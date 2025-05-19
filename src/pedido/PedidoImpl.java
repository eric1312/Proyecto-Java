package pedido; // Paquete pedido

import java.util.ArrayList; // Importar la clase ArrayList
import java.util.Scanner;   // Importar la clase Scanner
import articulo.Articulo;   // Importar la clase Articulo


public class PedidoImpl implements PedidoServices{  // Clase PedidoImpl que implementa la interfaz PedidoServices

    public int addPedido(ArrayList<Pedido> pedidos,ArrayList<Articulo> articulos,Scanner sc,int siguienteIdPedido){ // Método para agregar un nuevo pedido
        System.out.println("ingresa el nombre del cliente: ");  
        String nombre,fecha;       
        do{ 
            nombre= sc.nextLine();
        }while(nombre.length()>20 || nombre.length()<=0);   
        System.out.println("ingrese fecha");
        do{ 
        fecha= sc.nextLine();   
        }while(fecha.length()>20 || fecha.length()<=0); 
        ArrayList<Articulo> listaPedido = new ArrayList<>();    // Crear una lista para almacenar los articulos del pedido
        int id=0;       // Variable para almacenar el id del articulo
        double total=0; // Variable para almacenar el total del pedido
        while(id>=0){   
            System.out.println("ingresa el id del producto a pedir (numero negativo para salir): ");
            id = sc.nextInt();  // Leer el id del articulo
            sc.nextLine();  // Consumir el salto de línea
            boolean encontrado = false; // Variable para verificar si el articulo fue encontrado
            for(Articulo articulo : articulos){  // Bucle para recorrer la lista de articulos
                if(id==articulo.getId()){   // Verificar si el id del articulo coincide con el id ingresado
                    System.out.println("articulo encontrado, ingrese cantidad: ");  
                    int cantidad = sc.nextInt();    // Leer la cantidad del articulo
                    encontrado =true;   
                    sc.nextLine();  // Consumir el salto de línea
                    if(!listaPedido.contains(articulo)){    // Verificar si el articulo no está en la lista del pedido
                        articulo.setDescripcion("la cantidad de este articulo es: "+cantidad);  // Establecer la descripcion del articulo
                        listaPedido.add(articulo);  // Agregar el articulo a la lista del pedido
                    }
                    total+=cantidad*articulo.getPrecio();   // Calcular el total del pedido
                }
            }
            if(!encontrado){    // Verificar si el articulo no fue encontrado
                System.out.println("Articulo no encontrado ...");   // Mostrar mensaje de error
            }
        }
        Pedido pedido = new Pedido(siguienteIdPedido,fecha,nombre,total);   // Crear un nuevo objeto Pedido
        pedido.setArticulos(listaPedido);   // Establecer la lista de articulos del pedido
        pedidos.add(pedido);    // Agregar el pedido a la lista de pedidos
        return siguienteIdPedido++; // Retornar el siguiente id de pedido
    }

    public void removePedido(ArrayList<Pedido> pedidos,Scanner sc) {        // Método para eliminar un pedido existente
        int input;  
        System.out.printf("ingresa el Id del pedido a eliminar: "); 
        do{
            input=sc.nextInt();   // Leer el id del pedido a eliminar
            sc.nextLine();  // Consumir el salto de línea
        }while(input<=0);   
        int id=input;   
        if(pedidos.removeIf(pedido -> pedido.getId() == id)){   // Verificar si el pedido fue eliminado
            System.out.printf("pedido con id %d eliminado...",id);  // Mostrar mensaje de éxito
        }
        else{
            System.out.printf("pedido con id %d no encontrado...",id);  // Mostrar mensaje de error
        }
    }

    public String getPedido(ArrayList<Pedido> pedidos,Scanner sc){  // Método para obtener un pedido existente
        System.out.println("ingresa el id de pedido a buscar: ");   
        int id; 
        do{
            id = sc.nextInt();  // Leer el id del pedido a buscar
            sc.nextLine();  // Consumir el salto de línea
        }while(id<=0);  
        for(int i=0;i<pedidos.size();i++){  
            if(id==pedidos.get(i).getId()){  // Verificar si el id del pedido coincide con el id ingresado
                return toString1(pedidos.get(i));   // Retornar la cadena con los atributos del pedido
            }
        }
        System.out.println("pedido ID no encontrado");  // Mostrar mensaje de error
        return "no se encontro pedido con ID: "+id; // Retornar mensaje de error
    }

