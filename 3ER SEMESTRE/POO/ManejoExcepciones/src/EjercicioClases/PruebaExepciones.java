/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EjercicioClases;

/**
 *
 * @author rociomera
 */
class Ex1 extends RuntimeException{
    public Ex1(){
        super("Excepcion 1");
    }
    public Ex1(String s){
        super(s);
    }
}

class Ex2 extends RuntimeException{
    public Ex2(){
        super("Excepcion 2");
    }
    public Ex2(String s){
        super(s);
    }
}

class Ex3 extends RuntimeException{
    public Ex3(){
        super("Excepcion 3");
    }
    public Ex3(String s){
        super(s);
    }
}

public class PruebaExepciones {
    static int test;
    static void metodoC() {
           if(test==1) throw new Ex1();
           else if(test==2) throw new Ex2();
           else if(test==3) throw new Ex3();
    }
    static void metodoB () {
      try {
          metodoC();
      } catch (Ex2 ex) {
          System.out.println("metodoB atrapa Ex2");
          throw new Ex3();
      } catch (Ex3 ex) {
          System.out.println("metodoB atrapa Ex3");
          throw new Ex1();
      }
    }
    static void metodoA() {
       try {
           metodoB();
       } catch (Ex3 ex) {
           System.out.println("metodoA atrapa Ex3");
           throw new Ex1();
       } catch (Ex1 ex) {
           System.out.println("metodoA atrapa Ex1");
       }
    }   
    public static void main(String[] args) {
        //línea en la que la variable test toma un valor
        metodoA();
    }
}

/*
La clase PruebaExepciones se ejecuta tres veces con diferentes 
valores para la variable test. Para cada ejecución indique 
cuál sería la salida (Justifique su respuesta)

valor variable test
test=1; 


test=2; 


test=3; */



