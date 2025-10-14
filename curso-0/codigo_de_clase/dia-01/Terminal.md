# CURSO 0

## DIA 1

### Rutas

- **Rutas absolutas**: Comienzan desde la raíz del sistema de archivos. En Linux y Mac, la raíz es `/`. En Windows, la raíz es `C:\`, `D:\`, etc.
- **Rutas relativas**: Comienzan desde el directorio actual. Se puede usar `./` para referirse al directorio actual u omitir el `./.si.

### Terminal

#### Conceptos

- **Terminal**: Herramienta que permite interactuar con el sistema operativo a través de comandos de texto.
- **Windows**: `cmd` o `PowerShell`. Para poder usar todos los mismos comandos que en Linux y Mac debeis instalar [`Git Bash`](https://gitforwindows.org/).
- **Linux y Mac**: Terminal nativa del sistema operativo. En Linux, se puede usar `Ctrl + Alt + T` para abrirla.
- **Comandos**: Instrucciones que se le dan a la terminal para realizar acciones específicas. Se pueden usar argumentos para modificar su comportamiento.
- **Argumentos**: Opciones que se le pasan a un comando para modificar su comportamiento. Se pueden usar `-` o `--` para especificar opciones cortas o largas, respectivamente. Cortas suelen ser una letra y largas suelen ser palabras completas.
- **Autocompletar**: Se puede usar la tecla `Tab` para autocompletar nombres de archivos y directorios. Si hay varias opciones, se puede presionar `Tab` dos veces para ver las opciones disponibles.
- **`Ruta raiz`**: Es la ruta absoluta del sistema de archivos donde se encuentran todos los archivos y directorios. En Linux y Mac, la raíz es `/`. En Windows, la raíz es `C:\`, `D:\`, etc.
- **`Ruta usuario`**: Es la ruta absoluta del directorio del usuario actual. En Linux y Mac, suele ser `/home/usuario`. En Windows, suele ser `C:\Users\usuario`.

#### Comandos básicos

- **`pwd`**(print working directory): : Muestra la ruta absoluta del directorio actual

  ```bash
  pwd
  ```

- **`ls`**(list): Muestra los archivos y carpetas del directorio actual. Se le pueden pasar argumentos para modificar su comportamiento como: l, a,... Támbien puede recibir rutas absolutas o relativas.

  ```bash
  ls
  ```

  - Muestra los archivos y carpetas de la ruta relativa o absoluta especificada

    ```bash
    ls ./nombre_directorio
    ls ./nombre_directorio/nombre_directorio
    ls /nombre_directorio
    ls /nombre_directorio/nombre_directorio
    ```

  - Muestra los archivos y carpetas con detalles (permisos, propietario, tamaño, etc.)

    ```bash
    ls -l
    ls -l ./nombre_directorio
    ls -l ./nombre_directorio/nombre_directorio
    ls -l /nombre_directorio
    ls -l /nombre_directorio/nombre_directorio
    ```

  - Muestra todos los archivos, incluyendo los ocultos (que empiezan con .)

    ```bash
    ls -a
    ls -a ./nombre_directorio
    ls -a ./nombre_directorio/nombre_directorio
    ls -a /nombre_directorio
    ls -a /nombre_directorio/nombre_directorio
    ```

  - Muestra todos los archivos y carpetas con detalles

    ```bash
    ls -la
    ls -la ./nombre_directorio
    ls -la ./nombre_directorio/nombre_directorio
    ls -la /nombre_directorio
    ls -la /nombre_directorio/nombre_directorio
    ```

- **`cd`**(change directory): Cambia el directorio en el que estás trabajando. Evitar usar espacios, caracteres especiales y acentos en los nombres de archivos y carpetas. Se puede usar tabulador para autocompletar nombres.

  - Sube un nivel en la jerarquía de directorios. Me lleva al directorio padre del actual.

    ```bash
    cd ../
    ```

  - Va al directorio home del usuario

    ```bash
    cd ~
    ```

  - **`cd /`**: Va al directorio raíz del sistema.

    - Raíz del sistema para Linux y Mac

      ```bash
      cd /
      ```

    - Raíz del sistema para Windows. Puede haber otras letras como /d, /e, etc.

      ```bash
      cd /c
      cd /d
      cd /e
      ```

  - Cambia al directorio especificado en la ruta relativa desde el directorio actual

    ```bash
    cd ./nombre_directorio
    cd ./nombre_directorio/nombre_directorio
    cd nombre_directorio
    cd nombre_directorio/nombre_directorio
    ```

  - Cambia al directorio especificado en la ruta absoluta

    ```bash
    cd /nombre_directorio
    cd /nombre_directorio/nombre_directorio
    ```

  - Cambia al directorio en el que estaba anteriormente

    ```bash
    cd -
    ```

- **`mkdir`**(make directory): Crea un nuevo directorio

  - Crea un nuevo directorio en la ruta relativa o absoluta especificada. Tienen que existir todos los directorios intermedios. Si ya existe el directorio, no se creará.

    ```bash
    mkdir ./nombre_directorio
    mkdir ./nombre_directorio/nombre_directorio2
    mkdir nombre_directorio
    mkdir nombre_directorio/nombre_directorio2
    mkdir /nombre_directorio1/nombre_directorio2
    ```

  - Crea un nuevo directorio y todos los directorios intermedios que no existan según la ruta relativa o absoluta especificada.

    ```bash
    mkdir -p ./nombre_directorio1/nombre_directorio2/nombre_directorio3
    mkdir -p nombre_directorio1/nombre_directorio2/nombre_directorio3
    mkdir -p /nombre_directorio1/nombre_directorio2/nombre_directorio3
    ```

  - Crea dos nuevos directorios según la ruta relativa o absoluta especificada.

    ```bash
    mkdir ./nombre_directorio1 ./nombre_directorio2
    mkdir nombre_directorio1 nombre_directorio2
    ```

- **`rm`**(remove): Elimina un archivo o directorio (con precaución). Si intento borrar un directorio, me dará un error porque puede contener archivos y directorios.

  - Elimina el archivo especificado en la ruta relativa o absoluta. Si el archivo está en uso, no se eliminará.

    ```bash
    rm ./nombre_archivo.ext
    rm nombre_archivo.ext
    rm ./nombre_directorio/nombre_archivo.ext
    rm nombre_directorio/nombre_archivo.ext
    rm /nombre_directorio/nombre_archivo.ext
    ```

  - Elimina varios archivos especificados en las rutas relativas o absolutas. Si algún archivo está en uso, no se eliminará.

    ```bash
    rm ./nombre_archivo1.ext ./nombre_archivo2.ext
    rm nombre_archivo1.ext nombre_archivo2.ext
    rm /nombre_directorio/nombre_archivo1.ext /nombre_directorio/nombre_archivo2.ext
    ```

  - Elimina un directorio y su contenido de forma recursiva

    ```bash
    rm -r ./nombre_directorio
    rm -r nombre_directorio
    rm -r ./nombre_directorio/nombre_directorio
    rm -r nombre_directorio/nombre_directorio
    rm -r /nombre_directorio
    rm -r /nombre_directorio/nombre_directorio
    ```

- **`touch`**: Crea un nuevo archivo vacío con el nombre especificado en la ruta relativa o absoluta.

  ```bash
  touch ./nombre_archivo.ext
  touch nombre_archivo.ext
  touch ./nombre_directorio/nombre_archivo.ext
  touch nombre_directorio/nombre_archivo.ext
  touch /nombre_directorio/nombre_archivo.ext
  ```

- **`nano`**: Editor de texto en la terminal

  - Abre el archivo especificado en el editor de texto nano. Si el archivo no existe, lo crea.

    ```bash
    nano ./nombre_archivo
    nano nombre_archivo
    nano ./nombre_directorio/nombre_archivo
    nano nombre_directorio/nombre_archivo
    nano /nombre_directorio/nombre_archivo
    ```

  - No permite posicionarse con el ratón, pero se puede usar el teclado para navegar
  - Ctrl + O: Guarda el archivo.
  - Ctrl + X: Cierra el editor de texto

- **`cat`**(concatenar): Muestra el contenido de un archivo.

  - Muestra el contenido del archivo especificado en la ruta relativa o absoluta. Si el archivo no existe, muestra un error.

    ```bash
    cat ./nombre_archivo
    cat nombre_archivo
    cat ./nombre_directorio/nombre_archivo
    cat nombre_directorio/nombre_archivo
    cat /nombre_directorio/nombre_archivo
    ```

  - Muestra el contenido de ambos archivos concatenados. Si alguno de los archivos no existe, muestra un error.

    ```bash
    cat ./nombre_archivo1 ./nombre_archivo2
    cat nombre_archivo1 nombre_archivo2
    cat ./nombre_directorio/nombre_archivo1 ./nombre_directorio/nombre_archivo2
    cat nombre_directorio/nombre_archivo1 nombre_directorio/nombre_archivo2
    cat /nombre_directorio/nombre_archivo1 /nombre_directorio/nombre_archivo2
    ```

  - Redirige el contenido de nombre_archivo1 a nombre_archivo2 (sobrescribiendo)

    ```bash
    cat ./nombre_archivo1 > ./nombre_archivo2
    cat nombre_archivo1 > nombre_archivo2
    cat ./nombre_directorio/nombre_archivo1 > ./nombre_directorio/nombre_archivo2
    cat nombre_directorio/nombre_archivo1 > nombre_directorio/nombre_archivo2
    cat /nombre_directorio/nombre_archivo1 > /nombre_directorio/nombre_archivo2
    ```

  - Añade al final de nombre_archivo2 el contenido de nombre_archivo1 sin sobrescribir

    ```bash
    cat ./nombre_archivo1 >> ./nombre_archivo2
    cat nombre_archivo1 >> nombre_archivo2
    cat ./nombre_directorio/nombre_archivo1 >> ./nombre_directorio/nombre_archivo2
    cat nombre_directorio/nombre_archivo1 >> nombre_directorio/nombre_archivo2
    cat /nombre_directorio/nombre_archivo1 >> /nombre_directorio/nombre_archivo2
    ```

- **`cp`**(copy): Copia archivos o directorios. Primero se especifica el archivo o directorio de origen y luego el destino

  - Copia el archivo especificado en la ruta especificada. Usa el mismo nombre de archivo.

    ```bash
    cp ./nombre_archivo.ext ./nombre_directorio
    cp nombre_archivo.ext nombre_directorio
    cp ./nombre_directorio/nombre_archivo.ext ./nombre_directorio/nombre_archivo_copiado.ext
    cp nombre_directorio/nombre_archivo.ext nombre_directorio/nombre_archivo_copiado.ext
    cp /nombre_directorio/nombre_archivo.ext /nombre_directorio/nombre_archivo_copiado.ext
    ```

  - Copia el archivo especificado en la ruta especificada. Usa un nuevo nombre de archivo.

    ```bash
    cp ./nombre_archivo.ext ./nombre_archivo_copiado.ext
    cp ./nombre_directorio/nombre_archivo.ext ./nombre_archivo_copiado.ext
    cp nombre_archivo.ext nombre_archivo_copiado.ext
    cp nombre_directorio/nombre_archivo.ext nombre_archivo_copiado.ext
    cp /nombre_directorio/nombre_archivo.ext /nombre_directorio/nombre_archivo_copiado.ext
    ```

  - Copia el directorio especificado con su contenido en la ruta especificada.

    ```bash
    cp -r ./nombre_directorio ./nombre_directorio_copia
    cp -r nombre_directorio nombre_directorio_copia
    cp -r ./nombre_directorio/nombre_directorio ./nombre_directorio_copia
    cp -r nombre_directorio/nombre_directorio nombre_directorio_copia
    cp -r /nombre_directorio/nombre_directorio /nombre_directorio/nombre_directorio_copia
    ```

- **`mv`**(move): Mueve o renombra archivos o directorios

  - Mover el archivo especificado en la ruta especificada. Usa el mismo nombre de archivo.

    ```bash
    mv ./nombre_archivo.ext ./nombre_directorio
    mv nombre_archivo.ext nombre_directorio
    mv ./nombre_directorio/nombre_archivo.ext ./nombre_directorio1/nombre_directorio2
    mv nombre_directorio/nombre_archivo.ext nombre_directorio1/nombre_directorio2
    mv /nombre_directorio/nombre_archivo.ext /nombre_directorio1/nombre_directorio2
    ```

  - **`mv ./nombre_archivo.ext ./nombre_directorio`**: Mueve el archivo especificado a la ruta especificada. Renombra el archivo.

    ```bash
    mv ./nombre_archivo.ext ./nombre_directorio/nombre_archivo_renombrado.ext
    mv nombre_archivo.ext nombre_directorio/nombre_archivo_renombrado.ext
    mv ./nombre_directorio/nombre_archivo.ext ./nombre_directorio/nombre_archivo_renombrado.ext
    mv nombre_directorio/nombre_archivo.ext nombre_directorio/nombre_archivo_renombrado.ext
    mv /nombre_directorio/nombre_archivo.ext /nombre_directorio/nombre_archivo_renombrado.ext
    ```

  - **`mv /nombre_directorio/nombre_archivo.ext /nombre_directorio/nombre_directorio/nombre_archivo_renombrado.ext`**: Mueve el archivo especificado en la ruta absoluta al directorio especificado y lo renombra
  - **`mv ./nombre_archivo.ext ./nombre_directorio`**: Mueve el archivo especificado en la ruta actual al directorio especificado
  - **`mv /nombre_directorio/nombre_archivo.ext /nombre_directorio/nombre_archivo_renombrado.ext`**: Renombra el archivo especificado en la ruta absoluta
  - **`mv /nombre_directorio/nombre_archivo.ext /nombre_directorio/nombre_directorio/nombre_archivo_renombrado.ext`**: Mueve el archivo especificado en la ruta absoluta al directorio especificado y lo renombra

- **`clear`**: Limpia la pantalla de la terminal

- **Comandos de ayuda**: Se pueden usar `--help` para ver la documentación de un comando. Por ejemplo, `ls --help`.
