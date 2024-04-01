import subprocess

try:
    # Ejecutar el programa especificado
    subprocess.run(["C:\\Program Files\\Git\\git-bash.exe"])

    print("El programa ha terminado.")
except Exception as e:
    print("Ha ocurrido un error:", e)
