package Modelo;

import Modelo.Personas.Persona;
import Modelo.baseDatos.Datos;

public class Registro {
	private  static double ingresosGenerales;
	private  static double gastosGenerales;
	private  static int idGenerico;
	private int idRegistro;
	private double valor;
	private String idDetalle;
	
	public Registro(double cantidad, String det){ 
		idRegistro = idGenerico;
		idGenerico++;
		if(cantidad < 0) {//Si se ingreso un gasto
			gastosGenerales+=cantidad;
		}
		else if(cantidad > 0) {//Si se ingreso un gasto
			ingresosGenerales+=cantidad;
		}
		valor = Math.abs(cantidad);
		setIdDetalle(det);
		Datos.registro.put(Integer.toString(idRegistro), this);
	}
	public Registro(int idR,double v, String idD) {
		idRegistro = idR;
		valor = v;
		idDetalle=idD;
	}
	public Registro(){
		
	}

	public  void setIngresos(double ing) {
		ingresosGenerales += ing;
	}
	
	public  void setGastos(double gas) {
		gastosGenerales += gas;
	}
		
	public double getIngresos() {
		return ingresosGenerales;
	}
	
	public double getGastos() {
		return gastosGenerales;
	}
	public  int getIdGeneral() {
		return idGenerico;
	}
	public void setIdGeneral(int i) {
		idGenerico = i;
	}

	public  void setIdRegistro(int iD) {
		idRegistro = iD;
	}
	public int getidRegistro() {
		return idRegistro;
	}
	public String getIdDetalle() {
		return idDetalle;
	}
	public void setIdDetalle(String idDetalle) {
		this.idDetalle = idDetalle;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	
	
}
