package tierraMedia;

public class Atraccion {
	private String nombre;
	private double costo;
	private double duracion;
	private int cupo;

	public Atraccion(String nombre, double costo, double duracion, int cupo) {
		this.nombre = nombre;
		this.costo = costo;
		this.duracion = duracion;
		this.cupo = cupo;
	}
	
	public String getnombre() {
		return nombre;
	}
	public double getCosto() {
		return costo;
	}
}


