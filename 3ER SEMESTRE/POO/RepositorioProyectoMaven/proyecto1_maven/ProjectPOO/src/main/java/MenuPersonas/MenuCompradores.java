/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MenuPersonas;

import Categoria.Categorias;
import General.Comprador;
import General.Personas;
import General.Producto;
import General.Proveedor;
import Pago.MetododePago;
import Pago.PagoPaypal;
import Pago.PagoTarjeta;
import Ubicacion.Coordenadas;
import Ubicacion.Geocoding;
import java.util.ArrayList;
import modelo.Sistema;
import modelo.Utilidades;
import static modelo.Utilidades.sc;

/**
 *
 * @author nicolepilco
 */
public class MenuCompradores extends MenuPersonas{



    public static void Consultas(ArrayList<Producto>produc, Comprador com){

        int opci = 0;
            while(opci != 1 && opci != 2){
                System.out.println("1.Consultar producto por codigo");
                System.out.println("2.volver al menu de busqueda");
                System.out.println("Ingresar la opcion:");
                opci = MenuPersonas.Validacion();
                if(opci == 1){
                    Producto pro = null;
                    while(pro == null){
                        System.out.println("Ingresar codigo:");
                        String cod = Utilidades.sc.nextLine();
                        pro = com.buscarProductoCodi(produc, cod.trim());
                        System.out.println("Producto seleccionado");
                        System.out.println(pro);
                        if(pro != null){
                            boolean val = false;
                            while(val == false){
                                System.out.println("Desea agregar producto al carrito(si,no):");
                                String agre = Utilidades.sc.nextLine();
                                if(agre.toLowerCase().contains("si")){
                                     System.out.println("Ingrese la cantidad");
                                     int cantidad = MenuPersonas.Validacion();
                                     if(cantidad >= 1){
                                         com.getCarrito().agregarProducto(pro, cantidad);
                                         System.out.println("Se agrego con exito el producto");
                                         val = true;
                                     }else{
                                         System.out.println("Cantidad no valida");
                                     }
                                }
                                 else if(agre.toLowerCase().contains("no")){ 
                                     val = true;
                                 }else{
                                     System.out.println("Ingrese una opcion valida:");
                                     val = false;
                                 }
                            }     
                        }else{

                            System.out.println("Ingrese un codigo existente");
                        }
                    }
                }if(opci == 2){
                    break; 
                }
                                    
            }
    }
    
    public static void MenuComRegistro(Sistema sis){

        boolean valida= true;
        
        // INGRESO DE NOMBRES
        String nombre = null;
	while(valida == true){
           System.out.println("Ingrese su nombre: ");
           nombre = Utilidades.sc.nextLine();
           valida = MenuPersonas.validarVacio(nombre);
        }
        // INGRESO DE IDENTIFICACION
        String numeroI = null;
	valida= false;
        while(valida == false){
            System.out.println("Ingrese su numero de indentificacion: ");
            numeroI = Utilidades.sc.nextLine();
            valida = MenuPersonas.validadorDeCedula(numeroI);
        }
        // INGRESO DE DIRECCION
        String direccion = null;
        Coordenadas cor = null;
	valida= true;
        while(valida == true){
           System.out.println("Ingrese su direccion: ");
           direccion = Utilidades.sc.nextLine();
           valida = MenuPersonas.validarVacio(direccion);
           if (valida==false){
             Geocoding geo = new Geocoding(direccion);
             cor = new Coordenadas(geo.getLatitud() , geo.getLongitud());
             if (geo.getLatitud() == 0) {
                 valida= true;
             }    
           }
           }
     
        // INGRESO DE CORREO ELECTRONICO
        String correo = null;
	valida = false;
        while(valida == false){
            System.out.println("Ingrese su correo electronico: ");
            correo = Utilidades.sc.nextLine();
            valida = MenuPersonas.validadoremail(correo);
        }   

        //INGRESO DE USUARIO
        String usuario = null;
        valida= true;
        while(valida == true){
             System.out.println("Ingrese su nombre de usuario: ");
             usuario = Utilidades.sc.nextLine();
             valida = MenuPersonas.validarVacio(usuario)||sis.existeUsuario(usuario);
        }

        //INGRESO DE CONTRASENIA
        String clave = null;
        valida= true;
        while(valida == true){
           System.out.println("Ingrese su contraseña: ");
           clave = Utilidades.sc.nextLine();
           valida = MenuPersonas.validarVacio(clave);
        }
        
        int opci = 0;
        MetododePago formapago = null;

        while(opci<1 || opci>2){
            System.out.println("Ingrese su metodo de pago: ");
            System.out.println("1.Paypal ");
            System.out.println("2.Tarjeta de credito: ");
            
            opci = MenuPersonas.Validacion();
            if(opci==1){
                // USUARIO PAYPAL
                String uName = null;
                valida= true;
                while(valida == true){
                   System.out.println("Ingrese su username PayPal: ");
                   uName = sc.nextLine();
                   valida = MenuPersonas.validarVacio(uName);
                }     
                // CONTRASENA PAYPAL
                String contra = null;
                valida= true;
                while(valida == true){
                   System.out.println("Ingrese su contraseña PayPal: ");
                   contra = sc.nextLine();
                   valida = MenuPersonas.validarVacio(contra);
                }     
                //FORMA DE PAGO
                formapago = new PagoPaypal(uName, contra);
            }else if(opci ==2){
                //TIPO DE TARJETA
                valida= true;
                String tipo = null;
                while(valida == true){
                   System.out.println("Ingrese el tipo de su tarjeta: ");
                   tipo = sc.nextLine();
                   valida = MenuPersonas.validarVacio(tipo);
                }     
                //NUMERO DE TARJETA 
                valida= true;
                String numT = null;
                while(valida == true){
                   System.out.println("Ingrese el numero de su tarjeta: ");
                   numT = sc.nextLine();
                   valida = MenuPersonas.validadortarjeta(numT);
                }  
                //NOMBRE DE SU TARJETA 
                valida= true;
                String nom = null;
                while(valida == true){
                   System.out.println("Ingrese el nombre de su tarjeta: ");
                   nom = sc.nextLine();
                   valida = MenuPersonas.validarVacio(nom);
                }  
                formapago = new PagoTarjeta(tipo, numT, nom, correo);
            }else{
                System.out.println("Ingrese una opcion valida");
            }
        }

        sis.registrarComprador(nombre, numeroI, direccion,cor, correo, usuario, clave, formapago);
        System.out.println("Usted se ha registrado con exito");
    }
    
