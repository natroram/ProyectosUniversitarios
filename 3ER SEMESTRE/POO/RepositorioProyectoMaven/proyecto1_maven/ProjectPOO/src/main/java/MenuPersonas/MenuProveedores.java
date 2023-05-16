/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MenuPersonas;

import General.Pedido;
import General.Personas;
import General.Producto;
import General.Proveedor;
import Pago.MetododePago;
import Pago.PagoPaypal;
import Pago.PagoTarjeta;
import Ubicacion.Coordenadas;
import Ubicacion.Geocoding;
import java.time.LocalDateTime;
import modelo.Sistema;
import modelo.Utilidades;
import static modelo.Utilidades.sc;

/**
 *
 * @author nicolepilco
 */

public class MenuProveedores extends MenuPersonas{

    /**
     * Menu de los proveedores
     * @param sis Sistema principal del programa
     */
    public static void MenuProRegistro(Sistema sis){

        boolean valida= true;
        
        // INGRESO DE NOMBRES
        String nombre = null;
	while(valida == true){
           System.out.println("Ingrese su nombre: ");
           nombre = Utilidades.sc.nextLine();
           valida = MenuPersonas.validarVacio(nombre)||sis.existeUsuario(nombre);
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
        
        //NUMERO DE CONTACTO 
        valida= true;
        String numC = null;
        while(valida == true){
            System.out.println("Ingrese el numero de contacto: ");
            numC = sc.nextLine();
            valida = MenuPersonas.validadorNumContacto(numC);
        }  


        //INGRESO DE USUARIO
        String usuario = null;
        valida= true;
        while(valida == true){
             System.out.println("Ingrese su nombre de usuario: ");
             usuario = Utilidades.sc.nextLine();
             valida = MenuPersonas.validarVacio(usuario);
        }

        //INGRESO DE CONTRASENIA
        String clave = null;
        valida= true;
        while(valida == true){
           System.out.println("Ingrese su contraseña: ");
           clave = Utilidades.sc.nextLine();
           valida = MenuPersonas.validarVacio(clave);
        }
        
        
        sis.registrarProveedor(nombre, numeroI, direccion,cor, correo, usuario, clave,numC);
        
        System.out.println("Usted se ha registrado con exito");
    }

    /**
     * Menu para el inicio de sesion del usuario
     * @param usuarioLog Objeto perteneciente al usuario
     */
    public static void MenuProInicioSesion(Personas usuarioLog){
        int opcionP = 0;
        while(opcionP != 4){
        System.out.println("1. Registrar producto");
        System.out.println("2.Consultar informacion de los pedidos");
        System.out.println("3.Editar productos"); 
        System.out.println("4.salir");
        opcionP = MenuPersonas.Validacion();
        Proveedor proveedor = (Proveedor)usuarioLog;

        while(opcionP == 1){
            System.out.println("Ingrese codigo del producto: ");
            String cod = sc.nextLine();
            System.out.println("Ingrese nombre del producto: ");
            String nombre = sc.nextLine();
            System.out.println("Ingrese descripcion del producto: ");
            String desc = sc.nextLine();
            System.out.println("Ingrese categorias del producto: ");

            String categorias = Utilidades.ingresoCat();
            double precio = Utilidades.ingresoDouble("Ingrese el precio del producto: ");
            proveedor.registrarProductos(cod, nombre, desc, categorias, precio, proveedor);
            
            System.out.println("Desea registrar otro producto?: ");
            System.out.println("1.Si");
            System.out.println("2.No");
            String op = sc.nextLine();
            if(op.toLowerCase().equals("si")){
                opcionP = 1;
            }
            else{
                opcionP = 0;
            }
        }
        if (opcionP==2){
            proveedor.consultarInformacionPedidos();
            System.out.println("Desea gestionar algun pedido:");
            System.out.println("1.Si");
            System.out.println("2.No");
            int op = MenuPersonas.Validacion();
            if(op==1){

                if(proveedor.getPedidosProveedor().size()!=0){
                int numero = -1;
                while(!proveedor.existPedido(numero)){
                System.out.println("Ingrese el codigo del pedido que desea gestionar");
                numero=MenuPersonas.Validacion();
                }
                proveedor.cambiarEstadoPedido(numero);
            }
            else{
                System.out.println("No hay pedidos ingresados");
                }

            }




            else{
                opcionP = 0;
            }}
            while(opcionP == 3){
            int x = 0;
            while(x != 3){
                System.out.println("1.Consultar productos");
                System.out.println("2.Editar producto");
                System.out.println("3.Salir");
                int a = MenuCompradores.Validacion();
                if(a == 1){
                    System.out.println("Ingrese la categoria del producto: ");
                    String cat = sc.nextLine();
                    System.out.println("Ingrese nombre del producto: ");
                    String nom = sc.nextLine();
                    proveedor.consultarInformacionProductos(cat, nom);
                    x = 0;
                }
                else if(a == 2){
                    Producto producto = null;
                    while(producto == null){
                        System.out.println("Ingrese codigo del producto a editar: ");
                        String cod = sc.nextLine();
                        producto = proveedor.buscarProducto(cod.trim());
                    }
                    producto.printCat();
                    int b = 0;
                    while(b != 5){
                        System.out.println("1.Editar nombre del producto");
                        System.out.println("2.Editar descripcion del producto");
                        System.out.println("3.Editar precio del producto");
                        System.out.println("4.Editar categoria del producto");
                        System.out.println("5.Salir");
                        int d = MenuPersonas.Validacion();
                        switch(d){
                            case 1:
                                System.out.println("Ingrese nuevo nombre: ");
                                String nuevoNom = sc.nextLine();
                                proveedor.editarProductoNom(producto, nuevoNom);
                                b = 0;
                                break;
                            case 2:
                               System.out.println("Ingrese nueva descripcion: ");
                               String nuevoDesc = sc.nextLine();
                               proveedor.editarProductoDes(producto, nuevoDesc);
                               b = 0;
                               break;
                            case 3:

                                double nuevoPrecio = Utilidades.ingresoDouble("Ingrese nuevo precio: ");

                                proveedor.editarProductoPrecio(producto, nuevoPrecio);
                                b = 0;
                                break;
                            case 4:
                                producto.printCat();
                                int e= 0;
                                String mensaje = "-Su accion fue registrada-";
                                while(e != 4) {
                                    System.out.println("1.Anadir categoria: ");
                                    System.out.println("2.Eliminar categoria: ");
                                    System.out.println("3.Reemplazar categoria: ");
                                    System.out.println("4.Salir:");
                                    int f = MenuPersonas.Validacion();
                                    switch (f) {
                                        case 1:

                                            String nuevoCat = Utilidades.ingresoCat();
                                            producto.addCat(nuevoCat);
                                            e = 0;
                                            break;
                                        case 2:
                                            producto.printCat();
                                            String delCat = Utilidades.ingresoCat("Ingrese categoria a eliminar: ");

                                            producto.deleteCat(delCat);
                                            e = 0;
                                            break;
                                        case 3:
                                            int pos =producto.getCategoria().size();
                                            while(!producto.inCatRange(pos)){
                                                System.out.println("Ingrese numero de la categoria a reemplazar: ");
                                                 pos = MenuPersonas.Validacion();
                                            }


                                            String nuevaCat = Utilidades.ingresoCat("Ingrese nueva categoria: ");
                                            proveedor.editarProductoCat(producto, nuevaCat, pos);
                                            e = 0;
                                            break;
                                        case 4:
                                            e = 4;
                                            mensaje ="";
                                            break;
                                    }
                                    System.out.println(mensaje);
                                }
                                b = 0;
                                break;
                            case 5:
                                b = 5;
                                break;
                        }
                    }
                }
                else{
                    x = 3;
                    opcionP = 0;
                }
            }
        
        }
            }
        }
    }




