package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import model.clientesDAO;
import model.clientesDTO;

/**
 * Servlet implementation class servletGestionUsu
 */
@WebServlet("/servletGestionClient")
public class servletGestionClient extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servletGestionClient() {
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
		
		String nombreCli,mailCli,direcCli,telClient;
		long cedulaCli;
		clientesDTO clientDto, clientDtoRes;
		clientesDAO clientDao = new clientesDAO();

		if(request.getParameter("btnInsertar")!=null) {

			if(!request.getParameter("cedula").isEmpty()) {
				cedulaCli=Long.parseLong(request.getParameter("cedula"));
				nombreCli=request.getParameter("nombre");
				mailCli=request.getParameter("email");
				direcCli=request.getParameter("dir_cli");
				telClient=request.getParameter("tel_cli");
				
				clientDto = new clientesDTO(cedulaCli, direcCli, mailCli, nombreCli, telClient);
				Boolean result = clientDao.insertar_cliente(clientDto);
				if(result) {
					JOptionPane.showMessageDialog(null, "Se agrego correctamente el cliente");
					response.sendRedirect("GestionClientes.jsp");
				}else {
					JOptionPane.showMessageDialog(null, "No se agrego el cliente");
					response.sendRedirect("GestionClientes.jsp");
				}
			} else {
				JOptionPane.showMessageDialog(null, "Ingrese numero de cedula");
				response.sendRedirect("GestionClientes.jsp");
			}
			
		} else if(request.getParameter("btnConsultar")!=null) {

			if(!request.getParameter("cedula").isEmpty()) {
				cedulaCli=Long.parseLong(request.getParameter("cedula"));
				clientDto = new clientesDTO(cedulaCli, null, null, null, null);
				clientDtoRes = clientDao.consultarId(clientDto);
				if(clientDtoRes!=null) {
					JOptionPane.showMessageDialog(null, "Se encontro al cliente");
					cedulaCli=clientDtoRes.getCedula_cliente();
					nombreCli=clientDtoRes.getNombre_cliente();
					mailCli=clientDtoRes.getMail_cliente();
					direcCli=clientDtoRes.getDireccion_cliente();
					telClient=clientDtoRes.getTel_cliente();
					response.sendRedirect("GestionClientes.jsp?ced="+cedulaCli+"&&nom="+nombreCli+"&&mail="+mailCli+"&&dir="+direcCli+"&&tel="+telClient);
				}else {
					JOptionPane.showMessageDialog(null, "No se encontró el cliente");
					response.sendRedirect("GestionClientes.jsp");
				}
			} else {
				JOptionPane.showMessageDialog(null, "Ingrese numero de cedula");
				response.sendRedirect("GestionClientes.jsp");
			}
			
		} else if(request.getParameter("btnEditar")!=null) {

			int res;
			if(!request.getParameter("cedula").isEmpty()) {
				cedulaCli=Long.parseLong(request.getParameter("cedula"));
				nombreCli=request.getParameter("nombre");
				mailCli=request.getParameter("email");
				direcCli=request.getParameter("dir_cli");
				telClient=request.getParameter("tel_cli");
				clientDto = new clientesDTO(cedulaCli, direcCli,mailCli, nombreCli, telClient);
				res = clientDao.actualizarCli(clientDto);
				if(res>0) {
					JOptionPane.showMessageDialog(null, "Se actualizo al cliente: " + cedulaCli);
					response.sendRedirect("GestionClientes.jsp");
				} else {
					JOptionPane.showMessageDialog(null, "No se encontró el cliente");
					response.sendRedirect("GestionClientes.jsp");
				}
			} else {
					JOptionPane.showMessageDialog(null, "Ingrese numero de cedula");
					response.sendRedirect("GestionClientes.jsp");
			}
		} else if(request.getParameter("btnEliminar")!=null) {
			int res;	
			if(!request.getParameter("cedula").isEmpty()) {
				cedulaCli=Long.parseLong(request.getParameter("cedula"));
				clientDto = new clientesDTO(cedulaCli, null, null, null, null);
				res = clientDao.eliminarCli(clientDto);
				if(res>0) {
					JOptionPane.showMessageDialog(null, "Se eliminó al cliente: " + cedulaCli);
					response.sendRedirect("GestionClientes.jsp");
				}else {
					JOptionPane.showMessageDialog(null, "No se encontró el cliente");
					response.sendRedirect("GestionClientes.jsp");
				}
			} else {
				JOptionPane.showMessageDialog(null, "Ingrese numero de cedula");
				response.sendRedirect("GestionClientes.jsp");
			}
			
		}
	}

}
