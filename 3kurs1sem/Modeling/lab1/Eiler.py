import numpy as np

from runge_principle import runge_principle
import matplotlib.pyplot as plt


def eiler_method(functions, t, x, y, h, start, end):
    ys = iteration(functions, t, x, y, h, start, end)
    return runge_principle(ys, iteration(functions, t, x, y, h / 2, start, end), iteration, functions, t, x, y, h / 2,
                           start, end)


def iteration(functions, t, x, y, h, start, end):
    xs = [t, x, y]
    ys = [[], []]
    times = (end - start) / h
    for l in range(int(times) + 1):

        for i in range(1, len(functions) + 1):
            ys[i - 1].append(xs[i])
            xs[i] = xs[i] + h * functions[i - 1](xs)


        xs[0] += h

    return ys
