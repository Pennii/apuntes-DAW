from flask import Flask, redirect, url_for, request

app = Flask(__name__)

productos = [{"descripcion":"Pc", "cantidad":2, "precio_unitario":800},
             {"descripcion":"Impresora", "cantidad":5, "precio_unitario":60},
             {"descripcion":"Raton", "cantidad":8, "precio_unitario":16}]

@app.route("/productos")
def productosLista():
    salida = "<h1>La lista de productos es:</h1><ul>"
    for prod in productos:
        salida += f"<li>{prod['descripcion']}, stock: {prod['cantidad']}, precio unitario: {prod['precio_unitario']}</li>"
    salida += "</ul>"
    return salida

@app.route("/productos/<nombre>")
def mostrarProducto(nombre):
    salida = "El producto no existe"
    for prod in productos:
        if nombre == prod["descripcion"]:
            salida = f"<h1>{prod['descripcion']}, stock: {prod['cantidad']}, precio unitario: {prod['precio_unitario']}</h1>"    
    return salida

@app.route("/nuevo/<nombre>/<int:precio>/<int:cant>")
@app.route("/nuevo/<nombre>/<int:precio>")
def agregar(nombre, precio, cant = 0):
    iguales = False
    for prod in productos:
        if nombre == str.lower(prod["descripcion"]):
            iguales = True
    if not iguales:
        productos.append({f"descripcion":nombre, "cantidad":cant, "precio_unitario":precio})
        salida = redirect(url_for("productosLista"))
    else:
        salida = "El producto ya existe"
    return salida

@app.route("/agregar", methods = ["GET", "POST"])
def agregarForm():
    if request.method == "POST":
        nom = request.form["nom"]
        prec = request.form["precio"]
        cantidad = request.form["cantidad"]
        return redirect(url_for("agregar", nombre = nom, precio = prec, cant = cantidad))
    else:        
        return f"""<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="style.css">
</head>

<body>
    <form method = 'post' action = ''>        
        <input type = 'text' name = 'nom' id = 'nombre' placeholder = 'descripcion'>
        <input type = 'number' name = 'precio' id = 'precio' placeholder = 'precio'>
        <input type = 'number' name = 'cantidad' id = 'cantidad' placeholder = 'cantidad'>
        <input type = 'submit' value = 'enviar'>
    </form>
</body>
    """
    
@app.route("/editar/<nom>", methods = ["GET", "POST"])
def editar(nom):
    if request.method == "GET":
        cant = int
        precio = int
        encontrado = False
        for prod in productos:
            if str.lower(prod["descripcion"]) == nom:
                cant = prod["cantidad"]
                precio = prod["precio_unitario"]
                encontrado = True
        if not encontrado:
            salida = "El producto no existe"
        else:
            salida = f"""<!DOCTYPE html>
    <html lang="es">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Document</title>
        <link rel="stylesheet" href={url_for('static',filename = 'css/flask3.css')}>
    </head>

    <body>
        <form method = 'post' action = ''>        
            <input type = 'text' name = 'nom' id = 'nombre' value = {nom}>
            <input type = 'text' name = 'viejoNombre' id = 'inv' value = {nom}>
            <input type = 'number' name = 'precio' id = 'precio' placeholder = 'precio' value = {precio}>
            <input type = 'number' name = 'cantidad' id = 'cantidad' placeholder = 'cantidad' value = {cant}>
            <input type = 'submit' value = 'enviar'>
        </form>
    </body>"""
    else:
        nuevoNombre = request.form["nom"]
        nuevoPrcio = request.form["precio"]
        nuevoStock = request.form["cantidad"]
        viejoNom = request.form["viejoNombre"]
        for prod in productos:
            if str.lower(prod["descripcion"]) == viejoNom:
                prod["cantidad"] = nuevoStock
                prod["precio_unitario"] = nuevoPrcio
                prod["descripcion"] = nuevoNombre
        salida = redirect(url_for("productosLista"))
    return salida

@app.route("/eliminar/<nombre>")
def eliminarLinea(nombre):
    iguales = False
    for prod in productos:
        if str.lower(prod["descripcion"]) == nombre:
            productos.remove(prod)
            iguales = True
    if iguales:
        salida = redirect(url_for("productosLista"))
    else:
        salida = f"Producto \"{nombre}\" no existe"
    return salida

if __name__ == "__main__":
    app.run(debug=True)