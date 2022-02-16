import pandas as pd

wind_directions_dictionary = {
    "Западный": 1,
    "Северный": 2,
    "Южный": 3,
    "Восточный": 4,
    "С-З": 5,
    "С-В": 6,
    "Ю-В": 7,
    "Ю-З": 8,
    "Переменный": 9,
}


def parse_wind_direction(wind_direction: str) -> int | None:
    if pd.isna(wind_direction):
        return None
    return wind_directions_dictionary[wind_direction]
