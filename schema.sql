-- Script de Creación de Base de Datos para OboeMarket
-- Módulo 5

CREATE DATABASE IF NOT EXISTS oboemarket_db;
USE oboemarket_db;

-- 1. Tabla de Categorías 
CREATE TABLE IF NOT EXISTS categories (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL UNIQUE,
    descripcion TEXT
);

-- 2. Tabla de Productos 
CREATE TABLE IF NOT EXISTS productos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    descripcion TEXT,
    descripcion_larga TEXT,
    precio DECIMAL(10, 2) NOT NULL DEFAULT 0.00,
    categoria VARCHAR(50) NOT NULL,
    subcategoria VARCHAR(50),
    imagen_url VARCHAR(255),
    material VARCHAR(100),
    nivel VARCHAR(50),
    stock INT DEFAULT 10,
    fecha_creacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- 3. Tabla de Usuarios (Módulo 6: Seguridad y Roles)
CREATE TABLE IF NOT EXISTS users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    apellido VARCHAR(50) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    rol VARCHAR(20) NOT NULL DEFAULT 'CLIENT',
    fecha_registro TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- DATOS DE PRUEBA (USUARIOS)
-- Contraseña 'admin123' encriptada con BCrypt (ejemplo)
INSERT INTO users (nombre, apellido, email, password, rol) VALUES 
('Admin', 'Oboe', 'admin@oboemarket.cl', '$2a$10$8.UnVuG9HHgffUDAlk8qfOuVGkqRzgVymGe07xd00DMxs.TVuHOnu', 'ADMIN'),
('Cliente', 'Prueba', 'cliente@gmail.com', '$2a$10$8.UnVuG9HHgffUDAlk8qfOuVGkqRzgVymGe07xd00DMxs.TVuHOnu', 'CLIENT');

-- 4. Tabla de Pedidos 
CREATE TABLE IF NOT EXISTS orders (
    id INT AUTO_INCREMENT PRIMARY KEY,
    customer_id INT,
    fecha_pedido TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    total DECIMAL(12, 2) NOT NULL,
    estado VARCHAR(20) DEFAULT 'PENDIENTE',
    FOREIGN KEY (customer_id) REFERENCES users(id)
);

-- 5. Tabla de Ítems de Pedido 
CREATE TABLE IF NOT EXISTS order_items (
    id INT AUTO_INCREMENT PRIMARY KEY,
    order_id INT,
    producto_id INT,
    cantidad INT NOT NULL,
    precio_unitario DECIMAL(10, 2) NOT NULL,
    FOREIGN KEY (order_id) REFERENCES orders(id),
    FOREIGN KEY (producto_id) REFERENCES productos(id)
);

-- LIMPIAR TABLA MANEJANDO RESTRICCIONES DE CLAVE FORÁNEA
SET FOREIGN_KEY_CHECKS = 0;
TRUNCATE TABLE order_items;
TRUNCATE TABLE orders;
TRUNCATE TABLE productos;
SET FOREIGN_KEY_CHECKS = 1;

-- DATOS DE PRUEBA (PRODUCTOS)
INSERT INTO productos (nombre, descripcion, descripcion_larga, precio, categoria, subcategoria, imagen_url, material, nivel) VALUES 
 ('Oboe Buffet Légende',      'Gama alta profesional de Buffet Crampon.', 'El Oboe Buffet Légende ofrece una sonoridad rica y una respuesta excepcional. Diseñado para los músicos más exigentes del mundo.', 9500000.00, 'Instrumentos', 'Profesional', 'assets/img/legende oboe 1.png', 'Madera de Granadilla', 'Profesional'), 
 ('Oboe Buffet Prodige',      'Perfecto para estudiantes. Resina ABS.', 'Ideal para quienes inician su camino musical. Su construcción en resina ABS lo hace resistente a cambios de temperatura.', 2200000.00, 'Instrumentos', 'Estudiante', 'assets/img/prodige 1.png', 'Resina ABS', 'Estudiante'), 
 ('Estuche Reeds n Stuff (12)','Caja de madera para 12 cañas.', 'Estuche elegante y robusto para proteger tus cañas más preciadas. Interior de terciopelo.', 38000.00, 'Almacenamiento','Cañas', 'assets/img/caja 12.png', 'Madera', 'General'), 
 ('Estuche Reeds n Stuff (6)', 'Caja de madera para 6 cañas.', 'Versión compacta del estuche clásico, ideal para transportar en el bolso del instrumento.', 22000.00, 'Almacenamiento','Cañas', 'assets/img/caña 6.png', 'Madera', 'General'), 
 ('Navaja Chiarugi Económica', 'Navaja estudiante biselada.', 'Herramienta básica y duradera para estudiantes que comienzan a aprender el arte del raspado.', 25000.00, 'Herramientas', 'Navajas', 'assets/img/chiarugi economic.png', 'Acero', 'Estudiante'), 
 ('Navaja Chiarugi Profesional','Filo profesional para raspado preciso.', 'Navaja de alta precisión con un filo que permite un control total sobre el raspado de la caña.', 52000.00, 'Herramientas', 'Navajas', 'assets/img/chiarugi desplegado.png', 'Acero de alta calidad', 'Profesional'), 
 ('Mandril Chiarugi',          'Herramienta de montaje esencial.', 'Mandril ergonómico para un montaje seguro y cómodo de las palas en los tudeles.', 22000.00, 'Herramientas', 'Montaje', 'assets/img/mandril.png', 'Acero y Madera', 'General'), 
 ('Hilo de Seda',              'Hilo resistente para atado de cañas.', 'Hilo de seda de alta calidad disponible en varios colores para un atado firme y estético.', 12000.00, 'Herramientas', 'Atado', 'assets/img/Hilo.png', 'Seda', 'General'), 
 ('Tubo Chiarugi N°2',         'Tudeles de precisión para montaje.', 'Tudeles Chiarugi número 2, el estándar de la industria por su estabilidad y afinación.', 3500.00, 'Accesorios',   'Tubos', 'assets/img/tubo chiarugi.png', 'Latón y Corcho', 'General'), 
 ('Palas Rigotti',             '10 palas de maderas seleccionadas.', 'Selección de 10 palas Rigotti con el grosor y dureza ideal para fabricar tus cañas.', 18000.00, 'Accesorios',   'Materia Prima', 'assets/img/rigoti cañas.png', 'Madera Arundo Donax', 'General'), 
 ('Soporte Oboe y Corno Inglés','Soporte doble de alta estabilidad.', 'Soporte plegable y seguro para descansar tu oboe y corno inglés durante los ensayos.', 30000.00, 'Accesorios',   'Soportes', 'assets/img/SOPORTE OBOE Y CORNO INGLES.png', 'Metal y Goma', 'General'), 
 ('Colgador Oboe',             'Arnés cómodo para estudio.', 'Colgador ajustable que distribuye el peso del instrumento para evitar fatiga en el pulgar y cuello.', 25000.00, 'Accesorios',   'Correas', 'assets/img/collar 1.png', 'Nylon y Cuero', 'General');
