from adaptive import start_adaptive
from gradient_descent import start_gradient
from libs import *

lib_x, lib_y = lib_calculate()
print("Library value :")
print("x =", lib_x, "\ny =", lib_y)

grad_x, grad_y = start_gradient(np.array([x0, y0]), 1)

print("\nGradient method :")
print("x =", grad_x, "\ny =", grad_y)
print("x error =", abs(grad_x - lib_x), "\ny error =", abs(grad_y - lib_y))

adap_x, adap_y = start_adaptive(np.array([x0, y0]))

print("\nAdaptive method :")
print("x =", adap_x, "\ny =", adap_y)
print("x error =", abs(adap_x - lib_x), "\ny error =", abs(adap_y - lib_y))

draw()
