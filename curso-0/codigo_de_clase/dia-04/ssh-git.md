# Ssh y Git

## SSH

SSH es un protocolo de red que nos permite conectarnos a un servidor remoto de forma segura.

### Crear las claves pública y privada

Para conectarnos a un servidor remoto con SSH, debemos generar una clave pública y privada.

1. Para generar una clave pública y privada, abrimos una terminal y ejecutamos el comando:

   ```bash
   ssh-keygen -t ed25519 -C "tu-email@dominio.com"
   ```

   - El comando **`ssh-keygen`** nos permite generar una clave pública y privada.
   - El parámetro **`-t ed25519`** especifica el tipo de clave a generar.
   - El parámetro **`-C "correoElectronico"`** añade un comentario a la clave, normalmente el email.

2. El comando nos preguntará el nombre del archivo donde guardar la clave. Si no se especifica, usará el nombre por defecto (**`id_ed25519`**).  
   Para usar varias claves SSH (por ejemplo, para GitHub personal y del trabajo), usa nombres diferentes.

3. El comando preguntará si queremos añadir una contraseña a la clave. Si pulsamos **`Enter`**, no se añade contraseña.

---

### Añadir la clave pública a cada servidor remoto(GitHub, GitLab, etc.)

Una vez generado el par de claves, debemos añadir la clave pública a cada servidor remoto.

1. Para añadir la clave pública a nuestro servidor remoto, debemos copiar su contenido:

   ```bash
   cat ~/.ssh/id_ed25519.pub
   ```

   - El comando **`cat`** muestra el contenido de un archivo.
   - La ruta **`~/.ssh/id_ed25519.pub`** corresponde al archivo de la clave pública.
   - Si creaste la clave con otro nombre, usa **`~/.ssh/nombre.pub`**.

2. Una vez copiado el contenido de la clave pública, debemos añadirlo a nuestro servidor remoto.

3. Accede a la interfaz web del servidor remoto y añade la clave pública.

---

### Configuración si tenemos varias cuentas de GitHub

Si tenemos varias cuentas de GitHub (por ejemplo, una personal y otra del trabajo), GitHub no nos permite usar la misma clave SSH para ambas cuentas. Esto significa que debemos crear una clave SSH diferente para cada cuenta siguiendo los pasos anteriores.

Una vez tenemos las claves SSH, debemos crear un archivo **`config`** en **`~/.ssh`** con la siguiente configuración:

1. Para crear el archivo **`config`** en la carpeta **`~/.ssh`**, abrimos una terminal y ejecutamos el comando **`cd ~/.ssh`** para situarnos en la carpeta **`~/.ssh`** y el comando **`nano config`** para crear el archivo **`config`** y abrirlo directamente con el editor de texto **`nano`**.

   ```bash
   cd ~/.ssh
   nano config
   ```

2. Dentro del archivo config añadimos la configuración de las distintas claves SSH con el siguiente formato:

   ```bash
   # Configuración para una cuenta de GitHub
   Host github.com
   HostName github.com
   User git
   IdentityFile ~/.ssh/id_ed25519
   # Configuración para otra cuenta de GitHub
   Host github.com-personal
   HostName github.com
   User git
   IdentityFile ~/.ssh/id_ed25519_personal
   ```

   - **`Host`**: Nombre del host al que nos conectamos. El primero es **`github.com`** y el segundo es **`github.com-personal`**.
   - **`HostName`**: Nombre del host al que nos conectamos. En este caso, ambos son **`github.com`**.
   - **`User`**: Nombre de usuario que usamos para conectarnos al host. En este caso, ambos son **`git`**.
   - **`IdentityFile`**: Ruta del archivo de la clave privada. En este caso, la primera es **`~/.ssh/id_ed25519`** y la segunda es **`~/.ssh/id_ed25519_personal`**.

3. Cuando copiamos el enlace del repositorio de **`GitHub`** para clonarlo, debemos cambiar **`Host`** por el que hemos especificado en el archivo **`config`** de la siguiente forma:

   ```bash
   git clone git@github.com:usuario1/repositorio.git
   git clone git@github.com-personal:usuario2/repositorio.git
   ```

   - El primer comando es el que usamos para la primera cuenta de GitHub y se queda tal cual lo copiamos de GitHub.
   - El segundo comando es el que usamos para la segunda cuenta de GitHub. En este caso, cambiamos la parte que hay entre la **`@`** y los **`:`** por el **`Host`** que hemos especificado en el archivo **`config`**.

---

### Automatizar la clonación de repositorios

Si ya queremos frikear un poco mas, podemos automatizar el proceso de clonación de repositorios para no tener que estar cambiando el host cada vez que clonamos un repositorio.

