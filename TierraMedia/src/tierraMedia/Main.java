package tierraMedia;

import java.util.*;

public class Main {
	public static void main(String[] args) {
		Archivo a = new Archivo();
		LinkedList<Usuario> usuarios = new LinkedList<Usuario>();
		usuarios = a.leerusuario(); //Carga lista de usuarios
		
		LinkedList<Atraccion> atracciones = new LinkedList<Atraccion>();
		atracciones = a.leeratracciones(); //Carga lista de atracciones
		
		LinkedList<Promociones> promociones = new LinkedList<Promociones>();
		promociones=a.leerpromociones();//carga lista de promociones

		for (Promociones p : promociones) {

			System.out.println(p.getNombre());

		}

		/*
		for (Usuario u : usuarios) {

			System.out.println(u.getnombre());

		}
		
		for (Atraccion at : atracciones) {

			System.out.println(at.getnombre());

		}*/
		
	}
}