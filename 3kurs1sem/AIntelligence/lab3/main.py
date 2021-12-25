from scipy import optimize
from GA import *
import matplotlib.pyplot as plt

print("Max binary x value =", MAX_VALUE, "\nMax resized x value =", resize(MAX_VALUE))
print("Min binary x value =", MIN_VALUE, "\nMin resized x value =", resize(MIN_VALUE))

print("\nSearching minimum of function ...")
x_min = start(True)
print("\nSearching maximum of function ...")
x_max = start(False)
print("\nMinimum of function =", x_min, "\nMaximum of function =", x_max)
bib = optimize.minimize(func16, 0.5).x[0]
print("Бібліотечний метод (мінімум) :", bib)
print("Максимум :", START)
x = np.linspace(START, END, 10000)
y = [func16(x[i]) for i in range(len(x))]
plt.plot(x, y)
plt.grid()
plt.show()
