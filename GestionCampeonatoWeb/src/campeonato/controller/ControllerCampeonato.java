package campeonato.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.validation.constraints.Email;

import campeonato.model.entities.*;
import campeonato.model.manager.CampeonatoManager;
import campeonato.view.util.JSFUtil;

@ManagedBean
@SessionScoped
public class ControllerCampeonato {


	private int idCampeonatoSeleccionado;
	private List<tbl_Campeonato> lista;
	private tbl_Campeonato Campeonato;
	private tbl_Equipos Equipo;
	private String accion;
	
	
	@EJB
	private CampeonatoManager managerCampeonato;

	@PostConstruct
	public void inicializar() {
		
		lista = managerCampeonato.findAllCampeonatos();
		accion = "crear";
		
		Campeonato=new tbl_Campeonato();
		Campeonato.setCamp_fechaInicio(getFechaActual());
		Campeonato.setCamp_cantidadEquiposPermitidos(32);
		Campeonato.setCamp_cantidadEquiposRegistrados(0);
		Campeonato.setTblEquipos(new ArrayList<tbl_Equipos>());
		Equipo=new tbl_Equipos();
		
	}


	
	public void actionListenerNuevoCampeonato() {
		inicializar();
	}

	public void actionListenerGuardarCampeonato() {
		try {
			if (Campeonato.getCamp_cantidadEquiposPermitidos() < Campeonato.getCamp_cantidadEquiposRegistrados()) {
				JSFUtil.crearMensajeInfo("Los equipos Permitidos son menores a los equipos Registrados");
			}else 
			{
				managerCampeonato.guardarCampeonato(Campeonato, accion);
				lista = managerCampeonato.findAllCampeonatos();
				JSFUtil.crearMensajeInfo("Campeonato registrado.");
				inicializar();
			} 

		} catch (Exception e) {
			JSFUtil.crearMensajeError(e.getMessage());
			e.printStackTrace();
		}
		
	}

	
	public void actionListeneragregarEquipo()
	{
		try {
		
		Campeonato=managerCampeonato.agregarEquipo(Campeonato, Equipo);
		Equipo=new tbl_Equipos();
		
		} catch (Exception e) {
			JSFUtil.crearMensajeError(e.getMessage());
			e.printStackTrace();
		}
	}
	
	
	public void actionListenerRemoverEquipo(tbl_Equipos obj)
	{
		managerCampeonato.removerEquipo(Campeonato, obj);
	}
	
	public void actionListenerEliminar(int id) {
		try {
			managerCampeonato.eliminarCampeonato(id);
			lista = managerCampeonato.findAllCampeonatos();
			JSFUtil.crearMensajeInfo("Eliminado.");
		} catch (Exception e) {
			JSFUtil.crearMensajeError(e.getMessage());
			e.printStackTrace();
		}
	}

	public void actionListenerActualizarCampeonato() {
		try {
			if (Campeonato.getCamp_cantidadEquiposPermitidos() < Campeonato.getCamp_cantidadEquiposRegistrados()) {
				JSFUtil.crearMensajeInfo("Los equipos Permitidos son menores a los equipos Registrados");
			} else {
				managerCampeonato.editarCampeonato(Campeonato);
				Campeonato=managerCampeonato.findCampeonato(Campeonato.getCampId());
				lista = managerCampeonato.findAllCampeonatos();
				JSFUtil.crearMensajeInfo("Actualización correcta.");
			}
		} catch (Exception e) {
			JSFUtil.crearMensajeError(e.getMessage());
			e.printStackTrace();
		}
	}

	public void actionListenerCargarCampeonato() {
		try {
		Campeonato=managerCampeonato.findCampeonato(idCampeonatoSeleccionado);
		accion="editar";
		}catch (Exception e) {
			JSFUtil.crearMensajeError(e.getMessage());
			e.printStackTrace();
		}
	}
	
	
	public void actionListenerCargarEquipo(tbl_Equipos equipo)
	{
		Equipo = equipo;
	}
	
	public void actionListenerActualizarEquipo() 
	{
		try 
		{
			managerCampeonato.editarEquipo(Equipo);
		}catch(Exception ex) 
		{
			JSFUtil.crearMensajeError(ex.getMessage());
		}
	}

	public Date getFechaActual() 
	{
		GregorianCalendar c = new GregorianCalendar();
		Date fechaActual = c.getTime();
		return fechaActual;
	}

	public int getIdCampeonatoSeleccionado() {
		return idCampeonatoSeleccionado;
	}

	public void setIdCampeonatoSeleccionado(int idCampeonatoSeleccionado) {
		this.idCampeonatoSeleccionado = idCampeonatoSeleccionado;
	}

	public List<tbl_Campeonato> getLista() {
		return lista;
	}

	public void setLista(List<tbl_Campeonato> lista) {
		this.lista = lista;
	}

	public tbl_Campeonato getCampeonato() {
		return Campeonato;
	}

	public void setCampeonato(tbl_Campeonato campeonato) {
		Campeonato = campeonato;
	}

	public tbl_Equipos getEquipo() {
		return Equipo;
	}

	public void setEquipo(tbl_Equipos equipo) {
		Equipo = equipo;
	}



	public String getAccion() {
		return accion;
	}

	public void setAccion(String accion) {
		this.accion = accion;
	}

}
