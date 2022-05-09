from consts import ABC, TOKENS, STATES_TRANSITIONS, FINAL, TYPES

SYMBOL_TABLE = []
ID_TABLE = []
CONST_TABLE = []
LINE_NUM = 1


def analyse_lex(source_code: str) -> tuple[bool, str]:
    state: int = 0
    lexeme: str = ''
    try:
        for char in source_code:
            char_class = get_char_class(char)  # до якого класу належить
            state = get_next_state(state, char_class)  # обчислити наступний стан
            if is_final(state):  # якщо стан заключний
                process_semantic(state, _, lexeme, char)
                state = 0
            elif state == 0:
                lexeme = ''  # якщо стан НЕ заключний, а стартовий - нова лексема
            else:
                lexeme += char  # якщо стан НЕ закл. і не стартовий - додати символ до лексеми
    except SystemExit as e:
        return False, \
               'Lexer: Аварійне завершення програми з кодом {0}'.format(e)  # Повідомити про факт виявлення помилки
    return True, 'Lexer: Лексичний аналіз завершено успішно'


def read_file(file_path: str = 'test.base') -> str:
    with open(file_path, 'r') as file:
        return file.read()


def get_char_class(char: chr) -> str:
    for k, v in ABC.items():
        if char in k:
            return v
    if char in '.':
        return "dot"
    if char in " \t":
        return "ws"
    if char in "\n":
        return "nl"
    if char in "+-=*/^()":
        return char
    return 'символ не належить алфавіту'


def get_next_state(state: int, char_class: str) -> int:
    try:
        return STATES_TRANSITIONS[(state, char_class)]
    except KeyError:
        return STATES_TRANSITIONS[(state, 'other')]


def is_final(state: int) -> bool:
    return True if state in FINAL else False


def process_semantic(state: int, line_num, lexeme: str, char: chr) -> tuple[int, str]:
    if state == 8:  # \n
        return line_num + 1, lexeme
    elif state in TYPES.keys():  # keyword, ident, real, int
        token = get_token_or_type(state, lexeme)
        if token == 'keyword':
            print('{0:<3d} {1:<10s} {2:<10s} '.format(line_num, lexeme, token))
            SYMBOL_TABLE.append((line_num, lexeme, token, ''))
        else:
            index = indexIdConst(state, lexeme)
            print('{0:<3d} {1:<10s} {2:<10s} {3:<2d} '.format(line_num, lexeme, token, index))
            SYMBOL_TABLE.append((line_num, lexeme, token, index))
        return line_num, ''
    elif state == 7:
        lexeme += char
        token = get_token_or_type(state, lexeme)
        print('{0:<3d} {1:<10s} {2:<10s} '.format(line_num, lexeme, token))
        SYMBOL_TABLE.append((line_num, lexeme, token, ''))
        return line_num, ''
    else:  # ERROR
        print('Lexer: у рядку ', line_num, ' неочікуваний символ ' + char)
        exit(101)


def get_token_or_type(state: int, lexeme: str) -> str:
    try:
        return TOKENS[lexeme]  # try to simplify
    except KeyError:
        return TYPES[state]


def indexIdConst(state, lexeme):
    indx = 0
    if state == 2:
        indx = tableOfId.get(lexeme)
        #		token=getToken(state,lexeme)
        if indx is None:
            indx = len(tableOfId) + 1
            tableOfId[lexeme] = indx
    if state in (6, 9):
        indx = tableOfConst.get(lexeme)
        if indx is None:
            indx = len(tableOfConst) + 1
            tableOfConst[lexeme] = indx
    return indx
