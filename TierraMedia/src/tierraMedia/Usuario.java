package tierraMedia;

public class Usuario {
	private String nombre;
	private double presupuesto;
	private double tiempodisponible;

	public Usuario(String nombre, double presupuesto, double tiempodisponible) {
		super();
		this.nombre = nombre;
		this.presupuesto = presupuesto;
		this.tiempodisponible = tiempodisponible;
	}
	
	public String getnombre() {
		return nombre;
	}

}
