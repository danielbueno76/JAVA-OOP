package casaapuestas.apuestas;

public enum CausaExcepcionApuesta {
	/** Se ha buscado a un usuario por su login, pero no existe */
	NO_EXISTE,
	/** Se ha solicitado introducir una fecha, que no tiene el formato correcto*/
	FECHAS_INCORRECTAS,
	/** Se a pedido introducir resultados, pero los resultado no se han introducidos */
	RESULTADOS_NO_INTRODUCIDOS,
	/** Se ha intentado pagar unas apuesta, ya pagadas */
	APUESTAS_YA_PAGADAS
	
}
