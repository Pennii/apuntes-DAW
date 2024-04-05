edad = int(input("Ingresa la edad del participante: "))
while edad < 0 or edad > 100:
    edad = int(input("EDAD INVALIDA, INGRESA OTRA VEZ: "))

if edad <= 5:
    categoria = "benjamin"
elif edad > 5 and edad <= 10:
    categoria = "alenin"
elif edad > 10 and edad <= 15:
    categoria = "juvenil"
elif edad > 15 and edad <= 20:
    categoria = "cadete"
elif edad > 20 and edad <= 40:
    categoria = "profesional"
else:
    categoria = "senior"

print(f"La categoria del deportista es: {categoria}")
