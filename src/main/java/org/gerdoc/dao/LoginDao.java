package org.gerdoc.dao;

import org.gerdoc.model.Login;

import java.util.List;

public interface LoginDao
{
    List<Login> findAll( );
    Login findById(Long id);
    Login save(Login Login);
    void deleteById(Long id);
    Login update(Login Login);
}
