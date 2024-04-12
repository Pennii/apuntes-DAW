print("CALCULAR PERIMETRO Y AREA DE UN RECTANGULO:")

base = float(input("INGRESA LA BASE: "))
altura = float(input("INGRESA LA ALTURA: "))

perimetro = base * 2 + altura * 2
area = base * altura

print(f"EL PERIMETRO ES: {perimetro}")
print(f"EL AREA ES: {area}")

print("SUMA, RESTA, DIVISION Y MULTIPLICACION DE AMBOS NUMEROS: ")
print(base + altura, " ", base - altura, " ", base / altura, " ", base * altura)