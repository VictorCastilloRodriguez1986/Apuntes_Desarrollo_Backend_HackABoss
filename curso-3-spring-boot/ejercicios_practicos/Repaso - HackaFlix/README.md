# 🎬 HackaFlix

## 🧠 Objetivo
El objetivo de este ejercicio es implementar un endpoint en Spring Boot que permita **filtrar películas** utilizando **múltiples parámetros de consulta (query params)**.

---

## 📌 Contexto
Estás desarrollando una API para una plataforma de streaming. Los usuarios pueden buscar películas aplicando distintos filtros. El endpoint `/peliculas` debe aceptar los siguientes parámetros de forma **opcional**:

- `genero`: Género de la película (por ejemplo: `"Acción"`, `"Drama"`, `"Comedia"`)
- `anio`: Año de estreno (por ejemplo: `2023`, `2021`)
- `idioma`: Idioma original de la película (por ejemplo: `"es"`, `"en"`, `"fr"`)

---

## 🛠️ Lo que debes hacer

- Crear un **controlador REST** con un endpoint `/peliculas` que reciba los parámetros anteriores usando `@RequestParam`, todos como **opcionales** (`required = false`).
- Simular una **base de datos en memoria** con una lista fija de películas (puedes crear una clase `Pelicula` con los atributos `titulo`, `genero`, `anio`, `idioma`).
- Filtrar la lista según los parámetros recibidos.  
  Si no se recibe ningún parámetro, se deben devolver **todas las películas**.
- Probar el endpoint con distintas combinaciones de filtros, por ejemplo:
    - `/peliculas?genero=Drama`
    - `/peliculas?anio=2022&idioma=en`
    - `/peliculas?genero=Acción&anio=2023&idioma=es`

---

## 🧪 Requisitos mínimos

- El endpoint debe funcionar correctamente con **uno, dos o los tres parámetros combinados**.
- Si no se envía ningún parámetro, debe devolver la **lista completa**.
- No es necesario usar base de datos ni repositorios. Todo puede estar en **memoria**.