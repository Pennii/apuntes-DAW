class Persona:
    def __init__(self, nombre, edad, dni):
        self.__nombre = nombre
        self.__edad = edad
        self.__dni = dni
    
    @property
    def nombre(self):
        return self.__nombre
    
    @property
    def edad(self):
        return self.__edad
    
    @property
    def dni(self):
        return self.__dni
    
    @nombre.setter
    def setNombre(self, nombre):
        self.__nombre = nombre
        print("Nombre cambiado")
    
    @edad.setter
    def edad(self, edad):
        if edad > 0:
            self.__edad = edad
        else:
            edad = 0
        print("edad cambiada")
    
    @dni.setter
    def dni(self, dni):
        self.__dni = dni
        print("dni cambiado")
        
    def mostrar(self):
        print(f"Nombre: {self.__nombre}, edad: {self.__edad}, dni: {self.__dni}")
    
    def esMayorDeEdad(self):
        return self.__edad >= 18

class alumno(persona):
    def __init__(self, nombre, edad, dni, nota):
        super(self, nombre, edad, dni)
        self.__nota = nota

persona1 = Persona("matias", 21, "xd")

persona1.mostrar()
persona1.dni = "tampoco"
persona1.mostrar()
print(persona1.esMayorDeEdad())