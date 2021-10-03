package controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.swing.JOptionPane;

import com.google.gson.Gson;

import model.productosDAO;
import model.usuariosDAO;
import model.usuariosDTO;

/**
 * Servlet implementation class servletGestionUsu
 */
@WebServlet("/servletProductos")
@MultipartConfig
public class servletProductos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servletProductos() {
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
		
		Part archivo = request.getPart("urlArchivo");
		String nomArchivo = request.getParameter("nomArchivo");
		String Url = "C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/"+nomArchivo+".csv";
		
		if(request.getParameter("btnCargar")!=null) {
			try {
				InputStream file = archivo.getInputStream();
				File copia= new File(Url);
				FileOutputStream escribir= new FileOutputStream(copia);
				int num=file.read();
				while(num !=-1) {
					escribir.write(num);
					num=file.read();
				}
				file.close();
				escribir.close();
				JOptionPane.showMessageDialog(null, "El archivo se cargo exitosamente");
				
				boolean res;
				productosDAO prodDao=new productosDAO();
				res=prodDao.insertar_Productos(Url);
				if(res) {
					JOptionPane.showMessageDialog(null, "Productos cargados en BD exitosamente");
					response.sendRedirect("GestionProductos.jsp");
				}else {
					JOptionPane.showMessageDialog(null, "Error al cargar productos en BD");
					response.sendRedirect("GestionProductos.jsp");
				}
			}catch(Exception e) {
				JOptionPane.showMessageDialog(null, "Error al cargar archivo");
				response.sendRedirect("GestionProductos.jsp");
			}
		}
		
		
	}

}
