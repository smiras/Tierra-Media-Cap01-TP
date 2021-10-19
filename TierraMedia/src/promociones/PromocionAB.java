package promociones;

import java.util.*;

import tierraMedia.Atraccion;

public class PromocionAB extends Promocion {
	private String atraccionesExtra[];

	public PromocionAB(String nombre, String[] atracciones, String[] atraccionesExtra) {
		super(nombre, atracciones);
		this.atraccionesExtra = atraccionesExtra;
	}

	@Override
	public void calcularDuracionyCosto(String[] atracciones, LinkedList<Atraccion> listatracciones) {
		super.calcularDuracionyCosto(atracciones, listatracciones);

		for (String ae : atraccionesExtra) {
			for (Atraccion a : listatracciones) {
				if (ae.equals(a.getNombre())) {

					duracion += a.getDuracion();

				}

			}

		}
	}
	
	
	public void calcularCupo(String[] atracciones, LinkedList<Atraccion> lista, String[] atraccionesextra) {
		for(Atraccion a : lista) {
			cupo = a.getCupo();
			for(String at:atracciones) {
				
				if(a.getNombre().equals(at)&&cupo<a.getCupo()) {
					cupo=a.getCupo();
				}
			}
			for(String ate:atraccionesextra) {
				
				if(a.getNombre().equals(ate)&&cupo<a.getCupo()) {
					cupo=a.getCupo();
				}
			}
		}
	}

}
