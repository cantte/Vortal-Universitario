/*
 * Copyright (C) 2019 Carlos Pavajeau
 * 
 */

package View;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JRadioButton;

/**
 * 
 */
public class RadioButton extends JRadioButton
{
    private static final long serialVersionUID = 5980880864892898722L;

    private static final String ICON_RADIO_BUTTON = "/View/Assets/Icons/15x15/Icon_RadioButton.png";
    private static final String ROLLOVER_ICON_RADIO_BUTTON = "/View/Assets/Icons/15x15/Icon_RadioButtonMouseOn.png";
    private static final String SELECT_ICON_RADIO_BUTTON = "/View/Assets/Icons/15x15/Icon_RadioButtonSelect.png";

    public static final byte RADIO_BUTTON_WIDTH = 120;
    public static final byte RADIO_BUTTON_HEIGHT = 20;

    public RadioButton(String text)
    {
        super(text);
        setIcon(new ImageIcon(getClass().getResource(ICON_RADIO_BUTTON)));
        setRolloverIcon(new ImageIcon(getClass().getResource(ROLLOVER_ICON_RADIO_BUTTON)));
        setSelectedIcon(new ImageIcon(getClass().getResource(SELECT_ICON_RADIO_BUTTON)));
        setFont(FontConstants.DEFAULT_FONT);
        setBackground(Color.WHITE);
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        setSize(new Dimension(RadioButton.RADIO_BUTTON_WIDTH, RadioButton.RADIO_BUTTON_HEIGHT));
        setBorderPainted(false);
        setBorder(null);
        setFocusPainted(false);
    }
}