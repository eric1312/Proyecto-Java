import java.util.Scanner;   // Importar la clase Scanner
import articulo.ArticuloImpl;   // Importar la clase ArticuloImpl
import pedido.Pedido;   // Importar la clase Pedido
import pedido.PedidoImpl;   // Importar la clase PedidoImpl
import articulo.Articulo;   // Importar la clase Articulo
import java.util.ArrayList; // Importar la clase ArrayList
import java.util.Locale;    // Importar la clase Locale

public class App {  // Clase principal
    public static void main(String[] args) {    // Método principal
        PedidoImpl pedidoService = new PedidoImpl();    // Crear una instancia de PedidoImpl
        ArrayList<Pedido> pedidos = new ArrayList<>();  // Crear una lista de pedidos
        Scanner sc = new Scanner(System.in);    // Crear una instancia de Scanner
        sc.useLocale(Locale.US);    // Establecer el locale para el Scanner
        int opcion = 0; // Variable para almacenar la opción del menú
        ArticuloImpl service = new ArticuloImpl();      // Crear una instancia de ArticuloImpl
        ArrayList<Articulo> articulos = new ArrayList<>();  // Crear una lista de articulos
        int siguienteIdArticulo = 1;    // Variable para almacenar el siguiente id de articulo
        int siguienteIdPedido = 1;  // Variable para almacenar el siguiente id de pedido
        do {    // Bucle para mostrar el menú
            System.out.println("\n--- Menu ---");   // Mostrar el menú
            System.out.println("1. Crear articulo");    // Opción 1
            System.out.println("2. Consultar articulo");    // Opción 2
            System.out.println("3. Listar articulos");      // Opción 3
            System.out.println("4. Modificar articulo");    // Opción 4
            System.out.println("5. Suprimir articulo");   // Opción 5
            System.out.println("6. Salir"); // Opción 6
            System.out.print("Selecciona una opcion: ");    // Solicitar al usuario que seleccione una opción

            if (sc.hasNextInt()) {  // Verificar si la entrada es un número entero
                opcion = sc.nextInt();  // Leer la opción seleccionada
            } else {    // Si la entrada no es un número entero
                System.out.println("Por favor ingrese un numero valido."); // Mostrar mensaje de error
                sc.next(); // descartar el input no válido  
                continue;   // Volver a mostrar el menú
            }
            sc.nextLine(); // consumir el salto de línea

            switch (opcion) {  // Estructura switch para manejar las opciones del menú
                case 1: // Crear articulo
                    siguienteIdArticulo = service.crearArticulo(articulos, siguienteIdArticulo, sc);    // Llamar al método crearArticulo
                    break;  
                case 2: // Consultar articulo
                    service.consultarArticulo(articulos, sc);   // Llamar al método consultarArticulo
                    break;  
                case 3: // Listar articulos
                    service.listarArticulos(articulos);  // Llamar al método listarArticulos
                    break;
                case 4: // Modificar articulo
                    service.modificarArticulo(articulos, sc);   // Llamar al método modificarArticulo
                    break;  
                case 5: // Suprimir articulo
                    service.suprimirArticulo(articulos, sc);    // Llamar al método suprimirArticulo
                    break;
                case 6: // Salir
                    System.out.println("Saliendo...");  // Mostrar mensaje de salida
                    break;
                default:    // Opción no válida
                    System.out.println("Opcion no válida, por favor intente de nuevo.");    // Mostrar mensaje de error
            }
        } while (opcion != 6);  // Repetir el bucle hasta que el usuario seleccione la opción de salir
        //prueba de pedidos
        siguienteIdPedido = pedidoService.addPedido(pedidos, articulos, sc, siguienteIdPedido); // Llamar al método addPedido
        System.out.println(pedidoService.getPedido(pedidos, sc));   // Llamar al método getPedido
        pedidoService.updatePedido(sc, pedidos, articulos); // Llamar al método updatePedido
        System.out.println(pedidoService.getPedido(pedidos, sc));   // Llamar al método getPedido
        sc.close(); // Cerrar el Scanner
    }
}

// 1. Inicialización de objetos y variables
    // Se crean instancias de servicios (PedidoImpl, ArticuloImpl), listas para almacenar artículos y pedidos, y un Scanner para leer la entrada del usuario.
    // Se inicializan los contadores de IDs para artículos y pedidos.
// 2. Menú principal (bucle do-while)
    // Se muestra un menú con opciones para crear, consultar, listar, modificar y suprimir artículos, además de la opción para salir.
    // El usuario ingresa una opción. Si la entrada no es válida, se muestra un mensaje de error y se vuelve a mostrar el menú.
// 3. Ejecución de la opción seleccionada
    // Según la opción elegida, se llama al método correspondiente del servicio de artículos:
        // 1: Crear artículo (crearArticulo)
        // 2: Consultar artículo (consultarArticulo)
        // 3: Listar artículos (listarArticulos)
        // 4: Modificar artículo (modificarArticulo)
        // 5: Suprimir artículo (suprimirArticulo)
        // 6: Salir (termina el bucle)
        // Si la opción no es válida, se muestra un mensaje de error.
// 4. Salida del menú
    // Cuando el usuario elige salir (opción 6), termina el bucle.
// 5. Pruebas de pedidos (fuera del menú)
    // Se agrega un pedido usando addPedido.
    // Se muestra el pedido recién creado con getPedido.
    // Se permite actualizar el pedido con updatePedido.
    // Se vuelve a mostrar el pedido actualizado con getPedido.
// 6. Cierre de recursos
    // Se cierra el Scanner para liberar recursos.