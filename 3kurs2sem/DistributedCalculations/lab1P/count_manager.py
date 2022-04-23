from collections import Counter

from numba import jit


def count_words_in_files(files: list[str]) -> Counter:
    counter: Counter = Counter()
    for file in files:
        counter += Counter(file.splitlines())
    return counter


def merge_counters(counter1, counter2):
    return Counter(counter1) + Counter(counter2)


@jit(nogil=True)
def count_words_in_file_jit(file: str):
    counter = {}
    lines: list[str] = file.splitlines()
    for line in lines:
        if line in counter:
            counter[line] += 1
        else:
            counter[line] = 1
    return counter


def count_words_in_file(file: str):
    counter = Counter()
    lines: list[str] = file.splitlines()
    for line in lines:
        if line in counter:
            counter[line] += 1
        else:
            counter[line] = 1
    return counter
