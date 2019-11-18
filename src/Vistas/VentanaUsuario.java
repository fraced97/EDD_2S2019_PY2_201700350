/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import Estructuras.ArbolAVL2;
import Estructuras.Archivo;
import Estructuras.MatrizAd.NodoMatrizAd;
import Estructuras.Usuario;
import static Vistas.Login.usuarioActual;
import static eddproyecto2.EDDProyecto2.tabla;
import java.awt.Component;
import java.awt.Image;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import javax.swing.DefaultListModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListCellRenderer;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author USUARIO
 */
public final class VentanaUsuario extends javax.swing.JFrame {

    /**
     * Creates new form VentanaUsuario
     */
                NodoMatrizAd nodoEnComunMatriz;
        NodoMatrizAd antes;
                NodoMatrizAd father;
            NodoMatrizAd rutaActual;
            JFileChooser seleccionararchivo = new JFileChooser();
    File archivo;
            
    public VentanaUsuario() {
        super("Bienvenido "+ usuarioActual.getNickname());
        initComponents();
        nodoEnComunMatriz = null;
        father=usuarioActual.getMatriz().buscarMatriz(0, 1);
        
        System.out.println(father.getArbol().getRuta());
        /*DefaultListModel dlm = new DefaultListModel();
        dlm.addElement(new ListEntry("AAA", new ImageIcon("C:\\Users\\USUARIO\\Documents\\NetBeansProjects\\EDDProyecto2\\carpeta2.png")));  
        jList1 = new JList(dlm);
        this.jList3 = new JList(dlm);
        jList1.updateUI();
       
        jList1.setCellRenderer(new ListEntryCellRenderer());
        jList3.setCellRenderer(new ListEntryCellRenderer());
        this.pack();
       
        jList1.updateUI();
        jList3.updateUI();*/
        labelRuta.setText(father.getArbol().getRuta());
        labelNombreUsuario.setText(usuarioActual.getNickname());
        Carpetas();
        Archivos();
        
    }
    
