package com.mycompany.sistematiendaropa;
/**
 *
 * @author DELL
 */


public class Usuario {
    private String nombre;
    private String tipoIdentificacion;
    private String numeroIdentificacion;
    private String usuario;
    private String contrasena;

    public Usuario(String nombre, String tipoDeIdentificacion, String numeroDeIdentificacion, String usuario, String contrasena) {
        this.nombre = nombre;
        this.tipoIdentificacion = tipoIdentificacion;
        this.numeroIdentificacion = numeroDeIdentificacion;
        this.usuario = usuario;
        this.contrasena = contrasena;
    }
    public String getNombre() {
        return nombre;
    }
    
    public String getUsuario() {
        return usuario;
    }

    public String getContrasena() {
        return contrasena;
    }
    
    public static String generarUsuario(String nombre, String tipoIdentificacion) {
        return tipoIdentificacion.substring(0, 2) + "_" + nombre.substring(0, 4);
        
    }
    
    public static String generarContrasena(String nombre, String numeroIdentificacion) {
        return nombre.substring(0, 2).toUpperCase() + numeroIdentificacion.substring(0, 3);
        
    }
    
    
}
