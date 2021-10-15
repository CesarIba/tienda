package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;
import model.detalleventasDAO;
import model.detalleventasDTO;
import model.ventasDAO;
import model.ventasDTO;
import model.productosDTO;
import model.productosDAO;
import model.clientesDAO;
import model.clientesDTO;

/**
 * Servlet implementation class servletGestionUsu
 */
@WebServlet("/servletVentas")
public class servletVentas extends HttpServlet {
	private static final long serialVersionUID = 1L;
	double iva1, iva2, iva3;
	int cant1, cant2, cant3;

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

		HttpSession sesion = request.getSession();

		if (request.getParameter("btnConsultar") != null) {
			long cedula;

			clientesDTO clientDTO;
			cedula = Long.parseLong(request.getParameter("cedCli"));
			clientesDAO clidao = new clientesDAO();
			clientesDTO clidto = new clientesDTO(cedula);
			clientDTO = clidao.consultarId(clidto);
			sesion.setAttribute("cliente", clientDTO);
			request.getRequestDispatcher("GestionVentas.jsp").forward(request, response);
		}

		if (request.getParameter("btnConsulprod1") != null) {

			long codpro;
			productosDTO listapro;
			codpro = Long.parseLong(request.getParameter("cod_prod1"));
			productosDTO podto = new productosDTO(codpro);
			productosDAO prodao = new productosDAO();
			listapro = prodao.consultarProd(podto);
			iva1 = listapro.getIva_compra();
			sesion.setAttribute("producto1", listapro);
			request.getRequestDispatcher("GestionVentas.jsp").forward(request, response);
		}

		if (request.getParameter("btnConsulprod2") != null) {
			long codpro;
			productosDTO listapro1;
			codpro = Long.parseLong(request.getParameter("cod_prod2"));
			productosDTO podto = new productosDTO(codpro);
			productosDAO prodao = new productosDAO();
			listapro1 = prodao.consultarProd(podto);
			iva2 = listapro1.getIva_compra();
			sesion.setAttribute("producto2", listapro1);
			request.getRequestDispatcher("GestionVentas.jsp").forward(request, response);
		}
		if (request.getParameter("btnConsulprod3") != null) {
			long codpro;
			productosDTO listapro2;
			codpro = Long.parseLong(request.getParameter("cod_prod3"));
			productosDTO podto = new productosDTO(codpro);
			productosDAO prodao = new productosDAO();
			listapro2 = prodao.consultarProd(podto);
			iva3 = listapro2.getIva_compra();

			sesion.setAttribute("producto3", listapro2);
			request.getRequestDispatcher("GestionVentas.jsp").forward(request, response);
		}

		double tot, tot1, tot2, res, res1, res2, totalsiniva, totaliva, totaldesiva;

		if (request.getParameter("btnCotizar") != null) {
			double total1, total2, total3;

			cant1 = Integer.parseInt(request.getParameter("cant_prod1"));
			cant2 = Integer.parseInt(request.getParameter("cant_prod2"));
			cant3 = Integer.parseInt(request.getParameter("cant_prod3"));

			tot = Double.parseDouble(request.getParameter("valor_prod1"));
			tot1 = Double.parseDouble(request.getParameter("valor_prod2"));
			tot2 = Double.parseDouble(request.getParameter("valor_prod3"));

			res = cant1 * tot;
			res1 = cant2 * tot1;
			res2 = cant3 * tot2;
			total1 = res * iva1 / 100;
			total2 = res1 * iva2 / 100;
			total3 = res2 * iva3 / 100;
			totalsiniva = res + res1 + res2;
			totaliva = total1 + total2 + total3;
			totaldesiva = totalsiniva + totaliva;

			ventasDTO cotVen = new ventasDTO(Long.parseLong(request.getParameter("cedCli")),
					Long.parseLong(request.getParameter("cedUsu")), totaliva, totaldesiva, totalsiniva);
			sesion.setAttribute("cant1", cant1);
			sesion.setAttribute("cant2", cant2);
			sesion.setAttribute("cant3", cant3);
			sesion.setAttribute("CotVenta", cotVen);
			request.getRequestDispatcher("GestionVentas.jsp").forward(request, response);
		}

