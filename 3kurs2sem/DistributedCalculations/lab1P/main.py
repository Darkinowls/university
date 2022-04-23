import functools
import time
from concurrent.futures.process import ProcessPoolExecutor
from concurrent.futures.thread import ThreadPoolExecutor
from functools import reduce

from count_manager import count_words_in_files, merge_counters, count_words_in_file_jit, count_words_in_file
from file_manager import get_paths, read_files


def do_first_task():
    print(count_words_in_files(read_files(get_paths())))


def do_second_task():
    files = read_files(get_paths())
    counters = map(count_words_in_file, files)
    print(reduce(merge_counters, list(counters)))


def do_third_task():
    files = read_files(get_paths())
    with ProcessPoolExecutor(4) as executor:
        print(reduce(merge_counters, executor.map(count_words_in_file, files)))


def do_third_and_half_task():
    files = read_files(get_paths())
    with ThreadPoolExecutor(max_workers=4) as executor:
        print(reduce(merge_counters, executor.map(count_words_in_file_jit, files)))


def calculate_process_time(func: functools):
    start = time.time()
    func()
    print(time.time() - start)


if __name__ == '__main__':
    # calculate_process_time(do_first_task)
    # calculate_process_time(do_second_task)
    # calculate_process_time(do_third_task) # multiprocessing (4 cores)
    calculate_process_time(do_third_and_half_task)  # multithreading by jit (nogil=True)
