
package modelo;

public class Inmueble {
    int codigoInmueble;
    String nombreProducto;
    String descripcion;
    String precio;
    String direccion;
    String estado;

    public Inmueble() {
    }

    public Inmueble(int codigoInmueble, String nombreProducto, String descripcion, String precio, String direccion, String estado) {
        this.codigoInmueble = codigoInmueble;
        this.nombreProducto = nombreProducto;
        this.descripcion = descripcion;
        this.precio = precio;
        this.direccion = direccion;
        this.estado = estado;
    }

    public int getCodigoInmueble() {
        return codigoInmueble;
    }

    public void setCodigoInmueble(int codigoInmueble) {
        this.codigoInmueble = codigoInmueble;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
    
}
