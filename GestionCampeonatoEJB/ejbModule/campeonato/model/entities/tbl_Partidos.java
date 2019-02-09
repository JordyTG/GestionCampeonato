package campeonato.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the "tbl_Partidos" database table.
 * 
 */
@Entity
@Table(name="\"tbl_Partidos\"")
@NamedQuery(name="tbl_Partidos.findAll", query="SELECT t FROM tbl_Partidos t")
public class tbl_Partidos implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="par_id")
	private Integer parId;

	@Column(name="\"equ_id_L\"")
	private Integer equ_id_L;

	@Column(name="\"equ_id_V\"")
	private Integer equ_id_V;

	@Column(name="par_arbitro")
	private String parArbitro;

	@Column(name="\"par_equipoLocal\"")
	private String par_equipoLocal;

	@Column(name="\"par_equipoVisitante\"")
	private String par_equipoVisitante;

	@Column(name="par_estadio")
	private Integer parEstadio;

	@Temporal(TemporalType.DATE)
	@Column(name="par_fecha")
	private Date parFecha;

	@Column(name="\"par_golesLocales\"")
	private String par_golesLocales;

	@Column(name="\"par_golesVisitante\"")
	private String par_golesVisitante;

	@Column(name="par_hora")
	private String parHora;

	//bi-directional many-to-one association to tbl_Campeonato
	@ManyToOne
	@JoinColumn(name="camp_id")
	private tbl_Campeonato tblCampeonato;

	//bi-directional many-to-one association to tbl_Equipos
	@ManyToOne
	@JoinColumns({
		})
	private tbl_Equipos tblEquipo1;

	//bi-directional many-to-one association to tbl_Equipos
	@ManyToOne
	@JoinColumns({
		})
	private tbl_Equipos tblEquipo2;

	public tbl_Partidos() {
	}

	public Integer getParId() {
		return this.parId;
	}

	public void setParId(Integer parId) {
		this.parId = parId;
	}

	public Integer getEqu_id_L() {
		return this.equ_id_L;
	}

	public void setEqu_id_L(Integer equ_id_L) {
		this.equ_id_L = equ_id_L;
	}

	public Integer getEqu_id_V() {
		return this.equ_id_V;
	}

	public void setEqu_id_V(Integer equ_id_V) {
		this.equ_id_V = equ_id_V;
	}

	public String getParArbitro() {
		return this.parArbitro;
	}

	public void setParArbitro(String parArbitro) {
		this.parArbitro = parArbitro;
	}

	public String getPar_equipoLocal() {
		return this.par_equipoLocal;
	}

	public void setPar_equipoLocal(String par_equipoLocal) {
		this.par_equipoLocal = par_equipoLocal;
	}

	public String getPar_equipoVisitante() {
		return this.par_equipoVisitante;
	}

	public void setPar_equipoVisitante(String par_equipoVisitante) {
		this.par_equipoVisitante = par_equipoVisitante;
	}

	public Integer getParEstadio() {
		return this.parEstadio;
	}

	public void setParEstadio(Integer parEstadio) {
		this.parEstadio = parEstadio;
	}

	public Date getParFecha() {
		return this.parFecha;
	}

	public void setParFecha(Date parFecha) {
		this.parFecha = parFecha;
	}

	public String getPar_golesLocales() {
		return this.par_golesLocales;
	}

	public void setPar_golesLocales(String par_golesLocales) {
		this.par_golesLocales = par_golesLocales;
	}

	public String getPar_golesVisitante() {
		return this.par_golesVisitante;
	}

	public void setPar_golesVisitante(String par_golesVisitante) {
		this.par_golesVisitante = par_golesVisitante;
	}

	public String getParHora() {
		return this.parHora;
	}

	public void setParHora(String parHora) {
		this.parHora = parHora;
	}

	public tbl_Campeonato getTblCampeonato() {
		return this.tblCampeonato;
	}

	public void setTblCampeonato(tbl_Campeonato tblCampeonato) {
		this.tblCampeonato = tblCampeonato;
	}

	public tbl_Equipos getTblEquipo1() {
		return this.tblEquipo1;
	}

	public void setTblEquipo1(tbl_Equipos tblEquipo1) {
		this.tblEquipo1 = tblEquipo1;
	}

	public tbl_Equipos getTblEquipo2() {
		return this.tblEquipo2;
	}

	public void setTblEquipo2(tbl_Equipos tblEquipo2) {
		this.tblEquipo2 = tblEquipo2;
	}

}