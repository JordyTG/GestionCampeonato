package campeonato.model.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the "tbl_ResultadosGrupos" database table.
 * 
 */
@Entity
@Table(name="\"tbl_ResultadosGrupos\"")
@NamedQuery(name="tbl_ResultadosGrupos.findAll", query="SELECT t FROM tbl_ResultadosGrupos t")
public class tbl_ResultadosGrupos implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="resg_id")
	private Integer resgId;

	@Column(name="grup_cod")
	private String grupCod;

	@Column(name="\"resg_numGolesCotra\"")
	private Integer resg_numGolesCotra;

	@Column(name="\"resg_numGolesFavor\"")
	private Integer resg_numGolesFavor;

	@Column(name="\"resg_numPartidosEmpatados\"")
	private Integer resg_numPartidosEmpatados;

	@Column(name="\"resg_numPartidosGanados\"")
	private Integer resg_numPartidosGanados;

	@Column(name="\"resg_numPartidosPerdidos\"")
	private Integer resg_numPartidosPerdidos;

	@Column(name="resg_puntaje")
	private Integer resgPuntaje;

	//bi-directional many-to-one association to tbl_Campeonato
	@ManyToOne
	@JoinColumn(name="camp_id")
	private tbl_Campeonato tblCampeonato;

	//bi-directional many-to-one association to tbl_Equipos
	@ManyToOne
	@JoinColumn(name="equi_id")
	private tbl_Equipos tblEquipo;

	public tbl_ResultadosGrupos() {
	}

	public Integer getResgId() {
		return this.resgId;
	}

	public void setResgId(Integer resgId) {
		this.resgId = resgId;
	}

	public String getGrupCod() {
		return this.grupCod;
	}

	public void setGrupCod(String grupCod) {
		this.grupCod = grupCod;
	}

	public Integer getResg_numGolesCotra() {
		return this.resg_numGolesCotra;
	}

	public void setResg_numGolesCotra(Integer resg_numGolesCotra) {
		this.resg_numGolesCotra = resg_numGolesCotra;
	}

	public Integer getResg_numGolesFavor() {
		return this.resg_numGolesFavor;
	}

	public void setResg_numGolesFavor(Integer resg_numGolesFavor) {
		this.resg_numGolesFavor = resg_numGolesFavor;
	}

	public Integer getResg_numPartidosEmpatados() {
		return this.resg_numPartidosEmpatados;
	}

	public void setResg_numPartidosEmpatados(Integer resg_numPartidosEmpatados) {
		this.resg_numPartidosEmpatados = resg_numPartidosEmpatados;
	}

	public Integer getResg_numPartidosGanados() {
		return this.resg_numPartidosGanados;
	}

	public void setResg_numPartidosGanados(Integer resg_numPartidosGanados) {
		this.resg_numPartidosGanados = resg_numPartidosGanados;
	}

	public Integer getResg_numPartidosPerdidos() {
		return this.resg_numPartidosPerdidos;
	}

	public void setResg_numPartidosPerdidos(Integer resg_numPartidosPerdidos) {
		this.resg_numPartidosPerdidos = resg_numPartidosPerdidos;
	}

	public Integer getResgPuntaje() {
		return this.resgPuntaje;
	}

	public void setResgPuntaje(Integer resgPuntaje) {
		this.resgPuntaje = resgPuntaje;
	}

	public tbl_Campeonato getTblCampeonato() {
		return this.tblCampeonato;
	}

	public void setTblCampeonato(tbl_Campeonato tblCampeonato) {
		this.tblCampeonato = tblCampeonato;
	}

	public tbl_Equipos getTblEquipo() {
		return this.tblEquipo;
	}

	public void setTblEquipo(tbl_Equipos tblEquipo) {
		this.tblEquipo = tblEquipo;
	}

}