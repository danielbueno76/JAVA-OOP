package casaapuestas.usuarios;


/**
 * Clase que representa a un Administrador en la casa de apuestas. Deriva de <code>Usuario</code>
 * 
 */
public class Administrador extends Usuario {
	
	/**
	 * Constructor que recibe como par�metros todos los campos necesarios para crear una instancia de <code>Usuario</code>
	 * 
	 * @param login el login, o identificador �nico de usuario
	 * @param clave la clave del usuario (en claro)
	 * @param nombre el nombre del usuario
	 * @param apellidos los apellidos del usuario
	 * @param nif el NIF del usuario
	 * @param movil el n�mero de tel�fono del usuario
	 * @param correo la direcci�n de correo del usuario
	 * @param metodo el m�todo de mensajer�a preferido por el usuario
	 */
	
	public Administrador(String login, String clave, String nombre,	String apellidos, String nif, String movil, String correo,MetodoMensajeria metodo) 
	{
		// Invoca al constructor de la superclase
		super(login, clave, nombre, apellidos, nif, movil, correo, metodo);
	}

}
