/*
 * Copyright (C) 2019 Carlos Pavajeau
 * 
 */

package View;

/**
 * 
 */
public class PasswordField extends Field
{
    private static final long serialVersionUID = 4725724463251225939L;

    public PasswordField(int width, int height, String defaultText)
    {
        super(width, height, defaultText, Field.OBLIGATORY_FIELD);
    }

    public PasswordField(String defaultText)
    {
        super(defaultText, Field.OBLIGATORY_FIELD);
    }
}