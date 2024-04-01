class Persona:

    def __init__(self,nombre, edad, dni):
        self.__nombre = nombre
        self.__edad = edad
        self.__dni = dni



    def setNombre(self, nom):
        self.nombre = nom
    
    def getNombre(self):
        return self.nombre        