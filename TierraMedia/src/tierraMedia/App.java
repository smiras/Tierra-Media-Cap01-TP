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
			LinkedList<Oferta> colapromo = sugerencia.armarColaOferta(promociones, atracciones, user.getPresupuesto(),
					user.getTiempodisponible());
			/*
			System.out.println(colapromo.toString());
			System.out.println("hasta acá llega la cola");
			System.out.println();
			*/
			
			imprimir.cabecera(user.getNombre());
			String eleccion;
			
			int i = 0;
			int size = colapromo.size();
			while (i < size) {
				Oferta ofer = colapromo.get(i);
				eleccion = sugerencia.ofertar(colapromo.get(i));
				if (eleccion.equals("s")) {
					System.out.println("¡Reserva confirmada!");
					
					sugerencia.aceptarPromo(colapromo.get(i), user, atracciones);
					colapromo = sugerencia.armarColaOferta(promociones, atracciones, user.getPresupuesto(),
							user.getTiempodisponible());					
					size = colapromo.size();
					i=0;
					
						colapromo.remove(ofer);
					
				} else if (eleccion.equals("n")) {
					System.out.println("No te preocupes tenemos más opciones para vos");
					
					colapromo.remove(ofer);
				}
				imprimir.imprimirTicket(user.getOfertasAceptadas(),user.getNombre(),user.getPresupuesto());
								
				
				
			}
			
		}
	}

}
