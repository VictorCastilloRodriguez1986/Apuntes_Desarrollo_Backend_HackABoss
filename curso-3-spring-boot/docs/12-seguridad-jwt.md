## Temas a tratar

En esta clase se abordarán las siguientes temáticas:
- Json Web Token (JWT)
- Ciclo de vida de JWT
- ¿Cómo funciona JWT?
- ¿Cómo vemos el contenido de un JWT?
- JWT en Java mediante JWT

---


## JWT

JWT significa "JSON Web Token". Es un estándar abierto (RFC 7519) que define un formato compacto y autónomo para transmitir de manera segura la información entre dos partes como un objeto JSON.

Un JWT se compone de tres partes separadas por puntos (`.`):

1. **Header (Encabezado o cabecera)**: Contiene información sobre el tipo de token y el algoritmo de cifrado utilizado para firmar el token.
    
2. **Payload (Carga útil)**: Es donde se almacenan los datos que queremos transmitir. Puede incluir información como el ID del usuario, roles, permisos o cualquier otro dato relevante. Esta información está representada en formato JSON.
    
3. **Signature (Firma)**: Se utiliza para verificar que el mensaje no ha sido alterado en el camino y viene de una fuente confiable. Se genera combinando el encabezado, la carga útil y una clave secreta (o clave pública/privada en algunos casos) usando un algoritmo de firma.
    

Los JWT son utilizados comúnmente en entornos de autenticación y autorización en aplicaciones web y API RESTful por varias razones:

1. **Autenticación**: Después de que un usuario se autentica en un servidor, este puede generar un JWT y devolverlo al cliente. El cliente luego incluye este token en las solicitudes subsiguientes para acceder a recursos protegidos.
    
2. **Intercambio de información segura**: Dado que los JWT están firmados digitalmente, el receptor puede verificar la integridad del contenido. Esto es útil cuando se envían datos entre dos partes y se necesita asegurar que no han sido manipulados en el camino.
    
3. **Estadoless (sin estado)**: Los JWT son autónomos, lo que significa que contienen toda la información necesaria en sí mismos. Esto evita la necesidad de almacenar información de estado del usuario en el servidor, lo que puede ser útil en aplicaciones distribuidas y escalables.
    

Los JWT son flexibles y se pueden usar en diferentes escenarios de autenticación y autorización, pero es crucial manejarlos de manera segura, especialmente protegiendo la clave secreta utilizada para firmar los tokens, evitando incluir información sensible en la carga útil si no es necesario y considerando la vigencia (expiración) del token para evitar problemas de seguridad.


### Ciclo de vida de JWT

![](./resources/ciclo-vida-jwt.png)

Como podemos ver en la imagen, el flujo del ciclo de vida de un token JWT inicia en el cliente, realizando una solicitud POST con el nombre de usuario y contraseña para iniciar sesión.

Una vez validados los datos, se genera un JWT que se entrega al usuario como confirmación de autenticación exitosa.

El cliente usa este token en todas sus solicitudes subsiguientes, adjuntándolo en la cabecera `Authorization` con el formato "Bearer XXXXXXX", donde "Bearer" es un prefijo estándar seguido del contenido del token.

En el servidor, se verifica la validez del token mediante su firma para garantizar su seguridad y autenticidad. Esto permite al servidor confiar en la identidad del usuario.

El token incluye información relevante en su carga útil (payload), como los datos del usuario, lo que proporciona al servidor la capacidad de identificar al solicitante.

Una vez que se ha confirmado la autenticidad del token y se ha identificado al usuario, se activa el mecanismo de control de acceso. Esto determina si el usuario tiene permisos para acceder a los recursos solicitados y, en caso afirmativo, se envía la respuesta con el recurso protegido correspondiente.

Este enfoque permite implementar un sólido proceso de autenticación utilizando JSON Web Tokens (JWT), que no solo garantizan la seguridad de la comunicación, sino que también proporcionan un medio para transportar información del usuario de manera segura entre cliente y servidor.


### ¿Cómo funciona JWT?

La autorización se logra cuando el usuario ingresa sus credenciales con éxito, entonces se genera un JSON Web Token que es retornado al cliente, quien tiene que guardarlo localmente, en vez del modelo tradicional de crear una sesión en el servidor y retornar una cookie.

Siempre que el usuario quiere acceder a una ruta protegida o recurso, el cliente tiene que enviar el JWT, generalmente en el encabezado de Authorization utilizando el esquema Bearer.

El contenido del encabezado HTTP se ve de la siguiente forma:

```
eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IlRlc3QgVXNlciIsImlhdCI6MTY0NTYyMjMwMH0.lOrRy_a8w09uA6VfvGeM33bEq0fvYBB56UgC3I5uBHQ
```

Recuerda que un token JWT consta de tres partes separadas por puntos: el encabezado, los datos y la firma.


#### ¿Cómo vemos el contenido de un JWT?

