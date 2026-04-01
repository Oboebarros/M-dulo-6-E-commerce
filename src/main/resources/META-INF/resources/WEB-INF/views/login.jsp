<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>OboeMarket — Login</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body { background-color: #0f1123; color: #e0e0e0; font-family: 'Segoe UI', sans-serif; display: flex; align-items: center; min-height: 100vh; }
        .card { background-color: #16213e; border: 1px solid rgba(201,168,76,0.2); border-radius: 20px; box-shadow: 0 10px 40px rgba(0,0,0,0.4); max-width: 400px; width: 100%; margin: auto; padding: 2rem; }
        .form-label { color: #c9a84c; font-weight: bold; }
        .form-control { background-color: #1a1a2e; border: 1px solid rgba(201,168,76,0.3); color: #fff; }
        .form-control:focus { background-color: #1a1a2e; border-color: #c9a84c; color: #fff; box-shadow: 0 0 10px rgba(201,168,76,0.2); }
        .btn-gold { background: linear-gradient(45deg, #c9a84c, #e0c070); color: #1a1a2e; border: none; font-weight: bold; border-radius: 50px; padding: 10px 0; width: 100%; transition: 0.3s; }
        .btn-gold:hover { transform: translateY(-2px); box-shadow: 0 5px 15px rgba(201,168,76,0.4); color: #1a1a2e; }
        .brand { color: #c9a84c; font-size: 2rem; font-weight: bold; text-align: center; margin-bottom: 2rem; letter-spacing: 2px; }
    </style>
</head>
<body>

<div class="card">
    <div class="brand">OBOEMARKET</div>
    <h4 class="text-center mb-4 text-white">Iniciar Sesión</h4>

    <c:if test="${not empty error}">
        <div class="alert alert-danger p-2 small">${error}</div>
    </c:if>
    <c:if test="${param.msg == 'registrado'}">
        <div class="alert alert-success p-2 small">Registro exitoso. Ya puedes iniciar sesión.</div>
    </c:if>

    <form action="${pageContext.request.contextPath}/login" method="post">
        <div class="mb-3">
            <label class="form-label text-white">Email</label>
            <input type="email" name="email" class="form-control" required>
        </div>
        <div class="mb-4">
            <label class="form-label text-white">Contraseña</label>
            <input type="password" name="password" class="form-control" required>
        </div>
        <button type="submit" class="btn btn-gold mb-3">INGRESAR</button>
    </form>
    
    <div class="text-center">
        <a href="${pageContext.request.contextPath}/register" class="text-decoration-none small" style="color: #aaa;">¿No tienes cuenta? Regístrate aquí</a>
    </div>
</div>

</body>
</html>
