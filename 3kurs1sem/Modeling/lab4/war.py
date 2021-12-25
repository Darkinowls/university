import numpy as np
from scipy.optimize import linprog
import pandas as pd


def get_matrix():
    return np.array(pd.read_excel('Opt1.xlsx', sheet_name='matrix').set_index('W'))


def calculate_A():
    array = get_matrix()

    # x1 + x2 + x3 + x4 + x5 - u -> min
    # p1 = x1 / u
    # sum(x) = 1
    # x1 = p1 * u
    c = [1, 1, 1, 1, 1, -1]

    # aijx1 + aijx2 + aijx3 + aijx4 + aijx5  - u <= 0

    # -aijx1 - aijx2 - aijx3 - aijx4 - aijx5  + u >= 0

    A_u = [[-array[i][j] if i < 5 else 1 for i in range(6)] for j in range(5)]

    b_u = [0 for i in range(5)]

    A_e = [[1, 1, 1, 1, 1, 0]]

    b_e = [1]

    x_c_bounds = (0, None)

    res = linprog(c, A_ub=A_u, b_ub=b_u, A_eq=A_e, b_eq=b_e, bounds=[x_c_bounds for i in range(6)],
                  method='revised simplex')

    return res


def calculate_B():
    array = get_matrix()

    # x1 + x2 + x3 + x4 + x5 - u -> min
    # - x1 - x2 - x3 - x4 - x5 + u -> -max
    # p1 = x1 / u
    # sum(x) = 1
    # x1 = p1 * u
    c = [-1, -1, -1, -1, -1, 1]

    # aijx1 + aijx2 + aijx3 + aijx4 + aijx5  - u <= 0
    # -aijx1 - aijx2 - aijx3 - aijx4 - aijx5  + u >= 0

    A_u = [[array[j][i] if i < 5 else -1 for i in range(6)] for j in range(5)]

    b_u = [0 for i in range(5)]

    A_e = [[1, 1, 1, 1, 1, 0]]

    b_e = [1]

    x_c_bounds = (0, None)

    res = linprog(c, A_ub=A_u, b_ub=b_u, A_eq=A_e, b_eq=b_e, bounds=[x_c_bounds for i in range(6)],
                  method='revised simplex')

    return res