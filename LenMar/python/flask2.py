from flask import Flask

app = Flask(__name__)

lista = [
         {"nombre":"Paco", "edad":20,"ciclo":"DAW"},
         {"nombre":"Maria", "edad":20,"ciclo":"ASIR"},
         {"nombre":"Juan", "edad":18,"ciclo":"DAM"},
         {"nombre":"Ana", "edad":21,"ciclo":"DAW"},
         ]

@app.route("/")
def inicio():
    return {"alumnos":lista}

@app.get("/lista")
def listado():
    texto = "<h1 style=color:#034180>Listado de alumnos</h1>\n<ol>"
    for i in range(len(lista)):
        texto += "<li> {nombre} y tiene {edad} años, estudia {ciclo}</li>\n".format(nombre = lista[i].get("nombre"), edad = lista[i].get("edad"), ciclo = lista[i].get("ciclo"))
    texto += "</ol>"
    return "<head> <style>body{background-color : #32363a; color : white}</style></head>"+texto

@app.get("/alumno/<nom>")
def alumno(nom):
    encontrado = False
    for alm in lista:
        if alm.get("nombre") == nom:
            encontrado = True
            salida = "El alumno existe: \n{nombre} y tiene {edad} años, estudia {ciclo}".format(nombre = alm.get("nombre"), edad = alm.get("edad"), ciclo = alm.get("ciclo"))
    if not encontrado:
        salida = "El alumno no existe"
    return salida

if __name__ == "__main__":
    app.run(debug=True)