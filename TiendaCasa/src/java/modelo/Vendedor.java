
package modelo;

public class Vendedor {
    int codigoVendedor;
    String nombreVendedor;
    String apellido;
    int telefono;
    String correo;

    public Vendedor() {
    }

    public Vendedor(int codigoVendedor, String nombreVendedor, String apellido, int telefono, String correo) {
        this.codigoVendedor = codigoVendedor;
        this.nombreVendedor = nombreVendedor;
        this.apellido = apellido;
        this.telefono = telefono;
        this.correo = correo;
    }

    public int getCodigoVendedor() {
        return codigoVendedor;
    }

    public void setCodigoVendedor(int codigoVendedor) {
        this.codigoVendedor = codigoVendedor;
    }

    public String getNombreVendedor() {
        return nombreVendedor;
    }

    public void setNombreVendedor(String nombreVendedor) {
        this.nombreVendedor = nombreVendedor;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
    
    
    
}
