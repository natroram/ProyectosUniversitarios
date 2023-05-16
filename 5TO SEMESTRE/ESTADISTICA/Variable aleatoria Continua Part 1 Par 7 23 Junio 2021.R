set.seed(5)
runif(20)

#P(x<=2.5) X sigue una distribución uniforme (2,5)
punif(2.5,min=2, max=5)

#P(x>2.5) X sigue una distribución uniforme (2,5)
punif(2.5,min=2, max=5, lower.tail = F)
dunif(2.5, min=2, max=5)


#exponencial
#Se pide modelar las magnitudes sísmicas registradas según la escala de Ritcher en una región norteamericana mediante una distribución exponencial con media igual a 2.4.  Obtenga la probabilidad de que la magnitud de un sismo en esta región sea
#P(x>3)
pexp(3,rate=1/2.4, lower.tail=F)

#esta entre 2 y 3
F(3) - F(2)
pexp(3,rate=1/2.4, lower.tail=T)-pexp(2,rate=1/2.4, lower.tail=T)
