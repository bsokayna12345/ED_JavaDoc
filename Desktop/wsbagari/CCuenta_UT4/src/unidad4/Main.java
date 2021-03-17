/**
 * 
 */
package unidad4;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 * @author usuario
 *
 */
public class Main {
	static BufferedReader dato = new BufferedReader(new InputStreamReader(System.in));
	/**
	 * 
	 * @param args esto es el metodo principal
	 */

	public static void main(String[] args) {
		CCuenta cuenta1;
		double saldoActual;
		int opcion = 0;
		cuenta1 = new CCuenta("Juan López", "1000-2365-85-123456789", 2500, 0);
		do {
			try {
				System.out.println("MENÚ DE OPERACIONES");
				System.out.println("-------------------");
				System.out.println("1 - Ingresar");
				System.out.println("2 - Retirar");
				System.out.println("3 - Finalizar");
				opcion = Integer.parseInt(dato.readLine());
				if (opcion == 1) {
					System.out.println("¿Cuánto desea ingresar?: ");
					float ingresar = Integer.parseInt(dato.readLine());
					operativa_cuenta(cuenta1, ingresar, opcion);
				} else if (opcion == 2) {
					System.out.println("¿Cuánto desea retirar?: ");
					float retirar = Integer.parseInt(dato.readLine());
					operativa_cuenta(cuenta1, retirar, opcion);
				} else if (opcion == 3) {
					System.out.println("Finalizamos la ejecución");
				} else {
					System.err.println("Opción errónea");
				}

			} catch (IOException ex) {
				 System.out.println(Main.class.getName());
			}
		} while (opcion != 3);
		saldoActual = cuenta1.estado();
		System.out.println("El saldo actual es: " + saldoActual);
	}
	/**
	 * 
	 * @param cuenta1 llamar al metodo cuenta de la clase CCuenta.
	 * @param cantidad -llamar al metodo cantidad de la clase CCuenta
	 * @param opcion - hay dos opciones (1.para ingreso in la cuenta , 2. retirar de la cuenta )
	 */

	public static void operativa_cuenta(CCuenta cuenta1, float cantidad, int opcion) {
		if (opcion == 2) {
			try {
				cuenta1.retirar(cantidad);
			} catch (Exception e) {
				System.out.print("Fallo al retirar");
			}
		} else if (opcion == 1) {
			try {
				System.out.println("Ingreso en cuenta");
				cuenta1.ingresar(cantidad);
			} catch (Exception e) {
				System.out.print("Fallo al ingresar");
			}
		}
	}
}


