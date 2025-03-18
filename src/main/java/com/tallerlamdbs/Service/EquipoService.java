package com.tallerlamdbs.Service;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.tallerlamdbs.Modelos.Equipos;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class EquipoService {
    private static final String JSON_PATH = "src/main/java/JSON/UefaTeam.json";

    // Metodo para listar equipos con filtro de año de fundacion
    public static List<Equipos> listarEquipos(Predicate<Equipos> filtro) {
        List<Equipos> listaEquipos = new ArrayList<>();

        try {
            // Leer JSON
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(new FileReader(JSON_PATH));
            JSONObject jsonObject = (JSONObject) obj;

            // Obtener el array de jugadores
            JSONArray equipos = (JSONArray) jsonObject.get("equipos");

            // Imprimir encabezado de la tabla
            System.out.println("---------------------------------------------");
            System.out.printf("%-5s | %-20s | %-15s %n", "ID", "Equipo", "Año de fundacion");
            System.out.println("---------------------------------------------");

            // Recorrer e imprimir los datos en formato de tabla
            for (Object equipoObj : equipos) {
                JSONObject equipo = (JSONObject) equipoObj;
                Long id = (Long) equipo.get("id");
                String name = (String) equipo.get("name");
                int yearfoundation = Integer.parseInt(equipo.get("yearfoundation").toString());

                System.out.printf("%-5d | %-20s | %-15s %n", id, name, yearfoundation);
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
        return listaEquipos.stream()
                .filter(filtro)
                .collect(Collectors.toList());
            }

            public void imprimirEntrenadores (List<Equipos>equiposJson){
                equiposJson.forEach(e -> System.out.println(e.getCoach()));
            }
}
