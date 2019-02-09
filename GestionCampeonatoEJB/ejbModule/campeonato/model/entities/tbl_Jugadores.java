package campeonato.model.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the "tbl_Jugadores" database table.
 * 
 */
@Entity
@Table(name="\"tbl_Jugadores\"")
@NamedQuery(name="tbl_Jugadores.findAll", query="SELECT t FROM tbl_Jugadores t")
public class tbl_Jugadores implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="jug_id")
	private Integer jugId;

	@Column(name="jug_apellidos")
	private String jugApellidos;

	@Column(name="jug_cedula")
	private String jugCedula;

	@Column(name="jug_foto")
	private byte[] jugFoto;

	@Column(name="jug_nacionalidad")
	private String jugNacionalidad;

	@Column(name="jug_nombres")
	private Integer jugNombres;

	@Column(name="jug_numero")
	private String jugNumero;

	@Column(name="jug_observacion")
	private String jugObservacion;

	@Column(name="jug_posicion")
	private String jugPosicion;

	@Column(name="jug_suspendido")
	private String jugSuspendido;

	@Column(name="\"jug_tarjetasAmarillas\"")
	private String jug_tarjetasAmarillas;

	@Column(name="\"jug_tarjetasRojas\"")
	private String jug_tarjetasRojas;

	@Column(name="jug_telefono")
	private String jugTelefono;

	//bi-directional many-to-one association to tbl_Equipos
	@ManyToOne
	@JoinColumn(name="equ_id")
	private tbl_Equipos tblEquipo;

	public tbl_Jugadores() {
	}

	public Integer getJugId() {
		return this.jugId;
	}

	public void setJugId(Integer jugId) {
		this.jugId = jugId;
	}

	public String getJugApellidos() {
		return this.jugApellidos;
	}

	public void setJugApellidos(String jugApellidos) {
		this.jugApellidos = jugApellidos;
	}

	public String getJugCedula() {
		return this.jugCedula;
	}

	public void setJugCedula(String jugCedula) {
		this.jugCedula = jugCedula;
	}

	public byte[] getJugFoto() {
		return this.jugFoto;
	}

	public void setJugFoto(byte[] jugFoto) {
		this.jugFoto = jugFoto;
	}

	public String getJugNacionalidad() {
		return this.jugNacionalidad;
	}

	public void setJugNacionalidad(String jugNacionalidad) {
		this.jugNacionalidad = jugNacionalidad;
	}

	public Integer getJugNombres() {
		return this.jugNombres;
	}

	public void setJugNombres(Integer jugNombres) {
		this.jugNombres = jugNombres;
	}

	public String getJugNumero() {
		return this.jugNumero;
	}

	public void setJugNumero(String jugNumero) {
		this.jugNumero = jugNumero;
	}

	public String getJugObservacion() {
		return this.jugObservacion;
	}

	public void setJugObservacion(String jugObservacion) {
		this.jugObservacion = jugObservacion;
	}

	public String getJugPosicion() {
		return this.jugPosicion;
	}

	public void setJugPosicion(String jugPosicion) {
		this.jugPosicion = jugPosicion;
	}

	public String getJugSuspendido() {
		return this.jugSuspendido;
	}

	public void setJugSuspendido(String jugSuspendido) {
		this.jugSuspendido = jugSuspendido;
	}

	public String getJug_tarjetasAmarillas() {
		return this.jug_tarjetasAmarillas;
	}

	public void setJug_tarjetasAmarillas(String jug_tarjetasAmarillas) {
		this.jug_tarjetasAmarillas = jug_tarjetasAmarillas;
	}

	public String getJug_tarjetasRojas() {
		return this.jug_tarjetasRojas;
	}

	public void setJug_tarjetasRojas(String jug_tarjetasRojas) {
		this.jug_tarjetasRojas = jug_tarjetasRojas;
	}

	public String getJugTelefono() {
		return this.jugTelefono;
	}

	public void setJugTelefono(String jugTelefono) {
		this.jugTelefono = jugTelefono;
	}

	public tbl_Equipos getTblEquipo() {
		return this.tblEquipo;
	}

	public void setTblEquipo(tbl_Equipos tblEquipo) {
		this.tblEquipo = tblEquipo;
	}

}