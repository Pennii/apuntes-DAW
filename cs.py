import pyautogui
import os

try:
    # abrimos el archivo
    file = open("ruta.txt")
    ruta = file.read()
    # subimos la copia de seguridad
    pyautogui.hold("winleft")
    pyautogui.press("r")
    pyautogui.write("cmd")
    pyautogui.press("enter")
    """    pyautogui.sleep(1)
    pyautogui.write(f"cd {ruta}")
    pyautogui.press("enter")
    pyautogui.sleep(1)
    pyautogui.write("git add .")
    pyautogui.press("enter")
    pyautogui.sleep(1)
    pyautogui.write("git commit -m\"subido desde remoto\"")
    pyautogui.press("enter")
    pyautogui.sleep(1)
    pyautogui.write("git push origin master")
    pyautogui.press("enter")
    pyautogui.sleep(15)
    os.system("shutdown /s /t 1")
    print("El programa ha terminado.")"""
except Exception as e:
    print("Ha ocurrido un error:", e)
