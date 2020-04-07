//este test prueba la dinamica y estatica cambiando el import del packete


package estructuras.lineales.testings;
 import estructuras.lineales.dinamicas.Cola;
/**
 *
 * @author Dantesito
 */
public class TestingCola {

	// import lineales.estaticas.Cola;
	

	/**
	 *
	 * @author Catedra Estructuras de Datos
	 * 
	 */

	static String sOk = "OK!", sErr = "ERROR";

	public static void main(String[] arg) {
		testCola();
	}

	public static void testCola() {
		System.out.println("COMIENZO TEST COLA");
		Cola q1 = new Cola();
		System.out.println("Cola vac�a: \t\t\t\t\t\t\t--> " + q1.toString());
		boolean exito = true;

		System.out.println("Si es cola estatica tama�o <= 10 se debe llenar");
		int num = 1;
		while (num < 12) {
			if (num < 10) {
				System.out.print("Pone " + num + " espera true: \t\t\t\t\t" + ((q1.poner(num) == true) ? sOk : sErr));
			} else {
				System.out.print("Pone " + num + " espera false en estatica y true en dinamica : \t" + q1.poner(num));
			}
			num++;
			System.out.println("\t--> " + q1.toString());
		}
		System.out
				.println("Recupera frente espera 1 recupera: \t\t\t" + (((int) q1.obtenerFrente() == 1) ? sOk : sErr));

		System.out.print("Saca espera true : \t\t\t\t\t" + ((q1.sacar() == true) ? sOk : sErr));
		System.out.println("\t--> " + q1.toString());
		System.out.println("Recupera frente espera 2 recupera \t\t\t" + (((int) q1.obtenerFrente() == 2) ? sOk : sErr));
		System.out.print("Saca espera true: \t\t\t\t\t" + ((q1.sacar() == true) ? sOk : sErr));
		System.out.println("\t--> " + q1.toString());
		System.out
				.println("Recupera frente espera 3 recupera: \t\t\t" + (((int) q1.obtenerFrente() == 3) ? sOk : sErr));
		System.out.print("Pone 23 espera true: \t\t\t\t\t" + ((q1.poner(23) == true) ? sOk : sErr));
		System.out.println("\t--> " + q1.toString());
		System.out.print("Pone 24 espera true: \t\t\t\t\t" + ((q1.poner(24) == true) ? sOk : sErr));
		System.out.println("\t--> " + q1.toString());
		System.out
				.println("Recupera frente espera 3 recupera: \t\t\t" + (((int) q1.obtenerFrente() == 3) ? sOk : sErr));

		Cola q2 = q1.clone();
		System.out.println("Copia espera [3 4 5 6 7 8 9 <10 11> 23 24]: \t\t\t--> " + q2.toString());

		System.out.println("Pone 7 espera false en estatica, true en dinamica: \t" + q1.poner(7));
		System.out.print("Pone 8 espera false en estatica, true en dinamica: \t" + q1.poner(8));
		System.out.println("\t--> " + q1.toString());

		while (!q1.esVacia()) {
			System.out.print("Saca " + q1.obtenerFrente() + " de cola espera true: \t\t\t\t"
					+ ((q1.sacar() == true) ? sOk : sErr));
			System.out.println("\t--> " + q1.toString());
		}
		System.out.print("Se vacio la cola q1");
		System.out.println("\t\t\t\t\t\t--> " + q1.toString());
		System.out.println("Sacar en cola vacia espera false: \t\t\t" + ((q1.sacar() == false) ? sOk : sErr));
		System.out.println(
				"Recupera frente en cola vacia espera null: \t\t" + ((q1.obtenerFrente() == null) ? sOk : sErr));

		System.out.println("Verifica copia guardada espera [3 4 5 6 7 8 9 <10 11> 23 24]: \t--> " + q2.toString());
		System.out.println(
				"Pone 27 espera true en dinamica y false en estatica: \t" + ((q2.poner(27) == true) ? sOk : sErr));
		System.out.println("Verifica copia espera [3 4 5 6 7 8 9 <10 11> 23 24 <27>]: \t--> " + q2.toString());
		System.out.println(
				"Saca " + q2.obtenerFrente() + " de cola espera true: \t\t\t\t" + ((q2.sacar() == true) ? sOk : sErr));
		System.out.println("Verifica copia espera [4 5 6 7 8 9 <10 11> 23 24 <27>]: \t--> " + q2.toString());
		System.out.println(
				"Saca " + q2.obtenerFrente() + " de cola espera true: \t\t\t\t" + ((q2.sacar() == true) ? sOk : sErr));
		System.out.println("Verifica copia espera [5 6 7 8 9 <10 11> 23 24 <27>]: \t\t--> " + q2.toString());
		System.out.println(
				"Saca " + q2.obtenerFrente() + " de cola espera true:\t\t\t\t" + ((q2.sacar() == true) ? sOk : sErr));
		System.out.println("Verifica copia espera [6 7 8 9 <10 11> 23 24 <27>]: \t\t--> " + q2.toString());
		System.out.println("Pone 28: \t\t\t\t\t\t" + ((q2.poner(28) == true) ? sOk : sErr));
		System.out.println("Pone 29: \t\t\t\t\t\t" + ((q2.poner(29) == true) ? sOk : sErr));
		System.out.println("Verifica copia espera [6 7 8 9 <10 11> 23 24 <27> 28 29]: \t--> " + q2.toString());
		q2.vaciar();
		System.out.println("Vacia copia espera []: \t\t\t\t\t\t--> " + q2.toString());

	}
}