		if (request.getParameter("btnInsertar") != null) {
			double total1, total2, total3;

			cant1 = Integer.parseInt(request.getParameter("cant_prod1"));
			cant2 = Integer.parseInt(request.getParameter("cant_prod2"));
			cant3 = Integer.parseInt(request.getParameter("cant_prod3"));

			tot = Double.parseDouble(request.getParameter("valor_prod1"));
			tot1 = Double.parseDouble(request.getParameter("valor_prod2"));
			tot2 = Double.parseDouble(request.getParameter("valor_prod3"));

			res = cant1 * tot;
			res1 = cant2 * tot1;
			res2 = cant3 * tot2;
			total1 = res * iva1 / 100;
			total2 = res1 * iva2 / 100;
			total3 = res2 * iva3 / 100;
			totalsiniva = res + res1 + res2;
			totaliva = total1 + total2 + total3;
			totaldesiva = totalsiniva + totaliva;

			int i = JOptionPane.showConfirmDialog(null,
					"Art1 " + res + "\n" + "Art2 " + res1 + "\n" + "Art3 " + res2 + "\n" + "\nIVA " + total1 + "\n"
							+ "IVA2 " + total2 + "\n" + "IVA3 " + total3 + "\n" + "\nTotal sin IVA  " + totalsiniva
							+ "\n" + "TOTAL IVA " + totaliva + "\n" + "Total a pagar " + totaldesiva + "\n");
			// JOptionPane.showMessageDialog(null, "impriendo la i"+i);
			if (i == 0) {
				String cedcli, cedusu;
				long cc, cu;
				double tv, vv;
				boolean ress;
				cedcli = (request.getParameter("cedCli"));
				cedusu = (request.getParameter("cedUsu"));
				tv = totalsiniva;
				vv = totaldesiva;
				cc = Long.parseLong(cedcli);
				cu = Long.parseLong(cedusu);
				ventasDTO ven = new ventasDTO(cc, cu, totaliva, tv, vv);
				ventasDAO vendao = new ventasDAO();
				ress = vendao.insertar_venta(ven);
				if (ress) {
					JOptionPane.showMessageDialog(null, "Venta registrada");
					int can;
					long cv;
					double dtv;
					boolean x;
					ventasDTO venn;
					detalleventasDTO dd;
					detalleventasDAO dedao;
					long codpro = Long.parseLong(request.getParameter("cod_prod1"));
					long codpro2 = Long.parseLong(request.getParameter("cod_prod2"));
					long codpro3 = Long.parseLong(request.getParameter("cod_prod3"));
					ventasDAO vend = new ventasDAO();
					venn = vend.consultarcodventa();

					can = cant1;
					if (can > 0) {

						cv = venn.getCodigo();
						dtv = res+total1;
						dd = new detalleventasDTO(can, codpro, cv, res, dtv, total1);
						dedao = new detalleventasDAO();
						x = dedao.insertar_detventa(dd);
						if (x) {
							//JOptionPane.showMessageDialog(null, "detalle insertado");
						}
					}

					else {
						JOptionPane.showMessageDialog(null, "No inserto detalle 1");
					}
					can = cant2;
					if (can > 0) {

						cv = venn.getCodigo();
						dtv = res1+total2;
						dd = new detalleventasDTO(can, codpro2, cv, res1, dtv, total2);
						dedao = new detalleventasDAO();
						x = dedao.insertar_detventa(dd);
						if (x) {
							//JOptionPane.showMessageDialog(null, "detalle insertado");
						}
					} else {
						JOptionPane.showMessageDialog(null, "No inserto detalle 2");
					}
					can = cant3;
					if (can > 0) {

						cv = venn.getCodigo();
						dtv = res2+total3;
						dd = new detalleventasDTO(can, codpro3, cv, res2, dtv, total3);
						dedao = new detalleventasDAO();
						x = dedao.insertar_detventa(dd);
						if (x) {
							//JOptionPane.showMessageDialog(null, "detalle insertado");
							JOptionPane.showMessageDialog(null, "Gracias por comprar con nosotros!!!");
							response.sendRedirect("Menu principal.jsp");
						}
					} else {
						JOptionPane.showMessageDialog(null, "No inserto detalle 3");
					}

				} else {
					JOptionPane.showMessageDialog(null, "Venta NO registrada");
				}

			}
			sesion.invalidate();
		}
	}
}
