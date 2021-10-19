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
			LinkedList<Promocion> colapromo = sugerencia.armarColaPromo(promociones, atracciones, user.getPresupuesto(),
					user.getTiempodisponible());
			imprimir.cabecera(user.getNombre());
			String eleccion;

			for (Promocion pr : colapromo) {
				eleccion = sugerencia.ofrecerPromo(pr);
				if (eleccion.equals("s")) {
					System.out.println("aceptó la promo");
				} else if (eleccion.equals("n")) {
					System.out.println("no aceptó");
				} else
					System.out.println("No se entiende");
			}

			List<Atraccion> colatraccion = new LinkedList<Atraccion>(); // Arma cola de atracciones a ofrecer
			for (Atraccion atr : atracciones) {
				if (user.getPresupuesto() >= atr.getCosto()) {
					colatraccion.add(atr);
				}
			}
			
			//las atracciones vuelven a ser ofertables
		}
	}

}
