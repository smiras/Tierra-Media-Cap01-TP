package tierraMedia;

import java.util.*;

public class Promociones {

	String nombre;
	String tipo;
	int cantAtracciones;
	String[] atraccionesIncluidas;
	double costoFinal = 0;
	double duracionFinal = 0;

	public Promociones(String nombre, String tipo, int cantAtracciones, String[] atracciones) {
		this.nombre = nombre;
		this.tipo = tipo;
		this.cantAtracciones = cantAtracciones;
		this.atraccionesIncluidas = atracciones;

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
	
	public void CalcularCostoFinal(LinkedList<Atraccion> atracciones) {
		for (String ai : atraccionesIncluidas) {
			for (Atraccion a : atracciones) {
				if (ai.equals(a.getnombre())) {
					costoFinal += a.getCosto();
					
				}
			}

		}
	}

	public String getNombre() {
		// TODO Auto-generated method stub
		return nombre;
	}
}
