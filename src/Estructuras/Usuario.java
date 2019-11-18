/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructuras;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;

/**
 *
 * @author USUARIO
 */
public class Usuario {
    
    private String nickname;
    private String contrasenia;

    public String getContrasenia2() {
        return contrasenia2;
    }

    public void setContrasenia2(String contrasenia2) {
        this.contrasenia2 = contrasenia2;
    }
    String contrasenia2;
    private String fechaHora;
    private MatrizAd matriz;

    public Usuario(String nickname, String contrasenia){
        this.nickname = nickname;
        this.contrasenia = contrasenia;
        try{
            MessageDigest procesoEncriptar = MessageDigest.getInstance("SHA-256");
            procesoEncriptar.reset();
            procesoEncriptar.update(contrasenia.getBytes("utf8"));
            String encriptado = String.format("%064x", new BigInteger(1, procesoEncriptar.digest()));
            this.contrasenia2=encriptado;
        }catch(Exception e){
            
        }
        
        
                    this.fechaHora = LocalDateTime.now().toString();
        this.matriz = new MatrizAd();
             this.matriz.insertarElemento(0, 0, new ArbolAVL2("Raiz","Raiz"));
                    this.matriz.insertarElemento(0, 1, new ArbolAVL2("Raiz/","Inicio"));
        this.matriz.insertarElemento(1, 0, new ArbolAVL2("Raiz/","Inicio"));
        
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(String fechaHora) {
        this.fechaHora = fechaHora;
    }

    public MatrizAd getMatriz() {
        return matriz;
    }

    public void setMatriz(MatrizAd matriz) {
        this.matriz = matriz;
    }
    
    
    
}
