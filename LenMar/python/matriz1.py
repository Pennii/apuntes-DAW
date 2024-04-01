lista = list()
sietes = 0
for i in range(5):
    lista.append(int(input("Ingresa un numero ")))
    if lista[i] == 7:
        sietes += 1
print("tu lista es: ",lista)
print("cantidad de 7: ", sietes)