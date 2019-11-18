
package eddproyecto2;

//import Estructuras.ArbolAVL;
import Estructuras.ArbolAVL2;
import Estructuras.HashTable;
import Estructuras.MatrizAd;
import Estructuras.Pila;
import Estructuras.Usuario;
import Vistas.Login;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author Fredy
 */
public class EDDProyecto2 {

    /**
     * @param args the command line arguments
     */
    public static HashTable tabla;
    public static Pila pila;
    
    public static void main(String[] args){
        tabla = new HashTable(); 
        pila = new Pila();
        /*tabla.insertar(new Usuario("Fredy","12345678"));
         tabla.insertar(new Usuario("Jesus","12345678"));
         tabla.insertar(new Usuario("Eli","12345678"));
         tabla.insertar(new Usuario("Karen","12345678"));
         tabla.insertar(new Usuario("Ricardo","12345678"));
         tabla.insertar(new Usuario("Manuel","12345678"));
         tabla.insertar(new Usuario("Brandon","12345678"));
         tabla.insertar(new Usuario("Jose","12345678"));
         tabla.insertar(new Usuario("Gar","12345678"));
         tabla.insertar(new Usuario("Bob","12345678"));
         tabla.insertar(new Usuario("Mario","12345678"));
         tabla.insertar(new Usuario("Milton","12345678"));
         tabla.insertar(new Usuario("ys","12345678"));
         tabla.insertar(new Usuario("gerardo","12345678"));
         tabla.insertar(new Usuario("Cris","12345678"));*/
         
         
         Login login = new Login();
         login.setVisible(true);
        // TODO code application logic here
       /* ArbolAVL2 arbol = new ArbolAVL2();
        arbol.insertar("M");
        arbol.insertar("D");
        arbol.insertar("P");
        arbol.insertar("A");
        arbol.insertar("E");
        arbol.insertar("W");
        arbol.insertar("B");
        arbol.insertar("G");
        arbol.insertar("Z");
        arbol.insertar("Q");
        arbol.insertar("O");
        arbol.insertar("L");
        arbol.insertar("T");
        arbol.insertar("I");
        arbol.insertar("H");
        
        
        
        
        arbol.preorden(arbol.ObtenerRaiz());
        arbol.graficarArbol();*/
       //MatrizAd matriz = new MatrizAd();
       
       /*for(int i=0;i<3;i++){
           for(int j=0;j<;j++){
               //System.out.println(i);
               //System.out.println("---------------");
               //System.out.println(j);
               //System.out.println("----------------");
               matriz.insertarElemento(i, j,"Ejemplo"+String.valueOf(i)+String.valueOf(j));
           }
       }*/
       //matriz.recorrerMatriz();
        //matriz.graficarMatriz();
       
    }
    
}
