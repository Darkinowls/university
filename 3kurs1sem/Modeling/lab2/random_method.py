import numpy as np


def random(a, b, func, num):
    x = np.linspace(a, b, num)
    y = [func(x[i]) for i in range(num)]
    return x[np.where(y == np.amin(y))][0]

