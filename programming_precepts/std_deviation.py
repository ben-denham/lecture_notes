from math import pow, sqrt

def std_deviation(data, population=False):
    sum = 0
    for datum in data:
        sum += datum

    mean = sum / len(data)

    variance = 0
    for datum in data:
        variance += pow(datum - mean, 2)

    divisor = len(data)
    if not population:
        divisor -= 1

    return sqrt(variance / divisor)

def z_score(x, mean, std_dev):
    return (x - mean) / std_dev
