package casaapuestas.partidos; //Importamos librerias y paquetes necesarios

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import casaapuestas.cuentas.ExcepcionCuenta;
import casaapuestas.equipos.Equipo;
import casaapuestas.usuarios.CasaApuestas;
import casaapuestas.usuarios.Jugador;
import casaapuestas.apuestas.Apuesta;
import casaapuestas.apuestas.CausaExcepcionApuesta;
import casaapuestas.apuestas.ExcepcionApuesta;
import casaapuestas.apuestas.TipoApuestas;


/**
 * Clase que representa a un Partido en la casa de apuestas. Tiene los atributos comunes a todos ellos, y métodos <i>getter</i> y <i>setter</i>.
 */
public class Partido implements IConstantesApuestas{

	/**  Identificador unico de cada partido */
	private String idPartido;
	 /**  Instante a partir del cual se pueden realizar apuestas */
	private Calendar inicioApuestas;
	/**  Marca el fin de las apuestas*/
	private Calendar finApuestas;
	/**  Datos del equipo local*/
	private Equipo equipoLocal;
	/**  Datos del equipo visitante*/
	private Equipo equipoVisitante;
	/** La lista de apuestas del partido  */
	private List<Apuesta> listaApuestas;
	/** Recoge el resultado final de las apuestas tipo Marcador */
	private String resultadoFinalMarcador;
	/** Recoge el resultado final de las apuestas tipo Quiniela */
	private String resultadoFinalQuiniela;
	/** Recoge el resultado final de las apuestas tipo Corners */
	private String resultadoFinalCorners;

	/**
	 * Constructor que crea una instancia de la clase Partido recibiendo como parámetros todos los atributos
	 * 
	 * @param idPartido,  identificador único partido
	 * @param inicioApuestas, instante a partir del cual se pueden realizar apuestas
	 * @param finApuestas, marca el fin de las apuestas
	 * @param equipoLocal, datos del equipo que juega en su propia cancha
	 * @param equipoVisitante, datos del equipo que juega en una cancha que no es suya
	 */
	public Partido(String idPartido, Calendar inicioApuestas,Calendar finApuestas, Equipo equipoLocal, Equipo equipoVisitante) {
		super();
		this.idPartido=idPartido;
		this.inicioApuestas=inicioApuestas;
		this.finApuestas=finApuestas;
		this.equipoLocal=equipoLocal;
		this.equipoVisitante=equipoVisitante;

		// Inicializa las colecciones
		listaApuestas = new ArrayList<Apuesta>();
	}
	
