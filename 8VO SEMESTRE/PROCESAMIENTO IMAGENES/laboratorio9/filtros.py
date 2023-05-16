'''
Funciones de filtros de convolucion
Natalia Ramirez
201911765
'''

import math
import numpy as np
import cv2
import copy


# mascara 3 x 3
# limites

def processImage(image):
    image = cv2.cvtColor(src=image, code=cv2.COLOR_BGR2GRAY)
    return image


def filtroMediano(img):
    median_image = cv2.medianBlur(img, 3)
    return median_image


def filtroMaximo(img):
    size = (3, 3)
    shape = cv2.MORPH_RECT
    kernel = cv2.getStructuringElement(shape, size)
    max_image = cv2.erode(img, kernel)
    return max_image


def filtroMinimo(img):
    size = (3, 3)
    shape = cv2.MORPH_RECT
    kernel = cv2.getStructuringElement(shape, size)
    min_image = cv2.dilate(img, kernel)
    return min_image


def filtroPuntoMedio(img):
    punto_medio_image = cv2.GaussianBlur(img, (3, 3), 0)
    return punto_medio_image


def filtroMedioAritmetico(img):
    average_image = cv2.blur(img, ksize=(3, 3))
    return average_image


def filtroMedioContraArmonico(img):
    filtro = cv2.xphoto.createContrastHarmonicMeanFilter(3)
    filtered_image = filtro.apply(img)
    return filtered_image
