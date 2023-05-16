# Taller03-Solid

**1) Clases Helado y Pastel. Tienen mucha similitud, se debería crear una clase padre llamada Postre.**

No cumple con el principio D: Principio de inversión de dependencias. Puesto que si se quiere hacer un cambio en el costo de cualquiera de los productos la formula (que es la misma para ambos) debe ser cambiada en cada clase. Por eso se crea la clase Postre. 

<center>
  
Antes 
---| 
![1 1](https://user-images.githubusercontent.com/73801237/121585752-8e376700-c9f8-11eb-8684-fcd5e441e3d8.PNG) |

</center>

Después Postre | Después Helado y Pastel
--- | ---
![1 2](https://user-images.githubusercontent.com/73801237/121585446-36006500-c9f8-11eb-8392-cb4fddab7243.PNG) | ![2 2](https://user-images.githubusercontent.com/73801237/121580975-f7b47700-c9f2-11eb-952a-80a7b550e804.PNG)

**2) Clases Procesos.OperacionesAderezo y Postre. ¿Es necesaria la clase OperacionesAderezo?. Se puede incluir dentro de postre un método para agregar un aderezo y para quitar un aderezo.**

La clase OperacionesAderezo sí es necesaria porque de lo contrario la clase postre no estaría cumpliendo S: Principio de responsabilidad única, porque la clase tendría mas de una responsabilidad. 

OperacionesAderezo
---|
![image](https://user-images.githubusercontent.com/73801237/121582356-84ac0000-c9f4-11eb-9dd6-d141b8a6311b.png)

**3) Métodos calcularPrecioFinal() y  showPrecioFinal() están muy relacionados, deben estar en otra clase por si cambia la fórmula de cálculo. La clase nueva debe llamarse Procesos.ManejadorDePrecio.**

Al igual que el punto anterior, no cumple con el principio S: Principio de responsabilidad única. Por eso se crea la clase ManejadorDePrecio.

ManejadorDePrecio | Despues Postre 
--- |---
![3 1](https://user-images.githubusercontent.com/73801237/121583696-33047500-c9f6-11eb-98a3-c871eee4213e.PNG) | ![3 2](https://user-images.githubusercontent.com/73801237/121583864-6b0bb800-c9f6-11eb-9a9f-926b62c09670.PNG)


4. Enum Adicionales.Aderezo
El principio que se atenta es DIP, ya que inicialmente se depende de detalles y no de la abstracción, cambiando enum a una clase abstracta reducimos el aclopamiento.
Antes
![image](https://user-images.githubusercontent.com/8119854/121571127-3d1f7700-c9e8-11eb-935c-339c36b67080.png)

Después
![image](https://user-images.githubusercontent.com/8119854/121572395-c08d9800-c9e9-11eb-98ca-70acf7a3eabc.png)


**5) Clase manejadorDeLeche: El principio que no se cumple es LSP puesto que la clase hija LecheDeslactosada tiene un comportamiento inesperado a la clase padre LecheEntera al tirar una excepción**
<center>
 | Error en consola | Antes |
  
 | --- | --- |
  
  ![1 2](https://user-images.githubusercontent.com/73547550/121601416-87feb600-ca0b-11eb-9bd3-4d7cec89c265.png) | ![2 2](https://user-images.githubusercontent.com/73547550/121601580-c1372600-ca0b-11eb-8e67-53f7f919ca21.png) |
  
  Después |
  --- |
  ![1 1](https://user-images.githubusercontent.com/73547550/121600076-94820f00-ca09-11eb-969d-a7883814c867.png) |
  
</center>

