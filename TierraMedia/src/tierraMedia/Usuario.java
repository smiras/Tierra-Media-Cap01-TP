package tierraMedia;

import java.util.LinkedList;

public class Usuario {
	private String nombre;
	private double presupuesto;
	private double tiempodisponible;
	LinkedList<Oferta> ofertasAceptadas = new LinkedList<Oferta>();

	public Usuario(String nombre, double presupuesto, double tiempodisponible) {
		this.nombre = nombre;
		this.presupuesto = presupuesto;
		this.tiempodisponible = tiempodisponible;
	}
	
	public String getNombre() {
		return nombre;
	}

	public double getPresupuesto() {
		return presupuesto;
	}

	public void setPresupuesto(double presupuesto) {
		this.presupuesto = presupuesto;
	}

	public double getTiempodisponible() {
		return tiempodisponible;
	}

	public void setTiempodisponible(double tiempodisponible) {
		this.tiempodisponible = tiempodisponible;
	}
	
	public void ofertaAceptada(Oferta oferta) {
		ofertasAceptadas.add(oferta);
	}
	
	public LinkedList<Oferta> getOfertasAceptadas(){
		return ofertasAceptadas;
	}
	
}
