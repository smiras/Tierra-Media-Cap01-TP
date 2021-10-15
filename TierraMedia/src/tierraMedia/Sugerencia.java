package tierraMedia;

import java.util.*;

import promociones.Promocion;

public class Sugerencia {
	public static void main(String[] args) {
		String decision;
		Archivo a = new Archivo();
		a.leerarchivos();
		LinkedList<Usuario> usuarios = a.getListausuarios(); // Carga lista de usuarios
		LinkedList<Atraccion> atracciones = a.getListatracciones(); // Carga lista de atracciones
		LinkedList<Promocion> promociones = a.getListapromociones();// carga lista de promociones
		Scanner sc = new Scanner(System.in);

		for (Promocion p : promociones) {
			System.out.println(p.getNombre());
			System.out.println(p.getDuracionFinal());
		}

	}
}

/*
 * Costo 25,000000: Duracion 3,000000: Costo 25,000000: Duracion 3,000000: Costo
 * 15,000000: Duracion 9,500000: Costo 3,000000: Duracion 6,500000: Costo
 * 17,000000: Duracion 5,500000: Costo 17,000000: Duracion 5,500000:
 */