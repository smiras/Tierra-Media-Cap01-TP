package promociones;

import java.util.*;

public class PromocionPorcentual extends Promocion {
	private static double duracionFinal;
	private double porcentaje;
	
	public PromocionPorcentual(String nombre, String[] atracciones,double porcentaje, double duracionFinal) {
		super(nombre, atracciones, duracionFinal);
		// TODO Auto-generated constructor stub
		this.porcentaje=porcentaje;
	}

	

}
