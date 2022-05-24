from lex_manager import analyse_lex, SYMBOL_TABLE, ID_TABLE, CONST_TABLE, read_file


print(analyse_lex(read_file()))

# Таблиці: розбору, ідентифікаторів та констант
print('-' * 30)
print('SYMBOL_TABLE:{0}'.format(SYMBOL_TABLE))
print('ID_TABLE:{0}'.format(ID_TABLE))
print('CONST_TABLE:{0}'.format(CONST_TABLE))
