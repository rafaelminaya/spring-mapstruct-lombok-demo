-- CATEGORIAS
insert into category (id, name, status) values (1, 'Finance', false);
insert into category (id, name, status) values (2, 'n/a', false);
insert into category (id, name, status) values (3, 'Public Utilities', true);
-- PRODUCTOS
insert into product (id, name, creation_date, price, category_id) values (1, 'Lemonade - Kiwi, 591 Ml', '2024-02-04 15:53:11', 0.5, 1);
insert into product (id, name, creation_date, price, category_id) values (2, 'Wine - Lamancha Do Criana', '2023-07-24 18:42:35', 113.888, 2);
insert into product (id, name, creation_date, price, category_id) values (3, 'Pork Casing', '2024-02-26 02:56:47', 00.0001, 3);
insert into product (id, name, creation_date, price, category_id) values (4, 'Cheese - Cheddar, Mild', '2023-07-04 22:42:54', 5.99, 1);
insert into product (id, name, creation_date, price, category_id) values (5, 'Crackers - Water', '2023-09-06 03:09:06', 10.989, 2);
-- FACTURAS
insert into factura (id, numero, fecha_emision) values (1, '1630928518', '2023-09-01T15:47:33Z');
insert into factura (id, numero, fecha_emision) values (2, '1123090297', '2023-09-07T14:08:14Z');
insert into factura (id, numero, fecha_emision) values (3, '2054448176', '2024-03-05T11:23:12Z');
insert into factura (id, numero, fecha_emision) values (4, '0733693482', '2023-10-07T07:09:05Z');
-- FACTURAS DETALLES
insert into factura_detalle (id, factura_id, cantidad, precio, producto) values (1, 1, 5, 180.5, 'Sage - Fresh');
insert into factura_detalle (id, factura_id, cantidad, precio, producto) values (2, 1, 9, 240.0, 'Beef Ground Medium');
insert into factura_detalle (id, factura_id, cantidad, precio, producto) values (3, 2, 12, 150.0, 'Pineapple - Regular');
insert into factura_detalle (id, factura_id, cantidad, precio, producto) values (4, 3, 8, 75.5, 'Bread Roll Foccacia');
insert into factura_detalle (id, factura_id, cantidad, precio, producto) values (5, 4, 15, 190.5, 'Chicken - Ground');

