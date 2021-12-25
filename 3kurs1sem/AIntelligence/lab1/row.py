import math
import random

import numpy as np

NUM_NEURONS = 5
NUM_INPUT = 3
V = 0.01

WAGES = [random.uniform(-0.1, 0.1)] * (NUM_NEURONS * NUM_INPUT + NUM_NEURONS)


def sigmoid_function(x):
    return (1 / (1 + math.exp(-x))) * 10


def calculate_sum(input, start, end):
    return np.inner(input, WAGES[start:end])


def sigmoid_function_der(x):
    return math.exp(x) / ((1 + math.exp(x)) ** 2)


def forward(input: []):
    Ss = []
    Ys = []

    for i in range(NUM_NEURONS):
        Ss.append(calculate_sum(input, len(input) * i, len(input) * i + len(input)))
        Ys.append(sigmoid_function(Ss[i]))

    Ss.append(calculate_sum(Ys, NUM_NEURONS * len(input), NUM_NEURONS * len(input) + NUM_NEURONS))
    return sigmoid_function(Ss[-1])


def teach_by_row(input: [], output: float):
    Ss = []
    Ys = []

    # calculate hidden neurons

    for i in range(NUM_NEURONS):
        Ss.append(calculate_sum(input, len(input) * i, len(input) * i + len(input)))
        Ys.append(sigmoid_function(Ss[i]))

    # calculate output

    Ss.append(calculate_sum(Ys, NUM_NEURONS * len(input), NUM_NEURONS * len(input) + NUM_NEURONS))
    Ys.append(sigmoid_function(Ss[-1]))

    # calculate error

    error = Ys[-1] - output
    quad_error = error ** 2

    neuron_error = []

    for i in range(NUM_NEURONS):
        neuron_error.append(error * WAGES[NUM_NEURONS * len(input) + i])

    for i in range(NUM_INPUT * NUM_NEURONS):
        WAGES[i] -= sigmoid_function_der(Ss[i // len(input)]) * neuron_error[i // len(input)] * input[
            i % len(input)] * V

    for i in range(NUM_NEURONS):
        WAGES[NUM_NEURONS * NUM_INPUT + i] -= sigmoid_function_der(Ss[-1]) * error * Ys[i] * V

    return quad_error


def teach_by_dataset(dataset):
    errors = []
    for i in range(len(dataset)):
        errors.append(teach_by_row(dataset[i][0:-1], dataset[i][-1]))

    return np.mean(errors)


def teach_predict_self(data):
    old_quad_error = 0
    for i in range(100):
        new_quad_error = teach_by_row(data[0:-1], data[-1])
        predicted = forward(data[0:-1])
        if abs(new_quad_error - old_quad_error) < 0.1 ** 20:
            print("Predicted in i :", i)
            print("Predicted : ", predicted)
            print("Actual : ", data[-1],"\n")
            return
        old_quad_error = new_quad_error


def teach(data):
    old_error = 10
    for i in range(100):
        new_error = teach_by_dataset(data)
        if old_error < new_error:
            raise Exception("Увага! Нейронка розбігається, поставте меншу швидкість навчання. V =", V)
        if abs(old_error - new_error) < 0.1 ** 5:
            print("Середня квадратична похибка :", new_error)
            print("Завершення циклу через допустиму квадратичну похибку")
            return True
        old_error = new_error


def forward_set(set):
    predicted = []
    for i in range(len(set)):
        predicted.append(forward(set[i]))
    return predicted
