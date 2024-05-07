from flask import Flask, redirect, url_for

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

@app.route("/nuevo/<nombre>/<int:precio>")
def agregar(nombre, precio, cant = 0):
    iguales = False
    for prod in productos:
        if nombre == prod["descripcion"]:
            iguales = True
    if not iguales:
        productos.append({f"descripcion":nombre, "cantidad":cant, "precio_unitario":precio})
        salida = redirect(url_for("productosLista"))
    else:
        salida = "El producto ya existe"
    return salida

if __name__ == "__main__":
    app.run(debug=True)