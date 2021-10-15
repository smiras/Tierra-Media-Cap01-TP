package promociones;

import java.util.*;

import tierraMedia.Atraccion;

public class Promocion {

	private String nombre;
	private int cantAtracciones;
	private String[] atraccionesIncluidas;
	private double costoFinal = 0;
	private double duracionFinal = 0;

	public Promocion(String nombre, String[] atracciones) {
		this.nombre = nombre;
		this.atraccionesIncluidas = atracciones;
		this.duracionFinal=duracionFinal;
		
	}

	public String getNombre() {

		return nombre;
	}

	public void getAtracciones() {
		for (String a : atraccionesIncluidas) {
			System.out.println(a);
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

	public double getDuracionFinal() {
		return duracionFinal;
	}

}
