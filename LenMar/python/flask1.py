from flask import Flask, Response, request
from datetime import datetime

app = Flask(__name__)

@app.route("/")
def saludo():
    return "Hola mundo"

@app.route("/fecha")
def fecha():
    return f"<h1>LA FECHA DE HOY ES</h1><br><b>{datetime.today().date()}</b>"

@app.route("/metodo",methods=["GET","POST"])
def mostrar():
    if request.method == "GET":
        text = "metodo get"
    else:
        text = "metodo post"
    return text

@app.route("/hola")
@app.route("/hola/<nombre>")
@app.route("/hola/<nombre>/<edad>")
def hola(nombre = None, edad = None):
    if nombre and edad:
        return f"hola {nombre}, tienes {edad} años"
    elif nombre:
        return f"hola {nombre}"
    else:
        return "hola"
    
@app.route("/suma/<int:num1>/<int:num2>")
def suma(num1, num2):
    return f"El resultado de {num1} + {num2} es: {num1+num2}"

if __name__ == "__main__":
    app.run(debug=True)