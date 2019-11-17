/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructuras;

import Vistas.ScrollPaneReport;
import Vistas.VentanaReporte;
import Vistas.VentanaReporte2;
import Vistas.VentanaReporte3;
import java.io.File;
import java.io.PrintWriter;

/**
 *
 * @author USUARIO
 */
public class MatrizAd {
    // --------------------------------------------------------------------------------------------------------------------------------------------

    public class NodoMatrizAd {

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }

        public NodoMatrizAd getArriba() {
            return arriba;
        }

        public void setArriba(NodoMatrizAd arriba) {
            this.arriba = arriba;
        }

        public NodoMatrizAd getAbajo() {
            return abajo;
        }

        public void setAbajo(NodoMatrizAd abajo) {
            this.abajo = abajo;
        }

        public NodoMatrizAd getSiguiente() {
            return siguiente;
        }

        public void setSiguiente(NodoMatrizAd siguiente) {
            this.siguiente = siguiente;
        }

        public NodoMatrizAd getAnterior() {
            return anterior;
        }

        public void setAnterior(NodoMatrizAd anterior) {
            this.anterior = anterior;
        }

        public String getFechaHora() {
            return fechaHora;
        }

        public void setFechaHora(String fechaHora) {
            this.fechaHora = fechaHora;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public ArbolAVL2 getArbol() {
            return arbol;
        }

        public void setArbol(ArbolAVL2 arbol) {
            this.arbol = arbol;
        }

        //String nombreArchivo;
        int x, y;
        private NodoMatrizAd arriba, abajo, siguiente, anterior;
        private String fechaHora, nombre,ruta;
        private ArbolAVL2 arbol;

        public NodoMatrizAd(int x, int y, ArbolAVL2 arbol) {
            this.x = x;
            this.arbol = arbol;
            this.y = y;
            this.nombre= nombre;
            this.ruta=ruta;
            this.arriba = null;
            this.abajo = null;
            this.siguiente = null;
            this.anterior = null;
            //this.arriba = null;
            //this.abajo = null;
        }

        public NodoMatrizAd() {

        }

    }
    // --------------------------------------------------------------------------------------------------------------------------------------------
    private NodoMatrizAd raiz;

    //private ArbolAVL2 arbol;
    public MatrizAd() {
        //this.raiz= new NodoMatrizAd(-1,-1,new ArbolAVL2());
        this.raiz = new NodoMatrizAd(-1, -1, new ArbolAVL2("Root","Nombre"));
        //this->raiz->frente=primeraMatriz;
        //this->primeraMatriz->fondo=raiz;
        //this->primeraMatriz=NULL;
        //this->ultimaMatriz=NULL;
        //this->primeraMatriz=raiz;
        //this->ultimaMatriz=raiz;
        //this->tamanioCubo=0;
    }

    public NodoMatrizAd buscarFila(int y) {
        NodoMatrizAd temp;
        temp = this.raiz;
        while (temp != null) {
            if (temp.getY() == y) {
                return temp;
            }
            temp = temp.getAbajo();

        }
        return null;
    }

    public NodoMatrizAd buscarColumna(int x) {
        NodoMatrizAd temp;
        temp = this.raiz;
        while (temp != null) {
            if (temp.getX() == x) {
                return temp;
            }
            temp = temp.getSiguiente();

        }
        return null;
    }

    public NodoMatrizAd insertarColumna(NodoMatrizAd nuevo, NodoMatrizAd cabezaCol) {
        NodoMatrizAd aux;
        aux = cabezaCol;
        boolean condicion = false;
        while (true) {
            if (aux.getX() == nuevo.getX()) {
                aux.setY(nuevo.getY());

                aux.setArbol(nuevo.getArbol());
                return aux;
            } else if (aux.getY() > nuevo.getY()) {
                condicion = true;
                break;
            }
            if (aux.getSiguiente() != null) {
                aux = aux.getSiguiente();

            } else {
                break;
            }
        }
        if (condicion) {
            nuevo.setSiguiente(aux);
            aux.getAnterior().setSiguiente(nuevo);
            //aux->anterior->siguiente=nuevo;
            nuevo.setAnterior(aux.getAnterior());
            //nuevo->anterior=aux->anterior;
            aux.setAnterior(nuevo);
            //aux->anterior=nuevo;
        } else {
            aux.setSiguiente(nuevo);
            //aux->siguiente=nuevo;
            nuevo.setAnterior(aux);
            //nuevo->anterior=aux;

        }
        return nuevo;

    }

