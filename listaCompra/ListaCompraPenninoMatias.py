from flask import Flask, url_for, redirect, request

app = Flask(__name__)
datos_compra = ["Leche","Café","Pan","Mantequilla"]

@app.route("/json")
def json():
    return datos_compra

@app.route("/", methods = ["GET", "POST"])
def inicio():
    if request.method == "GET":
        salida = f"""
        <!DOCTYPE html>
    <html lang="es">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>ListaCompra</title>
    </head>
    <body>
        <img src={url_for('static', filename = 'img/logo_ies_aguadulce.png')} alt="..." width="100px">
        <h1>Lista de la compra</h1>
        <form action="" method="post">
            <input type="text" name = "agregar">
            <input type="submit" value="Añadir">
        </form>
        <ul>"""
        for it in datos_compra:
            salida += f"<li>[<a href = {url_for('borrar', descripcion = it)}>X</a>]<a href = {url_for('detalle', nombre = it)}>{it}</a></li>"
        salida += """
        
        </ul>
    </body>
    </html>"""
    else:
        nombre = request.form["agregar"]
        salida = redirect(url_for("nuevo", nombre = nombre))
    return salida

@app.route("/borrar/<descripcion>")
def borrar(descripcion):
    encontrado = False
    for it in datos_compra:
        if it == descripcion:
            encontrado = True
            datos_compra.remove(it)
    if encontrado:
        salida = redirect(url_for("inicio"))
    else:
        salida =f"""
        <h1>Borrar producto</h1>
        <p>En la lista <b>no</b> esta anotado el producto <b>{descripcion}</b> y no se puede borrar</p>
        <a href = {url_for("inicio")}>volver</a>"""
    return salida

@app.route("/detalle/<nombre>")
def detalle(nombre):
    salida = "<h1>Detalles del producto</h1>"
    encontrado = False
    for it in datos_compra:
        if it == nombre:
            encontrado = True
            salida += f"""
            <p>En la lista esta anotado el producto <b>{nombre}</b></p>
            <a href = {url_for("inicio")}>volver</a>"""
    if not encontrado:
        salida +=f"""
            <p>En la lista <b>no</b> esta anotado el producto <b>{nombre}</b></p>
            <a href = {url_for("inicio")}>volver</a>"""
    return salida

@app.route("/nuevo/<nombre>")
def nuevo(nombre):
    encontrado = False
    for it in datos_compra:
        if it == nombre:
            encontrado = True
    if not encontrado:
        datos_compra.append(nombre)
        salida = redirect(url_for("inicio"))
    else:
        salida = f"""
        <h1>Nuevo producto</h1>
        <p>En la lista esta anotado el producto <b>{nombre}</b> y no se puede duplicar</p>
        <a href = {url_for("inicio")}>volver</a>"""
    return salida


@app.errorhandler(404)
def urlErronea(ex):
    return f"""
        <h1>URL erronea</h1>
        <h2>Esta pagina no existe</h2>
        <a href = {url_for("inicio")}>volver</a>"""







if __name__ == "__main__":
    app.run(debug=True)