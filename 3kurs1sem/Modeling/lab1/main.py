import numpy as np
from Eiler import eiler_method
from Runge_Kutt import *
from system_of_functions import *
from scipy.integrate import odeint

Eiler = eiler_method([x_der, y_der], 0, 0, 0, 0.1, 0, 1)

print("Метод Ейлера\n", np.matrix(Eiler))

Runge = Runge_Kutt([x_der, y_der], 0, 0, 0, 0.1, 0, 1)

print("Метод Рунге-Кута\n", np.matrix(Runge))

t = np.linspace(0, 1, 1000)
xs = [0, 0]
original = odeint(F, xs, t)

print("Original\n", np.matrix(original))

fig, (ax1, ax2) = plt.subplots(1, 2)

ax1.plot(original[:, 0], original[:, 1], 'g-', label="Original y(x)")
ax1.plot(Eiler[0], Eiler[1], 'r-', label="Eiler y(x)")
ax1.plot(Runge[0], Runge[1], 'b-', label="Runge y(x)")

ax2.plot(t, original[:, 0], 'g--', label="Original x(t)")
ax2.plot(t, original[:, 1], 'g-', label="Original y(t)")

EilerT = np.linspace(0, 1, len(Eiler[0]))

ax2.plot(EilerT, Eiler[0], 'r--', label="Eiler x(t)")
ax2.plot(EilerT, Eiler[1], 'r-', label="Eiler y(t)")

RungeT = np.linspace(0, 1, len(Runge[0]))
ax2.plot(RungeT, Runge[0], 'b--', label="Runge x(t)")
ax2.plot(RungeT, Runge[1], 'b-', label="Runge y(t)")

ax1.legend()
ax2.legend()
ax1.grid()
ax2.grid()
plt.show()