    public NodoMatrizAd insertarFila(NodoMatrizAd nuevo, NodoMatrizAd cabezaFila) {
        NodoMatrizAd aux;
        aux = cabezaFila;
        boolean condicion = false;
        while (true) {
            if (aux.getY() == nuevo.getY()) {
                //SI LA POSICION ES LA MISMA LA SOBRE ESCRIBO
                aux.setX(nuevo.getX());
                aux.setArbol(nuevo.getArbol());
                return aux; //RETORNAMOS EL PUNTERO
            } else if (aux.getY() > nuevo.getY()) {
                //SE INSERTA ANTES DEL TEMP
                condicion = true;
                break;
            }
            if (aux.getAbajo() != null) {
                aux = aux.getAbajo();

            } else {
                break;
            }
        }
        if (condicion) {
            //INSERTARLO ANTES DE TEMPORAL
            nuevo.setAbajo(aux);
            aux.getArriba().setAbajo(nuevo);
            //aux->arriba->abajo=nuevo;
            nuevo.setArriba(aux.getArriba());
            //nuevo->arriba=aux->arriba;
            aux.setArriba(nuevo);
            //aux->arriba=nuevo;
        } else {
            //INSERCION AL FINAL
            aux.setAbajo(nuevo);
            nuevo.setArriba(aux);

        }
        return nuevo;
    }

    public NodoMatrizAd crearColumna(int x) {
        NodoMatrizAd cabezaColumna;
        cabezaColumna = this.raiz;
        /////////////////////////
        //NodoMatrizAd aux;
        //aux= new NodoMatrizAd(x,-1,"Col",0,"","","","");
        ///////////////////////
        NodoMatrizAd columna;
        columna = insertarColumna(new NodoMatrizAd(x, -1, new ArbolAVL2("Root","Nombre")), cabezaColumna);
        return columna;
    }

    public NodoMatrizAd crearFila(int y) {
        NodoMatrizAd cabezaFila;
        cabezaFila = this.raiz;
        /////////////////////////
        //NodoMatriz3D *aux;
        //aux= new NodoMatriz3D(-1,y,"Fila",0,"","","","");
        ///////////////////////
        NodoMatrizAd fila;
        fila = insertarFila(new NodoMatrizAd(-1, y, new ArbolAVL2("Root","Nombre")), cabezaFila);
        return fila;
    }

    public void insertarElemento(int x, int y, ArbolAVL2 dato) {
        NodoMatrizAd nuevo;
        nuevo = new NodoMatrizAd(x, y, dato);
        NodoMatrizAd nodoColumna;
        nodoColumna = buscarColumna(x);
        NodoMatrizAd nodoFila;
        nodoFila = buscarFila(y);
        //1 caso: Columna no exista y fila no exista
        if (nodoColumna == null && nodoFila == null) {
            //std::cout << "caso 1"<< std::endl;
            nodoColumna = crearColumna(x);
            nodoFila = crearFila(y);
            nuevo = insertarColumna(nuevo, nodoFila);
            nuevo = insertarFila(nuevo, nodoColumna);
            //System.out.println("ENTRO EN EL PRIMER IF");
            //return;
            //2 caso: Columna no exista y fila exista
        } else if (nodoColumna == null && nodoFila != null) {
            //std::cout << "caso 2"<< std::endl;
            nodoColumna = crearColumna(x);
            nuevo = insertarColumna(nuevo, nodoFila);
            nuevo = insertarFila(nuevo, nodoColumna);
            //System.out.println("ENTRO EN EL SEGUNDO IF");
            //return;
            //3 caso: Columna exista y fila no exista
        } else if (nodoColumna != null && nodoFila == null) {
            //std::cout << "caso 3"<< std::endl;
            nodoFila = crearFila(y);
            nuevo = insertarColumna(nuevo, nodoFila);
            nuevo = insertarFila(nuevo, nodoColumna);
            //System.out.println("Entro en el tercer if");
            //return;
            //4 caso: Columna exista y fila exista
        } else if (nodoColumna != null && nodoFila != null) {
            //std::cout << "caso 4"<< std::endl;
            nuevo = insertarColumna(nuevo, nodoFila);
            nuevo = insertarFila(nuevo, nodoColumna);
            //System.out.println("entro en el cuarto if");
            //return;
        }

    }

