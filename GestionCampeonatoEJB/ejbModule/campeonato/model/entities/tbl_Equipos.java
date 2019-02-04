package campeonato.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the "tbl_Equipos" database table.
 * 
 */
@Entity
@Table(name="\"tbl_Equipos\"")
@NamedQuery(name="tbl_Equipos.findAll", query="SELECT t FROM tbl_Equipos t")
public class tbl_Equipos implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="equ_id")
	private Integer equId;

	@Column(name="equ_ciudad")
	private String equCiudad;

	@Column(name="equ_direccion")
	private String equDireccion;

	@Column(name="equ_escudo")
	private byte[] equEscudo;

	@Temporal(TemporalType.DATE)
	@Column(name="\"equ_fechaFundacion\"")
	private Date equ_fechaFundacion;

	@Column(name="\"equ_nombreOficial\"")
	private String equ_nombreOficial;

	@Column(name="\"equ_paginaWeb\"")
	private String equ_paginaWeb;

	@Column(name="equ_seudonimo")
	private String equSeudonimo;

	//bi-directional many-to-one association to tbl_Campeonato
	@ManyToOne
	@JoinColumn(name="camp_id")
	private tbl_Campeonato tblCampeonato;

	//bi-directional many-to-one association to tbl_Persona
	@ManyToOne
	@JoinColumn(name="equ_presidente_id")
	private tbl_Persona tblPersona;

	//bi-directional many-to-one association to tbl_Grupos
	@OneToMany(mappedBy="tblEquipo")
	private List<tbl_Grupos> tblGrupos;

	//bi-directional many-to-one association to tbl_Jugadores
	@OneToMany(mappedBy="tblEquipo")
	private List<tbl_Jugadores> tblJugadores;

	//bi-directional many-to-one association to tbl_Partidos
	@OneToMany(mappedBy="tblEquipo1")
	private List<tbl_Partidos> tblPartidos1;

	//bi-directional many-to-one association to tbl_Partidos
	@OneToMany(mappedBy="tblEquipo2")
	private List<tbl_Partidos> tblPartidos2;

	//bi-directional many-to-one association to tbl_ResultadosGrupos
	@OneToMany(mappedBy="tblEquipo")
	private List<tbl_ResultadosGrupos> tblResultadosGrupos;

	public tbl_Equipos() {
	}

	public Integer getEquId() {
		return this.equId;
	}

	public void setEquId(Integer equId) {
		this.equId = equId;
	}

	public String getEquCiudad() {
		return this.equCiudad;
	}

	public void setEquCiudad(String equCiudad) {
		this.equCiudad = equCiudad;
	}

	public String getEquDireccion() {
		return this.equDireccion;
	}

	public void setEquDireccion(String equDireccion) {
		this.equDireccion = equDireccion;
	}

	public byte[] getEquEscudo() {
		return this.equEscudo;
	}

	public void setEquEscudo(byte[] equEscudo) {
		this.equEscudo = equEscudo;
	}

	public Date getEqu_fechaFundacion() {
		return this.equ_fechaFundacion;
	}

	public void setEqu_fechaFundacion(Date equ_fechaFundacion) {
		this.equ_fechaFundacion = equ_fechaFundacion;
	}

	public String getEqu_nombreOficial() {
		return this.equ_nombreOficial;
	}

	public void setEqu_nombreOficial(String equ_nombreOficial) {
		this.equ_nombreOficial = equ_nombreOficial;
	}

	public String getEqu_paginaWeb() {
		return this.equ_paginaWeb;
	}

	public void setEqu_paginaWeb(String equ_paginaWeb) {
		this.equ_paginaWeb = equ_paginaWeb;
	}

	public String getEquSeudonimo() {
		return this.equSeudonimo;
	}

	public void setEquSeudonimo(String equSeudonimo) {
		this.equSeudonimo = equSeudonimo;
	}

	public tbl_Campeonato getTblCampeonato() {
		return this.tblCampeonato;
	}

	public void setTblCampeonato(tbl_Campeonato tblCampeonato) {
		this.tblCampeonato = tblCampeonato;
	}

	public tbl_Persona getTblPersona() {
		return this.tblPersona;
	}

	public void setTblPersona(tbl_Persona tblPersona) {
		this.tblPersona = tblPersona;
	}

	public List<tbl_Grupos> getTblGrupos() {
		return this.tblGrupos;
	}

	public void setTblGrupos(List<tbl_Grupos> tblGrupos) {
		this.tblGrupos = tblGrupos;
	}

	public tbl_Grupos addTblGrupo(tbl_Grupos tblGrupo) {
		getTblGrupos().add(tblGrupo);
		tblGrupo.setTblEquipo(this);

		return tblGrupo;
	}

	public tbl_Grupos removeTblGrupo(tbl_Grupos tblGrupo) {
		getTblGrupos().remove(tblGrupo);
		tblGrupo.setTblEquipo(null);

		return tblGrupo;
	}

	public List<tbl_Jugadores> getTblJugadores() {
		return this.tblJugadores;
	}

	public void setTblJugadores(List<tbl_Jugadores> tblJugadores) {
		this.tblJugadores = tblJugadores;
	}

	public tbl_Jugadores addTblJugadore(tbl_Jugadores tblJugadore) {
		getTblJugadores().add(tblJugadore);
		tblJugadore.setTblEquipo(this);

		return tblJugadore;
	}

	public tbl_Jugadores removeTblJugadore(tbl_Jugadores tblJugadore) {
		getTblJugadores().remove(tblJugadore);
		tblJugadore.setTblEquipo(null);

		return tblJugadore;
	}

	public List<tbl_Partidos> getTblPartidos1() {
		return this.tblPartidos1;
	}

	public void setTblPartidos1(List<tbl_Partidos> tblPartidos1) {
		this.tblPartidos1 = tblPartidos1;
	}

	public tbl_Partidos addTblPartidos1(tbl_Partidos tblPartidos1) {
		getTblPartidos1().add(tblPartidos1);
		tblPartidos1.setTblEquipo1(this);

		return tblPartidos1;
	}

	public tbl_Partidos removeTblPartidos1(tbl_Partidos tblPartidos1) {
		getTblPartidos1().remove(tblPartidos1);
		tblPartidos1.setTblEquipo1(null);

		return tblPartidos1;
	}

	public List<tbl_Partidos> getTblPartidos2() {
		return this.tblPartidos2;
	}

	public void setTblPartidos2(List<tbl_Partidos> tblPartidos2) {
		this.tblPartidos2 = tblPartidos2;
	}

	public tbl_Partidos addTblPartidos2(tbl_Partidos tblPartidos2) {
		getTblPartidos2().add(tblPartidos2);
		tblPartidos2.setTblEquipo2(this);

		return tblPartidos2;
	}

	public tbl_Partidos removeTblPartidos2(tbl_Partidos tblPartidos2) {
		getTblPartidos2().remove(tblPartidos2);
		tblPartidos2.setTblEquipo2(null);

		return tblPartidos2;
	}

	public List<tbl_ResultadosGrupos> getTblResultadosGrupos() {
		return this.tblResultadosGrupos;
	}

	public void setTblResultadosGrupos(List<tbl_ResultadosGrupos> tblResultadosGrupos) {
		this.tblResultadosGrupos = tblResultadosGrupos;
	}

	public tbl_ResultadosGrupos addTblResultadosGrupo(tbl_ResultadosGrupos tblResultadosGrupo) {
		getTblResultadosGrupos().add(tblResultadosGrupo);
		tblResultadosGrupo.setTblEquipo(this);

		return tblResultadosGrupo;
	}

	public tbl_ResultadosGrupos removeTblResultadosGrupo(tbl_ResultadosGrupos tblResultadosGrupo) {
		getTblResultadosGrupos().remove(tblResultadosGrupo);
		tblResultadosGrupo.setTblEquipo(null);

		return tblResultadosGrupo;
	}

}