# VISION POR COMPUTADOR - LABORATORIO 2
######################################

# Librerías
import cv2  # librería de visión por computadora
import numpy as np
import glob

# Inicialización de Variables

# criterio de terminación (un parámetro de función CornerSubPix)
criteria = (cv2.TERM_CRITERIA_EPS + cv2.TERM_CRITERIA_MAX_ITER, 30, 0.001)

# inicializa los array que van a contener los puntos: (0,0,0), (1,0,0), (2,0,0) ....,(6,5,0)
objp = np.zeros((7 * 7, 3), np.float32)
objp[:, :2] = np.mgrid[0:7, 0:7].T.reshape(-1, 2)

# Inicializa los parametros que almacenarán los puntos de la imagen, del mundo real, y los valóres intrínsecos y extrínsecos
# Para cada imagen creamos una lista que contiene una lista de puntos-3D de la escena del mundo real.
# coord3D contendrá la posición 3D de los puntos que representa a las esquinas internas de los cuadros del tablero en la escena 3D del mundo real.

coord3D = []  # PUNTOS 3D ESPACIALES EN EL MUNDO REAL

# Para cada imagen creamos una lista que contiene una lista de puntos-2D en la imagen
# coord2D contendrá la posición 2D de los puntos que representan a las esquinas internas de los cuadros del tablero en la imagen 2D.

coord2D = []  # PUNTOS 2D EN EL PLANO IMAGEN.

# Una vez que se tienen las posiciones 3D y las posiciones 2D de las esquinas internas del tablero se puede calcular la relación entre ambas
# NOTA: dado que usamos un tablero de ajedrez estos puntos tienen una relación definida entre ellos, esto es:
# la posición de los puntos está sobre las lineas y los cuadrados del tablero.
# entonces la relación (esperado-real) puede ser usada para corregir la distorsión de la imagen.

images = glob.glob('*.jpg')  # obtiene en un array todos los archivos con la extensión especificada

# //////////////////// Bloque principal del algoritmo de calibración ///////////////////////
# //El algoritmo tiene 2 etapas: 
# //Etapa 1: detecta las esquinas del tablero.
# //Etapa 2: proceso de calibración.

# ////////////////////////////////////////////////////////////////////////////////////////////
# //  ETAPA 1: detecta las esquinas del tablero y sus correspondientes coordenadas 2D y 3D ///
# ////////////////////////////////////////////////////////////////////////////////////////////


for fname in images:  # para cada frame (cada tablero)

    img = cv2.imread(fname)
    gray = cv2.cvtColor(img, cv2.COLOR_BGR2GRAY)

    # Encuentra las esquinas en un tablero de ajedrez
    ret, corners = cv2.findChessboardCorners(gray, (7, 7), None)

    # If found, add object points, image points (after refining them)
    if ret:
        corners_opt = cv2.cornerSubPix(gray, corners, (11, 11), (-1, -1), criteria)
        coord2D.append(corners_opt)

        coord3D.append(objp)

        # Draw and display the corners
        img = cv2.drawChessboardCorners(img, (7, 7), corners_opt, ret)

        cv2.namedWindow('img', cv2.WINDOW_NORMAL)
        cv2.resizeWindow('img', 800, 600)
        cv2.imshow('img', img)
        cv2.waitKey(500)

cv2.destroyAllWindows()

# ////////////////////////////////////
# //ETAPA 2: Proceso de Calibración///
# ////////////////////////////////////


ret, mtx, dist, rvecs, tvecs = cv2.calibrateCamera(coord3D, coord2D, gray.shape[::-1], None, None)

# almacenamos la matriz de la cámara, los coeficientes de distorsión para futuros usos

np.savetxt('cam_matrix.txt', mtx, delimiter=',')
np.savetxt('coef_dist.txt', dist, delimiter=',')

############  ELIMINA LA DISTORSIÓN  #####################

img = cv2.imread('img12.jpg')
h, w = img.shape[:2]
newcameramtx, roi = cv2.getOptimalNewCameraMatrix(mtx, dist, (w, h), 0, (w, h))

# undistort
dst = cv2.undistort(img, mtx, dist, None, newcameramtx)
# crop the image
x, y, w, h = roi
dst = dst[y:y + h, x:x + w]
cv2.imwrite('calibresult.png', dst)

############  ERROR DE RE-PROYECCION  ############

mean_error = 0
for i in range(len(coord3D)):
    coord2D_new, _ = cv2.projectPoints(coord3D[i], rvecs[i], tvecs[i], mtx, dist)
    error = cv2.norm(coord2D[i], coord2D_new, cv2.NORM_L2) / len(coord2D_new)
    mean_error += error
print("total error: {}".format(mean_error / len(coord3D)))
