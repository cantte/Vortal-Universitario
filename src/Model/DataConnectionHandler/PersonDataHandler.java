/*
 * Copyright (C) 2019 Carlos Pavajeau
 * 
 */

package Model.DataConnectionHandler;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

/**
 * 
 */
public class PersonDataHandler extends EntityDataHandler
{
    public PersonDataHandler() throws FileNotFoundException
    {
        super("Person.dat");
    }
    
    @Override
    public boolean Insert(Object anObject) throws SQLException, ClassNotFoundException, IOException 
    {
        return super.Insert(anObject);
    }

    @Override
    public Object Select(Object anObject) throws SQLException, ClassNotFoundException, IOException 
    {
        return super.Select(anObject);
    }

    @Override
    public boolean Update(Object anObject) throws SQLException, ClassNotFoundException, IOException 
    {
        return super.Update(anObject);
    }

    @Override
    public boolean Delete(Object anObject) throws SQLException, ClassNotFoundException, IOException 
    {
        return super.Delete(anObject);
    }
}