contiene = False
suma = 0
cant = 0
media = 0
while not contiene:
    num = int(input("ingresalo: "))
    contiene = num == 0
    if not contiene:
        suma += num
        cant += 1
   
if suma > 0:
    media = suma/cant
print(f"la suma de los numeros es: {suma}")
print(f"la media de los numeros es: {media}")