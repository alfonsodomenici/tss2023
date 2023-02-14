/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.tss.interfacce.esempi_base;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author ospite
 */
public class B extends A implements ActionListener{

    @Override
    public void m1() {
        
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
         JOptionPane.showMessageDialog(null, "ascolto click su prova da B");
    }
    
}
