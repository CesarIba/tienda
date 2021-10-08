package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import com.google.gson.Gson;

import model.usuariosDAO;
import model.usuariosDTO;

/**
 * Servlet implementation class servletGestionUsu
 */
@WebServlet("/servletGestionUsu")
public class servletGestionUsu extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servletGestionUsu() {
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
		
		PrintWriter mostrarInfo=response.getWriter();
		String nombreUsu,mailUsu,usuario,claveUsu;
		long cedulaUsu;
		usuariosDTO usuDto, usuDtoRes;
		usuariosDAO usuDao = new usuariosDAO();

		if(request.getParameter("btnInsertar")!=null) {

			if(!request.getParameter("cedula").isEmpty()) {
				cedulaUsu=Long.parseLong(request.getParameter("cedula"));
				nombreUsu=request.getParameter("nombre");
				mailUsu=request.getParameter("email");
				usuario=request.getParameter("usuario");
				claveUsu=request.getParameter("clave");
				
				usuDto = new usuariosDTO(cedulaUsu, mailUsu, nombreUsu, claveUsu, usuario);
				Boolean result = usuDao.insertar_usuario(usuDto);
				if(result) {
					JOptionPane.showMessageDialog(null, "Se agrego correctamente el usuario");
					response.sendRedirect("index.jsp");
				}else {
					JOptionPane.showMessageDialog(null, "No se agrego el usuario");
					response.sendRedirect("GestionUsuarios.jsp");
				}
			} else {
				JOptionPane.showMessageDialog(null, "Ingrese numero de cedula");
				response.sendRedirect("GestionUsuarios.jsp");
			}
			
		} else if(request.getParameter("btnConsultar")!=null) {

			if(!request.getParameter("cedula").isEmpty()) {
				cedulaUsu=Long.parseLong(request.getParameter("cedula"));
				usuDto = new usuariosDTO(cedulaUsu, null, null, null, null);
				usuDtoRes = usuDao.consultarId(usuDto);
				if(usuDtoRes!=null) {
					JOptionPane.showMessageDialog(null, "Se encontro al usuario");
					cedulaUsu=usuDtoRes.getCedula_usuario();
					nombreUsu=usuDtoRes.getNombre_usuario();
					mailUsu=usuDtoRes.getMail_usuario();
					usuario=usuDtoRes.getUsuario();
					claveUsu=usuDtoRes.getClave();
					response.sendRedirect("GestionUsuarios.jsp?ced="+cedulaUsu+"&&nom="+nombreUsu+"&&mail="+mailUsu+"&&usu="+usuario+"&&clv="+claveUsu);
				}else {
					JOptionPane.showMessageDialog(null, "No se encontró el usuario");
					response.sendRedirect("GestionUsuarios.jsp");
				}
			} else {
				JOptionPane.showMessageDialog(null, "Ingrese numero de cedula");
				response.sendRedirect("GestionUsuarios.jsp");
			}
			
		} else if(request.getParameter("btnEditar")!=null) {

			int res;
			if(!request.getParameter("cedula").isEmpty()) {
				cedulaUsu=Long.parseLong(request.getParameter("cedula"));
				nombreUsu=request.getParameter("nombre");
				mailUsu=request.getParameter("email");
				usuario=request.getParameter("usuario");
				claveUsu=request.getParameter("clave");
				usuDto = new usuariosDTO(cedulaUsu, mailUsu, nombreUsu, claveUsu, usuario);
				res = usuDao.actualizarUsu(usuDto);
				if(res>0) {
					JOptionPane.showMessageDialog(null, "Se actualizo al usuario: " + cedulaUsu);
					response.sendRedirect("GestionUsuarios.jsp");
				} else {
					JOptionPane.showMessageDialog(null, "No se encontró el usuario");
					response.sendRedirect("GestionUsuarios.jsp");
				}
			} else {
					JOptionPane.showMessageDialog(null, "Ingrese numero de cedula");
					response.sendRedirect("GestionUsuarios.jsp");
			}
		} else if(request.getParameter("btnEliminar")!=null) {
			int res;	
			if(!request.getParameter("cedula").isEmpty()) {
				cedulaUsu=Long.parseLong(request.getParameter("cedula"));
				usuDto = new usuariosDTO(cedulaUsu, null, null, null, null);
				res = usuDao.eliminarUsu(usuDto);
				if(res>0) {
					JOptionPane.showMessageDialog(null, "Se eliminó al usuario: " + cedulaUsu);
					response.sendRedirect("GestionUsuarios.jsp");
				}else {
					JOptionPane.showMessageDialog(null, "No se encontró el usuario");
					response.sendRedirect("GestionUsuarios.jsp");
				}
			} else {
				JOptionPane.showMessageDialog(null, "Ingrese numero de cedula");
				response.sendRedirect("GestionUsuarios.jsp");
			}
		}
	}
}
