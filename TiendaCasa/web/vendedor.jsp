<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Gestión de Vendedores</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-dark text-white">

    <div class="container mt-5">
        <h1 class="text-info mb-4">Gestión de Vendedores</h1>

        <div class="card bg-dark border-info mb-4">
            <div class="card-body">
                <h5 class="card-title text-info">Añadir/Actualizar Vendedor</h5>
                <form action="Controlador?menu=Vendedor" method="POST">
                    <div class="row">
                        <div class="col-md-6 mb-3">
                            <label for="nombreVendedor" class="form-label">Nombre</label>
                            <input type="text" class="form-control bg-secondary text-white border-info" id="nombreVendedor" name="nombreVendedor" value="${vendedor.nombreVendedor}" required placeholder="Ej: Juan">
                        </div>
                        <div class="col-md-6 mb-3">
                            <label for="apellido" class="form-label">Apellido</label>
                            <input type="text" class="form-control bg-secondary text-white border-info" id="apellido" name="apellido" value="${vendedor.apellido}" required placeholder="Ej: Pérez">
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-6 mb-3">
                            <label for="telefono" class="form-label">Teléfono</label>
                            <input type="text" class="form-control bg-secondary text-white border-info" id="telefono" name="telefono" value="${vendedor.telefono}" required placeholder="Ej: 555-1234">
                        </div>
                        <div class="col-md-6 mb-3">
                            <label for="correo" class="form-label">Correo</label>
                            <input type="email" class="form-control bg-secondary text-white border-info" id="correo" name="correo" value="${vendedor.correo}" required placeholder="Ej: juan.perez@example.com">
                        </div>
                    </div>
                    <input type="hidden" name="codigoVendedor" value="${vendedor.codigoVendedor}">
                    <div class="d-flex justify-content-end mt-3">
                        <button type="submit" name="accion" value="Agregar" class="btn btn-info me-2">Agregar</button>
                        <button type="submit" name="accion" value="Actualizar" class="btn btn-info">Actualizar</button>
                    </div>
                </form>
            </div>
        </div>

        <div class="card bg-dark border-info">
            <div class="card-body">
                <h5 class="card-title text-info">Lista de Vendedores</h5>
                <div class="table-responsive">
                    <table class="table table-dark table-striped table-bordered">
                        <thead>
                            <tr class="text-info">
                                <th>ID</th>
                                <th>Nombre</th>
                                <th>Apellido</th>
                                <th>Teléfono</th>
                                <th>Correo</th>
                                <th>Acciones</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="vendedor" items="${vendedores}">
                                <tr>
                                    <td>${vendedor.codigoVendedor}</td>
                                    <td>${vendedor.nombreVendedor}</td>
                                    <td>${vendedor.apellido}</td>
                                    <td>${vendedor.telefono}</td>
                                    <td>${vendedor.correo}</td>
                                    <td>
                                        <div class="d-flex">
                                            <a href="Controlador?menu=Vendedor&accion=Editar&id=${vendedor.codigoVendedor}" class="btn btn-sm btn-warning me-2">Editar</a>
                                            <a href="Controlador?menu=Vendedor&accion=Eliminar&codigoVendedor=${vendedor.codigoVendedor}" class="btn btn-sm btn-danger" onclick="return confirm('¿Estás seguro de que deseas eliminar a este vendedor?')">Eliminar</a>
                                        </div>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>

    <script src="js/bootstrap.bundle.min.js"></script>
</body>
</html>