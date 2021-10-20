package tierraMedia;

import java.util.Arrays;

public class Oferta {
	private String nombre;
	private String[] atracciones;
	private double costo;
	private double duracion;
	private int cupo;

	public Oferta(String nombre, String[] atracciones, double costo, double duracion, int cupo) {
		super();
		this.nombre = nombre;
		this.atracciones = atracciones;
		this.costo = costo;
		this.duracion = duracion;
		this.cupo = cupo;
	}

	public String getNombre() {
		return nombre;
	}

	public String[] getAtracciones() {
		return atracciones;
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

	@Override
	public String toString() {
	 return "Promo \nnombre: " + nombre + "\natracciones: " + Arrays.toString(atracciones) + "\ncosto: " + costo
	 + "\nduracion: " + duracion;
	}

}
