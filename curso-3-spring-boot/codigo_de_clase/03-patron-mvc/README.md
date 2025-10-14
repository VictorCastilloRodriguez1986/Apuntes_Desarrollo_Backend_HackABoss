# 🍔 ¡McD te necesita!

La famosa cadena de comida rápida **McD'** está en plena expansión digital. Después de buscar sin éxito a un desarrollador experimentado, deciden confiar en **ti** —sí, en **ti**— para crear el primer prototipo de su sistema de gestión de pedidos.

Tu misión es construir una **API REST sencilla** que permita a los clientes ver el menú, hacer pedidos, y al personal agregar nuevos platos.  
No te preocupes por bases de datos ni seguridad por ahora: lo importante es que **funcione**.

---

## ✅ Requisitos funcionales

Implementa los siguientes endpoints:

### 1. `GET /menu`
Devuelve la lista completa de platos disponibles en el menú.

### 2. `GET /pedidos/{id}`
Devuelve la información detallada de un pedido específico por su ID.

### 3. `POST /pedidos`
Permite a un cliente realizar un nuevo pedido.  
El pedido se recibe como JSON.

### 4. `POST /menu`
Permite agregar un nuevo plato al menú.  
El plato se recibe como JSON.

---

## 📜 Reglas

- Usa listas en memoria (`ArrayList`, `HashMap`) para almacenar los datos.
- No uses `ResponseEntity` ni base de datos.
- Los datos deben persistir mientras la aplicación esté corriendo.
- Puedes usar clases simples como `Plato` y `Pedido` para representar los datos.

---

¡Buena suerte, desarrollador estrella! 🚀