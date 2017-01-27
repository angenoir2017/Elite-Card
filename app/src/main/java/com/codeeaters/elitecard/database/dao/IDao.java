package com.codeeaters.elitecard.database.dao;

import java.util.ArrayList;

/**
 * Created by leinad on 1/11/17.
 */

public interface IDao<T> {

    public T add(T entity);

    public boolean addMany(ArrayList<T> entities);

    public boolean updateOne(T entity);

    public boolean updateMany(ArrayList<T> entities);

    public boolean remove(T entity);

    public boolean removeMany(ArrayList<T> entities);

    public boolean removeAll();

    public T fetchOne(int id);

    public ArrayList<T> fetchAll();
}
