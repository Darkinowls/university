import pandas as pd
from pandas import DataFrame
from sqlalchemy import create_engine

from app.consts import ID, HOST, DATABASE, USER, PASSWORD

ENGINE = create_engine("mysql+pymysql://{user}:{pw}@{host}/{db}"
                       .format(host=HOST, db=DATABASE, user=USER, pw=PASSWORD))


def save_database_table(dataframe: DataFrame, table: str, if_exists: str) -> int | None:
    return dataframe.to_sql(table, ENGINE, if_exists=if_exists, index_label=ID)


def get_dataframe_from_table(table: str):
    return pd.read_sql_table(table, ENGINE)


def database_table_empty(table: str) -> bool:
    return get_dataframe_from_table(table).empty
