package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

/**
 * Servlet implementation class Contralador1
 */
@WebServlet("/Servletlogin")
public class Servletlogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servletlogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String u,c;
		u=request.getParameter("usu");
		c=request.getParameter("pass");
		if (u.equals("admininicial")&& c.equals("admin123456")) {
			JOptionPane.showMessageDialog(null, "Datos correctos");
			response.sendRedirect("Menu principal.jsp?dat="+u);
		}
	
	else {
		JOptionPane.showMessageDialog(null, "Datos incorrectos");
		response.sendRedirect("index.jsp");
	}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String u,c;
				u=request.getParameter("usu");
				c=request.getParameter("pass");
				if (u.equals( "admininicial")&& c.equals("admin123456")) {
					JOptionPane.showMessageDialog(null, "Datos correctos");
					response.sendRedirect("Menu principal.jsp?dat="+u);
				}
			
			else {
				JOptionPane.showMessageDialog(null, "Datos incorrectos");
				response.sendRedirect("Index.jsp");
			}
	}

}
