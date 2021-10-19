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
			imprimir.cabecera(user.getNombre());
			String eleccion;
			Iterator it = colapromo.iterator();
			
			int i=0;
			int size = colapromo.size();
			while(i<size) {
				
				eleccion = sugerencia.ofertar(colapromo.get(i));
				if (eleccion.equals("s")) {
					System.out.println("aceptaste esta oferta");
					sugerencia.aceptarPromo(colapromo.get(i), user, atracciones);
					colapromo = sugerencia.armarColaOferta(promociones, atracciones, user.getPresupuesto(),
							user.getTiempodisponible());
					size = colapromo.size();
					i++;
				} else if (eleccion.equals("n")) {
					System.out.println("no aceptaste esta oferta");
					colapromo.remove(colapromo.get(i));
					i++;
				} else
					System.out.println("No se entiende");
				
			
			}

			
			
			//las atracciones vuelven a ser ofertables
		}
	}

}
