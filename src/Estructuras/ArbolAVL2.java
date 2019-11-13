/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructuras;

import java.io.File;
import java.io.PrintWriter;
import Vistas.ScrollPaneReport;
import Vistas.VentanaReporte;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /*public String getNombreArchivo() {
        return nombreArchivo;
    }*/

    //private ArrayList<Usuario> mostrar;
    /*public void setNombreArchivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }*/
    private Nodo raiz;
    String name;
    //String nombreArchivo;

    public ArbolAVL2(String nombreCarpeta) {
        raiz = null;
        this.name=nombreCarpeta;
        //mostrar = new ArrayList<Usuario>();
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

    // Devuelve el factor de equilibrio de un Nodo
    int getFe(Nodo x) {
        if (x == null) {
            return -1;
        }

        return x.factorDeEquilibrio;
    }

    // Rotaci�n simple a la izquierda
    Nodo SimpleLeft(Nodo x) {
        Nodo aux = x.hojaIzquierda;
        x.hojaIzquierda = aux.hojaDerecha;
        aux.hojaDerecha = x;
        x.factorDeEquilibrio = Math.max(getFe(x.hojaIzquierda), getFe(x.hojaDerecha)) + 1;
        aux.factorDeEquilibrio = Math.max(getFe(aux.hojaIzquierda), getFe(aux.hojaDerecha)) + 1;
        return aux;
    }

    // Rotaci�n simple a la derecha
    Nodo SimpleRight(Nodo x) {
        Nodo aux = x.hojaDerecha;
        x.hojaDerecha = aux.hojaIzquierda;
        aux.hojaIzquierda = x;
        x.factorDeEquilibrio = Math.max(getFe(x.hojaIzquierda), getFe(x.hojaDerecha)) + 1;
        aux.factorDeEquilibrio = Math.max(getFe(aux.hojaIzquierda), getFe(aux.hojaDerecha)) + 1;
        return aux;
    }

    // Rotaci�n doble a la derecha
    Nodo DoubleLeft(Nodo x) {
        Nodo temp;
        x.hojaIzquierda = SimpleRight(x.hojaIzquierda);
        temp = SimpleLeft(x);
        return temp;
    }

    // Rotaci�n doble a la izquierda
    Nodo DoubleRight(Nodo x) {
        Nodo temp;
        x.hojaDerecha = SimpleLeft(x.hojaDerecha);
        temp = SimpleRight(x);
        return temp;
    }

    Nodo insertarAvl(Nodo nuevo, Nodo aux) {
        Nodo nuevoPadre = aux;
        if (nuevo.archivo.getNombre().compareToIgnoreCase(aux.archivo.getNombre()) < 0) {
            if (aux.hojaIzquierda == null) {
                aux.hojaIzquierda = nuevo;
            } else {
                aux.hojaIzquierda = insertarAvl(nuevo, aux.hojaIzquierda);
                if ((getFe(aux.hojaIzquierda) - getFe(aux.hojaDerecha)) == 2) {
                    if (nuevo.archivo.getNombre().compareToIgnoreCase(aux.hojaIzquierda.archivo.getNombre()) < 0) {
                        nuevoPadre = SimpleLeft(aux);
                    } else {
                        nuevoPadre = DoubleLeft(aux);
                    }

                }
            }
        } else if (nuevo.archivo.getNombre().compareToIgnoreCase(aux.archivo.getNombre()) > 0) {
            if (aux.hojaDerecha == null) {
                aux.hojaDerecha = nuevo;
            } else {
                aux.hojaDerecha = insertarAvl(nuevo, aux.hojaDerecha);
                if ((getFe(aux.hojaDerecha) - getFe(aux.hojaIzquierda)) == 2) {
                    if (nuevo.archivo.getNombre().compareToIgnoreCase(aux.hojaDerecha.archivo.getNombre()) > 0) {
                        nuevoPadre = SimpleRight(aux);
                    } else {
                        nuevoPadre = DoubleRight(aux);
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

    public void insertar(Archivo dato) {
        Nodo nuevo = new Nodo(dato);
        if (raiz == null) {
            raiz = nuevo;
        } else {
            raiz = insertarAvl(nuevo, raiz);
        }
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

    public void graficarArbol2(Nodo raiz7,PrintWriter escribir){
        if (raiz7 !=null) {
             escribir.println("\"" + raiz7.archivo.getNombre() +"\";");
        if (raiz7.hojaIzquierda != null) {
             escribir.println("\"" + (raiz7.archivo.getNombre()) + "\"->\"" + (raiz7.hojaIzquierda.archivo.getNombre()) +  "\";");
        }
        
               
        if (raiz7.hojaDerecha!=null) {
             escribir.println("\"" + (raiz7.archivo.getNombre()) +"\"->\"" + (raiz7.hojaDerecha.archivo.getNombre()) +  "\";");
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
                    

            ProcessBuilder abrir;
            String rutaImagen=punto.getAbsolutePath()+"//"+"ArbolAvlImagen.jpg";
            String rutaDot= punto.getAbsolutePath()+"//"+"ArbolAvl.dot";
            abrir = new ProcessBuilder("dot", "-Tjpg", "-o",rutaImagen,rutaDot);
            
            //abrir = new ProcessBuilder("dot -Tjpg Arbol.dot -o imagenArbol.jpg");
            //system("dot -Tjpg Arbol.dot -o imagenArbol.jpg")
            //os.system("imagenArbol.jpg")
            abrir.redirectErrorStream(true);
            abrir.start();
            ///////////////////////////// Creo una ventana nueva con la imagen 
            //ScrollPaneReport temporal3= new ScrollPaneReport(rutaImagen);
            VentanaReporte temporal4 = new VentanaReporte(rutaImagen);
            temporal4.abrirVentana(rutaImagen);
            
            ////////////////////////////////////////////////////////////
            
        }catch(Exception e){
            System.out.println("NO HAY NADA");
        }

    }
}