package casaapuestas.partidos;

/**Clase donde se declarar las constante que vamos a utilizar durante el proyecto
 * esto nos va a permitir modificar el valor de las constantes sin tener que volver a compilar
 * todos los archivos .class
 *
 */
public interface IConstantesApuestas {
	/** Variable que indica el porcentaje que se reparte a los jugadores respecto al dinero total apostado en un partido*/
	public final float RATIO_PREMIOS=(float)0.8;
	/** Variable que indica el porcentaje que se reparte a la casa de apuestas respecto al dinero total apostado en un partido*/
	public final float RATIO_CASA_APUESTAS=(float)0.2;
}
