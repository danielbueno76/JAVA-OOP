package casaapuestas.equipos; //Importamos los paquetes y las librerias necesarias para el c�digo


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Clase controladora encargada de la gesti�n de los Equipos
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
	 * M�todo que a�ade una nueva instancia de <code>Equipo</code> y la colecciona, indexada por el <code>idEquipo</code>
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
				// Pero si ya exist�a lanza una excepci�n
				throw new ExcepcionEquipos(CausaExcepcionEquipos.YA_EXISTE, idEquipo);
			}
	
	}

	/**
	 * M�todo que permite mostrar toda la informaci�n de un determinado  <code>Equipo</code> especificada por  <code>nombreEquipo</code>
	 * 
	 * @param idEquipo identificador �nico de un partido
	 * @return una cadena con toda la informaci�n del partido requerido
	 * @throws ExcepcionEquipo si no existe un partido con este <code>idPartido</code>
	 */
	public String verEquipo(String idEquipo) throws ExcepcionEquipos {
			// Recupera la instancia de la colecci�n
			Equipo esteEquipo = listaEquipos.get(idEquipo);
			// Si este equipo exist�a, no es null
			if (esteEquipo != null) {
				// Le pide al equipo que muestre su informaci�n completa
				return esteEquipo.verFichaCompletaEquipo();
			} else {
				// Pero si no exist�a lanza una excepci�n
				throw new ExcepcionEquipos(CausaExcepcionEquipos.NO_EXISTE, idEquipo);
			}

	}
	
	/**
	 * M�todo que permite obtener una lista de equipos, cada una con informaci�n (FichaBreve) sobre cada instancia de <code>Equipo</code> coleccionada por este
	 * controlador.
	 * 
	 * @return Una lista de cadenas
	 */	
	public List<String> listarEquipos() {
		
		//Inicializamos la lista de Equipos
		List<String> listadoEquipos = new ArrayList<String>();
		
		// Recorre la colecci�n de equipos
				for (Equipo e : listaEquipos.values()) {
					// A cada equipo le pide informaci�n breve
					String fichaEquipo = e.verFichaBreveEquipo();
					// Y la a�ade al listado
					listadoEquipos.add(fichaEquipo);
				}				
		//Devuelve el listado
		return listadoEquipos;
	}
	
	/**
	 * M�todo que permite obtener todos los datos sobre un equipo <code>Equipo</code> coleccionada por este
	 * controlador.
	 * 
	 * @return variable tipo Equipo
	 */	
	public Equipo obtenerEquipo(String idEquipo) {
		//Devuelve todos los datos de un equipo
		return listaEquipos.get(idEquipo);
		
	}
	
	
}


