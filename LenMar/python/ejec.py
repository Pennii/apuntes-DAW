import subprocess
import pyautogui
import os

try:
    # Ejecutar el programa especificadogit
    pyautogui.press("winleft")
    pyautogui.write("git")
    pyautogui.press("enter")
    pyautogui.sleep(1)
    pyautogui.write("cd onedrive/desktop/apuntes-daw")
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
    pyautogui.sleep(1)
    print("El programa ha terminado.")
except Exception as e:
    print("Ha ocurrido un error:", e)
