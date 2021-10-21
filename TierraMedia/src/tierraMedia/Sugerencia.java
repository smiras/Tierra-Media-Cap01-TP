package tierraMedia;

import java.util.*;
import promociones.*;

public class Sugerencia {

	public LinkedList<Promocion> armarColaPromos(LinkedList<Promocion> promos, Usuario user, LinkedList<Promocion> promosaceptadas) {
		LinkedList<Promocion> colapromos = new LinkedList<Promocion>();
		for (Promocion p : promos) {
			if ((p.getCosto() <= user.getPresupuesto()) && (p.getDuracion() <= user.getTiempodisponible())
					&& p.getCupo() > 0) {
				colapromos.add(p);
			}
		}
		LinkedList<Promocion> auxiliar = promosaceptadas;

		for (Promocion pr : auxiliar) {
			for (Promocion promo : promosaceptadas) {
				if (pr.getNombre().equals(promo.getNombre())) {
					colapromos.remove(pr);
				}
			}
		}
		
		return colapromos;
	}

	public LinkedList<Atraccion> armarColaAtracciones(LinkedList<Atraccion> atracciones, Usuario user,
			LinkedList<Atraccion> aceptadas) {
		LinkedList<Atraccion> colatracciones = new LinkedList<Atraccion>();
		for (Atraccion a : atracciones) {
			if ((a.getCosto() <= user.getPresupuesto()) && (a.getDuracion() <= user.getTiempodisponible())
					&& a.getCupo() > 0) {
				colatracciones.add(a);
			}
		}

		LinkedList<Atraccion> auxiliar1 = colatracciones;

		for (Atraccion at : auxiliar1) {
			for (Atraccion acep : aceptadas) {
				if (at.getNombre().equals(acep.getNombre())) {
					colatracciones.remove(at);
				}
			}
		}

		return colatracciones;
	}

	public String ofertarPromos(Promocion ofer) {
		Scanner sc = new Scanner(System.in);
		System.out.println(ofer.toString());
		System.out.println("¿Acepta la sugerencia? Ingrese: s (Si) o n (No)");
		return sc.nextLine();
	}

	public String ofertarAtraccion(Atraccion ofer) {
		Scanner sc = new Scanner(System.in);
		System.out.println(ofer.toString());
		System.out.println("¿Acepta la sugerencia? Ingrese: s (Si) o n (No)");
		return sc.nextLine();
	}

	public LinkedList<Atraccion> aceptarPromo(Promocion ofer, Usuario user, LinkedList<Atraccion> atracciones) {
		LinkedList<Atraccion> aceptadas = new LinkedList<Atraccion>();

		user.setPresupuesto(user.getPresupuesto() - ofer.getCosto());
		user.setTiempodisponible(user.getTiempodisponible() - ofer.getDuracion());
		user.aceptarPromos(ofer);

		for (String at : ofer.getAtracciones()) {
			for (Atraccion atraccion : atracciones) {
				if (at.equals(atraccion.getNombre())) {
					atraccion.restarCupo();
					aceptadas.add(atraccion);
				}
			}
		}

		return aceptadas;
	}

	public void aceptarAtraccion(Atraccion ofer, Usuario user, LinkedList<Atraccion> atracciones) {

		user.setPresupuesto(user.getPresupuesto() - ofer.getCosto());
		user.setTiempodisponible(user.getTiempodisponible() - ofer.getDuracion());
		user.aceptarAtracciones(ofer);

		for (Atraccion atraccion : atracciones) {
			if (ofer.getNombre().equals(atraccion.getNombre())) {
				atraccion.restarCupo();

			}
		}
	}

}
