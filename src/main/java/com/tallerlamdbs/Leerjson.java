package com.tallerlamdbs;


import com.tallerlamdbs.Modelos.Equipos;


import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Leerjson {
    
    public static List<Equipos>listarEquipos () {
  List<Equipos> listaEquipos = new ArrayList<>();
  
        try {
            // Leer y parsear JSON
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(new FileReader("src/main/java/JSON/UefaTeam.json"));
            JSONObject jsonObject = (JSONObject) obj;

            // Obtener el array de jugadores
            JSONArray equipos = (JSONArray) jsonObject.get("equipos");

            // Imprimir encabezado de la tabla
            System.out.printf("%-5s | %-20s | %-15s %n", "ID", "Nombre", "Equipo");
            System.out.println("---------------------------------------------");

            // Recorrer e imprimir los datos en formato de tabla
            for (Object equipoObj : equipos) {
                JSONObject equipo = (JSONObject) equipoObj;
                Long id = (Long) equipo.get("id");
                String name = (String) equipo.get("name");
                

                System.out.printf("%-5d | %-20s | %-15s %n", id, name, equipo);
            }
        } catch (Exception e) {
            e.printStackTrace();
      
            
        } 
        return listaEquipos;  }
}


