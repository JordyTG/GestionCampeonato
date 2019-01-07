package campeonato.controller;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import campeonato.model.entities.tbl_Campeonato;
import campeonato.model.manager.CampeonatoManager;
import campeonato.view.util.JSFUtil;

@ManagedBean
@SessionScoped
public class ControllerCampeonato {
	private int id;
	private Date fecha;
	private String nombre;
	private String descripcion;
	private int equiposPermitidos;
	private int equiposRegistrados;

	private List<tbl_Campeonato> lista;
	@EJB
	private CampeonatoManager managerCampeonato;

	@PostConstruct
	public void inicializar() {
		lista = managerCampeonato.findAllCampeonatos();
		fecha = getFechaActual();
		equiposPermitidos = 32;
	}

	public void actionListenerReset() {
		lista = managerCampeonato.findAllCampeonatos();
	}

	public void actionListenerAgregar() {
		try {
			managerCampeonato.agregarCampeonato(nombre, descripcion, fecha, equiposPermitidos);
			lista = managerCampeonato.findAllCampeonatos();
			JSFUtil.crearMensajeInfo("Campeonato registrado.");
		} catch (Exception e) {
			JSFUtil.crearMensajeError(e.getMessage());
			e.printStackTrace();
		}
		nombre = "";
		descripcion = "";
		equiposPermitidos = 32;
		fecha = getFechaActual();

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

	public void actionListenerActualizar() {
		try {
			if (equiposPermitidos < equiposRegistrados) {
				JSFUtil.crearMensajeInfo("Los equipos Permitidos son menores a los equipos Registrados");
			} else {
				managerCampeonato.editarCampeonato(id, nombre, descripcion, fecha, equiposPermitidos);
				lista = managerCampeonato.findAllCampeonatos();
				JSFUtil.crearMensajeInfo("Actualización correcta.");
			}
		} catch (Exception e) {
			JSFUtil.crearMensajeError(e.getMessage());
			e.printStackTrace();
		}
	}

	public void actionListenerCargar(tbl_Campeonato objeto) {
		id = objeto.getCampId();
		fecha = objeto.getCamp_fechaInicio();
		nombre = objeto.getCampNombre();
		descripcion = objeto.getCampDescripcion();
		equiposRegistrados = objeto.getCamp_cantidadEquiposRegistrados();
	}

	public Date getFechaActual() {
		GregorianCalendar c = new GregorianCalendar();
		Date fechaActual = c.getTime();
		return fechaActual;
	}

	public int getEquiposPermitidos() {
		return equiposPermitidos;
	}

	public void setEquiposPermitidos(int equiposPermitidos) {
		this.equiposPermitidos = equiposPermitidos;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<tbl_Campeonato> getLista() {
		return lista;
	}

	public void setLista(List<tbl_Campeonato> lista) {
		this.lista = lista;
	}

	public int getEquiposRegistrados() {
		return equiposRegistrados;
	}

	public void setEquiposRegistrados(int equiposRegistrados) {
		this.equiposRegistrados = equiposRegistrados;
	}

}
