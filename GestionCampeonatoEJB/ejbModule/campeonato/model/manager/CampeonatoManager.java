package campeonato.model.manager;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import java.util.ArrayList;
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
	
	
	
	public tbl_Campeonato guardarCampeonato(tbl_Campeonato obj, String accion) throws Exception
	{
		if (obj.getCampNombre() == null || obj.getCampNombre().length() < 6)
			throw new Exception("Nombre requerido o muy corto (Menor a 5 caracteres)"); // lo eliminamos:
		if (obj.getTblEquipos().size()==0)
			throw new Exception("Nombre hay detalles."); // lo eliminamos:
		if(accion.equals("crear"))
		{
			em.persist(obj);
		}else 
		{
			em.merge(obj);
		}
		return obj;
	}
	
	public tbl_Campeonato findCampeonato(int id) throws Exception {
		tbl_Campeonato a = em.find(tbl_Campeonato.class, id);
		if (a == null)
			throw new Exception("No existe el Campeonato especificado."); // lo eliminamos:
		a.getTblEquipos().size();
		return a;
	}

	public void eliminarCampeonato(int id) throws Exception { // buscamos el Campeonato:
		tbl_Campeonato a = findCampeonato(id);
		if (a == null)
			throw new Exception("No existe el Campeonato especificado."); // lo eliminamos:
		em.remove(a);
	}

	public void editarCampeonato(tbl_Campeonato objA) throws Exception { // buscamos el

		tbl_Campeonato a = findCampeonato(objA.getCampId());
		if (a == null)
			throw new Exception("No existe el Campeonato especificado."); // actualizamos ciertos campos especificados
																		// en los parametros del metodo:
		a.setCampNombre(objA.getCampNombre());
		a.setCampDescripcion(objA.getCampDescripcion());
		a.setCamp_fechaInicio(objA.getCamp_fechaInicio());
		a.setCamp_cantidadEquiposPermitidos(objA.getCamp_cantidadEquiposPermitidos());
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
	
	public tbl_Campeonato agregarEquipo(tbl_Campeonato objA, tbl_Equipos objB) throws Exception 
	{
		if(objA==null) 
		{
			objA=new tbl_Campeonato();
			objA.setTblEquipos(new ArrayList<tbl_Equipos>());
		}
		if(objA.getCamp_cantidadEquiposRegistrados()+1>objA.getCamp_cantidadEquiposPermitidos()) 
		{
			throw new Exception("Cantidad de Equipos exceden el campeonato");
		}else 
		{
			objA.setCamp_cantidadEquiposRegistrados(objA.getCamp_cantidadEquiposRegistrados()+1);
		}
		objA.addTblEquipo(objB);
		return objA;
	}
	
	public tbl_Campeonato removerEquipo(tbl_Campeonato objA, tbl_Equipos objB)
	{
		objA.getTblEquipos().remove(objB);
		return objA;
	}
	

	public tbl_Equipos findEquipo(int id) throws Exception {
		tbl_Equipos a = em.find(tbl_Equipos.class, id);
		return a;
	}
	
	public tbl_Equipos findEquipoYJugadores(int id) throws Exception {
		tbl_Equipos a = em.find(tbl_Equipos.class, id);
		a.getTblJugadores().size();
		return a;
	}

	public void eliminarEquipo(int id) throws Exception { // buscamos el Campeonato:
		tbl_Equipos a = findEquipo(id);
		if (a == null)
			throw new Exception("No existe el Equipo especificado."); // lo eliminamos:
		em.remove(a);
	}

	public void editarEquipo(tbl_Equipos equipo) throws Exception { // buscamos el
		try {
		tbl_Equipos a = findEquipo(equipo.getEquId());
		if (a == null)
			throw new Exception("No existe el Equipo especificado."); // actualizamos ciertos campos especificados
																		// en los parametros del metodo:
		a.setEqu_nombreOficial(equipo.getEqu_nombreOficial());
		a.setEqu_nombrePresidente(equipo.getEqu_nombrePresidente());
		
		em.merge(a);
		}catch(Exception ex)
		{
			throw new Exception(ex.getMessage());
		}
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
	

	//---------------------------Jugador
	
	public List<tbl_Jugadores> findAllJugadores() {
		Query q;
		List<tbl_Jugadores> listado;
		String sentenciaSQL;
		sentenciaSQL = "SELECT o FROM tbl_TipoPersona o ";
		q = em.createQuery(sentenciaSQL);
		listado = q.getResultList();
		return listado;
	}
	
	public List<tbl_Jugadores> findAllJugadoresEquipo(int idEquipo) {
		Query q;
		List<tbl_Jugadores> listado;
		tbl_Equipos objFind= em.find(tbl_Equipos.class, idEquipo);
		objFind.getTblJugadores().size();
		listado=objFind.getTblJugadores();
		return listado;
	}	
	
	
	public void agregarJugador(tbl_Jugadores jugador, int idEquipo) throws Exception {
		System.out.println("\nvoid agregarNuevo\n");
		if (jugador.getJugCedula()== null || jugador.getJugCedula().length() == 0)
			throw new Exception("Debe especificar campos.");
		tbl_Equipos b = em.find(tbl_Equipos.class, idEquipo);
		jugador.setTblEquipo(b);
		if (jugador.getJugCedula().length()!=10)
			throw new Exception("La cedula necesita 1o digitos.");
		em.persist(jugador);
	}

	public tbl_Jugadores findPersona(int id) throws Exception {
		tbl_Jugadores a = em.find(tbl_Jugadores .class, id);
		return a;
	}

	public void eliminarPersona(int id) throws Exception { // 
		tbl_Jugadores a = findPersona(id);
		if (a == null)
			throw new Exception("No existe la persona especificado."); // lo eliminamos:
		em.remove(a);
	}

	
	
	public void editarJugador_EquipoDelJugador(int idJugador, int idEquipo) throws Exception {
		
		tbl_Jugadores a = em.find(tbl_Jugadores.class, idJugador);
		if (a==null)
			throw new Exception("No se existe. Jugador ");
		tbl_Equipos b = em.find(tbl_Equipos.class, idEquipo);
		if (b==null)
			throw new Exception("No se existe. Equipo ");
		a.setTblEquipo(b);
		em.merge(a);
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
	
	
	
	
	
}
