edad = int(input("Ingresa la edad: "))
nota = float(input("Ingresa la nota: "))
sexo = input("Ingresa el sexo: ")
cond = edad >= 18 and nota >= 5
if cond and (sexo == "F" or sexo == "f"):
    print("ACEPTADA")
elif cond and (sexo == "M" or sexo == "m"):
    print("POSIBLE")
else: 
    print("NO ACEPTADA")