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

	@Column(name="\"equ_nombrePresidente\"")
	private String equ_nombrePresidente;

	@Column(name="\"equ_paginaWeb\"")
	private String equ_paginaWeb;

	@Column(name="equ_seudonimo")
	private String equSeudonimo;

	//bi-directional many-to-one association to tbl_Campeonato
	@ManyToOne
	@JoinColumn(name="camp_id")
	private tbl_Campeonato tblCampeonato;

	//bi-directional many-to-one association to tbl_Jugadores
	@OneToMany(mappedBy="tblEquipo")
	private List<tbl_Jugadores> tblJugadores;

	//bi-directional many-to-one association to tbl_ResultadosGrupos
	@OneToMany(mappedBy="tblEquipo")
	private List<tbl_ResultadosGrupos> tblResultadosGrupos;

	//bi-directional many-to-one association to tlb_Grupos
	@OneToMany(mappedBy="tblEquipo")
	private List<tlb_Grupos> tlbGrupos;

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

	public String getEqu_nombrePresidente() {
		return this.equ_nombrePresidente;
	}

	public void setEqu_nombrePresidente(String equ_nombrePresidente) {
		this.equ_nombrePresidente = equ_nombrePresidente;
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

	public List<tlb_Grupos> getTlbGrupos() {
		return this.tlbGrupos;
	}

	public void setTlbGrupos(List<tlb_Grupos> tlbGrupos) {
		this.tlbGrupos = tlbGrupos;
	}

	public tlb_Grupos addTlbGrupo(tlb_Grupos tlbGrupo) {
		getTlbGrupos().add(tlbGrupo);
		tlbGrupo.setTblEquipo(this);

		return tlbGrupo;
	}

	public tlb_Grupos removeTlbGrupo(tlb_Grupos tlbGrupo) {
		getTlbGrupos().remove(tlbGrupo);
		tlbGrupo.setTblEquipo(null);

		return tlbGrupo;
	}

}