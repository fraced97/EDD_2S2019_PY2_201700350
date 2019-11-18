/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructuras;

import java.io.File;
import java.io.PrintWriter;

import Vistas.VentanaReporte;
import Vistas.VentanaReporte3;
import java.util.ArrayList;
import javax.swing.JOptionPane;
/**
 *
 * @author USUARIO
 */
public class ArbolAVL2 {

    // --------------------------------------------------------------------------------------------------------------------------------------------
    class Nodo {

       /* public String getNombreArchivo() {
            return nombreArchivo;
        }

        public void setNombreArchivo(String nombreArchivo) {
            this.nombreArchivo = nombreArchivo;
        }*/

        public int getFactorDeEquilibrio() {
            return factorDeEquilibrio;
        }

        public void setFactorDeEquilibrio(int factorDeEquilibrio) {
            this.factorDeEquilibrio = factorDeEquilibrio;
        }

        public Nodo getHojaIzquierda() {
            return hojaIzquierda;
        }

        public void setHojaIzquierda(Nodo hojaIzquierda) {
            this.hojaIzquierda = hojaIzquierda;
        }

        public Nodo getHojaDerecha() {
            return hojaDerecha;
        }

        public void setHojaDerecha(Nodo hojaDerecha) {
            this.hojaDerecha = hojaDerecha;
        }

        public Archivo getArchivo() {
            return archivo;
        }

        public void setArchivo(Archivo archivo) {
            this.archivo = archivo;
        }
        
        //String nombreArchivo;
        int factorDeEquilibrio;
        Nodo hojaIzquierda, hojaDerecha;
        Archivo archivo;

        public Nodo(Archivo u) {
            //this.nombreArchivo = u;
            this.archivo=u;
            this.factorDeEquilibrio = 0;
            this.hojaDerecha = null;
            this.hojaIzquierda = null;

        }
    }
    // --------------------------------------------------------------------------------------------------------------------------------------------

    public Nodo getRaiz() {
        return raiz;
    }

    public void setRaiz(Nodo raiz) {
        this.raiz = raiz;
    }

    

    private Nodo raiz;

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    String ruta;
    String nombre;

    public String getRuta3() {
        return ruta3;
    }

    public void setRuta3(String ruta3) {
        this.ruta3 = ruta3;
    }
    String ruta3;
    ArrayList<Archivo> archivosList;
    //String nombreArchivo;

    public ArrayList<Archivo> getArchivosList() {
        return archivosList;
    }

    public void setArchivosList(ArrayList<Archivo> archivosList) {
        this.archivosList = archivosList;
    }

    public ArbolAVL2(String nombreCarpeta, String nombreOriginal) {
        raiz = null;
        this.ruta=nombreCarpeta;
        this.nombre = nombreOriginal;
        //mostrar = new ArrayList<Usuario>();
        
    }
    Nodo derechaSimple(Nodo x) {
             Nodo aux = x.hojaDerecha;
                 x.hojaDerecha = aux.hojaIzquierda;
            aux.hojaIzquierda = x;
                 x.factorDeEquilibrio = Math.max(getFe(x.hojaIzquierda), getFe(x.hojaDerecha)) + 1;
                            aux.factorDeEquilibrio = Math.max(getFe(aux.hojaIzquierda), getFe(aux.hojaDerecha)) + 1;
            return aux;
    }
    public void eliminarHojaArbol(Archivo archivo){
                            this.inorden2();
                    for(Archivo a : this.getArchivosList()){
                    if(a.getNombre().equals(archivo.getNombre())){
                this.getArchivosList().remove(a);
                break;
            }
                    }
                    this.raiz = null;
                    for(Archivo a: this.getArchivosList()){
                     this.insertarOriginal(a);
                        }
        
    }

    Nodo buscar(Nodo r, String d) {
        if (r == null) {
            return null;
        } else if (r.archivo.getNombre().compareToIgnoreCase(d) == 0) {
            return r;
        } else if (r.archivo.getNombre().compareToIgnoreCase(d) < 0) {
            return buscar(r.hojaDerecha, d);
        } else {
            return buscar(r.hojaIzquierda, d);
        }

    }

    public Nodo ObtenerRaiz() {
        return raiz;
    }

    
    int getFe(Nodo x) {
        if (x == null) {
            return -1;
        }

        return x.factorDeEquilibrio;
    }
    
    
    