1. Para ello, crearemos un archivo **`clone_repo`** en la carpeta **`.ssh`** usando el comando **`nano ~/.ssh/clone_repo`** y añadiremos el siguiente contenido:

   ```python
   #!/bin/bash
   # Uso: ./clone_personal_repo [tipo(repositorio personal/trabajo)] nombre_repositorio
   tipo=$1
   repositorio=$2
   # Si solo se proporciona un parámetro, asumir que es un repositorio de trabajo
   if [ -z "$repositorio" ]; then
       tipo="trabajo"
       repositorio=$1
   fi
   if [ "$tipo" = "trabajo" ]; then
       git clone git@github.com:usuario/$repositorio.git
       echo "Repositorio de trabajo clonado."
   elif [ "$tipo" = "personal" ]; then
       git clone git@github.com-personal:usuario/$repositorio.git
       echo "Repositorio personal clonado."
   else
       echo "Tipo no reconocido. Uso: ./clone_personal_repo [tipo(repositorio personal/trabajo)] nombre_repositorio"
       exit 1
   fi
   ```

2. Para que el script esté disponible desde cualquier lugar, debemos añadir la carpeta **`.ssh`** al **`PATH`**. Para esto debemos añadir la siguiente línea **`export PATH="$HOME/.ssh:$PATH"`** al archivo **`.bashrc`**, **`.zshrc`** o **`.bash_profile`** según el terminal y el sistema operativo que estemos usando.

   ```bash
   export PATH="$HOME/.ssh:$PATH"
   ```

3. Para ejecutar el script, debemos darle permisos de ejecución con el comando **`chmod +x ~/.ssh/clone_repo`** y ejecutarlo con el comando **`clone_repo personal nombreRepositorio`** para clonar un repositorio personal o **`clone_repo trabajo nombreRepositorio`** para clonar un repositorio de trabajo.

   ```bash
   chmod +x ~/.ssh/clone_repo

   clone_repo personal nombreRepositorio
   clone_repo trabajo nombreRepositorio
   ```

4. Si queremos clonar un repositorio sin especificar el tipo, podemos hacerlo con el comando **`clone_repo nombreRepositorio`** y asumirá que es un repositorio de trabajo.

   ```bash
   clone_repo nombreRepositorio
   ```

---

## Git

Git es un sistema de control de versiones para el mantenimiento eficiente y confiable de archivos.

Git trabaja de forma descentralizada, es decir, cada desarrollador tiene una copia completa del historial del proyecto y puede trabajar sin conexión.

Permite el trabajo colaborativo, ya que cada uno puede trabajar en su propia rama y luego fusionar los cambios.

Para verificar que tenemos Git instalado, ejecutamos el siguiente comando:

```bash
git --version
```

### Configurar Git

Después de instalarlo, debemos configurar Git con nuestro nombre, email, rama por defecto, editor predeterminado, ...:

```bash
git config --global user.name "nombreUsuario"
git config --global user.email "correoElectronico"
git config --global init.defaultBranch main
git config --global core.editor "intellij"
git config --global core.autocrlf valor
git config --global -e
git config --list
```

- **`--global`**: Aplica la configuración a todos los repositorios del usuario. Si no se especifica, solo se aplica al repositorio actual.
- **`--system`**: Aplica la configuración a todos los usuarios del sistema. Se puede usar en lugar de **`--global`**.
- **`--local`**: Aplica la configuración solo al repositorio actual. Se puede usar en lugar de **`--global`**.
- **`user.name`**: Configura el nombre de usuario que se usará en los commits.
- **`user.email`**: Configura el correo electrónico que se usará en los commits.
- **`init.defaultBranch`**: Configura la rama por defecto al crear un nuevo repositorio. Por defecto es **`master`**.
- **`core.editor`**: Configura el editor de texto que se usará para editar los mensajes de commit.
- **`core.autocrlf`**: Configura el comportamiento de los finales de línea.
  - **`true`**: Para los de windows. En el comando, cambiar **`valor`** por **`true`**.
  - **`input`**: Para los de Mac/Linux. En el comando, cambiar **`valor`** por **`input`**.
- **`-e`**: Abre el archivo de configuración en el editor de texto configurado.
- **`--list`**: Muestra la configuración actual de Git.

---

### Conceptos básicos de Git

#### Repositorio

Un **repositorio** es el lugar donde se almacenan los archivos de un proyecto. Puede ser:

- **Local**: Creado en tu ordenador con el comando `git init`.
- **Remoto**: Alojado en servicios como GitHub, GitLab o Bitbucket.

#### Etapas

Un repositorio tiene vaias etapas:

1. **Working Directory**: Donde trabajamos en los archivos. Aquí hacemos cambios y añadimos nuevos archivos.

2. **Staging Area**: Es el área de preparación. Es el lugar donde se encuentran los archivos que se van a añadir al repositorio despues de hacer **`git add .`**.

3. **Local Repository**: Es el lugar donde se encuentran los archivos del proyecto que están listos para ser enviados al repositorio remoto despues de hacer **`git commit -m "Mensaje del commit"`**. La **`Statging area`** estaría vacía.

4. **Remote Repository**: Es el servidor remoto donde se encuentran los archivos del proyecto despues de usar el comando **`git push`**.

   ```bash
   git add .
   git commit -m "Mensaje del commit"
   git push
   ```

#### Clone

El comando **`git clone`** se usa para clonar un repositorio remoto en nuestro ordenador. Esto crea una copia local del repositorio remoto.

```bash
git clone https://github.com/usuario/repositorio.git
```

#### Status

