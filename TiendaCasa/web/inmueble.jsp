<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Gestión de Inmuebles</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-dark text-white">

    <div class="container mt-5">
        <h1 class="text-warning mb-4">Gestión de Inmuebles</h1>

        <div class="card bg-dark border-warning mb-4">
            <div class="card-body">
                <h5 class="card-title text-warning">Añadir/Actualizar Inmueble</h5>
                    <form action="Controlador?menu=Inmueble" method="POST">
                        <div class="row">
                            <div class="col-md-6 mb-3">
                                <label for="nombreProducto" class="form-label">Nombre Producto</label>
                                <input type="text" class="form-control bg-secondary text-white border-warning" id="nombreProducto" name="nombreProducto" value="${inmueble.nombreProducto}" required placeholder="Nombre Del Inmueble">
                            </div>
                            <div class="col-md-6 mb-3">
                                <label for="descripcion" class="form-label">Descripción</label>
                                <input type="text" class="form-control bg-secondary text-white border-warning" id="descripcion" name="descripcion" value="${inmueble.descripcion}" required placeholder="Descripcion">
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-4 mb-3">
                                <label for="precio" class="form-label">Precio</label>
                                <input type="text" class="form-control bg-secondary text-white border-warning" id="precio" name="precio" value="${inmueble.precio}" required placeholder="Precio">
                            </div>
                            <div class="col-md-4 mb-3">
                                <label for="direccion" class="form-label">Dirección</label>
                                <input type="text" class="form-control bg-secondary text-white border-warning" id="direccion" name="direccion" value="${inmueble.direccion}" required placeholder="Lugar">
                            </div>
                            <div class="col-md-4 mb-3">
                                <label for="estado" class="form-label">Estado</label>
                                <input type="text" class="form-control bg-secondary text-white border-warning" id="estado" name="estado" value="${inmueble.estado}" required placeholder="Estado">
                            </div>
                        </div>
                        <input type="hidden" name="codigoInmueble" value="${inmueble.codigoInmueble}">
                        <div class="d-flex justify-content-end mt-3">
                            <button type="submit" name="accion" value="Agregar" class="btn btn-warning me-2">Agregar</button>
                            <button type="submit" name="accion" value="Actualizar" class="btn btn-warning">Actualizar</button>
                        </div>
                    </form>
            </div>
        </div>

        <div class="card bg-dark border-warning">
            <div class="card-body">
                <h5 class="card-title text-warning">Lista de Inmuebles</h5>
                <div class="table-responsive">
                    <table class="table table-dark table-striped table-bordered">
                        <thead>
                            <tr class="text-warning">
                                <th>ID</th>
                                <th>Nombre</th>
                                <th>Descripción</th>
                                <th>Precio</th>
                                <th>Dirección</th>
                                <th>Estado</th>
                                <th>Acciones</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="inmueble" items="${inmuebles}">
                                <tr>
                                    <td>${inmueble.codigoInmueble}</td>
                                    <td>${inmueble.nombreProducto}</td>
                                    <td>${inmueble.descripcion}</td>
                                    <td>${inmueble.precio}</td>
                                    <td>${inmueble.direccion}</td>
                                    <td>${inmueble.estado}</td>
                                    <td>
                                        <div class="d-flex">
                                            <a href="Controlador?menu=Inmueble&accion=Editar&id=${inmueble.codigoInmueble}" class="btn btn-sm btn-info me-2">Editar</a>
                                            <a href="Controlador?menu=Inmueble&accion=Eliminar&codigoInmueble=${inmueble.codigoInmueble}" class="btn btn-sm btn-danger" onclick="return confirm('¿Estás seguro de que deseas eliminar este inmueble?')">Eliminar</a>
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