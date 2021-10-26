package tierraMedia;

import java.util.LinkedList;
import promociones.*;

public class Usuario {
	private String nombre;
	private double presupuesto;
	private double tiempodisponible;
	private LinkedList<Promocion> promosAceptadas = new LinkedList<Promocion>();
	private LinkedList<Atraccion> atraccionAceptada = new LinkedList<Atraccion>();
	private double dineroGastado;
	private double tiempoNecesario;

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

	public double calcularDinerogastado() {
		dineroGastado = 0;
		promosAceptadas.forEach(promo -> dineroGastado += promo.getCosto());
		atraccionAceptada.forEach(atraccion -> dineroGastado += atraccion.getCosto());
		return dineroGastado;
	}

	public double calcularTiempoNecesario() {
		tiempoNecesario = 0;
		promosAceptadas.forEach(promo -> tiempoNecesario += promo.getDuracion());
		atraccionAceptada.forEach(atraccion -> tiempoNecesario += atraccion.getDuracion());
		return tiempoNecesario;
	}
}