    public void recorrerMatriz() {
     
        NodoMatrizAd aux_columna;
        NodoMatrizAd aux_Fila;
        //NodoMatrizAd auxRaiz;
        aux_columna = this.raiz;
        //auxRaiz=aux->frente;
        boolean condicion = true;
        while (condicion) {
            while (aux_columna != null) {
        
                aux_Fila = aux_columna;
                //aux1=aux;
                while (aux_Fila != null) {
             
                    //System.out.println(aux_Fila.getArbol().getRuta() + " " + String.valueOf(aux_Fila.getX()) + " " + String.valueOf(aux_Fila.getY()));
                    aux_Fila = aux_Fila.getSiguiente();
                }
 
                if (aux_columna.getAbajo() != null) {
                    aux_columna = aux_columna.getAbajo();
                } else {
                    break;
                }

                
            }
           
            if (aux_columna.getAbajo() == null) {
                System.out.println("   ENTRO EN LA COLUMNA NULA");
                //aux= aux->frente;
                //auxRaiz=auxRaiz->frente;
                condicion = false;
                break;
            }
        }
  
 
    }

    public void graficarMatriz2(PrintWriter escribir) {
        NodoMatrizAd aux_columna;
        NodoMatrizAd aux_Fila;
        //NodoMatrizAd auxRaiz;
        aux_columna = this.raiz;
        //auxRaiz=aux->frente;
        boolean condicion = true;
        while (condicion) {
            while (aux_columna != null) {
                /* if (aux_columna.getAbajo() != null) {
                    aux_columna = aux_columna.getAbajo();
                } else {
                    break;
                }
                if (aux_columna.getSiguiente() != null) {
                    aux_Fila = aux_columna.getSiguiente();
                } else {
                    break;
                }*/
                //aux1=aux;
                aux_columna=aux_columna.getAbajo(); ///IMPORTANTE
                aux_columna=aux_columna.getSiguiente(); ///importante para que no se miren la cabeceras
                aux_Fila = aux_columna;
                
                while (aux_Fila != null) {
                    //cout << aux1->dato<<" ";
                    //if (aux_Fila.getArbol().equals("Raiz")) {
                    if (aux_Fila.getAbajo() != null) {
                        //escribir.println("\"" + (aux_Fila.getArbol().getNombre()) + " (" + aux_Fila.getX() + ", " + aux_Fila.getY() + ") " + "\"->\"" + (aux_Fila.getAbajo().getArbol().getNombre()) + " (" + aux_Fila.getAbajo().getX() + ", " + aux_Fila.getAbajo().getY() + ") " + "\"" + "[dir=both];");
                        escribir.println("\"" + (aux_Fila.getArbol().getRuta()) + " (" + aux_Fila.getX() + ", " + aux_Fila.getY() + ") " + "\"->\"" + (aux_Fila.getAbajo().getArbol().getRuta()) + " (" + aux_Fila.getAbajo().getX() + ", " + aux_Fila.getAbajo().getY() + ") " + "\"" + "[dir=both];");
                    }
                    //escribir.println("\"" + aux_Fila.getArbol() + ", (" + aux_Fila.getX() + "," + aux_Fila.getY() + ")" + "\"->");
                    if (aux_Fila.getAbajo() != null) {
                        NodoMatrizAd temp;
                        NodoMatrizAd temp2;
                        NodoMatrizAd temp3 = aux_Fila;
                        temp2 = aux_Fila.getAbajo();
                        temp = temp2;
                        //escribir.print("\"" + (temp.getArbol())+" ("+temp.getX()+", "+temp.getY()+") "  + "\"->\"" + (temp.getAbajo().getArbol())+" ("+temp.getAbajo().getX()+", "+temp.getAbajo().getY()+") "  + "\"" + "[dir=both];");
                        //if(temp2.getAbajo().getAbajo()!=null){
                        //  temp=temp2.getAbajo().getAbajo();
                        //}
                        while (true) {
                            while (temp != null) {
                                if (temp.getAbajo() != null) {
                                    //escribir.println("\"" + (temp.getArbol().getNombre()) + " (" + temp.getX() + ", " + temp.getY() + ") " + "\"->\"" + (temp.getAbajo().getArbol().getNombre()) + " (" + temp.getAbajo().getX() + ", " + temp.getAbajo().getY() + ") " + "\"" + "[dir=both];");
                                    escribir.println("\"" + (temp.getArbol().getRuta()) + " (" + temp.getX() + ", " + temp.getY() + ") " + "\"->\"" + (temp.getAbajo().getArbol().getRuta()) + " (" + temp.getAbajo().getX() + ", " + temp.getAbajo().getY() + ") " + "\"" + "[dir=both];");
                                }
                                temp = temp.getAbajo();
                            }
                            if (temp3.getSiguiente() != null) {
                                temp = temp3.getSiguiente();
                                temp3 = temp3.getSiguiente();
                                //temp2=temp2.getSiguiente();
                            } else {
                                break;
                            }

                        }

                    }
                    if (aux_Fila.getSiguiente() != null) {
                        escribir.println("rank=same{");
                        if (aux_Fila.getSiguiente() != null) {
                            //escribir.println("\"" + (aux_Fila.getArbol().getNombre()) + " (" + aux_Fila.getX() + ", " + aux_Fila.getY() + ") " + "\"->\"" + (aux_Fila.getSiguiente().getArbol().getNombre()) + " (" + aux_Fila.getSiguiente().getX() + ", " + aux_Fila.getSiguiente().getY() + ") " + "\"" + "[dir=both];");
                            escribir.println("\"" + (aux_Fila.getArbol().getRuta()) + " (" + aux_Fila.getX() + ", " + aux_Fila.getY() + ") " + "\"->\"" + (aux_Fila.getSiguiente().getArbol().getRuta()) + " (" + aux_Fila.getSiguiente().getX() + ", " + aux_Fila.getSiguiente().getY() + ") " + "\"" + "[dir=both];");
                            
                        }
                        //escribir.println("\"" + aux_Fila.getArbol() + ", (" + aux_Fila.getX() + "," + aux_Fila.getY() + ")" + "\"->");
                        escribir.println("}");
                        NodoMatrizAd temp;
                        NodoMatrizAd temp2;
                        NodoMatrizAd temp3;
                        temp3 = aux_Fila;
                        temp2 = aux_Fila.getSiguiente();
                        temp = temp2;
                        while (true) {
                            while (temp != null) {
                                if (temp.getSiguiente() != null) {
                                    escribir.println("rank=same{");
                                    //escribir.println("\"" + (temp.getArbol().getNombre()) + " (" + temp.getX() + ", " + temp.getY() + ") " + "\"->\"" + (temp.getSiguiente().getArbol().getNombre()) + " (" + temp.getSiguiente().getX() + ", " + temp.getSiguiente().getY() + ") " + "\"" + "[dir=both];");
                                    escribir.println("\"" + (temp.getArbol().getRuta()) + " (" + temp.getX() + ", " + temp.getY() + ") " + "\"->\"" + (temp.getSiguiente().getArbol().getRuta()) + " (" + temp.getSiguiente().getX() + ", " + temp.getSiguiente().getY() + ") " + "\"" + "[dir=both];");
                                    escribir.println("}");
                                }
                                temp = temp.getSiguiente();
                            }
                            if (temp3.getAbajo() != null) {
                                temp = temp3.getAbajo();
                                temp3 = temp3.getAbajo();
                            } else {
                                break;
                            }

                        }
                    }


                    /*if (aux_Fila.getAbajo() != null) {
                        //System.out.println("\"" + (aux_Fila.getArbol()) + "\"->\"" + (aux_Fila.getAbajo().getArbol()) + "\"" + "[dir=both];");
                        escribir.println("\"" + (aux_Fila.getArbol())+" ("+aux_Fila.getX()+", "+aux_Fila.getY()+") "  + "\"->\"" + (aux_Fila.getAbajo().getArbol())+" ("+aux_Fila.getAbajo().getX()+", "+aux_Fila.getAbajo().getY()+") "  + "\"" + "[dir=both];");
                    }
                    if (aux_Fila.getSiguiente() != null) {
                        //System.out.println("\"" + (aux_Fila.getArbol())+"("+aux_Fila.getX()+", "+aux_Fila.getY()+")" + "\"->\"" + (aux_Fila.getSiguiente().getArbol())+"("+aux_Fila.getSiguiente().getX()+", "+aux_Fila.getSiguiente().getY()+")" + "\"" + "[dir=both];");
                        escribir.println("\"" + (aux_Fila.getArbol())+" ("+aux_Fila.getX()+", "+aux_Fila.getY()+") " + "\"->\"" + (aux_Fila.getSiguiente().getArbol())+" ("+aux_Fila.getSiguiente().getX()+", "+aux_Fila.getSiguiente().getY()+") " + "\"" + "[dir=both];");
                    }*/
                    //aux_Fila = aux_Fila.getSiguiente();
                    break;
                }
                /*if (aux_columna.getAbajo() != null) {
                    aux_columna = aux_columna.getAbajo();
                } else {
                    break;
                }*/
                // aux = aux->abajo;
                //cout<<""<<endl;
                break;
            }
            //aux=auxRaiz;
            /*if (aux_columna.getAbajo() == null) {
                //aux= aux->frente;
                //auxRaiz=auxRaiz->frente;
                condicion = false;
                break;
            }*///else
            //{
            //  condicion= false;
            //break;
            //}
            break;
        }
    }

