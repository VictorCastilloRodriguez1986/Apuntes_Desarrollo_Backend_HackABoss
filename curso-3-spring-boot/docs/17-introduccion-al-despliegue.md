
# Clase: Despliegue y Configuración de Spring Boot en IntelliJ IDEA 2025

---

## Índice de temas

1. ¿Qué es un despliegue (deploy) y por qué es importante?
2. ¿Qué son las variables de entorno y su rol en las aplicaciones?
3. ¿Cómo configurar las variables de entorno en IntelliJ IDEA 2025?
4. Configuración de `application.properties` y `application.yml` en Spring Boot
5. ¿Qué es un archivo `.JAR` y `.WAR` y para qué sirven?
6. Ejemplo práctico: Uso de variables de entorno en `application.properties`

---

## 1. ¿Qué es un despliegue (deploy) y por qué es importante?

El **despliegue** (o *deployment*) es el proceso mediante el cual llevamos una aplicación desde el entorno de desarrollo (nuestra máquina local) hacia un entorno de producción o de pruebas donde otros usuarios puedan utilizarla.

El despliegue puede implicar:

✅ Copiar el archivo ejecutable de la aplicación (como un `.jar` o `.war`) en un servidor.  
✅ Configurar variables de entorno necesarias para que la aplicación funcione correctamente.  
✅ Iniciar la aplicación para que quede escuchando peticiones.  
✅ Configurar el entorno (base de datos, dependencias externas).  

Es un paso crucial porque:

- Permite que el código que desarrollamos llegue a los usuarios.  
- Asegura que la aplicación funcione en entornos reales.  
- Nos permite detectar problemas que no aparecen en desarrollo.  

En Java con Spring Boot, generalmente el despliegue se realiza empaquetando la aplicación en un `.jar` o `.war` y luego ejecutándola o desplegándola en un servidor de aplicaciones.

---

## 2. ¿Qué son las variables de entorno y su rol en las aplicaciones?

Las **variables de entorno** son valores definidos fuera de la aplicación (en el sistema operativo o servidor) que permiten pasar configuraciones a la aplicación sin necesidad de modificar el código.

### Ventajas:

- Evitan que tengamos credenciales sensibles en el repositorio.  
- Permiten personalizar el comportamiento de la app en diferentes entornos (dev, prod).  
- Son fáciles de cambiar sin recompilar.  

Por ejemplo: la URL de una base de datos, claves de API, o el puerto en el que la aplicación escucha.

### Ejemplo de variable de entorno en Linux/Mac:

```bash
export SPRING_DATASOURCE_URL=jdbc:mysql://localhost:3306/mi_bd
```

En Windows PowerShell:

```powershell
setx SPRING_DATASOURCE_URL "jdbc:mysql://localhost:3306/mi_bd"
```

En Spring Boot podemos acceder a ellas en el archivo `application.properties` así:

```properties
spring.datasource.url=${SPRING_DATASOURCE_URL}
```

---

## 3. ¿Cómo configurar variables de entorno en IntelliJ IDEA 2025?

En IntelliJ IDEA 2025, podemos configurar variables de entorno para las ejecuciones de Spring Boot directamente en la configuración de la aplicación.

Pasos:

1️⃣ **Abre IntelliJ IDEA** y abre el proyecto de Spring Boot.  
2️⃣ Ve a la parte superior derecha, haz clic en el menú desplegable donde aparece la configuración de ejecución (por ejemplo, "DemoApplication" o  "App").  
3️⃣ Haz clic en “Edit Configurations…”.  
4️⃣ En la ventana que se abre, selecciona tu configuración de Spring Boot (normalmente de tipo "Application").  
5️⃣ En la sección **Environment Variables** verás un campo vacío o con un botón “Tabla” para editar las variables.  
6️⃣ Haz clic en ese botón (+) y añade las variables en conjunto par Clave-Valor:  

| Name                     | Value                                       |
|--------------------------|---------------------------------------------|
| SPRING_DATASOURCE_URL    | jdbc:mysql://localhost:3306/mi_bd           |
| SPRING_DATASOURCE_USERNAME| root                                       |
| SPRING_DATASOURCE_PASSWORD| 1234                                       |

7️⃣ Haz clic en “OK” y luego en “Apply”.  
8️⃣ Ahora, cuando ejecutes tu app desde IntelliJ, Spring Boot usará esas variables.

✅ **Nota**: Esto es útil para desarrollo local. En producción, normalmente se configuran en el sistema operativo o en el entorno de despliegue (por ejemplo, Docker, Kubernetes).

---

## 4. Configuración de `application.properties` y `application.yml` en Spring Boot

Spring Boot utiliza archivos de configuración para personalizar el comportamiento de la app.

### `application.properties`

Es un archivo de propiedades simples, por ejemplo:

```properties
server.port=8081
spring.datasource.url=${SPRING_DATASOURCE_URL}
spring.datasource.username=${SPRING_DATASOURCE_USERNAME}
spring.datasource.password=${SPRING_DATASOURCE_PASSWORD}
```

### `application.yml`

Permite una sintaxis más limpia y estructurada:

```yaml
server:
  port: 8081

spring:
  datasource:
    url: ${SPRING_DATASOURCE_URL}
    username: ${SPRING_DATASOURCE_USERNAME}
    password: ${SPRING_DATASOURCE_PASSWORD}
```

Ambos archivos son equivalentes, solo cambia el estilo.

✅ Podemos tener múltiples perfiles, como:  
- `application-dev.properties` para desarrollo  
- `application-prod.properties` para producción  

Spring Boot los elige según la variable de entorno `SPRING_PROFILES_ACTIVE`.

---

## 5. ¿Qué es un archivo `.JAR` y `.WAR` y para qué sirven?

### `.JAR` (Java ARchive)

Un **.jar** es un archivo comprimido que contiene:  
- Archivos `.class` compilados.  
- Dependencias necesarias.  
- Recursos estáticos.  
- Archivo `META-INF/MANIFEST.MF` que indica el punto de inicio.  

Permite que la aplicación se ejecute como:  

```bash
java -jar mi-aplicacion.jar
```

En Spring Boot, la mayoría de las apps se empaquetan como `.jar` autoejecutables con Tomcat embebido.

### `.WAR` (Web Application Archive)

Un **.war** también es un archivo comprimido, pero con estructura para desplegarse en un servidor de aplicaciones (como Tomcat externo). Contiene:  
- Código de la app.  
- Web descriptors (`WEB-INF`).  
- Recursos y dependencias.  

Se usa así:  
- Copiar el `.war` en la carpeta `webapps` de Tomcat.  
- Tomcat lo despliega automáticamente.

---

## 6. Ejemplo práctico: Uso de variables de entorno en `application.properties`

### Paso 1: Variables de entorno

Configura las variables en IntelliJ para tu proyecto:

```txt
SPRING_DATASOURCE_URL = jdbc:mysql://localhost:3306/personas_db
SPRING_DATASOURCE_USERNAME = root
SPRING_DATASOURCE_PASSWORD = 1234
```

### Paso 2: Traete las varibles a tu  `application.properties`

```properties
spring.datasource.url=${SPRING_DATASOURCE_URL}
spring.datasource.username=${SPRING_DATASOURCE_USERNAME}
spring.datasource.password=${SPRING_DATASOURCE_PASSWORD}
spring.jpa.hibernate.ddl-auto=update
```

✅ Cuando la app arranca, Spring Boot reemplaza los `${…}` por los valores de las variables de entorno.
