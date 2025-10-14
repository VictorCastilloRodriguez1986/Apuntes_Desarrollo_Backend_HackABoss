# Práctica guiada I

En esta práctica, crearás un repositorio local de Git y aprenderás a realizar commits siguiendo buenas prácticas. También practicarás cómo agregar y eliminar archivos del repositorio, gestionar cambios con `git status` y `git log`, e ignorar archivos no deseados utilizando `.gitignore`.

<br>

## Antes de empezar

Hasta ahora, hemos aprendido los conceptos básicos de Git y cómo funciona. Ahora los aplicarás en un proyecto completo. Asegúrate de haber leído la teoría antes de empezar.

-   Crearás un repositorio local y harás commits siguiendo buenas prácticas.

-   Aprenderás a ignorar archivos con `.gitignore`.

-   Enlazarás tu repositorio con GitHub y harás tu primer `git push`.

-   Harás pruebas con `git pull` y resolverás conflictos manualmente.

-   Trabajarás con ramas y fusionarás cambios.

-   Utilizarás `git revert` para deshacer cambios correctamente.

<br>

## Crear un repositorio local y hacer commits

1. **Crea una nueva carpeta y entra en ella:**

    ```bash
    mkdir mi_proyecto
    cd mi_proyecto
    ```

2. **Inicializa Git en la carpeta (esto solo se hace una vez por repositorio):**

    ```bash
    git init
    ```

3. **Crea un archivo de texto y ábrelo con `nano` para editarlo:**

    ```bash
    nano colores.txt
    ```

    Escribe lo siguiente:

    ```
    Rojo
    Azul
    Verde
    ```

    Guarda y cierra (`CTRL + O`, `Enter`, `CTRL + X`).

4. **Verifica el estado del repositorio:**

    ```bash
    git status
    ```

    > Git te dirá que `colores.txt` es un archivo no rastreado.

5. **Agrega el archivo al stage y haz un commit:**

    ```bash
    git add colores.txt
    git commit -m "Añadido archivo colores.txt con colores básicos"
    ```

6. **Abre el archivo nuevamente y añade más colores:**

    ```bash
    nano colores.txt
    ```

    Agrega:

    ```
    Amarillo
    Naranja
    ```

    Guarda y cierra.

7. **Verifica el estado, agrega los cambios y haz otro commit:**

    ```bash
    git status
    git add colores.txt
    git commit -m "Añadidos más colores"
    ```

8. **Consulta el historial de commits:**
   
    ```bash
    git log --oneline
    ```
    
    Supongamos que ves algo como esto:
    
    ```
    a3f1d2b Añadidos más colores
    d9c8e4a Añadido archivo colores.txt con colores básicos
    ```
    
	> Observa que cada commit tiene un identificador único (hash). Usa estos identificadores para referenciar commits específicos.

<br>

## Eliminar un archivo del repositorio y agregarlo a `.gitignore`

En la vida real, es común que accidentalmente agregues archivos que contienen información sensible o que simplemente no quieres compartir, como contraseñas, archivos de configuración local o datos temporales. Afortunadamente, Git tiene una solución para esto.

1. **Crea un archivo privado que no queremos rastrear:**

    ```bash
    nano privado.txt
    ```

    Escribe:

    ```
    Este archivo contiene información privada.
    ```

    Guarda y cierra.

2. **Añádelo al repositorio por error:**

    ```bash
    git add privado.txt
    git commit -m "Añadido archivo privado por error"
    ```

3. **Eliminarlo del repositorio sin borrarlo del sistema:**

    ```bash
    git rm --cached privado.txt
    ```

    > Esto elimina `privado.txt` del repositorio, pero el archivo sigue existiendo en tu carpeta local.

4. **Confirma la eliminación con un nuevo commit:**

    ```bash
    git commit -m "Eliminado archivo privado del repositorio"
    ```

5. **Para evitar que este tipo de errores sucedan en el futuro, agregaremos `privado.txt` a `.gitignore`**

    ```bash
    nano .gitignore
    ```

    Añade lo siguiente:

    ```
    privado.txt
    ```

    Guarda y cierra.

6. **Verifica que Git ahora ignora `privado.txt`:**

    ```bash
    git status
    ```

    > `privado.txt` no debería aparecer como archivo pendiente de agregar.

7. **Confirma que `.gitignore` funciona agregándolo al repositorio:**
   
    ```bash
    git add .gitignore
    git commit -m "Añadido archivo .gitignore para ignorar archivos privados"
    ```

> Ahora, cualquier persona que descargue este repositorio desde GitHub no verá `privado.txt`, ya que Git lo ignorará de manera automática.

---
⬅ [Anterior: Ignorar archivos y manejar versiones](04_ignorar_archivos_versiones.md) | 📂 [Volver al índice](../README.md) | [Siguiente: Práctica II ➡](06_practica_II.md)
