# Práctica guiada II

En esta práctica, aprenderás a subir un repositorio local a GitHub, enlazándolo correctamente con un repositorio remoto y utilizando git push para enviar los cambios. También practicarás cómo descargar modificaciones desde GitHub con git pull y manejar conflictos que surgen cuando los cambios en el mismo archivo se hacen tanto de forma local como en remoto.

<br>

## Antes de empezar

Hasta ahora, hemos aprendido los conceptos básicos de Git y cómo funciona. Ahora los aplicarás en un proyecto completo. Asegúrate de haber leído la teoría antes de empezar.

-   Crearás un repositorio local y harás commits siguiendo buenas prácticas.

-   Aprenderás a ignorar archivos con `.gitignore`.

-   Enlazarás tu repositorio con GitHub y harás tu primer `git push`.

-   Harás pruebas con `git pull` y resolverás conflictos manualmente.

<br>

## Subir el repositorio a GitHub

1. **Crea un repositorio en GitHub:**

    - Ve a [GitHub](https://github.com) e inicia sesión.
    - Haz clic en **New Repository**.
    - Escribe el nombre `mi_proyecto`.
    - **No agregues README, `.gitignore` ni ningún otro archivo.**
    - Haz clic en **Create Repository**.

2. **Copia la URL SSH del repositorio (se verá como `git@github.com:usuario/mi_proyecto.git`).**

3. **Vincula el repositorio local con GitHub:**

    ```bash
    git remote add origin git@github.com:usuario/mi_proyecto.git
    ```

4. **Verifica que el enlace se haya creado correctamente:**

    ```bash
    git remote -v
    ```

    Esto debería mostrar:

    ```
    origin  git@github.com:usuario/mi_proyecto.git (fetch)
    origin  git@github.com:usuario/mi_proyecto.git (push)
    ```

5. **Sube los cambios con `git push` (la primera vez debe incluir `-u`):**

    ```bash
    git push -u origin main
    ```

    > Para futuros `push`, solo necesitarás escribir:

    ```bash
    git push
    ```

6. **Abre tu repositorio en GitHub y verifica que los archivos han sido subidos correctamente.** 🎉

<br>

## Descargar cambios desde GitHub con `git pull`

A veces, puede que haya cambios en el repositorio remoto que aún no tienes en tu copia local. Para traer esos cambios, usamos `git pull`.

1. **Modifica `colores.txt` directamente en GitHub (esto no es recomendable en la vida real, pero lo haremos para practicar `git pull`).**

    - Abre `colores.txt` en GitHub y haz clic en el ícono de edición (lápiz).
    - Agrega una nueva línea:
      
        ```
        Morado
        ```
    
	- Haz clic en **Commit changes**.

2. **Descarga los cambios desde GitHub:**
   
    ```bash
    git pull origin main
    ```
    
    Si todo va bien, Git descargará los cambios y los fusionará automáticamente.

<br>

## Generar un conflicto y solucionarlo

1. **Modifica `colores.txt` en GitHub agregando otra línea:**

    ```
    Cyan
    ```

    - Guarda los cambios.

2. **Modifica `colores.txt` localmente agregando otra línea diferente:**

    ```bash
    nano colores.txt
    ```

    - Agrega:
      
        ```
        Rosa
        ```
    
	- Guarda y cierra.

3. **Confirma el cambio en local:**

    ```bash
    git add colores.txt
    git commit -m "Añadido color Rosa localmente"
    ```

4. **Intenta hacer `git pull` nuevamente:**

    ```bash
    git pull origin main
    ```

    Esto generará un **conflicto** porque `colores.txt` ha cambiado tanto en GitHub como en tu equipo.

5. **Abre `colores.txt` y verás algo como esto:**

    ```
    <<<<<<< HEAD
    Rosa
    =======
    Cyan
    >>>>>>> nombre_del_commit_remoto
    ```

6. **¿Qué significan estos marcadores?**

    - `<<<<<<< HEAD` → Muestra la versión del archivo en tu repositorio local.
    - `=======` → Separa las dos versiones en conflicto.
    - `>>>>>>> nombre_del_commit_remoto` → Indica la versión del archivo que viene del repositorio remoto.

7. **Edita el archivo manualmente para combinar ambas versiones:**

    ```
    Rosa
    Cyan
    ```

    - Guarda y cierra el archivo.

8. **Confirma que has resuelto el conflicto:**

    ```bash
    git add colores.txt
    git commit -m "Conflicto resuelto en colores.txt"
    ```

9. **Sube los cambios corregidos a GitHub:**
   
    ```bash
    git push
    ```

---
⬅ [Anterior: Práctica I](05_practica_I.md) | 📂 [Volver al índice](../README.md) | [Siguiente: Bases de Datos Relacionales ➡](../05-sql/01_bases_de_datos_relacionales.md)

