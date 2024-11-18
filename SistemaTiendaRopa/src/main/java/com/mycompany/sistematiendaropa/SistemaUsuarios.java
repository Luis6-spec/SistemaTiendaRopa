package com.mycompany.sistematiendaropa;

/**
 *
 * @author DELL
 */

import java.util.ArrayList;
import java.util.Scanner;

public class SistemaUsuarios {
    private static ArrayList<Usuario> listaUsuarios = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    private static final String ADMIN_USER = "admin";
    private static final String ADMIN_PASSWORD = "admin123";
    
    public static void registrarUsuario(){
        System.out.println("╔═════════════════════════════════════════════════════════╗");
        System.out.println("║                   REGISTRO DE USUARIO                   ║");
        System.out.println("╚═════════════════════════════════════════════════════════╝");
        System.out.println("╔═════════════════════════════════════════════════════════╗");
        System.out.println("║ Ingrese su nombre (solo letras):                        ║");
        System.out.println("╚═════════════════════════════════════════════════════════╝");
        
        String nombre = scanner.nextLine();
        while (!nombre.matches("[a-zA-Z ]+")) {
         System.out.println("Nombre invalido. Ingrese nuevamente (solo letras): ");
         nombre = scanner.nextLine();
        }
        System.out.println("╔═════════════════════════════════════════════════════════╗");
        System.out.println("║                   REGISTRO DE USUARIO                   ║");
        System.out.println("╚═════════════════════════════════════════════════════════╝");
        System.out.println("╔═════════════════════════════════════════════════════════╗");
        System.out.println("║ Ingrese su tipo de identificacion (ej: CC, TI):         ║");
        System.out.println("╚═════════════════════════════════════════════════════════╝");

        String tipoIdentificacion = scanner.nextLine();
        System.out.println("╔═════════════════════════════════════════════════════════╗");
        System.out.println("║                   REGISTRO DE USUARIO                   ║");
        System.out.println("╚═════════════════════════════════════════════════════════╝");
        System.out.println("╔═════════════════════════════════════════════════════════╗");
        System.out.println("║ Ingrese su numero de identificacion:                    ║");
        System.out.println("╚═════════════════════════════════════════════════════════╝");

        String numeroIdentificacion = scanner.nextLine();
        
        String  usuario = Usuario.generarUsuario(nombre, tipoIdentificacion);
        String contrasena = Usuario.generarContrasena(nombre, numeroIdentificacion);
        
        listaUsuarios.add(new Usuario(nombre, tipoIdentificacion, numeroIdentificacion, usuario, contrasena));

        System.out.println("REGISTRO DE USUARIO EXITOSO.");
        System.out.println("Su nombre de usuario es: " + usuario);
        System.out.println("Su contraseña para ingresar es: " + contrasena);

        
    }
    
    public static  boolean  iniciarSesion() {
        System.out.println("╔═════════════════════════════════════════════════════════╗");
        System.out.println("║                   INICIO DE SESION                      ║");
        System.out.println("╚═════════════════════════════════════════════════════════╝");
        System.out.println("╔═════════════════════════════════════════════════════════╗");
        System.out.println("║ Ingrese su nombre de usuario:                           ║");
        System.out.println("╚═════════════════════════════════════════════════════════╝");
        String usuarioIngresado = scanner.nextLine();


        System.out.println("╔═════════════════════════════════════════════════════════╗");
        System.out.println("║                   INICIO DE SESION                      ║");
        System.out.println("╚═════════════════════════════════════════════════════════╝");
        System.out.println("╔═════════════════════════════════════════════════════════╗");
        System.out.println("║ Ingrese su contraseña:                                  ║");
        System.out.println("╚═════════════════════════════════════════════════════════╝");
        String contrasenaIngresada = scanner.nextLine();

        if (usuarioIngresado.equals(ADMIN_USER) && contrasenaIngresada.equals(ADMIN_PASSWORD)) {
            System.out.println("Inicio de sesión exitoso. Bienvenido, Administrador.");
            verUsuariosRegistrados();
            return true;
        }
        
        
        for (Usuario usuario : listaUsuarios) {
            if (usuario.getUsuario().equals(usuarioIngresado) && usuario.getContrasena().equals(contrasenaIngresada)) {
                
                System.out.println("╔════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╗");
                System.out.println("║ INICIO DE SESION EXITOSO, GRACIAS POR ESCOGERNOS Y CONFIAR EN NOSOTROS. ESPARAMOS Y TENGAS UNA EXPERIENCIA DE COMPRA AGRADABLE.║                                 ║");
                System.out.println("╚════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╝");
                return true;
            }
        }
        
        System.out.println("Usario o  contraseña incorrectos. Intente de nuevo. ");
        return  false;
    }

    private static void verUsuariosRegistrados() {
        if (listaUsuarios.isEmpty()) {
            System.out.println("No hay usuarios registrados.");
        } else {
            System.out.println("Usuarios registrados el dia de hoy :");
            int contador = 1;
            for (Usuario usuario : listaUsuarios) {
                System.out.println(contador + ". Nombre: " + usuario.getNombre() + ", Usuario: " + usuario.getUsuario());
                contador++;
            }
            System.out.println("Cantidad total de usuarios: " + listaUsuarios.size());
            System.out.println("Saliendo del programa...");
            System.exit(0);
        }


    }
}
