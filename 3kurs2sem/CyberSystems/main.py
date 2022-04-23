from database_manager import renew_database_table, WEATHER_TABLE
from dataframe_manager import locate_datetime_gaps, get_weather_api, TEMPERATURE, WIND_SPEED, WIND_DIRECTION_ID, \
    fill_gaps_by_pad
from dialog_manager import ask_fill_method, ask_do_use_pad
from file_manager import get_files_paths, read_excel_files

# df.to_excel("Q_table.xlsx")
# DIR_NAME = "і франківськ"
DIR_NAME = "киев+"


def main():
    paths = get_files_paths(DIR_NAME)
    excel_dataframes = read_excel_files(paths)
    weather_api = get_weather_api(excel_dataframes, paths)
    weather_marked = locate_datetime_gaps(weather_api)
    if weather_api is not weather_marked:
        weather_api = ask_fill_method(weather_marked, [TEMPERATURE, WIND_SPEED], [WIND_DIRECTION_ID])
    elif weather_api[WIND_DIRECTION_ID].isnull().values.any() and ask_do_use_pad():
        weather_api = fill_gaps_by_pad(weather_api, [WIND_DIRECTION_ID])
    renew_database_table(weather_api, WEATHER_TABLE)


main()
