package com.tallerlamdbs;

import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

import com.tallerlamdbs.Modelos.Equipos;
import com.tallerlamdbs.Service.EquipoService;

public class Main {
    private static List<Equipos> equiposJson;
    EquipoService equipoService = new EquipoService();
    public static void limpiarPantalla() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            limpiarPantalla();
            System.out.println("========================");
            System.out.println("=    MENÚ PRINCIPAL    =");
            System.out.println("========================");
            System.out.println("1. Menu Equipos");
            System.out.println("2. Menu Jugadores");
            System.out.println("3. Menu Estadisticas");
            System.out.println("Salir: ");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcion) {
                case 1:
                    menuEquipos(scanner);
                    break;
                case 2:
                    menuJugadores(scanner);
                    break;
                case 3:
                   menuEstadisticas(scanner);
                    case 4:
                    System.out.println("Saliendo...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Opción inválida.");
            }
        }
    }

    private static void menuEquipos(Scanner scanner) {
        EquipoService equipoService = new EquipoService();
        while (true) {
            limpiarPantalla();
            System.out.println("                        "); 
            System.out.println("========================");
            System.out.println("==   MENÚ EQUIPOS   ==");
            System.out.println("========================");
            System.out.println("1. Listar equipos fundados desde 2000");
            System.out.println("2. listar entrenadores");
            System.out.println("2. Volver al menú principal");
            
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine();

          switch (opcion) {
            case 1:
            listarEquipos(equipoService);
                
                break;
          case 2 :
          imprimirEntrenadores();
                break;
          }
        }
    }

    private static void menuJugadores(Scanner scanner) {
        // JugadoresService jugadorService = new JugadoresService();
        while (true) {
            limpiarPantalla();
            System.out.println("========================");
            System.out.println("==   MENÚ JUGADORES   ==");
            System.out.println("========================");
            System.out.println("1. Listar jugadores");
            System.out.println("2. Volver al menú principal");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine();

            if (opcion == 1) {
                System.out.println("prueba");
            } else if (opcion == 2) {
                return;
            } else {
                System.out.println("Opción inválida.");
            }
        }
    }

    public static void menuEstadisticas(Scanner scanner){
        while (true) {
            limpiarPantalla();
            System.out.println("========================");
            System.out.println("==    ESTADISTICAS    ==");
            System.out.println("========================");
            System.out.println("1. PROXIMAMENTE");
            System.out.println("2. Volver al menú principal");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine();

            if (opcion == 1) {
                System.out.println("prueba");
            } else if (opcion == 2) {
                return;
            } else {
                System.out.println("Opción inválida.");
            }
        }
    }

    private static void listarEquipos(EquipoService equipoService) {
        Predicate<Equipos> filtroDesde2000 = equipo -> equipo.getYearfoundation() >= 2000;
        List<Equipos> equipos = EquipoService.listarEquipos(filtroDesde2000);
        System.out.println(equipos);
        }
    

        private static void imprimirEntrenadores() {
            if (equiposJson != null && !equiposJson.isEmpty()) {
                System.out.println("Coachs: ");
                equiposJson.forEach(e -> System.out.println(e.getCoach()));
            } else {
                System.out.println("No hay Coachs disponibles.");
            }
        }
        
    }

