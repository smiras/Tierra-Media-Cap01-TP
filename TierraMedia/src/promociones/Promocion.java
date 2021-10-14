package promociones;

import java.util.*;

import tierraMedia.Atraccion;

public class Promocion {

	private String nombre;
	private String tipo;
	private int cantAtracciones;
	private String[] atraccionesIncluidas;
	private double costoFinal = 0;
	private double duracionFinal = 0;

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

	public void CalcularDuracionFinal(LinkedList<Atraccion> atracciones) {
		for (String ai : atraccionesIncluidas) {
			for (Atraccion a : atracciones) {
				if (ai.equals(a.getnombre())) {

					duracionFinal += a.getDuracion();
				}
			}

		}
	}

	public double CalcularCostoFinal(LinkedList<Atraccion> atracciones) {
		for (String ai : atraccionesIncluidas) {
			for (Atraccion a : atracciones) {
				if (ai.equals(a.getnombre())) {
					costoFinal += a.getCosto();

				}
			}

		}
		return costoFinal;
	}

}
