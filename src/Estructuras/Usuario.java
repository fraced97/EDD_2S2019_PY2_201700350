/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructuras;

/**
 *
 * @author USUARIO
 */
public class Usuario {
    
    private String nickname;
    private String contrasenia;
    private String fechaHora;
    private MatrizAd matriz;

    public Usuario(String nickname, String contrasenia, String fechaHora, MatrizAd matriz) {
        this.nickname = nickname;
        this.contrasenia = contrasenia;
        this.fechaHora = fechaHora;
        this.matriz = matriz;
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
