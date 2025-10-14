# 12. CRUD con JPA -  Alta, Baja, Modificación y lectura en una Base de Datos.

<br>

## CRUD con JPA

<br>

**CRUD** es un acrónimo que se utiliza comúnmente en el desarrollo de software para describir las cuatro operaciones básicas de manipulación de datos en una aplicación o sistema:

- **Crear (Create):** La operación "C" se refiere a la capacidad de crear nuevos registros o elementos en una base de datos o sistema. En el contexto de una base de datos, esto implica agregar una nueva fila a una tabla. En una aplicación, puede implicar crear nuevos objetos o instancias de una clase.
    
- **Leer (Read):** La operación "R" se refiere a la capacidad de leer, recuperar o consultar datos existentes de una base de datos o sistema. Esto implica obtener información de registros o elementos ya existentes sin realizar cambios en ellos.
    
- **Actualizar (Update):** La operación "U" implica la capacidad de modificar o actualizar datos existentes en una base de datos o sistema. Puede implicar cambiar los valores de campos o propiedades en registros o elementos existentes.
    
- **Eliminar (Delete):** La operación "D" se refiere a la capacidad de eliminar registros o elementos de una base de datos o sistema. Esto implica la eliminación permanente de datos que ya no son necesarios o deseados.

También es muy común encontrar este concepto con las siglas **ABML (Altas Bajas Modificaciones y Lecturas)** que serían el equivalente en español. Todas estas operaciones CRUD las haremos en el `PersonaJPA` que hicimos anteriormente.

<br>

--- 
---

<br>

## Crear (CREATE)

La operación "Create" en el contexto de JPA (Java Persistence API) implica crear nuevos registros en una base de datos a partir de objetos Java. CREATE cuenta con un método especial (con el mismo nombre) dentro del JpaController de cada clase que hayamos mapeado.

```java
    public void create(Persona nuevaPelicula) {
        EntityManager em = ConfigJPA.getEntityManager();

        try{
            // guardar algo en la DB
            em.getTransaction().begin(); // Iniciar una transaccion
            em.persist(nuevaPelicula);
            em.getTransaction().commit();

        }finally {
            em.close();
        }
    }

```

<br>

## Encontrar un recurso Find (READ)

El método **find** se utiliza para recuperar un registro específico de la base de datos a través de su identificador o clave primaria.

El método find se utiliza para recuperar todos los registros de una determinada tabla permitiéndonos almacenar en algún tipo de Collection (generalmente listas).

Probemos ver en el _main_ todos los registros de nuestra base de datos mediante find agregando lo siguiente:

```java
    public Persona findOne(Integer idBuscado) {
        EntityManager em = ConfigJPA.getEntityManager();
        try{
            return em.find(Persona.class, idBuscado);
        }finally {
            em.close();
        }

    }

```

<br>

## Encontrar varios recursos (READ)

JPA (Java Persistence API) no tiene un método `findAll()` incorporado en EntityManager porque está diseñado como una especificación de bajo nivel que proporciona acceso genérico a la persistencia de datos, pero sin abstraer demasiado las consultas.

En lugar de imponer métodos predefinidos, JPA permite escribir consultas dinámicas con JPQL (SELECT e FROM Entity e).

```java
      public List<Persona> findAll() {
        EntityManager em = ConfigJPA.getEntityManager();
        try{
            TypedQuery<Persona> query = em.createQuery("SELECT p FROM persona p", Persona.class);
            return query.getResultList();
        }finally {
            em.close();
        }

    }


```

<br>

## EDIT

El método **destroy** se utiliza para eliminar una entidad específica de la base de datos. Elimina permanentemente el registro asociado en la tabla correspondiente. Por otro lado, el método **edit** se utiliza para actualizar los datos de una entidad existente en la base de datos. Permite modificar los valores de los campos de la entidad sin eliminarla ni crear una nueva.


```java
     public void update(Persona actualizarPelicula) {
        EntityManager em = ConfigJPA.getEntityManager();
        try{
            em.getTransaction().begin(); // Iniciar una transaccion
            em.merge(actualizarPelicula);
            em.getTransaction().commit();
        }finally {
            em.close();
        }
    }

```

<br>

## DESTROY

El método **destroy** se utiliza para eliminar una entidad específica de la base de datos. Elimina permanentemente el registro asociado en la tabla correspondiente. Por otro lado, el método **edit** se utiliza para actualizar los datos de una entidad existente en la base de datos. Permite modificar los valores de los campos de la entidad sin eliminarla ni crear una nueva.

```java
      public void delete(Integer idEliminar) {
        EntityManager em = ConfigJPA.getEntityManager();
        try{
            em.getTransaction().begin(); // Iniciar una transaccion
            Persona persona = em.find(Persona.class, idEliminar);
            if (persona != null){
                em.remove(persona);
            }else{
                System.err.println("El id " + idEliminar + " No existe, gracias a antonio");
            }
            em.getTransaction().commit();
        }finally {
            em.close();
        }
    }

```

Con estos métodos estas listos para comenzar un proyecto.

---
> [⬅️ Anterior: Introducción a JPA](11-introduccion-a-jpa.md) | 📂 [Volver al índice](./README.md)
