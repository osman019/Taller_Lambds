package com.tallerlamdbs;

import java.util.Scanner;

import com.tallerlamdbs.Service.EquipoService;
import com.tallerlamdbs.Service.JugadoresService;

public class Main {
    public static void limpiarPantalla() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcionPrincipal;

        do {
            limpiarPantalla();
            System.out.println("\n========== MENÚ PRINCIPAL ==========");
            System.out.println("1. Equipos");
            System.out.println("2. Jugadores");
            System.out.println("3. Salir");
            System.out.println("=======================================");
            System.out.print("Seleccione una opción: ");
            opcionPrincipal = scanner.nextInt();

            switch (opcionPrincipal) {
                case 1:
                    menuEquipos(scanner);
                    break;
                case 2:
                    menuJugadores(scanner);
                    break;
                case 3:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción inválida, intente de nuevo.");
            }
        } while (opcionPrincipal != 3);

        scanner.close();
    }

    private static void menuEquipos(Scanner scanner) {
        int opcion;

        do {

            System.out.println("\n===== MENÚ EQUIPOS =====");
            System.out.println("1. Listar Equipos fundados despues del año 2000");
            System.out.println("2. Mostrar Entrenadores");
            System.out.println("3. Volver al Menú Principal");
            System.out.println("==========================");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {

                case 1:
                    EquipoService.listarEquiposFundadosDespuesDe2000();
                    break;

                case 2:
                    EquipoService.imprimirNombresEntrenadores();
                    break;
                case 3:
                    System.out.println("Volviendo al Menú Principal...");
                    break;
                default:
                    System.out.println("Opción inválida, intente de nuevo.");
            }
        } while (opcion != 3);
    }

    private static void menuJugadores(Scanner scanner) {
        int opcion;
        do {
            limpiarPantalla();
            System.out.println("\n===== MENÚ JUGADORES =====");
            System.out.println("1. Calcular Promedio de Edad por Equipo");
            System.out.println("2. Volver al Menú Principal");
            System.out.println("============================");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("-------------------------------");
                    System.out.println("- Promedio de edad por equipo -");
                    System.out.println("-------------------------------");
                    JugadoresService.calcularPromedioEdadPorEquipo();
                    break;
                case 2:
                    System.out.println("Volviendo al Menú Principal...");
                    break;
                default:
                    System.out.println("Opción inválida, intente de nuevo.");
            }
        } while (opcion != 2);
    }
}
