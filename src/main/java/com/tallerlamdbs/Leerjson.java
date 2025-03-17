package com.tallerlamdbs;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tallerlamdbs.Modelos.Equipos;
import java.io.FileReader;
import java.util.List;

public class Leerjson {
    
    public static List<Equipos> cargarEquipos(String ruta) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return List.of(mapper.readValue(new File(ruta), Equipos[].class));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}