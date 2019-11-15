
package eddproyecto2;

//import Estructuras.ArbolAVL;
import Estructuras.ArbolAVL2;
import Estructuras.HashTable;
import Estructuras.MatrizAd;
import Estructuras.Usuario;
import Vistas.Login;

/**
 *
 * @author Fredy
 */
public class EDDProyecto2 {

    /**
     * @param args the command line arguments
     */
    public static HashTable tabla;
    
    public static void main(String[] args) {
        tabla = new HashTable(); 
        tabla.insertar(new Usuario("Fredy","hola"));
         tabla.insertar(new Usuario("Jesus","hola"));
         tabla.insertar(new Usuario("Eli","hola"));
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