    public void updatePedido(Scanner sc,ArrayList<Pedido> pedidos,ArrayList<Articulo> articulos){   // Método para actualizar un pedido existente
        int idPedido,opcion=0;  
        char decision;  
        int id; 
        System.out.printf("ingresa el Id del pedido a actualizar: ");
        do{
            idPedido=sc.nextInt();  // Leer el id del pedido a actualizar
            sc.nextLine();  // Consumir el salto de línea
        }while(idPedido<=0);    
        for(Pedido pedido : pedidos){   
            while(idPedido==pedido.getId() && opcion>=0){   // Verificar si el id del pedido coincide con el id ingresado
                System.out.println("pedido encontrado, ingrese que quiere cambiar: (numero negativo para terminar)");   
                System.out.println("1)nombre, 2)fecha, 3)cantidad de articulos");   
                opcion=sc.nextInt();    // Leer la opción a cambiar
                sc.nextLine();  // Consumir el salto de línea
                switch(opcion){ 
                    case 1: 
                        System.out.println("ingresa el nombre del cliente actualizado: ");
                        String nombre;  
                        do{ 
                            nombre= sc.nextLine();  
                        }while(nombre.length()>20 || nombre.length()<=0);
                        pedido.setCliente(nombre);  // Establecer el nuevo nombre del cliente
                        break;  
                    case 2: 
                        System.out.println("ingrese fecha actualizada");
                        String fecha;   
                        do{ 
                            fecha= sc.nextLine();   
                        }while(fecha.length()>20 || fecha.length()<=0); 
                        pedido.setFecha(fecha); // Establecer la nueva fecha del pedido
                        break;  
                    case 3:
                        double total=pedido.getTotal(); 
                        ArrayList<Articulo> articulosPedido = pedido.getArticulos();    
                        id=0;
                        while(id>=0){
                            System.out.println("ingresa el id del producto a pedir (numero negativo o 0 para salir): ");
                            id = sc.nextInt();  // Leer el id del articulo
                            sc.nextLine();  
                            for(Articulo articulo : articulos){ 
                                if(id==articulo.getId()){   // Verificar si el id del articulo coincide con el id ingresado
                                    System.out.println("articulo encontrado, ingrese cantidad y si queres restar o sumar (R o S) primero cantidad: ");  
                                    int cantidad;   
                                    do{
                                        cantidad = sc.nextInt();    // Leer la cantidad del articulo
                                        sc.nextLine();  // Consumir el salto de línea
                                    }while(cantidad<0); 
                                    System.out.println("ahora si ingrese R o S");
                                    do{
                                        String input = sc.nextLine();   
                                        input=input.toUpperCase();  
                                        decision = input.charAt(0); 
                                    }while(decision!='R' && decision!='S'); 
                                    if(!articulosPedido.contains(articulo)){        // Verificar si el articulo no está en la lista del pedido
                                        articulo.setDescripcion("la cantidad de este articulo es: "+cantidad);  // Establecer la descripcion del articulo
                                        articulosPedido.add(articulo);  // Agregar el articulo a la lista del pedido
                                    }
                                    else{
                                        for(int j=0;j<articulosPedido.size();j++){  
                                            if(articulosPedido.get(j).getId()==id){   // Verificar si el id del articulo coincide con el id ingresado
                                                articulosPedido.get(j).setDescripcion("la cantidad de este articulo es: "+cantidad);    // Establecer la descripcion del articulo
                                            }
                                        }
                                        if(decision=='S'){  
                                            total+=cantidad*articulo.getPrecio();   // Calcular el total del pedido
                                        }   
                                        else {
                                            total-=cantidad*articulo.getPrecio();   // Calcular el total del pedido
                                        }
                                    }
                                }
                            }
                            pedido.setTotal(total); // Establecer el nuevo total del pedido
                        }
                        break;
                    default:
                        System.out.println("ERROR, opcion no disponible");  // Mostrar mensaje de error
                }
            }
            if(!(idPedido==pedido.getId())){    // Verificar si el id del pedido no coincide con el id ingresado
                System.out.println("pedido no encontrado... "); // Mostrar mensaje de error
            }
        }
    }

    String toString1(Pedido pedido){    // Método para convertir el objeto Pedido a una cadena
        return  "ID: "+pedido.getId()+  
                "\nnombre: "+pedido.getCliente()+   
                "\nfecha: "+pedido.getFecha()+  
                "\nimporte: "+pedido.getTotal()+
                "\nArticulos: "+pedido.getArticulos().toString();
    }
}

// 1. Solicita el ID del pedido a actualizar
    // Pide al usuario que ingrese el ID del pedido que quiere modificar.
    // Valida que el ID sea mayor que 0.
// 2. Busca el pedido con ese ID
    // Recorre la lista de pedidos.
    // Si encuentra el pedido con el ID ingresado, entra en un bucle para permitir varias modificaciones.
// 3. Menú de opciones de modificación
    // Muestra un menú para elegir qué campo modificar:
    // Nombre del cliente
    // Fecha
    // Cantidad de artículos
// 4. Modificación según la opción elegida
    // Opción 1:

        // Pide el nuevo nombre del cliente y lo valida.
        // Actualiza el nombre en el pedido.
    // Opción 2:

        // Pide la nueva fecha y la valida.
        // Actualiza la fecha en el pedido.

    // Opción 3:

        // Permite modificar los artículos del pedido.
        // Pide el ID del artículo a modificar (sale si es negativo o cero).
        // Busca el artículo en la lista de artículos.
        // Si lo encuentra, pide la cantidad y si quiere sumar o restar (S o R).
        // Si el artículo no está en el pedido, lo agrega con la cantidad indicada.
        // Si ya está, actualiza la cantidad y suma o resta el total según la decisión del usuario.
        // Actualiza el total del pedido.
// 5. Salida del bucle
    // El bucle termina si el usuario ingresa una opción negativa en el menú.
// 6. Si no encuentra el pedido
    // Si el ID no coincide con ningún pedido, muestra un mensaje de error.