package tierraMedia;

import java.util.*;

public class Imprimir {

	public void cabecera(Usuario user) {
		System.out.println("¡Bienvenid@ a la Tierra Media!");
		System.out.println("-------------------------------------------------------------------");
		System.out.printf("Nombre: %s \n", user.getNombre());
		System.out.println("-------------------------------------------------------------------");
	}

	public void imprimirTicket(Usuario user) {

		System.out.println("-------------------------------------------------------------------");
		System.out.printf("Tu ticket de compra: %s \n", user.getNombre());
		System.out.println(user.getTiempodisponible());
		System.out.println(user.getPresupuesto());
		System.out.printf("Sus atracciones elegidas son: ");
		for (Oferta oferta : user.getOfertasAceptadas()) {

			System.out.println(Arrays.toString(oferta.getAtracciones()));
		}

		System.out.println("¡Gracias por tu compra! ¡Te esperamos en la Tierra Media!");
		System.out.println("-------------------------------------------------------------------");
	}
}
