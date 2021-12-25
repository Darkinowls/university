# import pandas as pd
# from movement import move, np
#
# pos = 25
#
# R = pd.read_excel('source.xlsx', sheet_name='R').set_index('R')
# Q = pd.read_excel('source.xlsx', sheet_name='Q_start').set_index('Q')
#
# for i in range(50):
#     Q = move(np.array(Q), np.array(R), -1, pos - 1)
#     print(Q)
#
# df = pd.DataFrame(np.array(Q))
# df.index += 1
# df.columns += 1
# df.to_excel("Q_table.xlsx")
