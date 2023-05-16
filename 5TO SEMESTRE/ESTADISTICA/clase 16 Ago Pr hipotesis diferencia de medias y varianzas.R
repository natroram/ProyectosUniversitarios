#Para verificar si el proceso de llenado de bolsas de café con 500 gramos está operando correctamente se toman aleatoriamente muestras de tamaño diez cada cuatro horas. 
#Una muestra de bolsas está compuesta por las siguientes observaciones: 502, 501, 497, 491, 496, 501, 502, 500, 489, 490.

#¿Está el proceso llenando bolsas conforme lo dice la envoltura? Use un nivel de significancia del 5%.


#Ho: media=500
#Ha: media diferente de 500

cont<-c(502, 501, 497, 491, 496, 501, 502, 500, 489, 490)
cont

shapiro.test(cont)
require(nortest)
ad.test(cont)


#Ho: los datos son N(media, varianza)
#Ha: los datos no son N(media, varianza)
#valor p <0.05 entonces se rechaza Ho a favor de Ha, NO son normales
#valor p >=0.05 entonces No se rechaza Ho en contra de Ha, Son normales

#Conclusion: Se comprueba la normalidad de los datos dado que el valor p es 0.05

t.test(cont,alternative = "two.sided", conf.level=0.99, mu=500)

#No existe evidencia estadistica par afirmar que el llenado de las bolsas de cafe es diferente de 500 con un alpha del 0.05
#no se rechaza Ho
#Entonces el proceso de llenado si esta cumpliendo con lo que dice la envoltura con un alpha de 0.09

qt(0.05/2,9)
qt(0.05/2,9, lower.tail = F)

#======================================================================================
#EJERCICIO DE PLANTULAS - DIFERENCIA DE MEDIAS CON POBLACION NORMAL

Control<-read.table("clipboard", header=T)

#Ho: IE Control = IE Fertilizados
#Ha: IE Control <> IE Fertilizados

Ctrl<-subset(Control, Tratamiento=='Ctrl')
Ctrl

Fert<-subset(Control, Tratamiento=='Fert')
Fert


#Para comprobar la igualdad o desigualdad de las varianzas

#Ho:varianzas son iguales
#Ha:varianzas son diferentes (varianza1/ varianza 2 <> 1)

var.test(Ctrl$IE, Fert$IE)
#No se rechaza Ho
#Por lo tanto las varianzas son iguales

#se aplica la prueba de diferencia de medias para pob normales con varianzas iguales
t.test(Ctrl$IE, Fert$IE, var.equal = T)

#Se rechaza Ho
#Existe evidencia estadistica para afimar que hay diferencia entre las plantulas sin fertilizar y las que estan fertilizadas


t.test(Ctrl$IE, Fert$IE, var.equal = F)
#Se rechaza Ho
#Existe evidencia estadistica para afimar que hay diferencia entre las plantulas sin fertilizar y las que estan fertilizadas

#a) concluya con el valor p 
#b) concluya con alpha 0.02
