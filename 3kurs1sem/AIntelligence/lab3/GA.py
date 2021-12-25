from random import randint
import numpy as np
from functions import *

<<<<<<< HEAD
POP_SIZE = 200
MUTATION_RATE = 0.8
CHERNOBYL_RATE = 3

=======

POP_SIZE = 40
MUTATION_RATE = 0.6
CHERNOBYL_RATE = 0
EPOCHS = 50
>>>>>>> master

def start(minimum: bool):
    global MINIMUM
    MINIMUM = minimum
    generation = [[randint(0, 1) for i in range(GENE_SIZE)] for i in range(POP_SIZE)]
    return lifetime(generation, 1)


def lifetime(generation, epoch):
<<<<<<< HEAD
    father, mother = selection(generation)
    father_value, mother_value = get_number(father), get_number(mother)
    print("Epoch #" + str(epoch), "\nfather =", father_value, "\nmother =", mother_value)
    if epoch == 50: return father_value
=======
    # gradfather
    father, mother = selection(generation)
    father_value, mother_value = get_number(father), get_number(mother)
    print("Epoch #" + str(epoch), "\nfather =", father_value, "\nmother =", mother_value)
    if epoch == EPOCHS: return father_value
>>>>>>> master
    new_generation = [crossover(father, mother) for i in range(POP_SIZE)]
    new_generation = [mutate(new_generation[i]) if i < POP_SIZE * MUTATION_RATE else new_generation[i] for i in
                      range(POP_SIZE)]
    return lifetime(new_generation, epoch + 1)


def crossover(father, mother):
    index = randint(0, GENE_SIZE)
    baby = father.copy()
    baby[index:] = mother[index:].copy()
    # print(index)
    # print(father)
    # print(mother)
    # print(baby)
    return baby


def mutate(baby):
    indexs = []
    indexs.append(randint(0, GENE_SIZE - 1))
    if CHERNOBYL_RATE != 0: [indexs.append(randint(0, GENE_SIZE - 1)) for i in range(CHERNOBYL_RATE)]
    return [(1 - baby[i] if indexs.__contains__(i) else baby[i]) for i in range(GENE_SIZE)]


def selection(generation):
    values = [func16(get_number(array)) for array in generation]
    if MINIMUM:
        fittest = np.sort(values)
    else:
        fittest = np.sort(values)[::-1]

<<<<<<< HEAD
    # parents = [fittest[i] for i in range(len(fittest)) if i == 0 or fittest[0] != fittest[i]]
    parents = fittest[:2]
=======
    parents = [fittest[i] for i in range(len(fittest)) if i == 0 or fittest[0] != fittest[i]]
    # parents = fittest[:2]
>>>>>>> master

    father_index = values.index(parents[0])
    mother_index = values.index(parents[1])
    return generation[father_index], generation[mother_index]
