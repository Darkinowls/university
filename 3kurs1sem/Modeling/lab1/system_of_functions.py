G = 3
K = 2


def x_der(xs):
    t = xs[0]
    x = xs[1]
    y = xs[2]
    return K * t + x - y + G


def y_der(xs):
    x = xs[1]
    y = xs[2]
    return -x + K * y


def F(xs, t):
    x = xs[0]
    y = xs[1]
    x_der_t = K * t + x - y + G
    y_der_t = -x + K * y
    return [x_der_t, y_der_t]
