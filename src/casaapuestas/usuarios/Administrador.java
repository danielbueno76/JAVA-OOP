package casaapuestas.usuarios;


/**
 * Clase que representa a un Administrador en la casa de apuestas. Deriva de <code>Usuario</code>
 * 
 */
public class Administrador extends Usuario {
	
	/**
	 * Constructor que recibe como parámetros todos los campos necesarios para crear una instancia de <code>Usuario</code>
	 * 
	 * @param login el login, o identificador único de usuario
	 * @param clave la clave del usuario (en claro)
	 * @param nombre el nombre del usuario
	 * @param apellidos los apellidos del usuario
	 * @param nif el NIF del usuario
	 * @param movil el número de teléfono del usuario
	 * @param correo la dirección de correo del usuario
	 * @param metodo el método de mensajería preferido por el usuario
	 */
	
	public Administrador(String login, String clave, String nombre,	String apellidos, String nif, String movil, String correo,MetodoMensajeria metodo) 
	{
		// Invoca al constructor de la superclase
		super(login, clave, nombre, apellidos, nif, movil, correo, metodo);
	}

}
