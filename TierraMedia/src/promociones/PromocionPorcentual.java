package promociones;

import java.util.*;

import tierraMedia.Atraccion;

public class PromocionPorcentual extends Promocion {
	private double duracionFinal = 0;
	private double porcentaje;
	
	public PromocionPorcentual(String nombre, String[] atracciones,double porcentaje) {
		super(nombre, atracciones);
		// TODO Auto-generated constructor stub
		this.porcentaje=porcentaje;
	}

	public void calcularDuracion(String[] atracciones, LinkedList<Atraccion> listatracciones) {
		for (String ai : atracciones) {
			for (Atraccion a : listatracciones) {
				if (ai.equals(a.getnombre())) {

					this.duracionFinal += a.getDuracion();
				}
			}
		}
	}
	

}
