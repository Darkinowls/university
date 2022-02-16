import os

from dotenv import load_dotenv
from pandas import DataFrame
from sqlalchemy import create_engine

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

ID = 'id'


def renew_database_table(dataframe: DataFrame, table: str):
    with ENGINE.begin() as connection:
        dataframe.to_sql(con=connection, name=table, if_exists='replace', index_label=ID)
