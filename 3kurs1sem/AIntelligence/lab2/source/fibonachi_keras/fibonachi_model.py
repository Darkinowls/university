from tensorflow import keras
from keras.models import Sequential
from keras import optimizers
from keras.layers import Convolution2D, MaxPooling2D, Dropout, Flatten, Dense, Reshape, LSTM, BatchNormalization

import os

os.environ['TF_CPP_MIN_LOG_LEVEL'] = '2'


def mind_model():
    model = Sequential()
    model.add(Dense(3, input_dim=3, activation='relu'))
    model.add(Dense(3, activation='relu'))
    model.add(Dense(1))
    # compile the keras model
    model.compile(loss='mean_absolute_error', optimizer='adam')
    return model
