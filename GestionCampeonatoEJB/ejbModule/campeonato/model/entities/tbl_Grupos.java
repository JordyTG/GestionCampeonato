package campeonato.model.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the "tbl_Grupos" database table.
 * 
 */
@Entity
@Table(name="\"tbl_Grupos\"")
@NamedQuery(name="tbl_Grupos.findAll", query="SELECT t FROM tbl_Grupos t")
public class tbl_Grupos implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="grup_id")
	private Integer grupId;

	@Column(name="grup_cod")
	private String grupCod;

	@Column(name="grup_nombre")
	private String grupNombre;

	//bi-directional many-to-one association to tbl_Campeonato
	@ManyToOne
	@JoinColumn(name="camp_id")
	private tbl_Campeonato tblCampeonato;

	//bi-directional many-to-one association to tbl_Equipos
	@ManyToOne
	@JoinColumn(name="equ_id")
	private tbl_Equipos tblEquipo;

	public tbl_Grupos() {
	}

	public Integer getGrupId() {
		return this.grupId;
	}

	public void setGrupId(Integer grupId) {
		this.grupId = grupId;
	}

	public String getGrupCod() {
		return this.grupCod;
	}

	public void setGrupCod(String grupCod) {
		this.grupCod = grupCod;
	}

	public String getGrupNombre() {
		return this.grupNombre;
	}

	public void setGrupNombre(String grupNombre) {
		this.grupNombre = grupNombre;
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