
from scipy.optimize import linprog

def calculate():
    # 10x + 4y + 8z -> min
    # -10x - 4y - 8z -> -max
    c = [-10, -4, -8]

    # x + y + z <= 8000
    # x > 0, y > 0, z > 0
    # x + y <= 8000 * 0.7
    # - 2y  + z <= 0

    A = [[1, 1, 1], [1, 1, 0], [0, -2, 1]]
    b = [8000, 8000 * 0.7, 0]
    x_bounds = (0, None)
    y_bounds = (0, None)
    z_bounds = (0, None)
    res = linprog(c, A_ub=A, b_ub=b, bounds=[x_bounds, y_bounds, z_bounds], method='revised simplex')

    res.fun = -res.fun

    return res
