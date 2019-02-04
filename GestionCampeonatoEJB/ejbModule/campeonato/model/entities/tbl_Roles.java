package campeonato.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the "tbl_Roles" database table.
 * 
 */
@Entity
@Table(name="\"tbl_Roles\"")
@NamedQuery(name="tbl_Roles.findAll", query="SELECT t FROM tbl_Roles t")
public class tbl_Roles implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="rol_id")
	private Integer rolId;

	@Column(name="rol_observacion")
	private String rolObservacion;

	@Column(name="rol_tipo")
	private String rolTipo;

	//bi-directional many-to-one association to tbl_Usuario
	@OneToMany(mappedBy="tblRole")
	private List<tbl_Usuario> tblUsuarios;

	public tbl_Roles() {
	}

	public Integer getRolId() {
		return this.rolId;
	}

	public void setRolId(Integer rolId) {
		this.rolId = rolId;
	}

	public String getRolObservacion() {
		return this.rolObservacion;
	}

	public void setRolObservacion(String rolObservacion) {
		this.rolObservacion = rolObservacion;
	}

	public String getRolTipo() {
		return this.rolTipo;
	}

	public void setRolTipo(String rolTipo) {
		this.rolTipo = rolTipo;
	}

	public List<tbl_Usuario> getTblUsuarios() {
		return this.tblUsuarios;
	}

	public void setTblUsuarios(List<tbl_Usuario> tblUsuarios) {
		this.tblUsuarios = tblUsuarios;
	}

	public tbl_Usuario addTblUsuario(tbl_Usuario tblUsuario) {
		getTblUsuarios().add(tblUsuario);
		tblUsuario.setTblRole(this);

		return tblUsuario;
	}

	public tbl_Usuario removeTblUsuario(tbl_Usuario tblUsuario) {
		getTblUsuarios().remove(tblUsuario);
		tblUsuario.setTblRole(null);

		return tblUsuario;
	}

}