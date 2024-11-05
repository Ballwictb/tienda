<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="Clases.Producto"%>
<%@ page import="Clases.Productos"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="./css/comprarProducto.css">

</head>
<body>
	<h2>Comprar Productos</h2>
	<%
	Productos productos = new Productos();
	%>
	<table>
		<tr>
			<th>Nombre</th>
			<th>Precio</th>
			<th>Stock</th>
			<th>Imagen</th>
		</tr>
		<%
		List<Producto> productosListados = productos.listarProductos();
		for (int i = 0; i < productosListados.size(); i++) {
			Producto producto = productosListados.get(i);
		%>
		<tr>
			<td><%=producto.getNombre()%></td>
			<td><%=producto.getPrecio()%> €</td>
			<td><%=producto.getStock()%></td>
			<td><a
				href="ManejoTienda?action=comprar&id=<%=producto.getId()%>"> <img
					src="<%=producto.getImagen()%>" width="100" height="100">
			</a></td>
		</tr>
		<%
		}
		%>
	</table>
	<a class="volver" href="./index.jsp">Volver</a>
</body>
</html>