    Nodo izquierdaSimple(Nodo x) {
                Nodo aux = x.hojaIzquierda;
         x.hojaIzquierda = aux.hojaDerecha;
                aux.hojaDerecha = x;
                        x.factorDeEquilibrio = Math.max(getFe(x.hojaIzquierda), getFe(x.hojaDerecha)) + 1;
            aux.factorDeEquilibrio = Math.max(getFe(aux.hojaIzquierda), getFe(aux.hojaDerecha)) + 1;
                        return aux;
    }

    
    

    
    

    
    Nodo DerechaDoble(Nodo x) {
              Nodo temp;
              x.hojaDerecha = izquierdaSimple(x.hojaDerecha);
        temp = derechaSimple(x);
                 return temp;
    }

                Nodo insertarHojaEnAvl(Nodo nuevo, Nodo aux) {
           Nodo nuevoPadre = aux;
                       if (nuevo.archivo.getNombre().compareToIgnoreCase(aux.archivo.getNombre()) < 0) {
                   if (aux.hojaIzquierda == null) {
                aux.hojaIzquierda = nuevo;
            } else {
                      aux.hojaIzquierda = insertarHojaEnAvl(nuevo, aux.hojaIzquierda);
                if ((getFe(aux.hojaIzquierda) - getFe(aux.hojaDerecha)) == 2) {
                    if (nuevo.archivo.getNombre().compareToIgnoreCase(aux.hojaIzquierda.archivo.getNombre()) < 0) {
                        nuevoPadre = izquierdaSimple(aux);
                    } else {
                        nuevoPadre = izquierdaDoble(aux);
                    }

                }
            }
        } else if (nuevo.archivo.getNombre().compareToIgnoreCase(aux.archivo.getNombre()) > 0) {
            if (aux.hojaDerecha == null) {
                aux.hojaDerecha = nuevo;
            } else {
                aux.hojaDerecha = insertarHojaEnAvl(nuevo, aux.hojaDerecha);
                if ((getFe(aux.hojaDerecha) - getFe(aux.hojaIzquierda)) == 2) {
                    if (nuevo.archivo.getNombre().compareToIgnoreCase(aux.hojaDerecha.archivo.getNombre()) > 0) {
                        nuevoPadre = derechaSimple(aux);
                    } else {
                        nuevoPadre = DerechaDoble(aux);
                    }
                }
            }
        } else {
            System.out.println("Nodo yA EXISTE");
        }

        // actualizando la altura
        if ((aux.hojaIzquierda == null) && (aux.hojaDerecha != null)) {
            aux.factorDeEquilibrio = aux.hojaDerecha.factorDeEquilibrio + 1;
        } else if ((aux.hojaDerecha == null) && (aux.hojaIzquierda != null)) {
            aux.factorDeEquilibrio = aux.hojaIzquierda.factorDeEquilibrio + 1;
        } else {
            aux.factorDeEquilibrio = Math.max(getFe(aux.hojaIzquierda), getFe(aux.hojaDerecha)) + 1;
        }

        return nuevoPadre;

    }
    

    public ArbolAVL2 insertarOriginal(Archivo dato) {
        
        Nodo nuevo = new Nodo(dato);
            this.inorden2();
        
        
        
                    for(Archivo a: this.getArchivosList()){
            if(a.getNombre().equals(dato.getNombre())){
        int reply = JOptionPane.showConfirmDialog(null, "Nombre de Archivo ya existente, desea continuar?", "Este Nombre Ya Existe", JOptionPane.YES_NO_OPTION);
        if (reply == JOptionPane.YES_OPTION) {
                    this.eliminarHojaArbol(dato);
                    this.insertarOriginal(dato);
                }
                    }
            }
        
        
        //Nodo nuevo = new Nodo(dato);
        if (raiz == null) {
            raiz = nuevo;
        } else {
            raiz = insertarHojaEnAvl(nuevo, raiz);
        }
                    return this;
    }

    public void preorden(Nodo aux) {
        //System.out.println("PreOrden");
        if (aux != null) {
            System.out.println(aux.archivo.getNombre());
            preorden(aux.hojaIzquierda);
            preorden(aux.hojaDerecha);

        }
    }

    public void postOrden(Nodo aux) {
        //System.out.println("POSTORDEN");
        if (aux != null) {
            postOrden(aux.hojaIzquierda);
            postOrden(aux.hojaDerecha);
            System.out.println(aux.archivo.getNombre());
        }
    }

    public void inorden(Nodo aux) {
        //System.out.println("Inorden");
        if (aux != null) {
            inorden(aux.hojaIzquierda);
            System.out.println(aux.archivo.getNombre());
            inorden(aux.hojaDerecha);

        }
    }
    public void inorden2(){
                this.setArchivosList(new ArrayList<>());
            innorden4(this.raiz);
        
    }
    Nodo izquierdaDoble(Nodo x) {
        Nodo temp;
        x.hojaIzquierda = derechaSimple(x.hojaIzquierda);
        temp = izquierdaSimple(x);
        return temp;
    }
    
