package tierraMedia;

import static org.junit.Assert.*;

import java.util.*;

import org.junit.Test;
import promociones.*;

public class testTierraMedia {

	@Test
	public void test() {
		Archivo a = new Archivo();
		a.leerarchivos();
		LinkedList<Usuario> usuarios = a.getListausuarios(); // Carga lista de usuarios
		LinkedList<Atraccion> atracciones = a.getListatracciones(); // Carga lista de atracciones
		LinkedList<Promocion> promociones = a.getListapromociones();// carga lista de promociones
		Collections.sort(atracciones, Collections.reverseOrder()); // Ordena lista de atracciones
		Collections.sort(promociones, Collections.reverseOrder()); // Ordena lista de promociones
		PromocionAbsoluta promo = new PromocionAbsoluta("Pack Terror",new String[] {"Bosque Sombrío","Sendero de los Muertos"}, 12);
		
		promo.calcularDuracionyCosto(new String[] {"Bosque Sombrío","Sendero de los Muertos"}, atracciones);
		assertEquals(1.5, promo.getDuracion(), 0.001);
		
		PromocionPorcentual promo1 = new PromocionPorcentual("Pack Trekking", new String[] {"Montañas Nubladas","Río Bruinen"}, 25);
		promo1.calcularDuracionyCosto(new String[] {"Montañas Nubladas","Río Bruinen"}, atracciones);
		assertEquals(9, promo1.getCosto(), 0.001);
		
		Usuario Cindriel = new Usuario("Cindriel", 200, 1.5);
		Atraccion atraccion = new Atraccion("Rivendel", 40, 2, 20);
		Cindriel.aceptarPromos(promo1);
		Cindriel.aceptarPromos(promo);
		Cindriel.aceptarAtracciones(atraccion);		
		assertEquals(61 , Cindriel.calcularDinerogastado(), 0.001);
		assertEquals(11, Cindriel.calcularTiempoNecesario(), 0.001);
				
		assert(a.leerarchivos());
		assert(a.escribirArchivos(Cindriel));
	}
	
	
}
