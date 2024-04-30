# Demo de Lombok con MapStruct
## Instalacion de MapStruct
- Se agregaron la dependencia y el plugin manualmente siguiendo la documentacion oficial.  
- Link sección instalación: [documentacion oficial](https://mapstruct.org/documentation/installation/)
## Instalacion de Project Lombok
- Se agregaron la dependencia y el plugin automáticamente desde la plataforma [start.spring.io](https://start.spring.io/)
## Vinculación de MapStruct y Lombok
- Se agregó dentro del plugin del MapStruct el "path" hacia la librería de lombok y la vinculación de ambos.  
- Esto con el fin de que trabajen juntos correctamente en tiempo de compilacion (desarrollo).  
- Nos apoyamos con el siguiente extracto desde la [documentación oficial de MapStruct](https://mapstruct.org/documentation/stable/reference/html/#lombok)
# Ejecución
- El proyecto trabaja con una base de datos H2 en memoria.
- Al ejecutar el proyecto, se cargarán 2 beans correspondientes a las clases **InitDatabaseFacturas** y **InitDatabaseProducts** que implementan la interfaz **CommandLineRunner** e invocan a los métodos mappers.
- La primera clase trabaja con configuraciones de Spring Framework y la segunda no(solo trabaja con una inyección de depdencias para proveerse de datos)
