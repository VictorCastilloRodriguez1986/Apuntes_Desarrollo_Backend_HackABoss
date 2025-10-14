# 🧠 Consigna: “El Sindicato de Villanos” – Registro de malvados en entrenamiento

## 😈 Contexto
El Sindicato de Villanos está creciendo y necesita un sistema para gestionar a sus aspirantes a supervillanos. Tu equipo ha sido contratado para desarrollar el sistema interno que permita registrar, evaluar y controlar a los nuevos malvados en formación.

## 🎯 Objetivo
Crear una aplicación en **Java** con **arquitectura en capas** que permita realizar un **CRUD completo** de aspirantes a villanos, almacenados en memoria. El sistema debe ser **modular**, **limpio** y preparado para futuras expansiones (como misiones, enfrentamientos, etc.).

---

## 📦 Requisitos funcionales

### 1. Modelo: `AspiranteVillano`
- `id` (int)
- `alias` (String) — nombre malvado, ej. “Doctor Caos”
- `nivelDeMaldad` (int, de 0 a 10)
- `especialidad` (String) — ej. “Manipulación”, “Tecnología”, “Magia”
- `enProbatoria` (boolean) — si aún está en entrenamiento

### 2. Operaciones CRUD
- Registrar nuevo aspirante
- Listar todos los aspirantes
- Buscar por ID
- Actualizar datos del aspirante
- Eliminar (expulsar del sindicato)

### 3. Reglas de negocio
- ❌ No se permite registrar alias duplicados
- 📊 El `nivelDeMaldad` debe estar entre 0 y 10
- 🏆 Si el aspirante tiene nivel 10 y no está en probatoria, se marca como “Listo para el mal”

---

## 🧱 Requisitos técnicos

### Capas
- **Model**: clase `AspiranteVillano`
- **Repository**: interfaz y clase con almacenamiento en memoria (`Map`)
- **Service**: lógica de negocio y validaciones
- **Controller**: entrada principal (REST)

### Buenas prácticas
- ✅ Validaciones en el Service
- 🧩 Separación de responsabilidades
- ⚠️ Manejo de errores y mensajes claros

---

## 🎮 Bonus opcional
Proximamente...