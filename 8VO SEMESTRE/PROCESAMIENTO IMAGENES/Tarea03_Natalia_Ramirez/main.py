import cv2

'''
Natalia Ramirez Yepez
201911765
Tarea 3 - Practica
'''

imagen_color = cv2.imread("rubik_color.png")
imagen_blackWhite = cv2.imread("rubik_blackWhite.png")

print("Imagen Rubik a color")
b1, g1, r1 = imagen_color[8, 35]
print('Brillo de pixel (8,35) en imagen a color: ', (int(b1) + int(g1) + int(r1)) / 3)
b2, g2, r2 = imagen_color[24, 126]
print('Brillo de pixel (24,126) en imagen a color: ', ((int(b2) + int(g2) + int(r2)) / 3))
b3, g3, r3 = imagen_color[78, 58]
print('Brillo de pixel (78,58) en imagen a color: ', (int(b3) + int(g3) + int(r3)) / 3)
b4, g4, r4 = imagen_color[90, 90]
print('Brillo de pixel (90,90) en imagen a color: ', (int(b4) + int(g4) + int(r4)) / 3)
b5, g5, r5 = imagen_color[24, 73]
print('Brillo de pixel (24,73) en imagen a color: ', (int(b5) + int(g5) + int(r5)) / 3)

print("Imagen Rubik a blanco y negro")
b1, g1, r1 = imagen_blackWhite[8, 35]
print('Brillo de pixel (8,35) en imagen blanco y negro: ', (int(b1) + int(g1) + int(r1)) / 3)
b2, g2, r2 = imagen_blackWhite[24, 126]
print('Brillo de pixel (24,126) en imagen blanco y negro: ', ((int(b2) + int(g2) + int(r2)) / 3))
b3, g3, r3 = imagen_blackWhite[78, 58]
print('Brillo de pixel (78,58) en imagen blanco y negro: ', (int(b3) + int(g3) + int(r3)) / 3)
b4, g4, r4 = imagen_blackWhite[90, 90]
print('Brillo de pixel (90,90) en imagen blanco y negro: ', (int(b4) + int(g4) + int(r4)) / 3)
b5, g5, r5 = imagen_blackWhite[24, 73]
print('Brillo de pixel (24,73) en imagen blanco y negro: ', (int(b5) + int(g5) + int(r5)) / 3)

cv2.waitKey()
