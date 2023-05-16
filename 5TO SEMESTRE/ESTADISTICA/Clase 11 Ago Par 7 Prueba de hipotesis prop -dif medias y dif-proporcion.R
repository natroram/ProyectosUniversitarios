xbarra<-7.8
media<-8
desvi<-0.5
n<-50
alpha<-0.01/2

#Ho: media=8
#Ha: media diferente de 8

# estadistico de prueba
estad<-(xbarra-media)/(desvi/sqrt(n))
estad

#region de rechazo
qnorm(alpha)
qnorm(alpha, lower.tail = F)

# Se rechaza Ho
#Existe evidencia estadistica para afirmar que el nuevo sedal sintetico tiene una resistencia promedio a la ruptura diferente de 8 kg con un nivel de significancia del 1%

#============================================================================================
xbarra<-19500
desvi<-3900
n<-100
alpha<-0.03
media<-20000

#Ho:media =20000
#Ha: media > 20000

#estad de prueba Z
estad<-(xbarra-media)/(desvi/sqrt(n))
estad


#valor p
pnorm(estad)

#valor p es mayor que 0.03
#No se rechaz Ho, en contra de la alternativa
#No existe evidencia estadistica suficiente para afirmar que el promedio de recorrido del auto es mayor que 20 mil km al año


#======================================================================================================
#Ho: p =0.60
#Ha: p > 0.60
#estadistico de prueba Z
z<-(0.70-0.60)/(sqrt(0.60*(1-0.60)/100))
z

#R.R.  Z> Z(alpha)
qnorm(0.05, lower.tail = F)

#Existe evidencia estadistica para afirmar que el nuevo medicamenta es mejor que el anterior con un nivel de confianza del 95%

prop.test(x=70,n=100, p=0.60, alternative = "greater", conf.level = 0.95)


#============================================================================================
#diferencia de medias
#Ho: media1-media2=0
#Ha: media 1- media2 diferente de 0

x1<-1.55
x2<-1.43
sigma1<-0.26
sigma2<-0.22
n1<-30
n2<-35
alpha<-0.01/2

z<-(x1-x2)/sqrt((sigma1^2)/n1+(sigma2^2)/n2)
z

#region de rechazo
qnorm(alpha)
qnorm(alpha, lower.tail = F)

#No se rechaza Ho
#No existe evidencia estadistica para afirmar que los dos suelos difieren con respecto al esfuerzo constante promedio con 1% de significancia

#===================================================================================================
#diferencia de proporciones
#Ho: p1-p2=0
#Ha: p1 - p2 > 0

#estadistico de prueba 
prop.test(x=c(23,13),n=c(175,125),alternative = "greater")

#valor p es mayor a 0.05 entonces No se rechaza Ho
#No existe evidencia estadistica para afirmar que las personas de las minorias raciales dejan su trabajo en proporcion mas alta que las de raza blanca
#con alpha 0.29