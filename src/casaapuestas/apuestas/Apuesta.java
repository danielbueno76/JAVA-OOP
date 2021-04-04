package casaapuestas.apuestas;

import casaapuestas.cuentas.ExcepcionCuenta;
import casaapuestas.usuarios.CasaApuestas;
import casaapuestas.usuarios.Jugador;


/**
 * Clase que representa a una apuesta en la casa de apuestas. Tiene los atributos comunes a todos ellos, y métodos <i>getter</i> y <i>setter</i>.
 */
public class Apuesta {

	/**  Cantidad apostada en un partido */
	private float cantidad;
	/**  Resultado que determina las apuestas */
	private String resultadoApostado;
	/**  Cadena en la que se dice los equipos que se enfrentaran en el partido al que se ha apostado */
	private String conceptoPartido;
	/**  Tipo de apuesta realizada sobre cada partido */
	private TipoApuestas modalidad;
	/**  Datos de un jugador */
	private Jugador esteJugador;
	/**  Parametro que indica que el dinero de la apuesta, no se ha pagado(false)*/
	private Boolean yaPagado=false;
	
	/**
	 * Constructor que crea una instancia de la clase Apuesta recibiendo como parámetros todos los atributos
	 * 
	 * @param esteJugador, Datos de un jugador
	 * @param cantidad, Cantidad apostada en un partido
	 * @param resultadoApostado,  Resultado que determina las apuestas
	 * @param conceptoPartido, Cadena en la que se dice los equipos que se enfrentaran en el partido al que se ha apostado
	 * @param modalidad, Tipo de apuesta realizada sobre cada partido
	 * 
	 */
	public Apuesta(Jugador esteJugador,float cantidad, String resultadoApostado,TipoApuestas modalidad, String conceptoPartido)  throws ExcepcionCuenta{
		this.esteJugador=esteJugador;
		this.cantidad=cantidad;
		this.resultadoApostado=resultadoApostado;
		this.conceptoPartido=conceptoPartido;
		this.modalidad=modalidad;
		// Así que delegamos en que el Jugador realice el ingreso
		esteJugador.realizarReintegro("Pago de apuesta sobre " + conceptoPartido, cantidad);
		// Al apostar se incrementa el saldo de la casa de apuestas
		CasaApuestas casaApuestas=CasaApuestas.getInstance();
		casaApuestas.realizarIngreso("Ingreso en efectivo por el Pago de una Apuesta", cantidad);

	}
	
	/**
	 * Metodo que realiza el ingreso al jugador
	 * 
	 * @param pago, unidades monetarias que recibe el ganador de una apuesta 
	 * 
	 */
	public void abonarPagoApuesta(float pago) {
		esteJugador.realizarIngreso("Cobro de premio de apuesta sobre " +conceptoPartido, pago);
		yaPagado=true; //Al pagar la apuesta se indica que ya se ha pagado, por si se intenta pagar otra vez
	}
	
	
	/**
	 * Método que devuelve datos como Modalidad, Jugador, Cantidad, Resultado, Concepto
	 * 
	 * @return una cadena con la información que identifica a este apuesta
	 */
	public String verFichaApuesta(){
		return "Apuesta de tipo " +modalidad+": El jugador "+esteJugador.getLogin()+" ha apostado "+cantidad+" al resultado '"+resultadoApostado+ "' en el partido " + conceptoPartido;
	}
	
	/**
	 * Método que devuelve la cantidad apostada en la apuesta
	 * 
	 * @return cantidad
	 */
	public float getCantidad() {
		return cantidad;
	}
	
	/**
	 * Método que fija la cantidad apostado
	 * 
	 * @param cantidad, cantidad apostada
	 */	
	public void setCantidad(float cantidad) {
		this.cantidad = cantidad;
	}
	
	/**
	 * Método que devuelve el resultado
	 * 
	 * @return el resultado
	 */
	public String getResultadoApostado() {
		return resultadoApostado;
	}

	/**
	 * Método que fija el resultado del partido
	 * 
	 * @param resultado, el resultado de un partido
	 */
	public void setResultadoApostado(String resultadoApostado) {
		this.resultadoApostado=resultadoApostado;
	}
	
	/**
	 * Método que devuelve el concepto del partido
	 * 
	 * @return concepto Partido
	 */
	public String getConceptoPartido() {
		return conceptoPartido;
	}

	/**
	 * Método que fija concepto del partido
	 * 
	 * @param conceptoPartido, aparecen los equipos que se enfrentan
	 */
	public void setConceptoPartido(String conceptoPartido) {
		this.conceptoPartido = conceptoPartido;
	}
	
	/**
	 * Método que devuelve el tipo de apuesta de cada partido
	 * 
	 * @return modalidad
	 */
	public TipoApuestas getTipoApuestas() {
		return modalidad;
	}

	/**
	 * Método que fija el tipo de apuesta de cada partido
	 * 
	 * @param modalidad el nuevo valor para modalidad
	 */
	public void setIdPartido(TipoApuestas modalidad) {
		this.modalidad = modalidad;
	}
	
	/**
	 * Método que devuelve esteJugador
	 * 
	 * @return esteJugador
	 */
	public Jugador getJugador() {
		return esteJugador;
	}

	/**
	 * Método que fija el valor de esteJugador
	 * 
	 * @param esteJugador, incluye los datos de un jugador
	 */
	public void setJugador(Jugador esteJugador) {
		this.esteJugador = esteJugador;
	}
	
	/**
	 * Método que devuelve yaPagado. yaPagado=true, ya se ha pagado. yaPagado=false, la apuesta todavia no se ha pagado
	 * 
	 * @param yaPagado, indica si la apuesta esta o no pagada
	 */
	public Boolean getYaPagado() {
		return yaPagado;
	}

	/**
	 * Método que fija el valor a yaPagado. yaPagado=true, ya se ha pagado. yaPagado=false, la apuesta todavia no se ha pagado
	 * 
	 * @param yaPagado, indica si la apuesta esta o no pagada
	 */
	public void setYaPagado(Boolean yaPagado) {
		this.yaPagado = yaPagado;
	}

}
