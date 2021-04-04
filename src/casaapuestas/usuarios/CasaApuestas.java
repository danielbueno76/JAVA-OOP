package casaapuestas.usuarios;

import java.util.List;

import casaapuestas.cuentas.Cuenta;
import casaapuestas.cuentas.ExcepcionCuenta;

public class CasaApuestas {
	
	/** Cuenta de dinero del jugador ante la casa de apuestas */
	private static Cuenta cuentaCasaApuestas=new Cuenta();
	
	/**Patron Singleton*/
	//Variable que almacena un objeto de tipo casaApuestas
	private static CasaApuestas instance = new CasaApuestas();
			
 	private CasaApuestas(){} //Se declara el contructor privado para que no se pueda crear otro objeto en otra clase
		
 	//Devuelve un objeto de tipo casaApuestas
    public static CasaApuestas getInstance() {
        return instance;
    }	
	

	/**
	 * Método que permite que se realice un ingreso en la cuenta de la casa de apuestas
	 * @param concepto el concepto por el que se ingresa
	 * 
	 * @param cantidad la cantidad que se ingresa
	 */
	public void realizarIngreso(String concepto, float cantidad) {
		// Pasa la petición a la cuenta
		cuentaCasaApuestas.realizarIngreso(concepto, cantidad);
	}

	/**
	 * Método que permite que se realice un reintegro desde la cuenta de la casa de apuestas
	 * @param concepto el concepto por el que se reintegra
	 * 
	 * @param cantidad la cantidad que se reintegra
	 * @throws ExcepcionCuenta si el saldo de la cuenta no es suficiente para reintegrar la <code>cantidad</code>
	 */
	public void realizarReintegro(String concepto, float cantidad) throws ExcepcionCuenta 
	{
		// Pasa la petición a la cuenta
		cuentaCasaApuestas.realizarReintegro(concepto, cantidad);
	}

	/**
	 * Método que permite que un jugador informe de su saldo
	 * @return el saldo en la cuenta de la casa de apuestas
	 */
	public float verSaldo() {
		//Pasa la petición a la cuenta
		return cuentaCasaApuestas.getSaldo();
	}

	/**
	 * Método que permite que un jugador informe de los movimientos de su cuenta
	 * @return una lista de cadenas, donde cada elemento corresponde a un movimiento
	 */
	public List<String> listarMovimientosCuenta() {
		//Pasa la petición a la cuenta
		return cuentaCasaApuestas.listarMovimientos();
	}

}
