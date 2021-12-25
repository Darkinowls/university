from keras.models import Sequential
from keras.layers import Convolution2D, MaxPooling2D, Dropout, Flatten, Dense, Reshape, LSTM, BatchNormalization, \
    Convolution1D

import os

os.environ['TF_CPP_MIN_LOG_LEVEL'] = '2'
classes = ['circle', 'ellipse', 'rectangle', 'square', 'triangle']


def mind_model():
    model = Sequential()
    model.add(Dense(1000, input_dim=200 * 200, activation='relu'))
    model.add(Dense(1000, activation='relu'))
    model.add(Dense(1000, activation='relu'))
    model.add(Dense(1000, activation='relu'))
    model.add(Dense(1000, activation='relu'))
    model.add(Dense(5, activation='softmax'))
    model.compile(loss="categorical_crossentropy", optimizer="adam", metrics=['categorical_accuracy'])
    # optimizer = 'adam' дуже дуже довго ,
    # optimizer = 'SGD' найпростіший,
    # optimizer='rmsprop'
    return model
