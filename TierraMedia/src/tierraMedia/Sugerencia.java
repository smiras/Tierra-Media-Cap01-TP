package tierraMedia;

import java.util.*;
import promociones.*;

public class Sugerencia {

	public LinkedList<Oferta> armarColaOferta(LinkedList<Promocion> promociones, LinkedList<Atraccion> atracciones,
			double presupuesto, double tiempo) {
		LinkedList<Oferta> cola = new LinkedList<Oferta>();
		for (Promocion pr : promociones) {
			if ((presupuesto >= pr.getCosto()) && (tiempo >= pr.getDuracion()) && (pr.getCupo() > 0)) {
				Oferta ofer = new Oferta(pr.getNombre(), pr.getAtracciones(), pr.getCosto(), pr.getDuracion(),
						pr.getCupo());
				cola.add(ofer);
			}
		}
		for (Atraccion at : atracciones) {
			if ((presupuesto >= at.getCosto()) && (tiempo >= at.getDuracion()) && (at.getCupo() > 0)) {
				Oferta ofer = new Oferta(at.getNombre(), at.getAtraccion(), at.getCosto(), at.getDuracion(),
						at.getCupo());
				cola.add(ofer);
			}
		}
		return cola;
	}

	public String ofertar(Oferta ofer) {
		Scanner sc = new Scanner(System.in);
		System.out.println(ofer.toString());
		System.out.println("¿Acepta la sugerencia? Ingrese: s (Si) o n (No)");
		return sc.nextLine();
	}

	public void aceptarPromo(Oferta oferta, Usuario user, LinkedList<Atraccion> atracciones) {
		user.setPresupuesto(user.getPresupuesto() - oferta.getCosto());
		user.setTiempodisponible(user.getTiempodisponible() - oferta.getDuracion());
		user.ofertaAceptada(oferta);
		for (String at : oferta.getAtracciones()) {
			for (Atraccion atraccion : atracciones) {
				if (at.equals(atraccion.getNombre())) {
					atraccion.restarCupo();
				}
			}
		}

	}

	
}
