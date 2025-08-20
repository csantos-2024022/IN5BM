
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
public class VendedorDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int resp;

    // Método para listar todos los vendedores
    public List listar() {
        String sql = "call sp_ListarVendedor()"; 
        List<Vendedor> listaVendedor = new ArrayList<>();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Vendedor v = new Vendedor();
                v.setCodigoVendedor(rs.getInt(1));
                v.setNombreVendedor(rs.getString(2));
                v.setApellido(rs.getString(3));
                v.setTelefono(rs.getInt(4));
                v.setCorreo(rs.getString(5));
                listaVendedor.add(v);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaVendedor;
    }
    

    public int agregar(Vendedor ven) {
        String sql = "call sp_AgregarVendedor(?, ?, ?, ?)"; 
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, ven.getNombreVendedor());
            ps.setString(2, ven.getApellido());
            ps.setInt(3, ven.getTelefono());
            ps.setString(4, ven.getCorreo());
            resp = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resp;
    }

   
    public Vendedor listarPorId(int id) {
        Vendedor vendedor = new Vendedor();
        String sql = "SELECT * FROM Vendedor WHERE codigoVendedor = ?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                vendedor.setCodigoVendedor(rs.getInt(1));
                vendedor.setNombreVendedor(rs.getString(2));
                vendedor.setApellido(rs.getString(3));
                vendedor.setTelefono(rs.getInt(4));
                vendedor.setCorreo(rs.getString(5));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return vendedor;
    }
    
  
    public int actualizar(Vendedor ven){
        String sql = "call sp_EditarVendedor(?, ?, ?, ?)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, ven.getNombreVendedor());
            ps.setString(2, ven.getApellido());
            ps.setInt(3, ven.getTelefono());
            ps.setString(4, ven.getCorreo());
            ps.setInt(5, ven.getCodigoVendedor());
            resp = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resp;
    }

    public void eliminar(int id){
        String sql = "call sp_EliminarVendedor(?)";
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

