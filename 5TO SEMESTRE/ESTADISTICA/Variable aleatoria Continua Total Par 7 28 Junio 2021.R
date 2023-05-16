set.seed(5)
runif(20)

#P(x<=2.5) X sigue una distribución uniforme (2,5)
punif(2.5,min=2, max=5)

#P(x>2.5) X sigue una distribución uniforme (2,5)
punif(2.5,min=2, max=5, lower.tail = F)
dunif(2.5, min=2, max=5) #es otro valor

media=(5+2)/2
media

varianza=(5-2)^2/12
varianza

desviestan=sqrt(varianza)
desviestan

#exponencial
#Se pide modelar las magnitudes sísmicas registradas según la escala de Ritcher en una región norteamericana mediante una distribución exponencial con media igual a 2.4.  Obtenga la probabilidad de que la magnitud de un sismo en esta región sea
#P(x>3)
pexp(3,rate=1/2.4, lower.tail=F)

pgamma(3,shape = 1,rate = 1/2.4, lower.tail = F)


#esta entre 2 y 3
#F(3) - F(2)
pexp(3,rate=1/2.4, lower.tail=T)-pexp(2,rate=1/2.4, lower.tail=T)


#DISTRIB BETA
#Probabilidad de que X pertenezca a [0,5 ; 0,7]
#F(0.7) - F(0.5)
pbeta(0.7, shape1 = 4, shape2=3, ncp=0)-pbeta(0.5, shape1 = 4, shape2=3, ncp=0)

#DISTRIBICION NORMAL

#P(z<2.5)  
pnorm(2.5)

#P(X<2.5) X sigue una N(2,1)
pnorm(2.5, mean=2, sd=1)

#P(z>2.5)
pnorm(2.5, lower.tail = F)

#P(0<z<3)
pnorm(3)-pnorm(0)

#P(z<a)=0.5793
qnorm(0.5793)
qnorm(0.25)
qnorm(0.50)
qnorm(0.75)

#X ~ N(3,2)
#primer cuartil
qnorm(0.25, mean=3, sd=2)
#segundo cuartil
qnorm(0.50, mean=3, sd=2)
#tercer cuartil
qnorm(0.75, mean=3, sd=2)

#ejercicio de la ppt

#a)¿Cuál es la probabilidad de que los costos reales sean mayores que la cantidad presupuestada?
#X~ N(400, 20^2)
#P (X>450)
#X: la cantidad gastada en mantenimiento de reparaciones de cierta fabrica
proba=pnorm(450,mean=400, sd=20, lower.tail = F)
round(proba,4)

#b)Si se observa a esta empresa durante ocho semanas. Cual es la probabilidad de que en al menos una de ellas la cantidad gastada sea mayor que el presupuesto?
#X: # de semanas en las que la cant gastada es > que el presupuesto
#n=8, p(x)=0.062 
#P (x>=1)
pbinom(0,size=8, prob=proba,lower.tail = F)

#P (X<=0) o P (x<1)
pbinom(0,size=8, prob=proba,lower.tail = T) 

