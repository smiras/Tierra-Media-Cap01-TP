package tierraMedia;

import java.util.LinkedList;

public class Imprimir {

		public void cabecera(String name) {
			System.out.println("¡Bienvenid@ a la Tierra Media!");
			System.out.println("-------------------------------------------------------------------");
			System.out.printf("Nombre: %s \n", name);
			System.out.println("-------------------------------------------------------------------");
		}
		
		public void imprimirTicket(LinkedList<Oferta> ofertasAceptadas) {
			System.out.println("-------------------------------------------------------------------");
			System.out.println("Sus atracciones elegidas son:");
			for(Oferta oferta: ofertasAceptadas) {
				System.out.println(oferta);
			}
			System.out.println("-------------------------------------------------------------------");
		}
}
