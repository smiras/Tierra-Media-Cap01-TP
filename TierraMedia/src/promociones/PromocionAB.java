package promociones;

import java.util.*;

import tierraMedia.Atraccion;

public class PromocionAB extends Promocion{
	private String atraccionesExtra[];
	
	
	public PromocionAB(String nombre, String[] atracciones, String[] atraccionesExtra) {
		super(nombre, atracciones);
		// TODO Auto-generated constructor stub
		this.atraccionesExtra = atraccionesExtra;
	}

	@Override
	public void calcularDuracionyCosto(String[] atracciones, LinkedList<Atraccion> listatracciones) {
		super.calcularDuracionyCosto(atracciones, listatracciones);
		
		for (String ae : atraccionesExtra) {
			for (Atraccion a : listatracciones) {
				if (ae.equals(a.getnombre())) {

					duracionFinal += a.getDuracion();
					
				}
			
			}
		
		}
	
	}

}
