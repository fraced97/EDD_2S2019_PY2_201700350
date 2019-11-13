/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

/**
 *
 * @author USUARIO
 */ 
public class ScrollPaneReport extends JFrame implements KeyListener{
    String rut;
    JScrollPane jsp;

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        ScrollPaneReport spn = new ScrollPaneReport(rut);
        spn.setSize(this.getSize());
        this.setVisible(false);
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    public ScrollPaneReport(String rut) {
        super("Ventana De Reportes");
        this.rut = rut;
        //addKeyListener(this);
        ImageIcon ii = new ImageIcon(rut);
        jsp = new JScrollPane(new JLabel(ii));
        this.getContentPane().add(jsp);
        this.setSize(1000, 950);
        this.setVisible(true);

    }

    

}
