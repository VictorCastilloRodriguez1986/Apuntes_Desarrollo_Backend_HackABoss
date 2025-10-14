# Instalación y configuración de Git

Git es un sistema de control de versiones que permite guardar y gestionar los cambios en los archivos de un proyecto.

<br>

## ¿Por qué usar Git?

-   **Historial de cambios**: Si algo sale mal, puedes volver a una versión anterior.

-   **Trabajo en equipo**: Permite que varias personas trabajen en el mismo proyecto sin pisarse los cambios.

-   **Copia de seguridad**: Tu código se puede guardar en la nube (en plataformas como GitHub), evitando pérdidas de información.

Si nunca has trabajado con Git, puedes imaginarlo como una caja fuerte donde cada cambio en los archivos queda registrado y puede ser recuperado en cualquier momento.

<br>

## Configuración inicial de Git

Después de instalar Git, hay que configurarlo con nuestro nombre y correo electrónico.

Ejecuta los siguientes comandos reemplazando con tu información:

```bash
git config --global user.name "Tu Nombre"
git config --global user.email "tuemail@ejemplo.com"
```

Para asegurarte de que todas las ramas principales se llamen `main` en lugar de `master`, configura Git con el siguiente comando:

```bash
git config --global init.defaultBranch main
```

<br>

### Configuración del Editor por Defecto

Si deseas usar IntelliJ IDEA como editor por defecto para Git, configúralo con el siguiente comando:

```bash
git config --global core.editor "intellij"
```

<br>

### Configuración para evitar problemas de cambios de línea

Cuando trabajas en equipo con diferentes sistemas operativos, es importante evitar problemas con los cambios de línea. Configura Git según tu sistema operativo:

-   **Mac y Ubuntu:**

    ```bash
    git config --global core.autocrlf input
    ```

-   **Windows:**

    ```bash
    git config --global core.autocrlf true
    ```

Más información sobre este tema en: [Cómo evitar problemas con cambios de línea en Git](https://www.campusmvp.es/recursos/post/git-como-evitar-problemas-con-cambios-de-linea-al-trabajar-en-equipo.aspx)

<br>

### ¿Por qué cambiar `master` por `main`?

Tradicionalmente, la rama principal en Git se llamaba `master`. Sin embargo, en los últimos años, la comunidad de desarrollo ha promovido el uso de `main` como la rama principal predeterminada. Esto se debe a una iniciativa para utilizar un lenguaje más inclusivo y evitar términos que puedan tener connotaciones problemáticas.

Además, la mayoría de plataformas como GitHub y GitLab ya han adoptado `main` como la rama predeterminada en los nuevos repositorios. Al establecer `main` como el nombre por defecto, evitamos inconsistencias y problemas al trabajar en diferentes entornos.

Para verificar la configuración, usa:

```bash
git config --list
```

Si necesitas cambiar algún valor, simplemente ejecuta el mismo comando con la información corregida.

---
> ⬅ [Anterior: Explorando IntelliJ](../03-entorno/02_explorando_intellij.md) | 📂 [Volver al índice](../README.md) | [Siguiente: Configuración SSH ➡](01_configuracion_ssh.md)
