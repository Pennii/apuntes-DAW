
from Persona import Persona
    
persona1 = Persona("matias", 21, "no tiene")
print("El nombre de la primera persona es:", persona1.getNombre())
print("El nombre de la primera persona es: {}".format(persona1.getNombre()))
print(f"El nombre de la primera persona es:{persona1.getNombre()}")
persona1.setNombre("aaa")
print(persona1.getNombre())

    
    