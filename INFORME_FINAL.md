# Informe de Mejoras y Ajustes - OboeMarket
**Módulo 6: Portafolio Profesional**

### 1. Introducción
Este documento detalla el proceso de revisión, depuración y mejora que apliqué al proyecto **OboeMarket** para mi entrega final del portafolio profesional. Mi objetivo fue optimizar la versión final del producto para que cumpla con los estándares de un e-commerce profesional, asegurando su estabilidad técnica y una experiencia de usuario fluida.

### 2. Errores Detectados y Corregidos por mí
A lo largo del desarrollo, identifiqué y resolví los siguientes problemas críticos:

- **Error de Renderizado JSP (404)**:
    - **Causa**: Spring Boot 3 no soporta nativamente JSPs dentro de `src/main/webapp` cuando se ejecuta como un JAR embebido.
    - **Solución**: Migré toda la estructura de vistas y recursos estáticos a `src/main/resources/META-INF/resources/`, cumpliendo con el estándar de classpath para Tomcat embebido.
- **Conflictos de Puertos (8080/8084)**:
    - **Causa**: Procesos residuales bloqueaban los puertos estándar.
    - **Solución**: Implementé una configuración flexible en `application.properties` y utilicé scripts de limpieza en PowerShell para asegurar la disponibilidad del puerto 8080.
- **Error de Carga de Clase Principal (ClassNotFoundException)**:
    - **Causa**: Desincronización en la carpeta de compilación `target`.
    - **Solución**: Estandaricé el uso de `mvn clean compile` para garantizar que el classpath esté siempre actualizado.
- **Falta de Persistencia de Datos**:
    - **Causa**: Al migrar de Servlets a Spring Boot, se perdió la conexión manual por JDBC.
    - **Solución**: Implementé **Spring Data JPA** con repositorios automatizados, eliminando el código redundante de los antiguos DAOs y mejorando la estabilidad de las consultas.

### 3. Mejoras que Implementé (Usabilidad y Diseño)
Siguiendo las instrucciones de la rúbrica, apliqué los siguientes cambios:

- **Interfaz de Administración de Alto Contraste**: 
    - Rediseñé la vista `lista.jsp` con un tema oscuro profesional, utilizando una paleta de colores azul marino y dorado para mejorar la legibilidad y la estética "Premium" de la marca.
- **Flujo de Usuario Optimizado (Carrito)**:
    - Implementé un sistema de notificaciones **Toast** que me permite confirmar al usuario cuando un producto se añade al carrito sin interrumpir su navegación por el catálogo.
- **Automatización de Inventario (Data Seeding)**:
    - Creé un `DataInitializer` que garantiza que el sistema siempre tenga un usuario administrador (`admin@oboemarket.cl`) y productos de prueba listos para usar, eliminando la necesidad de cargas manuales.
- **Seguridad Basada en Roles (RBAC)**:
    - Configuré **Spring Security** con un redireccionamiento personalizado según el rol del usuario para mejorar la experiencia de navegación.
- **Consistencia de Imágenes**:
    - Ajusté todas las rutas de imágenes para que se carguen correctamente usando el contexto de la aplicación (`${pageContext.request.contextPath}`).

### 4. Feedback que Recibí y Apliqué
- **Sugerencia**: "El texto en el panel de administración es difícil de leer con el fondo oscuro".
    - **Aplicación**: Forcé el color de las etiquetas de formulario y textos mudos a blanco y gris claro mediante CSS específico para mejorar la legibilidad.
- **Sugerencia**: "Faltan enlaces a contenido especializado para músicos".
    - **Aplicación**: Removí redes sociales genéricas e integré un enlace directo a contenido educativo de alta calidad (Sonata 12 de H. Purcell para 2 Oboes y Corno Inglés) en todos los pies de página, reforzando la identidad de la tienda.
- **Sugerencia**: "Simplificar la navegación legal y de soporte".
    - **Aplicación**: Unifiqué las secciones de **Preguntas Frecuentes** y **Términos y Condiciones** en una página dedicada (`/faq`), facilitando el acceso a la información de soporte y ubicación de la tienda física.

### 5. Evolución de mi Proyecto
Desarrollé este e-commerce de manera paulatina, siguiendo estas fases:
1. **Fase 1 (Arquitectura)**: Realicé la migración de Servlets/JSP manuales a Spring Boot 3 para modernizar el sistema.
2. **Fase 2 (Persistencia)**: Reemplacé las consultas SQL manuales por repositorios de Spring Data JPA, aumentando la fiabilidad.
3. **Fase 3 (Seguridad)**: Implementé el control de acceso para diferenciar la experiencia entre Administradores y Clientes.
4. **Fase 4 (Refinamiento)**: Ajusté la interfaz de usuario, la visibilidad del carrito y los mensajes de confirmación tras recibir retroalimentación.

### 6. Conclusión
Optimicé el producto final tanto en su arquitectura interna como en su presentación visual, logrando un sistema robusto, seguro y centrado en el usuario, cumpliendo con todos los estándares requeridos para mi portafolio profesional.
