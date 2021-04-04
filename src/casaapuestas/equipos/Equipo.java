package casaapuestas.equipos; //Importamos paquetes necesarios

/**
 * Clase que representa un equipo en la casa de apuestas. Tiene los atributos comunes a todos ellos, y m�todos <i>getter</i> y <i>setter</i>.
 */

public class Equipo{
	/** La division en la que participa el equipo */
	private String division;
	/** El nombre del pais*/
	private String pais;
	/** El nombre del equipo */
	private String nombreEquipo;
	/** el identificador del equipo*/
	private String idEquipo;
	
	/**
	 * Constructor que recibe como parametros todos los campos necesarios para crear una instancia de <code>Equipo</code>
	 * 
	 * @param idEquipo, identificador del equipo
	 * @param nombreEquipo , nombre que recibe el equipo
	 * @param pais , pais de origen del equipo
	 * @param division , division en la que juega el equipo
	 */
	public Equipo(String idEquipo,String nombreEquipo, String pais, String division) {
		super();
		this.idEquipo=idEquipo;
		this.division=division;
		this.nombreEquipo=nombreEquipo;
		this.pais=pais;

	}
	
	/**
	 * Metodo que devuelve el identificador de un equipo
	 * @return idEquipo, el identificador del equipo
	 */
	public String  getIdEquipo() {
		return idEquipo;
	}

	/**
	 * Metodo que fija el identificador del equipo
	 * 
	 * @param idEquipo, identificador del equipo
	 * 
	 */
	public void setIdEquipo(String idEquipo) {
		this.idEquipo = idEquipo;
	}
	
	/**
	 * Metodo que devuelve el nombre del equipo
	 * 
	 * @return nombreEquipo, nombre del equipo
	 */
	public String  getNombreEquipo() {
		return nombreEquipo;
	}

	/**
	 * Metodo que fija el nombre del equipo
	 * 
	 * @param nombreEquipo, el nuevo valor para el nombreEquipo
	 */
	public void setNombreEquipo(String nombreEquipo) {
		this.nombreEquipo = nombreEquipo;
	}
	
	/**
	 * Metodo que devuelve la divisi�n en la que juega
	 * 
	 * @return divisi�n, es la categoria en la que juega cada equipo
	 */
	public String  getDivision() {
		return division;
	}
	
	/**
	 * Metodo que fija un nuevo valor para divisi�n
	 * 
	 * @param divisi�n, categoria en la que juega un equipo 
	 */
	public void setDivision(String division) {
		this.division = division;
	}
	
	/**
	 * Metodo que devuelve el pa�s en el que juega
	 * 
	 * @return el pais
	 */
	public String getPais() {
		return pais;
	}

	/**
	 * Metodo que fija un nuevo valor para pa�s donde juega el equipo
	 * 
	 * @param pais, estado donde juega el equipo
	 */
	public void setPais(String pais) {
		this.pais = pais;
	}
	
		
		
	/**
	 * Metodo que permite a un equipo mostrar en una sola cadena toda su informaci�n relevante
	 * 
	 * @return una cadena con toda la informaci�n de este equipo
	 */
	public String verFichaCompletaEquipo() {
	
		// Compone una cadena con todos los campos y los devuelve
		return "IdEquipo: "+idEquipo+"\nNombre Equipo Completo: " + nombreEquipo + "\nPais: " + pais + "\nDivision: " + division;
	}
	
	
	/**
	 * Metodo que permite a un equipo mostrar s�lo la informaci�n necesaria para identificarle
	 * 
	 * @return una cadena con la informaci�n que identifica a este equipo(idEquipo)
	 */
	
	public String verFichaBreveEquipo() {
		// Compone una cadena con los campos relevantes y la retorna
		return "Id Equipo: " + idEquipo;
	}

	
}
