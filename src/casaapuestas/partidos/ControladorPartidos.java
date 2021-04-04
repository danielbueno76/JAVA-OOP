package casaapuestas.partidos; //Importamos librerias y paquetes necesarios

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import casaapuestas.apuestas.CausaExcepcionApuesta;
import casaapuestas.apuestas.ExcepcionApuesta;
import casaapuestas.apuestas.TipoApuestas;
import casaapuestas.cuentas.CausaExcepcionCuentas;
import casaapuestas.cuentas.ExcepcionCuenta;
import casaapuestas.equipos.CausaExcepcionEquipos;
import casaapuestas.equipos.ControladorEquipos;
import casaapuestas.equipos.Equipo;
import casaapuestas.equipos.ExcepcionEquipos;
import casaapuestas.usuarios.CausaExcepcionUsuario;
import casaapuestas.usuarios.ControladorUsuarios;
import casaapuestas.usuarios.ExcepcionUsuario;
import casaapuestas.usuarios.Jugador;



/**
 * Clase controladora encargada de la gestión de los Partidos y de las apuestas que se realizan sobre ellos.
 */

public class ControladorPartidos {
	
	/**
	 * Lista de los partidos existentes en el sistema, indexados por el idPartido
	 */
	private Map<String, Partido> listaPartidos;
	
	/**
	 * Variable de tipo ControladorUsuarios, la cual aporta a RealizarApuesta los datos de un determinado jugador
	 */	
	private ControladorUsuarios cu;

	private ControladorEquipos ce;
	
	/**
	 * Constructor que inicializa las colecciones y recibe como parámetro una variable de tipo ControladorUsuarios
	 */
	public ControladorPartidos(ControladorUsuarios cu, ControladorEquipos ce) {
		super();
		this.cu=cu;
		this.ce=ce;
		// Inicializa las colecciones
		listaPartidos = new HashMap<String, Partido>();

		}
	
	/**
	 * Método que crea una nueva instancia de <code>Partido</code> y la colecciona, indexada por el <code>idPartido</code>
	 * 
	 * @param idPartido, identificador unico de cada partido.
	 * @param fecha, fecha del partido
	 * @param inicioApuestas, hora de inicio del partido (marca el inicio de la posibilidad de realizar apuestas)
	 * @param finApuestas, hora final del partido
	 * @param equipoLocal, datos sobre el equipo local
	 * @param equipoVisitante, datos sobre el equipo visitante
	 * @throws ExcepcionPartido si ya existe un Partido con este <code>idPartido</code>
	 */
	public void crearPartido(String idPartido, Calendar inicioApuestas,Calendar finApuestas, String idEquipoLocal, String idEquipoVisitante)
		throws ExcepcionPartidos, ExcepcionEquipos, ExcepcionApuesta{
		
		Equipo equipoLocal=ce.obtenerEquipo(idEquipoLocal);
		Equipo equipoVisitante=ce.obtenerEquipo(idEquipoVisitante);
		// Comprueba si existen los dos equipos
		if(equipoLocal== null )
				{
			// Pero si no existen lanza una excepción
			throw new ExcepcionEquipos(CausaExcepcionEquipos.NO_EXISTE, idEquipoLocal);
			
				}	
		if(equipoVisitante== null)
				{
					// Pero si no existen lanza una excepción
					throw new ExcepcionEquipos(CausaExcepcionEquipos.NO_EXISTE, idEquipoVisitante);
					
				}
		//Comprueba que el inicio de las apuestas no comience después del final de estas
		if(inicioApuestas.after(finApuestas)) {
			// Lanza una excepción
			throw new ExcepcionApuesta(CausaExcepcionApuesta.FECHAS_INCORRECTAS);
		}
		// Comprueba si ya existe un partido con este id
		if (!listaPartidos.containsKey(idPartido)) {
			// Si no existe, crea la instancia
			Partido nuevoPartido = new Partido(idPartido, inicioApuestas, finApuestas, equipoLocal, equipoVisitante);
			// Y la colecciona
			listaPartidos.put(idPartido, nuevoPartido);
	
		} else {

			// Pero si ya existía lanza una excepción
			throw new ExcepcionPartidos(CausaExcepcionPartidos.YA_EXISTE, idPartido);
			}
		


		
}
	
	/**
	 * Método que permite obtener una lista de cadenas, cada una con información (FichaBreve) sobre cada instancia de <code>Partido</code> coleccionada por este
	 * controlador.
	 * 
	 * @return Una lista de cadenas
	 */		
	
	public List<String> listarPartidos() {
		
		//Inicializamos la lista de Partidos
		List<String> listadoPartidos = new ArrayList<String>();
		
		// Recorre la colección de Partido
				for (Partido p : listaPartidos.values()) {

					// A cada Partido le pide información breve
					String fichaPartido = p.verFichaBrevePartido();
					// Y la añade al listado
					listadoPartidos.add(fichaPartido);
				}
		return listadoPartidos;
	}
	
