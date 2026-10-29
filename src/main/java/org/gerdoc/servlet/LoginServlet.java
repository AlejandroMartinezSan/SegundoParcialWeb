package org.gerdoc.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.gerdoc.service.LoginService;
import org.gerdoc.service.impl.LoginServiceImpl;
import org.gerdoc.model.Login;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private LoginService loginService = new LoginServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String usuarioInput = request.getParameter("nombre");
        String contrasenaInput = request.getParameter("especialidad");
        String accion = request.getParameter("accion");

        if (usuarioInput == null || contrasenaInput == null || usuarioInput.trim().isEmpty() || contrasenaInput.trim().isEmpty()) {
            request.setAttribute("errorMsg", "El usuario y la contraseña son obligatorios.");
            request.getRequestDispatcher("login.jsp").forward(request, response);
            return;
        }

        Login usuarioAutenticado = loginService.authenticate(usuarioInput, contrasenaInput);

        if (usuarioAutenticado != null) {

            if (!usuarioAutenticado.isActivo()) {
                request.setAttribute("errorMsg", "El usuario se encuentra inactivo. Contacte al administrador.");
                request.getRequestDispatcher("login.jsp").forward(request, response);
                return;
            }

            String rol = usuarioAutenticado.getRol();

            String nombreCompleto = usuarioAutenticado.getNombreCompleto();

            HttpSession session = request.getSession(true);
            session.setAttribute("usuarioLogueado", usuarioAutenticado);
            session.setAttribute("rol", rol);
            session.setAttribute("nombreUsuario", nombreCompleto);

            if ("PROFESOR".equalsIgnoreCase(rol)) {
                response.sendRedirect("dashboard_profesor.jsp");
            } else if ("ALUMNO".equalsIgnoreCase(rol)) {
                response.sendRedirect("dashboard_alumno.jsp");
            } else {
                response.sendRedirect("index.jsp");
            }

        } else {
            request.setAttribute("errorMsg", "Usuario o contraseña incorrectos. Intente de nuevo.");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect("login.jsp");
    }
}