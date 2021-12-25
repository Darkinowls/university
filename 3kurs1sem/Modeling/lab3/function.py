import numpy as np

G = 3
K = 2

x0 = (K * G + 2)
y0 = (G - 2)
error = 10 ** -6


def function(x, y):
    return x ** 2 + (y - G) ** 2 - 2 * K * G * x + K


def function_x_der(x):
    return 2 * x - 2 * K * G


def function_y_der(y):
    return 2 * y - 2 * G


def function_der(input):
    return np.array([function_x_der(input[0]), function_y_der(input[1])])
