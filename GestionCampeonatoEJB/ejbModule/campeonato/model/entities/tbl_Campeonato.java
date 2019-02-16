package campeonato.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the "tbl_Campeonato" database table.
 * 
 */
@Entity
@Table(name="\"tbl_Campeonato\"")
@NamedQuery(name="tbl_Campeonato.findAll", query="SELECT t FROM tbl_Campeonato t")
public class tbl_Campeonato implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="camp_id")
	private Integer campId;

	@Column(name="\"camp_cantidadEquiposPermitidos\"")
	private Integer camp_cantidadEquiposPermitidos;

	@Column(name="\"camp_cantidadEquiposRegistrados\"")
	private Integer camp_cantidadEquiposRegistrados;

	@Column(name="camp_descripcion")
	private String campDescripcion;

	@Temporal(TemporalType.DATE)
	@Column(name="\"camp_fechaInicio\"")
	private Date camp_fechaInicio;

	@Column(name="camp_nombre")
	private String campNombre;

	//bi-directional many-to-one association to tbl_Equipos
	@OneToMany(mappedBy="tblCampeonato", cascade=CascadeType.ALL)
	private List<tbl_Equipos> tblEquipos;

	//bi-directional many-to-one association to tbl_Fases
	@OneToMany(mappedBy="tblCampeonato")
	private List<tbl_Fases> tblFases;

	//bi-directional many-to-one association to tbl_Partidos
	@OneToMany(mappedBy="tblCampeonato")
	private List<tbl_Partidos> tblPartidos;

	//bi-directional many-to-one association to tbl_ResultadosGrupos
	@OneToMany(mappedBy="tblCampeonato")
	private List<tbl_ResultadosGrupos> tblResultadosGrupos;

	//bi-directional many-to-one association to tlb_Grupos
	@OneToMany(mappedBy="tblCampeonato")
	private List<tlb_Grupos> tlbGrupos;

	public tbl_Campeonato() {
	}

	public Integer getCampId() {
		return this.campId;
	}

	public void setCampId(Integer campId) {
		this.campId = campId;
	}

	public Integer getCamp_cantidadEquiposPermitidos() {
		return this.camp_cantidadEquiposPermitidos;
	}

	public void setCamp_cantidadEquiposPermitidos(Integer camp_cantidadEquiposPermitidos) {
		this.camp_cantidadEquiposPermitidos = camp_cantidadEquiposPermitidos;
	}

	public Integer getCamp_cantidadEquiposRegistrados() {
		return this.camp_cantidadEquiposRegistrados;
	}

	public void setCamp_cantidadEquiposRegistrados(Integer camp_cantidadEquiposRegistrados) {
		this.camp_cantidadEquiposRegistrados = camp_cantidadEquiposRegistrados;
	}

	public String getCampDescripcion() {
		return this.campDescripcion;
	}

	public void setCampDescripcion(String campDescripcion) {
		this.campDescripcion = campDescripcion;
	}

	public Date getCamp_fechaInicio() {
		return this.camp_fechaInicio;
	}

	public void setCamp_fechaInicio(Date camp_fechaInicio) {
		this.camp_fechaInicio = camp_fechaInicio;
	}

	public String getCampNombre() {
		return this.campNombre;
	}

	public void setCampNombre(String campNombre) {
		this.campNombre = campNombre;
	}

	public List<tbl_Equipos> getTblEquipos() {
		return this.tblEquipos;
	}

	public void setTblEquipos(List<tbl_Equipos> tblEquipos) {
		this.tblEquipos = tblEquipos;
	}

	public tbl_Equipos addTblEquipo(tbl_Equipos tblEquipo) {
		getTblEquipos().add(tblEquipo);
		tblEquipo.setTblCampeonato(this);

		return tblEquipo;
	}

	public tbl_Equipos removeTblEquipo(tbl_Equipos tblEquipo) {
		getTblEquipos().remove(tblEquipo);
		tblEquipo.setTblCampeonato(null);

		return tblEquipo;
	}

	public List<tbl_Fases> getTblFases() {
		return this.tblFases;
	}

	public void setTblFases(List<tbl_Fases> tblFases) {
		this.tblFases = tblFases;
	}

	public tbl_Fases addTblFas(tbl_Fases tblFas) {
		getTblFases().add(tblFas);
		tblFas.setTblCampeonato(this);

		return tblFas;
	}

	public tbl_Fases removeTblFas(tbl_Fases tblFas) {
		getTblFases().remove(tblFas);
		tblFas.setTblCampeonato(null);

		return tblFas;
	}

	public List<tbl_Partidos> getTblPartidos() {
		return this.tblPartidos;
	}

	public void setTblPartidos(List<tbl_Partidos> tblPartidos) {
		this.tblPartidos = tblPartidos;
	}

	public tbl_Partidos addTblPartido(tbl_Partidos tblPartido) {
		getTblPartidos().add(tblPartido);
		tblPartido.setTblCampeonato(this);

		return tblPartido;
	}

	public tbl_Partidos removeTblPartido(tbl_Partidos tblPartido) {
		getTblPartidos().remove(tblPartido);
		tblPartido.setTblCampeonato(null);

		return tblPartido;
	}

	public List<tbl_ResultadosGrupos> getTblResultadosGrupos() {
		return this.tblResultadosGrupos;
	}

	public void setTblResultadosGrupos(List<tbl_ResultadosGrupos> tblResultadosGrupos) {
		this.tblResultadosGrupos = tblResultadosGrupos;
	}

	public tbl_ResultadosGrupos addTblResultadosGrupo(tbl_ResultadosGrupos tblResultadosGrupo) {
		getTblResultadosGrupos().add(tblResultadosGrupo);
		tblResultadosGrupo.setTblCampeonato(this);

		return tblResultadosGrupo;
	}

	public tbl_ResultadosGrupos removeTblResultadosGrupo(tbl_ResultadosGrupos tblResultadosGrupo) {
		getTblResultadosGrupos().remove(tblResultadosGrupo);
		tblResultadosGrupo.setTblCampeonato(null);

		return tblResultadosGrupo;
	}

	public List<tlb_Grupos> getTlbGrupos() {
		return this.tlbGrupos;
	}

	public void setTlbGrupos(List<tlb_Grupos> tlbGrupos) {
		this.tlbGrupos = tlbGrupos;
	}

	public tlb_Grupos addTlbGrupo(tlb_Grupos tlbGrupo) {
		getTlbGrupos().add(tlbGrupo);
		tlbGrupo.setTblCampeonato(this);

		return tlbGrupo;
	}

	public tlb_Grupos removeTlbGrupo(tlb_Grupos tlbGrupo) {
		getTlbGrupos().remove(tlbGrupo);
		tlbGrupo.setTblCampeonato(null);

		return tlbGrupo;
	}

}