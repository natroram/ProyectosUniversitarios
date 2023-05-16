/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Adicionales;

/**
 *
 * @author Katherine Morales Tierra
 */
public abstract class Aderezo {
  // Atributo nombre del aderezo
  protected String nombre;
  // Método abstracto para que cada tipo de aderezo sea una subclase de Aderezo e implemente dicho método
  abstract void setNombre(String nombre);
  
  @Override
  public String toString(){
    return nombre.toUpperCase();
  }
}
