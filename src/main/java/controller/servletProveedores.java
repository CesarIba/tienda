package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import model.proveedoresDAO;
import model.proveedoresDTO;

/**
 * Servlet implementation class servletGestionUsu
 */
@WebServlet("/servletProveedores")
public class servletProveedores extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servletProveedores() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nombreProv,ciudadProv,direcProv,telProv;
		long nitProv;
		proveedoresDTO proveeDto, proveeDtoRes;
		proveedoresDAO proveeDao = new proveedoresDAO();

		if(request.getParameter("btnInsertar")!=null) {

			if(!request.getParameter("nit").isEmpty()) {
				nitProv=Long.parseLong(request.getParameter("nit"));
				nombreProv=request.getParameter("nombre");
				ciudadProv=request.getParameter("ciudad");
				direcProv=request.getParameter("dir_prov");
				telProv=request.getParameter("tel_prov");
				
				proveeDto = new proveedoresDTO(nitProv, direcProv, ciudadProv, nombreProv, telProv);
				Boolean result = proveeDao.insertar_proveedor(proveeDto);
				if(result) {
					JOptionPane.showMessageDialog(null, "Se agrego correctamente el proveedor");
					response.sendRedirect("GestionProveedores.jsp");
				}else {
					JOptionPane.showMessageDialog(null, "No se agrego el proveedor");
					response.sendRedirect("GestionProveedores.jsp");
				}
			} else {
				JOptionPane.showMessageDialog(null, "Ingrese numero de nit");
				response.sendRedirect("GestionProveedores.jsp");
			}
			
		} else if(request.getParameter("btnConsultar")!=null) {

			if(!request.getParameter("nit").isEmpty()) {
				nitProv=Long.parseLong(request.getParameter("nit"));
				proveeDto = new proveedoresDTO(nitProv, null, null, null, null);
				proveeDtoRes = proveeDao.consultarnit(proveeDto);
				if(proveeDtoRes!=null) {
					JOptionPane.showMessageDialog(null, "Se encontro el proveedor");
					nitProv=proveeDtoRes.getNit_proveedor();
					nombreProv=proveeDtoRes.getNombre_proveedor();
					ciudadProv=proveeDtoRes.getCiudad_priveedor();
					direcProv=proveeDtoRes.getDireccion_proveedor();
					telProv=proveeDtoRes.getTel_proveedor();
					response.sendRedirect("GestionProveedores.jsp?nit="+nitProv+"&&nom="+nombreProv+"&&ciu="+ciudadProv+"&&dir="+direcProv+"&&tel="+telProv);
				}else {
					JOptionPane.showMessageDialog(null, "No se encontró el proveedor");
					response.sendRedirect("GestionProveedores.jsp");
				}
			} else {
				JOptionPane.showMessageDialog(null, "Ingrese numero de nit");
				response.sendRedirect("GestionProveedores.jsp");
			}
			
		} else if(request.getParameter("btnEditar")!=null) {

			int res;
			if(!request.getParameter("nit").isEmpty()) {
				nitProv=Long.parseLong(request.getParameter("nit"));
				nombreProv=request.getParameter("nombre");
				ciudadProv=request.getParameter("ciudad");
				direcProv=request.getParameter("dir_prov");
				telProv=request.getParameter("tel_prov");
				proveeDto = new proveedoresDTO(nitProv, ciudadProv, nombreProv, telProv, direcProv);
				res = proveeDao.actualizarProv(proveeDto);
				if(res>0) {
					JOptionPane.showMessageDialog(null, "Se actualizo el proveedor: " + nitProv);
					response.sendRedirect("GestionProveedores.jsp");
				} else {
					JOptionPane.showMessageDialog(null, "No se encontró el proveedor");
					response.sendRedirect("GestionProveedores.jsp");
				}
			} else {
					JOptionPane.showMessageDialog(null, "Ingrese numero de nit");
					response.sendRedirect("GestionProveedores.jsp");
			}
		} else if(request.getParameter("btnEliminar")!=null) {
			int res;	
			if(!request.getParameter("nit").isEmpty()) {
				nitProv=Long.parseLong(request.getParameter("nit"));
				proveeDto = new proveedoresDTO(nitProv, null, null, null, null);
				res = proveeDao.eliminarProv(proveeDto);
				if(res>0) {
					JOptionPane.showMessageDialog(null, "Se eliminó el proveedor: " + nitProv);
					response.sendRedirect("GestionProveedores.jsp");
				}else {
					JOptionPane.showMessageDialog(null, "No se encontró el proveedor");
					response.sendRedirect("GestionProveedores.jsp");
				}
			} else {
				JOptionPane.showMessageDialog(null, "Ingrese numero de nit");
				response.sendRedirect("GestionProveedores.jsp");
			}
			
		}
	}

}

