package tierraMedia;

import java.util.*;

public class Promociones {

	String nombre;
	String tipo;
	int cantAtracciones;
	String[] atracciones;
	double costo = 0;

	public Promociones(String nombre, String tipo, int cantAtracciones, String[] atracciones) {
		this.nombre = nombre;
		this.tipo = tipo;
		this.cantAtracciones = cantAtracciones;
		this.atracciones = atracciones;

	}

	public double CalcularCostoFinal(LinkedList<Atraccion> atraccion) {
		for (String a : atracciones) {
			for (Atraccion at : atraccion) {
				if (a==at.getnombre()) {
					costo+=at.getCosto();
				}
			}
		}
		return costo;
	}

	public String getNombre() {
		// TODO Auto-generated method stub
		return nombre;
	}
}
