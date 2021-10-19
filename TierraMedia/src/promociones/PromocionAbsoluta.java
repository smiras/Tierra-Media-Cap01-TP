package promociones;

import java.util.*;

import tierraMedia.Atraccion;

public class PromocionAbsoluta extends Promocion {
	
	private double costo;

	public PromocionAbsoluta(String nombre, String[] atracciones, double costo) {
		super(nombre, atracciones);
		this.costo = costo;

	}

	@Override
	public void calcularDuracionyCosto(String[] atracciones, LinkedList<Atraccion> listatracciones) {
		super.calcularDuracionyCosto(atracciones, listatracciones);
		super.costo = costo;
	}
}
