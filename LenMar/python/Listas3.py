import random
alumno = []
sum = 0

for i in range(5):
    alumno.append(random.randint(0,10))
    
print("Notas del alumno:")
for i in alumno:
    print(i)  
    sum += i
    
print(f"Nota media:{sum/len(alumno)}")
print(f"Nota maxima: {max(alumno)}")
print(f"Nota minima: {min(alumno)}")