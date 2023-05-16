'''
Laboratorio 9
Natalia Ramirez
201911765
'''

import numpy as np
import cv2
from ruido import *
from filtros import *


def menuRuido():
    print("Escoja ruido a aplicar: ")
    print("1. Sal \n"
          "2. Pimienta \n"
          "3. Sal y Pimienta \n"
          "4. Gausiano \n"
          "5. Uniforme \n"
          )


def menuFiltro():
    print("Escoja filtro a aplicar: ")
    print("1. Maximo \n"
          "2. Minimo \n"
          "3. Mediana \n"
          "4. Medio Aritmetico \n"
          "5. Punto Medio")


"""video = cv2.VideoCapture(0)
ret, frame = video.read()
if ret == True:
    cv2.imshow('captura', frame)
    img = cv2.cvtColor(src=frame, code=cv2.COLOR_BGR2GRAY)
"""
img = ''
img_ruido = ''
img_filtro = ''
img_realza = ''

menuRuido()
ruido = int(input())

video = cv2.VideoCapture(0)

if ruido == 1:
    while video.isOpened():
        ret, imagen = video.read()
        img_ruido = FunctionSAL(imagen)
        cv2.imwrite("fotoSAL.png", img_ruido)
        img_filtro = cv2.imread("fotoSAL.png", 0)
        img_filtro = filtroMaximo(img_filtro)
        cv2.imwrite("fotoSAL_sinRuido.png", img_filtro)
        img_realza = cv2.imread("fotoSAL_sinRuido.png", 0)
        img_realza = cv2.equalizeHist(img_realza)
        cv2.imwrite("fotoSAL_realzada.png", img_realza)

        if ret == True:
            cv2.imshow('Video con Sal', img_ruido)
            if cv2.waitKey(1) & 0xFF == ord('s'):
                break
        else:
            break
    video.release()
    cv2.destroyAllWindows()

elif ruido == 2:
    while video.isOpened():
        ret, imagen = video.read()
        img_ruido = FunctionPIMIENTA(imagen)
        cv2.imwrite("fotoPIMIENTA.png", img_ruido)
        img_filtro = cv2.imread("fotoPIMIENTA.png", 0)
        img_filtro = filtroMinimo(img_filtro)
        cv2.imwrite("fotoPIMIENTA_sinRuido.png", img_filtro)
        img_realza = cv2.imread("fotoPIMIENTA_sinRuido.png", 0)
        img_realza = cv2.equalizeHist(img_realza)
        cv2.imwrite("fotoPIMIENTA_realzada.png", img_realza)

        if ret == True:
            cv2.imshow('Video con Pimienta', img_ruido)
            if cv2.waitKey(1) & 0xFF == ord('s'):
                break
        else:
            break
    video.release()
    cv2.destroyAllWindows()
elif ruido == 3:
    while video.isOpened():
        ret, imagen = video.read()
        img_ruido = FunctionSAlYPIMIENTA(imagen)
        cv2.imwrite("fotoSALyPIMIENTA.png", img_ruido)
        img_filtro = cv2.imread("fotoSALyPIMIENTA.png", 0)
        img_filtro = filtroMediano(img_filtro)
        cv2.imwrite("fotoSALyPIMIENTA_sinRuido.png", img_filtro)
        img_realza = cv2.imread("fotoSALyPIMIENTA_sinRuido.png", 0)
        img_realza = cv2.equalizeHist(img_realza)
        cv2.imwrite("fotoSALyPIMIENTA_realzada.png", img_realza)

        if ret == True:
            cv2.imshow('Video con Sal y Pimienta', img_ruido)
            if cv2.waitKey(1) & 0xFF == ord('s'):
                break
        else:
            break
    video.release()
    cv2.destroyAllWindows()
elif ruido == 4:
    while video.isOpened():
        ret, imagen = video.read()
        img_ruido = FunctionGAUSSIANO(imagen)
        cv2.imwrite("fotoGAUSSIANO.png", img_ruido)
        img_filtro = cv2.imread("fotoGAUSSIANO.png", 0)
        img_filtro = filtroMedioAritmetico(img_filtro)
        cv2.imwrite("fotoGAUSSIANO_sinRuido.png", img_filtro)
        img_realza = cv2.imread("fotoGAUSSIANO_sinRuido.png", 0)
        img_realza = cv2.equalizeHist(img_realza)
        cv2.imwrite("fotoGAUSSIANO_realzada.png", img_realza)

        if ret == True:
            cv2.imshow('Video con Gaussiano', img_ruido)
            if cv2.waitKey(1) & 0xFF == ord('s'):
                break
        else:
            break
    video.release()
    cv2.destroyAllWindows()
elif ruido == 5:
    while video.isOpened():
        ret, imagen = video.read()
        img_ruido = FunctionUNIFORME(imagen)
        cv2.imwrite("fotoUNIFORME.png", img_ruido)
        img_filtro = cv2.imread("fotoUNIFORME.png", 0)
        img_filtro = filtroPuntoMedio(img_filtro)
        cv2.imwrite("fotoUNIFORME_sinRuido.png", img_filtro)
        img_realza = cv2.imread("fotoUNIFORME_sinRuido.png", 0)
        img_realza = cv2.equalizeHist(img_realza)
        cv2.imwrite("fotoUNIFORME_realzada.png", img_realza)

        if ret == True:
            cv2.imshow('Video con UNIFORME', img_ruido)
            if cv2.waitKey(1) & 0xFF == ord('s'):
                break
        else:
            break
    video.release()
    cv2.destroyAllWindows()

menuFiltro()
filtro = int(input("Ingrese opcion de filtro: "))

if filtro == 1:
    img_filtro = filtroMaximo(img_ruido)
    cv2.imshow(img_filtro)
elif filtro == 2:
    img_filtro = filtroMinimo(img_ruido)
    cv2.imshow(img_filtro)
elif filtro == 3:
    img_filtro = filtroMediano(img_ruido)
    cv2.imshow(img_filtro)
elif filtro == 4:
    img_filtro = filtroMedioAritmetico(img_ruido)
    cv2.imshow(img_filtro)
elif filtro == 5:
    img_filtro = filtroPuntoMedio(img_ruido)
    cv2.imshow(img_filtro)
