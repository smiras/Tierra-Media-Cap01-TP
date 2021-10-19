package tierraMedia;

public class Atraccion implements Comparable<Atraccion> {
	private String nombre;
	private double costo;
	private double duracion;
	private int cupo;
	private int ofertable = 1;

	public Atraccion(String nombre, double costo, double duracion, int cupo) {
		this.nombre = nombre;
		this.costo = costo;
		this.duracion = duracion;
		this.cupo = cupo;
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
		cupo -= 1;
	}

	public void setOfertable() {
		ofertable = 0;
	}

	public int getOfertable() {
		return ofertable;
	}

	@Override
	public String toString() {
		return "Atraccion [nombre=" + nombre + ", costo=" + costo + ", duracion=" + duracion + ", cupo=" + cupo + "]";
	}

	@Override
	public int compareTo(Atraccion at) {
		return Double.valueOf(costo).compareTo(at.getCosto());

	}
}
