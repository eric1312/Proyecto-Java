package pedido; // Paquete pedido
import articulo.Articulo;   // Importar la clase Articulo
import java.util.ArrayList; // Importar la clase ArrayList

public class Pedido { // Clase Pedido
    private int id; // Atributo id
    private String fecha;   // Atributo fecha
    private String cliente;  // Atributo cliente
    private double total;   // Atributo total
    private ArrayList<Articulo> articulos = new ArrayList<Articulo>();  // Atributo articulos

    public ArrayList<Articulo> getArticulos() { // Método para obtener la lista de articulos
        return articulos;
    }

    public void setArticulos(ArrayList<Articulo> articulos) {   // Método para establecer la lista de articulos
        this.articulos=articulos;
    }

    public Pedido(int id, String fecha, String cliente, double total) { // Constructor de la clase Pedido
        this.id = id;   // Inicializar el atributo id
        this.fecha = fecha; // Inicializar el atributo fecha
        this.cliente = cliente; // Inicializar el atributo cliente
        this.total = total; // Inicializar el atributo total
    }

    public int getId() {    // Método para obtener el id
        return id;  // Retornar el id
    }

    public void setId(int id) { // Método para establecer el id
        this.id = id;   // Asignar el id
    }

    public String getFecha() {  // Método para obtener la fecha
        return fecha;   // Retornar la fecha
    }

    public void setFecha(String fecha) {    // Método para establecer la fecha
        this.fecha = fecha;  // Asignar la fecha
    }

    public String getCliente() {    // Método para obtener el cliente
        return cliente; // Retornar el cliente
    }

    public void setCliente(String cliente) {    // Método para establecer el cliente
        this.cliente = cliente; // Asignar el cliente
    }

    public double getTotal() {  // Método para obtener el total
        return total;   // Retornar el total
    }

    public void setTotal(double total) {    // Método para establecer el total
        this.total = total; // Asignar el total
    }
}

// 1. Atributos
    // id: Identificador único del pedido.
    // fecha: Fecha en la que se realiza el pedido.
    // cliente: Nombre del cliente que realiza el pedido.
    // total: Importe total del pedido.
    // articulos: Lista de artículos (ArrayList<Articulo>) que forman parte del pedido.
// 2. Constructor
    // Permite crear un objeto Pedido inicializando todos los atributos principales (id, fecha, cliente, total).
// 3. Métodos getters y setters
    // getId / setId: Obtener o establecer el identificador del pedido.
    // getFecha / setFecha: Obtener o establecer la fecha del pedido.
    // getCliente / setCliente: Obtener o establecer el nombre del cliente.
    // getTotal / setTotal: Obtener o establecer el importe total del pedido.
    // getArticulos / setArticulos: Obtener o establecer la lista de artículos del pedido.
// 4. Uso
    // Esta clase sirve como modelo de datos para representar un pedido en tu sistema. 
    // Permite almacenar y manipular toda la información relevante de un pedido, incluyendo los artículos asociados.