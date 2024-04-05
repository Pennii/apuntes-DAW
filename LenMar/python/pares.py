num1 = int(input("Ingresa un numero: "))
num2 = int(input("Ingresa otro numero: "))
resultado = ""

if num1 > num2:
    for i in range(num2, num1):
        if i % 2 == 0:
            resultado += f"{i} - "
    resultado = resultado[:resultado.__len__()-2]
    print(resultado)
elif num2 > num1:
    for i in range(num1, num2):
        if i % 2 == 0:
            resultado += f"{i} - "
    resultado = resultado[:resultado.__len__()-2]
    print(resultado)
else:
    print("Ambos numeros son iguales")