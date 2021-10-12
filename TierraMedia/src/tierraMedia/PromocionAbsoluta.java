package tierraMedia;

import java.util.ArrayList;

public class PromocionAbsoluta extends Promociones{
double costoFinal;
	public PromocionAbsoluta(String nombre, String tipo, int cantAtracciones, ArrayList<String> atracciones, double costoFinal) {
		super(nombre, tipo, cantAtracciones, atracciones);
		this.costoFinal=costoFinal;
	}
	
	public double getCostoFinal() {
		return costoFinal;
	}
	

}
