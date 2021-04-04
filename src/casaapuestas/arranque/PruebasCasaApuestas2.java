package casaapuestas.arranque;

import java.util.Calendar;
import java.util.List;

import casaapuestas.apuestas.ExcepcionApuesta;
import casaapuestas.apuestas.TipoApuestas;
import casaapuestas.cuentas.ExcepcionCuenta;
import casaapuestas.equipos.ControladorEquipos;
import casaapuestas.equipos.ExcepcionEquipos;
import casaapuestas.partidos.ControladorPartidos;
import casaapuestas.partidos.ExcepcionPartidos;
import casaapuestas.usuarios.ControladorUsuarios;
import casaapuestas.usuarios.ExcepcionUsuario;
import casaapuestas.usuarios.MetodoMensajeria;

/**
 * Clase con un main() de pruebas para la iteración 0, entregada por el profesor.
 * @author Eduardo Gómez Sánchez, ETSIT UVa.
 *
 */
public class PruebasCasaApuestas2 {

	/**
	 * Método main(). No se esperan parámetros.
	 * @param args parámetros en línea de comandos, pero se ignoran.
	 */
	public static void main(String[] args) {
		//Crea una instancia de controlador de equipos
		ControladorEquipos ce = new ControladorEquipos();	
		//Crea una instancia de controlador de usuarios
		ControladorUsuarios cu = new ControladorUsuarios();
		//Crea una instancia de controlador de partidos
		ControladorPartidos cp = new ControladorPartidos(cu,ce);

		////////////////////////////////////////////////////////
		// CASOS DE USO PREVIOS
		////////////////////////////////////////////////////////	
		try {
			// Crea varios jugadores
			cu.crearJugador("jugador0", "miclave", "Nombre", "Apellidos", "00000000A", "666666666", "edugom@tel.uva.es", MetodoMensajeria.SMS);
			cu.crearJugador("jugador1", "miclave", "Nombre", "Apellidos", "00000000A", "666666666", "edugom@tel.uva.es", MetodoMensajeria.SMS);
			cu.crearJugador("jugador2", "miclave", "Nombre", "Apellidos", "00000000A", "666666666", "edugom@tel.uva.es", MetodoMensajeria.SMS);
			cu.crearJugador("jugador3", "miclave", "Nombre", "Apellidos", "00000000A", "666666666", "edugom@tel.uva.es", MetodoMensajeria.SMS);
			cu.crearJugador("jugador4", "miclave", "Nombre", "Apellidos", "00000000A", "666666666", "edugom@tel.uva.es", MetodoMensajeria.SMS);
			cu.crearJugador("jugador5", "miclave", "Nombre", "Apellidos", "00000000A", "666666666", "edugom@tel.uva.es", MetodoMensajeria.SMS);
			cu.crearJugador("jugador6", "miclave", "Nombre", "Apellidos", "00000000A", "666666666", "edugom@tel.uva.es", MetodoMensajeria.SMS);
			cu.crearJugador("jugador7", "miclave", "Nombre", "Apellidos", "00000000A", "666666666", "edugom@tel.uva.es", MetodoMensajeria.SMS);
			cu.crearJugador("jugador8", "miclave", "Nombre", "Apellidos", "00000000A", "666666666", "edugom@tel.uva.es", MetodoMensajeria.SMS);
			cu.crearJugador("jugador9", "miclave", "Nombre", "Apellidos", "00000000A", "666666666", "edugom@tel.uva.es", MetodoMensajeria.SMS);
			cu.crearAdministrador("Administrador", "clave", "Secreto", "Secreto Secreto", "12222222B", "66323237", "admin@tel.uva.es", MetodoMensajeria.CORREO);
			
			// Ingresa de partida 100 euros en la cuenta de cada uno
			cu.realizarIngresoEnCuentaJugador("jugador0", (float)100.00);
			cu.realizarIngresoEnCuentaJugador("jugador1", (float)100.00);
			cu.realizarIngresoEnCuentaJugador("jugador2", (float)100.00);
			cu.realizarIngresoEnCuentaJugador("jugador3", (float)100.00);
			cu.realizarIngresoEnCuentaJugador("jugador4", (float)100.00);
			cu.realizarIngresoEnCuentaJugador("jugador5", (float)100.00);
			cu.realizarIngresoEnCuentaJugador("jugador6", (float)100.00);
			cu.realizarIngresoEnCuentaJugador("jugador7", (float)100.00);
			cu.realizarIngresoEnCuentaJugador("jugador8", (float)100.00);
			cu.realizarIngresoEnCuentaJugador("jugador9", (float)100.00);
			cu.realizarIngresoEnCasaApuestas("Administrador", (float)100000000.00);	

			// Crea varios equipos
			System.out.println("\nCreo seis equipos");
			ce.crearEquipo("Valladolid","Real Valladolid Club de Fútbol, S.A.D", "España", "Liga Adelante");
			ce.crearEquipo("Aston Birra","Aston Birra F.C", "España", "Trofeo Rector");
			ce.crearEquipo("Mirandes", "Club Deportivo Mirandés, S.A.D.", "España", "Liga Adelante");
			ce.crearEquipo("Ponferradina", "Sociedad Deportiva Ponferradina, S.A.D", "España", "Liga Adelante");
			ce.crearEquipo("Burgos", "Real Burgos Club de Fútbol, S.A.D", "España", "2ª Division B");
			ce.crearEquipo("Zamora", "Zamora Club de Fútbol",  "España", "2ª Division B");
			//Se crea una fecha de inicio de las apuestas, que se fija al 8 de mayo de 2015, a las 8:00
			Calendar inicioApuestas = Calendar.getInstance();
			inicioApuestas.clear();
			inicioApuestas.set(2015, Calendar.MAY, 8, 8, 0);
			//Se crea una fecha de fin de las apuestas, que se fija al 10 de mayo de 2015, a las 19:30
			Calendar finApuestas = Calendar.getInstance();
			finApuestas.clear();
			finApuestas.set(2015, Calendar.MAY, 10, 19, 30);
			//Se crean otras dos fechas de inicio y fin de apuestas, para el fin de semana siguiente
			Calendar inicioApuestas2 = Calendar.getInstance();
			inicioApuestas2.clear();
			inicioApuestas2.set(2015, Calendar.MAY, 15, 8, 0);
			Calendar finApuestas2 = Calendar.getInstance();
			finApuestas2.clear();
			finApuestas2.set(2015, Calendar.MAY, 17, 19, 30);
			//Creo partidos, tres esta semana y tres la semana próxima
			System.out.println("\nCreo tres partidos");
			cp.crearPartido("p0", inicioApuestas, finApuestas,"Valladolid", "Aston Birra");		// Será el "p0"
			cp.crearPartido("p1", inicioApuestas, finApuestas,"Mirandes", "Ponferradina");		// Será el "p1"
			cp.crearPartido("p2", inicioApuestas, finApuestas,"Burgos", "Zamora");				// Será el "p2"
			cp.crearPartido("p3",inicioApuestas2, finApuestas2,"Zamora", "Mirandes");			// Será el "p3"
			cp.crearPartido("p4",inicioApuestas2, finApuestas2,"Aston Birra", "Ponferradina" );	// Será el "p4"
			cp.crearPartido("p5", inicioApuestas2, finApuestas2,"Burgos", "Valladolid");			// Será el "p5"
		} catch (ExcepcionUsuario eu) {
			//No se debería llegar hasta aquí, pero hay que comprobarlo
			System.out.println("Ha fallado una operación sobre el usuario con identificador '" + eu.getLogin() + "', por la siguiente causa: " + eu.getCausa().toString());
		} catch (ExcepcionEquipos ee) {
			//Si se llega hasta aquí alguna operación con equipos ha ido mal
			System.out.println("Ha fallado una operación sobre el equipo con identificador '" + ee.getIdEquipo() + "', por la siguiente causa: " + ee.getCausa().toString());
		} catch (ExcepcionPartidos ep) {
			//Si se llega hasta aquí alguna operación con partidos ha ido mal
			System.out.println("Ha fallado una operación sobre el partido con identificador '" + ep.getIdPartido() + "', por la siguiente causa: " + ep.getCausa().toString());
		} catch (ExcepcionApuesta ea) {
			//Si se llega hasta aquí alguna operación con apuestas ha ido mal
			System.out.println("Ha fallado una operación de apuestas por la siguiente causa: " + ea.getCausa().toString());
		}
		
		////////////////////////////////////////////////////////
		// CASOS DE USO EN ESCENARIOS DE ÉXITO
		////////////////////////////////////////////////////////	
		System.out.println("===============================================");
		System.out.println("PRUEBAS DE LA ITERACIÓN 2 - ESCENARIOS DE ÉXITO");
		System.out.println("===============================================");

		try {
			// Función de listar, limitando el listado a los partidos que admiten apuestas, necesaria en "crear apuesta"
			//NOTA: para que esto funcione hay que "trucar" el sistema de manera que crea que la fecha actual está en medio del intervalo en el que se admiten apuestas
			System.out.println("\nListo los partidos que admiten apuestas (sólo deberían salir tres)");
			List<String> listado = cp.listarPartidosAbiertos();
			for(String s : listado) {
				System.out.println(s);
			}
			
			//Caso de uso "crear apuesta"
			System.out.println("\nCreo apuestas de 'marcador' sobre el partido con identificador 'p0'. En total se apuestan 100 euros en esta modalidad y este partido.");
			cp.realizarApuesta("jugador0", "p0", TipoApuestas.MARCADOR, "1-1", (float)30.0);
			cp.realizarApuesta("jugador1", "p0", TipoApuestas.MARCADOR, "2-1", (float)10.0);
			cp.realizarApuesta("jugador2", "p0", TipoApuestas.MARCADOR, "0-1", (float)5.0);
			cp.realizarApuesta("jugador3", "p0", TipoApuestas.MARCADOR, "0-0", (float)8.0);
			cp.realizarApuesta("jugador4", "p0", TipoApuestas.MARCADOR, "1-2", (float)12.0);
			cp.realizarApuesta("jugador5", "p0", TipoApuestas.MARCADOR, "2-1", (float)15.0);
			cp.realizarApuesta("jugador6", "p0", TipoApuestas.MARCADOR, "1-1", (float)20.0);

			System.out.println("\nCreo apuestas de 'quiniela' sobre el partido con identificador 'p0'. En total se apuestan 50 euros en esta modalidad y este partido.");
			cp.realizarApuesta("jugador8", "p0", TipoApuestas.QUINIELA, "2", (float)10.0);
			cp.realizarApuesta("jugador7", "p0", TipoApuestas.QUINIELA, "X", (float)8.0);
			cp.realizarApuesta("jugador6", "p0", TipoApuestas.QUINIELA, "X", (float)2.0);
			cp.realizarApuesta("jugador5", "p0", TipoApuestas.QUINIELA, "1", (float)10.0);
			cp.realizarApuesta("jugador4", "p0", TipoApuestas.QUINIELA, "2", (float)8.0);
			cp.realizarApuesta("jugador3", "p0", TipoApuestas.QUINIELA, "1", (float)12.0);

			System.out.println("\nCreo apuestas de 'corners' sobre el partido con identificador 'p0'. En total se apuestan 50 euros en esta modalidad y este partido.");
			cp.realizarApuesta("jugador0", "p0", TipoApuestas.CORNERS, "X", (float)23.0);		//Ambos equipos tienen el mismo número de saques de esquina
			cp.realizarApuesta("jugador2", "p0", TipoApuestas.CORNERS, "1", (float)17.0);		//El equipo local tira más saques de esquina
			cp.realizarApuesta("jugador4", "p0", TipoApuestas.CORNERS, "X", (float)2.0);		//Ambos equipos tienen el mismo número de saques de esquina
			cp.realizarApuesta("jugador6", "p0", TipoApuestas.CORNERS, "2", (float)3.0);		//El equipo visitante tira más saques de esquina
			cp.realizarApuesta("jugador8", "p0", TipoApuestas.CORNERS, "1", (float)5.0);		//El equipo local tira más saques de esquina

			System.out.println("\nCreo apuestas de 'marcador' sobre el partido con identificador 'p1' para comprobar que se separa bien lo apostado en cada partido. En total se apuestan 20 euros en esta modalidad y este partido.");
			cp.realizarApuesta("jugador0", "p1", TipoApuestas.MARCADOR, "8-1", (float)15.0);
			cp.realizarApuesta("jugador1", "p1", TipoApuestas.MARCADOR, "5-1", (float)5.0);
			
			//Caso de uso "listar apuestas partido": aunque es anterior lo usamos para comprobar las apuestas
			System.out.println("\nListo las apuestas realizadas sobre el partido con identificador 'p0'. Deberían salir 7 de 'marcador', 6 de 'quiniela' y 5 de 'corners'");
			listado = cp.listarApuestasPartido("p0");
			for(String s : listado) {
				System.out.println(s);
			}
			
			// Caso de uso "listar movimientos de cuenta de jugador"
			System.out.println("\nListo los movimientos de la cuenta del jugador con identificador 'jugador6' para comprobar que se han anotado sus apuestas");
			listado = cu.listarMovimientosCuentaJugador("jugador6");
			for(String s : listado) {
				System.out.println(s);
			}

			//Caso de uso "introducir resultado"
			System.out.println("\nIntroduzco resultados en las distintas modalidades para el partido 'p0'");
			cp.introducirResultadoPartido("p0", TipoApuestas.MARCADOR, "1-1");		//Ganan 'jugador0' y 'jugador6': total apostado a ganador 50, total para premios 80, ratio de pago 1,6
			cp.introducirResultadoPartido("p0", TipoApuestas.QUINIELA, "X");			//Ganan 'jugador7' y 'jugador6': total apostado a ganador 10, total para premios 40, ratio de pago 4
			cp.introducirResultadoPartido("p0", TipoApuestas.CORNERS, "2");			//Gana 'jugador6': total apostado a ganador 5, total para premios 40, ratio de pagos 8
			
			//Caso de uso "pagar apuestas" (sería razonable también usar un sólo método para pagar todas las modalidades de un partido, o incluso para pagar todas las apuestas)
			System.out.println("\nPago las apuestas de todas las modalidades para el partido 'p0'");
			cp.pagarApuestasPartido("p0", TipoApuestas.MARCADOR);				//En marcador 'jugador0 cobra 48 y 'jugador6' cobra 32
			cp.pagarApuestasPartido("p0", TipoApuestas.QUINIELA);				//En quiniela 'jugador7' cobra 32 y 'jugador6' cobra 8
			cp.pagarApuestasPartido("p0", TipoApuestas.CORNERS);					//En corners 'jugador6' cobra 40
											
			
			// Caso de uso "listar movimientos de cuenta de jugador"
			System.out.println("\nListo los movimientos de la cuenta del jugador con identificador 'jugador0' para comprobar que ha cobrado bien sus premios");
			listado = cu.listarMovimientosCuentaJugador("jugador0");
			for(String s : listado) {
				System.out.println(s);
			}

			// Caso de uso "listar movimientos de cuenta de jugador"
			System.out.println("\nListo los movimientos de la cuenta del jugador con identificador 'jugador6' para comprobar que ha cobrado bien sus premios");
			listado = cu.listarMovimientosCuentaJugador("jugador6");
			for(String s : listado) {
				System.out.println(s);
			}
			
			System.out.println("\nListo los movimientos de la cuenta del jugador con identificador 'jugador7' para comprobar que ha cobrado bien su premio");
			listado = cu.listarMovimientosCuentaJugador("jugador7");
			for(String s : listado) {
				System.out.println(s);
			}			
		} catch (ExcepcionPartidos ep) {
			//Si se llega hasta aquí alguna operación con partidos ha ido mal
			System.out.println("Ha fallado una operación sobre el partido con identificador '" + ep.getIdPartido() + "', por la siguiente causa: " + ep.getCausa().toString());
		} catch (ExcepcionUsuario eu) {
			//Si se llega hasta aquí alguna operación con usuarios ha ido mal
			System.out.println("Ha fallado una operación sobre el usuario con identificador '" + eu.getLogin() + "', por la siguiente causa: " + eu.getCausa().toString());
		} catch (ExcepcionApuesta ea) {
			//Si se llega hasta aquí alguna operación con apuestas ha ido mal
			System.out.println("Ha fallado una operación de apuestas por la siguiente causa: " + ea.getCausa().toString());
		}
		 catch (ExcepcionCuenta ec) {
				//Si se llega hasta aquí alguna operación con apuestas ha ido mal
				System.out.println("Ha fallado una operación de apuestas por la siguiente causa: " + ec.getCausa().toString());
		}
		
		////////////////////////////////////////////////////////
		// CASOS DE USO EN ESCENARIOS DE FALLO
		////////////////////////////////////////////////////////	
		System.out.println("===============================================");
		System.out.println("PRUEBAS DE LA ITERACIÓN 1 - ESCENARIOS DE FALLO");
		System.out.println("===============================================");

		try {
			// Caso de uso "crear equipo": se intenta crear un equipo con un nombre corto que ya existe
			System.out.println("\nIntento crear un equipo con un identificador 'Valladolid'");
			ce.crearEquipo("Valladolid", "Fútbol Club La UVa","Imaginaria","Imaginaria");
		} catch (ExcepcionEquipos ee) {
			//Si se llega hasta aquí alguna operación con equipos ha ido mal
			System.out.println("Ha fallado una operación sobre el equipo con identificador '" + ee.getIdEquipo() + "', por la siguiente causa: " + ee.getCausa().toString());
		}
		
		try {
			// Caso de uso "ver equipo": se intenta mostrar un equipo que no existe
			System.out.println("\nIntento mostrar los datos del equipo 'Telecos'");
			String ficha = ce.verEquipo("Telecos");
			System.out.println(ficha);

		} catch (ExcepcionEquipos ee) {
			//Si se llega hasta aquí alguna operación con equipos ha ido mal
			System.out.println("Ha fallado una operación sobre el equipo con identificador '" + ee.getIdEquipo() + "', por la siguiente causa: " + ee.getCausa().toString());
		}
		
		//Operaciones auxiliares
		//Se crea una fecha de inicio de las apuestas, que se fija al 17 de abril de 2015, a las 8:00
		Calendar inicioApuestas = Calendar.getInstance();
		inicioApuestas.clear();
		inicioApuestas.set(2015, Calendar.APRIL, 17, 8, 0);
		//Se crea una fecha de fin de las apuestas, que se fija al 19 de abril de 2015, a las 19:30
		Calendar finApuestas = Calendar.getInstance();
		finApuestas.clear();
		finApuestas.set(2015, Calendar.APRIL, 19, 19, 30);

		try {
			//Caso de uso "crear partido": se intenta crear un partido con fechas en orden inverso
			System.out.println("\nIntento crear un partido con las fechas en orden inverso");
			cp.crearPartido("p6", finApuestas, inicioApuestas,"Valladolid", "Aston Birra");
		} catch (ExcepcionEquipos ee) {
			//Si se llega hasta aquí alguna operación con equipos ha ido mal
			System.out.println("Ha fallado una operación sobre el equipo con identificador '" + ee.getIdEquipo() + "', por la siguiente causa: " + ee.getCausa().toString());
		} catch (ExcepcionPartidos ep) {
			//Si se llega hasta aquí alguna operación con partidos ha ido mal
			System.out.println("Ha fallado una operación sobre el partido con identificador '" + ep.getIdPartido() + "', por la siguiente causa: " + ep.getCausa().toString());
		}  catch (ExcepcionApuesta ea) {
			//Si se llega hasta aquí alguna operación con apuestas ha ido mal
			System.out.println("Ha fallado una operación de apuestas por la siguiente causa: " + ea.getCausa().toString());
		}
		
		try {
			//Caso de uso "crear partido": se intenta crear un partido con equipos que no existen
			System.out.println("\nIntento crear un partido con equipos que no existen");
			cp.crearPartido("p7",inicioApuestas, finApuestas,"Telecos", "Informáticos") ;
		} catch (ExcepcionEquipos ee) {
			//Si se llega hasta aquí alguna operación con equipos ha ido mal
			System.out.println("Ha fallado una operación sobre el equipo con identificador '" + ee.getIdEquipo() + "', por la siguiente causa: " + ee.getCausa().toString());
		} catch (ExcepcionPartidos ep) {
			//Si se llega hasta aquí alguna operación con partidos ha ido mal
			System.out.println("Ha fallado una operación sobre el partido con identificador '" + ep.getIdPartido() + "', por la siguiente causa: " + ep.getCausa().toString());
		}  catch (ExcepcionApuesta ea) {
			//Si se llega hasta aquí alguna operación con apuestas ha ido mal
			System.out.println("Ha fallado una operación de apuestas por la siguiente causa: " + ea.getCausa().toString());
		}	
		
		try {
			//Caso de uso "modificar partido": se intenta modificar un partido con fechas en orden inverso
			System.out.println("\nIntento modificar un partido con las fechas en orden inverso");
			cp.modificarPartido("p1", finApuestas, inicioApuestas, "Valladolid", "Aston Birra");
		} catch (ExcepcionEquipos ee) {
			//Si se llega hasta aquí alguna operación con equipos ha ido mal
			System.out.println("Ha fallado una operación sobre el equipo con identificador '" + ee.getIdEquipo() + "', por la siguiente causa: " + ee.getCausa().toString());
		} catch (ExcepcionPartidos ep) {
			//Si se llega hasta aquí alguna operación con partidos ha ido mal
			System.out.println("Ha fallado una operación sobre el partido con identificador '" + ep.getIdPartido() + "', por la siguiente causa: " + ep.getCausa().toString());
		}

		try {
			//Caso de uso "modificar partido": se intenta modificar un partido con equipos que no existen
			System.out.println("\nIntento modificar un partido con equipos que no existen");
			cp.modificarPartido("p1", inicioApuestas, finApuestas, "Telecos", "Informáticos");
		} catch (ExcepcionEquipos ee) {
			//Si se llega hasta aquí alguna operación con equipos ha ido mal
			System.out.println("Ha fallado una operación sobre el equipo con identificador '" + ee.getIdEquipo() + "', por la siguiente causa: " + ee.getCausa().toString());
		} catch (ExcepcionPartidos ep) {
			//Si se llega hasta aquí alguna operación con partidos ha ido mal
			System.out.println("Ha fallado una operación sobre el partido con identificador '" + ep.getIdPartido() + "', por la siguiente causa: " + ep.getCausa().toString());
		}	

		try {
			//Caso de uso "ver partido": se intenta mostrar un partido que no existe
			System.out.println("\nIntento mostrar el partido con identificador 'ninguno'");
			String ficha = cp.verPartido("ninguno");
			System.out.println(ficha);
		} catch (ExcepcionPartidos ep) {
			//Si se llega hasta aquí alguna operación con partidos ha ido mal
			System.out.println("Ha fallado una operación sobre el partido con identificador '" + ep.getIdPartido() + "', por la siguiente causa: " + ep.getCausa().toString());
		}

		try {
			//Caso de uso "modificar partido": se intenta modificar un partido que no existe
			System.out.println("\nIntento modificar el partido con identificador 'ninguno'");
			cp.modificarPartido("ninguno", inicioApuestas, finApuestas, "Valladolid", "Aston Birra");
		} catch (ExcepcionEquipos ee) {
			//Si se llega hasta aquí alguna operación con equipos ha ido mal
			System.out.println("Ha fallado una operación sobre el equipo con identificador '" + ee.getIdEquipo() + "', por la siguiente causa: " + ee.getCausa().toString());
		} catch (ExcepcionPartidos ep) {
			//Si se llega hasta aquí alguna operación con partidos ha ido mal
			System.out.println("Ha fallado una operación sobre el partido con identificador '" + ep.getIdPartido() + "', por la siguiente causa: " + ep.getCausa().toString());
		}
		
		try {
			//Caso de uso "eliminar partido": se intenta eliminar un partido que no existe
			System.out.println("\nIntento eliminar el partido con identificador 'ninguno'");
			cp.borrarPartido("ninguno");
		} catch (ExcepcionPartidos ep) {
			//Si se llega hasta aquí alguna operación con partidos ha ido mal
			System.out.println("Ha fallado una operación sobre el partido con identificador '" + ep.getIdPartido() + "', por la siguiente causa: " + ep.getCausa().toString());
		}

		try {
			//Caso de uso "crear apuesta": se intenta crear una apuesta sobre un partido que no existe
			System.out.println("\nIntento crear una apuesta sobre el partido con identificador 'ninguno'");
			cp.realizarApuesta("jugador0", "ninguno", TipoApuestas.MARCADOR, "0-0", (float)10.0);		
		} catch (ExcepcionPartidos ep) {
			//Si se llega hasta aquí alguna operación con partidos ha ido mal
			System.out.println("Ha fallado una operación sobre el partido con identificador '" + ep.getIdPartido() + "', por la siguiente causa: " + ep.getCausa().toString());
		} catch (ExcepcionUsuario eu) {
			//Si se llega hasta aquí alguna operación con usuarios ha ido mal
			System.out.println("Ha fallado una operación sobre el usuario con identificador '" + eu.getLogin() + "', por la siguiente causa: " + eu.getCausa().toString());
		}
		catch (ExcepcionCuenta ec) {
			//Si se llega hasta aquí alguna operación con apuestas ha ido mal
			System.out.println("Ha fallado una operación de apuestas por la siguiente causa: " + ec.getCausa().toString());
		}
		
		try {
			//Caso de uso "crear apuesta": se intenta crear una apuesta sobre un partido que no acepta apuestas
			System.out.println("\nIntento crear una apuesta sobre un partido que no acepta apuestas hasta la semana siguiente");
			cp.realizarApuesta("jugador0", "p3", TipoApuestas.MARCADOR, "0-0", (float)10.0);		
		} catch (ExcepcionPartidos ep) {
			//Si se llega hasta aquí alguna operación con partidos ha ido mal
			System.out.println("Ha fallado una operación sobre el partido con identificador '" + ep.getIdPartido() + "', por la siguiente causa: " + ep.getCausa().toString());
		} catch (ExcepcionUsuario eu) {
			//Si se llega hasta aquí alguna operación con usuarios ha ido mal
			System.out.println("Ha fallado una operación sobre el usuario con identificador '" + eu.getLogin() + "', por la siguiente causa: " + eu.getCausa().toString());
		}
		catch (ExcepcionCuenta ec) {
			//Si se llega hasta aquí alguna operación con apuestas ha ido mal
			System.out.println("Ha fallado una operación de apuestas por la siguiente causa: " + ec.getCausa().toString());
		}

		try {
			//Caso de uso "crear apuesta": se intenta crear una apuesta por encima del saldo del usuario
			System.out.println("\nIntento crear una apuesta por 500 euros de un jugador que menos");
			cp.realizarApuesta("jugador0", "p0", TipoApuestas.MARCADOR, "0-0", (float)500.0);		
		} catch (ExcepcionPartidos ep) {
			//Si se llega hasta aquí alguna operación con partidos ha ido mal
			System.out.println("Ha fallado una operación sobre el partido con identificador '" + ep.getIdPartido() + "', por la siguiente causa: " + ep.getCausa().toString());
		} catch (ExcepcionUsuario eu) {
			//Si se llega hasta aquí alguna operación con usuarios ha ido mal
			System.out.println("Ha fallado una operación sobre el usuario con identificador '" + eu.getLogin() + "', por la siguiente causa: " + eu.getCausa().toString());
		}
		catch (ExcepcionCuenta ec) {
			//Si se llega hasta aquí alguna operación con apuestas ha ido mal
			System.out.println("Ha fallado una operación de apuestas por la siguiente causa: " + ec.getCausa().toString());
		}

		System.out.println("===============================================");
		System.out.println("PRUEBAS DE LA ITERACIÓN 2 - ESCENARIOS DE FALLO");
		System.out.println("===============================================");

		try {
			//Caso de uso "fijar resultado": se intenta fijar un resultado sobre un partido abierto
			System.out.println("\nIntento fijar un resultado sobre el partido 'p3'");
			cp.introducirResultadoPartido("p3", TipoApuestas.MARCADOR, "2-2");		
		} catch (ExcepcionPartidos ep) {
			//Si se llega hasta aquí alguna operación con partidos ha ido mal
			System.out.println("Ha fallado una operación sobre el partido con identificador '" + ep.getIdPartido() + "', por la siguiente causa: " + ep.getCausa().toString());
		} catch (ExcepcionApuesta ea) {
			//Si se llega hasta aquí alguna operación con apuestas ha ido mal
			System.out.println("Ha fallado una operación de apuestas por la siguiente causa: " + ea.getCausa().toString());
		}

		try {
			//Caso de uso "fijar resultado": se intenta fijar un resultado sobre un partido ya pagado
			System.out.println("\nIntento fijar un resultado sobre el partido 'p0'");
			cp.introducirResultadoPartido("p0", TipoApuestas.MARCADOR, "3-1");		
		} catch (ExcepcionPartidos ep) {
			//Si se llega hasta aquí alguna operación con partidos ha ido mal
			System.out.println("Ha fallado una operación sobre el partido con identificador '" + ep.getIdPartido() + "', por la siguiente causa: " + ep.getCausa().toString());
		} catch (ExcepcionApuesta ea) {
			//Si se llega hasta aquí alguna operación con apuestas ha ido mal
			System.out.println("Ha fallado una operación de apuestas por la siguiente causa: " + ea.getCausa().toString());
		}
		
		try {
			//Caso de uso "pagar apuestas": intento volver a pagar unas apuestas ya pagadas
			System.out.println("\nIntento volver a pagar las apuestas de 'marcador' del partido 'p0'");
			cp.pagarApuestasPartido("p0", TipoApuestas.MARCADOR);				
		} catch (ExcepcionPartidos ep) {
			//Si se llega hasta aquí alguna operación con partidos ha ido mal
			System.out.println("Ha fallado una operación sobre el partido con identificador '" + ep.getIdPartido() + "', por la siguiente causa: " + ep.getCausa().toString());
		} catch (ExcepcionApuesta ea) {
			//Si se llega hasta aquí alguna operación con apuestas ha ido mal
			System.out.println("Ha fallado una operación de apuestas por la siguiente causa: " + ea.getCausa().toString());
		}

		try {
			//Caso de uso "pagar apuestas": intento pagar unas apuestas de un partido sin resultado
			System.out.println("\nIntento pagar las apuestas de 'marcador' del partido 'p1'");
			cp.pagarApuestasPartido("p1", TipoApuestas.MARCADOR);				
		} catch (ExcepcionPartidos ep) {
			//Si se llega hasta aquí alguna operación con partidos ha ido mal
			System.out.println("Ha fallado una operación sobre el partido con identificador '" + ep.getIdPartido() + "', por la siguiente causa: " + ep.getCausa().toString());
		} catch (ExcepcionApuesta ea) {
			//Si se llega hasta aquí alguna operación con apuestas ha ido mal
			System.out.println("Ha fallado una operación de apuestas por la siguiente causa: " + ea.getCausa().toString());
		}

	}
}
