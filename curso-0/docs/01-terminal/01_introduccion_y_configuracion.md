# 1. Introducción & configuración

El **terminal** es una herramienta para interactuar con el sistema operativo mediante comandos en lugar de hacer clic en iconos. Es una forma rápida y precisa de gestionar archivos y programas sin usar la interfaz gráfica.

Cuando abres el terminal, este siempre comienza en un directorio determinado de tu ordenador. **El terminal siempre trabaja dentro de un directorio, aunque no se vea directamente en la pantalla**. Para saber en qué ubicación estamos, debemos usar un comando específico.

-   **Windows (Git Bash recomendado)**: Se abrirá en `C:\Users\tu-usuario`, que es tu carpeta de usuario.

-   **Mac**: Se abrirá en `/Users/tu-usuario`, que es la carpeta equivalente en macOS.

-   **Ubuntu:** Se abrirá en `/home/tu-usuario`, que es la carpeta de usuario en sistemas basados en Linux.

<br>

### ¿Por qué recomendamos Git Bash en Windows?

Windows tiene su propia terminal llamada **PowerShell**, pero funciona de manera diferente a las terminales de Mac y Linux. Como en este curso utilizaremos comandos de terminal similares a los de sistemas Unix (Linux y Mac), recomendamos **Git Bash** en Windows porque:

-   Soporta los mismos comandos que en Linux y Mac, facilitando el aprendizaje.

-   Usa la barra `/` en las rutas en lugar de `\`, lo que evita confusión al trabajar con múltiples sistemas.

-   Permite utilizar herramientas como `ls`, `pwd`, y `cd` de la misma manera en cualquier sistema operativo.

Puedes descargar Git Bash desde [aquí](https://gitforwindows.org/) e instalarlo en tu computadora.

<br>

### Diferencia en rutas entre Windows y Git Bash

En **Windows**, las rutas de archivos y carpetas usan la barra invertida `\` como separador. Por ejemplo:

```bash
C:\Users\tu-usuario\Documents
```

Sin embargo, cuando usas **Git Bash en Windows**, las rutas se presentan con `/`, como en los sistemas Unix (Mac y Linux). Por lo tanto, la misma ruta en Git Bash se vería así:

```bash
/c/Users/tu-usuario/Documents
```

Esto es importante al ejecutar comandos dentro de Git Bash, ya que debes usar `/` en lugar de `\` para que los comandos funcionen correctamente.

---
> 📂 [Volver al índice](../README.md) | [Siguiente: Comandos básicos y navegación ➡](02_comandos_basicos_y_navegacion.md)
