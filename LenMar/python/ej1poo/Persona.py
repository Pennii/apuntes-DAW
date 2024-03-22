class Persona:
    
    __nombre = ()
    
    def __init__(self,nombre, edad, dni):
        self.nombre = nombre
        self.edad = edad
        self.dni = dni



    def setNombre(self, nom):
        self.nombre = nom
    
    def getNombre(self):
        return self.nombre        