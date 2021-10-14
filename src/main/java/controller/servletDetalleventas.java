package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import model.detalleventasDAO;
import model.detalleventasDTO;

/**
 * Servlet implementation class servletGestionUsu
 */
@WebServlet("/servletDetalleventas")
public class servletDetalleventas extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public servletDetalleventas() {
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

		int cantprodDetv;
		long codprodDetv, codventDetv; 
		double valtotDetv, valventDetv, valivaDetv;
		detalleventasDTO detventasDto, detventasDtoRes;
		detalleventasDAO detventasDao = new detalleventasDAO();

		if (request.getParameter("btnInsertar") != null) {

			if (!request.getParameter("cant_producto").isEmpty()) {
				cantprodDetv = Integer.parseInt(request.getParameter("cant_producto"));
				codprodDetv = Long.parseLong(request.getParameter("cod_producto"));
				codventDetv = Long.parseLong(request.getParameter("cod_venta"));
				valtotDetv = Double.parseDouble(request.getParameter("valor_total"));
				valventDetv = Double.parseDouble(request.getParameter("valor_venta"));
				valivaDetv = Double.parseDouble(request.getParameter("valor_iva"));

				detventasDto = new detalleventasDTO(cantprodDetv, codprodDetv, codventDetv, valtotDetv, valventDetv,
						valivaDetv);
				Boolean result = detventasDao.insertar_detventa(detventasDto);
				if (result) {
					JOptionPane.showMessageDialog(null, "Se agregaron correctamente los detalles");
					// response.sendRedirect("GestionClientes.jsp");
				} else {
					JOptionPane.showMessageDialog(null, "No se agregon los detalles");
					// response.sendRedirect("GestionClientes.jsp");
				}
			} /*
				 * else { JOptionPane.showMessageDialog(null, "Ingrese numero de cedula");
				 * response.sendRedirect("GestionClientes.jsp"); }
				 */
		}
	}
}
