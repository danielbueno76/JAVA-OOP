package casaapuestas.apuestas;

import casaapuestas.apuestas.CausaExcepcionApuesta;

//Las excepciones corresponden a la siguiente iteraci�n
public class ExcepcionApuesta extends Exception{
	/** Las clases que derivan de Exception deben tener un atributo como este. */
	private static final long serialVersionUID = 1L;
	/** La causa de la excecpci�n */
	private CausaExcepcionApuesta causa;

	/**
	 * Constructor que permite crear una excepci�n al operar sobre apuesta
	 * 
	 * @param causa la causa de la excepci�n
	 */
	public ExcepcionApuesta(CausaExcepcionApuesta causa) {
		super();
		// Asigna los par�metros
		this.causa = causa;

	}

	/**
	 * M�todo que devuelve la causa que dio lugar a esta excepci�n
	 * 
	 * @return la causa
	 */
	public CausaExcepcionApuesta getCausa() {
		return causa;
	}

}
