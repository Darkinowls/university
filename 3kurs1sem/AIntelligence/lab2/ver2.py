from manage_classes import get_class_array
from manage_source import get_edges_array
from second_mind import mind_model
import numpy as np

def ver2():
    edges_teach = get_edges_array('source/teach')

    np.savetxt('first_foto.txt', edges_teach[0], fmt='%1.d')

    # 4d => num_foto, width, height, num_channel
    edges_teach = edges_teach.reshape(edges_teach.shape[0], 200, 200, 1)

    classes_int_teach, classes = get_class_array('source/teach')

    model = mind_model()

    model.fit(edges_teach, classes_int_teach, epochs=40)

    edges_test = get_edges_array('source/test')
    edges_test = edges_test.reshape(edges_test.shape[0], 200, 200, 1)

    prs_teach = model.predict(edges_teach)
    prs_test = model.predict(edges_test)

    np.set_printoptions(suppress=True)
    np.set_printoptions(precision=2)

    print(prs_teach)
    print('-' * 30)
    for i in range(3 * len(classes)):
        if i % 3 == 0: print(classes[i // 3], "відповідний індекс", i // 3)
        print(prs_test[i])
