# Arbol Fractal

Dibuja en la pantalla 5 �rboles de fractal de diferente tama�o dispuestos en un campo verde.

## Preparaci�n del campo

Es una ventana de 800x600 y coloca la l�nea de horizonte en X=200. 
Todo lo que est� encima de esa l�nea se pinta azul cielo. 
Todo lo que est� por debajo de la l�nea se pinta verde campo.

## Dibujo de los �rboles

Se debe utilizar la base de las f�rmulas seg�n lo indicado en la siguiente figura:

<img src="img/formulas.png" width="400">

Se fabrica una funci�n que haga lo siguiente:

f(x1, y1, x2, y2, n)

"La funci�n f crea la primera rama del �rbol del punto x1,y1 a x2,y2 y luego crea n ramas subsecuentes siguiendo el principio del fractal"

Para el caso general queremos obtener el valor de x3,y3. La otra rama se puede obtener de la misma manera.

Se obtiene el �ngulo de beta. Este �ngulo es el arctan de la pendiente que forman los puntos x1,y1 y x2,y2.

```
beta = arctan( (y2 - y1) / (x2 - x1) )
```

Ese �ngulo nos interesa porque solamente al aumentarle el �ngulo de alpha tenemos la inclinaci�n que necesitamos para entontrar x3,y3
entonces tenemos el angulo ``final = alpha + beta``
Una vez que tenemos el angulo ``final``, tenemos que calcular ``t``

```
t = ra�z cuadrada ( (x2 - x1)2 + (y2 - y1)2 )
```

y el largo de nuestra rama es entonces 0.8 t

Ahora, lo que tenemos que poder calcular es x3, y3 que se nos da gracias a las funciones seno y coseno:

```
x3 = x2 + 0.8 t cos(angulo final)
y3 = y2 + 0.8 t sin(angulo final)
```

## Color en las ramas

Se da un color a cada una de las ramas de los �rboles para simular un �rbol de verdad. 
Adem�s, tambi�n se puede dar un ancho a las l�neas. El resultado es el siguiente:

<img src="img/fractal.png" width="500">