	/**
	 * Metodo que realiza los calculo que permiten asignar las unidades monetarias a repartir entre
	 * los agraciados con premios como en beneficio de la casa de apuesta
	 * 
	 * @throws ExcepcionApuesta, recoge excepciones como NO_EXISTE, FECHAS_INCORRECTAS, RESULTADOS_NO_INTRODUCIDOS, APUESTAS_YA_PAGADAS
	 * 
	 * @param modalidad, hay tres modalidades de TipoApuestas: Marcador, Quiniela, Corners
	 * @param conceptoPartido, cadena que permite identificar la razon por la cual se realiza el ingreso
	 */
	public void pagarApuesta(TipoApuestas modalidad,String conceptoPartido)	throws ExcepcionApuesta{
		
		/**Si alguno de los campos no esta vacio, quiere decir que se ha introducido algun tipo de resultado, 
		 * por el contrario, si todos los campos son igual a null, se lanzara una excepcion que indicara que
		 *  no se han introducido resultado en ninguno de los campos
		 */
		if(resultadoFinalMarcador!=null && resultadoFinalQuiniela!=null && resultadoFinalCorners!=null) {
		//Creamos e inicializamos a 0, estas variables auxiliares
		float totalApostado=0;	
		float totalApostadoGanador=0;
		//Recorremos la listaApuestas, y vamos recogiendo la modalidad de cada apuesta, asi como la cantidad apostada
		for(Apuesta a:listaApuestas) {			
			if(modalidad==a.getTipoApuestas()) {
					float cantidad=a.getCantidad();
					totalApostado=totalApostado+cantidad;
					}
		}
		//Creamos una instancia de CasaApuestas
		CasaApuestas casaApuestas=CasaApuestas.getInstance();
		//Pasa a realizaIngreso, una cadena para que se guarde en la lista de movimientos
		casaApuestas.realizarIngreso("Ganancia de la casa de apuestas sobre "+ conceptoPartido,  RATIO_CASA_APUESTAS* totalApostado);
		
		//Recorremos listaApuestas
		for(Apuesta a:listaApuestas) {	
			if(modalidad==a.getTipoApuestas()) {
				//Cuando la modalidad es tipo MARCADOR...
			if(modalidad==TipoApuestas.MARCADOR) {
				//se comparan los valores de resultadoFinalMarcador y getResultadoApustado
				if(resultadoFinalMarcador.equals(a.getResultadoApostado())) {
					//en caso de ser iguales, se inicializa cantidad on el valor que devuelve getCantidad
					float cantidad=a.getCantidad();
					totalApostadoGanador=totalApostadoGanador+cantidad;
					}
				}
			//Cuando la modalidad es tipo QUINIELA...
				else if(modalidad==TipoApuestas.QUINIELA) {
					//se comparan los valores de resultadoFinalQuiniela y getResultadoApustado
					if(resultadoFinalQuiniela.equals(a.getResultadoApostado())) {
						//en caso de ser iguales, se inicializa cantidad on el valor que devuelve getCantidad
						float cantidad=a.getCantidad();
						totalApostadoGanador=totalApostadoGanador+cantidad;
						}
				}
			//Cuando la modalidad es tipo CORNERES...
				else if(modalidad==TipoApuestas.CORNERS) {
					//se comparan los valores de resultadoFinalCorners y getResultadoApustado
					if(resultadoFinalCorners.equals(a.getResultadoApostado())) {
						//en caso de ser iguales, se inicializa cantidad on el valor que devuelve getCantidad
						float cantidad=a.getCantidad();
						totalApostadoGanador=totalApostadoGanador+cantidad;
						}
				}
			}
		}
		//se recorre la lista de apuestas
		for(Apuesta a:listaApuestas) {	
			//se inicializa cantidad con lo que devuelve getCantidad
			float cantidad=a.getCantidad();
			if(modalidad==a.getTipoApuestas()) {
				//Si la modalidad es del tipo Marcador...
			if(modalidad==TipoApuestas.MARCADOR) {
				//y el resultadoFinalMarcador es igual al valor que devuelve getResultadoApostado
				if(resultadoFinalMarcador.equals(a.getResultadoApostado())) {
					//se calcula el ratio de premios, que le corresponde a cada premiado
					float ratio=(cantidad)/totalApostadoGanador;
					//se calcula el premio que va a obtener cada premiado
					float pago=RATIO_PREMIOS*totalApostado*ratio;
					//Si el pago no se habia realizado, getYaPagado=false, se llama a la funcion
					//abonarPagoApuesta, se la pasa el valor a pagar
					if(a.getYaPagado()==false) {
					a.abonarPagoApuesta(pago);
					
					}
					else {
						// Si ya se ha pagado la apuesta, getYaPagado=true, se lanza una excepcion
						throw new ExcepcionApuesta(CausaExcepcionApuesta.APUESTAS_YA_PAGADAS);
					}
				}
				}
			//Si la modalidad es del tipo Quiniela...
				else if(modalidad==TipoApuestas.QUINIELA) {
					//y el resultadoFinalQuiniela es igual al valor que devuelve getResultadoApostado
					if(resultadoFinalQuiniela.equals(a.getResultadoApostado())) {
						//se calcula el ratio de premios, que le corresponde a cada premiado
						float ratio=(cantidad)/totalApostadoGanador;
						//se calcula el premio que va a obtener cada premiado
						float pago=RATIO_PREMIOS*totalApostado*ratio;
						//Si el pago no se habia realizado, getYaPagado=false, se llama a la funcion
						//abonarPagoApuesta, se la pasa el valor a pagar
						if(a.getYaPagado()==false) {
							a.abonarPagoApuesta(pago);
							
							}
							else {
								// Si ya se ha pagado la apuesta, getYaPagado=true, se lanza una excepcion
								throw new ExcepcionApuesta(CausaExcepcionApuesta.APUESTAS_YA_PAGADAS);
							}
				}
				}
			//Si la modalidad es del tipo Corners...
				else if(modalidad==TipoApuestas.CORNERS) {
					//y el resultadoFinalCorners es igual al valor que devuelve getResultadoApostado
					if(resultadoFinalCorners.equals(a.getResultadoApostado())) {
						//se calcula el ratio de premios, que le corresponde a cada premiado
						float ratio=(cantidad)/totalApostadoGanador;
						//se calcula el premio que va a obtener cada premiado
						float pago=RATIO_PREMIOS*totalApostado*ratio;
						//Si el pago no se habia realizado, getYaPagado=false, se llama a la funcion
						//abonarPagoApuesta, se la pasa el valor a pagar
						if(a.getYaPagado()==false) {
							a.abonarPagoApuesta(pago);
							
							}
							else {
								// Si ya se ha pagado la apuesta, getYaPagado=true, se lanza una excepcion
								throw new ExcepcionApuesta(CausaExcepcionApuesta.APUESTAS_YA_PAGADAS);
							}
					}
				}
			}
		}
		}
		//si los campos estan vacios, se lanza una excepcion indicando que no se han introducido los resultados
		else {
			throw new ExcepcionApuesta(CausaExcepcionApuesta.RESULTADOS_NO_INTRODUCIDOS	);
		}
}


