'''
Natalia Ramirez Yepez
matricula: 201911765
Tarea 5 - ejercicio 2
'''

import cv2

def area_figura(ancho, alto, lados):
    if lados == 4:
        if ancho == alto:
            return ancho ** 2
        else:
            return ancho * alto
    else:
        return (ancho * alto) / 2


def perimetro_triangulo(ancho, alto):
    l = ((ancho ** 2) + (alto ** 2)) ** (1 / 2)
    return l + ancho + alto


def perimetro_cuadrado(ancho, alto):
    if ancho == alto:
        return 4 * ancho
    else:
        return 2 * (ancho + alto)


def parseo_texto(c, dimension, n):
    M = cv2.moments(c)
    x1 = 0
    y1 = 0
    x, y, ancho, alto = dimension
    if M['m00'] != 0.0:
        x1 = int(M['m10'] / M['m00'])
        y1 = int(M['m01'] / M['m00'])
    cv2.circle(imagen, (x1, y1), 5, (0, 0, 0))
    print("Area: ", area_figura(ancho, alto, n))
    if n == 4:
        print("Perimetro: ", perimetro_cuadrado(ancho, alto))
    else:
        print("Perimetro: ", perimetro_triangulo(ancho, alto))
    print("Centroide (x,y): ", (x1, y1))


figuras = ['Rectangulo', 'Cuadrado', 'Triangulo']
imagenes = ['img1.bmp', 'img2.bmp', 'img3.bmp']

for i in range(len(imagenes)):
    imagen = cv2.imread(imagenes[i])
    grises = cv2.cvtColor(imagen, cv2.COLOR_BGR2GRAY)
    canny = cv2.Canny(grises, 10, 150)
    contornos, _ = cv2.findContours(canny, cv2.RETR_EXTERNAL, cv2.CHAIN_APPROX_SIMPLE)
    for contorno in contornos:
        print(figuras[i].upper())
        e = 0.1 * cv2.arcLength(contorno, True)
        approx = cv2.approxPolyDP(contorno, e, True)
        dimensiones = cv2.boundingRect(approx)
        lados = len(approx)
        if lados == 3:
            parseo_texto(contorno, dimensiones, lados)
        if len(approx) == 4:
            ratio = float(dimensiones[2]) / dimensiones[3]
            if 0.9 < ratio < 1:
                parseo_texto(contorno, dimensiones, lados)
            else:
                parseo_texto(contorno, dimensiones, lados)
        cv2.drawContours(imagen, [approx], 0, (255, 255, 255), 2)
        cv2.namedWindow(figuras[i], cv2.WINDOW_AUTOSIZE)
        cv2.imshow(figuras[i], imagen)
        cv2.waitKey(0)
