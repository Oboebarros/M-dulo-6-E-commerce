# OboeMarket - Módulo 6 & Portafolio Profesional

Proyecto de E-commerce especializado en Oboes y accesorios, migrado a **Spring Boot 3.2.4**. Este repositorio contiene la versión final optimizada para el Portafolio Profesional.

## 🚀 Tecnologías Utilizadas
- **Java 21**
- **Spring Boot 3.2.4**
- **Spring Security** (Autenticación y Roles RBAC)
- **Spring Data JPA** (Persistencia con MySQL)
- **JSP & JSTL** (Vistas dinámicas)
- **Bootstrap 5.3** (Diseño Responsivo)
- **Maven** (Gestión de dependencias)

## 🛠️ Configuración y Ejecución
1.  **Base de Datos**: Crea una base de datos en MySQL llamada `oboemarket_db`.
2.  **Propiedades**: Configura tu usuario y contraseña de MySQL en `src/main/resources/application.properties`.
3.  **Ejecución**:
    ```powershell
    mvn spring-boot:run
    ```
4.  **Acceso**: Abre [http://localhost:8080](http://localhost:8080) en tu navegador.

## 🔐 Usuarios de Prueba
El sistema cuenta con inicialización automática de datos (`DataInitializer`):
- **Administrador**: `admin@oboemarket.cl` / `admin123`
- **Cliente**: Puedes registrar uno nuevo en la página de registro.

## 📁 Estructura del Proyecto
- `src/main/java`: Lógica de negocio, controladores, servicios y modelos.
- `src/main/resources`: Configuración y recursos estáticos.
- `src/main/resources/META-INF/resources`: Ubicación de archivos JSP y assets (estándar para Tomcat embebido).

## 📄 Documentación Adicional
Para más detalles sobre los errores corregidos y la evolución del proyecto, consulta el [INFORME_FINAL.md](./INFORME_FINAL.md).
