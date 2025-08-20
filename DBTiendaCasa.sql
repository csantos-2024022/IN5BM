drop database if exists DBTiendaCasa;
create database DBTiendaCasa;
use DBTiendaCasa;


Create table Inmueble(
	codigoInmueble int auto_increment,
    nombreProducto varchar(50),
    descripcion varchar(150),
    precio varchar(50),
    direccion varchar(100),
    estado varchar(50),
    primary key pk_codigoInmueble(codigoInmueble)
);


Create table Vendedor(
	codigoVendedor int auto_increment,
    nombreVendedor varchar(50),
    apellido varchar(50),
    telefono int,
    correo varchar(150),
    primary key pk_codigoVendedor(codigoVendedor)
);



-- procedimientos almacenados
-- agregar
delimiter //
create procedure sp_agregarInmueble(
    in nombreProducto varchar(50),
    in descripcion varchar(150),
    in precio varchar(50),
    in direccion varchar(100),
    in estado varchar(50)
    )
begin
    insert into Inmueble (nombreProducto, descripcion, precio, direccion, estado)
    values (nombreProducto, descripcion, precio, direccion, estado);
end //
delimiter ;

call sp_agregarInmueble('Casa', 'Casa de dos niveles color rojo','Q80000', 'zona 10', 'En Venta');
call sp_agregarInmueble('Apartamento', 'apartamento de un nivel color verde', 'Q100000', 'zona 9', 'vendida');
call sp_agregarInmueble('Casa', 'casa de ladrillos', 'Q100000', 'zona 10', 'vendida');
call sp_agregarInmueble('Apartamento', 'apartamento en el edificio C-101 zona 14', 'Q200000', 'zona 14', 'En Venta');
call sp_agregarInmueble('Apartamento', 'apartamento grande', 'Q100000', 'zona 6', 'vendida');
call sp_agregarInmueble('Casa', 'casa de un nivel', 'Q100012', 'zona 2', 'vendida');
call sp_agregarInmueble('Casa', 'casa de tres niveles', 'Q150000', 'zona 3', 'vendida');
call sp_agregarInmueble('Apartamento', 'apartamento en zona 14 la cañada', 'Q123789', 'zona 14', 'vendida');
call sp_agregarInmueble('Casa', 'casa de cuatro niveles', 'Q150000', 'zona 12', 'vendida');
call sp_agregarInmueble('Casa', 'casa grande', 'Q100000', 'zona 15', 'vendida');
call sp_agregarInmueble('Apartamento', 'apartamento color blanco', 'Q150000', 'zona 10', 'vendida');

-- listar
Delimiter //
create procedure sp_listarInmueble()
begin
	select codigoInmueble, nombreProducto, descripcion, precio, direccion, estado from Inmueble; 
end //
Delimiter ;
call sp_listarInmueble();


-- buscar
delimiter $$
create procedure sp_buscarInmueble(in codInm int)
begin
    select codigoInmueble, nombreProducto, descripcion, precio, direccion, estado from Inmueble
    where codigoInmueble = codinm;
end $$
delimiter ;
call sp_buscarInmueble(10);

-- editar detalleCompra
delimiter $$
create procedure sp_editarInmueble(
    in p_codigoInmueble int,
    in p_nombreProducto varchar(50),
    in p_descripcion varchar(150),
    in p_precio varchar(50),
    in p_direccion varchar(100),
    in p_estado varchar(50)
)
begin
    update Inmueble
    set nombreProducto = p_nombreProducto,
        descripcion   = p_descripcion,
        precio        = p_precio,
        direccion     = p_direccion,
        estado        = p_estado
    where codigoInmueble = p_codigoInmueble;
end $$
delimiter ;

call sp_editarInmueble(1, 'Casa en la playa', 'Bonita casa frente al mar con 3 habitaciones', '250000', 'Avenida Costera #123', 'Disponible' );

delimiter //
CREATE PROCEDURE sp_eliminarInmueble(
    IN _codigoInmueble INT
)
BEGIN
    DELETE FROM Inmueble
    WHERE
        codigoInmueble = _codigoInmueble;
END //
delimiter ;


-- VENDEDOR ------------------------------------------------------
DELIMITER //

CREATE PROCEDURE sp_ListarVendedor()
BEGIN
    SELECT * FROM Vendedor;
END //
delimiter ;
call sp_ListarVendedor();
delimiter //
CREATE PROCEDURE sp_AgregarVendedor(
    IN _nombreVendedor VARCHAR(50),
    IN _apellido VARCHAR(50),
    IN _telefono INT,
    IN _correo VARCHAR(150)
)
BEGIN
    INSERT INTO Vendedor (nombreVendedor, apellido, telefono, correo)
    VALUES (_nombreVendedor, _apellido, _telefono, _correo);
END //
delimiter ;
CALL sp_AgregarVendedor('Ana', 'García', 5551111, 'ana.garcia@example.com');
CALL sp_AgregarVendedor('Luis', 'Ramírez', 5552222, 'luis.ramirez@example.com');
CALL sp_AgregarVendedor('Sofía', 'Martínez', 5553333, 'sofia.martinez@example.com');
CALL sp_AgregarVendedor('Carlos', 'López', 5554444, 'carlos.lopez@example.com');
CALL sp_AgregarVendedor('Elena', 'Díaz', 5555555, 'elena.diaz@example.com');
CALL sp_AgregarVendedor('Javier', 'Sánchez', 5556666, 'javier.sanchez@example.com');
CALL sp_AgregarVendedor('María', 'Fernández', 5557777, 'maria.fernandez@example.com');
CALL sp_AgregarVendedor('David', 'Pérez', 5558888, 'david.perez@example.com');
CALL sp_AgregarVendedor('Laura', 'Gómez', 5559999, 'laura.gomez@example.com');
CALL sp_AgregarVendedor('Jorge', 'Jiménez', 5550000, 'jorge.jimenez@example.com');

delimiter //
CREATE PROCEDURE sp_EditarVendedor(
    IN _codigoVendedor INT,
    IN _nombreVendedor VARCHAR(50),
    IN _apellido VARCHAR(50),
    IN _telefono INT,
    IN _correo VARCHAR(150)
)
BEGIN
    UPDATE Vendedor SET
        nombreVendedor = _nombreVendedor,
        apellido = _apellido,
        telefono = _telefono,
        correo = _correo
    WHERE codigoVendedor = _codigoVendedor;
END //
delimiter ;


delimiter //
CREATE PROCEDURE sp_EliminarVendedor(
    IN _codigoVendedor INT
)
BEGIN
    DELETE FROM Vendedor WHERE codigoVendedor = _codigoVendedor;
END //

DELIMITER ;





