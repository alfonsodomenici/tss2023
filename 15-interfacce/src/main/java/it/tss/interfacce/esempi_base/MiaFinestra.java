/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.tss.interfacce.esempi_base;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author ospite
 */
public class MiaFinestra extends JFrame{

    private JButton btn;
    
    public MiaFinestra(String titolo) throws HeadlessException {
        super(titolo);
        initComponents();
    }

    private void initComponents() {
        btn = new JButton();
        btn.setText("click on");
        btn.setBounds(10, 20, 100, 20);
        btn.addActionListener(this::onBtnClick);
        this.getContentPane().add(btn);
        this.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    }
    
    private void onBtnClick(ActionEvent e){
        JOptionPane.showMessageDialog(this, "Clickeddddd!!!!!!!");
    }
    
    public static void main(String[] args) {
        MiaFinestra f = new MiaFinestra("prova");
        f.setBounds(100, 100, 400, 500);
        f.setVisible(true);
    }
}
