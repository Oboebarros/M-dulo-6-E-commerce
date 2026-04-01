<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>OboeMarket — Registro</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body { background-color: #0f1123; color: #e0e0e0; font-family: 'Segoe UI', sans-serif; display: flex; align-items: center; min-height: 100vh; }
        .card { background-color: #16213e; border: 1px solid rgba(201,168,76,0.2); border-radius: 20px; box-shadow: 0 10px 40px rgba(0,0,0,0.4); max-width: 500px; width: 100%; margin: auto; padding: 2.5rem; }
        .form-label { color: #c9a84c; font-weight: bold; }
        .form-control { background-color: #1a1a2e; border: 1px solid rgba(201,168,76,0.3); color: #fff; }
        .form-control:focus { background-color: #1a1a2e; border-color: #c9a84c; color: #fff; box-shadow: 0 0 10px rgba(201,168,76,0.2); }
        .btn-gold { background: linear-gradient(45deg, #c9a84c, #e0c070); color: #1a1a2e; border: none; font-weight: bold; border-radius: 50px; padding: 12px 0; width: 100%; transition: 0.3s; }
        .btn-gold:hover { transform: translateY(-2px); box-shadow: 0 5px 15px rgba(201,168,76,0.4); color: #1a1a2e; }
        .brand { color: #c9a84c; font-size: 2.5rem; font-weight: bold; text-align: center; margin-bottom: 2rem; letter-spacing: 2px; }
    </style>
</head>
<body>

<div class="card">
    <div class="brand">OBOEMARKET</div>
    <h4 class="text-center mb-4">Crea tu Cuenta</h4>

    <c:if test="${not empty error}">
        <div class="alert alert-danger p-2 small">${error}</div>
    </c:if>

    <form action="${pageContext.request.contextPath}/register" method="post">
        <div class="row">
            <div class="col-md-6 mb-3">
                <label class="form-label">Nombre</label>
                <input type="text" name="nombre" class="form-control" value="${user.nombre}" required>
            </div>
            <div class="col-md-6 mb-3">
                <label class="form-label">Apellido</label>
                <input type="text" name="apellido" class="form-control" value="${user.apellido}" required>
            </div>
        </div>
        <div class="mb-3">
            <label class="form-label">Email</label>
            <input type="email" name="email" class="form-control" value="${user.email}" required>
        </div>
        <div class="mb-4">
            <label class="form-label">Contraseña</label>
            <input type="password" name="password" class="form-control" required>
        </div>
        <button type="submit" class="btn btn-gold mb-3">REGISTRARME</button>
    </form>
    
    <div class="text-center">
        <a href="${pageContext.request.contextPath}/login" class="text-decoration-none small" style="color: #aaa;">¿Ya tienes cuenta? Inicia sesión</a>
    </div>
</div>

</body>
</html>
