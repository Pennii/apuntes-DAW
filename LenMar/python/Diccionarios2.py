cadena = input("ingresa la cadena: ")
mapa = {}

for i in range(len(cadena)):
    if mapa.get(cadena[i]) is None:
        mapa.setdefault(cadena[i], 0)
    mapa[cadena[i]] += 1
    
print(mapa)