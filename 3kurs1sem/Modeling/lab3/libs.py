from matplotlib import pyplot as plt
from scipy import optimize

from function import *


def lib_calculate():
    optimization = optimize.minimize(function, x0, args=(x0,))
    best_x = optimization.x[0]
    optimization = optimize.minimize(lambda x, y: function(y, x), y0, args=(y0,))
    best_y = optimization.x[0]
    return best_x, best_y


def draw():
    y = x = np.linspace(-15, 15, 1000)
    x, y = np.meshgrid(x, y)
    z = function(x, y)
    ax = plt.axes(projection='3d')
    ax.contour3D(x, y, z, 100)
    ax.set_xlabel('x')
    ax.set_ylabel('y')
    ax.set_zlabel('z')
    plt.show()
