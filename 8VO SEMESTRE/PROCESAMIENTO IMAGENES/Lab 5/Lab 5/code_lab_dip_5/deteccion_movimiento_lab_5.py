''''''''''''''''''''''''''''''''''''''''''''
'''             LABORATORIO 5
            DETECCIÓN DE MOVIMIENTO
       PROCESAMIENTO DIGITAL DE IMÁGENES
'''            
''''''''''''''''''''''''''''''''''''''''''''

import cv2

#Ventanas para mostrar los resultados
cv2.namedWindow("Video", cv2.WINDOW_AUTOSIZE)
cv2.namedWindow("Imagen Fondo", cv2.WINDOW_AUTOSIZE)
cv2.namedWindow("Movimiento", cv2.WINDOW_AUTOSIZE)

capture = cv2.VideoCapture('video2.avi')  #carga archivo de video a procesar

#Extraigo un frame como fondo como referencia
ret, fondo = capture.read() #usa 1er frame del video
fondogris = cv2.cvtColor(fondo, cv2.COLOR_BGR2GRAY)

cv2.imshow("Imagen Fondo", fondo)

while (True):
    #Lectura de frames a usar para detectar movimiento
    ret, frame = capture.read()
    if (not ret):
        break

    #Convertir frame a escala de gris
    frameGris = cv2.cvtColor(frame, cv2.COLOR_BGR2GRAY)

    #Detecto movimiento usando el fondo de referencia extraido previamente
    frameRes = cv2.subtract(frameGris, fondogris)

    #Binarizo el movimiento detectado (imagen frameRes)
    ret, frameRes = cv2.threshold(frameRes, 10, 255, cv2.THRESH_BINARY)

    #Erosión para eliminar pequeños ruidos del movimiento detectado
    frameRes = cv2.erode(frameRes, None)

    #Muestro el video resultante con el movimiento detectado
    cv2.imshow("Movimiento", frameRes)
    cv2.imshow("Video", frame)

    key = cv2.waitKey(33)
    if (key==27):
        break

capture.release()
cv2.destroyAllWindows()
