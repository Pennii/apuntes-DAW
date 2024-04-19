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
        
    def __str__(self):
        return f"Nombre: {self.__nombre}, edad: {self.__edad}, dni: {self.__dni}"
    
    def esMayorDeEdad(self):
        return self.__edad >= 18

class alumno(Persona):
    def __init__(self, nombre, edad, dni, nota):
        super().__init__( nombre, edad, dni)
        self.__nota = nota
        
    def __str__(self):
        return super().__str__() + f" nota: {self.__nota}"

persona1 = alumno("matias", 21, "xd", 5)


persona1.dni = "tampoco"
print(persona1.__str__())
print(persona1.esMayorDeEdad())