    public void Carpetas(){
        DefaultListModel dlm = new DefaultListModel();
        NodoMatrizAd temp = this.father.getSiguiente();
        rutaActual=this.father;
       
        while(temp!=null){
            
            dlm.addElement(new entrarLista(temp.getArbol().getNombre(), new ImageIcon("carpeta2.png")));    
            
            temp = temp.getSiguiente();
            
            
        }
        //////ARCHIVOS
         NodoMatrizAd aux;
                if(this.nodoEnComunMatriz==null){
            aux = this.father;
                }else{
                    aux = this.nodoEnComunMatriz;
                }
                //DefaultListModel dlm = new DefaultListModel();
                aux.getArbol().inorden2();
                for(Archivo a: aux.getArbol().getArchivosList() ){
             
             dlm.addElement(new entrarLista(a.getNombre(), new ImageIcon("archivo2.png")));
             
                    }
            jList1.setModel(dlm);
                jList1.setCellRenderer(new imagenEnLista());
                        jList1.updateUI();
        /////ARCHIVOOOOOAAAA
        //jList1 = new JList(dlm);
        jList1.setModel(dlm);
        jList1.setCellRenderer(new imagenEnLista());
        jList1.updateUI();
        
        
        
    }
   

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jRadioButton1 = new javax.swing.JRadioButton();
        jPanel2 = new javax.swing.JPanel();
        btCrearC = new javax.swing.JButton();
        btModificarC = new javax.swing.JButton();
        btEliminarC = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        crearArchivos = new javax.swing.JButton();
        btModificarA = new javax.swing.JButton();
        btEliminarA = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        labelRuta = new javax.swing.JLabel();
        labelNombreUsuario = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        abrirC = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList3 = new javax.swing.JList<>();
        jButton1 = new javax.swing.JButton();
        regresar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        jRadioButton1.setText("jRadioButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(0, 0));

        jPanel2.setBackground(new java.awt.Color(51, 255, 102));
        jPanel2.setLayout(null);

        btCrearC.setText("Crear");
        btCrearC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCrearCActionPerformed(evt);
            }
        });
        jPanel2.add(btCrearC);
        btCrearC.setBounds(10, 23, 220, 30);

        btModificarC.setText("Modificar");
        jPanel2.add(btModificarC);
        btModificarC.setBounds(10, 70, 220, 30);

        btEliminarC.setText("Eliminar");
        jPanel2.add(btEliminarC);
        btEliminarC.setBounds(10, 110, 220, 30);

        jButton4.setText("Graficar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton4);
        jButton4.setBounds(10, 150, 220, 30);

        jPanel3.setBackground(new java.awt.Color(51, 255, 51));
        jPanel3.setLayout(null);

        crearArchivos.setText("Crear");
        crearArchivos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crearArchivosActionPerformed(evt);
            }
        });
        jPanel3.add(crearArchivos);
        crearArchivos.setBounds(20, 20, 210, 30);

        btModificarA.setText("Modificar");
        btModificarA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btModificarAActionPerformed(evt);
            }
        });
        jPanel3.add(btModificarA);
        btModificarA.setBounds(20, 60, 210, 30);

        btEliminarA.setText("Eliminar");
        btEliminarA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEliminarAActionPerformed(evt);
            }
        });
        jPanel3.add(btEliminarA);
        btEliminarA.setBounds(20, 100, 210, 30);

        jButton8.setText("Graficar");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton8);
        jButton8.setBounds(20, 140, 210, 30);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Archivos");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Carpetas");

        labelNombreUsuario.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        labelNombreUsuario.setText("Admin");

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jList1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jList1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jList1);

        abrirC.setText("Abrir Carpeta");
        abrirC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                abrirCActionPerformed(evt);
            }
        });

        jButton2.setText("Carga Archivos");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jList3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jList3MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jList3);

        jButton1.setText("Salir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        regresar.setText("Regresar");
        regresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regresarActionPerformed(evt);
            }
        });

        jLabel3.setText("Nombre");

        jLabel5.setText("Contenido");

        jLabel6.setText("Fecha y hora");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelNombreUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(abrirC, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(36, 36, 36)
                                .addComponent(regresar, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)
                                .addComponent(jButton1)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(labelRuta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 630, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addContainerGap())))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addContainerGap())))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelNombreUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(abrirC)
                            .addComponent(jButton2)
                            .addComponent(regresar)
                            .addComponent(jButton1))
                        .addGap(7, 7, 7)
                        .addComponent(labelRuta, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(37, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btCrearCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCrearCActionPerformed
        // TODO add your handling code here:
        String name = JOptionPane.showInputDialog(this, "Escriba el nombre de la Carpeta");
        NodoMatrizAd temp;
        temp=father;
        
        String aux = father.getArbol().getRuta()+name+"/";
        while(true){
            if(temp.getAbajo()!=null){
                temp =temp.getAbajo();
                
            }else{
                usuarioActual.getMatriz().insertarElemento(0, temp.getY()+1, new ArbolAVL2(aux,name));
                usuarioActual.getMatriz().insertarElemento(temp.getY()+1, 0, new ArbolAVL2(aux,name));
                usuarioActual.getMatriz().insertarInterseccion(father.getArbol().getRuta(), aux,name);
                break;
                               
            }
            
        }
        Carpetas();
        
        
    }//GEN-LAST:event_btCrearCActionPerformed

    private void abrirCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_abrirCActionPerformed
        // TODO add your handling code here:
                NodoMatrizAd aux = this.father.getSiguiente();
                    NodoMatrizAd fatherAux;
                        int carpetaSeleccionada = jList1.getSelectedIndex();
                for(int i=0; i<carpetaSeleccionada;i++){
                    aux = aux.getSiguiente();
                }
                    fatherAux=usuarioActual.getMatriz().buscarMatriz(0, aux.getY());
                String carpetaAbrir = aux.getArbol().getRuta();
                this.nodoEnComunMatriz=aux;
          while(true){
             if(fatherAux.getArbol().getRuta().equals(carpetaAbrir)){
                         father = fatherAux;
                 break;
                    }else{
                 fatherAux = fatherAux.getAbajo();
             }
         }
                this.Archivos();
            this.Carpetas();
          labelRuta.setText(fatherAux.getArbol().getRuta());
            
            //rutaActual =aux;
    }//GEN-LAST:event_abrirCActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        usuarioActual.getMatriz().graficarMatriz();
        //tabla.graficar();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        Login login = new Login();
        login.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void regresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regresarActionPerformed
        // TODO add your handling code here:
        NodoMatrizAd rutaActual2= rutaActual;
        NodoMatrizAd rutaAux;
        NodoMatrizAd rutaAux2;
        rutaAux=usuarioActual.getMatriz().buscarMatriz(rutaActual2.getY(), 0);
        //while(true){
            if(rutaActual2.getY()!=1){
                //System.out.println("ENTRO AL PRIMER IF");
                if(rutaAux.getAbajo()!=null){
                    rutaAux=rutaAux.getAbajo();
                }
                
                rutaAux2=rutaAux;
                while(true){
                    
                    if(rutaAux2!=null){
                        //System.out.println("Entro al SEGUNDO if");
                        if(rutaAux2.getAnterior()==null){
                            rutaAux=rutaAux2;
                            //System.out.println("Entro al ultimo if");
                        }
                        rutaAux2=rutaAux2.getAnterior();
                    }else{
                        break;
                    }
                    
                }
               // System.out.println(rutaAux.getX());
                //System.out.println(rutaAux.getY());
                this.father=rutaAux.getSiguiente();
                //rutaAux=usuarioActual.getMatriz().buscarMatriz(rutaActual2.getY(), 0);
                
            }else{
                
                this.father=usuarioActual.getMatriz().buscarMatriz(0, 1);
                //break;
                
            }
       // }
        
        
        if(rutaActual2.getY()!=1){
            NodoMatrizAd auxRuta3=rutaAux.getSiguiente();
            if(auxRuta3.getArbol().getNombre().equals("Inicio")){
                this.nodoEnComunMatriz=null;
            }else{
                
                NodoMatrizAd auxRuta4=usuarioActual.getMatriz().buscarMatriz(auxRuta3.getY(), 0);
                this.nodoEnComunMatriz=auxRuta4.getAbajo();
                
            }
            
            labelRuta.setText(auxRuta3.getArbol().getRuta());
        }
        Carpetas();
        //System.out.println("lo logre");
        Archivos();
        
        
       
        
        
    }//GEN-LAST:event_regresarActionPerformed

    private void crearArchivosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crearArchivosActionPerformed
        // TODO add your handling code here:
                    String name = JOptionPane.showInputDialog("Escriba el nombre del Archivo", ".txt");
                    String contenido = JOptionPane.showInputDialog(this, "Escriba el contenido");
                if(nodoEnComunMatriz==null){
                                NodoMatrizAd aux =usuarioActual.getMatriz().buscarMatriz(father.getX(), father.getY());
           usuarioActual.getMatriz().buscarMatriz(aux.getX(), aux.getY()).getArbol().insertar(new Archivo(name,contenido));
                    }else{
                        NodoMatrizAd aux =usuarioActual.getMatriz().buscarMatriz(nodoEnComunMatriz.getX(), nodoEnComunMatriz.getY());
               usuarioActual.getMatriz().buscarMatriz(aux.getX(), aux.getY()).getArbol().insertar(new Archivo(name,contenido));
                    }
                Archivos();
                Carpetas();
                
                    
        
        
        
    }//GEN-LAST:event_crearArchivosActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
                if(nodoEnComunMatriz!=null){
            
            nodoEnComunMatriz.getArbol().graficarArbol();
           
            
                 }else{
           
             this.father.getArbol().graficarArbol();
        
             }
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jList3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList3MouseClicked
        // TODO add your handling code here:
                    try{
                    Archivo archivo;
                    if(nodoEnComunMatriz == null){
                            NodoMatrizAd temp;
            temp= this.father;
       temp.getArbol().inorden2();
            archivo = temp.getArbol().getArchivosList().get(this.jList3.getSelectedIndex());
                                    }else{
      NodoMatrizAd temp = this.nodoEnComunMatriz;
                     temp.getArbol().inorden2();
            archivo = temp.getArbol().getArchivosList().get(this.jList3.getSelectedIndex());            
                                    }
        
                           this.jLabel5.setText(archivo.getAdentro());
             this.jLabel6.setText(archivo.getFechaHora());
        this.jLabel3.setText(archivo.getNombre());
                    
            
                    }catch(ArrayIndexOutOfBoundsException r){
            
                    }
    }//GEN-LAST:event_jList3MouseClicked

    private void jList1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jList1MouseClicked

    private void btEliminarAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEliminarAActionPerformed
        // TODO add your handling code here:
                            if(nodoEnComunMatriz != null){
                     NodoMatrizAd temp = this.nodoEnComunMatriz;
            temp.getArbol().inorden2();
                        Archivo archivo = temp.getArbol().getArchivosList().get(this.jList3.getSelectedIndex());
                                    usuarioActual.getMatriz().buscarMatriz(temp.getX(),temp.getY()).getArbol().eliminarHojaArbol(archivo);
                }           else{
                NodoMatrizAd temp = this.father;
                        temp.getArbol().inorden2();
      Archivo archivo = temp.getArbol().getArchivosList().get(this.jList3.getSelectedIndex());
                                usuarioActual.getMatriz().buscarMatriz(temp.getX(),temp.getY()).getArbol().eliminarHojaArbol(archivo);
 
        }
                         Archivos();
               Carpetas();
    }//GEN-LAST:event_btEliminarAActionPerformed

    private void btModificarAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btModificarAActionPerformed
        // TODO add your handling code here:
        String name = JOptionPane.showInputDialog("Modificar, Escriba el nuevo contenido", ".txt");
                    String contenido = JOptionPane.showInputDialog(this, "Escriba el contenido");
      if(nodoEnComunMatriz != null){
                        NodoMatrizAd aux = nodoEnComunMatriz;
            aux.getArbol().inorden2();
            Archivo file = aux.getArbol().getArchivosList().get(this.jList3.getSelectedIndex());
                         Archivo file5 = aux.getArbol().getArchivosList().get(this.jList3.getSelectedIndex());
                        file5.setAdentro(contenido);
            file5.setNombre(name);
                        usuarioActual.getMatriz().buscarMatriz(aux.getX(),aux.getY()).getArbol().eliminarHojaArbol(file);
                usuarioActual.getMatriz().buscarMatriz(aux.getX(),aux.getY()).getArbol().insertar(file5);
            
                        }else{
        NodoMatrizAd aux4 = father;
            aux4.getArbol().inorden2();
                    Archivo file = aux4.getArbol().getArchivosList().get(this.jList3.getSelectedIndex());
        Archivo file6 = aux4.getArbol().getArchivosList().get(this.jList3.getSelectedIndex());
            usuarioActual.getMatriz().buscarMatriz(aux4.getX(),aux4.getY()).getArbol().eliminarHojaArbol(file);
                        file6.setAdentro(contenido);
            file6.setNombre(name);
                        usuarioActual.getMatriz().buscarMatriz(aux4.getX(),aux4.getY()).getArbol().insertar(file6);
            
        }
        Archivos();
        Carpetas();
        
        
    }//GEN-LAST:event_btModificarAActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        seleccionararchivo.setFileFilter(new FileNameExtensionFilter("todos los archivos *.csv", "csv", "CSV"));
                int abrir = seleccionararchivo.showDialog(null, "Abrir");
                if (abrir == JFileChooser.APPROVE_OPTION) {
                    String PATH = seleccionararchivo.getSelectedFile().getAbsolutePath();
                    if (PATH.endsWith(".csv") || PATH.endsWith(".CSV")) {
                        archivo = seleccionararchivo.getSelectedFile();
                        leer_archivo(archivo);

                    } else {
                        System.out.println("No es .csv");
                    }
                }
                Archivos();
                Carpetas();
        
        
    }//GEN-LAST:event_jButton2ActionPerformed

    public void leer_archivo(File archivo2) {
        FileReader FR = null;
        BufferedReader BR = null;

        String linea;
        //String Random;
        int contador=0;
        try {
            String datos[];
            String contra;
            //int contador = 0;
            FR = new FileReader(archivo);
            BR = new BufferedReader(FR);
            String line = BR.readLine();
            while (null!=line) {
            String [] fields = line.split(",");
            line = BR.readLine();
            if(contador!=0){
               //System.out.println(Arrays.toString(fields));
                //System.out.println(line);
                //tabla.insertar(new Usuario(fields[0],fields[1]));
                if(nodoEnComunMatriz==null){
                                NodoMatrizAd aux =usuarioActual.getMatriz().buscarMatriz(father.getX(), father.getY());
           usuarioActual.getMatriz().buscarMatriz(aux.getX(), aux.getY()).getArbol().insertar(new Archivo(fields[0],fields[1]));
                    }else{
                        NodoMatrizAd aux =usuarioActual.getMatriz().buscarMatriz(nodoEnComunMatriz.getX(), nodoEnComunMatriz.getY());
               usuarioActual.getMatriz().buscarMatriz(aux.getX(), aux.getY()).getArbol().insertar(new Archivo(fields[0],fields[1]));
                    }
                
            }
            contador=contador+1;
     
         }

        } catch (IOException e) {

        }

    }
    
    
    public void Archivos(){
                    NodoMatrizAd aux;
                if(this.nodoEnComunMatriz==null){
            aux = this.father;
                }else{
                    aux = this.nodoEnComunMatriz;
                }
                DefaultListModel dlm = new DefaultListModel();
                aux.getArbol().inorden2();
                for(Archivo a: aux.getArbol().getArchivosList() ){
             
             dlm.addElement(new entrarLista(a.getNombre(), new ImageIcon("archivo2.png")));
             
                    }
            jList3.setModel(dlm);
                jList3.setCellRenderer(new imagenEnLista());
                        jList3.updateUI();
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VentanaUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaUsuario().setVisible(true);
            }
        });
    }

    
  
