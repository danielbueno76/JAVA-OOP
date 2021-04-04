package casaapuestas.partidos;

public enum CausaExcepcionPartidos {
	/** Se ha buscado a un partido por su login, pero no existe */
	NO_EXISTE,
	/** Se ha intentado crear a un Partido, pero ya existe otro con nombre */
	YA_EXISTE,
	/** Se ha intentado apostar en un partido cerrado*/
	PARTIDO_CERRADO,
	/** Se ha intentado conprobar resultado en un partido abierto */
	PARTIDO_ABIERTO
}
