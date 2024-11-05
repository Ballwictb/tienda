package Servlet;

import Clases.Producto;
import Clases.Productos;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class ManejoTienda
 */
@WebServlet("/ManejoTienda")
public class ManejoTienda extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ManejoTienda() {
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
		String action = request.getParameter("action");

		if ("comprar".equals(action)) {
			int id = Integer.parseInt(request.getParameter("id"));
			Productos.comprarProducto(id);
			response.sendRedirect("comprarProductos.jsp");
		} else {
			response.getWriter().append("Acción no válida");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action");

		if ("crear".equals(action)) {
			String nombre = request.getParameter("nombre");
			int precio = Integer.parseInt(request.getParameter("precio"));
			String imagen = request.getParameter("imagen");
			int stock = Integer.parseInt(request.getParameter("stock"));
			boolean renovar = request.getParameter("renovar") != null;

			Producto producto = new Producto(nombre, precio, imagen, stock,renovar);
			Productos.agregarProducto(producto);
			response.sendRedirect("index.jsp");
		} else {
			response.getWriter().append("Acción no valida");
		}
	}
}
