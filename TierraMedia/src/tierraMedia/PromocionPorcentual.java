package tierraMedia;

import java.util.*;

public class PromocionPorcentual extends Promociones{
	double porcentaje;

	public PromocionPorcentual(String nombre, String tipo, int cantAtracciones, ArrayList<String> atracciones, double porcentaje) {
		super(nombre, tipo, cantAtracciones, atracciones);

		this.porcentaje=porcentaje;
	}
	
	
	public double CalcularCostoFinal(LinkedList<Atraccion> atraccion) {
		
		return costo=super.CalcularCostoFinal(atraccion)*porcentaje;
	}

	
	

}
