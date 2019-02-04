package campeonato.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the "tbl_TipoPersona" database table.
 * 
 */
@Entity
@Table(name="\"tbl_TipoPersona\"")
@NamedQuery(name="tbl_TipoPersona.findAll", query="SELECT t FROM tbl_TipoPersona t")
public class tbl_TipoPersona implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="tiper_id")
	private Integer tiperId;

	@Column(name="tiper_observacion")
	private String tiperObservacion;

	@Column(name="tiper_tipo")
	private String tiperTipo;

	//bi-directional many-to-one association to tbl_Persona
	@OneToMany(mappedBy="tblTipoPersona")
	private List<tbl_Persona> tblPersonas;

	public tbl_TipoPersona() {
	}

	public Integer getTiperId() {
		return this.tiperId;
	}

	public void setTiperId(Integer tiperId) {
		this.tiperId = tiperId;
	}

	public String getTiperObservacion() {
		return this.tiperObservacion;
	}

	public void setTiperObservacion(String tiperObservacion) {
		this.tiperObservacion = tiperObservacion;
	}

	public String getTiperTipo() {
		return this.tiperTipo;
	}

	public void setTiperTipo(String tiperTipo) {
		this.tiperTipo = tiperTipo;
	}

	public List<tbl_Persona> getTblPersonas() {
		return this.tblPersonas;
	}

	public void setTblPersonas(List<tbl_Persona> tblPersonas) {
		this.tblPersonas = tblPersonas;
	}

	public tbl_Persona addTblPersona(tbl_Persona tblPersona) {
		getTblPersonas().add(tblPersona);
		tblPersona.setTblTipoPersona(this);

		return tblPersona;
	}

	public tbl_Persona removeTblPersona(tbl_Persona tblPersona) {
		getTblPersonas().remove(tblPersona);
		tblPersona.setTblTipoPersona(null);

		return tblPersona;
	}

}