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
			LinkedList<Atraccion> colatracciones = new LinkedList<Atraccion>();
			LinkedList<Promocion> promosaceptadas = new LinkedList<Promocion>();
			LinkedList<Atraccion> aceptadas = new LinkedList<Atraccion>();
			LinkedList<Promocion> colapromos = sugerencia.armarColaPromos(promociones, user, promosaceptadas); 
						
			imprimir.cabecera(user);
			String eleccion;
			
			while (!colapromos.isEmpty()) {
				Promocion ofer = colapromos.get(0);
				eleccion = sugerencia.ofertarPromos(ofer);
				if (eleccion.equalsIgnoreCase("s")) {
					System.out.println("¡Reserva confirmada!");
					aceptadas.addAll(sugerencia.aceptarPromo(ofer, user, atracciones));
					promosaceptadas.add(ofer);
					colapromos = sugerencia.armarColaPromos(promociones, user,promosaceptadas);
					
				} else if (eleccion.equalsIgnoreCase("n")) {
					System.out.println("No te preocupes tenemos más opciones para vos");
					colapromos.pollFirst();
				}

			}
			
			colatracciones = sugerencia.armarColaAtracciones(atracciones, user, aceptadas);
			
			while (!colatracciones.isEmpty()) {
				Atraccion ofera = colatracciones.get(0);
				aceptadas.add(ofera);
				eleccion = sugerencia.ofertarAtraccion(ofera);
				if (eleccion.equalsIgnoreCase("s")) {
					System.out.println("¡Reserva confirmada!");
					sugerencia.aceptarAtraccion(ofera, user, atracciones);
					colatracciones = sugerencia.armarColaAtracciones(atracciones, user, aceptadas);
				} else if (eleccion.equalsIgnoreCase("n")) {
					System.out.println("No te preocupes tenemos más opciones para vos");
					colatracciones.pollFirst();
				}

			}
			
			imprimir.imprimirTicket(user);
		}
		
		
	}
}
