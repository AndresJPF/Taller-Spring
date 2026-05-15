# Taller Spring API

Proyecto desarrollado con Spring Boot para la gestión de productos utilizando una arquitectura REST.

## Tecnologías utilizadas

* Java 17+
* Spring Boot
* Spring Web
* Spring Data JPA
* MySQL
* Maven

## Funcionalidades

* Crear productos
* Listar productos
* Buscar productos por ID
* Actualizar productos
* Eliminar productos
* Persistencia de datos con MySQL

## Estructura del proyecto

```bash
src/
 ├── main/
 │   ├── java/
 │   │   └── com/example/
 │   │       ├── controller/
 │   │       ├── entity/
 │   │       ├── repository/
 │   │       ├── service/
 │   │       └── TallerSpringApplication.java
 │   └── resources/
 │       └── application.properties
```

## Instalación y ejecución

### 1. Clonar el repositorio

```bash
git clone https://github.com/AndresJPF/Taller-Spring.git
cd Taller-Spring
```

### 2. Configurar la base de datos

Crear una base de datos en MySQL:

```sql
CREATE DATABASE taller_spring;
```

Configurar las credenciales en `application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/taller_spring
spring.datasource.username=root
spring.datasource.password=tu_password
spring.jpa.hibernate.ddl-auto=update
```

### 3. Ejecutar el proyecto

Con Maven:

```bash
./mvnw spring-boot:run
```

O desde tu IDE ejecutando la clase principal:

```java
TallerSpringApplication
```

## Endpoints principales

| Método | Endpoint          | Descripción                 |
| ------ | ----------------- | --------------------------- |
| GET    | `/productos`      | Obtener todos los productos |
| GET    | `/productos/{id}` | Obtener producto por ID     |
| POST   | `/productos`      | Crear producto              |
| PUT    | `/productos/{id}` | Actualizar producto         |
| DELETE | `/productos/{id}` | Eliminar producto           |

## Ejemplo JSON para crear productos

```json
[
  {
    "nombre": "Laptop Gamer",
    "descripcion": "RTX 4060, 16GB RAM, 512GB SSD",
    "precio": 4500.00,
    "stock": 10,
    "categoria": "Tecnologia",
    "fechaCreacion": "2026-05-15T00:00:00"
  },
  {
    "nombre": "Mouse Inalambrico",
    "descripcion": "Mouse ergonomico 2.4GHz",
    "precio": 35.00,
    "stock": 50,
    "categoria": "Accesorios",
    "fechaCreacion": "2026-05-15T00:00:00"
  },
  {
    "nombre": "Teclado Mecanico",
    "descripcion": "Switches blue, retroiluminado RGB",
    "precio": 120.00,
    "stock": 30,
    "categoria": "Accesorios",
    "fechaCreacion": "2026-05-15T00:00:00"
  },
  {
    "nombre": "Monitor 27\"",
    "descripcion": "Full HD 144Hz, panel IPS",
    "precio": 850.00,
    "stock": 15,
    "categoria": "Tecnologia",
    "fechaCreacion": "2026-05-15T00:00:00"
  },
  {
    "nombre": "Auriculares",
    "descripcion": "Sonido surround 7.1, microfono",
    "precio": 75.00,
    "stock": 25,
    "categoria": "Accesorios",
    "fechaCreacion": "2026-05-15T00:00:00"
  }
]
```

## Ejemplo de petición POST

```http
POST /productos
Content-Type: application/json
```

```json
{
  "nombre": "Laptop Gamer",
  "descripcion": "RTX 4060, 16GB RAM, 512GB SSD",
  "precio": 4500.00,
  "stock": 10,
  "categoria": "Tecnologia"
}
```

## Autor

Desarrollado por Andrés Palacio.
