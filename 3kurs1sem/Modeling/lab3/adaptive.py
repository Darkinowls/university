import random

from function import *

h = 1
tries = 20


def random_single_vector():
    e = np.array([random.random()-0.5, random.random()-0.5])
    return e / (np.sum(e ** 2) ** 0.5)


def start_adaptive(input: np):
    return iteration(input, h)


def iteration(input, h):
    if h < error: return input
    for i in range(tries):
        attempt = np.copy(input)
        attempt = attempt + h * random_single_vector()
        if function(attempt[0], attempt[1]) <= function(input[0], input[1]):
            return iteration(attempt, h * 2)

    return iteration(input, h / 2)
