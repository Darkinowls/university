def bisection(a, b, func, e, i=1):
    # print(i)

    xc = (a + b) / 2
    L = b - a

    x1 = a + L / 4
    x2 = b - L / 4

    fc = func(xc)
    f1 = func(x1)
    f2 = func(x2)

    if f1 < fc:
        b = xc
        xc = x1
    elif f2 < fc:
        a = xc
        xc = x2
    else:
        a = x1
        b = x2

    if abs(b - a) < e: return xc

    return bisection(a, b, func, e, i + 1)
