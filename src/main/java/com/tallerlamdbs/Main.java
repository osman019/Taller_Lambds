package com.tallerlamdbs;

import java.io.FileReader;

import com.tallerlamdbs.Service.EquipoService;
import com.tallerlamdbs.Service.JugadoresService;

public class Main {
    public static void main(String[] args) {
       JugadoresService JugadoresService = new JugadoresService();
        EquipoService EquipoService = new EquipoService();

        Leerjson parser = new Leerjson();
	
			Object obj = parser.parse(new FileReader("/src/main/java/JSON/UefaTeam.json"));	
    }
}



