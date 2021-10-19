package tierraMedia;

import java.util.*;
import promociones.*;

public class Sugerencia {
	public LinkedList<Promocion> armarColaPromo(LinkedList<Promocion> promociones,LinkedList<Atraccion> atracciones, double presupuesto, double tiempo){
		LinkedList<Promocion> cola = new LinkedList<Promocion>();
		for (Promocion pr : promociones) {
			if ((presupuesto >= pr.getCosto()) && (tiempo >= pr.getDuracion())
					&& (pr.tieneCupo(atracciones))) {
				cola.add(pr);
			}
		}
		return cola;
	}	
	
	public String ofrecerPromo(Promocion pr) {
		Scanner sc = new Scanner(System.in);
		System.out.println(pr.toString());
		System.out.println("¿Acepta la sugerencia? Ingrese: s (Si) o n (No)");
		return sc.nextLine();
	}
}