El comando **`git status`** se usa para ver el estado del repositorio. Muestra los archivos que han sido modificados, añadidos al área de preparación y los que no están siendo rastreados.

```bash
git status
```

#### Log

El comando **`git log`** se usa para ver el historial de commits del repositorio. Muestra información sobre cada commit, como el autor, la fecha y el mensaje del commit.

```bash
git log
git log --oneline
git log --graph
git log --decorate
```

- **`--oneline`**: Muestra el historial de commits en una sola línea por commit.

#### Add

Es el proceso de añadir los archivos al área de preparación(Staging Area). Se puede comparar con el proceso de añadir los archivos a una cesta de la compra.

```bash
git add .
```

- **`.`**: Añade todos los archivos del directorio actual al área de preparación.
- **`nombreArchivo`**: Añade un archivo específico al área de preparación.
- **`nombreCarpeta`**: Añade una carpeta específica al área de preparación.
- **`.ext`**: Añade todos los archivos con una extensión específica al área de preparación.

  Si añadiste un archivo por error al **`área de preparación`**, puedes quitarlo con el comando **`git reset nombreArchivo.ext`**.

#### Commit

Es una instantánea de los archivos del proyecto en un momento determinado. Se puede comparar con una fotografía de los archivos en ese momento.

```bash
git commit -m "Mensaje del commit"
```

- **`-m`**: Indica que se va a añadir un mensaje al commit.
- **`"Mensaje del commit"`**: Mensaje que describe los cambios realizados en el commit. Es importante que el mensaje sea claro y conciso.

#### Push

Es el proceso de subir los **`commits locales`** a un **`repositorio remoto`**.

```bash
git push -u origin main
git push
```

- **`-u`**: Indica que se va a establecer una relación entre la rama local y la rama remota. Esto significa que la próxima vez que hagamos un **`push`**, no será necesario especificar el nombre de la rama remota.
- **`origin`**: Es el nombre del remoto. Por defecto, es **`origin`**.
- **`main`**: Es el nombre de la rama remota a la que se va a hacer el **`push`**. Por defecto, es **`main`**.

#### Pull

Es el proceso de traer los **`commits`** de un **`repositorio remoto`** a un **`repositorio local`**.

```bash
git pull
```

---

### Crear un nuevo repositorio

#### Repositorio local

1. Para crear un repositorio local debemos situarnos en la carpeta del proyecto y ejecutar el comando **`git init`**.

   Si no hay carpeta del proyecto podemos crearla con el comando **`mkdir nombreCarpeta`**, situarnos en ella con el comando **`cd nombreCarpeta`** y ejecutar el comando **`git init`**.

   No influye si la carpeta está vacía o contiene archivos.

   Este comando crea una carpeta oculta llamada **`.git`** que contiene toda la información del repositorio.

   Para comprobar que se ha creado el repositorio local, podemos ejecutar el comando **`ls -a`** para listar los archivos y carpetas ocultas y comprobar que existe la carpeta **`.git`**.

2. Tenemos que crear un repositorio remoto en **GitHub, GitLab, Bitbucket, ...** para poder vincularle el repositorio local.

   Una vez creado el repositorio remoto, lo vinculamos con el repositorio local por primera vez con el comando **`git remote add origin git@github.com:usuario/repositorio.git`**.

3. Para subir los commits locales por primera vez al repositorio remoto, primero hay que añadir los archivos al área de preparación con **`git add .`** y hacer el commit con **`git commit -m "Mensaje del commit"`** y despues ejecutamos el comando **`git push -u origin main`**.

   A partir de haber hecho el primer **`push`**, podemos subir los commits locales al repositorio remoto con el comando **`git push`**.

4. Puedo verificar que el repositorio remoto está vinculado al repositorio local con el comando **`git remote -v`**.

   ```bash
   git remote -v
   ```

   Este comando nos mostrará la URL del repositorio remoto y el nombre del remoto (normalmente **`origin`**).

#### Repositorio remoto

1. Tenemos que crear un repositorio remoto en **GitHub, GitLab, Bitbucket, ...**.

2. Una vez creado el repositorio, debemos clonar el **`repositorio remoto`** en un **`repositorio local`**. Accedemos a la interfaz web del **`repositorio remoto`** y copiamos el enlace del repositorio.

   ```bash
   git clone https://github.com/usuario/repositorio.git
   ```

3. Una vez clonado el **`repositorio remoto`**, podemos empezar a trabajar y añadir los archivos al área de preparación con **`git add .`**, hacer el commit con **`git commit -m "Mensaje del commit"`** y despues ejecutamos el comando **`git push`**.

```bash
git add .
git commit -m "Mensaje del commit"
git push
```

---

### Ignorar archivos

Si queremos ignorar archivos o carpetas en un repositorio, debemos crear un archivo llamado **`.gitignore`** en la raíz del repositorio y añadir los nombres de los archivos o carpetas que queremos ignorar.

```bash
# Ignorar archivos de un tipo específico
*.ext
# Ignorar una carpeta
carpeta/
# Ignorar un archivo específico
archivo.ext
# Ignorar todos los archivos de un tipo específico en una carpeta
carpeta/*.ext
```

---
