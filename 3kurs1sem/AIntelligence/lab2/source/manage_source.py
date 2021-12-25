import os
import numpy as np

from eyes import see


def get_edges_array(db):
    edges = []

    dirs = os.listdir(db)
    for dir in dirs:
        files = os.listdir('%s/%s' % (db, dir))
        for f in files:
            path = '%s/%s/%s' % (db, dir, f)
            edges.append(see(path))
            print(path)

    edges = np.array(edges)
    return edges
