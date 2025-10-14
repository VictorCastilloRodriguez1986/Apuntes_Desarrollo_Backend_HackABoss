# 3. Acciones Prácticas

Ahora que conoces cómo moverte en la terminal, vamos a aprender cómo crear, modificar y gestionar archivos y carpetas.



### Crear carpetas y archivos

Para crear una carpeta, usa el comando `mkdir`:

```bash
mkdir ./nueva-carpeta
```

Para crear un archivo vacío, usa `touch`:

```bash
touch ./archivo.txt
```

Puedes verificar que fueron creados con:

```bash
ls
```

Si deseas crear varias carpetas al mismo tiempo:

```bash
mkdir ./carpeta1 ./carpeta2 ./carpeta3
```

Si quieres crear una estructura de carpetas anidadas de una sola vez:

```bash
mkdir -p ./proyecto/src/utils
```

<br>

### Editar archivos con `nano`

El editor de texto `nano` te permite modificar archivos directamente desde la terminal. Para abrir un archivo:

```bash
nano ./archivo.txt
```

Escribe el contenido y usa las siguientes teclas:

-   **Guardar**: `Ctrl + O`, luego `Enter`
-   **Salir**: `Ctrl + X`

Si quieres abrir un archivo en modo solo lectura para evitar modificaciones accidentales:

```bash
nano -v ./archivo.txt
```

<br>

### Copiar archivos

Si necesitas hacer una copia de un archivo, usa el comando `cp`:

```bash
cp ./archivo.txt ./archivo-copia.txt
```

Para copiar carpetas enteras:

```bash
cp -r ./nueva-carpeta ./copia-carpeta
```

Si quieres copiar múltiples archivos a una carpeta:

```bash
cp ./archivo1.txt ./archivo2.txt ./destino/
```

<br>

### Mover y renombrar archivos

El comando `mv` permite mover archivos y también renombrarlos:

```bash
mv ./archivo.txt ./documento.txt
```

Para mover un archivo a otra carpeta:

```bash
mv ./documento.txt ./nueva-carpeta/
```

Si deseas mover múltiples archivos a la vez:

```bash
mv ./archivo1.txt ./archivo2.txt ./destino/
```

<br>

### Ver contenido de archivos

Para ver el contenido de un archivo sin abrirlo, usa `cat`:

```bash
cat ./documento.txt
```

<br>

### Navegación con `cd` y `ls` con rutas

En lugar de moverte con `cd` paso a paso, puedes ir directamente a una ubicación específica:

```bash
cd ./nueva-carpeta/subcarpeta
```

Si deseas ver el contenido de una carpeta sin moverte a ella, usa `ls` acompañado de la ruta:

```bash
ls ./nueva-carpeta
```

<br>

### Eliminar archivos y carpetas

Para eliminar un archivo:

```bash
rm ./documento.txt
```

Para eliminar una carpeta y su contenido:

```bash
rm -r ./nueva-carpeta
```

Si deseas eliminar múltiples archivos a la vez:

```bash
rm ./archivo1.txt ./archivo2.txt
```

**¡Cuidado!** Los archivos eliminados con `rm` no van a la papelera, desaparecen permanentemente.

---
> [⬅️ Anterior: Comandos básicos y navegación](02_comandos_basicos_y_navegacion.md) | [📂 Volver al índice](../README.md) | [Siguiente: Algoritmos I ➡](../02-algoritmos/01_algoritmos_1.md)
