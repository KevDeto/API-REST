**API REST de Clientes - Java + Spring Boot**

Este proyecto implementa una API REST enfocada exclusivamente en la gestión de clientes. Fue desarrollado utilizando Spring Boot y sigue una arquitectura limpia y modular basada en paquetes.

**Tecnologías utilizadas**:

+ **Spring Data JPA**: Para la persistencia y manejo de la base de datos.
+ **Spring Web**: Para la construcción de la API REST.
+ **MySQL Workbench**: Como herramienta para gestionar la base de datos MySQL.
+ **Lombok**: Para reducir el código repetitivo, como getters, setters y constructores.
+ **Spring Boot DevTools**: Para mejorar la experiencia de desarrollo con reinicios automáticos.
+ **Swagger**: Para la documentación interactiva de los endpoints REST.

**Arquitectura**:

El proyecto utiliza una estructura de paquetes clara y organizada:

+ **Controller**: Maneja las solicitudes HTTP y delega la lógica a la capa de servicio.
+ **Service**: Contiene la lógica de negocio.
  + **Impl**: Implementaciones concretas de los servicios.
+ **Model**: Estructura los datos y las entidades del dominio.
  + **DAO**: Acceso a datos con Spring Data JPA.
  + **DTO**: Objetos para transferir datos entre las capas.
  + **Entity**: Clases mapeadas a tablas de la base de datos.
  + **Payload**: Estructuras para solicitudes y respuestas personalizadas.

**Características principales**:

+ CRUD de clientes con validaciones en los datos.
+ Persistencia en base de datos MySQL.
+ Documentación de los endpoints generada automáticamente con Swagger.
+ Diseño modular que facilita la extensibilidad y el mantenimiento.

**Requisitos**:
+ **Java 17** o superior.
+ **Maven** como gestor de dependencias.
+ **MySQL** como motor de base de datos.
