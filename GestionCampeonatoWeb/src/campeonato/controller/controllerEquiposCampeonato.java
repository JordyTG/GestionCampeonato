package campeonato.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import campeonato.model.entities.tbl_Equipos;
import campeonato.model.manager.CampeonatoManager;
import campeonato.view.util.JSFUtil;


@ManagedBean
@SessionScoped
public class controllerEquiposCampeonato {

	private List<tbl_Equipos> listaEquipos;
	private int idCampeonatoSeleccionado;
	private int idEquipoSeleccionado;
	private String nombreCampeonato;
	@EJB
	private CampeonatoManager managerCampeonato;

	@PostConstruct
	public void inicializar() {
		listaEquipos = managerCampeonato.findAllEquipo();
	}

	public void actualizarListaEquipos() 
	{
		listaEquipos = managerCampeonato.findAllEquipo();
		for(tbl_Equipos equipo : listaEquipos)
		{
			System.out.println("\n\n\n->"+ equipo.getEqu_nombreOficial());
		}
	}
	
	public String actionEntrarCampeonato(int campId, String Campeonato)
	{
		idCampeonatoSeleccionado=campId;
		actualizarListaEquipos();
		System.out.println("\n\n\nCorrecta captura de ID\n\n\n");
		return "gestionEquiposCampeonato";		
	}
	
	public List<tbl_Equipos> getListaEquipos() {
		return listaEquipos;
	}

	public void setListaEquipos(List<tbl_Equipos> listaEquipos) {
		this.listaEquipos = listaEquipos;
	}

	public int getIdCampeonatoSeleccionado() {
		return idCampeonatoSeleccionado;
	}

	public void setIdCampeonatoSeleccionado(int idCampeonatoSeleccionado) {
		this.idCampeonatoSeleccionado = idCampeonatoSeleccionado;
	}

	public int getIdEquipoSeleccionado() {
		return idEquipoSeleccionado;
	}

	public void setIdEquipoSeleccionado(int idEquipoSeleccionado) {
		this.idEquipoSeleccionado = idEquipoSeleccionado;
	}

	public String getNombreCampeonato() {
		return nombreCampeonato;
	}

	public void setNombreCampeonato(String nombreCampeonato) {
		this.nombreCampeonato = nombreCampeonato;
	}

	
	
	
}
