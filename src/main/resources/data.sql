-- Insertar datos en la tabla Departamentos
insert into Departamentos(direccion_oficinas, municipio, nombre_departamento) values('El Naranjo', 'Guatemala', 'PNC');
insert into Departamentos(direccion_oficinas, municipio, nombre_departamento) values('Avenida Reforma', 'Guatemala', 'Tránsito');
insert into Departamentos(direccion_oficinas, municipio, nombre_departamento) values('Zona 4', 'Guatemala', 'PMT');
insert into Departamentos(direccion_oficinas, municipio, nombre_departamento) values('Mixco', 'Mixco', 'PMT de Mixco');
insert into Departamentos(direccion_oficinas, municipio, nombre_departamento) values('Quetzaltenango', 'Quetzaltenango', 'PNC de Quetzaltenango');
insert into Departamentos(direccion_oficinas, municipio, nombre_departamento) values('Antigua Guatemala', 'Sacatepéquez', 'Tránsito de Antigua');
insert into Departamentos(direccion_oficinas, municipio, nombre_departamento) values('Escuintla', 'Escuintla', 'PMT de Escuintla');
insert into Departamentos(direccion_oficinas, municipio, nombre_departamento) values('Villa Nueva', 'Villa Nueva', 'PMT de Villa Nueva');
insert into Departamentos(direccion_oficinas, municipio, nombre_departamento) values('Cobán', 'Alta Verapaz', 'PNC de Cobán');
insert into Departamentos(direccion_oficinas, municipio, nombre_departamento) values('Petén', 'Petén', 'PMT de Petén');

---

-- Insertar datos en la tabla Infractores
insert into Infractores(direccion, dni, email, nombre_infractor) values('Cayala', '1', 'bb@gmail.com', 'Eduardo Salazar');
insert into Infractores(direccion, dni, email, nombre_infractor) values('Zona 10', '2', 'luis.perez@mail.com', 'Luis Perez');
insert into Infractores(direccion, dni, email, nombre_infractor) values('Zona 1', '3', 'ana.gomez@mail.com', 'Ana Gomez');
insert into Infractores(direccion, dni, email, nombre_infractor) values('Zona 13', '4', 'pedro.lopez@mail.com', 'Pedro Lopez');
insert into Infractores(direccion, dni, email, nombre_infractor) values('Zona 16', '5', 'maria.rodriguez@mail.com', 'Maria Rodriguez');
insert into Infractores(direccion, dni, email, nombre_infractor) values('Zona 18', '6', 'jorge.hernandez@mail.com', 'Jorge Hernandez');
insert into Infractores(direccion, dni, email, nombre_infractor) values('Mixco', '7', 'isabel.castro@mail.com', 'Isabel Castro');
insert into Infractores(direccion, dni, email, nombre_infractor) values('Villa Nueva', '8', 'fernando.ramirez@mail.com', 'Fernando Ramirez');
insert into Infractores(direccion, dni, email, nombre_infractor) values('San Jose Pinula', '9', 'carmen.soto@mail.com', 'Carmen Soto');
insert into Infractores(direccion, dni, email, nombre_infractor) values('Fraijanes', '10', 'david.alvarez@mail.com', 'David Alvarez');

---

-- Insertar datos en la tabla Inspectores
insert into Inspectores(nombre_inspector, numero_placa) values('Jose Luis', 'H-9864');
insert into Inspectores(nombre_inspector, numero_placa) values('Maria Elena', 'A-5678');
insert into Inspectores(nombre_inspector, numero_placa) values('Juan Perez', 'B-1234');
insert into Inspectores(nombre_inspector, numero_placa) values('Ana Morales', 'C-9101');
insert into Inspectores(nombre_inspector, numero_placa) values('Carlos Gomez', 'D-2345');
insert into Inspectores(nombre_inspector, numero_placa) values('Laura Valdez', 'E-6789');
insert into Inspectores(nombre_inspector, numero_placa) values('Roberto Campos', 'F-3456');
insert into Inspectores(nombre_inspector, numero_placa) values('Sofia Reyes', 'G-7890');
insert into Inspectores(nombre_inspector, numero_placa) values('Daniel Castro', 'I-1234');
insert into Inspectores(nombre_inspector, numero_placa) values('Paola Herrera', 'J-5678');

---

