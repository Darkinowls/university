import numpy as np

from lab1_keras.lab1_model import mind_model
from source.eyes import see


def number_sequence():
    row16 = [0.58, 3.38, 0.91, 5.8,
             0.91, 5.01, 1.17, 4.67,
             0.6, 4.81, 0.53, 4.75,
             1.01, 5.04, 1.07]


    array16 = []
    array16_in = []
    for i in range(len(row16) - 3):
        array16.append(row16[i:i + 4])
        array16_in.append(row16[i:i + 3])

    model = mind_model()

    array16 = np.array(array16)
    array16_in = np.array(array16_in)

    print(array16_in[:-2])
    print(array16[:-2, -1])

    # SCALING AND NORMALIZATION!

    model.fit(array16_in[:-2], array16[:-2, -1], epochs=3500)

    predictions = model.predict(array16_in)

    delta = []

    for i in range(len(predictions)):
        if len(predictions) - 2 == i: print("-----Predict-----")
        delta.append(abs(array16[i][-1] - predictions[i]))
        print(array16[i][-1], predictions[i])

    print("Абсолютна похибка для усіх значень -", np.mean(delta))
