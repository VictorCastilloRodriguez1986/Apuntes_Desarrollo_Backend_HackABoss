# Configuración de SSH para GitHub y GitLab

Cuando trabajamos con Git, podemos conectarnos a los servidores remotos usando dos protocolos: **SSH** y **HTTP**.

<br>

## ¿Por qué usar SSH en lugar de HTTP?

-   **Mayor seguridad**: SSH permite autenticarse con claves cifradas en lugar de escribir usuario y contraseña cada vez.

-   **Menos problemas al trabajar**: Con SSH, Git recuerda la clave de acceso y no necesitas autenticarte en cada operación.

-   **Obligatorio en muchas plataformas**: GitHub y GitLab han eliminado el soporte de autenticación con usuario y contraseña por HTTP, obligando a los usuarios a utilizar **SSH** o **tokens de acceso personal**.

Con SSH, establecemos una conexión cifrada y autenticada entre nuestro equipo y el servidor de GitHub o GitLab, permitiendo que las operaciones como `git push` y `git pull` sean más rápidas y seguras.

<br>

## Generar una clave SSH

Antes de poder usar SSH, necesitamos generar una clave única que identificará nuestro ordenador en GitHub/GitLab.

1. Abre **Git Bash** en Windows o **Terminal** en Mac.
   
2. Ejecuta el siguiente comando reemplazando tu correo:
   
    ```bash
    ssh-keygen -t ed25519 -C "tuemail@ejemplo.com"
    ```

3. **¡Importante!** Cuando el terminal te pregunte por una ubicación para guardar la clave, simplemente presiona **Enter** para aceptar la opción predeterminada.
   
4. Si te pide una contraseña opcional, puedes dejarla en blanco o definir una si deseas más seguridad.

<br>

## Agregar la clave SSH a GitHub

Ahora que hemos generado la clave SSH, hay que agregarla a GitHub para que nos reconozca.

1. Copia la clave pública con este comando:
   
    ```bash
    cat ~/.ssh/id_ed25519.pub
    ```

2. Ve a **GitHub** > **Settings** > **SSH and GPG keys** > **New SSH key**.
   
3. Pega la clave en el campo correspondiente y guarda los cambios.

<br>

## Probar la conexión SSH

Para comprobar que todo está configurado correctamente, ejecuta:

```bash
ssh -T git@github.com
```

Si la configuración es correcta, deberías ver un mensaje de bienvenida indicando que la conexión fue exitosa.

Después de este paso, tu ordenador estará listo para interactuar con GitHub de forma segura sin necesidad de ingresar usuario y contraseña en cada operación.

---
⬅ [Anterior: Instalación de Git](00_instalacion_configuracion.md) | 📂 [Volver al índice](../README.md) | [Siguiente: Creación de un repositorio ➡](02_creacion_uso_repositorio.md)