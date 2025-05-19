package articulo;   // Paquete articulo

public class Articulo { // Clase Articulo
    private int id; // Atributo id
    private String nombre;  // Atributo nombre
    private String descripcion; // Atributo descripcion
    private double precio;  // Atributo precio

    public Articulo(int id, String nombre, String descripcion, double precio) { // Constructor de la clase Articulo
        this.id = id;   // Inicializar el atributo id
        this.nombre = nombre;   // Inicializar el atributo nombre
        this.descripcion = descripcion; // Inicializar el atributo descripcion
        this.precio = precio;   // Inicializar el atributo precio
    }

    public void setNombre(String nombre) {  // Método para establecer el nombre
        this.nombre = nombre;   // Asignar el nombre
    }

    public void setDescripcion(String descripcion) {    // Método para establecer la descripcion
        this.descripcion = descripcion; // Asignar la descripcion
    }

    public void setPrecio(double precio) {  // Método para establecer el precio
        this.precio = precio;   // Asignar el precio
    }

    public int getId() {    // Método para obtener el id
        return id;  // Retornar el id
    }

    public String getNombre() {   // Método para obtener el nombre
        return nombre;  // Retornar el nombre
    }

    public String getDescripcion() {    // Método para obtener la descripcion
        return descripcion; // Retornar la descripcion
    }

    public double getPrecio() {   // Método para obtener el precio
        return precio;  // Retornar el precio
    }

    @Override   // Método para convertir el objeto a una cadena
    public String toString() {
        return  
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", precio=" + precio 
                ;   // Retornar la cadena con los atributos del objeto
    }
}

// 1. Atributos
    // id: Identificador único del artículo.
    // nombre: Nombre del artículo.
    // descripcion: Descripción del artículo.
    // precio: Precio del artículo.
// 2. Constructor
    // Permite crear un objeto Articulo inicializando todos sus atributos (id, nombre, descripcion, precio).
// 3. Métodos setters
    // setNombre: Cambia el nombre del artículo.
    // setDescripcion: Cambia la descripción del artículo.
    // setPrecio: Cambia el precio del artículo.
// 4. Métodos getters
    // getId: Devuelve el identificador del artículo.
    // getNombre: Devuelve el nombre del artículo.
    // getDescripcion: Devuelve la descripción del artículo.
    // getPrecio: Devuelve el precio del artículo.
// 5. Método toString
    // Sobrescribe el método toString para mostrar todos los atributos del artículo en formato de texto, útil para imprimir información del objeto.
// Uso:
    // Esta clase representa un artículo en tu sistema, permitiendo almacenar y manipular su información básica.