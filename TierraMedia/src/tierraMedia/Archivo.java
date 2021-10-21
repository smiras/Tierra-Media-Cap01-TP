package tierraMedia;

import java.io.*;
import java.util.*;
import promociones.*;

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
					pp.calcularDuracionyCosto(atracciones, listatracciones);
					pp.calcularCupo(atracciones, listatracciones);

					listapromociones.add(pp);
				} else {
					if (data[1].equals("absoluta")) {
						for (int i = 4; i < data.length; i++) {
							atracciones[i - 4] = data[i];
						}

						PromocionAbsoluta pa = new PromocionAbsoluta(data[0], atracciones, Double.parseDouble(data[2]));
						pa.calcularDuracionyCosto(atracciones, listatracciones);
						pa.calcularCupo(atracciones, listatracciones);
						listapromociones.add(pa);
					} else {
						if (data[1].equals("AxB")) {
							String atraccionespagas[] = new String[Integer.parseInt(data[2])];
							String atraccionesextra[] = new String[Integer.parseInt(data[3])
									- Integer.parseInt(data[2])];
							int cantatraccionespagas = Integer.parseInt(data[2]);

							for (int i = 4; i < data.length; i++) {
								if (i - 4 < cantatraccionespagas) {
									atraccionespagas[i - 4] = data[i];
								} else {
									atraccionesextra[i - cantatraccionespagas - 4] = data[i];
								}
							}

							PromocionAB pab = new PromocionAB(data[0], atraccionespagas, atraccionesextra);
							pab.calcularCupo(atraccionesextra, listatracciones, atraccionesextra);
							pab.calcularDuracionyCosto(atraccionespagas, listatracciones);
							listapromociones.add(pab);
						}
					}
				}
				line = bufInput.readLine();
			}
			bufInput.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void escribirArchivos(Usuario user) {

		try {
			FileWriter output = new FileWriter("files/" + user.getNombre() + ".txt");
			BufferedWriter bf = new BufferedWriter(output);

			bf.write("---------------------------------\n");
			bf.write("Tu ticket de compra: "+ user.getNombre());
			bf.write("\n-------------------------------------------------------------------");
			bf.write("\nSus atracciones elegidas son: ");
			for (Promocion promos : user.getPromosAceptadas()) {

				bf.write("\n"+(promos.toString()));
			}
			for (Atraccion atraccion : user.getAtraccionAceptada()) {

				bf.write("\n"+(atraccion.toString()));
			}
			bf.write("\nGasto Final: "+user.calcularDinerogastado());
			bf.write("\nTiempo Necesario: "+user.calcularTiempoNecesario());
			bf.write("\n¡Gracias por tu compra! ¡Te esperamos en la Tierra Media!");
			bf.write("\n-------------------------------------------------------------------");
			bf.close();
		} catch (

		IOException e) {
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
