# 🐶 Ejercicio: “Adopta un amigo”

## 📝 Consigna

Una protectora de animales quiere lanzar una API para gestionar su sistema de adopciones.  
Tu equipo fue contratado para crear el prototipo de esta API, que permita:

- Ver los animales disponibles para adopción
- Registrar nuevos animales
- Postularse para adoptar uno
- Ver las postulaciones realizadas

---

## 🎯 Endpoints a implementar

### 1. `GET /animales`

Devuelve la lista de animales disponibles.  
Cada animal tiene:

- `id`
- `nombre`
- `tipo` (perro, gato, etc.)
- `edad`
- `descripcion`

---

### 2. `POST /animales`

Permite registrar un nuevo animal.  
Recibe un JSON con los datos del animal.

---

### 3. `POST /adopciones`

Permite postularse para adoptar un animal.  
Recibe:

- `nombrePersona`
- `idAnimal`
- `mensaje`

Devuelve un mensaje de confirmación con el nombre del animal y del postulante.

---

### 4. `GET /adopciones`

Devuelve la lista de postulaciones realizadas.

---

## 📦 Reglas

- Usa listas en memoria (`ArrayList`) para animales y postulaciones
- No hace falta validar si el animal ya fue adoptado
- Usa `ResponseEntity` para todas las respuestas
- No uses base de datos ni servicios externos

---

## 💡 Bonus

Agrega un endpoint `GET /animales/random` que devuelva un animal aleatorio como “sugerencia de adopción”.