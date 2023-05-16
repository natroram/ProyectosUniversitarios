#Natalia Ramirez


import cv2
import numpy as np

kernel = np.ones((6, 6), np.uint8)
imagen = cv2.imread('periodista.png', 0)
_, thresh1 = cv2.threshold(img, 127, 255, cv2.THRESH_BINARY_INV)

cierre2 = cv2.morphologyEx(thresh1, cv2.MORPH_CLOSE, kernel)

apertura = cv2.morphologyEx(cierre2, cv2.MORPH_OPEN, kernel)

erosion = cv2.erode(apertura, None)
cv2.imshow("movimiento", erosion)
cv2.waitKey(0)
cv2.destroyAllWindows()

