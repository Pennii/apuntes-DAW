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
    texto = f"""
    <!DOCTYPE html>
    <html lang="es">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Ejemplo flex</title>
        <link rel="stylesheet" href={url_for('static', filename = 'css/style.css')}>

    </head>
    <body>
    <img src = {url_for('static', filename = 'img/logo_ies_aguadulce.png')} alt = '...' width = 200px>
    <h2><a href = {url_for('formulario')}>Agregar alumno</a></h2>
    <h1>Listado de alumnos</h1>\n<ol>"""
    for i in range(len(lista)):
        texto += f"<li> <a href = {url_for('alumno', nom = lista[i].get('nombre'))}>{lista[i].get('nombre')}</a> y tiene {lista[i].get('edad')} años, estudia {lista[i].get('ciclo')} <a href = {url_for('eliminarAlm', nom = lista[i].get('nombre'))}>BORRAR</a></li>\n"
    texto += "</ol>"
    return texto+"</body></html>"

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
        salida = redirect(url_for('listado'))
    else:
        salida = f"""El alumno no ha sido encontrado en la lista
        <a href= {url_for('inicio')}> volver </a>
        """
    return salida
    
@app.route("/formulario_alumno", methods = ["GET", "POST"])
def formulario():
    if request.method == "POST":
        nom = request.form['nombre']
        ed = request.form['edad']
        cic = request.form['ciclo']
        salida = redirect(url_for('agregarAlm',nombre = nom, ciclo = cic, edad = ed))
    else:
        salida = f"""<form method = 'post' action = {url_for('formulario')}>        
        <input type = 'text' name = 'nombre' id = 'nombre'>
        <input type = 'number' name = 'edad' id = 'edad'>
        <input type = 'text' name = 'ciclo' id = 'ciclo'>
        <input type = 'submit' value = 'enviar'>
        </form>
        """
    return salida

@app.errorhandler(404)
def notEncontrado(e):
    return f"""
    <h2>ERROR PAGINA NO EXISTE</h2>
    <a href = {url_for("inicio")} >VOLVER</a>
    """


if __name__ == "__main__":
    app.run(debug=True)