TOKENS = {('program', 'var', 'end', 'end.', 'if', 'for', 'then', 'read', 'write', 'goto'): 'keyword',
          ('-', '+'): 'add_op',
          '=': 'assign_op',
          '.': 'dot',
          (' ', '\t'): 'ws',
          '\n': 'nl',
          ('*', '/'): 'mult_op',
          ('(', ')'): 'par_op',
          '^': 'pow_op'}

TYPES = {2: 'ident', 6: 'real', 9: 'int'}
ABC = {
    'abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ': 'Letter',
    "0123456789": 'Digit'
}

STATES_TRANSITIONS = {(0, 'Letter'): 1, (1, 'Letter'): 1, (1, 'Digit'): 1, (1, 'other'): 2,
                      (0, 'Digit'): 4, (4, 'Digit'): 4,  (4, 'other'): 9,
                      (4, 'dot'): 5, (5, 'Digit'): 5, (5, 'E'): 10, (10, 'Digit'): 5, (5, 'other'): 6,
                      (0, 'ws'): 0,
                      (0, 'nl'): 8,
                      (0, '+'): 7, (0, '-'): 7, (0, '*'): 7, (0, '/'): 7, (0, '('): 7,
                      (0, ')'): 7, (0, '='): 7, (0, '^'): 7,
                      (0, 'other'): 101
                      }

FINAL = {2, 6, 9, 7, 8, 101}
