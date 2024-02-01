import pyautogui as pg
import Pyperclip as pyc
import time


def enviar_mensaje(mensaje, repeticiones):
    for _ in range(repeticiones):
        pyc.copy(mensaje)
        
        # Ajusta la velocidad de pegado y presiona "Enter" dos veces
        pg.PAUSE = 0.05
        pg.hotkey('ctrl', 'v')
        pg.press('enter')
        pg.press('enter')
        pg.PAUSE = 0.1  # Restaura la velocidad de pausa después de enviar el mensaje
        time.sleep(1)  # Agrega un pequeño retardo entre los mensajes para evitar problemas

# Ingresa la cadena de texto que deseas enviar
mensaje = input('Ingresa tu mensaje: ')

# Ingresa la cantidad de veces que deseas enviar el mensaje
repeticiones = int(input('Número de veces que deseas enviar el mensaje: '))
time.sleep(3)

enviar_mensaje(mensaje, repeticiones)