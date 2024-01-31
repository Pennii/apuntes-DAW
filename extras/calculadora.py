def suma(a, b):
    resultado = a + b
    return resultado

def resta(a, b):
    resultado = a - b
    return resultado

print("calculadora basica")
num1 = float(input("Ingresa el primer numero\n"))
op = input("ingresa la operacion\n")
num2 = float(input("Ingresa el segundo numero\n"))


if(op == "+"):
    resultado = suma(num1, num2)
else:
    resultado = resta(num1, num2)

print(f"RESULTADO: {resultado}")