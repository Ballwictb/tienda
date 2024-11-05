<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="./css/crearProducto.css">
</head>
<body>
 <h2>Insertar Producto</h2>
    <form action="ManejoTienda" method="post">
        <input type="hidden" name="action" value="crear">
        <label for="nombre">Nombre: </label>
        <input type="text" id="nombre" name="nombre" required><br>
		<label for="precio">Precio: </label>
        <input type="text" id="precio" name="precio" required><br>
        <label for="imagen">Imagen URL: </label>
        <input type="text" id="imagen" name="imagen" required><br>
        <label for="stock">Stock: </label>
        <input type="text" id="stock" name="stock" required><br>
        <label for="renovar">Renovar Automaticamente</label>        
        <input type="checkbox" id="renovar" name="renovar">
        <input type="submit" value="Insertar">
    </form>
    <a href="./index.jsp">Volver</a>
</body>
</html>