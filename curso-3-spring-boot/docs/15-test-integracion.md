# Temas a tratar

En esta clase se abordarán las siguientes temáticas:

- Introducción a los Test de Integración
- Diferencias entre Test Unitarios y de Integración
- Dependencias necesarias para Test de Integración en Spring Boot
- Anotaciones de Spring Boot para Test de Integración
- Preparación de la base de datos para Test 
- Ejemplo práctico: CRUD de Personas con MySQL
- Implementación de los tests de integración (con @SpringBootTest, TestRestTemplate, etc.)

---
---



## 2) Desarrollo teórico

### 1. Introducción a los Test de Integración

Los test de integración verifican que múltiples componentes de una aplicación funcionen juntos correctamente. En Spring Boot, estos tests incluyen la carga de todo el contexto de la aplicación y la interacción con los beans reales, la base de datos y otros recursos.

### 2. Diferencias entre Test Unitarios y de Integración

- *Unitarios*: prueban clases o métodos en aislamiento (por ejemplo, usando Mockito).
- *Integración*: prueban cómo interactúan los componentes de la aplicación (por ejemplo, un controlador que usa un servicio y un repositorio).

### 3. Dependencias necesarias para Test de Integración

Generalmente, se usan las siguientes dependencias:

- spring-boot-starter-test: incluye JUnit, AssertJ, Mockito, Hamcrest y más.


### 4. Anotaciones de Spring Boot para Test de Integración

- @SpringBootTest: carga el contexto completo de la aplicación.
- @TestInstance: indica que JUnit usará una sola instancia de la clase de prueba para todos los métodos de test.
- @Transactional: para revertir los cambios en la base de datos al final de cada prueba.
- @AutoConfigureMockMvc: para inyectar un objeto MockMvc y probar controladores.

### 5. Preparación de la base de datos para Test

- *MySQL*: usar un proyecto que tenga un sistema CRUD con una base de datos para hacer pruebas reales.
- *No tengo una DB*: puedes crearte esta base de datos de pruebas para probarla.

```sql
-- Create the database (schema)
CREATE DATABASE prueba_jpa;

-- Use the database
USE prueba_jpa;

-- Create table
 CREATE TABLE Persona (
     id BIGINT AUTO_INCREMENT PRIMARY KEY,
     nombre VARCHAR(255),
     apellido VARCHAR(255),
     edad INT
 );

 -- Insert raw
INSERT INTO Persona (nombre, apellido, edad) VALUES ('Juan', 'Perez', 30);
INSERT INTO Persona (nombre, apellido, edad) VALUES ('Maria', 'Gonzales', 25);
INSERT INTO Persona (nombre, apellido, edad) VALUES ('Carlos', 'Rodriguez', 40);
INSERT INTO Persona (nombre, apellido, edad) VALUES ('Ana', 'Martinez', 35);
INSERT INTO Persona (nombre, apellido, edad) VALUES ('Luis', 'Hernandez', 28);
```


### 6. Ejemplo práctico: CRUD de Personas

#### Entidad Persona

java
@Entity
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String apellido;
    // Getters y Setters
}

#### Repositorio

java
public interface PersonaRepository extends JpaRepository<Persona, Long> {
}

#### Servicio

java
@Service
public class PersonaService {
    @Autowired
    private PersonaRepository personaRepository;

    public List<Persona> listar() {
        return personaRepository.findAll();
    }

    public Persona guardar(Persona persona) {
        return personaRepository.save(persona);
    }

    public Optional<Persona> buscarPorId(Long id) {
        return personaRepository.findById(id);
    }

    public void eliminar(Long id) {
        personaRepository.deleteById(id);
    }
}

#### Controlador

java
@RestController
@RequestMapping("/personas")
public class PersonaController {
    @Autowired
    private PersonaService personaService;

    @GetMapping
    public List<Persona> listar() {
        return personaService.listar();
    }

    @PostMapping
    public Persona guardar(@RequestBody Persona persona) {
        return personaService.guardar(persona);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Persona> buscarPorId(@PathVariable Long id) {
        return personaService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        personaService.eliminar(id);
    }
}

---

## 3) Dependencias necesarias en pom.xml

xml
<dependencies>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-jpa</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
   <dependency>
			<groupId>mysql</groupId>
			<artifactId>mysql-connector-java</artifactId>
			<version>8.0.21</version> </dependency>
		<dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-test</artifactId>
        <scope>test</scope>
    </dependency>
</dependencies>

---

## 4) Anotaciones clave para levantar el contexto en los tests

- @SpringBootTest(classes=MiAplicacion.class): arranca toda la aplicación para pruebas de integración.
- @AutoConfigureMockMvc: permite inyectar MockMvc para probar controladores.
- @Transactional: para que los cambios en la BD se reviertan después de cada test.

---

## 5) Ejemplo básico de test de integración

java
@SpringBootTest
@AutoConfigureMockMvc
class PersonaIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private PersonaRepository personaRepository;

    @Test
    void testListarPersonas() throws Exception {
        mockMvc.perform(get("/personas"))
                .andExpect(status().isOk())                             //Espera que de 200 la respuesta
                .andExpect(jsonPath("$", hasSize(greaterThan(0))));     //Espera que la longitud de la lista tenga mas de 0 elementos
    }
}

---

## 📝 Ejercicios Prácticos

💡Recuerda que los siguientes ejercicios prácticos los llevarás a cabo en clase, por lo que contarás con la ayuda del profesor/a y tus compañeros para validar las resoluciones 😉


### Ejercicio Nº 1: Pruebas de Integracion

Complementar al proyecto de personas con las pruebas de integracion faltantes para completar el CRUD de una persona. Agregar una para el caso de que se pueda actualizar una persona, eliminar, o buscar una sola persona.

¿Qué resultados se obtienen al ejecutar los 3 tests? ¿Pasan todos correctamente?
