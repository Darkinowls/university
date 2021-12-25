import numpy as np
import matplotlib.pyplot as plt
from runge_principle import runge_principle


def Runge_Kutt(functions, t, x, y, h, start, end):
    ys = iteration(functions, t, x, y, h, start, end)
    return runge_principle(ys, iteration(functions, t, x, y, h / 2, start, end), iteration, functions, t, x, y, h / 2,
                           start, end)


def iteration(functions, t, x, y, h, start, end):
    xs = [t, x, y]
    ys = [[], []]

    times = (end - start) / h

    for l in range(int(times) + 1):

        ks = calculate_Ks(functions, xs, h)

        for i in range(1, len(functions) + 1):
            ys[i - 1].append(xs[i])
            xs[i] = xs[i] + (ks[0][i - 1] + 2 * ks[1][i - 1] + 2 * ks[2][i - 1] + ks[3][i - 1]) / 6

        xs[0] += h

    return ys


def calculate_Ks(functions, xs, h):
    ks = [[], [], [], []]

    for i in range(len(functions)):
        ks[0].append(h * functions[i](xs))


    for i in range(len(functions)):
        inner = [xs[0] + h / 2, xs[1] + ks[0][0] / 2, xs[2] + ks[0][1] / 2]
        ks[1].append(h * functions[i](inner))

    for i in range(len(functions)):
        inner = [xs[0] + h / 2, xs[1] + ks[1][0] / 2, xs[2] + ks[1][1] / 2]
        ks[2].append(h * functions[i](inner))

    for i in range(len(functions)):
        inner = [xs[0] + h, xs[1] + ks[2][0], xs[2] + ks[2][1]]
        ks[3].append(h * functions[i](inner))


    return ks
