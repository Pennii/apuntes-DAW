tupla = (1, 5, "hola", 5.7)
for i in tupla:
    print(i,"",end="")
print("")
if tupla.count(1) < 2:
    print("la tupla solo tiene 1 vez el numero 1")
