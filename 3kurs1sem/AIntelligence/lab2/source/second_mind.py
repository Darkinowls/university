
from keras.models import Sequential
from keras.layers import Convolution2D, MaxPooling2D, Dropout, Flatten, Dense, Reshape, LSTM, BatchNormalization, \
    Convolution1D
import os

os.environ['TF_CPP_MIN_LOG_LEVEL'] = '2'
classes = ['circle', 'ellipse', 'rectangle', 'square', 'triangle']

def mind_model():
    model = Sequential()

    model.add(Convolution2D(32, (3, 3), input_shape=(200, 200, 1), activation="relu"))
    model.add(MaxPooling2D(pool_size=(2, 2)))

    model.add(Convolution2D(64, (3, 3), activation="relu"))
    model.add(MaxPooling2D(pool_size=(2, 2)))

    model.add(Convolution2D(64, (3, 3), activation="relu"))
    model.add(MaxPooling2D(pool_size=(3, 3)))

    model.add(Dropout(0.25))  # random 1/4 of neurons are ignored each epoch
    model.add(Flatten())  # to 1d

    model.add(Dense(256, activation="relu"))
    model.add(Dense(256, activation="relu"))
    model.add(Dense(256, activation="relu"))
    model.add(Dense(256, activation="relu"))
    model.add(Dense(256, activation="relu"))

    model.add(Dense(5, activation="softmax"))
    model.compile(loss='categorical_crossentropy',
                  optimizer='adam',
                  metrics=['categorical_accuracy'])

    # optimizer = 'adam',
    # optimizer = 'adamGrad',
    # optimizer = 'SGD',
    # optimizer = 'adadelta'
    return model
