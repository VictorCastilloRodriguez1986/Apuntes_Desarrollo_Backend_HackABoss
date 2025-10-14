## Ejercicio Nº 1: Repasar conceptos

### 📚 Glosario de 10 términos clave

1. **Spring Boot** – Framework que simplifica el desarrollo de aplicaciones Java basadas en Spring.
2. **Framework** – Conjunto de herramientas y librerías que facilitan el desarrollo de software.
3. **Dependency Injection** – Técnica de diseño para lograr una arquitectura más flexible y desacoplada.
4. **Spring Initializr** – Herramienta web para generar esqueletos de proyectos Spring Boot.
5. **POM.xml** – Archivo de configuración usado por Maven para gestionar dependencias y configuraciones.
6. **Controller** – Componente que maneja las solicitudes HTTP y define las rutas de la aplicación.
7. **Main Class** – Clase principal que contiene el método `main()` y la anotación `@SpringBootApplication`.
8. **Application.properties** – Archivo donde se configuran propiedades personalizadas de la aplicación.
9. **Whitelabel Error Page** – Página de error genérica de Spring Boot cuando no se encuentra un controlador.
10. **DevTools** – Dependencia útil para facilitar el desarrollo, permitiendo recarga automática y mejoras en los logs.

---

## Ejercicio 1 – Crear y levantar un proyecto básico

1. Ir a [https://start.spring.io](https://start.spring.io)
2. Elegir:
   - Project: Maven
   - Language: Java
   - Spring Boot: última versión estable
   - Group: `com.hackaboss`
   - Artifact: `demo1`
3. Click en **Generate**
4. Descomprimir el archivo descargado y abrir con tu IDE favorito (IntelliJ)
5. Ejecutar la clase principal que tiene `@SpringBootApplication`
6. ✅ ¡Listo! El proyecto debería iniciar en `http://localhost:8080`

---

## Ejercicio 2 – Proyecto con cambios de nombres y dependencia adicional

1. Ir a [https://start.spring.io](https://start.spring.io)
2. Elegir:
   - Group: `com.miempresa`
   - Artifact: `ejercicio2`
   - Dependencia: agregar **Spring Web**
3. Descargar y abrir el proyecto
4. Cambiar nombre del paquete de `com.miempresa.ejercicio2` a `com.miempresa.proyectoNuevo`
5. Verificar que en el archivo `pom.xml` se encuentre:

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>
```

6. ✅ ¡Proyecto modificado y listo para ejecutarse!

---

## 💡 Ejercicio 3 – Proyecto que diga "Hola Mundo" en vez de error Whitelabel

1. Crear un proyecto nuevo como en el **Ejercicio 1**
2. Agregar la dependencia **Spring Web**
3. Crear una clase `HolaController.java`:

```java
package com.ejemplo.demo3;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HolaController {

    @GetMapping("/")
    public String hola() {
        return "¡Hola Mundo! 👋";
    }
}
```

4. Ejecutar la aplicación y entrar en `http://localhost:8080`
5. ✅ ¡Listo! En vez del error **Whitelabel Error Page**, verás el mensaje: **¡Hola Mundo! 👋**

🛠️ **RETO**: ¿Qué pasaría si no anotamos la clase con `@RestController`? ¿Podrías explicarlo?

---

🎯 ¡Sigue practicando y no te detengas! El mundo Spring Boot es muy amplio y poderoso 🚀