-- Insertar datos en la tabla Vehiculos
insert into Vehiculos(marca, matricula, modelo) values('Honda', 'P598HTJ', 'Civic');
insert into Vehiculos(marca, matricula, modelo) values('Toyota', 'C457FGH', 'Corolla');
insert into Vehiculos(marca, matricula, modelo) values('Nissan', 'J678KLP', 'Sentra');
insert into Vehiculos(marca, matricula, modelo) values('Ford', 'R321ZXC', 'Focus');
insert into Vehiculos(marca, matricula, modelo) values('Chevrolet', 'T987VBN', 'Malibu');
insert into Vehiculos(marca, matricula, modelo) values('BMW', 'U654QWE', 'X5');
insert into Vehiculos(marca, matricula, modelo) values('Audi', 'Y789ASD', 'A4');
insert into Vehiculos(marca, matricula, modelo) values('Mercedes-Benz', 'O123FGH', 'C-Class');
insert into Vehiculos(marca, matricula, modelo) values('Kia', 'P456JKL', 'Sorento');
insert into Vehiculos(marca, matricula, modelo) values('Hyundai', 'W789MNB', 'Tucson');

---

-- Insertar datos en la tabla Multas
insert into Multas(monto, fecha_infraccion, descripcion_multa, estado, id_infractor, id_inspector, id_departamento, id_vehiculo) values(200.00, '2025-11-11', 'Velocidad muy alta', 'PENDIENTE', 1, 1, 1, 1);
insert into Multas(monto, fecha_infraccion, descripcion_multa, estado, id_infractor, id_inspector, id_departamento, id_vehiculo) values(150.00, '2025-10-10', 'Estacionamiento en zona prohibida', 'PAGADA', 2, 2, 2, 2);
insert into Multas(monto, fecha_infraccion, descripcion_multa, estado, id_infractor, id_inspector, id_departamento, id_vehiculo) values(300.00, '2025-09-20', 'Conducir sin licencia', 'PENDIENTE', 3, 3, 3, 3);
insert into Multas(monto, fecha_infraccion, descripcion_multa, estado, id_infractor, id_inspector, id_departamento, id_vehiculo) values(50.00, '2025-12-05', 'No usar cinturón de seguridad', 'PAGADA', 4, 4, 4, 4);
insert into Multas(monto, fecha_infraccion, descripcion_multa, estado, id_infractor, id_inspector, id_departamento, id_vehiculo) values(100.00, '2025-08-25', 'Pasar semáforo en rojo', 'PENDIENTE', 5, 5, 5, 5);
insert into Multas(monto, fecha_infraccion, descripcion_multa, estado, id_infractor, id_inspector, id_departamento, id_vehiculo) values(250.00, '2025-07-15', 'Falta de documentos', 'PENDIENTE', 6, 6, 6, 6);
insert into Multas(monto, fecha_infraccion, descripcion_multa, estado, id_infractor, id_inspector, id_departamento, id_vehiculo) values(120.00, '2025-06-01', 'Uso de teléfono al conducir', 'PAGADA', 7, 7, 7, 7);
insert into Multas(monto, fecha_infraccion, descripcion_multa, estado, id_infractor, id_inspector, id_departamento, id_vehiculo) values(80.00, '2025-05-18', 'Giro en U prohibido', 'PENDIENTE', 8, 8, 8, 8);
insert into Multas(monto, fecha_infraccion, descripcion_multa, estado, id_infractor, id_inspector, id_departamento, id_vehiculo) values(180.00, '2025-04-09', 'Llantas lisas', 'PENDIENTE', 9, 9, 9, 9);
insert into Multas(monto, fecha_infraccion, descripcion_multa, estado, id_infractor, id_inspector, id_departamento, id_vehiculo) values(220.00, '2025-03-22', 'Contaminación por humo', 'PAGADA', 10, 10, 10, 10);

---

-- Insertar datos en la tabla Pagos
insert into Pagos(fecha_pago, monto_pagado, metodo_pago, id_multa) values('2025-10-15', 150.00, 'Tarjeta', 2);
insert into Pagos(fecha_pago, monto_pagado, metodo_pago, id_multa) values('2025-12-06', 50.00, 'Efectivo', 4);
insert into Pagos(fecha_pago, monto_pagado, metodo_pago, id_multa) values('2025-06-03', 120.00, 'Transferencia', 7);
insert into Pagos(fecha_pago, monto_pagado, metodo_pago, id_multa) values('2025-03-25', 220.00, 'Tarjeta', 10);
insert into Pagos(fecha_pago, monto_pagado, metodo_pago, id_multa) values('2025-09-25', 300.00, 'Efectivo', 3);
insert into Pagos(fecha_pago, monto_pagado, metodo_pago, id_multa) values('2025-11-15', 200.00, 'Transferencia', 1);
insert into Pagos(fecha_pago, monto_pagado, metodo_pago, id_multa) values('2025-08-30', 100.00, 'Tarjeta', 5);
insert into Pagos(fecha_pago, monto_pagado, metodo_pago, id_multa) values('2025-07-20', 250.00, 'Efectivo', 6);
insert into Pagos(fecha_pago, monto_pagado, metodo_pago, id_multa) values('2025-05-20', 80.00, 'Tarjeta', 8);
insert into Pagos(fecha_pago, monto_pagado, metodo_pago, id_multa) values('2025-04-12', 180.00, 'Transferencia', 9);