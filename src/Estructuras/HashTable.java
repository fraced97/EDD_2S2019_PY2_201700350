
package Estructuras;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

public class HashTable {

   
    private Usuario[] usuario;
    int objeto=0;
    int tamanio;
    String nombreArchivo;

    public HashTable() {
        this.tamanio = 7; 
        objeto = 0;
        this.usuario = new Usuario[tamanio];
        
    }

    public Usuario[] getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario[] usuario) {
        this.usuario = usuario;
    }
    
    
    
 public void generarPrimo(){
        int x = tamanio;
     while (true){
       x++;
      if (x%2 != 0 && x%3 != 0 && x%5 != 0 && x%7 != 0 && x%11!=0 && x>tamanio){
        tamanio=x;
       break;
    }
      }
    }
 public void ajustarTabla(){
        if(objeto > tamanio*0.75){
      objeto = 0;
         Usuario[] temp= usuario;
      generarPrimo();
        usuario = new Usuario[tamanio];
         for(Usuario u: temp){
       if(u != null){
          insertar(u);
        }
      }
      }
    }

    

    public void recorrerTabla(){
      //System.out.println("tamaño:" + tamanio);
      int x = 0;
      for(Usuario u: usuario){
        x++;
     if(u != null){

    System.out.println(String.valueOf(x) + ":" + u.getNickname());
    }
     }
    }

   

    public boolean buscarUsuarioExiste(String nombre){
     for(Usuario u : usuario){
     try {
      if (u.getNickname().equals(nombre) && u != null){
         return true;
         }
      }catch (NullPointerException c){
          continue;
       }
        }
        return false;
    }
    public void insertar(Usuario usuario){
     if(!buscarUsuarioExiste(usuario.getNickname())){
       int codigo = (usuario.getNickname().hashCode() & 0x7fffffff) % tamanio;
         if (this.usuario[codigo]== null){
          this.usuario[codigo] = usuario;
       }else{
          if(codigo*codigo > tamanio){
    for(int i=codigo; i< tamanio; i++){
        if (this.usuario[i] == null){
          if (i == this.usuario.length){
               i=0;
                 }
       this.usuario[i] = usuario;
           break;                      }
             }
                }else{
          codigo = codigo*codigo;
         if (this.usuario[codigo]== null) {
        this.usuario[codigo] = usuario;
         }else{
           while (true){
       codigo=codigo*codigo;
        if(codigo>this.tamanio){
          int x = 0;
         for(Usuario u:this.usuario){
         if(u==null){
          this.usuario[x]=usuario;
               break;
            }
           x++;
          }
           break;
        }else{
       if(this.usuario[codigo]==null){
        this.usuario[codigo] = usuario;
       break;
        }
        }
        }

         }

       }

       }
            this.objeto++;
            ajustarTabla();
        }else{
            JOptionPane.showMessageDialog(null, "Usuario ya existe");
        }

    }
public void graficar(){
    FileWriter fichero = null;
        PrintWriter pw = null;
        try {

        File miDir = new File (".");
        //fileName = new SimpleDateFormat("yyyyMMddHHmmss''").format(new Date());
        fichero = new FileWriter(miDir.getAbsolutePath() + "//" +"TablaHash" + ".txt");
        pw = new PrintWriter(fichero);


            pw.println("digraph test {\n" +
                    "    graph [ratio=fill];\n" +
                    "    node [label=\"\\N\", fontsize=15, shape=plaintext];\n" +
                    "    arset [label=<\n" +
                    "        <TABLE ALIGN=\"LEFT\">\n" +
                    "            <TR>\n" +
                    "                <TD>INDEX</TD>\n" +
                    "                <TD>USER</TD>\n" +
                    "\t      <TD>PASSWOR</TD>\n" +
                    "            </TR>");

            int count = 0;
            for(Usuario u: usuario){
                count++;
                if(u != null){
                    pw.println("<TR>");
                    pw.println("<TD>");
                    pw.println(String.valueOf(count));
                    pw.println("</TD>");
                    pw.println("<TD>");
                    pw.println(u.getNickname());
                    pw.println("</TD>");
                    pw.println("<TD>");
                    pw.println(u.getContrasenia());
                    pw.println("</TD>");
                    pw.println("</TR>");
                }else{
                    pw.println("<TR>");
                    pw.println("<TD>");
                    pw.println(String.valueOf(count));
                    pw.println("</TD>");
                    pw.println("<TD>");
                    pw.println();
                    pw.println("</TD>");
                    pw.println("<TD>");
                    pw.println();
                    pw.println("</TD>");
                    pw.println("</TR>");
                }

            }

            pw.println(" </TABLE>\n" +
                    "    >, ];\n" +
                    "}");


            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    // Nuevamente aprovechamos el finally para
                    // asegurarnos que se cierra el fichero.
                    if (null != fichero)
                        fichero.close();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            //Llamar a la funcion que sacara la grafica del codigo ejecutado
            //creacionDibujo(fileName);
}
    
}
