package tierraMedia;

import java.io.*;
import java.util.*;

import promociones.Promocion;
import promociones.PromocionAB;
import promociones.PromocionAbsoluta;
import promociones.PromocionPorcentual;

public class Archivo {

	LinkedList<Usuario> listausuarios = new LinkedList<Usuario>();
	LinkedList<Atraccion> listatracciones = new LinkedList<Atraccion>();
	LinkedList<Promocion> listapromociones = new LinkedList<Promocion>();

	public void leerarchivos() {

		try {
			FileReader input = new FileReader("files/Usuarios.txt");
			BufferedReader bufInput = new BufferedReader(input);

			String line;

			line = bufInput.readLine();

			while (line != null) {
				String[] datos;

				datos = line.split(",");
				Usuario u = new Usuario(datos[0], Double.parseDouble(datos[1]), Double.parseDouble(datos[2]));
				listausuarios.add(u);

				line = bufInput.readLine();
			}
			bufInput.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			FileReader input = new FileReader("files/Atracciones.txt");
			BufferedReader bufInput = new BufferedReader(input);

			String line = bufInput.readLine();

			while (line != null) {
				String[] dato;
				dato = line.split("_");

				Atraccion at = new Atraccion(dato[0], Double.parseDouble(dato[1]), Double.parseDouble(dato[2]),
						Integer.parseInt(dato[3]));
				listatracciones.add(at);

				line = bufInput.readLine();
			}
			bufInput.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			FileReader input = new FileReader("files/Promociones.txt");
			BufferedReader bufInput = new BufferedReader(input);

			String line = bufInput.readLine();

			while (line != null) {
				String[] data = line.split(",");
				String atracciones[] = new String[Integer.parseInt(data[3])];

				if (data[1].equals("porcentual")) {
					for (int i = 4; i < data.length; i++) {
						atracciones[i - 4] = data[i];
					}

					PromocionPorcentual pp = new PromocionPorcentual(data[0], atracciones, Double.parseDouble(data[2]));
					pp.calcularDuracion(atracciones, listatracciones);

					listapromociones.add(pp);
				} else {
					if (data[1].equals("absoluta")) {
						double duracionFinal = 0;
						for (int i = 4; i < data.length; i++) {
							atracciones[i - 4] = data[i];
						}
						for (String ai : atracciones) {
							for (Atraccion a : listatracciones) {
								if (ai.equals(a.getnombre())) {

									duracionFinal += a.getDuracion();
								}
							}
						}
						PromocionAbsoluta pa = new PromocionAbsoluta(data[0], atracciones, Double.parseDouble(data[2]),
								duracionFinal);
						listapromociones.add(pa);
					} else {
						String atraccionesextra[] = new String[Integer.parseInt(data[3]) - Integer.parseInt(data[2])];
						double duracionFinal = 0;
						for (int i = 4; i < data.length; i++) {
							atracciones[i - 4] = data[i];
						}
						for (int i = atracciones.length + 4; i < data.length; i++) {
							atraccionesextra[i - 4 - atracciones.length] = data[i];
						}
						for (Atraccion a : listatracciones) {
							for (String ai : atracciones) {

								if (ai.equals(a.getnombre())) {

									duracionFinal += a.getDuracion();
								}
							}
							for (String aextra : atraccionesextra) {

								if (aextra.equals(a.getnombre())) {

									duracionFinal += a.getDuracion();
								}
							}
						}
						PromocionAB pab = new PromocionAB(data[0], atracciones, atraccionesextra, duracionFinal);
						listapromociones.add(pab);
					}
				}

				line = bufInput.readLine();
			}
			bufInput.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public LinkedList<Usuario> getListausuarios() {
		return listausuarios;
	}

	public LinkedList<Atraccion> getListatracciones() {
		return listatracciones;
	}

	public LinkedList<Promocion> getListapromociones() {
		return listapromociones;
	}
}
