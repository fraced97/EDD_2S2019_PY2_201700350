/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import static eddproyecto2.EDDProyecto2.tabla;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author USUARIO
 */
public class VentanaUsuarioError extends JFrame {
    
    public VentanaUsuarioError() {
        //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super("VENTANA DE USUARIOS CON ERROR");
        this.setSize(900, 600);

        setLocationRelativeTo(null);
        //TABLA
        //COMPONENTES
        JPanel mostrarusuario = new JPanel();
        //JButton pregresar = new JButton("Regresar");
        //JButton pcargar = new JButton("Cargar");
        JButton pgenerar = new JButton("Generar");

        JTable tablamosrarusuario = new JTable();
        DefaultTableModel tablamostrarusuario2 = new DefaultTableModel() {   //no se pueda editar la tabla
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        JScrollPane scroll9 = new JScrollPane(tablamosrarusuario);

        //LAYOUT
        this.setLayout(null);
        mostrarusuario.setBounds(0, 0, 900, 600);
        getContentPane().add(mostrarusuario);

        //VISIBILIDAD
        this.setVisible(true);
        mostrarusuario.setLayout(null);
        mostrarusuario.setVisible(true);

        tablamostrarusuario2.addColumn("Usuario");
        tablamostrarusuario2.addColumn("Contraseña");
        tablamostrarusuario2.addColumn("Tipo de Error");
        //tablamostrarusuario2.addColumn("Apellido");
        //tablamostrarusuario2.addColumn("Correo");
        //tablamostrarusuario2.addColumn("Direccion");
        //tablamostrarusuario2.addColumn("Creditos");
        //tablamostrarusuario2.addColumn("Contraseña");
        tablamosrarusuario.setModel(tablamostrarusuario2);
        tablamosrarusuario.setBackground(Color.white);

        scroll9.setBounds(40, 100, 800, 400);
        mostrarusuario.add(scroll9);

        //BOTONES
        //pregresar.setBounds(700, 44, 120, 30);
        //mostrarusuario.add(pregresar);
        //pcargar.setBounds(100, 44, 120, 30);
        //mostrarusuario.add(pcargar);
        pgenerar.setBounds(350, 44, 120, 30);
        mostrarusuario.add(pgenerar);

        //COLOR
        mostrarusuario.setBackground(Color.cyan);

        /*pregresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CargaUsuario administrador = new CargaUsuario();
                administrador.setVisible(true);
                VentanaUsuarioError.this.dispose();
            }
        });*/
       /* pcargar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                seleccionararchivo.setFileFilter(new FileNameExtensionFilter("todos los archivos *.ipc_e", "ipc_e", "IPC_E"));
                int abrir = seleccionararchivo.showDialog(null, "Abrir");
                if (abrir == JFileChooser.APPROVE_OPTION) {
                    String PATH = seleccionararchivo.getSelectedFile().getAbsolutePath();
                    if (PATH.endsWith(".ipc_e") || PATH.endsWith(".IPC_E")) {
                        archivo = seleccionararchivo.getSelectedFile();
                        leer_archivo(archivo);

                    } else {
                        System.out.println("No es ipc_e");
                    }
                }
            }
        });*/

        pgenerar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //NodoEstudiante actual = new NodoEstudiante();
                //actual = Proyecto2IPC1.estudiante.primero;
                //do {
                    for(int i=0;i<tabla.usuarioError.size();i++){
                       String mostrar[] = {tabla.usuarioError.get(i), tabla.contraError.get(i),tabla.comentarioError.get(i)};
                    tablamostrarusuario2.addRow(mostrar); 
                    }
                    //String mostrar[] = {actual.carnet, actual.dpi};
                    //tablamostrarusuario2.addRow(mostrar);
                    //actual = actual.siguiente;
                //} while (actual != Proyecto2IPC1.estudiante.primero);

                tablamosrarusuario.setModel(tablamostrarusuario2);

            }
        });

        
    }
    
}
