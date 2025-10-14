# Flujo de trabajo en Git

Git nos permite llevar un control de versiones de nuestros proyectos, pero para usarlo correctamente, debemos entender su flujo de trabajo. A lo largo de este documento, aprenderás cómo manejar un repositorio local y cómo enlazarlo con un repositorio remoto (por ejemplo, en GitHub) para compartir tu código y asegurarlo en la nube.

<br>

## Concepto clave: El ciclo de trabajo en Git

Cuando trabajamos con Git, seguimos siempre este ciclo:

1. **Modificar archivos** en el proyecto.

2. **Añadir los cambios al _stage_** (preparar los archivos para ser guardados).
   
3. **Crear un _commit_** (guardar los cambios de forma permanente en el historial).
   
4. **Subir los cambios al repositorio remoto** con `git push`.

Si en algún momento necesitamos traer cambios nuevos del repositorio remoto, usamos `git pull`.

Este flujo de trabajo nos permite trabajar organizadamente y volver atrás si algo sale mal.

<br>

## Agregar cambios al _stage_

1. Verifica el estado del repositorio para ver qué archivos han sido modificados:
   
    ```bash
    git status
    ```

2. Agrega archivos al _stage_. **Importante:** este paso no guarda definitivamente los cambios, solo los prepara para ser confirmados en el siguiente paso.

    ```bash
    git add nombre_archivo.txt
    ```

    O para agregar todos los archivos modificados en la carpeta actual:

    ```bash
    git add .
    ```

    `.` indica que queremos incluir todos los cambios dentro de la carpeta actual.

3. Si agregaste un archivo por error, puedes quitarlo del _stage_ antes de hacer el _commit_ usando:
   
    ```bash
    git reset nombre_archivo.txt
    ```

<br>

## Crear commits

1. Una vez que los cambios están en el _stage_, se deben confirmar con un _commit_:

    ```bash
    git commit -m "Descripción de los cambios"
    ```

    **¿Qué es un commit y por qué es importante?**
    Un _commit_ es como un punto de guardado en la historia del proyecto. Cada vez que hacemos un _commit_, estamos creando un registro de los cambios, lo que nos permite regresar a versiones anteriores si algo sale mal.

2. **La importancia de escribir buenos mensajes de commit**
   
    - Un buen mensaje debe ser **claro y descriptivo**.
    - Evita mensajes genéricos como "cambios" o "actualización".
    - Ejemplo de un buen mensaje:
      
        ```bash
        git commit -m "Corrige error en el formulario de login"
        ```

<br>

## Subir cambios al repositorio remoto (por ejemplo, en GitHub)

1. Para compartir los cambios con otros o asegurarte de que están guardados en el servidor remoto, usa:
   
    ```bash
    git push
    ```

2. **¿Qué hace realmente `git push`?**
   
    - Envía los commits de la rama local al repositorio remoto.
    - Permite que otros colaboradores (o tú desde otro dispositivo) accedan a los cambios.
      
3. **Nota importante:**
   
    - La primera vez que subas cambios a un repositorio remoto, usa:
      
        ```bash
        git push -u origin main
        ```
        
        Esto establecerá la rama de seguimiento, de modo que en futuras ocasiones solo necesitas ejecutar `git push`.
        
4. Hasta que no ejecutes `git push`, los cambios seguirán estando solo en tu ordenador y no en el repositorio remoto.

---
⬅ [Anterior: Creación de un repositorio](02_creacion_uso_repositorio.md) | 📂 [Volver al índice](../README.md) | [Siguiente: Ignorar archivos y manejar versiones ➡](04_ignorar_archivos_versiones.md)
