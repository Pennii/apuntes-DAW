import subprocess
import pyautogui
import os

try:
    # WRITER PARA ESCRIBIR, READER PARA LEER VARIABLE {ESCRIBIR VARIABLE EN TEXTO - READ VARIABLE - UTILIZAR VARIABLE}
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
    pyautogui.sleep(15)
    os.system("shutdown /s /t 1")
except Exception as e:
    print("Ha ocurrido un error:", e)
