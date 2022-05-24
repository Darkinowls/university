import os

PATH = "E:/university/3kurs2sem/DistributedCalculations/lab1P/docs"


def get_paths(path: str = PATH) -> list[str]:
    return [path + '/' + file for file in os.listdir(path)]


def read_file(path: str) -> str:
    with open(path, 'rt') as file:
        return file.read()


def read_files(paths: list[str]) -> list[str]:
    return [read_file(path) for path in paths]
