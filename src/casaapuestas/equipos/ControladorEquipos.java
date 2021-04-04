package casaapuestas.equipos; //Importamos los paquetes y las librerias necesarias para el código


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Clase controladora encargada de la gestión de los Equipos
 */

public class ControladorEquipos {	
	/**
	 * Lista de los Equipos existentes en el sistemas. Indexada por nombreEquipo
	 */
	private Map<String,Equipo> listaEquipos;

	/**
	 * Constructor que inicializa las colecciones
	 */
	public ControladorEquipos() {
		super();
	
		// Inicializa las colecciones
		listaEquipos = new HashMap<String, Equipo>();
	}
	
	/**
	 * Método que añade una nueva instancia de <code>Equipo</code> y la colecciona, indexada por el <code>idEquipo</code>
	 * 
	 * @param idEquipo, identificador del equipo
	 * @param nombreEquipo , nombre que recibe el equipo
	 * @param pais , pais de origen del equipo
	 * @param division , division en la que juega el equipo
	 */
	public void crearEquipo(String idEquipo,String nombreEquipo, String pais,String division) throws ExcepcionEquipos 	{
			// Comprueba si ya existe un equipo con este nombre
			if (!listaEquipos.containsKey(idEquipo)) {
				// Si no existe, crea la instancia
				Equipo nuevoEquipo = new Equipo(idEquipo, nombreEquipo,pais,division);
				// Y la colecciona
				listaEquipos.put(idEquipo, nuevoEquipo);
			} else {
				// Pero si ya existía lanza una excepción
				throw new ExcepcionEquipos(CausaExcepcionEquipos.YA_EXISTE, idEquipo);
			}
	
	}

	/**
	 * Método que permite mostrar toda la información de un determinado  <code>Equipo</code> especificada por  <code>nombreEquipo</code>
	 * 
	 * @param idEquipo identificador único de un partido
	 * @return una cadena con toda la información del partido requerido
	 * @throws ExcepcionEquipo si no existe un partido con este <code>idPartido</code>
	 */
	public String verEquipo(String idEquipo) throws ExcepcionEquipos {
			// Recupera la instancia de la colección
			Equipo esteEquipo = listaEquipos.get(idEquipo);
			// Si este equipo existía, no es null
			if (esteEquipo != null) {
				// Le pide al equipo que muestre su información completa
				return esteEquipo.verFichaCompletaEquipo();
			} else {
				// Pero si no existía lanza una excepción
				throw new ExcepcionEquipos(CausaExcepcionEquipos.NO_EXISTE, idEquipo);
			}

	}
	
	/**
	 * Método que permite obtener una lista de equipos, cada una con información (FichaBreve) sobre cada instancia de <code>Equipo</code> coleccionada por este
	 * controlador.
	 * 
	 * @return Una lista de cadenas
	 */	
	public List<String> listarEquipos() {
		
		//Inicializamos la lista de Equipos
		List<String> listadoEquipos = new ArrayList<String>();
		
		// Recorre la colección de equipos
				for (Equipo e : listaEquipos.values()) {
					// A cada equipo le pide información breve
					String fichaEquipo = e.verFichaBreveEquipo();
					// Y la añade al listado
					listadoEquipos.add(fichaEquipo);
				}				
		//Devuelve el listado
		return listadoEquipos;
	}
	
	/**
	 * Método que permite obtener todos los datos sobre un equipo <code>Equipo</code> coleccionada por este
	 * controlador.
	 * 
	 * @return variable tipo Equipo
	 */	
	public Equipo obtenerEquipo(String idEquipo) {
		//Devuelve todos los datos de un equipo
		return listaEquipos.get(idEquipo);
		
	}
	
	
}


