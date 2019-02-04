package campeonato.model.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the "tbl_Usuario" database table.
 * 
 */
@Entity
@Table(name="\"tbl_Usuario\"")
@NamedQuery(name="tbl_Usuario.findAll", query="SELECT t FROM tbl_Usuario t")
public class tbl_Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="usu_id")
	private Integer usuId;

	@Column(name="usu_email")
	private String usuEmail;

	@Column(name="usu_password")
	private String usuPassword;

	@Column(name="usu_usuario")
	private String usuUsuario;

	//bi-directional many-to-one association to tbl_Roles
	@ManyToOne
	@JoinColumn(name="rol_id")
	private tbl_Roles tblRole;

	public tbl_Usuario() {
	}

	public Integer getUsuId() {
		return this.usuId;
	}

	public void setUsuId(Integer usuId) {
		this.usuId = usuId;
	}

	public String getUsuEmail() {
		return this.usuEmail;
	}

	public void setUsuEmail(String usuEmail) {
		this.usuEmail = usuEmail;
	}

	public String getUsuPassword() {
		return this.usuPassword;
	}

	public void setUsuPassword(String usuPassword) {
		this.usuPassword = usuPassword;
	}

	public String getUsuUsuario() {
		return this.usuUsuario;
	}

	public void setUsuUsuario(String usuUsuario) {
		this.usuUsuario = usuUsuario;
	}

	public tbl_Roles getTblRole() {
		return this.tblRole;
	}

	public void setTblRole(tbl_Roles tblRole) {
		this.tblRole = tblRole;
	}

}