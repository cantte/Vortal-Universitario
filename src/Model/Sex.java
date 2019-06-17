/*
 * Copyright (C) 2019-2019 Carlos Pavajeau - Euder Calvo
 * 
 */

package Model;

/**
 * This is the enum {@code Sex}, represent one sex.
 * @version 1.0
 * @author Carlos Pavajeau - Cantte
 */
public enum Sex
{
    /**Male sex*/
    MALE("Masculino"),
    /**Female sex*/
    FEMALE("Femenino"),
    /**Other sex*/
    OTHER("Otro");

    private final String m_sex;

    /**
     * Initialize a new {@code Sex} 
     * @param sex will be a new sex.
     */
    private Sex(String sex)
    {
        m_sex = sex;
    }

    public String GetSex()
    {
        return m_sex;
    }
}