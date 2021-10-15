package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;

import model.clientesDAO;
import model.clientesDTO;

/**
 * Servlet implementation class servletGestionUsu
 */
@WebServlet("/servletReportesCli")
public class servletReportesCli extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servletReportesCli() {
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
	
		ArrayList<clientesDTO> lista = new ArrayList<>();
		clientesDAO clientDao = new clientesDAO();
		lista = clientDao.consultaGral();
		Gson gson = new Gson();
		mostrarInfo.print(gson.toJson(lista));
		}
}
