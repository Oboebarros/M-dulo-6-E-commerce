package com.ejemplo.config;

import com.ejemplo.modelo.Producto;
import com.ejemplo.modelo.User;
import com.ejemplo.repository.ProductoRepository;
import com.ejemplo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        // 0. Limpieza automática (Activada para cargar datos frescos con descripciones largas)
        entityManager.createNativeQuery("SET FOREIGN_KEY_CHECKS = 0").executeUpdate();
        entityManager.createNativeQuery("TRUNCATE TABLE order_items").executeUpdate();
        entityManager.createNativeQuery("TRUNCATE TABLE orders").executeUpdate();
        entityManager.createNativeQuery("TRUNCATE TABLE productos").executeUpdate();
        entityManager.createNativeQuery("SET FOREIGN_KEY_CHECKS = 1").executeUpdate();

        // 1. Inicializar Usuario Admin
        String adminEmail = "admin@oboemarket.cl";
        
        if (userRepository.findByEmail(adminEmail).isEmpty()) {
            User admin = new User();
            admin.setNombre("Administrador");
            admin.setApellido("Sistema"); // Añadimos el apellido para evitar el error de validación
            admin.setEmail(adminEmail);
            // Encriptamos la contraseña "admin123" para que Spring Security la acepte
            admin.setPassword(passwordEncoder.encode("admin123"));
            admin.setRol("ADMIN");
            
            userRepository.save(admin);
            System.out.println(">>> Usuario administrador creado exitosamente: " + adminEmail);
        }

        // 2. Inicializar Productos si la tabla está vacía
        if (productoRepository.count() == 0) {
            productoRepository.saveAll(List.of(
                new Producto(0, "Oboe Buffet Légende", 
                    "Gama alta profesional de Buffet Crampon.", 
                    "El Oboe Buffet Légende ofrece una sonoridad rica y una respuesta excepcional. Diseñado para los músicos más exigentes del mundo, destaca por su refinamiento y precisión técnica.", 
                    9500000.00, "Instrumentos", "Profesional", "assets/img/legende oboe 1.png", "Madera de Granadilla", "Profesional"),
                
                new Producto(0, "Oboe Buffet Prodige", 
                    "Perfecto para estudiantes. Resina ABS.", 
                    "Ideal para quienes inician su camino musical. Su construcción en resina ABS lo hace resistente a cambios de temperatura y humedad, manteniendo una afinación estable.", 
                    2200000.00, "Instrumentos", "Estudiante", "assets/img/prodige 1.png", "Resina ABS", "Estudiante"),
                
                new Producto(0, "Estuche Reeds n Stuff (12)", 
                    "Caja de madera para 12 cañas.", 
                    "Estuche elegante y robusto para proteger tus cañas más preciadas. Cuenta con un interior de terciopelo y un sistema de sujeción seguro para 12 unidades.", 
                    38000.00, "Almacenamiento", "Cañas", "assets/img/caja 12.png", "Madera y Terciopelo", "General"),
                
                new Producto(0, "Estuche Reeds n Stuff (6)", 
                    "Caja de madera para 6 cañas.", 
                    "Versión compacta del estuche clásico, ideal para transportar lo esencial en el bolso del instrumento sin ocupar demasiado espacio.", 
                    22000.00, "Almacenamiento", "Cañas", "assets/img/caña 6.png", "Madera y Terciopelo", "General"),
                
                new Producto(0, "Navaja Chiarugi Económica", 
                    "Navaja estudiante biselada.", 
                    "Herramienta básica y duradera para estudiantes que comienzan a aprender el arte del raspado de cañas. Filo resistente y fácil de mantener.", 
                    25000.00, "Herramientas", "Navajas", "assets/img/chiarugi economic.png", "Acero al Carbono", "Estudiante"),
                
                new Producto(0, "Navaja Chiarugi Profesional", 
                    "Filo profesional para raspado preciso.", 
                    "Navaja de alta precisión con un filo excepcional que permite un control total sobre el raspado de la caña, ideal para ajustes minuciosos.", 
                    52000.00, "Herramientas", "Navajas", "assets/img/chiarugi desplegado.png", "Acero de Alta Calidad", "Profesional"),
                
                new Producto(0, "Mandril Chiarugi", 
                    "Herramienta de montaje esencial.", 
                    "Mandril ergonómico diseñado para un montaje seguro y cómodo de las palas en los tudeles. Indispensable en el kit de todo oboísta.", 
                    22000.00, "Herramientas", "Montaje", "assets/img/mandril.png", "Acero y Madera", "General"),
                
                new Producto(0, "Hilo de Seda", 
                    "Hilo resistente para atado de cañas.", 
                    "Hilo de seda de alta resistencia disponible en varios colores. Garantiza un atado firme y duradero, aportando una estética profesional a tus cañas.", 
                    12000.00, "Herramientas", "Atado", "assets/img/Hilo.png", "Seda Sintética", "General"),
                
                new Producto(0, "Tubo Chiarugi N°2", 
                    "Tudeles de precisión para montaje.", 
                    "Tudeles Chiarugi número 2 de 47mm, el estándar de la industria por su estabilidad, afinación y calidad de corcho natural.", 
                    3500.00, "Accesorios", "Tubos", "assets/img/tubo chiarugi.png", "Latón y Corcho", "General"),
                
                new Producto(0, "Palas Rigotti", 
                    "10 palas de maderas seleccionadas.", 
                    "Selección de 10 palas Rigotti (Arundo Donax) con el grosor y dureza ideal para fabricar tus propias cañas con éxito.", 
                    18000.00, "Accesorios", "Materia Prima", "assets/img/rigoti cañas.png", "Madera Arundo Donax", "General"),
                
                new Producto(0, "Soporte Oboe y Corno Inglés", 
                    "Soporte doble de alta estabilidad.", 
                    "Soporte plegable y seguro diseñado para descansar tu oboe y corno inglés durante los ensayos y presentaciones. Base antideslizante.", 
                    30000.00, "Accesorios", "Soportes", "assets/img/SOPORTE OBOE Y CORNO INGLES.png", "Metal y Goma", "General"),
                
                new Producto(0, "Colgador Oboe", 
                    "Arnés cómodo para estudio.", 
                    "Colgador ajustable que distribuye el peso del instrumento para evitar fatiga en el pulgar y tensión en el cuello durante largas sesiones.", 
                    25000.00, "Accesorios", "Correas", "assets/img/collar 1.png", "Nylon y Cuero", "General")
            ));
            System.out.println(">>> Todos los productos de OboeMarket han sido inicializados exitosamente.");
        }
    }
}
