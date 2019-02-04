package campeonato.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the "tbl_Persona" database table.
 * 
 */
@Entity
@Table(name="\"tbl_Persona\"")
@NamedQuery(name="tbl_Persona.findAll", query="SELECT t FROM tbl_Persona t")
public class tbl_Persona implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="per_id")
	private Integer perId;

	@Column(name="per_apellidos")
	private String perApellidos;

	@Column(name="per_cedula")
	private String perCedula;

	@Column(name="per_direccion")
	private String perDireccion;

	@Column(name="per_email")
	private String perEmail;

	@Column(name="per_nombres")
	private String perNombres;

	@Column(name="per_telefono")
	private String perTelefono;

	//bi-directional many-to-one association to tbl_Equipos
	@OneToMany(mappedBy="tblPersona")
	private List<tbl_Equipos> tblEquipos;

	//bi-directional many-to-one association to tbl_Jugadores
	@OneToMany(mappedBy="tblPersona")
	private List<tbl_Jugadores> tblJugadores;

	//bi-directional many-to-one association to tbl_TipoPersona
	@ManyToOne
	@JoinColumn(name="tiper_id")
	private tbl_TipoPersona tblTipoPersona;

	public tbl_Persona() {
	}

	public Integer getPerId() {
		return this.perId;
	}

	public void setPerId(Integer perId) {
		this.perId = perId;
	}

	public String getPerApellidos() {
		return this.perApellidos;
	}

	public void setPerApellidos(String perApellidos) {
		this.perApellidos = perApellidos;
	}

	public String getPerCedula() {
		return this.perCedula;
	}

	public void setPerCedula(String perCedula) {
		this.perCedula = perCedula;
	}

	public String getPerDireccion() {
		return this.perDireccion;
	}

	public void setPerDireccion(String perDireccion) {
		this.perDireccion = perDireccion;
	}

	public String getPerEmail() {
		return this.perEmail;
	}

	public void setPerEmail(String perEmail) {
		this.perEmail = perEmail;
	}

	public String getPerNombres() {
		return this.perNombres;
	}

	public void setPerNombres(String perNombres) {
		this.perNombres = perNombres;
	}

	public String getPerTelefono() {
		return this.perTelefono;
	}

	public void setPerTelefono(String perTelefono) {
		this.perTelefono = perTelefono;
	}

	public List<tbl_Equipos> getTblEquipos() {
		return this.tblEquipos;
	}

	public void setTblEquipos(List<tbl_Equipos> tblEquipos) {
		this.tblEquipos = tblEquipos;
	}

	public tbl_Equipos addTblEquipo(tbl_Equipos tblEquipo) {
		getTblEquipos().add(tblEquipo);
		tblEquipo.setTblPersona(this);

		return tblEquipo;
	}

	public tbl_Equipos removeTblEquipo(tbl_Equipos tblEquipo) {
		getTblEquipos().remove(tblEquipo);
		tblEquipo.setTblPersona(null);

		return tblEquipo;
	}

	public List<tbl_Jugadores> getTblJugadores() {
		return this.tblJugadores;
	}

	public void setTblJugadores(List<tbl_Jugadores> tblJugadores) {
		this.tblJugadores = tblJugadores;
	}

	public tbl_Jugadores addTblJugadore(tbl_Jugadores tblJugadore) {
		getTblJugadores().add(tblJugadore);
		tblJugadore.setTblPersona(this);

		return tblJugadore;
	}

	public tbl_Jugadores removeTblJugadore(tbl_Jugadores tblJugadore) {
		getTblJugadores().remove(tblJugadore);
		tblJugadore.setTblPersona(null);

		return tblJugadore;
	}

	public tbl_TipoPersona getTblTipoPersona() {
		return this.tblTipoPersona;
	}

	public void setTblTipoPersona(tbl_TipoPersona tblTipoPersona) {
		this.tblTipoPersona = tblTipoPersona;
	}

}