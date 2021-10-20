package tierraMedia;

import java.util.*;
import promociones.*;

public class App {
	public static void main(String[] args) {

		Archivo a = new Archivo();
		a.leerarchivos();
		LinkedList<Usuario> usuarios = a.getListausuarios(); // Carga lista de usuarios
		LinkedList<Atraccion> atracciones = a.getListatracciones(); // Carga lista de atracciones
		LinkedList<Promocion> promociones = a.getListapromociones();// carga lista de promociones

		Collections.sort(atracciones, Collections.reverseOrder()); // Ordena lista de atracciones
		Collections.sort(promociones, Collections.reverseOrder()); // Ordena lista de promociones
		Imprimir imprimir = new Imprimir();
		Sugerencia sugerencia = new Sugerencia();

		for (Usuario user : usuarios) {
			LinkedList<Oferta> ofrecidas = new LinkedList(); 
			LinkedList<Oferta> colapromo = sugerencia.armarColaOferta(promociones, atracciones, user, ofrecidas);

			imprimir.cabecera(user);
			String eleccion;

			// colapromo.forEach(cola->System.out.println(cola.getNombre()));
			
			while (!colapromo.isEmpty()) {

				Oferta ofer = colapromo.get(0);
				eleccion = sugerencia.ofertar(ofer);
				if (eleccion.equals("s")) {
					System.out.println("¡Reserva confirmada!");
					sugerencia.aceptarPromo(ofer, user, atracciones);
					

				} else if (eleccion.equals("n")) {
					System.out.println("No te preocupes tenemos más opciones para vos");

					}
				ofrecidas.add(ofer);
				colapromo = sugerencia.armarColaOferta(promociones, atracciones, user, ofrecidas);
			}
			
			imprimir.imprimirTicket(user);
		}
	}
}