	/**
	 * Método que permite mostrar toda la información de un determinado  <code>Partido</code> dada por un  <code>idPartido</code>
	 * 
	 * @param idPartido identificador único de un partido
	 * @return una cadena con toda la información del partido requerido
	 * @throws ExcepcionPartido si no existe un partido con este <code>idPartido</code>
	 */

	public String verPartido(String idPartido) throws ExcepcionPartidos {
		// Recupera la instancia de la colección
		Partido estePartido = listaPartidos.get(idPartido);
		
		// Si este partido existía, es diferente de null
				if (estePartido != null) {
					// Le pide al partido que muestre su información completa
					return estePartido.verFichaCompletaPartido();
				} else {
					// Pero si no existía lanza una excepción
					throw new ExcepcionPartidos(CausaExcepcionPartidos.NO_EXISTE, idPartido);
				}
							
	}

	
	/**
	 * Método que modifica una instancia de <code>Partido</code> especidicada por un <code>idPartido</code>
	 * 
	 * @param idPartido,  identificador único partido
	 * @param inicioApuestas, instante a partir del cual se pueden realizar apuestas
	 * @param finApuestas, marca el fin de las apuestas
	 * @param equipoLocal,  datos del equipo que juega en su propia cancha
	 * @param equipoVisitante, datos del equipo que juega en una cancha que no es suya
	 * @throws ExcepcionPartido si no existe un Partido con este <code>idPartido</code>
	 */
	
	public void modificarPartido(String idPartido,  Calendar inicioApuestas,Calendar finApuestas, String idEquipoLocal, String idEquipoVisitante)
			throws ExcepcionPartidos, ExcepcionEquipos {
		
		Equipo equipoLocal=ce.obtenerEquipo(idEquipoLocal);
		Equipo equipoVisitante=ce.obtenerEquipo(idEquipoVisitante);
		// Recupera la instancia de la colección
		Partido estePartido = listaPartidos.get(idPartido);
		
		// Comprueba si existen los dos equipos
		if(equipoLocal== null )
				{
			// Pero si no existen lanza una excepción
			throw new ExcepcionEquipos(CausaExcepcionEquipos.NO_EXISTE, idEquipoLocal);
			
				}	
		if(equipoVisitante== null)
				{
					// Pero si no existen lanza una excepción
					throw new ExcepcionEquipos(CausaExcepcionEquipos.NO_EXISTE, idEquipoVisitante);
					
				}
		// Si este partido existía, no es null
		if (estePartido != null && inicioApuestas.before(finApuestas)) {
			// Modifica uno a uno los otros atributos
			estePartido.setFechaInicio(inicioApuestas);
			estePartido.setFechaFinal(finApuestas);
			estePartido.setEquipoLocal(equipoLocal);
			estePartido.setEquipoVisitante(equipoVisitante);
		} else {
			// Pero si no existía lanza una excepción
			throw new ExcepcionPartidos(CausaExcepcionPartidos.NO_EXISTE, idPartido);
		}
		
		
	}
	
	/**
	 * Método que permite borrar una instancia de <code>Partido</code> determinada por <code>idPartido</code>
	 * 
	 * @param idPartido identificador único de un partido
	 * @throws ExcepcionPartido si no existe un usuario con este <code>idPartido</code>
	 */

	public void borrarPartido(String idPartido)
		throws ExcepcionPartidos {
		// Borra la instancia de la colección
		Partido estePartido = listaPartidos.remove(idPartido);
		// Si este partido es null es que no existía, informamos de que no lo se ha borrado, ya que no existía
		if (estePartido == null) {
		throw new ExcepcionPartidos(CausaExcepcionPartidos.NO_EXISTE, idPartido);
	}		

	}
	
	/**
	 * Método que permite obtener una lista de cadenas, con los partidos abiertos a una determinada fecha,  sobre cada instancia de <code>Partido</code> coleccionada por este
	 * controlador.
	 * 
	 * @return Una lista de cadenas
	 */	
	
	public List<String> listarPartidosAbiertos() {
		
		//Inicializamos la lista de Partidos
				List<String> listadoPartidosAbiertos = new ArrayList<String>();
				
				//Creamos una variable ahora de tipo Calendar donde almacenamos la hora actual. (En este caso hemos definido una hora concreta para que se pueda apostar)
				Calendar ahora = Calendar.getInstance();
				ahora.clear();
				ahora.set(2015, Calendar.MAY, 9, 8, 0);
				
				// Recorre la colección de Partido
						for (Partido p : listaPartidos.values()) {
							if(ahora.after(p.getFechaInicio()) && ahora.before(p.getFechaFinal()) && p != null)
							{
								
							// A cada Partido le pide información breve
							String fichaPartido = p.verFichaBrevePartido();
							// Y la añade al listado
							listadoPartidosAbiertos.add(fichaPartido);
							}
						}
				return listadoPartidosAbiertos;				
		}
	
