package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;
import model.ventasDAO;
import model.ventasDTO;

/**
 * Servlet implementation class servletGestionUsu
 */
@WebServlet("/servletVentas")
public class servletVentas extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public servletVentas() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		long cedusu, iva_vent, tot_vent, valor_vent, cedclient;
		ventasDTO ventDto;
		ventasDAO ventDao = new ventasDAO();

		if (request.getParameter("btnInsertar") != null) {

			if (!request.getParameter("cedula").isEmpty()) {
				cedusu = Long.parseLong(request.getParameter("cedula"));
				iva_vent = Long.parseLong(request.getParameter("Total_iva"));
				tot_vent = Long.parseLong(request.getParameter("Total_venta"));
				valor_vent = Long.parseLong(request.getParameter("Total_coniva"));
				cedclient = Long.parseLong(request.getParameter("cliente"));

				ventDto = new ventasDTO(cedclient, cedusu, iva_vent, valor_vent, tot_vent);
				Boolean result = ventDao.insertar_venta(ventDto);
				if (result) {
					JOptionPane.showMessageDialog(null, "Se agrego correctamente el cliente");
					response.sendRedirect("GestionClientes.jsp");
				} else {
					JOptionPane.showMessageDialog(null, "No se agrego el cliente");
					response.sendRedirect("GestionClientes.jsp");
				}
			} else {
				JOptionPane.showMessageDialog(null, "Ingrese numero de cedula");
				response.sendRedirect("GestionClientes.jsp");
			}
		}
	}

}