    public NodoMatrizAd buscarMatriz(int x, int y) {
        this.recorrerMatriz();
        NodoMatrizAd aux = this.raiz;
        int c = 1;
        while (aux!=null) {
            NodoMatrizAd aux1 = aux;
            while (aux1!=null){
                if(aux1.getY()==-1 || aux1.getX() == -1){
                    aux1 = aux1.getSiguiente();
                    continue;
                }
                if(aux1.getX()==x && aux1.getY()==y){
                  return aux1;  
                //System.out.println(aux1.getX() +"," + aux1.getY() + " : " +  aux1.getArbolAVL().getNombre());    
                }
                
                aux1 = aux1.getSiguiente();
                c++;
            }
            aux = aux.getAbajo();
        }
        return null;
    }

    public void insertarInterseccion(String padre, String hijo,String nombre) {
        
        NodoMatrizAd aux_columna;
        NodoMatrizAd aux_Fila;
        NodoMatrizAd tempPrimero = this.raiz;
        int HijoX=0;
        int HijoY=0;
        int PadreX=0;
        int PadreY=0;
        
        aux_columna = tempPrimero;
        aux_Fila = this.raiz;

        if (aux_columna.abajo != null) {
            aux_columna = aux_columna.abajo;
            if (aux_columna.siguiente != null) {
                aux_columna = aux_columna.siguiente;
                while (aux_columna != null) {
                    
                    if (aux_columna.arbol.getRuta().equals(padre)) {
                        
                        PadreX=aux_columna.getX();
                        PadreY=aux_columna.getY();
                        //break;
                    }
                    aux_columna = aux_columna.abajo;
                }
            }        
        }
        
        if(aux_Fila.abajo!=null){
            aux_Fila = aux_Fila.abajo;
            if(aux_Fila.siguiente!=null){
                while(aux_Fila!=null){
                    if(aux_Fila.arbol.getRuta().equals(hijo)){
                        HijoX = aux_Fila.getX();
                        HijoY = aux_Fila.getY();
                        //break;
                    }
                  aux_Fila=aux_Fila.siguiente;  
                }
                
            }
        }
        this.insertarElemento(HijoX,PadreY, new ArbolAVL2(hijo,nombre));

    }

