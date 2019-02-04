package campeonato.model.manager;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import campeonato.model.entities.*;


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
	
	
	
	//region [Campeonato]
	
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
	
	//------------------------Equipo
	
	public void agregarEquipo(tbl_Equipos equipo, int idPresidentePersona,  int idCampeonato) throws Exception {
		System.out.println("\nvoid agregarEQUIPO\n");
		if (equipo.getEqu_nombreOficial() == null || equipo.getEqu_nombreOficial().length() == 0)
			throw new Exception("Debe especificar campos.");
		tbl_Persona persona =(tbl_Persona)em.find(tbl_Persona.class, idPresidentePersona);
		tbl_Campeonato campeonato=(tbl_Campeonato)em.find(tbl_Campeonato.class, idCampeonato);
		equipo.setTblCampeonato(campeonato);
		equipo.setTblPersona(persona);
		em.persist(equipo);
	}

	public tbl_Equipos findEquipo(int id) throws Exception {
		tbl_Equipos a = em.find(tbl_Equipos.class, id);
		return a;
	}

	public void eliminarEquipo(int id) throws Exception { // buscamos el Campeonato:
		tbl_Equipos a = findEquipo(id);
		if (a == null)
			throw new Exception("No existe el Equipo especificado."); // lo eliminamos:
		em.remove(a);
	}

	public void editarEquipo(int id, String equ_nombreOficial, Date equ_fechaFundacion) throws Exception { // buscamos el
		tbl_Equipos a = findEquipo(id);
		if (a == null)
			throw new Exception("No existe el Equipo especificado."); // actualizamos ciertos campos especificados
																		// en los parametros del metodo:
		a.setEqu_nombreOficial(equ_nombreOficial);
		a.setEqu_fechaFundacion(equ_fechaFundacion);
		em.merge(a);
	}

	public List<tbl_Equipos> findAllEquipo() {
		Query q;
		List<tbl_Equipos> listado;
		String sentenciaSQL;
		sentenciaSQL = "SELECT o FROM tbl_Equipos o";
		q = em.createQuery(sentenciaSQL);
		listado = q.getResultList();
		return listado;
	}
	

	//---------------------------TipoPersona
	
	public List<tbl_TipoPersona> findAllTipoPesona() {
		Query q;
		List<tbl_TipoPersona> listado;
		String sentenciaSQL;
		sentenciaSQL = "SELECT o FROM tbl_TipoPersona o";
		q = em.createQuery(sentenciaSQL);
		listado = q.getResultList();
		return listado;
	}
	
	//--------------------------- ROLES
	
	public List<tbl_Roles> findAllRoles() {
		Query q;
		List<tbl_Roles> listado;
		String sentenciaSQL;
		sentenciaSQL = "SELECT o FROM tbl_Roles o";
		q = em.createQuery(sentenciaSQL);
		listado = q.getResultList();
		return listado;
	}
	
	
	//--------------------------- USUARIO

	public void agregarUsuario(tbl_Usuario usuario, int idRol) throws Exception {
		System.out.println("\nvoid agregarUsuario\n");
		if (usuario.getUsuUsuario() == null || usuario.getUsuUsuario().length() == 0)
			throw new Exception("Debe especificar campos.");
		tbl_Roles b = em.find(tbl_Roles.class, idRol);
		usuario.setTblRole(b);
		if (usuario.getUsuPassword().length() <6)
			throw new Exception("Contraseña muy corta. Mínimo 6 Caracteres");
		em.persist(usuario);
	}

	public tbl_Usuario findUsuario(int id) throws Exception {
		tbl_Usuario a = em.find(tbl_Usuario.class, id);
		return a;
	}

	public void eliminarUsuario(int id) throws Exception { // 
		tbl_Usuario  a = findUsuario(id);
		if (a == null)
			throw new Exception("No existe el Usuario especificado."); // lo eliminamos:
		em.remove(a);
	}

	public void editarUsuario (int id, String password, int rol) throws Exception {
		tbl_Usuario a = em.find(tbl_Usuario.class, id);
		a.setUsuPassword(password);
		tbl_Roles b = em.find(tbl_Roles.class, rol);
		a.setTblRole(b);
		if (password.length() <6)
			throw new Exception("Contraseña muy corta. Mínimo 6 Caracteres");
		em.merge(a);
	}

	
	
	public List<tbl_Usuario> findAllUsuarios(int id)
	{
		Query q;
		List<tbl_Usuario> listado;
		String sentenciaSQL;
		sentenciaSQL = "SELECT o FROM tbl_Usuario o";
		q = em.createQuery(sentenciaSQL);
		listado = q.getResultList();
		return listado;
	}
	
	
	//-------------------Persona
	
	public void agregarPersona(tbl_Persona persona, int idTipoPersona) throws Exception {
		System.out.println("\nvoid agregarPersona\n");
		if (persona.getPerCedula() == null || persona.getPerCedula().length() == 0)
			throw new Exception("Debe especificar campos.");
		tbl_TipoPersona b = em.find(tbl_TipoPersona.class, idTipoPersona);
		persona.setTblTipoPersona(b);
		if (persona.getPerCedula().length()!=10)
			throw new Exception("La cedula necesita 1o digitos.");
		em.persist(persona);
	}

	public tbl_Persona findPersona(int id) throws Exception {
		tbl_Persona a = em.find(tbl_Persona.class, id);
		return a;
	}

	public void eliminarPersona(int id) throws Exception { // 
		tbl_Persona a = findPersona(id);
		if (a == null)
			throw new Exception("No existe la persona especificado."); // lo eliminamos:
		em.remove(a);
	}

	public void editarPersona (tbl_Persona persona, int idTipoPersona) throws Exception {
		tbl_Persona a = em.find(tbl_Persona.class, persona.getPerId());
		a.setPerNombres(persona.getPerNombres());
		a.setPerApellidos(persona.getPerApellidos());
		a.setPerTelefono(persona.getPerTelefono());
		a.setPerEmail(persona.getPerEmail());
		a.setPerDireccion(persona.getPerDireccion());
		tbl_TipoPersona b = em.find(tbl_TipoPersona.class, idTipoPersona);
		a.setTblTipoPersona(b);
		if (persona.getPerNombres().length() == 0)
			throw new Exception("Ponga al menos el Nombre");
		em.merge(a);
	}

	
	
	public List<tbl_Persona> findAllPersona(int id)
	{
		Query q;
		List<tbl_Persona> listado;
		String sentenciaSQL;
		sentenciaSQL = "SELECT o FROM tbl_Persona o";
		q = em.createQuery(sentenciaSQL);
		listado = q.getResultList();
		return listado;
	}
	
	
	
	
}
