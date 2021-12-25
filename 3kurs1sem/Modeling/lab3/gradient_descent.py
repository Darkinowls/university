from function import *
import numpy as np


def start_gradient(input: np, h):
    return iteration(input, 0, h)


def iteration(input, prev, h):
    grad = function_der(input)
    lenth = np.sum(grad ** 2) ** 0.5
    # if lenth == 0: return input

    cur = function(input[0], input[1])
    # print("current_z=" + str(cur) + "; previous_z=" + str(prev) + "; h=" + str(h))

    if abs(cur - prev) < error: return input
    if cur > prev: h /= 2
    return iteration(input - h * grad / lenth, cur, h)
