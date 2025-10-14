# Creación y uso de un repositorio

Antes de empezar, es importante entender que un repositorio **local** y un repositorio **remoto** no son lo mismo:

-   Un **repositorio local** es la versión del proyecto que está almacenada en tu ordenador. Aquí puedes hacer cambios, crear nuevas versiones y administrar archivos sin necesidad de conexión a internet.

-   Un **repositorio remoto** es la copia del proyecto almacenada en un servidor en la nube, como GitHub. Esto permite compartir el código con otros colaboradores y asegurarse de que haya un respaldo accesible desde cualquier dispositivo.

Para entenderlo mejor, podemos comparar **GitHub** con servicios como **Google Drive** o **Dropbox**. Así como en Drive subimos archivos para guardarlos en la nube y compartirlos con otros, en GitHub subimos nuestro código para almacenarlo de forma segura y permitir la colaboración con otros desarrolladores.

<br>

### Importante: Los repositorios locales y remotos no se sincronizan automáticamente

A diferencia de servicios como Google Drive, donde los archivos se actualizan automáticamente en todos los dispositivos conectados, **Git no sincroniza automáticamente los cambios entre el repositorio local y el remoto**.

-   Si realizas cambios en tu repositorio local, **debes subirlos manualmente** con `git push` para que aparezcan en el remoto.

-   Si hay cambios nuevos en el repositorio remoto, **debes descargarlos manualmente** con `git pull` para actualizarlos en tu copia local.

Si no ejecutas estos comandos, tu repositorio local y el remoto pueden estar desactualizados respecto al otro, lo que podría generar conflictos o pérdida de trabajo si no se gestionan correctamente.

<br>

## Crear un repositorio local

1. Abre **Git Bash** en Windows o **Terminal** en Mac.

2. Crea una carpeta para tu proyecto:

    ```bash
    mkdir mi-proyecto
    cd mi-proyecto
    ```

3. Inicializa un repositorio Git:

    ```bash
    git init
    ```

<br>

## Crear un repositorio remoto en GitHub o GitLab

1. Accede a **GitHub** o **GitLab** y crea un nuevo repositorio.

2. **Es importante que copies la URL del repositorio en formato SSH y no HTTP.** La URL SSH tiene el siguiente formato: `git@github.com:usuario/repo.git`. No uses URLs que comiencen con `https://`.

<br>

## Enlazar el repositorio local con el remoto

1. Ejecuta el siguiente comando, reemplazando `URL_DEL_REPOSITORIO` por la URL SSH copiada:

    ```bash
    git remote add origin URL_DEL_REPOSITORIO
    ```

2. Verifica que el repositorio se ha enlazado correctamente con:

    ```bash
    git remote -v
    ```

## Clonando un repositorio remoto

Es posible clonar un repositorio remoto con el comando `git clone`. Esto descarga el repositorio en el directorio indicado en el terminal, de tal forma que ya no será necesario crearlo manualmente ni enlazarlo:

```bash
git clone git@github.com:usuario/repo.git
```

---
⬅ [Anterior: Configuración SSH](01_configuracion_ssh.md) | 📂 [Volver al índice](../README.md) | [Siguiente: Flujo de trabajo ➡](03_flujo_trabajo.md)
