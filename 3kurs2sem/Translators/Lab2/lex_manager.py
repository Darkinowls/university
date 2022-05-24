from consts import ABC, TOKENS, STATES_TRANSITIONS, FINAL, TYPES

SYMBOL_TABLE = []
ID_TABLE = {}
CONST_TABLE = {}


def analyse_lex(source_code: str) -> tuple[bool, str]:
    state: int = 0
    lexeme: str = ''
    line_num: int = 1
    index = 0
    try:
        while index < len(source_code):
            char = source_code[index]
            index += 1
            char_class = get_char_class(char, state)
            state = get_next_state(state, char_class)
            if is_final(state):
                line_num, lexeme, index = process_lexeme(state, line_num, lexeme, char, index)
                state = 0
            elif state == 0:
                lexeme = ''
            else:
                lexeme += char
    except SystemExit as e:
        return False, \
               'Lexer: Аварійне завершення програми з кодом {0}'.format(e)
    return True, 'Lexer: Лексичний аналіз завершено успішно'


def read_file(file_path: str = 'test.base') -> str:
    with open(file_path, 'r') as file:
        return file.read()


def get_char_class(char: chr, state: int) -> str:
    if state == 5 and char == 'E':
        return char
    if char in '.':
        return "dot"
    if char in " \t":
        return "ws"
    if char == "\n":
        return "nl"
    if char in "+-=*/^();:<>,!":
        return char
    for k, v in ABC.items():
        if char in k:
            return v
    return 'символ не належить алфавіту'


def get_next_state(state: int, char_class: str) -> int:
    try:
        return STATES_TRANSITIONS[(state, char_class)]
    except KeyError:
        return STATES_TRANSITIONS[(state, 'other')]


def is_final(state: int) -> bool:
    return True if state in FINAL else False


def process_lexeme(state: int, line_num: int, lexeme: str, char: chr, index: int) -> tuple[int, str, int]:
    if state == 8:  # \n
        return line_num + 1, lexeme, index
    elif state in TYPES.keys() or state in (14, 15):
        token = get_token_or_type(state, lexeme)
        number = get_number_from_table(state, lexeme) if token not in ('keyword', 'compare_op') else ''
        print('{0:<3d} {1:<20s} {2:<10s} {3:>3s} '.format(line_num, lexeme, token, str(number)))
        SYMBOL_TABLE.append((line_num, lexeme, token, number))
        return line_num, '', index - 1
    elif state == 7:
        lexeme += char
        token = get_token_or_type(state, char)
        print('{0:<3d} {1:<20s} {2:<10s} '.format(line_num, lexeme, token))
        SYMBOL_TABLE.append((line_num, lexeme, token, ''))
        return line_num, '', index
    exit_with_fail(state, line_num, char)


def exit_with_fail(state: int, line_num: int, char: chr):
    if state == 101:
        print('Lexer: у рядку ', line_num, ' неочікуваний символ ' + char)
    elif state == 102:
        print('Lexer: у рядку ', line_num, ' неочікуваний символ ' + char + ' після експоненти E')
    exit(state)


def get_token_or_type(state: int, lexeme: str) -> str:
    for k, v in TOKENS.items():
        if lexeme in k:
            return v
    return TYPES[state]


def get_number_from_table(state: int, lexeme: str) -> int:
    number = 0
    if state == 2:
        number = ID_TABLE.get(lexeme)
        if number is None:
            number = len(ID_TABLE) + 1
            ID_TABLE[lexeme] = number
    if state in (6, 9):
        number = CONST_TABLE.get(lexeme)
        if number is None:
            number = len(CONST_TABLE) + 1
            CONST_TABLE[lexeme] = number
    return number
