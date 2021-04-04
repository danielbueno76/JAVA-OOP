package casaapuestas.apuestas;

/**
 * Tipo enumerado que lista los tipos de apuesta por los que el resultado cambia y por tsnto es diferente al evaluar quién ha ganado la apuesta

 */
public enum TipoApuestas {
		/** Tipo de apuesta basada en que el Jugador tiene que acertar el resultado específico del partido */
		MARCADOR,
		/** Tipo de apuesta basada en que el Jugador tiene que acertar si el partido lo ha ganado el equipo locaol (1), el equipo visitante(2) o ha habido un empate (X)*/	
		QUINIELA,
		/** Tipo de apuesta basada en que el Jugador tiene que acertar el numero de Corners, que va a sacar, cada equipo*/
		CORNERS

}
