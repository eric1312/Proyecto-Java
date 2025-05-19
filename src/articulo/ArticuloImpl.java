package articulo; // Paquete articulo
import java.util.ArrayList; // Importar la clase ArrayList
import java.util.Scanner;   // Importar la clase Scanner

public class ArticuloImpl implements ArticuloServices { // Clase ArticuloImpl que implementa la interfaz ArticuloServices
    public int crearArticulo(ArrayList<Articulo> Articulos, int siguienteIdArticulo, Scanner sc) {  // Método para crear un nuevo articulo
        System.out.println("creando articulo...");  
        System.out.print("ingresar titulo del articulo: ");
        String nombre = sc.nextLine();
        System.out.print("ingresar contenido del articulo: ");
        String descripcion = sc.nextLine();
        System.out.print("ingresar precio del articulo: ");
        double precio;  // Variable para almacenar el precio 
        do{ 
            precio = sc.nextDouble();  // Leer el precio ingresado por el usuario 
        }while(precio<=0);  
        sc.nextLine();  // Consumir el salto de línea
        Articulo nuevoArticulo = new Articulo(siguienteIdArticulo++, nombre, descripcion, precio);      // Crear un nuevo objeto Articulo
        Articulos.add(nuevoArticulo);   // Agregar el nuevo articulo a la lista de articulos
        System.out.println("Articulo created: " + nuevoArticulo);   // Mostrar mensaje de éxito
        return siguienteIdArticulo; // Retornar el siguiente id de articulo
    }

    public void consultarArticulo(ArrayList<Articulo> Articulos, Scanner sc) {   // Método para consultar un articulo
        System.out.println("consultando articulo..."); 
        System.out.print("ingresar ID del articulo a consultar: "); 
        int idConsulta = sc.nextInt();  // Leer el id del articulo a consultar
        sc.nextLine();  // Consumir el salto de línea
        boolean encontrado = false; // Variable para verificar si el articulo fue encontrado
        for (Articulo Articulo : Articulos) {   // Bucle para recorrer la lista de articulos
            if (Articulo.getId() == idConsulta) {   // Verificar si el id del articulo coincide con el id ingresado
                System.out.println("Articulo encontrado: " + Articulo); // Mostrar el articulo encontrado
                encontrado = true;  // Cambiar el estado de encontrado a verdadero
                break;  // Salir del bucle
            }
        }
        if (!encontrado) {  // Verificar si el articulo no fue encontrado
            System.out.println("Articulo no encontrado.");  // Mostrar mensaje de error
        }
    }

    public void listarArticulos(ArrayList<Articulo> Articulos) {    // Método para listar todos los articulos
        System.out.println("listando articulos...");    
        if (Articulos.isEmpty()) {  // Verificar si la lista de articulos está vacía
            System.out.println("No hay articulos disponibles.");    // Mostrar mensaje de error
        } else {
            for (Articulo Articulo : Articulos) {   // Bucle para recorrer la lista de articulos
                System.out.println(Articulo);   // Mostrar cada articulo
            }
        }
    }

    public void modificarArticulo(ArrayList<Articulo> Articulos, Scanner sc) {  // Método para modificar un articulo existente
        System.out.println("Modificando articulo...");  
        System.out.print("ingresar ID del articulo a modificar: ");
        int modificarId = sc.nextInt(); // Leer el id del articulo a modificar
        sc.nextLine();  // Consumir el salto de línea
        boolean encontrado = false; // Variable para verificar si el articulo fue encontrado
        for (Articulo Articulo : Articulos) {   // Bucle para recorrer la lista de articulos
            if (Articulo.getId() == modificarId) {  // Verificar si el id del articulo coincide con el id ingresado
                System.out.print("Enter new titulo: "); 
                String nuevoNombre = sc.nextLine(); 
                System.out.print("Enter new contenido: ");  
                String nuevaDesc = sc.nextLine();   
                System.out.print("Enter new precio: "); 
                double nuevoPrecio ;    // Variable para almacenar el nuevo precio
                do{ 
                    nuevoPrecio = sc.nextDouble();  // Leer el nuevo precio ingresado por el usuario
                    sc.nextLine();  // Consumir el salto de línea
                }while(nuevoPrecio<=0); 
                Articulo.setNombre(nuevoNombre);    
                Articulo.setDescripcion(nuevaDesc);     
                Articulo.setPrecio(nuevoPrecio);    
                System.out.println("Articulo modificado: " + Articulo); // Mostrar el articulo modificado
                encontrado = true;  // Cambiar el estado de encontrado a verdadero
                break;  // Salir del bucle
            }
        }
        if (!encontrado) {  // Verificar si el articulo no fue encontrado
            System.out.println("Articulo not encontrado."); // Mostrar mensaje de error
        }
    }

    public void suprimirArticulo(ArrayList<Articulo> Articulos, Scanner sc) {   // Método para suprimir un articulo existente
        System.out.println("suprimiendo articulo...");  
        System.out.print("ingresar ID del articulo a suprimir: ");  
        int suprimirId = sc.nextInt();  // Leer el id del articulo a suprimir
        sc.nextLine();  // Consumir el salto de línea
        for (int i = 0; i < Articulos.size(); i++) {    // Bucle para recorrer la lista de articulos
            if (Articulos.get(i).getId() == suprimirId) {   // Verificar si el id del articulo coincide con el id ingresado
                Articulos.remove(i);    // Suprimir el articulo de la lista
                System.out.println("Articulo suprimido.");  // Mostrar mensaje de éxito
                break;  // Salir del bucle
            }
        }
    }
}
