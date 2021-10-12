package tierraMedia;

import java.util.*;

public class Promociones {

	String nombre;
	String tipo;
	int cantAtracciones;
	ArrayList<String> atracciones;
	double costo = 0;

	public Promociones(String nombre, String tipo, int cantAtracciones, ArrayList<String> atracciones2) {
		this.nombre = nombre;
		this.tipo = tipo;
		this.cantAtracciones = cantAtracciones;
		this.atracciones = atracciones2;

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
