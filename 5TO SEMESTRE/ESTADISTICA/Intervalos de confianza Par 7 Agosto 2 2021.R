n<-64
media<-33
desv<-sqrt(256)
desv  
w<-qnorm(0.025, lower.tail = F)
error<-desv/sqrt(n)
error
margen.error<-w*error
lim.inf<-media-margen.error
lim.sup<-media+margen.error
lim.inf
lim.sup

#======================================================
n<-17
media<-272
desv<-20

w<-qt(0.025,16, lower.tail=F) # t(0.025,16)
w

error<-desv/sqrt(n)
error
margen.error<-w*error
lim.inf<-media-margen.error
lim.sup<-media+margen.error
lim.inf
lim.sup

#===========================================================
lect<-c(28, 25, 29, 27, 27, 30,25, 24, 23, 29 )
lect

varianza<-var(lect)
varianza
 n<-10

w1<-qchisq(0.025,9, lower.tail = F)
w1 

w2<-qchisq(1-0.025, 9, lower.tail = F)
w2

lim.inf<-((n-1)*varianza)/w1
lim.inf

lim.sup<-((n-1)*varianza)/w2
lim.sup


#=========================================
n<-50
psomb<-4/50
psomb

w<-qnorm(0.025, lower.tail = F)
w

lim.inf<-psomb-(w*(sqrt(psomb*(1-psomb)/n)))
lim.inf

lim.sup<-psomb+(w*(sqrt(psomb*(1-psomb)/n)))
lim.sup


