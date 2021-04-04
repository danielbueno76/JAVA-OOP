package casaapuestas.apuestas;

import casaapuestas.apuestas.CausaExcepcionApuesta;

//Las excepciones corresponden a la siguiente iteración
public class ExcepcionApuesta extends Exception{
	/** Las clases que derivan de Exception deben tener un atributo como este. */
	private static final long serialVersionUID = 1L;
	/** La causa de la excecpción */
	private CausaExcepcionApuesta causa;

	/**
	 * Constructor que permite crear una excepción al operar sobre apuesta
	 * 
	 * @param causa la causa de la excepción
	 */
	public ExcepcionApuesta(CausaExcepcionApuesta causa) {
		super();
		// Asigna los parámetros
		this.causa = causa;

	}

	/**
	 * Método que devuelve la causa que dio lugar a esta excepción
	 * 
	 * @return la causa
	 */
	public CausaExcepcionApuesta getCausa() {
		return causa;
	}

}
