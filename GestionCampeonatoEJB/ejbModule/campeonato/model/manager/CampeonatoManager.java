package campeonato.model.manager;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import campeonato.model.entities.tbl_Campeonato;

/**
 * Session Bean implementation class CampeonatoManager
 */
@Stateless
@LocalBean
public class CampeonatoManager {

	@PersistenceContext(unitName = "gestionCampeonatoDS")
	private EntityManager em;

	/**
	 * Default constructor.
	 */
	public CampeonatoManager() {
		// TODO Auto-generated constructor stub
	}

	public void agregarCampeonato(String nombre, String descripcion, Date fecha,int equiposPermitidos) throws Exception {
		System.out.println("\nvoid agregarCampeonato\n");
		if (nombre == null || nombre.length() == 0)
			throw new Exception("Debe especificar campos.");
		tbl_Campeonato a = new tbl_Campeonato();
		a.setCampNombre(nombre);
		a.setCampDescripcion(descripcion);
		a.setCamp_fechaInicio(fecha);
		a.setCamp_cantidadEquiposPermitidos(equiposPermitidos);
		a.setCamp_cantidadEquiposRegistrados(0);
		em.persist(a);
	}

	public tbl_Campeonato findCampeonato(int id) throws Exception {
		tbl_Campeonato a = em.find(tbl_Campeonato.class, id);
		return a;
	}

	public void eliminarCampeonato(int id) throws Exception { // buscamos el Campeonato:
		tbl_Campeonato a = findCampeonato(id);
		if (a == null)
			throw new Exception("No existe el Campeonato especificado."); // lo eliminamos:
		em.remove(a);
	}

	public void editarCampeonato(int id, String nombre, String descripcion, Date fecha, int equiposPermitidos) throws Exception { // buscamos el
		// Campeonato:
		tbl_Campeonato a = findCampeonato(id);
		if (a == null)
			throw new Exception("No existe el Campeonato especificado."); // actualizamos ciertos campos especificados
																		// en los parametros del metodo:
		a.setCampNombre(nombre);
		a.setCampDescripcion(descripcion);
		a.setCamp_fechaInicio(fecha);
		a.setCamp_cantidadEquiposPermitidos(equiposPermitidos);
		em.merge(a);
	}

	public List<tbl_Campeonato> findAllCampeonatos() {
		Query q;
		List<tbl_Campeonato> listado;
		String sentenciaSQL;
		sentenciaSQL = "SELECT o FROM tbl_Campeonato o";
		q = em.createQuery(sentenciaSQL);
		listado = q.getResultList();
		return listado;
	}
}
