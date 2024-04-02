class Persona:

    def __init__(self,nombre, edad, dni):
        self.__nombre = nombre
        self.__edad = edad
        self.__dni = dni



    def setNombre(self, nom):
        self.__nombre = nom
    
    def getNombre(self):
        return self.__nombre        