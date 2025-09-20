insert into Vehiculos(marca, matricula, modelo)
values("Honda", "P598HTJ", "Civic");

insert into Inspectores(nombre_inspector, numero_placa)
values("Jose Luis", "H-9864");

insert into Infractores(direccion, dni, email, nombre_infractor)
values("Cayala", "1", "bb@gmail.com", "Eduardo Salazar");

insert into Departamentos(direccion_oficinas, municipio, nombre_departamento)
values("El Naranjo", "Guatemala", "PNC");

insert into Multas(monto, fecha_infraccion, descripcion_multa, estado, id_infractor, id_inspector, id_departamento, id_vehiculo)
values(200.00, "2025-11-11", "Velocidad muy alta", "PENDIENTE", 1, 1, 1, 1);