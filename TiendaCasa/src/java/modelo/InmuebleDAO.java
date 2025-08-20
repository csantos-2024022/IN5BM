/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Titi
 */
public class InmuebleDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int resp;
    
    
    public List listar() {
        String sql = "call sp_ListarInmueble()";
        List<Inmueble> listaInmueble = new ArrayList<>();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Inmueble c = new Inmueble();
                c.setCodigoInmueble(rs.getInt(1));
                c.setNombreProducto(rs.getString(2));
                c.setDescripcion(rs.getString(3));
                c.setPrecio(rs.getString(4));
                c.setDireccion(rs.getString(5));
                c.setEstado(rs.getString(6));
                listaInmueble.add(c);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaInmueble;
    }
    
    
    public int agregar(Inmueble cli) {
    String sql = "call sp_AgregarInmueble(?,?,?,?, ?)";
    try {
        con = cn.Conexion();
        ps = con.prepareStatement(sql);
        ps.setString(1, cli.getNombreProducto());
        ps.setString(2, cli.getDescripcion());
        ps.setString(3, cli.getPrecio());
        ps.setString(4, cli.getDireccion());
        ps.setString(5, cli.getEstado());
        resp = ps.executeUpdate();
    } catch (Exception e) {
        e.printStackTrace();
    }
    return resp;
}

    
    // Operacion editar
public int actualizar(Inmueble emp){
    String sql = "call sp_editarInmueble(?, ?, ?, ?, ?, ?);"; 
    try {
        con = cn.Conexion();
        ps = con.prepareStatement(sql);
        ps.setInt(1, emp.getCodigoInmueble()); 
        ps.setString(2, emp.getNombreProducto());
        ps.setString(3, emp.getDescripcion());
        ps.setString(4, emp.getPrecio());
        ps.setString(5, emp.getDireccion());
        ps.setString(6, emp.getEstado());

        ps.executeUpdate();
    } catch (Exception e) {
        e.printStackTrace();
    }
    return resp;
}
 

        public Inmueble listarPorId(int id) {
             Inmueble inmueble = new Inmueble();
             String sql = "select * from inmueble where codigoInmueble = ?";
             try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
            inmueble.setCodigoInmueble(rs.getInt(1));
            inmueble.setNombreProducto(rs.getString(2));
            inmueble.setDescripcion(rs.getString(3));
            inmueble.setPrecio(rs.getString(4));
            inmueble.setDireccion(rs.getString(5));
                inmueble.setEstado(rs.getString(6));
                }
        } catch (Exception e) {
            e.printStackTrace();
        }
     return inmueble;
        }
        
   
// eliminar
        public void eliminar(int id){
            String sql = "call sp_eliminarInmueble(?);";
            try {
                con = cn.Conexion();
                ps = con.prepareStatement(sql);
                ps.setInt(1, id); 
                ps.executeUpdate(); 
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    
}
