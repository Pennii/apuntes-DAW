lista = list()
sietes = 0
for i in range(5):
    lista.append(int(input("Ingresa un numero ")))
print("tu lista es: ",lista)
for i in range(5):
    if lista[i] == 7:
        sietes += 1
print("cantidad de 7: ", sietes)