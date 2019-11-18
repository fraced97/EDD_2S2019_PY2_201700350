/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructuras;

import Vistas.VentanaReporte3;
import java.io.File;
import java.io.PrintWriter;

/**
 *
 * @author USUARIO
 */
public class Pila {
    class nodo{
		String dato,usuario,fecha;
		nodo siguiente;
		public nodo(String n,String usuario,String fecha) {
			this.dato=n;
                        this.usuario=usuario;
			siguiente=null;
                        this.fecha=fecha;
		}
	}
	
	nodo primero;
	public Pila() {
		primero = null;
	}
	
	public boolean estaVacia() {
		return primero==null ? true:false;
	}
	
	public void push(String n,String usuario,String fecha) {
		nodo nuevo = new nodo(n,usuario,fecha);
		if(estaVacia()) {
			primero = nuevo;
		}
		else {
			nuevo.siguiente = primero;
			primero = nuevo;
		}
	}
        public void graficar(){
            File punto = new File(".");
        //String nombreArchivo="";
        PrintWriter escribir=null;
        
        try{
            
            escribir = new PrintWriter(punto.getAbsolutePath()+"//"+"Pila.dot","UTF-8");
            //escribir.println("Arbol.dot", "w")
            //escribir.println("digraph G {\n");
             escribir.println("digraph test {\n" +
                    "    graph [ratio=fill];\n" +
                    "    node [label=\"\\N\", fontsize=15, shape=plaintext];\n" +
                    "    arset [label=<\n" +
                    "        <TABLE ALIGN=\"LEFT\">\n" 
                    );
            //escribir.println("node [shape = plaintext]");
            //escribir.println("some_node [label=<<table border=\"0\" cellborder=\"1\" cellspacing=\"0\">");
            //escribir.println("<tr><td></td></tr><tr><td");
            nodo temp = this.primero;
            while(temp!=null){
                escribir.println("<TR>");
                    escribir.println("<TD>");
                    escribir.println(temp.dato+", "+temp.usuario+", "+temp.fecha);
                    escribir.println("</TD>");
                    
                    escribir.println("</TR>");
                //escribir.println("<tr><td bgcolor=""\"#f0e3ff""\">""<font color=""\"#ff1020""\">"+","+temp.usuario+temp.dato+"</font></td></tr>");
                temp = temp.siguiente;
            }
            //escribir.println("</table>>");
            //escribir.println("];");
            escribir.println(" </TABLE>\n" +
                    "    >, ];\n" +
                    "}");
            
            //escribir.println("}");

            escribir.close();
                    
            int numero=0;
            numero = (int) (Math.random() * 1000000000) + 1;
            ProcessBuilder abrir;
            String rutaImagen=punto.getAbsolutePath()+"//"+"PilaImagen"+String.valueOf(numero)+".jpg";
            String rutaDot= punto.getAbsolutePath()+"//"+"Pila.dot";
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
	
	/*public Rutas pop() {
		if(estaVacia()) return null;
		else {
			Rutas enviar = primero.dato;
			primero = primero.siguiente;
			return enviar;
		}	
	}*/
	
	/*public ArrayList<Rutas> enviarLista(){
		 ArrayList<Rutas> resultado = new ArrayList<Rutas>();
		 nodo temp = primero;
		 while(temp!=null) {
			 resultado.add(temp.dato);
			 temp = temp.siguiente;
		 }
		 return resultado;
	}*/
    
    
    
}
