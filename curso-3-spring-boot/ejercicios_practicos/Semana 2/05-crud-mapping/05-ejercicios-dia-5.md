## Ejercicio Nº 1 - 2 parte de la practica de @PostMapping para gestionar Eventos

Estás desarrollando una plataforma para la gestión de eventos académicos en una universidad. El objetivo es crear una API RESTful utilizando Java con Spring Boot que permita a los usuarios ver eventos próximos, registrar nuevos eventos, inscribir participantes en eventos, obtener detalles específicos de un evento, actualizar eventos por completo, modificar parcialmente eventos y eliminar eventos.

Para lograrlo, se requiere implementar los siguientes endpoints:

GET /eventos: Listo

GET /evento/{id}: Listo

POST /evento: Listo

PUT /evento/{id}: Permite actualizar por completo un evento existente. Se espera que el cuerpo de la solicitud contenga todos los datos del evento, y los campos no proporcionados serán sobrescritos o eliminados.

PATCH /evento/{id}: Permite modificar parcialmente un evento existente. Solo se espera que el cuerpo de la solicitud contenga los campos que se desean actualizar. Los campos no incluidos en la solicitud permanecerán sin cambios.

DELETE /evento/{id}: Permite eliminar un evento específico mediante su ID y debe dar un mensaje por eliminación o por no eliminación.

💡Nota: Utilizar como base de datos una Collection a elección para evitar todavía la configuración de Bases de Datos.

Una vez implementados los endpoints, lleva a cabo pruebas con Postman para verificar que cada uno funcione correctamente. Al finalizar, exporta la colección de Postman que contiene las pruebas realizadas.

Ejemplo de JSON para pruebas de POST, PUT y PATCH

```json
{
  "titulo": "Conferencia de Ciencias Computacionales",
  "descripcion": "Una conferencia sobre los avances en inteligencia artificial y aprendizaje automático.",
  "fecha": "2023-12-15",
  "hora": "10:00",
  "lugar": "Aula Magna Centro del Conocimiento",
  "ponente": "Dr. Esteban Madrazzo"
}
```
