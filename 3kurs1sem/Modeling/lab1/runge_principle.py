import matplotlib.pyplot as plt

ERROR = 0.1


def runge_principle(ys_old, ys_new, iteration, functions, t, x, y, h, start, end):
    print("H:", h)
    ys_refined = refine_array_over2(len(ys_old[0]), len(ys_old), ys_new)

    differences = calculate_distance_of_arrays(ys_old, ys_refined)

    error = calculate_error_by_array(differences)

    if error <= ERROR: return ys_new
    return runge_principle(ys_new, iteration(functions, t, x, y, h / 2, start, end), iteration, functions, t, x, y,
                           h / 2, start,
                           end)


def calculate_distance_of_arrays(ys_old, ys_new):
    distances = []

    for i in range(len(ys_old[0])):
        sum = 0
        for j in range(len(ys_old)):
            sum += (ys_old[j][i] - ys_new[j][i]) ** 2
        distances.append(sum ** 0.5)

    return distances


def refine_array_over2(cols, rows, ys_new):
        ys_refined = [[], []]

        for i in range(rows):
            for j in range(cols):
                ys_refined[i].append(ys_new[i][j * 2])

        return ys_refined

def calculate_error_by_array(arr):
    error = 0
    for i in range(len(arr)):
        error += arr[i] ** 2

    return (error / (len(arr) - 1)) ** 0.5