    public void innorden4(Nodo aux){
        if(aux!=null){
            innorden4(aux.getHojaIzquierda());
            this.getArchivosList().add(aux.getArchivo());
            innorden4(aux.getHojaDerecha());
            
        }
    }
    public void PostOrder2(){
        this.setArchivosList(new ArrayList<>());
        PostOrder4(this.raiz);
    }
    public void PostOrder4(Nodo aux){
        if(aux!=null){
            innorden4(aux.getHojaIzquierda());
            
            innorden4(aux.getHojaDerecha());
            this.getArchivosList().add(aux.getArchivo());
            
        }
    }

    public void graficarArbol2(Nodo raiz7,PrintWriter escribir){
        if (raiz7 !=null) {
             escribir.println("\"" + raiz7.archivo.getNombre()+"\n"+(raiz7.archivo.getAdentro())+"\n"+(raiz7.factorDeEquilibrio)+"\n"+(raiz7.archivo.fechaHora)+"\n"+(raiz7.archivo.usuarioCreador.getNickname())  +"\";");
        if (raiz7.hojaIzquierda != null) {
             escribir.println("\"" + (raiz7.archivo.getNombre())+"\n"+(raiz7.archivo.getAdentro())+"\n"+(raiz7.factorDeEquilibrio)+"\n"+(raiz7.archivo.fechaHora)+"\n"+(raiz7.archivo.usuarioCreador.getNickname()) + "\"->\"" + (raiz7.hojaIzquierda.archivo.getNombre())+"\n"+(raiz7.hojaIzquierda.archivo.getAdentro())+"\n"+(raiz7.hojaIzquierda.factorDeEquilibrio)+"\n"+(raiz7.hojaIzquierda.archivo.fechaHora)+"\n"+(raiz7.hojaIzquierda.archivo.usuarioCreador.getNickname())  +  "\";");
        }
        
               
        if (raiz7.hojaDerecha!=null) {
             escribir.println("\"" + (raiz7.archivo.getNombre())+"\n"+(raiz7.archivo.getAdentro())+"\n"+(raiz7.factorDeEquilibrio)+"\n"+(raiz7.archivo.fechaHora)+"\n"+(raiz7.archivo.usuarioCreador.getNickname()) +"\"->\"" + (raiz7.hojaDerecha.archivo.getNombre())+"\n"+(raiz7.hojaDerecha.archivo.getAdentro())+"\n"+(raiz7.hojaDerecha.factorDeEquilibrio)+"\n"+(raiz7.hojaDerecha.archivo.fechaHora)+"\n"+(raiz7.hojaDerecha.archivo.usuarioCreador.getNickname()) +  "\";");
        }
 
        graficarArbol2(raiz7.hojaIzquierda, escribir);
        graficarArbol2(raiz7.hojaDerecha, escribir);
        }
        


       

    }

    public void graficarArbol() {
        String ruta= "C:\\Users\\USUARIO\\Desktop\\GraficaPruebaProyecto\\ArbolAVL.";
        File punto = new File(".");
        String nombreArchivo="";
        PrintWriter escribir=null;
        
        try{
            
            escribir = new PrintWriter(punto.getAbsolutePath()+"//"+"ArbolAvl.dot","UTF-8");
            //escribir.println("Arbol.dot", "w")
            escribir.println("digraph G {\n");
            //#f.write("rankdir = LR \n node [shape = square];\n")
            graficarArbol2(this.raiz, escribir);
            escribir.println("}");

            escribir.close();
                    
            int numero=0;
            numero = (int) (Math.random() * 1000000000) + 1;
            ProcessBuilder abrir;
            String rutaImagen=punto.getAbsolutePath()+"//"+"ArbolAvlImagen"+String.valueOf(numero)+".jpg";
            String rutaDot= punto.getAbsolutePath()+"//"+"ArbolAvl.dot";
            abrir = new ProcessBuilder("dot", "-Tjpg", "-o",rutaImagen,rutaDot);
            
            //abrir = new ProcessBuilder("dot -Tjpg Arbol.dot -o imagenArbol.jpg");
            //system("dot -Tjpg Arbol.dot -o imagenArbol.jpg")
            //os.system("imagenArbol.jpg")
            abrir.redirectErrorStream(true);
            abrir.start();
            ///////////////////////////// Creo una ventana nueva con la imagen 
            //ScrollPaneReport temporal3= new ScrollPaneReport(rutaImagen);
            VentanaReporte3 temporal4 = new VentanaReporte3(rutaImagen);
            //temporal4.abrirVentana(rutaImagen);
            
            ////////////////////////////////////////////////////////////
            
        }catch(Exception e){
            System.out.println("NO HAY NADA");
        }

    }
}