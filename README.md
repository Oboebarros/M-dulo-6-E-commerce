# OboeMarket - Módulo 6

Proyecto de E-commerce migrado a **Spring Boot**.

## Funcionalidades
- **Registro y Login**: Los usuarios pueden registrarse (rol CLIENT por defecto).
- **Seguridad**:
  - Si entras como **ADMIN**, vas directo a la gestión de productos.
  - Si entras como **CLIENT**, vas al catálogo.
- **Roles**:
  - `ADMIN`: Puede crear, editar y eliminar productos en `/admin/products`.
  - `CLIENT`: Puede ver el catálogo y detalles.
- **Base de Datos**: Usa **Spring Data JPA** para conectar con MySQL.

## Configuración
1. Configura tu base de datos en `application.properties`.
2. Ejecuta la aplicación desde `OboeMarketApplication.java`.
3. Accede en: `http://localhost:8080/`

## Usuarios de Prueba
- **Administrador**: `admin@oboemarket.cl` / `admin123`
- **GitHub**: https://github.com/Oboebarros/M-dulo-6-E-commerce.git
