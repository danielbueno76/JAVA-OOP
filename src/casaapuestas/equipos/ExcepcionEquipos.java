package casaapuestas.equipos;

import casaapuestas.equipos.CausaExcepcionEquipos;


public class ExcepcionEquipos extends Exception{
	/** Las clases que derivan de Exception deben tener un atributo como este. */
	private static final long serialVersionUID = 1L;
	/** El login usado en la operaci�n que ha dado lugar a la excecpcion */
	private String idEquipo;
	/** La causa de la excecpci�n */
	private CausaExcepcionEquipos causa;

	/**
	 * Constructor que permite crear una excepci�n al operar sobre usuarios
	 * 
	 * @param causa, la causa de la excepcion
	 * @param idEquipo, el identificador de equipo usado en la operacion que ha causado la excepci�n
	 */
	public ExcepcionEquipos(CausaExcepcionEquipos causa, String idEquipo) {
		super();
		// Asigna los par�metros
		this.causa = causa;
		this.idEquipo = idEquipo;
	}

	/**
	 * Metodo que devuelve el idEquipo que dio lugar a esta excepci�n
	 * 
	 * @return idEquipo, el identificador del  equipo
	 */
	public String getIdEquipo() {
		return idEquipo;
	}

	/**
	 * Metodo que devuelve la causa que dio lugar a esta excepci�n
	 * 
	 * @return causa, raz�n por la que se ha lanzado la excepci�n
	 */
	public CausaExcepcionEquipos getCausa() {
		return causa;
	}

}
