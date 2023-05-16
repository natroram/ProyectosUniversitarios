#PRUEBAS DE HIPOTESIS

Ho: lo que se supone como cierto
ha: lo que se quiere demostrar
error tipo 1: evidencia que Ha es cierta a pesar de que Ho es cierta
error tipo 2: no se cuentra evidencia que Ha es cierta a pesar que sí lo es

#****para la media suponiendo que n es grande****
  
   |     cola derecha        |       cola izquierda    |
   |-------------------------|-------------------------|  
Ho:| media <= media.supuesta | media >= media.supuesta |
Ha:| media > media.supuesta  | media < media.supuesta  |

est.prueba: z = ((xbarra - media.supuesta)/desv.estandar)*sqrt(n)

region de rechazo:
qnorm(alfa, lower.tail = F)
qnorm(alfa)

Si z fuera de R.R -> se rechaza Ho, existe evidencia estadística para probar Ha

Dos colas
Ho: media = media.supuesta
ha: media diferente de media.supuesta

est.prueba: z = ((xbarra - media.supuesta)/desv.estandar)*sqrt(n)
R.R
qnorm(alfa/2, lower.tail = F)
qnorm(alfa/2)
Si z fuera de R.R -> se rechaza Ho, existe evidencia estadística para probar Ha

valor p: pnorm(z)
Si valor p menor que alfa -> se rechaza Ho 

#****para la media, n<30, varianza y media desconocidas, dist normal****
  
   |     cola derecha        |       cola izquierda    |
   |-------------------------|-------------------------|  
Ho:| media <= media.supuesta | media >= media.supuesta |
Ha:| media > media.supuesta  | media < media.supuesta  |

est.prueba: t = ((xbarra - media.supuesta)/desv.estandar)*sqrt(n)
R.R
qt(alfa, n-1, lower.tail = F) : cola derecha z mayor que valor
qt(alfa, n-1) : cola izq z menor que valor 
Si t fuera R.C -> se rechaza Ho, existe evidencia estadística para probar Ha

Dos colas
Ho: media = media.supuesta
ha: media diferente de media.supuesta
est.prueba: t = ((xbarra - media.supuesta)/desv.estandar)*sqrt(n)
R.R
qt(alfa/2, n-1, lower.tail = F) 
qt(alfa/2, n-1) : |t| > valor 
Si t fuera R.C -> se rechaza Ho, existe evidencia estadística para probar Ha

#****para la varianza****

   |     cola derecha         |       cola izquierda     |
   |--------------------------|--------------------------|  
Ho:| varianza <= var.supuesta | varianza >= var.supuesta |
Ha:| varianza > var.supuesta  | varianza < var.supuesta  |

est.prueba: X^2 = (n-1)*(S^2/var.supuesta)
R.R
qchisq(alfa,n-1) : cola derecha - si est mayor que valor
qchisq(1-alfa,n-1) : cola izq - si est menor que valor
Si X^2 fuera R.R -> se rechaza Ho

Dos colas
Ho: varianza = var.supuesta
Ha: varianza diferente de var.supuesta

est.prueba: X^2 = (n-1)*(S^2/var.supuesta)
R.R
qchisq(alfa/2,n-1) : si est mayor que valor
qchisq(1-(alfa)/2,n-1)
Si X^2 fuera R.R -> se rechaza Ho

#****para la proporción****

psomb = x/n
  
   |  cola derecha   | cola izquierda  |
   |-----------------|-----------------|  
Ho:| p <= p.supuesta | p >= p.supuesta |
Ha:| p > p.supuesta  | p < p.supuesta  |
  
est.prueba: z = sqrt(n)*((psomb-p.supuesta)/sqrt(p.supuesta*(1-p.supuesta)))
R.R
qnorm(alfa, lower.tail = F) : cola derecha - si z es mayor que valor
qnorm(alfa) : cola izq - si z es menor que valor
prop.test(x= , n= , alternative = "greater/less/two.sided", conf.level = 1-alfa)

