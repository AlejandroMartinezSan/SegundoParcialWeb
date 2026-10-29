package org.gerdoc.service.impl;

import org.gerdoc.dao.LoginDao;
import org.gerdoc.dao.impl.LoginDaoImpl;
import org.gerdoc.model.Login;
import org.gerdoc.service.LoginService;

import java.util.List;

public class LoginServiceImpl implements LoginService
{
    private LoginDao LoginDao;

    public LoginServiceImpl( )
    {
        this.LoginDao = (org.gerdoc.dao.LoginDao) new LoginDaoImpl( );
    }

    @Override
    public List<Login> findAll()
    {
        return LoginDao.findAll( );
    }

    @Override
    public Login findById(Long id)
    {
        return LoginDao.findById( id );
    }

    @Override
    public void save(Login Login)
    {
        LoginDao.save( Login );
    }

    @Override
    public void deleteById(Long id)
    {
        LoginDao.deleteById( id );
    }

    @Override
    public void update(Login Login)
    {
        LoginDao.update( Login );
    }
}
