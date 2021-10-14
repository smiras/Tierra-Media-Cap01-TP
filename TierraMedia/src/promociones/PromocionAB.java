package promociones;

import java.util.*;

public class PromocionAB extends Promocion{
	private  double duracionFinal;
	private String atraccionesExtra[];
	private double costoFinal;
	
	public PromocionAB(String nombre, String[] atracciones, String[] atraccionesExtra, double duracionFinal) {
		super(nombre, atracciones, duracionFinal);
		// TODO Auto-generated constructor stub
		this.atraccionesExtra = atraccionesExtra;
	}

	

}
