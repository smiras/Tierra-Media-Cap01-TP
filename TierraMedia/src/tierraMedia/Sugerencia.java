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
			System.out.println(p.getCostoFinal());
			System.out.println(p.getDuracionFinal());
		}

	}
}

