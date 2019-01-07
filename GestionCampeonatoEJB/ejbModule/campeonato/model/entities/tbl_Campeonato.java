package campeonato.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


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

}