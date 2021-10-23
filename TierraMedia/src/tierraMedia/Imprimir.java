package tierraMedia;

import promociones.*;

public class Imprimir {

	public void cabecera(Usuario user) {
		System.out.println("¡Bienvenid@ a la Tierra Media!");
		System.out.println("-------------------------------------------------------------------");
		System.out.printf("Nombre: %s \n", user.getNombre());
		System.out.println("-------------------------------------------------------------------");
	}

	public void imprimirTicket(Usuario user) {
		Archivo archivo = new Archivo();
		System.out.println("\n-------------------------------------------------------------------\n");
		System.out.printf("Tu ticket de compra: %s \n", user.getNombre());
		System.out.printf("Sus atracciones elegidas son: ");
		for (Promocion promos : user.getPromosAceptadas()) {

			System.out.println((promos));
		}
		for (Atraccion atraccion : user.getAtraccionAceptada()) {

			System.out.println((atraccion));
		}
		System.out.printf("\n--------------------------------------------------------------------");
		System.out.printf("\nGasto Final: " + user.calcularDinerogastado());
		System.out.printf("\nTiempo Necesario: " + user.calcularTiempoNecesario());
		System.out.printf("\n--------------------------------------------------------------------");
		System.out.printf("\n¡Gracias por tu compra! ¡Te esperamos en la Tierra Media!");
		System.out.printf("\n--------------------------------------------------------------------\n\n\n\n");
		archivo.escribirArchivos(user);
		
	}
}
