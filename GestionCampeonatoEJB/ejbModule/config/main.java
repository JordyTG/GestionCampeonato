package config;

import java.util.List;

import campeonato.model.entities.*;
import campeonato.model.manager.CampeonatoManager;

public class main {

	
	public static void main (String[] args) 
	{
		CampeonatoManager CM = new CampeonatoManager();
		List<tbl_Jugadores> lista= CM.findAllJugadoresEquipo(1);
		for(tbl_Jugadores j : lista) 
		{
			System.out.println("\n\n"+j.getJugCedula());
		}
		
	}
	
}
