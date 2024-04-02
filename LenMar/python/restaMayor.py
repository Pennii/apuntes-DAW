num1 = float(input("Ingresa un numero "))
num2 = float(input("Ingresa otro numero "))

if num1 >= num2:
    resta = num1 - num2
else:
    resta = num2 - num1
print(f"La resta del numero mayor menos el menor es: {resta}")