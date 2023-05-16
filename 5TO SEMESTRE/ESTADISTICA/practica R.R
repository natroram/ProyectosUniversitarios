#Practica R
#Parte 1
#objetoR<- objetoA | objetoR= objetoA : asignacion de valores y datos
#head(objetoR,n) : extrae los n primeros registros de objetoR
#colnames(objetoR) : visualiza las columnas del objetoR
#objetoR$columna : referencia a una columna especifica del objetoR

data = iris #asigna datos de base iris a variable data (dataframe)
head(data,3) #muestra 3 primeros registros de data
colnames(data) #muestra nombres de columnas de data
data$Species 

#ejercicio
data1 = head(data,10)
head(data1,5)
data1$Petal.Length

#table(datos,exclude) : crea tabla con frecuencias absolutas, se pueden
#excluir ciertos valores
#prop.table(tabla frecuencia,margin) : crea tabla con frecuencias 
#relativas. Por defecto margin es NULL, si es 1 se obtiene marginales 
#por filas, 2 para columnas
#cbind(columna1,columna2) : unifica columnas en nuevo objeto

tabla1 = table(data$Species)
tabla1
tabla2 = table(data$Species, exclude = c("versicolor"))
tabla2

tabla3 = prop.table(tabla1)
tabla3
tablaR = cbind(Absoluta = tabla1, Relativa = tabla3)
tablaR

#barplot(tabla frecuencia,main,xlab) : diagrama de barras
#main es el titulo del grafico y xlab etiqueta eje x

barplot(tabla1, main="PENE", xlab="MAS PENES")