	/**
	 * Método que permite realizar una apuesta, seleccionando un <code>Partido</code> determinada por <code>idPartido</code>
	 * controlador.
	 * @param login login el login, o identificador único de usuario
	 * @param idPartido,  identificador único partido
	 * @param modalidad, modalidad Apuesta/Marcador segun el tipo de apuesta que deseamos realizar
	 * @param Resultado, resultado del aprtido, marca si una apuesta es ganadora o perdedora
	 * @param importe, cantidad de dinero apostado a un partido
	 * @throws ExcepcionPartidos si no existe un Partido con este <code>idPartido</code>
	 */	
	
	public void realizarApuesta(String login, String idPartido,TipoApuestas modalidad, String resultadoApostado, float cantidad) 
			throws ExcepcionPartidos, ExcepcionCuenta, ExcepcionUsuario{
		// Recupera la instancia de la colección
		Partido estePartido = listaPartidos.get(idPartido);
		Jugador esteJugador=cu.obtenerJugador(login);
		// Si este jugador no existía, es null
		if(esteJugador==null) {
			throw new ExcepcionUsuario(CausaExcepcionUsuario.NO_EXISTE, login);
			
		}
		//Comprobamos que el saldo del juegador, sea superior al del importe que desea apostar
		if(cu.verSaldoJugador(login)> cantidad)
		{
			// Si este partido existía, podemos realizar la apuesta.
			if (estePartido != null) {
				Equipo equipoLocal=estePartido.getEquipoLocal();
				Equipo equipoVisitante=estePartido.getEquipoVisitante();
				String conceptoPartido= equipoLocal.getIdEquipo() + "-" +equipoVisitante.getIdEquipo();
				
				//Almacena esta apuesta en la lista de apuestas almacenada por partido
				estePartido.realizarApuesta(idPartido,esteJugador,resultadoApostado, cantidad,modalidad, conceptoPartido);
						
			} else {
				// Pero si no existía lanza una excepción
				throw new ExcepcionPartidos(CausaExcepcionPartidos.NO_EXISTE, idPartido);
			}
		}
		else {
			// Pero si no hay saldo lanza una excepción
			throw new ExcepcionCuenta(CausaExcepcionCuentas.USUARIO_SIN_FONDOS, "El saldo del usuario"+login+"es inferior a la cantidad "+cantidad+" que se quiere apostar");
		}
	}

	
	/**
	 * Método que permite obtener una lista de cadenas, con la lista de apuestas de un partido determinada por <code>idPartido</code>,  sobre cada instancia de <code>Partido</code> coleccionada por este
	 * controlador. También dependiendo de si eres el Administrador o un Jugador, te permite o no ver la lista de apuestas dependiendo la hora actual.
	 * 
	 * @return Una lista de cadenas
	 */	
	public List<String> listarApuestasPartido(String idPartido) throws ExcepcionPartidos{
		// Recupera la instancia de la colección
		Partido estePartido = listaPartidos.get(idPartido);
		
		//Creamos una variable ahora de tipo Calendar donde almacenamos la hora actual. (En este caso hemos definido una hora concreta para que se pueda apostar)
		Calendar ahora = Calendar.getInstance();
		ahora.clear();
		ahora.set(2015, Calendar.MAY, 9, 8, 0);
		
		// Si este jugador existía, no es null
		if(estePartido != null) {
		// Así que delegamos en que nos devuelva un informe sobre la lista de apuestas en ese partido
					return estePartido.listarApuestas(idPartido);

			
		} else {

				// Pero si no existía lanza una excepción
				throw new ExcepcionPartidos(CausaExcepcionPartidos.NO_EXISTE, idPartido);
			}
				
	}
	public void introducirResultadoPartido(String idPartido, TipoApuestas modalidad, String resultadoFinal)
		throws ExcepcionPartidos,ExcepcionApuesta {
		// Recupera la instancia de la colección
		Partido estePartido = listaPartidos.get(idPartido);
		
		// Si este jugador existía, no es null
		if(estePartido != null) {
			estePartido.introducirResultadoFinal(idPartido,modalidad,resultadoFinal);
		} else {
			// Pero si no existía lanza una excepción
			throw new ExcepcionPartidos(CausaExcepcionPartidos.NO_EXISTE, idPartido);
		}
 		
	}
	
	public void pagarApuestasPartido(String idPartido, TipoApuestas modalidad) 
	throws ExcepcionPartidos, ExcepcionApuesta{
		// Recupera la instancia de la colección
		Partido estePartido = listaPartidos.get(idPartido);
		
		// Si este jugador existía, no es null
		if (estePartido != null) {
		//Se recuperan los equipos local y visitante para añadirlos a conceptoPartido. Esta variable define los equipos que juegan en ese partido
		Equipo equipoLocal=estePartido.getEquipoLocal();
		Equipo equipoVisitante=estePartido.getEquipoVisitante();
		String conceptoPartido= equipoLocal.getIdEquipo() + "-" +equipoVisitante.getIdEquipo();
		
		estePartido.pagarApuesta(modalidad,conceptoPartido);
		}
		else {
			// Pero si no existía lanza una excepción
			throw new ExcepcionPartidos(CausaExcepcionPartidos.NO_EXISTE, idPartido);
			}
		
	}
		

}