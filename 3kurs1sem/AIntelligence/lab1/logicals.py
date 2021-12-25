import numpy as np

def logical_activator(S, T):
    return 0 if S < T else 1


def logical_function(input: [int, int], wages: [float, float], type: float):
    return logical_activator(np.inner(input, wages), type)


def logical_and(input: [int, int], wages=[1, 1]):
    return logical_function(input, wages, 1.5)


def logical_or(input: [int, int], wages=[1, 1]):
    return logical_function(input, wages, 0.5)


def logical_not(input: int, wages=-1.5):
    return logical_function(input, wages, -1)


def logical_xor(input: [int, int]):
    S1 = logical_or(input, [1, -1])
    S2 = logical_or(input, [-1, 1])

    return logical_or([S1, S2], [1, 1])


def test_logical():
    print("Logical and :")
    print(logical_and([1, 1]))
    print(logical_and([1, 0], [1, 1]))
    print(logical_and([1, 1], [1, -1]), "\n")

    print("Logical or :")
    print(logical_or([1, 0]))
    print(logical_or([0, 0], [1, 1]))
    print(logical_or([1, 0], [0, 1]), "\n")

    print("Logical not :")
    print(logical_not(0))
    print(logical_not(0, -1.5))
    print(logical_not(1, -1.5), "\n")

    print("Logical xor :")
    print(logical_xor([1, 1]))
    print(logical_xor([1, 0]))
    print(logical_xor([0, 0]), "\n")
