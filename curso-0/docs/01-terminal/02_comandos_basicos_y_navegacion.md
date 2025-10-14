# 2. Comandos básicos y navegación

Ahora que tenemos configurado el terminal, es fundamental conocer los comandos básicos para navegar por el sistema de archivos y gestionar directorios.

<br>

### ¿Qué es el directorio raíz?

El directorio raíz (`/`) es la base del sistema de archivos. Todas las carpetas y archivos en un sistema operativo derivan de este directorio. En sistemas Unix (Mac y Linux), la raíz es simplemente `/`, mientras que en Windows la raíz suele ser una unidad de disco como `C:\`.

Podemos listar los contenidos de la raíz con:

```bash
ls /
```

<br>

### Diferencia entre rutas absolutas y relativas

Cuando nos movemos por el sistema de archivos, podemos utilizar **rutas absolutas** o **rutas relativas**.

-   **Rutas absolutas**: Indican la ubicación exacta desde la raíz del sistema. Son independientes del directorio en el que nos encontramos.

    Ejemplo de ruta absoluta para entrar en `Documentos`:

    ```bash
    cd /home/usuario/Documentos
    ```

-   **Rutas relativas**: Indican la ubicación en relación al directorio actual en el que estamos. Son más cortas y flexibles, pero dependen de nuestra ubicación actual.

    Ejemplo de ruta relativa si estamos en `/home/usuario/` y queremos entrar en `Documentos`:

    ```bash
    cd ./Documentos
    ```

    Si estamos dentro de `Documentos` y queremos subir un nivel para volver a `/home/usuario/`:

    ```bash
    cd ../
    ```

    Para subir dos niveles y volver a `/home/`:

    ```bash
    cd ../../
    ```

<br>

## Explicación de `.` y `..`

-   `.` (punto): Representa el directorio actual. Se usa para referirse a la carpeta en la que ya estamos.

    ```bash
     # Equivalente a cd Documentos
    cd ./Documentos
    ```

-   `..` (doble punto): Representa el directorio padre (un nivel superior al actual). Se usa para **subir un nivel en la jerarquía de carpetas**.

    ```bash
     # Subimos un nivel
    cd ..
    ```

    ```bash
     # Subimos dos niveles
    cd ../..
    ```

<br>

### Ver en qué carpeta estamos

Para saber en qué directorio nos encontramos, usamos:

```bash
pwd
```

Esto imprimirá la ruta completa de nuestra ubicación actual.

<br>

### Listar archivos y carpetas

Para ver el contenido del directorio en el que estamos:

```bash
ls
```

Opciones útiles:

-   `ls -l` → Muestra detalles como permisos y tamaño.
-   `ls -a` → Muestra archivos ocultos.

<br>

### Movernos entre carpetas

Para cambiar de directorio usamos `cd`:

```bash
cd ./nombre-de-la-carpeta
```

Ejemplo: Para entrar en `Documentos`:

```bash
cd ./Documents
```

Para volver a la carpeta principal del usuario:

```bash
cd ~
```

También puedes utilizar simplemente `cd`:

```bash
cd
```

Para retroceder un nivel en la jerarquía de carpetas:

```bash
cd ..
```

Si queremos regresar dos niveles:

```bash
cd ../..
```

<br>

### Crear nuevas carpetas y archivos

Para crear una carpeta:

```bash
mkdir ./mi-carpeta
```

Para crear un archivo vacío:

```bash
touch ./archivo.txt
```

<br>

### Combinaciones de teclas útiles

-   **Copiar**: `Ctrl + Shift + C` (Windows/Linux) o `Cmd + C` (Mac)
-   **Pegar**: `Ctrl + Shift + V` (Windows/Linux) o `Cmd + V` (Mac)
-   **Autocompletar nombres**: `Tab` → Completa nombres de archivos o carpetas automáticamente.

Estos comandos y atajos permitirán una navegación eficiente en la terminal.

---
> [⬅️ Anterior: Introducción y configuración](01_introduccion_y_configuracion.md) | 📂 [Volver al índice](../README.md) | [Siguiente: Acciones prácticas ➡](03_acciones_practicas.md)
