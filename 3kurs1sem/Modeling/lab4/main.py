import firma
import war

# res_f = firma.calculate()
# print( "Оптимізація інвестицй фірми : \n", res_f)

res_a = war.calculate_A()
print( "\nЗмішана стратегія першого гравця\n", res_a)

res_b = war.calculate_B()
print("\nЗмішана стратегія другого гравця\n",res_b)