	/**
	 * Método que permite realizar una apuesta, añadiendo a la misma, sus parametros
	 *
	 * @param idPartido,  identificador único partido
	 * @param esteJugador, el jugador que va a realizar la apuesta
	 * @param resultadoApostado, la apuesta propiamente dicha del jugador
	 * @param cantidad, la cantidad (positiva) que se reintegra	
	 * @param modalidad, hay tres modalidades de TipoApuestas: Marcador, Quiniela, Corners
	 * @param conceptoPartido, cadena que permite identificar la razon por la cual se realiza el ingreso
	 * 
	 * @throws ExcepcionPartido,  si la hora actual no se encuentra entre inicioApuestas y finApuestas
	 * @throws ExcepcionCuenta si la <code>cantidad</code> es mayor que el saldo de la cuenta
	 */
	public void realizarApuesta(String idPartido, Jugador esteJugador,String resultadoApostado,float cantidad,TipoApuestas modalidad,String conceptoPartido) 
	throws ExcepcionPartidos, ExcepcionCuenta{

		//Creamos una variable ahora de tipo Calendar donde almacenamos la hora actual. (En este caso hemos definido una hora concreta para que se pueda apostar)
		Calendar ahora = Calendar.getInstance();
		ahora.clear();
		ahora.set(2015, Calendar.MAY, 9, 8, 0);
		//La apuesta se realiza siempre y cuando, estemos en el horario permitido
		if(ahora.after(inicioApuestas) && ahora.before(finApuestas)) {
		// Crea la apuesta
		Apuesta a = new Apuesta(esteJugador,cantidad, resultadoApostado, modalidad,conceptoPartido);
		// Lo añade a la lista de apuestas
		listaApuestas.add(a);		
		}	else {
			// Se lanza una excepcion si la hora actual no se encuentra entre inicioApuestas y finApuestas
			throw new ExcepcionPartidos(CausaExcepcionPartidos.PARTIDO_CERRADO, idPartido);
				}
	}
	
	/**
	 * Método que permite obtener un listado de las apuestas por el  <code>idPartido</code>
	 * @param idPartido identificador unico de cada partido
	 * @return listado de cadenas, donde cada elemento corresponde a una apuesta
	 */
	public List<String> listarApuestas(String idPartido) {
		//Inicializa el listado
				List<String> listadoApuestas = new ArrayList<String>();

				//Recorre la lista de apuestas
				for(Apuesta a : listaApuestas) {	
					//Cada apuesta nos devuelve una cadena donde van los datos relacionados con la apuesta
						String fichaApuesta = a.verFichaApuesta();
					//A cada apuesta le pide que informe sobre él, y el resultado lo añade al listado
					listadoApuestas.add(fichaApuesta);
				}
				//Al terminar retorna el listado
				return listadoApuestas;
	}
	
	/**
	 * Método que permite mostrar en una sola cadena TODA la información relevante de un Partido
	 * 
	 * @return una cadena con toda la información de este Partido
	 */
	public String verFichaCompletaPartido() {
		// Compone una cadena con todos los campos y la retorna
		return "\nId Partido: " + idPartido + "\nFecha Inicio: " + inicioApuestas.get(Calendar.HOUR_OF_DAY) + ":" + inicioApuestas.get(Calendar.MINUTE) + ":" + inicioApuestas.get(Calendar.SECOND) + " " + inicioApuestas.get(Calendar.DAY_OF_MONTH) + "/" + inicioApuestas.get(Calendar.MONTH) + "/" + inicioApuestas.get(Calendar.YEAR) + "\nFecha Final: "  + finApuestas.get(Calendar.HOUR_OF_DAY) + ":" + finApuestas.get(Calendar.MINUTE) + ":" + finApuestas.get(Calendar.SECOND) + " " + finApuestas.get(Calendar.DAY_OF_MONTH) + "/" + finApuestas.get(Calendar.MONTH) + "/" + finApuestas.get(Calendar.YEAR) + "\nEquipo Local: " + equipoLocal.getIdEquipo() + "\nEquipo Visitante: " + equipoVisitante.getIdEquipo();
	}
	
