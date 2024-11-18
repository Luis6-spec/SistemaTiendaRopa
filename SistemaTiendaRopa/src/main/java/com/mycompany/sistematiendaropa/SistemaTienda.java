package com.mycompany.sistematiendaropa;

/**
 *
 * @author DELL
 */
import java.util.ArrayList;
import java.util.Scanner;

public class SistemaTienda {
    private static ArrayList<Producto> productosMasculinosInfantil = new ArrayList<>();
    private static ArrayList<Producto> productosMasculinosAdulto = new ArrayList<>();
    private static  ArrayList<Producto> productosFemeninosInfantil = new ArrayList<>();
    private static ArrayList<Producto> productosFemeninosAdulto = new ArrayList<>();
    private static  Scanner scanner = new Scanner(System.in);
    
    public  static void inicializarProductos() {
        productosMasculinosInfantil.add(new ProductoInfantil("Camiseta de niño - Color Azul con estampado de  autos"));
        productosMasculinosInfantil.add(new ProductoInfantil("Jeans de niño - Corte clasico, resistente para juegos"));
        productosMasculinosInfantil.add(new ProductoInfantil("Chaqueta de niño - Impermeable con capucha  ajustable"));
        productosMasculinosInfantil.add(new ProductoInfantil("Sudadera de niño - Tela  suave y  elastica para mayor comodidad"));
        
        productosMasculinosAdulto.add(new ProductoAdulto("Camisa de adulto - Manga larga, tela  de algodon, ideal para oficina"));
        productosMasculinosAdulto.add(new ProductoAdulto("Pantalon formal de adulto - Corte  recto, color negro"));
        productosMasculinosAdulto.add(new ProductoAdulto("Chaqueta de cuero de adulto - Estilo clasico, resistente y elegante"));
        productosMasculinosAdulto.add(new ProductoAdulto("Reloj de pulsera de adulto - Diseño minimalista, resistente al agua"));
        
        productosFemeninosInfantil.add(new ProductoInfantil("Vestido de niña - Color rosa con flores, ideal para ocasiones especiales"));
        productosFemeninosInfantil.add(new ProductoInfantil("Falda de niña - Estilo tutu, ligera y comoda"));
        productosFemeninosInfantil.add(new ProductoInfantil("Blusa de niña - Color blanco bordados, suave al tacto"));
        productosFemeninosInfantil.add(new ProductoInfantil("Leggins de niña  - Color  lila, tela elastica y comoda para moverse"));
        
        productosFemeninosAdulto.add(new ProductoAdulto("Blusa de adulta - Manga corta, con encaje y detalles finos"));
        productosFemeninosAdulto.add(new ProductoAdulto("Pantalon de vestir de adulta - Color beige, estilo elegante"));
        productosFemeninosAdulto.add(new ProductoAdulto("Abrigo de adulta - Largo hasta  las  rodillas, ideal para  invierno"));
        productosFemeninosAdulto.add(new ProductoAdulto("Bolso de  mano de adulta  - Diseño moderno, color negro"));
        
        
                
                
    }
    
    
    public static void mostrarMenuRopa() {
         System.out.println("╔═════════════════════════════════════════════════════════╗");
         System.out.println("║                   SELECCION DE GENERO                   ║");
         System.out.println("╚═════════════════════════════════════════════════════════╝");
         System.out.println("╔═════════════════════════════════════════════════════════╗");
         System.out.println("║ Seleccione el genero de la ropa que prefiere.           ║");
         System.out.println("║ 1. Masculino                                            ║");
         System.out.println("║ 2. Femenino                                             ║");
         System.out.println("║ 3. Todos                                                ║");
         System.out.println("╚═════════════════════════════════════════════════════════╝");




        int opcionGenero = scanner.nextInt();
        scanner.nextLine();

        switch (opcionGenero) {
             case 1:
                 mostrarCategoriasEdad("Masculino"); 
                break;
              case 2:
                 mostrarCategoriasEdad("Femenino"); 
                break;
               case 3:
                  mostrarRopaCompleta(); 
                  break;
               default:
                  System.out.println("Opción no válida, intente de nuevo.");
        }          mostrarMenuRopa(); 
    }

    
    public static void mostrarCategoriasEdad(String genero) {
        System.out.println("╔═════════════════════════════════════════════════════════╗");
        System.out.println("║            SELECCION DE CATEGORIA DE EDAD               ║");
        System.out.println("╚═════════════════════════════════════════════════════════╝");
        System.out.println("╔═════════════════════════════════════════════════════════╗");
        System.out.println("║ Seleccione la categoria de edad que prefiere.           ║");
        System.out.println("║ 1. Infantil                                             ║");
        System.out.println("║ 2. Adulto                                               ║");
        System.out.println("║ 3. Todos                                                ║");
        System.out.println("╚═════════════════════════════════════════════════════════╝");


        
        int opcionEdad = scanner.nextInt();
        scanner.nextLine();
        
    
        
        if (genero.equals("Masculino")) {
            if (opcionEdad == 1) {
                mostrarProductos(productosMasculinosInfantil,genero);
            } else if (opcionEdad == 2) {
                mostrarProductos(productosMasculinosAdulto,genero);
            } else if (opcionEdad == 3) {
                mostrarProductosCombinados(productosMasculinosInfantil, productosMasculinosAdulto,genero);
            } else {
                System.out.println("Opcion no valida, intente de nuevo. ");
                mostrarCategoriasEdad(genero);
            }
        } else if (genero.equals("Femenino")) {
            if (opcionEdad == 1) {
                mostrarProductos(productosFemeninosInfantil,genero);
            } else if (opcionEdad == 2) {
                mostrarProductos(productosFemeninosAdulto,genero);
            } else if (opcionEdad == 3) {
                mostrarProductosCombinados(productosFemeninosInfantil, productosFemeninosAdulto,genero);
            } else {
                System.out.println("Opcion no valida, intente de nuevo. ");
                mostrarCategoriasEdad(genero);
            }
            
        }
    }
    
