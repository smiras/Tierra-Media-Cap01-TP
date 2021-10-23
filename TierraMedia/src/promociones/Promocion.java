package promociones;

import java.util.*;

import tierraMedia.Atraccion;

public class Promocion implements Comparable<Promocion> {

	private String nombre;
	private String[] atraccionesIncluidas;
	protected double costo = 0;
	protected double duracion = 0;
	protected int cupo;

	public Promocion(String nombre, String[] atracciones) {
		this.nombre = nombre;
		this.atraccionesIncluidas = atracciones;

	}

	public String getNombre() {

		return nombre;
	}

	public String[] getAtracciones() {
		return atraccionesIncluidas;
		}

	public double getDuracion() {
		return duracion;
	}

	public double getCosto() {
		return costo;
	}
	
	public int getCupo() {
		return cupo;
	}

	public void calcularDuracionyCosto(String[] atracciones, LinkedList<Atraccion> listatracciones) {
		for (String ai : atracciones) {
			for (Atraccion a : listatracciones) {
				if (ai.equals(a.getNombre())) {

					this.duracion += a.getDuracion();
					this.costo += a.getCosto();
				}
			}
		}
	}

	public void calcularCupo(String[] atracciones, LinkedList<Atraccion> lista) {
		for(Atraccion a : lista) {
			cupo = a.getCupo();
			for(String at:atracciones) {
				
				if(a.getNombre().equals(at)&&cupo<a.getCupo()) {
					cupo=a.getCupo();
				}
			}
		}
	}
	
	@Override
	public String toString() {
		return "\nPromocion \nNombre: " + nombre + "\nAtracciones Incluidas: " + Arrays.toString(atraccionesIncluidas)
				+ "\nCosto: " + costo + "\nDuracion: " + duracion+"\n";
	}

	@Override
	public int compareTo(Promocion pr) {
		return Double.valueOf(costo).compareTo(pr.getCosto());
	}

}
