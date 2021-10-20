package tierraMedia;

import java.util.*;
import promociones.*;

public class Sugerencia {

	public LinkedList<Oferta> armarColaOferta(LinkedList<Promocion> promociones, LinkedList<Atraccion> atracciones,
			Usuario user, LinkedList<Oferta> ofrecidas) {
		LinkedList<Oferta> cola = new LinkedList<Oferta>();
		
		for (Promocion pr : promociones) {
			if ((user.getPresupuesto() >= pr.getCosto()) && (user.getTiempodisponible() >= pr.getDuracion()) && (pr.getCupo() > 0)) {
				Oferta ofer = new Oferta(pr.getNombre(), pr.getAtracciones(), pr.getCosto(), pr.getDuracion(),
						pr.getCupo());
				cola.add(ofer);
			}
		}
		for (Atraccion at : atracciones) {
			if ((user.getPresupuesto() >= at.getCosto()) && (user.getTiempodisponible() >= at.getDuracion()) && (at.getCupo() > 0)) {
				Oferta ofer = new Oferta(at.getNombre(), at.getAtraccion(), at.getCosto(), at.getDuracion(),
						at.getCupo());
				cola.add(ofer);
			}
		}
		int i=0;
		int size = cola.size();
		while(!cola.isEmpty()&&i<size) {
			
			Oferta of = cola.get(i);
			for(Oferta ofer: ofrecidas) {
				if(of.getNombre().equals(ofer.getNombre()))
					cola.remove(of);
			}
			i++;
			size = cola.size();
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
