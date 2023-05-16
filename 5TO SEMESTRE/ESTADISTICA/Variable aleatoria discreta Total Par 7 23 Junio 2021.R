#BINOMIAL
#Se asegura que en el 60% de las instalaciones generadoras de electricidad mediante energía solar, los gastos de servicio se reducen al menos en una tercera parte.  
#a) Exactamente 3 instalaciones de 5 observadas

dbinom(x=3,size=5, prob=0.60) #f(a)

#b) De 3 a 5 instalaciones de 5 observadas
y=3:5
y
sum(dbinom(y, size=5, prob=0.60))
#F(5)- F(2)
pbinom(5,5,0.60)-pbinom(2,5,0.60)

#c) Al menos 3 instalaciones de 10 observadas
#1- P(x<=2)
1-pbinom(2,10, 0.60)
pbinom(2,10, 0.60, lower.tail = F)


#GEOMETRICA

#¿Cuál es la probabilidad de que en la quinta visita que haga, sea la primera vez que el predicador sea bien "recibido
dgeom(5-1,15/100)

#BINOMIAL NEGATIVA

#Las líneas telefónicas de la central de reservaciones de una cierta línea aérea se encuentran ocupadas el 60% del tiempo.
#a) Si usted llama a dicha central. ¿Cuál es la probabilidad de que en 6 intento, le contestaron 3 veces?
#x: # de intentos hasta que me contesten r veces
#p(x)=0.40
#P(X=6) y r=3
dnbinom(x=6-3,size=3, prob=0.40)

#b) ¿Cuál es la probabilidad de que si se llama a esta central 10 veces le contestan a lo mucho 4 veces?
#X:# de veces que contestan en 10 llamadas
pbinom(4,10,prob=0.40, lower.tail = T)

#c) Cuál es la probabilidad de que contesten 2 veces en a lo mucho 5  intentos?
#P(x<=5)
pnbinom(5-2,2,prob=0.40)

#HYPERGEOMETRICA
#Se tiene 10 impresoras de las cuales 4 son defectuosas.  Si se seleccionan al azar 3 impresoras.  Cuál es la probabilidad de que
#a) 2 sean defectuosas
dhyper(2,4,10-4,3)

#b)Ninguna sea  defectuosa
round(dhyper(0,4,10-4,3),4)

#c) A lo mucho 2 sean defectuosas
phyper(2,m=4,n=10-4,k=3)

#d) Por lo menos 1 sea defectuosa
1-dhyper(0,4,10-4,3)
phyper(0,m=4,n=10-4,k=3, lower.tail = F)

#POISSON
#En un banco el número de cheques protestados está en un promedio de 6 por día. Determinar la probabilidad de que:
  
#a) En un día cualquiera 2 cheques sean protestados.
round(dpois(2,6),4)

#b) En un día cualquiera los mucho  2 cheques sean protestados.
ppois(2,6)

#c) En 3 días cualquiera más de 1 sea protestado.
ppois(1,18,lower.tail = F)
1-sum(dpois(0:1,18))
