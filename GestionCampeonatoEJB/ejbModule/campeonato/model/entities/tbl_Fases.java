package campeonato.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the "tbl_Fases" database table.
 * 
 */
@Entity
@Table(name="\"tbl_Fases\"")
@NamedQuery(name="tbl_Fases.findAll", query="SELECT t FROM tbl_Fases t")
public class tbl_Fases implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="fas_id")
	private Integer fasId;

	@Column(name="\"fas_equipo_Local\"")
	private Integer fas_equipo_Local;

	@Column(name="\"fas_equipo_Visitante\"")
	private Integer fas_equipo_Visitante;

	@Temporal(TemporalType.DATE)
	@Column(name="fas_fecha")
	private Date fasFecha;

	@Column(name="\"fas_goles_Local\"")
	private Integer fas_goles_Local;

	@Column(name="\"fas_goles_Visitante\"")
	private Integer fas_goles_Visitante;

	@Column(name="fas_nombre_fase")
	private String fasNombreFase;

	//bi-directional many-to-one association to tbl_Campeonato
	@ManyToOne
	@JoinColumn(name="camp_id")
	private tbl_Campeonato tblCampeonato;

	public tbl_Fases() {
	}

	public Integer getFasId() {
		return this.fasId;
	}

	public void setFasId(Integer fasId) {
		this.fasId = fasId;
	}

	public Integer getFas_equipo_Local() {
		return this.fas_equipo_Local;
	}

	public void setFas_equipo_Local(Integer fas_equipo_Local) {
		this.fas_equipo_Local = fas_equipo_Local;
	}

	public Integer getFas_equipo_Visitante() {
		return this.fas_equipo_Visitante;
	}

	public void setFas_equipo_Visitante(Integer fas_equipo_Visitante) {
		this.fas_equipo_Visitante = fas_equipo_Visitante;
	}

	public Date getFasFecha() {
		return this.fasFecha;
	}

	public void setFasFecha(Date fasFecha) {
		this.fasFecha = fasFecha;
	}

	public Integer getFas_goles_Local() {
		return this.fas_goles_Local;
	}

	public void setFas_goles_Local(Integer fas_goles_Local) {
		this.fas_goles_Local = fas_goles_Local;
	}

	public Integer getFas_goles_Visitante() {
		return this.fas_goles_Visitante;
	}

	public void setFas_goles_Visitante(Integer fas_goles_Visitante) {
		this.fas_goles_Visitante = fas_goles_Visitante;
	}

	public String getFasNombreFase() {
		return this.fasNombreFase;
	}

	public void setFasNombreFase(String fasNombreFase) {
		this.fasNombreFase = fasNombreFase;
	}

	public tbl_Campeonato getTblCampeonato() {
		return this.tblCampeonato;
	}

	public void setTblCampeonato(tbl_Campeonato tblCampeonato) {
		this.tblCampeonato = tblCampeonato;
	}

}