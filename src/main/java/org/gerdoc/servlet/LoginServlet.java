package org.gerdoc.servlet;

import org.gerdoc.model.Login;
import org.gerdoc.service.LoginService;
import org.gerdoc.service.impl.LoginServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serial;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet
{
    @Serial
    private static final long serialVersionUID = 1L;
    private final LoginService LoginService = new LoginServiceImpl( );

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        String accion = req.getParameter("accion");
        if ("delete".equals(accion))
        {
            Long id = Long.parseLong(req.getParameter("id"));
            LoginService.deleteById(id);
            resp.sendRedirect("Logins.jsp");
            return;
        }
        String nombre = req.getParameter("nombre" );
        Integer edad = Integer.parseInt( req.getParameter("edad" ) );
        Double promedio = Double.parseDouble( req.getParameter("promedio" ) );
        Long id = Long.parseLong( req.getParameter("id" ) );

        Login Login = org.gerdoc.model.Login.builder( )
                .nombre( nombre )
                .edad( edad )
                .promedio( promedio )
                .build();
        if( "update".equals(accion) )
        {
            Login.setId( id );
            LoginService.update( Login );
        }
        else
        {
            LoginService.save( Login );
        }
        resp.sendRedirect("Logins.jsp");
    }
}
