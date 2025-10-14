**Ejercicio: Sistema básico de gestión de ventas con SQL**

En este ejercicio trabajarás con un sistema simplificado para registrar ventas realizadas por distintas tiendas. El sistema almacena información sobre los productos, las tiendas, y las ventas, incluyendo qué productos fueron vendidos en cada venta y en qué cantidad.

**Requisitos del sistema**
La base de datos debe permitir registrar:
- Los productos disponibles en el catálogo (no es necesario almacenar stock).
- Las tiendas que realizan las ventas.
- Cada venta realizada por una tienda, con la fecha correspondiente.
- Los productos vendidos en cada venta, indicando la cantidad de cada uno.


**Parte 1: Diseño del esquema**

Crea las tablas necesarias para almacenar la información anterior. Define adecuadamente las claves primarias y foráneas.
Asegúrate de representar correctamente la relación muchos-a-muchos entre ventas y productos, incluyendo un atributo adicional cantidad.


**Parte 2: Inserción de datos**

Escribe sentencias SQL para insertar los siguientes datos:
- Dos tiendas: "Tienda Centro" y "Tienda Norte".
- Tres productos: "Café", "Té Verde", "Chocolate".
- Una venta realizada por "Tienda Centro" el día 2025-06-01. En esa venta se vendieron:
    - 3 unidades de "Café"
    - 2 unidades de "Chocolate"


**Parte 3: Consultas**

Escribe consultas SQL para responder a las siguientes preguntas:
- ¿Qué productos se vendieron en la venta del 2025-06-01?
- ¿Cuántas unidades totales de "Café" se han vendido?
- ¿Cuántas ventas ha realizado cada tienda?
- Lista todas las ventas indicando: el nombre de la tienda, la fecha, y los productos vendidos con sus cantidades.


**Sugerencia**

Piensa en el modelo entidad-relación antes de crear las tablas. La relación entre productos y ventas se resuelve mediante una tabla intermedia (por ejemplo, venta_producto) que almacene tanto las claves foráneas como la cantidad vendida.
