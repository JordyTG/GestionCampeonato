package campeonato.controller;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import campeonato.model.entities.*;
import campeonato.model.manager.CampeonatoManager;
import campeonato.view.util.JSFUtil;

@ManagedBean
@SessionScoped
public class ControllerGruposCampeonato {

	private tbl_Campeonato Campeonato;
	
	@EJB
	private CampeonatoManager managerCampeonato;

	@PostConstruct
	public void inicializar() 
	{
		
	}
	
	public String inicializarByIdCampeonato(int id)
	{
		System.out.println("\n "+id+" \n");
		try {
		
			Campeonato=managerCampeonato.findCampeonato(id);
			return "gestionGruposCampeonato";
		}catch (Exception ex) 
		{
			JSFUtil.crearMensajeWarning(ex.getMessage());
			//return "gestionCampeonato";
			return "";
		}
	
	}

	public tbl_Campeonato getCampeonato() {
		return Campeonato;
	}

	public void setCampeonato(tbl_Campeonato campeonato) {
		Campeonato = campeonato;
	}
	
}
