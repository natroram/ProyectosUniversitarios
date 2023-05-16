'''
//**********************************************************//
//                    LABORATORIO 4                         //
//      MANEJO DE OPERADORES DE PRE-PROCESAMIENTO           // 
//         	                                            //
//**********************************************************//

la práctica se enfoca en el manejo de Operadores de Pre-procesamiento,
esto es: operadores aritméticos, operadores lógicos, selección de un
ROI, binarización, y dos pequeñas aplicaciones de: Realzado de brillo
a un ROI y Detección simple de Movimiento. 
'''

import cv2

#Funcion para cargar un archivo de imagen
def inputImg(message="\tPath de la imagen: "):
    while (True):
        path = input (message)
        try:
            return cv2.imread(path, 1)
        except:
            print ("\n\tRuta invalida")
            

print("\n*****************************************************************  ");
print("\n*\t     L A B O R A T O R I O    No. 4    D E \t\t*");
print("\n*\t\tPROCESAMIENTO DIGITAL DE IMAGENES\t\t*");
print("\n*   Manejo de Operadores Aritméticos, Lógicos, ROI, Threshold   *");
print("\n*                 y Aplicaciones básicas \t\t\t*");
print("\n*****************************************************************\n\n\n");

while(True):

    print("\t0. Salir\n\t1. Operador ADD\n\t2. Operador AND"+
          "\n\t3. Operador OR\n\t4. Operador XOR\n\t5. Operador"+
          " NOT\n\t6. Selección ROI\n\t7. Binarización\n\t"+
          "8. Aplicación#1 = Realzado de Brillo - ROI\n\t"+
          "9. Aplicación#2 = Simple Motion Detection\n\t"+
          "10. Copiar una región de una imagen")

    op = input("\n\t\tIngrese la opción --> ")


    if (op == '0'):
        break

    elif (op == '1'):
        print("\n\tOperador ADD")
        img1 = inputImg("\tPath 1era imagen: ")
        img2 = inputImg("\tPath 2da imagen: ")

        
        cv2.imshow("Img1", img1)
        cv2.imshow("Img2", img2)
        cv2.waitKey(0)
        cv2.destroyWindow("Img2")

        img3 = cv2.add(img1, img2)        
        cv2.imshow("Img1", img3)
        cv2.setWindowTitle("Img1", "Suma")
        cv2.waitKey(0)
        
    elif (op == '2'):
        print("\n\tOperador AND")
        img1 = inputImg("\tPath 1era imagen: ")
        img2 = inputImg("\tPath 2da imagen: ")

        cv2.imshow("Img1", img1)
        cv2.imshow("Img2", img2)
        cv2.waitKey(0)
        cv2.destroyWindow("Img2")

        img3 = cv2.bitwise_and(img1, img2)
        cv2.imshow("Img1", img3)
        cv2.setWindowTitle("Img1", "AND")
        cv2.waitKey(0)

    elif (op == '3'):
        print("\n\tOperador OR")
        img1 = inputImg("\tPath 1era imagen: ")
        img2 = inputImg("\tPath 2da imagen: ")

        cv2.imshow("Img1", img1)
        cv2.imshow("Img2", img2)
        cv2.waitKey(0)
        cv2.destroyWindow("Img2")

        img3 = cv2.bitwise_or(img1, img2)
        cv2.imshow("Img1", img3)
        cv2.setWindowTitle("Img1", "OR")
        cv2.waitKey(0)

    elif (op == '4'):
        print("\n\tOperador XOR")
        img1 = inputImg("\tPath 1era imagen: ")
        img2 = inputImg("\tPath 2da imagen: ")

        cv2.imshow("Img1", img1)
        cv2.imshow("Img2", img2)
        cv2.waitKey(0)
        cv2.destroyWindow("Img2")


        img3 = cv2.bitwise_xor(img1, img2)
        cv2.imshow("Img1", img3)
        cv2.setWindowTitle("Img1", "XOR")
        cv2.waitKey(0)

    elif (op == '5'):
        print("\n\tOperador NOT")
        img1 = inputImg()        

        cv2.imshow("Imagen", img1)
        cv2.waitKey(0)

        img2 = cv2.bitwise_not(img1)
        cv2.imshow("Imagen", img2)
        cv2.setWindowTitle("Imagen", "NOT")
        cv2.waitKey(0)

    elif (op == '6'):
        print("\n\tSeleccion de ROI")
        img1 = inputImg()        

        cv2.imshow("Imagen", img1)
        cv2.waitKey(0)

        r = cv2.selectROI(img1)        
        roi = img1[r[1]:r[1]+r[3], r[0]:r[0]+r[2]]
        cv2.imshow("Imagen", roi)
        cv2.setWindowTitle("Imagen", "ROI")
        cv2.waitKey(0)

    elif (op == '7'):
        print("\n\tBinarización")
        umbral=-1
        while(umbral<0 or umbral>255):
            try:
                umbral = int(input("\tIngrese un umbral 0-255: "))
            except:
                print("\t-Valor incorrecto-")
        
        img1 = inputImg()
        gray = cv2.cvtColor(img1, cv2.COLOR_BGR2GRAY)
        cv2.imshow("Imagen", gray)

        ret, binaria = cv2.threshold(gray, umbral, 255, cv2.THRESH_BINARY)
        cv2.imshow("Binarizada", binaria)
        cv2.waitKey(0)

    elif (op == '8'):
        print("\n\tAplicación#1 = Masking - Realzado de brillo en roi")
        img1 = inputImg("\tPath 1era imagen: ")
        img2 = inputImg("\tPath 2da imagen: ")

        img1 = cv2.cvtColor(img1, cv2.COLOR_BGR2GRAY)
        img2 = cv2.cvtColor(img2, cv2.COLOR_BGR2GRAY)
        cv2.imshow("Img1", img1)
        cv2.imshow("Img2", img2)
        cv2.waitKey(0)

        #Extracción del roi de la imagen 2
        img1 = cv2.add(img1, 20)
        img3 = cv2.bitwise_and(img1, img2)
        
        cv2.imshow("Img1", img3)
        cv2.setWindowTitle("Img1", "Img3")
        cv2.waitKey(0)

        #Reduccion de brillo de la imagen
        img1 = cv2.subtract(img1, 100)
        
        cv2.imshow("Img2", img1)
        cv2.setWindowTitle("Img2", "Img4")
        cv2.waitKey(0)

        #Suma del roi extraido y la imagen
        img3 = cv2.add(img1, img3)
        
        cv2.imshow("Img1", img3)
        cv2.setWindowTitle("Img1", "Roi Realzado")
        cv2.waitKey(0)

    elif (op == '9'):
        print("\n\tAplicación#2 = Simple Motion Detection")
        img1 = inputImg("\tPath 1era imagen: ")
        img2 = inputImg("\tPath 2da imagen: ")

        cv2.imshow("Img1", img1)
        cv2.imshow("Img2", img2)
        cv2.waitKey(0)
        cv2.destroyWindow("Img2")

        img3 = cv2.subtract(img1, img2)
        ret, img3 = cv2.threshold(img3, 30, 255, cv2.THRESH_BINARY)
        cv2.imshow("Img1", img3)
        cv2.setWindowTitle("Img1", "Motion Detection")
        cv2.waitKey(0)

    elif (op == '10'):
        print("\n\tCopiar una región de una imagen")
        img1 = inputImg()

        print("\n\tDatos de la imagen de entrada:")
        print("\tAlto: "+str(img1.shape[0])+"\tAncho: "+str(img1.shape[1])+"\tCanales: "+str(img1.size/(img1.shape[0]*img1.shape[1])))

        print("\n\tIngrese coordenadas de región")
        while (True):
            try:
                pminX = int(input("\tPunto mínimo X: "))
                pmaxX = int(input("\tPunto máximo X: "))
                pminY = int(input("\tPunto mínimo Y: "))
                pmaxY = int(input("\tPunto máximo Y: "))
                #Extracción de la region
                img2 = img1[pminY:pmaxY, pminX:pmaxX].copy()

                if (pminX>pmaxX or pminY>pmaxY):
                    print("\n\tPunto maximo debe ser mayor al minimo.\n")
                else:
                    break
            except:
                print("\n\tPuntos inválidos.\n")
        
        cv2.imshow("Imagen", img1)
        cv2.imshow("Region", img2)
        cv2.waitKey(0)
        
    else:
        print("\n\tOpcion incorrecta.\n")

    cv2.destroyAllWindows()
