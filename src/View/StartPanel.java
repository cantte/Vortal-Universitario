/*
 * Copyright (C) 2019 Carlos Pavajeau
 * 
 */

package View;

import java.awt.Point;
import java.awt.event.ActionEvent;

import Model.DataConnectionHandler.DataConnectionHandler;
import Model.DataConnectionHandler.PersonDataHandler;
import View.LoginPanel.TypeUser;

/**
 * 
 */
public class StartPanel extends Panel
{
    private static final long serialVersionUID = -3651333001011074104L;

    public StartPanel()
    {
        super("BIENVENIDO, SELECIONE LA OPCIÓN QUE DESEE");
    }

    @Override
    protected void InitPanel()
    {
        Button imProfessorButton = new Button(TypeButton.BUTTON_ICON_I_AM_PROFESSOR, 
                                            (ActionEvent evt) -> 
                                            {
                                                PanelHandler.ShowLoginPanel(TypeUser.PROFESSOR); 
                                            });
        Button imStudentButton = new Button(TypeButton.BUTTON_ICON_I_AM_STUDENT, 
                                            (ActionEvent evt) -> 
                                            { 
                                                PanelHandler.ShowLoginPanel(TypeUser.STUDENT); 
                                            });
        Button imAdminButton = new Button(TypeButton.BUTTON_ICON_I_AM_ADMIN, 
                                            (ActionEvent evt) -> 
                                            { 
                                                PanelHandler.ShowLoginPanel(TypeUser.ADMIN); 
                                            });

        AddComponent(imProfessorButton, new Point(100, 100));
        AddComponent(imStudentButton, new Point(700, 100));
        AddCenterComponentX(imAdminButton, 400);
        AddButton(TypeButton.BUTTON_EXIT, new Point(775, 625), (ActionEvent evt) -> { ExitButtonAction(); });
        EnableButtons();
    }

    private void ExitButtonAction()
    {
        System.exit(0);
    }

    public void EnableButtons()
    {
        try
        {
            DataConnectionHandler dataConnectionHandler = new PersonDataHandler();
            if (!dataConnectionHandler.ConnectWithData())
            {
                GetButtons().get(0).setEnabled(false);
                GetButtons().get(1).setEnabled(false);
            }
            else
            {
                GetButtons().get(0).setEnabled(true);
                GetButtons().get(1).setEnabled(true);   
            }
        }
        catch (Exception exception)
        {

        }
    }
}