/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pasandoArgumentos;

/**
 *
 * @author rociomera
 */
public class Test {
    public void parametroPrimitivo(double x,double y){
        x=x*2;
        y=y*8;
        System.out.println("Interior metodo primitivos:"+x+","+y);
    }
    
    public void parametroObjeto(Punto p){
        p.x=p.x*2;
        p.y=p.y*8;
        System.out.println("Interior metodo objetos:"+p.x+","+p.y);
    }
    
    public static void main(String[] args){
        Test t = new Test();
        int a = 2;
        int b = 4;
        System.out.println("a="+a+","+"b="+b);
        System.out.println("t.parametroPrimitivo(a,b)");
        t.parametroPrimitivo(a,b);
        System.out.println("a="+a+","+"b="+b);
        
        Punto p = new Punto();
        p.x = 10;
        p.y = 12;
        p.mostrarValores();
        System.out.println("t.parametroObjeto(p)");
        t.parametroObjeto(p);
        p.mostrarValores(); 
    }
}
