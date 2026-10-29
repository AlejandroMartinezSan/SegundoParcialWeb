package org.gerdoc.service;

import org.gerdoc.model.Login;

import java.util.List;

public interface LoginService
{
    List<Login> findAll( );
    Login findById( Long id );
    void save( Login Login );
    void deleteById( Long id );
    void update( Login Login );

    Login authenticate(String usuarioInput, String contrasenaInput);
}