Dos colas
Ho: p = p.supuesta
Ha: p diferente de p.supuesta

est.prueba: z = sqrt(n)*((psomb-p.supuesta)/sqrt(p.supuesta*(1-p.supuesta)))

R.R
si z mayor que qnorm(alfa/2, lower.tail = F) -> rechaza Ho

#*******PARA DOS POBLACIONES********

#****dos medias - muestras grandes****

   |  cola derecha    | cola izquierda   |
   |------------------|------------------|  
Ho:| media1 <= media2 | media1 >= media2 |
Ha:| media1 > media2  | media1 < media2  |

ybarra : media1
xbarra : media2
est.prueba: z = (ybarra-xbarra)/(sqrt((desv1/n)+(desv2/n)))
R.R
cola derecha : z > qnorm(alfa, lower.tail = F)
cola izq : z < qnorm(alfa)

Dos colas
Ho: media1 - media2 = 0 : medias son iguales
Ha: media1 - media2 diferente de 0 : medias son diferentes

est.prueba: z = (ybarra-xbarra)/(sqrt((desv1/n)+(desv2/n)))
|z| > qnorm(alfa/2, lower.tail = F)

#****muestras pequeñas - dist normal****

   |  cola derecha    | cola izquierda   |
   |------------------|------------------|  
Ho:| media1 <= media2 | media1 >= media2 |
Ha:| media1 > media2  | media1 < media2  |
  
ybarra, m : media1
xbarra, n : media2
estimador varianza S^2 = ((n-1)*desv1 + (m-1)*desv2)/(n+m-2)
est.prueba: t = (ybarra-xbarra)/(sqrt(S^2))*(sqrt((1/n)+(1/m)))

cola derecha: t > qt(alfa, n+m-2, lower.tail = F)
cola izq: t < qt(alfa, n+m-2)

#****dos varianzas - normal****

   | cola derecha  | cola izquierda |
   |---------------|----------------|  
Ho:| var1 <= var2  | var1 >= var2   |
Ha:| var1 > var2   | var1 < var2    |

est.prueba: F = var1/var2
cola derecha: F > qf(alfa,n-1,m-1, lower.tail = F)
cola izq: F < qf(alfa, n-1,m-1)

Dos colas
Ho: var1 = var2 : var1/var2 = 1
Ha: var1 diferente de var2 : var1/var2 diferente de 1
est.prueba: F = var1/var2
F > qf(alfa/2,n-1,m-1, lower.tail = F)
  
#****diferencia de proporciones****
Ho: p1-p2=0
Ha: p1 - p2 > 0

estadistico de prueba 
prop.test(x=c(23,13),n=c(175,125),alternative = "greater")

valor p es mayor a 0.05 entonces No se rechaza Ho

#************BONDAD DE AJUSTE************
datos <- c( , , , ,)
estimacion parametros
summary(datos)
var(datos)

Ho: datos pertenecen a distribucion X 
Ha: datos no perteneces a distribucion X 

#****para distribucion normal****
shapiro.test(datos) : ver si valor p < 0.05 se rechaza Ho
require(nortest)
ad.test(datos) : mismo procedimiento con valor p

#****para caso discreto****
require(vcd)
gf <- goodfit(datos, type = "poisson", method = "MinChisq")
summary(gf)
verificar valor p < 0.05 se rechaza Ho

#TABLA DE CONTINGENCIA

opinion <- read.table("clipboard", neader=T)
tabla1 <- xtabs(Numero~., opinion)
tabla2 <- round(prop.table(tabla1),3) : encuentra proporciones
addmargins(tabla2) : agrega marginales en forma de proporcion
addmargins(tabla1) : agrega marginales 

#****contraste de independencia****
Ho: variable1 y variable2 son independientes
Ha: variable1 y variable2 no son independientes

a <- chisq.test(tabla1) : pob normales n > 30
verificar valor p < 0.05 para rechazar Ho
a$observed : visualiza las observadas
a$expected : visualiza las esperadas

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

