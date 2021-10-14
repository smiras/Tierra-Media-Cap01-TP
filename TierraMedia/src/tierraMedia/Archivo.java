package tierraMedia;

import java.io.*;
import java.util.*;

import promociones.Promocion;
import promociones.PromocionAB;
import promociones.PromocionAbsoluta;
import promociones.PromocionPorcentual;

public class Archivo {

	public LinkedList leerusuario() {
		LinkedList<Usuario> listausuarios = new LinkedList<Usuario>();
		try {
			FileReader input = new FileReader("Usuarios.txt");
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

		return listausuarios;
	}

	public LinkedList leeratracciones() {
		LinkedList<Atraccion> lista = new LinkedList<Atraccion>();
		try {
			FileReader input = new FileReader("Atracciones.txt");
			BufferedReader bufInput = new BufferedReader(input);

			String line = bufInput.readLine();

			while (line != null) {
				String[] dato;
				dato = line.split("_");

				Atraccion at = new Atraccion(dato[0], Double.parseDouble(dato[1]), Double.parseDouble(dato[2]),
						Integer.parseInt(dato[3]));
				lista.add(at);

				line = bufInput.readLine();
			}
			bufInput.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return lista;
	}

	public LinkedList leerpromociones() {
		LinkedList<Promocion> lista = new LinkedList<Promocion>();
		try {
			FileReader input = new FileReader("Promociones.txt");
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

					lista.add(pp);
				} else {
					if (data[1].equals("absoluta")) {
						for (int i = 4; i < data.length; i++) {
							atracciones[i - 4] = data[i];
						}

						PromocionAbsoluta pa = new PromocionAbsoluta(data[0], atracciones);
						lista.add(pa);
					} else {
						String atraccionesextra[] = new String[Integer.parseInt(data[3]) - Integer.parseInt(data[2])];

						for (int i = 4; i < data.length; i++) {
							atracciones[i - 4] = data[i];
						}
						for (int i = atracciones.length + 4; i < atraccionesextra.length; i++) {
							atraccionesextra[i - 4 - atracciones.length] = data[i];
						}

						PromocionAB pab = new PromocionAB(data[0], atracciones, atraccionesextra);
						lista.add(pab);
					}
				}

				line = bufInput.readLine();
			}
			bufInput.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return lista;
	}
}
