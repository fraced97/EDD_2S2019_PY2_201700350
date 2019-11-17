/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructuras;

import java.time.LocalDateTime;

/**
 *
 * @author USUARIO
 */
public class Archivo {
    String fechaHora;
    String ruta,nombre,adentro,contenido;
    //String nombre;
    //String adentro;
   

    public Archivo(String nombre, String contenido) {
        //this.fechaHora = fechaHora;
        //this.ruta = ruta;
        this.nombre = nombre;
        this.adentro = contenido;
        fechaHora=LocalDateTime.now().toString();
        
    }

    public String getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(String fechaHora) {
        this.fechaHora = fechaHora;
    }

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

    public String getAdentro() {
        return adentro;
    }

    public void setAdentro(String adentro) {
        this.adentro = adentro;
    }
    
}
