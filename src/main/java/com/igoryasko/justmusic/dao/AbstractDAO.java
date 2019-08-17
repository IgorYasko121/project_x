package com.igoryasko.justmusic.dao;

import com.igoryasko.justmusic.entity.Entity;
import com.igoryasko.justmusic.exception.DaoException;

import java.sql.Connection;
import java.util.List;

/**
 * The {@code AbstractDAO} class provides methods for working with the database.
 *
 * @author Igor Yasko on 2019-07-19.
 */
public abstract class AbstractDAO<T extends Entity> {

    protected Connection connection;

    public abstract List<T> findAll() throws DaoException;

    public abstract T findById(long id) throws DaoException;

    public abstract boolean delete(long id) throws DaoException;

    void setConnection(Connection connection) {
        this.connection = connection;
    }

}
