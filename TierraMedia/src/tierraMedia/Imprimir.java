package tierraMedia;

import java.util.*;

public class Imprimir {

	public void cabecera(String name) {
		System.out.println("¡Bienvenid@ a la Tierra Media!");
		System.out.println("-------------------------------------------------------------------");
		System.out.printf("Nombre: %s \n", name);
		System.out.println("-------------------------------------------------------------------");
	}

	public void imprimirTicket(LinkedList<Oferta> ofertasAceptadas, String name, double presupuesto) {

		System.out.println("-------------------------------------------------------------------");
		System.out.printf("Tu ticket de compra: %s \n", name);
		System.out.printf("Sus atracciones elegidas son: ");
		for (Oferta oferta : ofertasAceptadas) {

			System.out.println(Arrays.toString(oferta.getAtracciones()));
		}

		System.out.println("¡Gracias por tu compra! ¡Te esperamos en la Tierra Media!");
		System.out.println("-------------------------------------------------------------------");
	}
}
