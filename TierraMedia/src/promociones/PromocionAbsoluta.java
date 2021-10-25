package promociones;

import java.util.*;

import tierraMedia.Atraccion;

public class PromocionAbsoluta extends Promocion {

	private double costo;
	private double costoInicial = 0;

	public PromocionAbsoluta(String nombre, String[] atracciones, double costo) {
		super(nombre, atracciones);
		this.costo = costo;
	}

	@Override
	public void calcularDuracionyCosto(String[] atracciones, LinkedList<Atraccion> listatracciones) {
		super.calcularDuracionyCosto(atracciones, listatracciones);
		costoInicial = super.getCosto();
	}

	@Override
	public String toString() {

		return "\nPromocion \nNombre: " + super.getNombre() + "\nAtracciones Incluidas: "
				+ Arrays.toString(super.getAtracciones()) + "\nAtracciones de regalo: " + "\nCosto: " + costo
				+ "\nDuracion: " + duracion + "\nTu ahorro es:" + (costoInicial);
	}
}
