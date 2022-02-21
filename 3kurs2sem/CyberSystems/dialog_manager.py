from pandas import DataFrame

from dataframe_manager import fill_gaps_by_interpolation, fill_gaps_by_pad

SKIP = 's'
THREE = '3'
TWO = '2'
ONE = '1'
SPLINE = 'spline'
POLYNOMIAL = 'polynomial'
LINEAR = 'linear'


def ask_interpolation_method() -> str | bool:
    print("There are gaps in records!"
          "\nChoose method to fill gaps:"
          "\nspline[1], polynomial[2], linear[3] or skip interpolation[s]")
    choice = input()
    if choice == ONE:
        return SPLINE
    if choice == TWO:
        return POLYNOMIAL
    if choice == THREE:
        return LINEAR
    if choice == SKIP:
        return False
    return ask_interpolation_method()


def ask_do_use_pad() -> bool:
    print("There are specific gaps in records!"
          "\nDo fill them using Pad?"
          "\nyes[1] or no[2]")
    choice = input()
    if choice == ONE:
        return True
    if choice == TWO:
        return False
    return ask_do_use_pad()


def ask_fill_method(dataframe: DataFrame, columns: list[str], columns_pad: list[str]):
    f_method = ask_interpolation_method()
    if f_method:
        dataframe = fill_gaps_by_interpolation(dataframe, f_method, columns)
    if ask_do_use_pad():
        dataframe = fill_gaps_by_pad(dataframe, columns_pad)
    print("The interpolation has been done successfully")
    return dataframe
