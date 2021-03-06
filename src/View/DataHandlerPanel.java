/*
 * Copyright (C) 2019 Carlos Pavajeau
 * 
 */

package View;

/**
 * 
 */
public class DataHandlerPanel extends Panel
{
    private static final long serialVersionUID = -7729393240920736937L;

    public DataHandlerPanel()
    {
        super("GESTIÓN DE DATOS");
    }

    @Override
    protected void InitPanel() 
    {
        AddCenterComponentY(new Button(TypeButton.BUTTON_ICON_ACCESS_DATA_MANAGER, null), 375);
        AddCenterComponentY(new Button(TypeButton.BUTTON_ICON_PERSONAL_DATA_MANAGER, null), 525);
        AddReturnButton();
    }
}