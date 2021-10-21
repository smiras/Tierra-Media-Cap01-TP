package tierraMedia;

import java.util.LinkedList;
import promociones.*;

public class Usuario {
	private String nombre;
	private double presupuesto;
	private double tiempodisponible;
	//guardar promos y atracciones aceptadas
	private LinkedList<Promocion> promosAceptadas = new LinkedList<Promocion>();
	private LinkedList<Atraccion> atraccionAceptada = new LinkedList<Atraccion>();

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
	
	public void aceptarPromos(Promocion promo) {
		promosAceptadas.add(promo);
	}
	
	public void aceptarAtracciones(Atraccion atraccion) {
		atraccionAceptada.add(atraccion);
	}

	public LinkedList<Promocion> getPromosAceptadas() {
		return promosAceptadas;
	}

	public LinkedList<Atraccion> getAtraccionAceptada() {
		return atraccionAceptada;
	}
}
