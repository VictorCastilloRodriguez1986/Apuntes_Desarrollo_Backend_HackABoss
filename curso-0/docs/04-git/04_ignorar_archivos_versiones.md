# Ignorar archivos y manejar versiones anteriores

<br>

## Uso de `.gitignore`

El archivo `.gitignore` es una herramienta fundamental en Git que permite indicar qué archivos o carpetas no deben ser rastreados ni añadidos al repositorio. Esto es útil para evitar que archivos innecesarios, temporales o con información sensible sean subidos al repositorio remoto.

<br>

### ¿Por qué es importante `.gitignore`?

-   **Mantiene el repositorio limpio**: Evita que archivos generados automáticamente por el sistema operativo o el entorno de desarrollo se suban al repositorio.

-   **Protege información sensible**: Permite excluir archivos como contraseñas, datos privados y configuraciones locales.

-   **Optimiza el rendimiento**: Evita que archivos grandes e irrelevantes ralenticen el trabajo con Git.

<br>

### Cómo usar `.gitignore`


1. Crea un archivo `.gitignore` en la raíz del proyecto:
   
    ```bash
    touch .gitignore
    ```

2. Edita el archivo y añade los archivos o carpetas que deseas ignorar:
   
    ```bash
    nano .gitignore
    ```
    
    Ejemplo de contenido:
    
    ```
    notas_personales/   # Carpeta donde guardas apuntes que no quieres subir
    configuracion.txt   # Archivo con configuraciones locales que solo necesitas tú
    *.backup            # Archivos de respaldo que no deberían subirse al repositorio
    ```

Es recomendable configurar este archivo antes de realizar el primer commit para evitar subir archivos no deseados al repositorio.

---
⬅ [Anterior: Flujo de trabajo](03_flujo_trabajo.md) | 📂 [Volver al índice](../README.md) | [Siguiente: Práctica I ➡](05_practica_I.md)

