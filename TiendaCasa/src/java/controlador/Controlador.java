/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://.netbeans/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controlador;

import modelo.Inmueble;
import modelo.InmuebleDAO;
import modelo.Vendedor;
import modelo.VendedorDAO;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Titi
 */
@WebServlet(name = "Controlador", urlPatterns = {"/Controlador"})
public class Controlador extends HttpServlet {

    Inmueble inmueble = new Inmueble();
    InmuebleDAO inmuebleDAO = new InmuebleDAO();
    Vendedor vendedor = new Vendedor();
    VendedorDAO vendedorDAO = new VendedorDAO();

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String menu = request.getParameter("menu");
        String accion = request.getParameter("accion");

        if (menu != null) {
            switch (menu) {
                case "Inmueble":
                    switch (accion) {
                        case "Listar":
                            List listaInmuebles = inmuebleDAO.listar();
                            request.setAttribute("inmuebles", listaInmuebles);
                            break;
                        case "Agregar":
                            String nombreProducto = request.getParameter("nombreProducto");
                            String descripcion = request.getParameter("descripcion");
                            String precio = request.getParameter("precio");
                            String direccion = request.getParameter("direccion");
                            String estado = request.getParameter("estado");

                            inmueble.setNombreProducto(nombreProducto);
                            inmueble.setDescripcion(descripcion);
                            inmueble.setPrecio(precio);
                            inmueble.setDireccion(direccion);
                            inmueble.setEstado(estado);
                            inmuebleDAO.agregar(inmueble);
                            request.getRequestDispatcher("Controlador?menu=Inmueble&accion=Listar").forward(request, response);
                            break;
                        case "Editar":
                            String idInmueble = request.getParameter("id");
                            Inmueble inmuebleSeleccionado = inmuebleDAO.listarPorId(Integer.parseInt(idInmueble));
                            request.setAttribute("inmueble", inmuebleSeleccionado);
                            request.getRequestDispatcher("Controlador?menu=Inmueble&accion=Listar").forward(request, response);
                            break;
                        case "Actualizar":
                            String codigoInmueble = request.getParameter("codigoInmueble");
                            
                                nombreProducto = request.getParameter("nombreProducto");
                                descripcion = request.getParameter("descripcion");
                                precio = request.getParameter("precio");
                                direccion = request.getParameter("direccion");
                                estado = request.getParameter("estado");

                                inmueble.setCodigoInmueble(Integer.parseInt(codigoInmueble));
                                inmueble.setNombreProducto(nombreProducto);
                                inmueble.setDescripcion(descripcion);
                                inmueble.setPrecio(precio);
                                inmueble.setDireccion(direccion);
                                inmueble.setEstado(estado);
                                inmuebleDAO.actualizar(inmueble);
                            
                            request.getRequestDispatcher("Controlador?menu=Inmueble&accion=Listar").forward(request, response);
                            break;
                        case "Eliminar":
                            codigoInmueble = request.getParameter("codigoInmueble");
                                inmuebleDAO.eliminar(Integer.parseInt(codigoInmueble));
                            request.getRequestDispatcher("Controlador?menu=Inmueble&accion=Listar").forward(request, response);
                            break;

                        default:
                            throw new AssertionError();
                    }
                    request.getRequestDispatcher("inmueble.jsp").forward(request, response);
                    break;

                    case "Vendedor":
                            switch (accion) {
                                case "Listar":
                                    List listaVendedores = vendedorDAO.listar();
                                    request.setAttribute("vendedores", listaVendedores);
                                    break;
                                case "Agregar":
                                    String nombreVendedor = request.getParameter("nombreVendedor");
                                    String apellido = request.getParameter("apellido");
                                    String telefonoStr = request.getParameter("telefono");
                                    int telefono = Integer.parseInt(telefonoStr);
                                    String correo = request.getParameter("correo");
                                    Vendedor nuevoVendedor = new Vendedor();
                                    nuevoVendedor.setNombreVendedor(nombreVendedor);
                                    nuevoVendedor.setApellido(apellido);
                                    nuevoVendedor.setTelefono(telefono);
                                    nuevoVendedor.setCorreo(correo);
                                    vendedorDAO.agregar(nuevoVendedor);
                                    request.getRequestDispatcher("Controlador?menu=Vendedor&accion=Listar").forward(request, response);
                                    break;
                                case "Editar":
                                    String idVendedor = request.getParameter("id");
                                    Vendedor vendedorSeleccionado = vendedorDAO.listarPorId(Integer.parseInt(idVendedor));
                                    request.setAttribute("vendedor", vendedorSeleccionado);
                                    request.getRequestDispatcher("Controlador?menu=Vendedor&accion=Listar").forward(request, response);
                                    break;
                                case "Actualizar":
                                    String codigoVendedor = request.getParameter("codigoVendedor");
                                    String nombreVendedorAct = request.getParameter("nombreVendedor");
                                    String apellidoAct = request.getParameter("apellido");
                                    String telefonoActStr = request.getParameter("telefono");
                                    int telefonoAct = Integer.parseInt(telefonoActStr);
                                    String correoAct = request.getParameter("correo");
                                    Vendedor vendedorAct = new Vendedor();
                                    vendedorAct.setCodigoVendedor(Integer.parseInt(codigoVendedor));
                                    vendedorAct.setNombreVendedor(nombreVendedorAct);
                                    vendedorAct.setApellido(apellidoAct);
                                    vendedorAct.setTelefono(telefonoAct);
                                    vendedorAct.setCorreo(correoAct);
                                    vendedorDAO.actualizar(vendedorAct);
                                    request.getRequestDispatcher("Controlador?menu=Vendedor&accion=Listar").forward(request, response);
                                    break;
                                case "Eliminar":
                                    String codigoVendedorEliminar = request.getParameter("codigoVendedor");
                                    vendedorDAO.eliminar(Integer.parseInt(codigoVendedorEliminar));
                                    request.getRequestDispatcher("Controlador?menu=Vendedor&accion=Listar").forward(request, response);
                                    break;
                                default:
                                    request.getRequestDispatcher("index.jsp").forward(request, response);
                                    return;
                            }
                            request.getRequestDispatcher("vendedor.jsp").forward(request, response);
                            break;


                default:
                    throw new AssertionError();
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}