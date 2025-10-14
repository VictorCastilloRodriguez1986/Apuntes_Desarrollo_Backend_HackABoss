# Ejercicio JWT

- Crea un nuevo proyecto utilizando Spring Initializr.

- Incorpora las librerías necesarias para el uso de JWT.

- No implementar ni registro ni gestión de una base de datos.

- Implementar una ruta "/auth/login" que acepte cualquier "username", pero el passoword tiene que coincidir con "123456". Si el password es correcta devolver un ResponseEntity con el token en un JSON: {"token": "VALOR_DEL_TOKEN"}.

- Implementar una ruta "/api/saludo" (que requiere autenticación) que devuelva un ResponseEntity con en el body una cadena de texto del tipo "¡Hola Stefano!". Stefano es el "username" del usuario que se logueó (leerlo del token que se envía en la petición).

- Implementar una ruta "/api/productos" (que no requiere autenticación) que devuelve ResponseEntity con en el body una cadena de texto "Productos".

- Implementar un filtro que, para cada petición a la API, imprima en la consola "¡Hola, soy el filtro que no hace nada!".

- Añadir en el claim del token un chiste y comprobar el token (y el chiste) en https://www.jwt.io.

- Crear una colección Postman con las peticiones para probar la API.

- Compartir el token en Slack para sonreír con los chistes.