class entrarLista
{
   private String value;
   private ImageIcon icon;
  
   public entrarLista(String value, ImageIcon icon) {
      this.value = value;
      this.icon = icon;
   }
  
   public String getValue() {
      return value;
   }
  
   public ImageIcon getIcon() {
      return icon;
   }
  
   public String toString() {
      return value;
   }
    }
  
class imagenEnLista
 extends JLabel implements ListCellRenderer
{
   private JLabel label;
  
   public Component getListCellRendererComponent(JList list, Object value,  int index, boolean isSelected,  boolean cellHasFocus) {
                entrarLista entry = (entrarLista) value;
  
      setText(value.toString());
                setIcon(entry.getIcon());
   
            if (isSelected) {
         setBackground(list.getSelectionBackground());
         setForeground(list.getSelectionForeground());
                    }
                else {
         setBackground(list.getBackground());
         setForeground(list.getForeground());
                }
  
                setEnabled(list.isEnabled());
            setFont(list.getFont());
                            setOpaque(true);
  
                        return this;
   }
    }

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton abrirC;
    private javax.swing.JButton btCrearC;
    private javax.swing.JButton btEliminarA;
    private javax.swing.JButton btEliminarC;
    private javax.swing.JButton btModificarA;
    private javax.swing.JButton btModificarC;
    private javax.swing.JButton crearArchivos;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    public javax.swing.JList<String> jList1;
    private javax.swing.JList<String> jList3;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel labelNombreUsuario;
    private javax.swing.JLabel labelRuta;
    private javax.swing.JButton regresar;
    // End of variables declaration//GEN-END:variables
}
