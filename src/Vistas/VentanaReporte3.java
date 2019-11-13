/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import javax.swing.JFrame;
import java.awt.*;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

/**
 *
 * @author USUARIO
 */
public class VentanaReporte3 extends JFrame {
    
    JLabel imagen;
    JScrollPane scroll;
    public VentanaReporte3(String ruta){
        super("Ventana Reporte");
        setSize(900,600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        imagen= new JLabel(new ImageIcon(ruta));
        scroll = new JScrollPane();
        scroll.setViewportView(imagen);
        add(scroll);
        setVisible(true);
        
    }
    
}
