package promociones;

import java.util.*;
import tierraMedia.Atraccion;

public class PromocionPorcentual extends Promocion {
	private double porcentaje;
	
	public PromocionPorcentual(String nombre, String[] atracciones,double porcentaje) {
		super(nombre, atracciones);
		this.porcentaje=porcentaje/100;
	}

	@Override
	public void calcularDuracionyCosto(String[] atracciones, LinkedList<Atraccion> listatracciones) {
		super.calcularDuracionyCosto(atracciones, listatracciones);
		super.costo = super.getCosto() -(super.getCosto()*porcentaje);
		
		}
	
	@Override
	public String toString() {
		
		return "\nPromocion \nNombre: " + super.getNombre() + "\nAtracciones Incluidas: " + Arrays.toString(super.getAtracciones())
		+"\nCosto: " + costo + "\nDuracion: " + duracion+"\nTu ahorro es del:"+porcentaje*100+"%";
	}

}
