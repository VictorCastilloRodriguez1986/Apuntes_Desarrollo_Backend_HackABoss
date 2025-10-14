# Ejercicios Día 1

## Ejercicio Nº 1 - Exploradores del Sistema de Archivos

**a) Crea tu propio espacio:**

- Antes de comenzar, ten en cuenta que los nombres que inicien con una barra `/ejemplo` representan un **directorio** (también llamado **carpeta**). En este caso, la carpeta se llama `ejemplo`.

- Ahora sí, abre la terminal. Trata de ver en qué carpeta estás ubicado.

- Ejecuta el comando `mkdir miExploracion` para crear un directorio llamado `/miExploracion`.

- Navega a dicho directorio usando `cd miExploracion`.

**b) Organiza tus hallazgos:**

- Dentro de `/miExploracion`, crea tres subdirectorios: `/documentos`, `/imagenes` y `/proyectos` usando `mkdir`.

- Navega al directorio `/documentos` (`cd documentos`).

- Dentro de `/documentos` crea dos subdirectorios `/personales` y `/trabajo`.

**c) Muévete con destreza:**

- Desde el directorio `/documentos`, regresa al directorio principal `/miExploracion` utilizando `cd ..`

- Desde `/miExploracion` entra al directorio `/imagenes`.

- Desde `/imagenes`, regresa al directorio principal `/miExploracion` utilizando `cd ..`

**d) Limpia tu camino y versión de Java:**

- En cualquier momento, si tu terminal se llena de comandos, utiliza `clear` para limpiar la pantalla.

- Investiga qué **versión de JDK** tienes instalado en tu máquina con el comando `java --version`

---

## Ejercicio Nº 2 - Explorando el Universo IntelliJ IDEA 2025

**a) Creando un proyecto:**

- Abre IntelliJ IDEA 2025.

- Crea un nuevo proyecto Java llamado: "**MiPrimerProyecto**".

- Asegúrate de seleccionar un JDK válido. Si no tienes uno, descarga e instala la versión más reciente.

**b) Conociendo la interfaz:**

- Explora las diferentes ventanas: _Project_, _Editor_, _Terminal_, _Run_, _Debug_.

- Ubica los botones _Run_ y _Debug_, que te permitirán ejecutar y depurar tus aplicaciones Java.

- Ejecuta el proyecto (si dejaste marcada la opción de **"_Add sample code_"** por defecto, se incluirá un código de ejemplo).

**c) Depurando tu código:**

- Coloca un punto de interrupción (_breakpoint_) en la línea donde aparece el _"Hello and welcome!"_.

- Ejecuta el proyecto en modo _Debug_.

- Observa cómo la ejecución se detiene en el _breakpoint_.

- Utiliza los botones de depuración (_Step Over_, _Step Into_, _Step Out_) para navegar por el código.

- Revisa el valor de las variables en la ventana _Variables_.

**d) Herramientas esenciales:**

- **Paleta de comandos**: Ábrela con `Shift + Ctrl + A` (Windows/Linux) o `Command + Shift + A` (macOS).

- Busca y ejecuta la acción _Reformat Code_ para formatear tu código.

- Busca y ejecuta la acción _Optimize Imports_ para eliminar _imports_ innecesarios.

- **Comentarios**:
  - Aprende a **comentar líneas de código** `Ctrl + /` (Windows/Linux) o `Command + /` (macOS).
  - Aprende a **comentar bloques de código** (`Ctrl + Shift + /` (Windows/Linux) o `Command + Shift + /` (macOS).

**e) Explorando el .idea:**

**.idea:** _es una carpeta que guarda la configuración específica del proyecto para el IDE._

- Localiza la carpeta `.idea` dentro de tu proyecto.

- Abre algunos de los archivos que contiene.

- Investiga qué tipo de información se almacena en esta carpeta.

- Comprende que esta carpeta contiene la configuraciones específicas de IntelliJ IDEA para tu proyecto.

**f) Plugins:**

- Abre la configuración de plugins (`File > Settings > Plugins`).

- Busca e instala un plugin popular, como **Material Theme UI** u otro que te interese.

- Los _plugins_ son extensiones que amplían las funcionalidades del IDE.

**g) Terminal integrada:**

- Abre la terminal integrada de IntelliJ IDEA.

- Ubícala en la parte inferior izquierda de la pantalla, haciendo clic derecho en el icono `Terminal`

- Ejecuta algunos comandos básicos (como `ls` (Linux/macOS) o `dir` (Windows).

**h) Consejos adicionales:**

- Anímate a explorar los menús y la configuración de IntelliJ IDEA.

- ¿Te ha llamado la atención alguna otra opción? Pregunta.

- Poco a poco, durante el curso, veremos más herramientas del IDE de IntelliJ.
