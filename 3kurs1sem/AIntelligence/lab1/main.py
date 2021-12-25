from logicals import test_logical
from row import *

# test_logical()

row16 = [0.58, 3.38, 0.91, 5.8,
         0.91, 5.01, 1.17, 4.67,
         0.6, 4.81, 0.53, 4.75,
         1.01, 5.04, 1.07]

array16 = []
array16_in = []
for i in range(len(row16) - NUM_INPUT):
    array16.append(row16[i:i + 4])
    array16_in.append(row16[i:i + 3])

print(np.matrix(array16))

for i in range(len(array16)):
    teach_predict_self(array16[i])

print("\n")

for i in range(100):
    print("i : ", i * 100)
    stop = teach(array16[0:-2])
    predicted = forward_set(array16_in)
    delta = []
    for i in range(len(array16_in)):
        delta.append(abs(predicted[i] - array16[i][-1]))
        print("Expected :", array16[i][-1], ", predicted :", predicted[i], ", delta :", delta[i])
    print("Середня арифметична похидка ", np.mean(delta), "\n")
    if stop: break


