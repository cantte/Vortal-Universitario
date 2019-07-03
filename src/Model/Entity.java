/*
 * Copyright (C) 2019-2019 Carlos Pavajeau - Euder Calvo
 * 
 */

package Model;

/**
 * This is the superclass of most major classes of software. Of course this 
 * class is abstract. But currently not implemented the abstract methods.
 * 
 * @version 1.0
 * @author Carlos Pavajeau - Cantte
 */

public abstract class Entity implements Comparable<Entity>
{
    private final String m_code;
    
    /**
     * Initialize a new {@code Entity} with it's code. 
     * This code identifies the {@code Entity} in the software, also the code is
     * unique and not repeatable by other {@code Entity}.
     * @param code that is to be assigned to the object.
     */
    public Entity(String code)
    {
        m_code = code;
    }

    /**
     * Initialize a new {@code Entity} with other {@code Entity}, this is the copy constructor.
     * This code identifies the {@code Entity} in the software, also the code is
     * unique and not repeatable by other {@code Entity}.
     * @param anEntity
     */
    public Entity(Entity anEntity)
    {
        this(anEntity.GetCode());
    }

    /**
     * Initialize a new {@code Entity} empty.
     * This code identifies the {@code Entity} in the software, also the code is
     * unique and not repeatable by other {@code Entity}.
     */
    public Entity()
    {
        this("");
    }

    /**
     * This method returns the code that this {@code Entity} has.
     * @return the code that this {@code Entity} has.
     */
    public String GetCode()
    {
        return m_code;
    }

    /**
     * This method returns {@code true} if the objects be {@code Entity} or the objects has
     * equals codes.
     * @param anObject The object to compare this {@code Entity} against.
     * @return {@code true} if the given object represents a {@code Entity} with
     *  a equivalent code. {@code false} otherwise.
     */
    @Override
    public boolean equals(Object anObject) 
    {
        if (this == anObject)
            return true;
        if (anObject == null)
            return false;
        if (getClass() != anObject.getClass())
            return false;
        Entity other = (Entity) anObject;
        if (GetCode() == null) {
            if (other.GetCode() != null)
                return false;
        } else if (!GetCode().equals(other.GetCode()))
            return false;
        return true;
    }

    /**
     * Returns a hashcode for this {@code Entity}. The result is
     * the exclusive OR of the two halves of the pimitive {@code long}
     * value held by this {@code  Entity} object
     * @return a hash code value for this object.
     */
    @Override
    public int hashCode() 
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((GetCode() == null) ? 0 : GetCode().hashCode());
        return result;
    }

    /**
     * Compares the codes of two {@code Entity} objects.
     * @param anEntity The object to compare this {@code Entity} against.
     * @return the value {@code 0} if the code of this {@code Entity} is equal to the argument
     * {@code Entity}, a value less than {@code 0} if the code of this {@code Entity} is 
     * less than the argument {@code Entity} and a value greater than {@code 0}
     * if the code of this {@code Entity} is greater than the argument {@code Entity}.
     */
    @Override
    public int compareTo(Entity anEntity)
    {
        return GetCode().compareTo(anEntity.GetCode());
    }
}
