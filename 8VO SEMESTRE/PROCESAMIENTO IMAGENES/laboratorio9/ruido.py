'''
Funciones de generacion de ruido en una imagen
Natalia Ramirez
201911765
'''

import math
import random
import numpy as np


def FunctionSAL(img):
    l = img.shape
    f = l[0]
    c = l[1]
    num = int(0.01 * f * c)  # Numero de pixeles con ruido
    img2 = img.copy()
    for i in range(num):
        X = random.randint(0, f - 1)
        Y = random.randint(0, c - 1)
        img2[X, Y] = 255
    return img2


def FunctionPIMIENTA(img):
    l = img.shape
    f = l[0]
    c = l[1]
    num = int(0.01 * f * c)  # Numero de pixeles con ruido
    img2 = img.copy()
    for i in range(num):
        X = random.randint(0, f - 1)
        Y = random.randint(0, c - 1)
        img2[X, Y] = 0
    return img2


def FunctionSAlYPIMIENTA(img):
    img1 = FunctionSAL(img)
    img2 = FunctionPIMIENTA(img1)
    return img2


def FunctionUNIFORME(img):
    l = img.shape
    f = l[0]
    c = l[1]
    a = 88
    b = 169
    V = np.zeros(256)
    pixel = f * c
    per = 1 / (b - a)
    img2 = img.copy()
    for i in range(256):
        if a <= i <= b:
            fact = int(pixel * per)
            V[i] = fact + 1
    for i in range(f):
        for j in range(c):
            if (i + j) % 2 == 0:
                valor = random.randint(0, 255)
                while V[valor] <= 0:
                    img2[i, j] = (valor + img2[i, j])
                    valor = random.randint(0, 255)
    return img2


def FunctionGAUSSIANO(img):
    l = img.shape
    f = l[0]
    c = l[1]
    V = np.zeros(256)
    u = 127
    var = 100
    pixel = c * f
    div = 2.5 * var
    img2 = img.copy()
    for i in range(256):
        num = math.pow(i - u, 2)
        dem = 2 * var * var
        e = math.exp(-num / dem)
        per = int(pixel * (1 / div) * e)
        V[i] = per + 20
    for i in range(f):
        for j in range(c):
            if (i + j) % 2 == 0:
                valor = random.randint(0, 255)
                while V[valor] <= 0:
                    img2[i, j] = ((valor + img2[i, j]))
                    valor = random.randint(0, 255)

    imagen = np.array(img)
    ruido = np.random.normal(50, 10, imagen.shape)
    ruido_img = imagen + ruido
    ruido_img = np.clip(ruido_img, 0, 255)
    return ruido_img

