import datetime
import warnings
from datetime import timedelta, datetime

import numpy as np
import pandas as pd
from pandas import DataFrame

from file_manager import get_date_from_path
from wind_direction_parser import parse_wind_direction

PAD = 'pad'

TIME_GAP = '30T'
ID = 'id'
EXCEL_FF = 'FF'
WIND_SPEED = 'wind_speed'
WIND_DIRECTION_ID = 'wind_direction_id'
TEMPERATURE = 'temperature'
T = 'T'
S = 'T'
UTC = 'UTC'
DATETIME = 'datetime'
EXCEL_WIND_DIRECTION = 'dd'
EXCEL_DAY = 'Число месяца'


def locate_datetime_gaps(dataframe: DataFrame) -> DataFrame:

    for i in range(len(dataframe[DATETIME]) - 1):
        if dataframe[DATETIME][i + 2] - dataframe[DATETIME][i + 1] != timedelta(days=0, minutes=30):
            print(dataframe[DATETIME][i + 2], dataframe[DATETIME][i + 1])
            dataframe, num_rows = insert_into_dataframe_datetime_rows(dataframe, i, TIME_GAP)
            i += num_rows

    return dataframe


def insert_into_dataframe_datetime_rows(dataframe: DataFrame, row: int, time_gap: str) -> tuple[DataFrame, int]:
    date_times = pd.date_range(start=dataframe[DATETIME][row + 1], end=dataframe[DATETIME][row + 2], freq=time_gap,
                               inclusive='neither')
    columns = dataframe.columns
    for i in range(len(date_times)):
        dataframe = pd.DataFrame(
            np.insert(dataframe.values, row + 1 + i, values=[date_times[i], np.nan, np.nan, np.nan], axis=0))
    dataframe.columns = columns
    dataframe.index += 1
    return dataframe, len(date_times)


def get_weather_api(dataframes: list[DataFrame], paths: list[str]) -> DataFrame:
    weathers_api = []
    for i in range(len(dataframes)):
        weathers_api.append(
            create_weather_dataframe(dataframes[i], get_date_from_path(paths[i], 2), get_date_from_path(paths[i], 1))
        )
    return merge_sort_dataframe_list(weathers_api, DATETIME)


def create_weather_dataframe(dataframe: DataFrame, month: int, year: int) -> DataFrame:
    rows = []
    for i in range(len(dataframe.index)):
        try:
            rows.append([
                datetime.combine(datetime(year, month, dataframe.at[i, EXCEL_DAY]), dataframe.at[i, UTC]),
                dataframe.at[i, T],
                parse_wind_direction(dataframe.at[i, EXCEL_WIND_DIRECTION]),
                dataframe.at[i, EXCEL_FF]
            ])
        except ValueError as warning:
            warnings.warn(warning.args[0])

    database_dataframe = pd.DataFrame(rows, columns=[DATETIME, TEMPERATURE, WIND_DIRECTION_ID, WIND_SPEED])
    return database_dataframe


def merge_sort_dataframe_list(dataframes: list[DataFrame], sort_by: str):
    dataframe = pd.concat(dataframes, ignore_index=True)
    dataframe = dataframe.sort_values(by=sort_by)
    dataframe = dataframe.reset_index(drop=True)
    dataframe.index += 1
    return dataframe


def fill_gaps_by_interpolation(dataframe: DataFrame, f_method: str, columns: list[str], pad_columns: list[str]):
    for column in columns:
        dataframe[column] = dataframe[column].astype(float).interpolate(method=f_method, order=3).round(0).astype(int)
    for pad_column in pad_columns:
        dataframe[pad_column] = dataframe[pad_column].astype(float).interpolate(method=PAD).round(0).astype(int)
    return dataframe


