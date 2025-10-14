-- DDL
DROP DATABASE IF EXISTS comercio;

CREATE DATABASE comercio;

USE comercio;

CREATE TABLE producto (
	id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL
);

CREATE TABLE tienda (
	id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL
);

CREATE TABLE venta (
	id INT AUTO_INCREMENT PRIMARY KEY,
    fecha DATE NOT NULL,
    tienda_id INT NOT NULL,
    FOREIGN KEY (tienda_id) REFERENCES tienda(id)
);

CREATE TABLE venta_producto (
	-- id INT AUTO_INCREMENT PRIMARY KEY,
    venta_id INT,
    FOREIGN KEY (venta_id) REFERENCES venta(id),
    producto_id INT,
    FOREIGN KEY (producto_id) REFERENCES producto(id),
    cantidad INT NOT NULL,
    -- UNIQUE(venta_id, producto_id )
    PRIMARY KEY (venta_id, producto_id )
);

-- DML

-- Dos tiendas: "Tienda Centro" y "Tienda Norte".
INSERT INTO tienda(nombre) VALUES
									("Tienda Centro"),
                                    ("Tienda Norte");
                                    
-- Tres productos: "Café", "Té Verde", "Chocolate".
INSERT INTO producto(nombre) VALUES
									("Café"),
                                    ("Té Verde"),
                                    ("Chocolate");
                                    
-- Una venta realizada por "Tienda Centro" el día 2025-06-01.
INSERT INTO venta(tienda_id, fecha) VALUES (1, "2025-06-01");
INSERT INTO venta(tienda_id, fecha) VALUES (1, "2025-06-02");

-- En esa venta se vendieron:
-- 3 unidades de "Café"
-- 2 unidades de "Chocolate"
INSERT INTO venta_producto(venta_id,producto_id,cantidad) VALUES
												(1, 1, 3),
                                                (1, 3, 2);
                                                
INSERT INTO venta_producto(venta_id,producto_id,cantidad) VALUES(2, 1, 10);
                                                
-- ERROR
-- INSERT INTO venta_producto(venta_id,producto_id,cantidad) VALUES (1, 11, 2);
-- INSERT INTO venta_producto(venta_id,producto_id,cantidad) VALUES (1, 1, 2);


-- ¿Qué productos se vendieron en la venta del 2025-06-01?
SELECT v.id AS venta_id, v.fecha, p.id AS producto_id, p.nombre, vp.cantidad
FROM venta AS v
JOIN venta_producto AS vp ON vp.venta_id = v.id
JOIN producto AS p ON vp.producto_id = p.id
WHERE fecha="2025-06-01";

-- ¿Cuántas unidades totales de "Café" se han vendido?
SELECT SUM(vp.cantidad) AS "n.cafes"
FROM venta_producto AS vp
WHERE vp.producto_id=1
GROUP BY vp.producto_id;

-- ¿Cuántas ventas ha realizado cada tienda?
SELECT t.nombre, COUNT(v.id) AS total_ventas
FROM tienda t
JOIN venta v ON v.tienda_id=t.id
GROUP BY t.nombre;

-- Lista todas las ventas indicando: el nombre de la tienda, la fecha, y los productos vendidos con sus cantidades.
SELECT t.nombre, v.fecha, p.nombre, vp.cantidad
FROM venta v
JOIN tienda AS t ON v.tienda_id = t.id
JOIN venta_producto AS vp ON v.id=vp.venta_id
JOIN producto AS p ON p.id = vp.producto_id;