    public static void MenuComInicioSesion(Personas usuarioLog, Sistema sis){
        int opcionC = 0;
        while(opcionC != 4){
            System.out.println("1.Consultar informacion de los productos");
            System.out.println("2.Consultar el carrito de compras");
            System.out.println("3.Consultar pedidos realizados");
            System.out.println("4.salir");
            opcionC = MenuPersonas.Validacion();
            Comprador com = (Comprador) usuarioLog;
            ArrayList<Proveedor> prove = new ArrayList<>();
            for(Personas per:sis.getPersonas()){
                if(per instanceof Proveedor){
                    Proveedor por = (Proveedor) per;
                    prove.add(por);
                }
            }
            com.consultarInfoDistan(prove);
            
            if(opcionC == 1){
                int opcion3 = 0;
                while(opcion3 != 5){
                    System.out.println("1.Consultar por categoria");
                    System.out.println("2.Consultar por nombre");
                    System.out.println("3.Consultar por precio");
                    System.out.println("4.Consultar todos los productos");
                    System.out.println("5.Salir");
                    opcion3 = MenuPersonas.Validacion();
                    if(opcion3 == 1){
                        System.out.println("Ingrese la categoria:");
                        String categorias = Utilidades.sc.nextLine();
                        while(!Categorias.contains(categorias.trim().toUpperCase())){
                            System.out.println("Ingrese una categoria correcto: ");
                            categorias= sc.nextLine();
                        }
                        ArrayList< Producto> produc = com.porFiltroCategoria(categorias.trim());
                        if(!produc.isEmpty()){
                            for(Producto p :produc){
                                System.out.println(p);
                                
                            }
                            Consultas(produc, com);
                        }else{
                            System.out.print("La categoria no existe");
                        }
                        
                    }
                    else if(opcion3 == 2){              
                        System.out.println("Ingrese el nombre del producto:");
                        String nombre = Utilidades.sc.nextLine();
                        ArrayList< Producto> produc2 = com.porFiltroName(nombre.trim());
                        if(!produc2.isEmpty()){
                            for(Producto p :produc2){
                                System.out.println(p);
                            }
                            Consultas(produc2, com);
                        }else{
                            System.out.println("El producto no existe");
                        }
                    }
                    else if(opcion3 == 3){
                        System.out.println("Ingrese el rango del precio:");
                        System.out.print("Ingrese el precio minimo:\t");
                        
                        while (!sc.hasNextDouble()){
                            sc.nextLine();
                            System.out.println("Ingrese un precio adecuado.");
                        }
                        double pricemin = sc.nextDouble();
                        sc.nextLine();
                        System.out.print("Ingrese el precio maximo:\t");
                        while (!sc.hasNextDouble()){
                            sc.nextLine();
                            System.out.println("Ingrese un precio adecuado.");
                        }
                        double pricemax= sc.nextDouble();
                        
                        ArrayList< Producto> produc3 = com.porFiltroPrecio(pricemax, pricemin);
                        for(Producto p :produc3){
                            System.out.println(p);
                        }
                        Consultas(produc3, com);
                    }
                    else if (opcion3== 4){
                        ArrayList< Proveedor> produc4= com.getProveCercanos();
                        ArrayList<Producto> proc = new ArrayList<>();
                        for (Proveedor p: produc4) {
                            for (Producto pro :p.getProductosProveedor()) {
                                
                                proc.add(pro);
                            }

                        }
                        if(proc.isEmpty()){
                            System.out.println("no hay proveedores cerca");
                        }
                        for(Producto po: proc){
                            
                            System.out.println(po);
                        }
                        Consultas(proc, com);
                    }else if(opcion3==5){
                        break;
                    }
                    
                       
                }
            }
            else if(opcionC==2){
                com.consultarCarrito();
                int elec = 0;
                while(elec != 1 && elec != 2){
                    System.out.println("1.- Eliminar producto del carrito");
                    System.out.println("2.- Efectuar compra");
                    System.out.print("Ingresar la opcion:");
                elec = MenuPersonas.Validacion();
                if(elec==1){
                    System.out.print("Ingrese el codigo del producto que desea eliminar:\t");
                    String codigo= sc.nextLine();
                    boolean valor = com.getCarrito().eliminarProducto(codigo);
                    if(valor){
                        System.out.println("\t\tLos elementos restantes del carrito son");
                        com.consultarCarrito();
                    }else{
                        System.out.println("El codigo ingresado no existe");
                    }
                }
                else if(elec==2){
                    if(com.getCarrito().getTotal() == 0.0){
                        System.out.println("No tiene articulos en el carrito");
                    }else{
                        System.out.println("Seleccione la forma de pago");
                        System.out.println("1.-Forma de pago preferida");
                        System.out.println("2.-Pago con Paypal");
                        System.out.println("3.-Pago con Tarjeta");
                        int op = sc.nextInt();
                        switch(op){
                            case 1:
                                MetododePago forma_pago = com.getForma_pago();
                                if(forma_pago instanceof PagoPaypal){
                                    PagoPaypal pay = (PagoPaypal)forma_pago;
                                    pay.setPago(com.getCarrito().getTotal());
                                    if(pay.procesarPago()){
                                        com.getCarrito().generarPedidos();
                                        System.out.println("Compra exitosa");
                                        break;
                                    }
                                }
                                else if(forma_pago instanceof PagoTarjeta){
                                    PagoTarjeta card = (PagoTarjeta)forma_pago;
                                    if(card.procesarPago()){
                                        com.getCarrito().generarPedidos();
                                        System.out.println("Compra exitosa");
                                        break;
                                    }
                                }
                            case 2:
                                String user = null;
                                boolean valida = true;
                                while(valida == true){
                                   System.out.println("Ingrese nombre de usuario: ");
                                   sc.nextLine();
                                    user = sc.nextLine();
                                   valida = MenuPersonas.validarVacio(user);
                                }     

                                String clave = null;
                                valida= true;
                                while(valida == true){
                                   System.out.println("Ingrese contraseña: ");
                                    clave = sc.nextLine();
                                   valida = MenuPersonas.validarVacio(clave);
                                }     


                                double monto = com.getCarrito().getTotal();
                                PagoPaypal paypal = new PagoPaypal(user, clave, monto);
                                if(paypal.procesarPago()){
                                    com.getCarrito().generarPedidos();
                                    System.out.println("Compra exitosa");
                                    break;
                                }else{
                                    System.out.println("No cuenta con suficientes fondos");
                                    break;
                                }

                            case 3:
                                valida= true;
                                String tipo = null;
                                while(valida == true){
                                   System.out.println("Ingrese el tipo de su tarjeta: ");
                                   sc.nextLine();
                                   tipo = sc.nextLine();
                                   valida = MenuPersonas.validarVacio(tipo);
                                }     
                                //NUMERO DE TARJETA 
                                valida= true;
                                String num = null;
                                while(valida == true){
                                   System.out.println("Ingrese el numero de su tarjeta: ");
                                   num = sc.nextLine();
                                   valida = MenuPersonas.validadortarjeta(num);
                                }  
                                //NOMBRE DE SU TARJETA 
                                valida= true;
                                String nom = null;
                                while(valida == true){
                                   System.out.println("Ingrese el nombre de su tarjeta: ");
                                   nom = sc.nextLine();
                                   valida = MenuPersonas.validarVacio(nom);
                                }  

                                PagoTarjeta tarjeta = new PagoTarjeta(tipo, num, nom, com.getCorreo_electronico());
                                if(tarjeta.procesarPago()){
                                    com.getCarrito().generarPedidos();
                                    System.out.println("Compra exitosa");
                                    break;
                                }
                                else{
                                    System.out.println("No se pudo realizar la compra");
                                }
                            }  
                        }
                    }
                }
                
            }
            else if(opcionC==3){
                if(com.getPedidosComprador().size() ==0){
                    System.out.println("No tiene pedidos realizados");
                }else{
                    System.out.println("\tLos pedidos que usted a realizado son");
                    com.consultarPedidos();
                }
                
            
            }
            
        }
    }
}

