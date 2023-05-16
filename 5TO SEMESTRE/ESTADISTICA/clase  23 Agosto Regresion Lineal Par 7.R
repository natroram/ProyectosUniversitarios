anti<-c(1,2,3,4,5,6)
cali<-c(4.8, 7.3, 8.4, 11, 13.1, 15.2)

regresion<-lm(cali~anti) #lm(y~x)
summary(regresion)

#De acuerdo al R^2 se puede inferir que la antiguedad explica el 99% de los datos de calificacion de los clientes del banco
#Por cada a;o de antiguedad cuanto aumenta la calificacion
#aumenta en 2.06 la calificacion por cada anio de antiguedad

grasas <- read.table('http://verso.mat.uam.es/~joser.berrendero/datos/EdadPesoGrasas.txt', header = TRUE)
grasas

summary(grasas)
regre1<-lm(grasas~edad, data = grasas)
summary(regre1)

plot(grasas$edad, grasas$grasas, xlab='edad', ylab='grasas')
abline(regre1)

#predicciones
nuevas<-data.frame(edad=seq(60,70))
nuevas

predict(regre1, nuevas)
