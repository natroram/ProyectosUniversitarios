'''
Natalia Ramirez Yepez
matricula: 201911765
Tarea 5 - ejercicio 1
'''

import numpy as np
import cv2

inferiorB = np.array([110, 50, 50])
superiorB = np.array([130, 255, 255])

inferiorR = np.array([160, 100, 50])
superiorR = np.array([180, 255, 255])

inferiorY = np.array([22, 93, 0])
superiorY = np.array([45, 255, 255])

lista_colores = [(inferiorB, superiorB), (inferiorR, superiorR), (inferiorY, superiorY)]

titulos = ["Azul", "Rojo", "Amarillo"]

for i in range(3):
    color = lista_colores[i]
    titulo = titulos[i]
    imgpath = 'img.bmp'
    imagen = cv2.imread(imgpath)
    hsv = cv2.cvtColor(imagen, cv2.COLOR_BGR2HSV)
    inferior = np.array(color[0])
    superior = np.array(color[1])
    mascara = cv2.inRange(hsv, inferior, superior)
    resolucion = cv2.bitwise_and(imagen, imagen, mask=mascara)
    cv2.namedWindow(titulo, cv2.WINDOW_AUTOSIZE)
    cv2.imshow(titulo, resolucion)
    cv2.waitKey(0)