Existen webs exclusivas para leer el contenido de los JWT. Una de las más conocidas es [https://jwt.io/](https://jwt.io/) en ella podemos copiar nuestro token del lado izquierdo y obtener la decodificación del lado derecho:

![](./resources/jwt-io.png)


### JWT en Java mediante JWT

JJWT es una librería de Java que proporciona creación y verificación de JWT. Es gratis y de código abierto. Permite la creación de tokens con facilidad, así como la verificación de su validez utilizando algoritmos de firma como HMAC (Hash-based Message Authentication Code) o RSA (Rivest-Shamir-Adleman).


#### Dependencias

Para utilizar la librería JJWT en un proyecto Java, necesitarás agregar las dependencias correctas a tu gestor de dependencias.

Utilizando Maven deberás agregar las siguientes dependencias:

```xml
<dependency>
    <groupId>io.jsonwebtoken</groupId>
    <artifactId>jjwt-api</artifactId>
    <version>0.12.3</version> <!-- Puedes usar la versión más reciente -->
</dependency>
<dependency>
    <groupId>io.jsonwebtoken</groupId>
    <artifactId>jjwt-impl</artifactId>
    <version>0.12.3</version> <!-- Puedes usar la versión más reciente -->
    <scope>runtime</scope>
</dependency>
<dependency>
    <groupId>io.jsonwebtoken</groupId>
    <artifactId>jjwt-jackson</artifactId>
    <version>0.12.3</version> <!-- Puedes usar la versión más reciente -->
    <scope>runtime</scope>
</dependency>
```


#### Ejemplo sencillo de utilización

Vamos a crear un nuevo proyecto con maven y, además de agregar las dependencias que mencionamos anteriormente en el pom.xml, implementaremos el siguiente código de prueba en el Main:

```java
package com.jwt.ejemploUso;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.SecretKey;

public class EjemploUsoApplication {

	public static void main(String[] args) {
                    
                    //construimos extra claims
                    Map<String, Object> extraClaims = new HashMap<>();
                    extraClaims.put("name", "prueba jwt");
            
                    //construimos jwt
                    Date issuedAt = new Date (System.currentTimeMillis());
                    Date expiration = new Date (issuedAt.getTime() + (1 *60 * 1000));
            
                    String jwt;
                    jwt = Jwts.builder()

                            //cabecera
                            .header()
                            .type("JWT")
                            .and()

                            //payload
                            .subject("pruebajwt")
                            .expiration(expiration)
                            .issuedAt(issuedAt)
                            .claims(extraClaims)

                            //firma
                            .signWith(generateKey(), Jwts.SIG.HS256)

                            .compact();
                    
                    //vemos nuestro jwt generado por pantalla
                    System.out.println(jwt);
                
                
	}
        
        public static SecretKey generateKey () {
            //tiene que ser larga porque dijimos que cumple con HS256
             String secretKey = "esta es mi key super segura 12345688789 HOLA que tal";
        
        return Keys.hmacShaKeyFor(secretKey.getBytes());
            
        }
}
```


#### ¿Qué hace éste código?

- Crea un mapa (`extraClaims`) para añadir información adicional al token. En este caso, agrega un claim (reclamo) con clave "name" y valor "prueba jwt".
    
- Establece las fechas de emisión (`issuedAt`) y expiración (`expiration`) del token. En este caso, el token expirará después de 1 minuto a partir de la fecha de emisión.
    
- Construye el JWT usando el builder proporcionado por `Jwts.builder()`.
    
- Configura la cabecera (`header`) del token, especificando el tipo como JWT.
    
- Define el contenido del token (payload) con el sujeto (`subject`), la fecha de expiración, la fecha de emisión y los reclamos adicionales.
    
- Firma el token utilizando una clave generada por el método `generateKey()`.
    
    - El método `**generateKey()**` Genera una clave secreta (`SecretKey`) utilizando el algoritmo HMAC-SHA256 a partir de una cadena de texto definida en el método. En este caso, la cadena es "esta es mi key super segura 12345688789 HOLA que tal".
        
- Imprime el JWT generado en la consola.
    

En síntesis, con este código sencillo podemos cear un JWT con una serie de reclamos (_claims_) y firmarlo utilizando una clave secreta generada por un método llamado `generateKey` creado por nosotros mismos.

Ésta clave se utiliza para garantizar la integridad del token. Es importante manejar estas claves de **forma segura** en un **entorno de producción**.

En éste ejemplo también vemos una validez corta (1 minuto) para ilustrar el concepto de expiración del token, pero en aplicaciones reales, la duración será ajustada según los requerimientos de seguridad y funcionalidad.

---

## Ejercicios Prácticos



### Ejercicio Nº 1: Implementando JWT

- Crea un nuevo proyecto utilizando Maven
    
- Incorpora las librerías necesarias para el uso de JWT
    
- Crea un token mediante el JWT builder indicando su cabecera, su payload y su firma. Personaliza todo de forma tal que en el pauload dejes un mensaje único proporcionado por ti para tus compañeros de clase.
    
- Intercambia el JWT que hayas generado (el código jwt propiamente) con otros compañeros y cada uno descifre el jwt utilizando [https://jwt.io/](https://jwt.io/) para entender su contenido. ¿Cuáles fueron los mensajes ocultos que cada uno propuso?

