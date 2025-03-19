package com.tallerlamdbs.Service;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.tallerlamdbs.Modelos.Equipos;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class EquipoService {
    private static final String JSON_PATH = "src/main/java/JSON/UefaTeam.json";
    public static List<Equipos> listarEquiposFundadosDespuesDe2000() {
        List<Equipos> listaEquipos = new ArrayList<>();

        try {
            // Leer el archivo JSON
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(new FileReader(JSON_PATH));
            JSONObject jsonObject = (JSONObject) obj;

            // Obtener la lista de equipos del JSON
            JSONArray equipos = (JSONArray) jsonObject.get("equipos");

            // Recorrer los equipos y convertirlos en objetos de tipo Equipos
            for (Object equipoObj : equipos) {
                JSONObject equipoJSON = (JSONObject) equipoObj;
                int yearFoundation = Integer.parseInt(equipoJSON.get("yearfoundation").toString());

                Equipos equipo = new Equipos(
                    Integer.parseInt(equipoJSON.get("id").toString()),
                    (String) equipoJSON.get("name"),
                    yearFoundation,
                    (String) equipoJSON.get("coach")
                );

                listaEquipos.add(equipo);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        // 📌 Predicate para filtrar equipos fundados después del 2000
        Predicate<Equipos> fundadosDespuesDe2000 = equipo -> equipo.getYearfoundation() > 2000;

        // Usando Stream para filtrar y listar equipos
        List<Equipos> equiposFiltrados = listaEquipos.stream()
                .filter(fundadosDespuesDe2000)
                .collect(Collectors.toList());

       
        System.out.println("\n===== Equipos fundados después del año 2000 =====");
        System.out.println("---------------------------------------------");
        System.out.printf("%-5s | %-20s | %-15s %n", "ID", "Equipo", "Año de fundación");
        System.out.println("---------------------------------------------");
        for (Equipos equipo : equiposFiltrados) {
            System.out.printf("%-5d | %-20s | %-15d %n", equipo.getId(), equipo.getName(), equipo.getYearfoundation());
        }

        return equiposFiltrados;
    }
   // 📌 Método para imprimir los nombres de los entrenadores
    public static void imprimirNombresEntrenadores() {
        List<Equipos> listaEquipos = new ArrayList<>();

        try {
            // Leer el archivo JSON
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(new FileReader(JSON_PATH));
            JSONObject jsonObject = (JSONObject) obj;

            // Obtener la lista de equipos del JSON
            JSONArray equipos = (JSONArray) jsonObject.get("equipos");

            // Recorrer los equipos y convertirlos en objetos de tipo Equipos
            for (Object equipoObj : equipos) {
                JSONObject equipoJSON = (JSONObject) equipoObj;
                Equipos equipo = new Equipos(
                    Integer.parseInt(equipoJSON.get("id").toString()),
                    (String) equipoJSON.get("name"),
                    Integer.parseInt(equipoJSON.get("yearfoundation").toString()),
                    (String) equipoJSON.get("coach")
                );

                listaEquipos.add(equipo);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        // 📌 Consumer para imprimir el nombre del entrenador
        Consumer<Equipos> imprimirEntrenador = equipo -> 
            System.out.printf("%-20s | %-15s %n", equipo.getName(), equipo.getCoach());

        // 📌 Imprimir encabezado
        System.out.println("\n===== Lista de Entrenadores =====");
        System.out.println("---------------------------------------");
        System.out.printf("%-20s | %-15s %n", "Equipo", "Entrenador");
        System.out.println("---------------------------------------");

        // 📌 Recorrer la lista y aplicar el Consumer con forEach
        listaEquipos.forEach(imprimirEntrenador);
    }

}
