num1 = int(input("ingresa un numero: "))
num2 = int(input("ingresa un numero: "))
num3 = int(input("ingresa un numero: "))

if num1 >= num2 and num1 >= num3:
    if num2 >= num3:
        print(f"{num1} - {num2} - {num3}")
    else:
        print(f"{num1} - {num3} - {num2}")
elif num2 >= num3 and num2 >= num1:
    if num1 >= num3:
        print(f"{num2} - {num1} - {num3}")
    else:
        print(f"{num2} - {num3} - {num1}")
else:
    if num1 >= num2:
        print(f"{num3} - {num1} - {num2}")
    else:
        print(f"{num3} - {num2} - {num1}")
        
        
         