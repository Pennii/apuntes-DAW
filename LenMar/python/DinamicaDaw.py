from flask import Flask

ciclo = "DAW"
modulos = ["LM", "ENTORNOS", "SISTEMAS", "BBDD", "PROG", "FOL"]

app = Flask(__name__)

@app.get("/")
def inicio():
    salida = f"<h1 style=color:green>PAGINA DE {ciclo}</h1>\n<p>Modulos:</p>\n<ul>"
    for i in range(len(modulos)):
        salida += f"<li>{modulos[i]}</li>"
    salida += "</ul>"
    return salida

lista = [
         {"nombre":"Paco", "edad":20,"ciclo":"DAW"},
         {"nombre":"Maria", "edad":20,"ciclo":"ASIR"},
         {"nombre":"Juan", "edad":18,"ciclo":"DAM"},
         {"nombre":"Ana", "edad":21,"ciclo":"DAW"},
         ]

@app.get("/lista")
def listado():
    texto = "<h1 style=color:blue>Listado de alumnos</h1>\n<ol>"
    for i in range(len(lista)):
        texto += "<li> {nombre} y tiene {edad} años, estudia {ciclo}</li>\n".format(nombre = lista[i].get("nombre"), edad = lista[i].get("edad"), ciclo = lista[i].get("ciclo"))
    texto += "</ol>"
    return texto

@app.route("/nuevomodulo/<string:mod>")
def hola(mod):
    if mod not in modulos:
        modulos.append(mod)
        salida = f"{mod} ha sido agregado como modulo"
    else:
        salida = "el modulo ya esta agregado"
    return salida

@app.route("/borrar/<mod>")
def borrar(mod):
    if mod in modulos:
        modulos.remove(mod)
        return inicio()
    else:
        return "El modulo no se encuentra en la lista"    
    
@app.route("/jsonmod")
def jsonmod():
    return {"Modulos": modulos}

if __name__ == "__main__":
    app.run(debug=True)