	/**
	 * Método que permite mostrar sólo la información necesaria para identificar un Partido
	 * 
	 * @return una cadena con la información breve que identifica al partido
	 */
	public String verFichaBrevePartido() {
		// Compone una cadena con los campos relevantes y la retorna
		return "\nId Partido: " + idPartido + "\nEquipo Local: " + equipoLocal.getIdEquipo() + "\nEquipo Visitante: " + equipoVisitante.getIdEquipo();
	
	}

	/**
	 * Método que devuelve el identificador de un partido,  idPartido
	 * 
	 * @return idPartido
	 */
	public String getIdPartido() {
		return idPartido;
	}
	
	/**
	 * Método que fiaj el identificador de un partido
	 * 
	 * @param id Partido, el nuevo identificador
	 */
	public void setIdPartido(String idPartido) {
		this.idPartido = idPartido;
	}
		
	/**
	 * Método que devuelve la hora de inicio de un partido
	 * 
	 * @return la hora de inicio de las apuestas
	 */
	public Calendar getFechaInicio() {
		return inicioApuestas;
	}

	/**
	 * Método que fija la hora del inicio de las apuestas
	 * 
	 * @param inicioApuestas, la nueva hora para poder apostar
	 */
	public void setFechaInicio(Calendar inicioApuestas) {
		this.inicioApuestas = inicioApuestas;
	}

	/**
	 * Método que devuelve la hora final de las apuestas
	 * 
	 * @return el momento en el que finzalizan las apuestas
	 */
	public Calendar getFechaFinal() {
		return finApuestas;
	}
	
	/**
	 * Método que fija el la hora del fin de las apuestas
	 * 
	 * @param finApuestas, la nueva del final de las apuestas
	 */
	public void setFechaFinal(Calendar finApuestas) {
		this.finApuestas = finApuestas;
	}

	/**
	 * Método que devuelve los datos del equipo visitante
	 * 
	 * @return los datos del equipo visitante
	 */
	public Equipo getEquipoVisitante() {
		return equipoVisitante;
	}

	/**
	 * Método que fija los datos del equipo visitante
	 * 
	 * @param equipoVisitante, datos del equipo visitante
	 */
	public void setEquipoVisitante(Equipo equipoVisitante) {
		this.equipoVisitante = equipoVisitante;
	}

	/**
	 * Método que devuelve los datos del equipo local
	 * 
	 * @return los datos del equipo local
	 */
	public Equipo  getEquipoLocal() {
		return equipoLocal;
	}
	
	/**
	 * Método que fija los datos del equipo local
	 * 
	 * @param equipoLocal, los datos del equipo local
	 */
	public void setEquipoLocal(Equipo equipoLocal) {
		this.equipoLocal = equipoLocal;
	}
	
	/**
	 * Método que fija el resultado final del partido
	 * 
	 * @param idPartido, identificador unico de cada partido
	 * @param modalidad, tipo de apuesta realizada sobre este partido
	 * @param resultadoFinal, recoge el resultado final
	 */
	public void introducirResultadoFinal(String idPartido, TipoApuestas modalidad,String resultadoFinal) 
	throws ExcepcionPartidos, ExcepcionApuesta{
		//Se comprueba que no se haya pagado aún alguna apuesta del partido
		for(Apuesta a: listaApuestas) {
			if(a.getYaPagado()==true) {
				// Pero si se ha pagado lanza una excepción
				throw new ExcepcionApuesta(CausaExcepcionApuesta.APUESTAS_YA_PAGADAS);
			}
			
		}
		
		//Creamos una variable ahora de tipo Calendar donde almacenamos la hora actual. (En este caso hemos definido una hora concreta para que se pueda apostar)
		Calendar ahora = Calendar.getInstance();
		ahora.clear();
		ahora.set(2015, Calendar.MAY, 11, 8, 0);
		//La apuesta se realiza siempre y cuando, estemos en el horario permitido
		if(ahora.after(finApuestas)) {
		//introducimos el resultado final dependiendo la modalidad que tengamos
		if(modalidad==TipoApuestas.MARCADOR) {
		this.resultadoFinalMarcador = resultadoFinal;	
		}
		else if(modalidad==TipoApuestas.QUINIELA) {
			this.resultadoFinalQuiniela = resultadoFinal;
		}
		else if(modalidad==TipoApuestas.CORNERS) {
			this.resultadoFinalCorners = resultadoFinal;
		}
		
		}
		else {
			// Pero si el partido aún no ha acabado se lanza una excepción
			throw new ExcepcionPartidos(CausaExcepcionPartidos.PARTIDO_ABIERTO, idPartido);
		}
	}
	}

