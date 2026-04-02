# OboeMarket – E-commerce para Músicos (Versión Final M7)

Este proyecto es la entrega final de la plataforma OboeMarket, un sistema de E-commerce diseñado para la gestión y venta de instrumentos y accesorios musicales, desarrollado con Spring Boot 3.2.4 y MySQL.

## 📂 Enlace al Repositorio
* **GitHub:** [https://github.com/Oboebarros/M-dulo-6-E-commerce](https://github.com/Oboebarros/M-dulo-6-E-commerce)

## 🛠️ Stack Tecnológico
* **Lenguaje:** Java 21
* **Framework Principal:** Spring Boot 3.2.4
* **Seguridad:** Spring Security (BCrypt)
* **Persistencia:** Spring Data JPA / Hibernate
* **Base de Datos:** MySQL
* **Motor de Plantillas:** Thymeleaf
* **Gestión de Dependencias:** Maven

## 🚀 Funcionalidades Principales
* **Autenticación y Roles (RBAC):** Diferencia accesos entre Administradores y Clientes.
* **Gestión de Productos (CRUD):** Panel administrativo para control de stock.
* **Carrito de Compras:** Sistema funcional con cálculo automático de totales.

## ⚙️ Instrucciones de Ejecución Local

1. **Requisitos:** Java 21, Maven y MySQL Server instalados.
2. **Base de Datos:** - Crea una base de datos vacía llamada `oboemarket_db`.
    - Importa el archivo `schema.sql` (incluido en la raíz del proyecto) para cargar la estructura y datos iniciales.
3. **Variables y Configuración:** Ajusta tus credenciales locales en `src/main/resources/application.properties`:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/oboemarket_db
   spring.datasource.username=tu_usuario
   spring.datasource.password=tu_contraseña