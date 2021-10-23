package tierraMedia;

import static org.junit.Assert.*;

import org.junit.Test;
import promociones.*;

public class testTierraMedia {

	@Test
	public void test() {
		String[] atracciones = {"Bosque Sombrío","Sendero de los Muertos"};
		PromocionAbsoluta promo = new PromocionAbsoluta("Pack Terror",atracciones,12);
		promo.calcularDuracionyCosto(atracciones, null);
				
	}
	
	
}
