package promociones;

import java.util.*;

import tierraMedia.Atraccion;

public class PromocionAbsoluta extends Promocion {
	
	private double costoFinal;

	public PromocionAbsoluta(String nombre, String[] atracciones, double costo) {
		super(nombre, atracciones);
		costoFinal = costo;

	}

	@Override
	public void calcularDuracionyCosto(String[] atracciones, LinkedList<Atraccion> listatracciones) {
		super.calcularDuracionyCosto(atracciones, listatracciones);
		super.costoFinal = costoFinal;
	}
}
