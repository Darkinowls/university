
from manage_classes import get_class_array
from manage_source import get_edges_array
from first_mind import mind_model
import numpy as np


def ver1():
    edges_teach = get_edges_array('source/teach')

    np.savetxt('first_foto.txt', edges_teach[0], fmt='%1.d')

    # to 1D => size=40000
    edges_teach = edges_teach.reshape(-1, 200 * 200)

    model = mind_model()

    classes_teach_int, classes = get_class_array('source/teach')

    model.fit(edges_teach, classes_teach_int, epochs=40)

    edges_test = get_edges_array('source/test')

    # to 1D => size=40000
    edges_test = edges_test.reshape(-1, 200 * 200)

    prs_teach = model.predict(edges_teach)
    prs_test = model.predict(edges_test)

    np.set_printoptions(suppress=True)
    np.set_printoptions(precision=2)

    print(prs_teach)
    print('-' * 30)
    for i in range(3 * len(classes)):
        if i % 3 == 0: print(classes[i // 3], "відповідний індекс", i // 3)
        print(prs_test[i])