    public static void mostrarProductos(ArrayList<Producto> productos, String genero) {
        for (int i = 0; i < productos.size(); i++) {
            Producto producto = productos.get(i);
            System.out.println((i + 1) + ". " + producto.getDescripcion());
            
        }
        seleccionarProducto(productos, genero, false);
        
    }
    
    public static  void mostrarProductosCombinados(ArrayList<Producto> productosInfantil,ArrayList<Producto> productosAdulto, String genero) {
         ArrayList<Producto> productosCombinados = new ArrayList<>();
    
    System.out.println("Productos " + genero + " - Infantil:");
    for (Producto producto : productosInfantil) {
        productosCombinados.add(producto);
        System.out.println((productosCombinados.size()) + ". " + producto.getDescripcion());
    }

    System.out.println("Productos " + genero + " - Adulto:");
    for (Producto producto : productosAdulto) {
        productosCombinados.add(producto);
        System.out.println((productosCombinados.size()) + ". " + producto.getDescripcion());
    }
    
     seleccionarProducto(productosCombinados, genero, false);

         
    }
    
    public static void seleccionarProducto(ArrayList<Producto> productos, String genero, boolean esGeneroTodos) {
    System.out.println("Seleccione el número del producto para más detalles: ");
    int opcionProducto = scanner.nextInt();
    scanner.nextLine();

    if (opcionProducto > 0 && opcionProducto <= productos.size()) {
        Producto productoSeleccionado = productos.get(opcionProducto - 1);
        System.out.println("Descripción detallada del producto: " + productoSeleccionado.getDescripcion());
        System.out.println("Para comprar este producto visite: www.ejemplo.com");

        
        if (esGeneroTodos) {
            
            System.out.println("╔═════════════════════════════════════════════════════════╗");
            System.out.println("║ ¿Desea regresar al menu principal o salir?              ║");
            System.out.println("║ 1. Regresar al menu principal o salir?                  ║");
            System.out.println("║ 2. Salir                                                ║");
            System.out.println("╚═════════════════════════════════════════════════════════╝");




        } else {
           
            System.out.println("╔══════════════════════════════════════════════════════════════╗");
            System.out.println("║ ¿Desea regresar al menu anterior, al menu principal o salir? ║");
            System.out.println("║ 1. Regresar al menu anterior                                 ║");
            System.out.println("║ 2. Regresar al menu principal                                ║");
            System.out.println("║ 3. Salir                                                     ║");
            System.out.println("╚══════════════════════════════════════════════════════════════╝");



          
        }

        int opcion = scanner.nextInt();
        scanner.nextLine();

        if (esGeneroTodos) {
            if (opcion == 1) {
                mostrarMenuRopa();
            } else {
                System.out.println("Gracias por escoger MCV SITE y por usar el sistema. Esperamos haberte ayudado en la seguridad de tu compra.");
                System.exit(0);
            }
        } else {
            if (opcion == 1) {
                mostrarCategoriasEdad(genero);
            } else if (opcion == 2) {
                mostrarMenuRopa();
            } else {
                System.out.println("Gracias por escoger MCV SITE y por usar el sistema. Esperamos haberte ayudado en la seguridad de tu compra.");
                System.exit(0);
            }
        }
    } else {
        System.out.println("Opción no válida, intente de nuevo.");
        seleccionarProducto(productos, genero, esGeneroTodos);
    }
}
    
    public static void mostrarRopaCompleta() {
        ArrayList<Producto> productosCombinados = new ArrayList<>();
    
    System.out.println("Productos Masculinos - Infantil:");
    for (Producto producto : productosMasculinosInfantil) {
        productosCombinados.add(producto);
        System.out.println((productosCombinados.size()) + ". " + producto.getDescripcion());
    }

    System.out.println("Productos Masculinos - Adulto:");
    for (Producto producto : productosMasculinosAdulto) {
        productosCombinados.add(producto);
        System.out.println((productosCombinados.size()) + ". " + producto.getDescripcion());
    }
    
    System.out.println("Productos Femeninos - Infantil:");
    for (Producto producto : productosFemeninosInfantil) {
        productosCombinados.add(producto);
        System.out.println((productosCombinados.size()) + ". " + producto.getDescripcion());
    }

    System.out.println("Productos Femeninos - Adulto:");
    for (Producto producto : productosFemeninosAdulto) {
        productosCombinados.add(producto);
        System.out.println((productosCombinados.size()) + ". " + producto.getDescripcion());
    }

    seleccionarProducto(productosCombinados, "Todos", true);
        
        
    }
    
}
