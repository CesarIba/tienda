package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

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
		
		String nombreUsu,mailUsu,usuario,claveUsu;
		long cedulaUsu;
		usuariosDTO usuDto;
		usuariosDAO usuDao = new usuariosDAO();
		if(request.getParameter("btnInsertar")!=null) {

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
			}
			
		}
	}

}
