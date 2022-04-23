import os

import pandas as pd
from dotenv import load_dotenv
from pandas import DataFrame
from sqlalchemy import create_engine

from consts import ID

load_dotenv()
HOST = os.getenv('HOST')
PORT = int(os.getenv('PORT'))
USER = os.getenv('TEMP_USER')
PASSWORD = os.getenv('PASSWORD')
DATABASE = os.getenv('DATABASE')
WEATHER_TABLE = os.getenv('WEATHER_TABLE')
CHARSET = os.getenv('CHARSET')

ENGINE = create_engine("mysql+pymysql://{user}:{pw}@{host}/{db}"
                       .format(host=HOST, db=DATABASE, user=USER, pw=PASSWORD))


def save_database_table(dataframe: DataFrame, table: str, if_exists: str) -> int | None:
    return dataframe.to_sql(table, ENGINE, if_exists=if_exists, index_label=ID)


def get_dataframe_from_table(table: str):
    return pd.read_sql_table(table, ENGINE)


def database_table_empty(table: str) -> bool:
    return get_dataframe_from_table(table).empty
