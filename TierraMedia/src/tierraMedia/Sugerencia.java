package tierraMedia;

import java.util.*;

import promociones.Promocion;

public class Sugerencia {
	public static void main(String[] args) {
		String decision;
		Archivo a = new Archivo();
		LinkedList<Usuario> usuarios = usuarios = a.leerusuario(); // Carga lista de usuarios
		LinkedList<Atraccion> atracciones = atracciones = a.leeratracciones(); // Carga lista de atracciones
		LinkedList<Promocion> promociones = promociones = a.leerpromociones();// carga lista de promociones
		Scanner sc = new Scanner(System.in);

		for(Promocion p : promociones) {
			System.out.println(p.getNombre());
		}

	}
}