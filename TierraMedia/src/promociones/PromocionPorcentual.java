package promociones;

import java.util.*;

public class PromocionPorcentual extends Promocion {
	double porcentaje;

	public PromocionPorcentual(String nombre, String[] atracciones, double porcentaje) {
		super(nombre, atracciones);
		// TODO Auto-generated constructor stub
		this.porcentaje = porcentaje;
	}

}
