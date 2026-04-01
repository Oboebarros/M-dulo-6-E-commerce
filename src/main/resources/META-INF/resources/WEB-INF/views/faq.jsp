<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>OboeMarket — FAQ & Términos</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body { background-color: #0f1123; color: #e0e0e0; font-family: 'Segoe UI', sans-serif; }
        .navbar { background-color: #16213e; border-bottom: 2px solid #c9a84c; }
        .navbar-brand { color: #c9a84c !important; font-weight: bold; }
        
        .section-card {
            background-color: #16213e;
            border-radius: 15px;
            padding: 2rem;
            margin-bottom: 2rem;
            border: 1px solid rgba(201,168,76,0.1);
        }
        h2, h4 { color: #c9a84c; font-weight: bold; margin-bottom: 1.5rem; }
        .faq-item { margin-bottom: 1.5rem; border-bottom: 1px solid rgba(255,255,255,0.05); padding-bottom: 1rem; }
        .faq-question { color: #fff; font-weight: 600; margin-bottom: 0.5rem; }
        .faq-answer { color: #aaa; font-size: 0.95rem; }
        
        footer {
            background-color: #16213e;
            color: #aaa;
            padding: 3rem 0;
            margin-top: 5rem;
            border-top: 1px solid rgba(201,168,76,0.2);
        }
        footer a { color: #aaa; text-decoration: none; transition: 0.3s; }
        footer a:hover { color: #c9a84c; }
    </style>
</head>
<body>

<nav class="navbar navbar-expand-lg px-4 mb-5">
    <a class="navbar-brand" href="${pageContext.request.contextPath}/">🎵 OBOEMARKET</a>
    <div class="ms-auto">
        <a href="${pageContext.request.contextPath}/catalogo" class="btn btn-outline-light btn-sm" style="border-color: #c9a84c; color: #c9a84c;">
            Volver al Catálogo
        </a>
    </div>
</nav>

<div class="container">
    <div class="row justify-content-center">
        <div class="col-lg-10">
            
            <!-- Preguntas Frecuentes -->
            <div class="section-card shadow-lg">
                <h2>❓ Preguntas Frecuentes (FAQ)</h2>
                
                <div class="faq-item">
                    <div class="faq-question">¿Cómo se envían los instrumentos?</div>
                    <div class="faq-answer">Todos nuestros oboes se envían en estuches rígidos acolchados, protegidos por una caja térmica para evitar cambios bruscos de temperatura que puedan dañar la madera.</div>
                </div>
                
                <div class="faq-item">
                    <div class="faq-question">¿Tienen garantía las cañas?</div>
                    <div class="faq-answer">Por razones de higiene, las cañas no tienen devolución una vez abiertas. Sin embargo, garantizamos que cada caña es probada y ajustada manualmente antes del despacho.</div>
                </div>

                <div class="faq-item">
                    <div class="faq-question">¿Realizan ajustes técnicos?</div>
                    <div class="faq-answer">Sí, contamos con un luthier especializado para el ajuste de zapatillas, muelles y eliminación de grietas en instrumentos de madera.</div>
                </div>

                <div class="faq-item">
                    <div class="faq-question">¿Cuál es el tiempo de entrega?</div>
                    <div class="faq-answer">Los accesorios se despachan en 24-48 horas. Los instrumentos pueden tardar hasta 5 días hábiles debido a la inspección final de calidad.</div>
                </div>
            </div>

            <!-- Términos y Condiciones -->
            <div class="section-card shadow-lg">
                <h2>📜 Términos y Condiciones</h2>
                <div class="faq-answer">
                    <p>Al utilizar este sitio, usted acepta los siguientes términos:</p>
                    <ul>
                        <li><strong>Precios:</strong> Todos los valores están expresados en pesos chilenos e incluyen IVA.</li>
                        <li><strong>Propiedad Intelectual:</strong> El contenido, imágenes y descripciones de productos son propiedad exclusiva de OboeMarket.</li>
                        <li><strong>Privacidad:</strong> Sus datos personales se utilizan únicamente para procesar sus pedidos y mejorar su experiencia de compra.</li>
                        <li><strong>Devoluciones:</strong> Los instrumentos tienen un plazo de 10 días para devolución si conservan sus sellos de garantía intactos.</li>
                    </ul>
                </div>
            </div>

            <!-- Nuestra Ubicación -->
            <div class="section-card shadow-lg">
                <h2>📍 Nuestra Tienda Física</h2>
                <div class="row align-items-center">
                    <div class="col-md-12 text-center">
                        <h4 class="mb-3">Visítanos</h4>
                        <p><strong>Dirección:</strong> Av. Principal 123, Ciudad de la Música, Chile</p>
                        <p><strong>Teléfono:</strong> +56 9 1234 5678</p>
                        <p><strong>Email:</strong> contacto@oboemarket.cl</p>
                        <p><strong>Horario:</strong> Lunes a Viernes de 9:00 a 18:30 hrs.</p>
                    </div>
                </div>
            </div>

        </div>
    </div>
</div>

<footer>
    <div class="container text-center">
        <div class="mb-4">
            <a href="${pageContext.request.contextPath}/faq" class="mx-3">Preguntas Frecuentes</a>
            <a href="${pageContext.request.contextPath}/faq" class="mx-3">Términos y Condiciones</a>
            <a href="https://youtu.be/atySC-99OYo" target="_blank" class="mx-3">🎵 YouTube: Purcell</a>
        </div>
        <div class="small">
            &copy; 2024 OboeMarket. Calidad y Excelencia para el Oboísta.
        </div>
    </div>
</footer>

</body>
</html>