    public void graficarMatriz() {

        File punto = new File(".");
        PrintWriter escribir = null;
        try {
            escribir = new PrintWriter(punto.getAbsolutePath() + "//" + "Matriz.dot", "UTF-8");
            escribir.println("digraph G {\n");
            escribir.println("node [shape=box, color=cornflowerblue ];");
            //escribir.println("rankdir=LR;");
            graficarMatriz2(escribir);
            /*NodoMatrizAd aux_columna;
        NodoMatrizAd aux_Fila;
        //NodoMatrizAd auxRaiz;
        aux_columna = this.raiz;
        //auxRaiz=aux->frente;
        boolean condicion = true;
        while(condicion){
            while(aux_columna != null){
                if(aux_columna.getAbajo()!=null)
                {
                   aux_columna = aux_columna.getAbajo();
                }
                else
                {
                    break;
                }
                if(aux_columna.getSiguiente()!=null)
                {
                    aux_Fila = aux_columna.getSiguiente();
                }
                else
                {
                    break;
                }
                //aux1=aux;
                while(aux_Fila != null){
                    //cout << aux1->dato<<" ";
                    
                    if(aux_Fila.getSiguiente()!=null){
                        System.out.println("\"" + (aux_Fila.getArbol()) + "\"->\"" + (aux_Fila.getSiguiente().getArbol()) +  "\""+"[dir=both];");
                        escribir.println("\"" + (aux_Fila.getArbol()) + "\"->\"" + (aux_Fila.getSiguiente().getArbol()) +  "\""+"[dir=both];");
                    }
                    if(aux_Fila.getAbajo()!=null){
                        System.out.println("\"" + (aux_Fila.getArbol()) + "\"->\"" + (aux_Fila.getAbajo().getArbol()) +  "\""+"[dir=both];");
                        escribir.println("\"" + (aux_Fila.getArbol()) + "\"->\"" + (aux_Fila.getAbajo().getArbol()) +  "\""+"[dir=both];");
                    }
                    aux_Fila = aux_Fila.getSiguiente();
                }
           // aux = aux->abajo;
            //cout<<""<<endl;
            }
            //aux=auxRaiz;
            if(aux_columna==null){
                //aux= aux->frente;
                //auxRaiz=auxRaiz->frente;
                condicion= false;
                break;
            }//else
            //{
              //  condicion= false;
                //break;
            //}
        }*/
            escribir.println("}");
            int numero=0;
            numero = (int) (Math.random() * 1000000000) + 1;
            escribir.close();
            ProcessBuilder abrir;
            String rutaImagen = punto.getAbsolutePath() + "//" + "MatrizImagen"+String.valueOf(numero)+".jpg";
            String rutaDot = punto.getAbsolutePath() + "//" + "Matriz.dot";
            abrir = new ProcessBuilder("dot", "-Tjpg", "-o", rutaImagen, rutaDot);

            //abrir = new ProcessBuilder("dot -Tjpg Arbol.dot -o imagenArbol.jpg");
            //system("dot -Tjpg Arbol.dot -o imagenArbol.jpg")
            //os.system("imagenArbol.jpg")
            abrir.redirectErrorStream(true);
            abrir.start();
            ///////////////////////////// Creo una ventana nueva con la imagen 
            //ScrollPaneReport temporal3 = new ScrollPaneReport(rutaImagen);

            //VentanaReporte temporal4 = new VentanaReporte(rutaImagen);
            //temporal4.abrirVentana(rutaImagen);
            VentanaReporte3 temporal4 = new VentanaReporte3(rutaImagen);
            //temporal4.abrirVentana(rutaImagen);
        } catch (Exception e) {
            System.out.println("ERROR PARA CREAR ARCHIVO");
        }

    }

}
