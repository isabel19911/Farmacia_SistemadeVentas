create database db_farmacia;
use db_farmacia;


create table tb_usuario(
IdUsuario int(11) auto_increment primary key,
nombre varchar(30) not null,
apellido varchar(30) not null,
usuario varchar(15) not null,
password varchar(15) not null,
telefono varchar(15) not null,
estado int(1) not null
);
select * from tb_usuario;

insert into tb_usuario(nombre, apellido, usuario, password, telefono, estado)
values ("Joel", "Zarpan", "joel", "12345", "904610451",1);

select usuario, password from tb_usuario where usuario = "joel" and password= "12345";

select * from tb_usuario;


-- tabla clientes
create table tb_cliente(
IdCliente int(11) auto_increment primary key,
nombre varchar(30) not null,
apellido varchar(30) not null,
DNI varchar(8) not null,
telefono varchar(15) not null,
direccion varchar(100) not null,
estado int(1) not null
);
select * from tb_cliente;


-- tabla categoria
create table tb_categoria(
IdCategoria int(11) auto_increment primary key,
descripcion varchar(200) not null,
estado int(30) not null
);
select * from tb_categoria;
truncate table tb_categoria;
select cv.IdCabeceraVenta as id, concat(c.nombre, '', c.apellido) as cliente, cv.valorPagar as total, cv.fechaVenta as fecha, cv.estado from tb_Cabecera_venta as cv, tb_cliente as c where cv.IdCliente = c.IdCliente;

select cv.IdCabeceraVenta, cv.IdCliente, concat(c.nombre, '', c.apellido) as cliente, cv.valorPagar, cv.fechaVenta, cv.estado from tb_Cabecera_venta as cv, tb_cliente as c where cv.IdCabeceraVenta = 3 and cv.IdCliente = c.IdCliente;


-- tabla producto
create table tb_producto(
IdProducto int(11) auto_increment primary key,
nombre varchar(100) not null,
cantidad int(11) not null,
precio double(10,2) not null,
descripcion varchar(200) not null,
porcentajeIgv int(2) not null,
IdCategoria int(11) not null,
estado int(1) not null
);
select * from tb_producto;
truncate tb_producto;

select p.IdProducto, p.nombre, p.cantidad, p.precio , p.descripcion, p.porcentajeIva, c.descripcion, p.estado from tb_producto As	p, tb_categoria As c where p.IdCategoria = c.IdCategoria;

-- tabla cabecera de venta

create table tb_Cabecera_venta(
IdCabeceraVenta int(11) auto_increment primary key,
IdCliente int(11) not null,
valorPagar double(10,2) not null,
fechaVenta date not null,
estado int(1) not null
);
select * from tb_Cabecera_venta;

select * from tb_detalle_venta;

-- tabla detalle de venta
create table tb_detalle_venta(
IdDetalleVenta int(11) auto_increment primary key,
IdCabeceraVenta int(11) not null,
IdProducto int(11) not null,
cantidad int(11) not null,
precioUnitario double(10,2) not null,
subtotal double(10,2) not null,
descuento double(10,2) not null,
igv double(10,2) not null,
totalPagar double(10,2) not null,
estado int(1) not null
);


show tables;

select * from tb_usuario;