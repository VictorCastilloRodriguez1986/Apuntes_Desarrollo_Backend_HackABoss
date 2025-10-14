# 14. Archivos Partials (Parciales)

En esta clase se abordarán las siguientes temáticas:

**Sistemas Web con JSP + Jakarta EE**
- Que son Partials
- Imagen en JSP desde una carpeta pública   
- Linkear un Archivo CSS con un JSP
- Linkear un Archivo JS  con un JSP

<br>

# Uso de Partials en un Proyecto Web con Java y Tomcat

En aplicaciones web construidas con Java y Tomcat, es común utilizar archivos parciales (**partials**) para evitar la repetición de código en múltiples páginas. Los partials más comunes son el **header** y el **footer**.

<br>

### Crear un Header y Footer como Partials

1. Crear los archivos `header.jsp` y `footer.jsp` en una carpeta dedicada (por ejemplo, `WEB-INF/views/partials/`).
   
2. El archivo **header.jsp** puede contener el menú de navegación o la barra superior:
   
   ```jsp
   <!-- header.jsp -->
   <header>
       <h1>Mi Aplicación Web</h1>
       <nav>
           <a href="home.jsp">Inicio</a>
           <a href="about.jsp">Acerca de</a>
       </nav>
   </header>
   ```

3. El archivo **footer.jsp** puede contener información de derechos de autor o enlaces a redes sociales:
   
   ```jsp
   <!-- footer.jsp -->
   <footer>
       <p>© 2025 Mi Aplicación Web. Todos los derechos reservados.</p>
   </footer>
   ```

<br>

### Incluir los Partials en un JSP Principal

Para incluir estos partials en otras páginas JSP, utiliza la directiva `include`:

```jsp
<%@ include file="partials/header.jsp" %>
<div>
    <h2>Contenido Principal</h2>
    <p>Bienvenido a la página de inicio.</p>
</div>
<%@ include file="partials/footer.jsp" %>
```

<br>

# Mostrar una Imagen en JSP desde una Carpeta Pública

Para mostrar imágenes en un proyecto web con JSP y Tomcat:

1. Crear una carpeta pública dentro de `webapp` (por ejemplo, `webapp/images`).
   
2. Guardar la imagen dentro de esa carpeta (por ejemplo, `logo.png`).
   
3. Referenciar la imagen en el archivo JSP:
   
   ```jsp
   <img src="images/logo.png" alt="Logo" width="200">
   ```

> **Nota:** Asegúrate de que la carpeta pública esté correctamente configurada en el archivo `web.xml` si es necesario.

<br>

# Linkear un Archivo CSS con un JSP

Los archivos CSS permiten dar estilo a la aplicación web. Sigue estos pasos para vincular un CSS a tu JSP:

1. Crear una carpeta `css` dentro de `webapp` y guardar el archivo `estilos.css`.
   
2. En el archivo JSP, utilizar la etiqueta `<link>` para vincular el CSS:
   
   ```jsp
   <head>
       <title>Mi Página JSP</title>
       <link rel="stylesheet" href="css/estilos.css">
   </head>
   ```

<br>

### Ejemplo de `estilos.css`

```css
body {
    font-family: Arial, sans-serif;
    background-color: #f4f4f4;
}
header {
    background-color: #333;
    color: white;
    padding: 10px;
}
footer {
    background-color: #222;
    color: white;
    text-align: center;
    padding: 5px;
}
```

<br>

# Linkear un Archivo JavaScript en el JSP

Los archivos JavaScript se usan para agregar funcionalidades dinámicas. Sigue estos pasos:

1. Crear una carpeta `js` dentro de `webapp` y guardar el archivo `script.js`.
   
2. En el archivo JSP, utilizar la etiqueta `<script>` para vincular el JavaScript:
   
   ```jsp
   <body>
       <h2>Hola Mundo con JS</h2>
       <button onclick="mostrarMensaje()">Haz clic aquí</button>
       <script src="js/script.js"></script>
   </body>
   ```

<br>

### Ejemplo de `script.js`

```javascript
function mostrarMensaje() {
    alert("¡Hola desde JavaScript!");
}
```

<br>

¡Listo! Con esta estructura tendrás un proyecto organizado y funcional utilizando JSP, CSS y JavaScript en Tomcat.

---
[⬅️ Volver al índice](./README.md)