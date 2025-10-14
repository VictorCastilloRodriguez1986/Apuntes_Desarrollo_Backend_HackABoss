## 🚀 Prueba Técnica Spring Boot: Gestión de Ventas para Supermercados

### 🎯 Objetivo

Evaluar conocimientos en Java y Spring Boot desarrollando una API RESTful completa, aplicando:

- Operaciones CRUD con JPA 🛠️
- Relaciones entre entidades 🔗
- Control de errores y excepciones ❗
- Uso de DTOs 📦
- Buenas prácticas REST ✅
- Programación funcional (lambdas y streams) 🌊

### 📘 Descripción del Caso

Una cadena de supermercados quiere digitalizar su sistema de ventas. Se debe construir una API para:

- Registrar productos con precios 🛒
- Gestionar sucursales 🏪
- Registrar ventas por sucursal, productos y cantidades 🧾
- Consultar ventas por sucursal, ingresos totales, productos más vendidos 📊

### 📚 Entidades Principales

- **Sucursal**: ubicación física del supermercado
- **Producto**: artículo a la venta (ej: arroz, agua)
- **Venta**: contiene productos y está asociada a una sucursal

**Relaciones**:

- Una Sucursal tiene muchas Ventas
- Una Venta contiene muchos Productos
- Un Producto puede estar en muchas Ventas

### ✅ Requisitos Técnicos

- Spring Boot + JPA con DB relacional (MySQL) 🐘
- Endpoints RESTful (GET, POST, PUT, DELETE) 🌐
- DTOs para separar modelos 🧱
- Manejo de errores con `ResponseEntity`, códigos HTTP y mensajes claros 🚦
- Lambdas o streams en una operación funcional 🌀
- Organización modular: `service`, `repository`, `controller` 🗂️
- Autogeneración de documentación con Swagger 📄
- Manejo centralizado de errores con `@ControllerAdvice` para al menos 2 excepciones ⚠️
- Un test unitario y un test de integración (con rollback que no modifique la DB) 🧪
- Colleción Postman con peticiones a todos los endpoints implementados

## 🧪 Testing

- ✅ 1 test unitario con `@SpringBootTest` o `@WebMvcTest`
- ✅ 1 test de integración con rollback automático
- ✅ Usa un `TestRestTemplate` o `MockMvc`

## ⚙️ Complemento del Proyecto

- 📄 Documentación Swagger autogenerada (`springdoc-openapi`)
- 🛡️ Manejo de excepciones globales con `@ControllerAdvice`:
  - `ProductoNotFoundException`
  - `SucursalNotFoundException`

---

## 🧾 Historias de Usuario

### 📦 Productos

#### 🔍 Listar productos

- Método: `GET`
- Path: `/api/productos`

#### ➕ Crear producto

- Método: `POST`
- Path: `/api/productos`
- Payload: nombre, precio, categoría

#### ✏️ Actualizar producto

- Método: `PUT`
- Path: `/api/productos/{id}`

#### ❌ Eliminar producto

- Método: `DELETE`
- Path: `/api/productos/{id}`

### 🏬 Sucursales

#### 🔍 Listar sucursales

- Método: `GET`
- Path: `/api/sucursales`

#### ➕ Crear sucursal

- Método: `POST`
- Path: `/api/sucursales`
- Payload: nombre, dirección

#### ✏️ Actualizar sucursal

- Método: `PUT`
- Path: `/api/sucursales/{id}`

#### ❌ Eliminar sucursal

- Método: `DELETE`
- Path: `/api/sucursales/{id}`

### 💰 Ventas

#### ➕ Registrar nueva venta

- Método: `POST`
- Path: `/api/ventas`
- Payload:

```json
{
  "sucursalId": 1,
  "detalle": [
    { "productoId": 10, "cantidad": 2 },
    { "productoId": 5, "cantidad": 1 }
  ]
}
```

#### 🔍 Obtener ventas por sucursal y/o fecha

- Método: `GET`
- Path: `/api/ventas?sucursalId=1&fecha=2025-06-01`

#### ❌ Eliminar/Anular venta (preferentemente borrado lógico)

- Método: `DELETE`
- Path: `/api/ventas/{id}`

---

### 📊 Extra:

#### 🔝 Autenticación con JWT

- Registro y Login
- Sin autenticación, serán permitidas solo las peticiones de tipo GET

#### 🔝 Gestion de inventario

#### 🔝 Producto más vendido

- Método: `GET`
- Path: `/api/estadisticas/producto-mas-vendido`
