## Temas a tratar

En esta clase se abordarán las siguientes temáticas:

**Anotaciones de Métodos HTTP**
- @PutMapping
- @PatchMapping
- @DeleteMapping

<br>

---
---

<br>

# `@PutMapping` en Spring Boot

El decorador `@PutMapping` es parte del paquete `org.springframework.web.bind.annotation` y se utiliza en controladores de Spring Boot para manejar solicitudes HTTP de tipo **PUT**.

Este tipo de solicitudes se usan generalmente para **actualizar recursos existentes**. A diferencia de `@PostMapping` (que suele crear nuevos registros), `@PutMapping` sobrescribe por completo el recurso especificado con los nuevos datos enviados.

<br>

## Cómo se crea un `@PutMapping`

Para definir un `@PutMapping`, se debe declarar un método dentro de un `@RestController` y anotarlo con `@PutMapping`, especificando la URL relativa que representará el recurso a actualizar.

```java
@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> actualizarUsuario(
            @PathVariable Long id,
            @RequestBody Usuario usuarioActualizado) {

        // Lógica de actualización aquí

        return ResponseEntity.ok(usuarioActualizado);
    }
}

```

### Detalles:

@PathVariable: Extrae el ID del recurso desde la URL.

@RequestBody: Recibe el nuevo objeto desde el cuerpo del _request_ en formato JSON.

<br>

## Cómo se envían datos desde Postman para un @PutMapping

Para probar un @PutMapping con Postman:

1. Selecciona el método PUT en la interfaz de Postman.

2. Introduce la URL correspondiente, por ejemplo: http://localhost:8080/api/usuarios/1

3. En la pestaña Body, elige la opción raw y elige el tipo JSON.

4. Agrega el objeto JSON con los datos actualizados:

```json
{
  "nombre": "Juan",
  "email": "juan@example.com"
}
```

5. Haz clic en Send

<br>

## Recomendaciones y código limpio para `@PutMapping`

Aquí tienes algunas recomendaciones para escribir un `@PutMapping` limpio y mantenible:

<br>

### 1. Validación de datos

Valida el `id` y el cuerpo del _request_ antes de procesarlo:

```java
if (!usuarioService.existsById(id)) {
    return ResponseEntity.notFound().build();
}
```

<br>

### 2. Evitar sobrescribir campos sensibles

Usa DTOs para evitar que los usuarios modifiquen propiedades como `id`, `roles`, o `fechaCreacion`.

```java
public class UsuarioDTO {
    private String nombre;
    private String email;
}
```

<br>

### 3. Separar lógica de negocio

La lógica de actualización debe estar en el servicio, no en el controlador.

```java
@PutMapping("/{id}")
public ResponseEntity<Usuario> actualizarUsuario(@PathVariable Long id, @RequestBody UsuarioDTO datos) {
    Usuario usuarioActualizado = usuarioService.actualizar(id, datos);
    return ResponseEntity.ok(usuarioActualizado);
}
```

<br>

### 4. Usar ResponseEntity

Te permite controlar el código de estado HTTP que se devuelve.

```java
return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
```

<br>

## Conclusión

El uso de `@PutMapping` es esencial cuando queremos **actualizar recursos existentes** de forma clara, semántica y RESTful. Al combinarlo con buenas prácticas como el uso de DTOs, validaciones y separación de responsabilidades, podemos construir APIs limpias, seguras y escalables.

<br>

# `@PatchMapping` en Springboot

`@PatchMapping` es una anotación de Spring Framework utilizada para manejar solicitudes HTTP PATCH en métodos de controladores. La solicitud PATCH se usa típicamente para actualizar parcialmente un recurso, en lugar de reemplazarlo por completo (como lo haría PUT).

* Se usa cuando solo se necesita modificar uno o varios campos de un objeto existente.

* A diferencia de `@PutMapping`, no requiere enviar todo el objeto, solo las partes que cambiarán.

<br>

## Cómo se crea un @PatchMapping

Para usar `@PatchMapping`, necesitas un método en tu controlador que lo maneje, generalmente junto con un parámetro que represente el ID del recurso a actualizar y un cuerpo que contenga los cambios:

```java
@PatchMapping("/usuarios/{id}")
public ResponseEntity<Usuario> actualizarParcialmenteUsuario(
        @PathVariable Long id,
        @RequestBody Map<String, Object> campos) {

    Usuario usuario = usuarioService.obtenerPorId(id);
    if (usuario == null) {
        return ResponseEntity.notFound().build();
    }

    campos.forEach((clave, valor) -> {
        Field field = ReflectionUtils.findField(Usuario.class, clave);
        field.setAccessible(true);
        ReflectionUtils.setField(field, usuario, valor);
    });

    usuarioService.guardar(usuario);
    return ResponseEntity.ok(usuario);
}
```

<br>

## Cómo enviar datos desde Postman para un @PatchMapping

1. Selecciona el método HTTP `PATCH`.
   
2. Escribe la URL correspondiente, por ejemplo:

   `PATCH [http://localhost:8080/usuarios/1](http://localhost:8080/usuarios/1)`

3. En la pestaña "Body", selecciona "raw" y elige "JSON".
   
4. Escribe el JSON con los campos que quieres actualizar, por ejemplo:
   
   ```json
   {
       "nombre": "Juan",
       "email": "juan@email.com"
   }
	```

<br>

Recuerda establecer el _header_: `Content-Type: application/json` 

<br>

## Recomendaciones y código limpio para @PatchMapping

* **Valida los datos** antes de aplicarlos. No confíes ciegamente en los datos del usuario.

* **Documenta bien** tu API para que quede claro qué campos pueden ser actualizados parcialmente.

* **Controla accesos**: asegúrate de que solo usuarios autorizados puedan modificar recursos.

* **Haz testing** para cada tipo de campo que se puede actualizar.

* Evita actualizaciones no deseadas validando los nombres de los campos recibidos.

* Usa utilidades como `ObjectMapper` para mapear datos en lugar de `ReflectionUtils` si prefieres un enfoque más robusto.

<br>

Con estos consejos puedes implementar `@PatchMapping` de manera eficiente, segura y siguiendo buenas prácticas de desarrollo en Spring Boot.

<br>

# `@DeleteMapping` en Spring Boot

La anotación `@DeleteMapping` forma parte del paquete `org.springframework.web.bind.annotation` y se utiliza para manejar solicitudes HTTP de tipo **DELETE**. Este tipo de solicitudes se usa comúnmente para **eliminar recursos** desde el servidor, siguiendo el estilo RESTful.

Usar `@DeleteMapping` permite que nuestra API comunique de forma clara la intención de borrar un recurso.

<br>

## Cómo se crea un `@DeleteMapping`

Para crear un _endpoint_ con `@DeleteMapping`, se utiliza en un método dentro de una clase anotada con `@RestController`, normalmente junto con `@PathVariable` para identificar qué recurso eliminar.

```java
@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarUsuario(@PathVariable Long id) {
        usuarioService.deleteById(id);
        return ResponseEntity.noContent().build(); // 204 No Content
    }
}
```

<br>

**Detalles:**

- `@PathVariable`: Se usa para identificar qué elemento eliminar.

- `ResponseEntity<Void>`: Devuelve una respuesta sin contenido.

<br>

## Cómo se envían datos desde Postman para un `@DeleteMapping`

1. Abre Postman y selecciona el método `DELETE`.
   
2. Escribe la URL del recurso que deseas eliminar, por ejemplo:
   
   ```
   http://localhost:8080/api/usuarios/5
   ```

3. No es necesario enviar un body JSON.
   
4. Haz clic en **Send**

<br>

Postman enviará la solicitud DELETE al backend para eliminar el recurso con ID 5.

<br>

## Recomendaciones y código limpio para `@DeleteMapping`

### 1. Verificar existencia antes de eliminar

Evita intentar eliminar recursos que no existen:

```java
if (!usuarioService.existsById(id)) {
    return ResponseEntity.notFound().build();
}
```

<br>

### 2. Separar la lógica de negocio

Delega la operación de borrado a una clase de servicio para mantener limpio el controlador:

```java
usuarioService.eliminarUsuarioPorId(id);
```

<br>

### 3. Usar códigos de respuesta apropiados

Utiliza `204 No Content` si se eliminó exitosamente o `404 Not Found` si no se encontró el recurso.

<br>

### 4. Agregar seguridad si es necesario

Asegúrate de que sólo usuarios autorizados puedan eliminar recursos.

<br>

## Conclusión

`@DeleteMapping` es esencial para construir APIs RESTful bien definidas. Usarlo correctamente mejora la claridad, seguridad y mantenimiento del código. Junto con buenas prácticas como validación y separación de responsabilidades, permite crear endpoints robustos y seguros.

---
[⬅️ Volver al índice](./README.md)

