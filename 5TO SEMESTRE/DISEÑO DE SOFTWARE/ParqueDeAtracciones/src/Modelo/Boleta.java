package Modelo;

import Modelo.Personas.Cliente;

public class Boleta {
    private String categoria;
    private static int ID = 0;
    private static int valor;
    private Cliente usuario;
    public Boleta(String categoria,int id,int valor) { 
    	this.categoria = categoria;
    	this.ID = id;
    	this.valor = valor;
    	this.usuario = null;
    }
    public static Boleta crearboleta(String categoria) {
    	int id;
    	// se crea una variable id para aumentar el ID cada vez que se cree una nueva boleta.
    	if (categoria.equals("bronce")){
    		valor=15000;
    		id=Boleta.ID+1;
    		return new Boleta(categoria, id, valor);
    	}
    	if (categoria.equals("plata")){
    		valor=30000;
    		id=Boleta.ID+1;
    		return new Boleta(categoria, id, valor);
    	}
    	if (categoria.equals("oro")){
    		valor=45000;
    		id=Boleta.ID+1;
    		return new Boleta(categoria, id, valor);
    	}    	    		
    	else {
    		return null;
    	}
    	//Primero se selecciona un valor deacuerdo a la categoria, si esta no tiene esta categoria marcara nulo, 
    	//luego se le aplica el valor y se aunmenta el id con un contador.
}
    public boolean pagodeboleta(Cliente comprador, Boleta b) {
    	if(comprador.getSaldo() >= b.valor) {
    		comprador.setsaldo(comprador.getSaldo()-b.valor);
    		b.setusuario(comprador);
    		return true;
    	}
    	else {
    		return false;
    	}
    	/*primero se verifica si el saldo es suficiente para efectuar la compra en caso de ser suficiente se retira el valor de la 
    	boleta del saldo del cliente, despues se le asigna el cliente a la boleta y se retorna true indicando que la transaccion fue
    	exitosa, en caso de no ser suficiente se retorna false indicando que no se pudo comprar la boleta*/ 
    }
    
    public void setusuario(Cliente usuario) {
		this.usuario = usuario;
	}
    
    public String getCategoria() {
		return categoria;
	}
    
    public int getID() {
		return ID;
	}
    
    public Cliente getusuario() {
		return usuario;
	}
    
    public int getvalor() {
		return valor;
	}
    
    public void setcategoria(String categoria) {
		this.categoria = categoria;
	}
    
    public void setID(int iD) {
		ID = iD;
	}
    
    public void setValor(int valor) {
		this.valor = valor;
	}
    /*public String toString (){
        String mensaje="Esta Boleta es categoria "+ getCategoria() +" con ID "+getID()+" y un valor de " +
        		getvalor() + " asocida al usuario "+ usuario.getnombre();
        return mensaje;
    }*/
    
}
