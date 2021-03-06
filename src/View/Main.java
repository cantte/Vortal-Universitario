/*
 * Copyright (C) 2019 Carlos Pavajeau
 * 
 */

package View;

import java.awt.EventQueue;

/**
 * This is the main class, here the application starts.
 * @version 1.0
 * @author Carlos Pavajeau - Cantte
 */

public class Main
{
    public static void main(String[] args) 
    {
        EventQueue.invokeLater(() -> 
        {
            MainWindow.MainWindow.setVisible(true);
        });
    }
}