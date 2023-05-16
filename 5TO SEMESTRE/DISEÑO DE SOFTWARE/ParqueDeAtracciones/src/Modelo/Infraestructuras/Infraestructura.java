package Modelo.Infraestructuras;
/**/
public abstract class Infraestructura {
	private String id;
    private String nombre;
    
    public Infraestructura() {   	
    }
    public Infraestructura(String id, String nom){
    	this.id = id; 
    	this.nombre = nom;
    }
    public String getID(){
        return id;
    }public String getNombre(){
        return nombre;
    }public void setID(String id){
        this.id=id;
    }public void setNombre(String nombre){
        this.nombre=nombre;
    }
    
}
