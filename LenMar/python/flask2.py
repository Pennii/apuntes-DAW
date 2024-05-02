from flask import Flask, request, url_for, redirect

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
    texto = "<h1>Listado de alumnos</h1>\n<ol>"
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

@app.route("/alumno/agregar/<string:nombre>/<string:ciclo>")
@app.route("/alumno/agregar/<string:nombre>/<int:edad>")
@app.route("/alumno/agregar/<string:nombre>/<int:edad>/<string:ciclo>")
def agregarAlm(nombre, ciclo = "DAW", edad = 18):    
    encontrado = False
    for alm in lista:
        if alm.get("nombre") == nombre:
            encontrado = True
    if not encontrado:
        lista.append({"nombre": nombre, "edad": edad, "ciclo": ciclo})
        salida = "Alumno agregado exitosamente"
    else:
        salida = "El alumno ya existe"
    return salida



@app.get("/alumno/eliminar/<nom>")
def eliminarAlm(nom):
    encontrado = False
    for alm in lista:
        if alm.get("nombre") == nom:
            encontrado = True
            lista.remove(alm)
    if encontrado:
        salida = inicio()
    else:
        salida = "El alumno no ha sido encontrado en la lista"
    return salida
    
@app.route("/prueba", methods = ["GET", "POST"])
def formulario():
    if request.method == "POST":
        nom = request.form['nombre']
        ed = request.form['edad']
        cic = request.form['ciclo']
        return redirect(url_for('agregarAlm',nombre = nom, ciclo = cic, edad = ed))
    else:
        return """<form method = 'post' action = '/prueba'>
        
        <input type = 'text' name = 'nombre' id = 'nombre'>
        <input type = 'number' name = 'edad' id = 'edad'>
        <input type = 'text' name = 'ciclo' id = 'ciclo'>
        <input type = 'submit' value = 'enviar'>
        </form>
        """
        

@app.errorhandler(404)
def notEncontrado(e):
    return inicio()


if __name__ == "__main__":
    app.run(debug=True)