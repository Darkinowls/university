import numpy as np

G = 0.8


def move(Q, R, prev_pos, pos):
    if prev_pos == pos: return Q
    next_pos = get_next_pos_index(Q, R, pos)
    Q[pos][next_pos] = R[pos][next_pos] + G * Q[next_pos][get_next_pos_index(Q, R, next_pos)]
    print(pos + 1, "->", next_pos + 1, Q[pos][next_pos])
    return move(Q, R, pos, next_pos)


def get_max_value(matrix, pas, pos):
    paths = np.where(matrix[pos] > pas)[0]
    if len(paths) == 0: return -1
    path_value = [matrix[pos][i] for i in paths]
    return np.amax(path_value)


def get_indexes_by_value(Q, R, pos):
    max_value_q = get_max_value(Q, 0, pos)
    if max_value_q != -1: return np.where(Q[pos] == max_value_q)
    max_value_r = get_max_value(R, -1, pos)
    return np.where(R[pos] == max_value_r)


def get_next_pos_index(Q, R, pos):
    max_indexes = get_indexes_by_value(Q, R, pos)
    return np.random.choice(max_indexes[0])


