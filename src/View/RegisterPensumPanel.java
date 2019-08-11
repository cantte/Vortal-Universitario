/*
 * Copyright (C) 2019-2019 Carlos Pavajeau - Euder Calvo
 * 
 */

package View;

import java.awt.event.ActionEvent;
import java.io.IOException;

import javax.swing.JOptionPane;

import Model.Pensum;
import Model.PostGraduate;
import Model.UnderGraduate;
import Model.DataConnectionHandler.DataConnectionHandler;
import Model.DataConnectionHandler.PensumDataHandler;
import View.MainWindow.Panels;

/**
 * 
 */
public class RegisterPensumPanel extends FormPanel
{
    private static final long serialVersionUID = -5626698849668333842L;
    
    public RegisterPensumPanel()
    {
        super("REGISTRO DE PENSUM");
    }

    @Override
    public void InitFields() 
    {
        AddField(new TextField(300, 50, "Digite el código del pensum", TextField.OBLIGATORY_FIELD + TextField.NUMERIC_FIELD), "Código: ", 50, 150);
        AddField(new TextField(300, 50, "Digite el nombre del pensum", TextField.OBLIGATORY_FIELD + TextField.ALPHA_FIELD), "Nombre: ", 400, 150);
        AddField(new TextField(400, 50, "Descripción (Opcional)", 0), "Descripción: ", 50, 250);
        AddField(new TextField(300, 50, "Digite el campus", TextField.OBLIGATORY_FIELD + TextField.ALPHA_FIELD), "Campus: ", 50, 350);
        AddField(new TextField(300, 50, "Digite el número de semestres", TextField.OBLIGATORY_FIELD + TextField.NUMERIC_FIELD), "Semestres: ", 400, 350);
        AddField(new TextField(300, 50, "Digite la carga lectiva global",
                TextField.OBLIGATORY_FIELD + TextField.NUMERIC_FIELD), "Carga lectiva global: ", 50, 450);
        AddField(new TextField(300, 50, "Digite el título", TextField.OBLIGATORY_FIELD + TextField.ALPHA_FIELD),
                "Título (Requerido/A otorgar): ", 400, 450);
        AddRadioButtons("Tipo: ", 50, 550, "Pregrado", "Posgrado");
    }

    @Override
    protected void RegisterButtonAction(ActionEvent evt) 
    {
        if (ValidateFields() && ValidateRadioButtons())
        {
            try
            {
                String code, name, description, campus, title;
                int semesters, globalLessonLoad;

                code = GetCode();
                name = GetName();
                description = GetDescription();
                campus = GetCampus();
                semesters = GetSemesters();
                globalLessonLoad = GetGlobalLessonLoad();
                title = GetTitle();

                Pensum pensum = (GetRadioButtons().get(0).isSelected()) ? new UnderGraduate(code, name, description, campus, semesters, globalLessonLoad, null, title) : 
                                                                          new PostGraduate(code, name, description, campus, semesters, globalLessonLoad, null, title);

                DataConnectionHandler dataConnectionHandler = new PensumDataHandler();

                if (SaveData(pensum, dataConnectionHandler))
                {
                    JOptionPane.showMessageDialog(this, "Registro de PEMSUM exitoso!");
                    MainWindow.ChangePanel(Panels.REGISTER_PENSUM_PANEL, Panels.PENSUM_HANDLER_PANEL);
                    ClearFormPanel();
                }
                else
                    JOptionPane.showMessageDialog(this, "PEMSUM ya registrado. Digite otro código.");
            }
            catch (IOException exception)
            {
               
            }
        }
        else
            JOptionPane.showMessageDialog(this, "Campos invalidos");
	}

    @Override
    protected void ReturnButtonAction() 
    {
        super.ReturnButtonAction();
        MainWindow.ChangePanel(Panels.REGISTER_PENSUM_PANEL, Panels.PENSUM_HANDLER_PANEL);
    }

    @Override
    protected void InitPanel() 
    {
        AddRegisterButton(TypeButton.BUTTON_REGISTER);
    }

    private String GetCode()
    {
        return GetContentField(0);
    }

    private String GetName()
    {
        return GetContentField(1);
    }

    private String GetDescription()
    {
        return GetFields().get(2).IsValidField() ? GetContentField(2) : "";
    }

    private String GetCampus()
    {
        return GetContentField(3);
    }

    private int GetSemesters()
    {
        return Integer.valueOf(GetContentField(4));
    }

    private int GetGlobalLessonLoad()
    {
        return Integer.valueOf(GetContentField(5));
    }

    private String GetTitle()
    {
        return GetContentField(6);
    }
}