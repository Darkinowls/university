from scipy import optimize
from random_method import *
import matplotlib.pyplot as plt
from bisection import bisection
from function import *

bib = optimize.minimize(MY_FUNC, MIN, method='SLSQP').x[0]  # Sequential Least Squares Programming
print("Бібліотечний метод :", bib)

bis = bisection(MIN, MAX, MY_FUNC, 0.01)
print("\nМетод поділу інтервалу навпіл :", bis )
print("Похибка :", abs(bis - bib))

ran = random(MIN, MAX, MY_FUNC, 100)
print("\nМетод випадкового пошуку :", ran)
print("Похибка :", abs(bis - ran))

fig, ax1 = plt.subplots(1)
originalX = np.linspace(MIN, MAX, 100)
originalY = [MY_FUNC(originalX[i]) for i in range(100)]
ax1.plot(originalX, originalY, 'g-', label="Original y(x)")
ax1.legend()
ax1.grid()
plt.show()
