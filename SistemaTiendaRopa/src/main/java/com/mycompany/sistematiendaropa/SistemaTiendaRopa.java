/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.sistematiendaropa;

/**
 *
 * @author DELL
 */
import java.util.Scanner;

public class SistemaTiendaRopa {
    private static Scanner scanner = new  Scanner(System.in);

    public static void main(String[] args) {
        SistemaTienda.inicializarProductos();
        boolean salir = false;
        
        while (!salir) {
            System.out.println("╔═════════════════════════════════════════════════════════╗");
            System.out.println("║                       MCV SITE                          ║");
            System.out.println("╚═════════════════════════════════════════════════════════╝");
            System.out.println("╔═════════════════════════════════════════════════════════╗");
            System.out.println("║ Bienvenido al sistema de registro e inicio de sesion.   ║");
            System.out.println("║ 1. Registrarse                                          ║");
            System.out.println("║ 2. Iniciar sesion                                       ║");
            System.out.println("║ 3. Salir                                                ║");
            System.out.println("║ Seleccione una opcion:                                  ║");
            System.out.println("╚═════════════════════════════════════════════════════════╝");
            
            if (scanner.hasNextInt()) {
                int opcion = scanner.nextInt();
                scanner.nextLine();
            
                switch (opcion) {
                     case 1:
                          SistemaUsuarios.registrarUsuario();
                         break;
                     case 2:
                          if (SistemaUsuarios.iniciarSesion()){
                             SistemaTienda.mostrarMenuRopa();
                        }
                        break;
                     case 3:
                          salir = true;
                         System.out.println("Gracias por escoger MCV SITE y por usar el sistema. Esperamos haberte ayudado en la seguridad de tu compra.");
                         break;
                     default:
                         System.out.println("Opcion no valida por favor intente de nuevo.");
                }
            }else {
                 System.out.println("Opción no válida, por favor ingrese un número.");
                 scanner.nextLine();
            }
        } 
        
    }
}
