import tensorflow as tf
import os


def get_class_array(db):
    classes = ['circle', 'ellipse', 'rectangle', 'square', 'triangle']
    classes_int = []

    k = 0

    dirs = os.listdir(db)
    for dir in dirs:
        files = os.listdir('%s/%s' % (db, dir))
        # circle, ellipses, rectangle, squares, triangles
        for i in range(len(files)):
            classes_int.append(k)
        # next type
        k = k + 1

    classes_int = tf.keras.utils.to_categorical(classes_int, num_classes=len(classes))

    return classes_int, classes
