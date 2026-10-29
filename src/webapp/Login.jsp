<%@ page import="org.gerdoc.service.LoginService" %>
<%@ page import="org.gerdoc.service.impl.LoginServiceImpl" %>
<%@ page import="org.gerdoc.model.Login" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!doctype html>
<html lang="es">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Iniciar Sesión</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-5">

    <%-- CONTENEDOR PARA MOSTRAR MENSAJES DE ERROR CUANDO LAS CREDENCIALES SON INCORRECTAS --%>
    <%
        String errorMsg = (String) request.getAttribute("errorMsg");
        if (errorMsg != null) {
    %>
        <div class="alert alert-danger alert-dismissible fade show" role="alert">
            <strong>Error:</strong> <%= errorMsg %>
            <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
        </div>
    <%
        }
    %>

    <div class="card mx-auto mt-5" style="max-width: 450px;">
        <div class="card-header bg-primary text-white text-center">
            <h4 class="mb-0">Control de Acceso</h4>
        </div>
        <div class="card-body">
            <h1 class="h4 text-center mb-4">Iniciar Sesión</h1>

            <%-- Formulario directo apuntando al Servlet --%>
            <form action="LoginServlet" method="post" id="formLogin">
                <input type="hidden" id="accion" name="accion" value="login" />

                <div class="mb-3">
                    <label for="nombre" class="form-label">Usuario / Nombre</label>
                    <input type="text" class="form-control" id="nombre" name="nombre" placeholder="Introduce tu usuario" required>
                </div>

                <div class="mb-3">
                    <label for="especialidad" class="form-label">Contraseña</label>
                    <input type="password" class="form-control" id="especialidad" name="especialidad" placeholder="Introduce tu contraseña" required>
                </div>

                <div class="d-grid gap-2 mt-4">
                    <button type="submit" class="btn btn-primary" id="btnGuardar">Ingresar</button>
                    <a href="index.jsp" class="btn btn-secondary">Regresar al Home</a>
                </div>
            </form>
        </div>
    </div>
</div>

<%-- El modal original se conserva por si lo necesitas desplegar como un popup complementario --%>
<div class="container text-center mt-3">
    <button type="button" class="btn btn-outline-success btn-sm" data-bs-toggle="modal" data-bs-target="#LoginModal">
        Ver Formulario alternativo en Popup
    </button>
</div>

<!-- Popup / Modal con formulario -->
<div class="modal fade" id="LoginModal" tabindex="-1" aria-labelledby="LoginModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="LoginModalLabel">Formulario de Login Alterno</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Cerrar"></button>
            </div>
            <form action="LoginServlet" method="post">
                <input type="hidden" name="accion" value="login" />
                <div class="modal-body">
                    <div class="mb-3">
                        <label for="modal_nombre" class="form-label">Nombre</label>
                        <input type="text" class="form-control" id="modal_nombre" name="nombre" required>
                    </div>
                    <div class="mb-3">
                        <label for="modal_especialidad" class="form-label">Contraseña</label>
                        <input type="password" class="form-control" id="modal_especialidad" name="especialidad" required>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cerrar</button>
                    <button type="submit" class="btn btn-success">Validar Credenciales</button>
                </div>
            </form>
        </div>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
