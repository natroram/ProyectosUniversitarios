# Eight Queen

Este programa resuelve el cl�sico problema de las 8 reinas. Este es un t�pico problema de recurrencia. 

## Recurrencia 

Ahora, el problema es identificar c�mo vamos a resolver ese problema con la recurrencia que 
se ve en este cap�tulo. Lo primero que debemos hacer es simplificar el problema al m�nimo.  
En nuestro caso, hay que simplificar este problema de la siguiente manera: 4 reinas en un tablero 4x4.

```
public boolean colocarReinaEnColumna(int col) {

	// Condici�n de fin de recurrencia
	if (col >= tablero.length)
		return true;
	
	for (int fila = 0; fila < tablero.length; fila++) {

		if(esConfiguracionCorrecta (fila, col)) {
			this.ponerReina(fila, col);

			// Aqu� es la importancia de la recurrencia
			if (colocarReinaEnColumna(col+1))
				return true;
			this.quitarReina(fila, col);
		}
	}
	return false;
}
```

Para cada columna se recorre una a una las filas. Cuando tenemos una configuraci�n que parece correcta, 
se coloca la reina en el lugar escogido y se llama al mismo m�todo para resolver un problema id�ntico, pero m�s peque�o.