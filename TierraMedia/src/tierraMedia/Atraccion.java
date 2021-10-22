package tierraMedia;

import java.util.Arrays;

public class Atraccion implements Comparable<Atraccion> {
	private String nombre;
	private String[] atraccion = new String[1];
	private double costo;
	private double duracion;
	private int cupo;

	public Atraccion(String nombre, double costo, double duracion, int cupo) {
		this.nombre = nombre;
		this.costo = costo;
		this.duracion = duracion;
		this.cupo = cupo;
		this.atraccion[0] = this.nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public double getCosto() {
		return costo;
	}

	public double getDuracion() {
		return duracion;
	}

	public int getCupo() {
		return cupo;
	}

	public void restarCupo() {
		cupo--;
	}

	@Override
	public String toString() {
		return "Atraccion \nNombre: " + nombre + "\nCosto: " + costo + "\nDuracion: " + duracion;
	}

	@Override
	public int compareTo(Atraccion at) {
		return Double.valueOf(costo).compareTo(at.getCosto());

	}

	public String[] getAtraccion() {
		return atraccion;
	}
}
