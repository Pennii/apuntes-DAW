v1 = int(input("Ingresa los km/h del vehiculo 1: "))
v2 = int(input("Ingresa los km/h del vehiculo 2: "))
d = int(input("Ingresa la distancia en kilometros entre ambos vehiculos: "))

if v1 < v2:
    encuentro = d / (v1 + v2)
    print(f"Los vehiculos se encontraran en {encuentro * 60} minutos")
else:
    print("Los vehiculos nunca se encontraran")