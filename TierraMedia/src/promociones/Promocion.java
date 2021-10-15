package promociones;

import java.util.*;

import tierraMedia.Atraccion;

public class Promocion {

	private String nombre;
	private String[] atraccionesIncluidas;
	protected double costoFinal = 0;
	protected double duracionFinal = 0;

	public Promocion(String nombre, String[] atracciones) {
		this.nombre = nombre;
		this.atraccionesIncluidas = atracciones;

	}

	public String getNombre() {

		return nombre;
	}

	public void getAtracciones() {
		for (String a : atraccionesIncluidas) {
			System.out.println(a);
		}
	}
	public double getDuracionFinal() {
		return duracionFinal;
	}
	
	public double getCostoFinal() {
		return costoFinal;
	}

	public void calcularDuracionyCosto(String[] atracciones, LinkedList<Atraccion> listatracciones) {
		for (String ai : atracciones) {
			for (Atraccion a : listatracciones) {
				if (ai.equals(a.getnombre())) {

					this.duracionFinal += a.getDuracion();
					this.costoFinal += a.getCosto();
				}
			}
		}
	}

	

}
