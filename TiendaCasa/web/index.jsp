<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Essenza & Co. | Sistema de Gestión de Inmuebles y Vendedores</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="Style/carrusel.css">
</head>
<body>
    <header>
        <h1 class="mensajeBienvenida">Bienvenido al gestión de Venta de casas y apartamentos</h1>
    </header>
    <nav>
        <ul>
            <li><a href="Controlador?menu=Inmueble&accion=Listar" target="contenido">Inmuebles</a></li>
            <li><a href="Controlador?menu=Vendedor&accion=Listar" target="contenido">Vendedores</a></li>
            <li class="avatar"></li>
        </ul>
    </nav>

    <div class="contenido">
        <div id="carouselExampleControls" class="carousel slide" data-bs-ride="carousel">
            <div class="carousel-inner">
                <div class="carousel-item active">
                    <img src="img/imagenCasa1.jpg" class="d-block w-100" alt="Casa 1">
                </div>
                <div class="carousel-item">
                    <img src="img/imagenCasa2.jpg" class="d-block w-100" alt="Casa 2">
                </div>
                <div class="carousel-item">
                    <img src="img/imagenCasa3.jpg" class="d-block w-100" alt="Casa 3">
                </div>
                <div class="carousel-item">
                    <img src="img/imagenCasa4.jpg" class="d-block w-100" alt="Casa 4">
                </div>
                <div class="carousel-item">
                    <img src="img/imagenCasa5.jpg" class="d-block w-100" alt="Casa 5">
                </div>
                <div class="carousel-item">
                    <img src="img/imagenCasa6.jpg" class="d-block w-100" alt="Casa 6">
                </div>
                <div class="carousel-item">
                    <img src="img/imagenCasa7.jpg" class="d-block w-100" alt="Casa 7">
                </div>
                <div class="carousel-item">
                    <img src="img/imagenCasa8.jpg" class="d-block w-100" alt="Casa 8">
                </div>
                <div class="carousel-item">
                    <img src="img/imagenCasa9.jpg" class="d-block w-100" alt="Casa 9">
                </div>
                <div class="carousel-item">
                    <img src="img/imagenCasa10.jpg" class="d-block w-100" alt="Casa 10">
                </div>
            </div>
            <button class="carousel-control-prev custom-control" type="button" data-bs-target="#carouselExampleControls" data-bs-slide="prev">
                <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                <span class="visually-hidden">Anterior</span>
            </button>
            <button class="carousel-control-next custom-control" type="button" data-bs-target="#carouselExampleControls" data-bs-slide="next">
                <span class="carousel-control-next-icon" aria-hidden="true"></span>
                <span class="visually-hidden">Siguiente</span>
            </button>
        </div>
        <iframe name="contenido" style="width: 100%; height: 600px; border: none;"></iframe>
    </div>

    <div class="panel">
        <h2>Bienvenido a la ventana de Administrador</h2>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>