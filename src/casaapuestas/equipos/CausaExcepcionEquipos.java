package casaapuestas.equipos;

/**
 * Tipo enumerado que se puede usar para especificar las causas de la excepción
 * 
 */
public enum CausaExcepcionEquipos {
	/** Se ha buscado a un Equipo por su idEquipo, pero no existe */
	NO_EXISTE,
	/** Se ha intentado crear a un Equipo, pero ya existe otro con ese idPartido */
	YA_EXISTE
}
