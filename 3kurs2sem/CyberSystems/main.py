from pandas import DataFrame

from database_manager import renew_database_table, WEATHER_TABLE
from dataframe_manager import locate_datetime_gaps, get_weather_api, TEMPERATURE, fill_gaps_by_interpolation, \
    WIND_SPEED, WIND_DIRECTION_ID
from file_manager import get_files_paths, read_excel_files

E = 'e'
S3 = '3'
S2 = '2'
S1 = '1'
S = '1'
SPLINE = 'spline'
DIR_NAME = "киев+"
POLYNOMIAL = 'polynomial'
LINEAR = 'linear'


# df.to_excel("Q_table.xlsx")

def ask_fill_method(dataframe: DataFrame, columns: list[str], columns_pad: list[str]):
    print("\nThere are gaps in records!"
          "\nChoose method to fill gaps:"
          "\nspline[1], polynomial[2], linear[3] or exit the program[e]")
    choice = input()
    f_method = None
    if choice == S1:
        f_method = SPLINE
    elif choice == S2:
        f_method = POLYNOMIAL
    elif choice == S3:
        f_method = LINEAR
    elif choice == E:
        print("Exiting ...")
        quit()
    else:
        ask_fill_method(dataframe, columns, columns_pad)
    dataframe = fill_gaps_by_interpolation(dataframe, f_method, columns, columns_pad)
    print("The Filling has been done successfully")
    return dataframe


def main():
    paths = get_files_paths(DIR_NAME)
    excel_dataframes = read_excel_files(paths)
    weather_api = get_weather_api(excel_dataframes, paths)
    renew_database_table(weather_api, WEATHER_TABLE)
    weather_marked = locate_datetime_gaps(weather_api)
    if weather_api is not weather_marked:
        weather_api = ask_fill_method(weather_marked, [TEMPERATURE, WIND_SPEED], [WIND_DIRECTION_ID])
    renew_database_table(weather_api, WEATHER_TABLE)


main()
