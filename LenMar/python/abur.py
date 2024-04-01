# comentario de linea
"""
comentario de multiple linea
comentario de multiple linea
comentario de multiple linea
"""

def main():
    filas = int(input("Ingresa las filas: \n"))
    columnas = int(input("Ingresa las columnas: \n"))
    num = 0
    matriz = []
    for i in range(filas):
        fila = []
        for j in range(columnas):
            fila.append(num)
            num += 1
        matriz.append(fila)
    for i in matriz:
        for j in i:
            print(j,'',end='')
        print('')
    input("ingresa una tecla para salir... ")
        
if __name__ == "__main__":
    main()