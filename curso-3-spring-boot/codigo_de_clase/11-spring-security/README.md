## 🪖 Proyecto: Centro de Inteligencia Militar – Archivos Clasificados

Año 2025. En un contexto de tensión geopolítica creciente, el Centro de Inteligencia Militar ha desarrollado un 
sistema interno para gestionar documentos estratégicos. Algunos archivos han sido desclasificados y pueden ser 
consultados por cualquier civil. Otros, sin embargo, contienen información sensible sobre operaciones encubiertas, 
tecnología experimental y agentes infiltrados. Solo el personal autorizado puede acceder a ellos. 
Tu misión como desarrollador es construir la API que manejará este sistema. Deberás garantizar que los 
documentos clasificados estén protegidos y que solo los agentes autenticados puedan crear, consultar o eliminar 
información confidencial.

### 🎯 Objetivo

Desarrollar una API REST con **Spring Boot** que permita:

- Consultar archivos **desclasificados** _(sin autenticación)_
- Consultar, crear y eliminar archivos **clasificados** _(requiere autenticación básica)_
- Simular la base de datos con una estructura en memoria (**HashMap**)
- Aplicar **Spring Security** de forma sencilla usando configuración en `application.properties`

### 🧩 Especificaciones técnicas
### 🔐 Seguridad
Usar autenticación básica configurada en application.properties 
- Usuario: agente007 
- Contraseña: topsecret

### 🗂️ Endpoints

    /archivos/desclasificados
    /archivos/clasificados
    /archivos
    /archivos/{id}

### 📄 Modelo 
Archivo 
{ 
private Long id; 
private String titulo; 
private String contenido; 
private boolean desclasificado; 
} 

### 🧠 Lógica de negocio
- La base de datos será simulada con un HashMap
- Los IDs se generarán en el backend
- No se necesita persistencia real ni conexión a base de datos

### 🧱 Estructura del proyecto
- ArchivoController: maneja las solicitudes HTTP
- ArchivoService: contiene la lógica de negocio
- ArchivoRepository: simula la base de datos en memoria

### 🧪 Recomendaciones para pruebas
- Usar Postman para probar los endpoints
- Configurar autenticación básica en los requests protegidos
- Probar acceso sin login para verificar protección