document.addEventListener("DOMContentLoaded", function(){ total()})

function  total(){
    var suma = document.getElementsByClassName("suma");
    var total = 0;
    var fila = document.getElementsByTagName("tr");
        for (let i = 0; i < suma.length; i++) {
            total += parseInt(suma[i].innerText);
        }
    document.getElementById("total").innerText = total;
}

function fondo(){
    var colorin = document.getElementById("color");
    var parrafos = document.getElementsByTagName("p")
    for (let i = 0; i < parrafos.length; i++) {
        parrafos[i].style.backgroundColor = colorin.value;
        
    }
}