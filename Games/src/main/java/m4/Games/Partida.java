package m4.Games;

import java.util.ArrayList;

public class Partida {

	private int intentos;
	private String palabra;
	private String palabraActualSecreta;

	public Partida(String palabra) {
		this.intentos = 10;
		this.palabra = palabra;

	}

	public String getPalabra() {
		return palabra;
	}

	public String getPalabraActualSecreta() {
		return palabraActualSecreta;
	}

	public int intentos() {
		return intentos;
	}

	public ArrayList<Integer> posicionesLetra(String letraTeclado) {

		// creamos un arrayList donde guardaremos las posibles multiples posiciones de
		// dicha letra
		ArrayList<Integer> posicionesLetra = new ArrayList<Integer>();
		// recorremos palabra de la partida char a char para comparar con la letra
		// pulsada
		for (int i = 0; i < palabra.length(); i++) {
			if (letraTeclado.charAt(0) == palabra.charAt(i)) {
				// si encuentra la letra añade al arrayList dicha posicion
				posicionesLetra.add(i);
			}
		}
		return posicionesLetra;
	}

	public void mostrarLetraPista() {
		String letra = "";
		char[] palabraSecreta = palabraActualSecreta.toCharArray();// la palabra con los asteriscos
		for (int i = 0; i < palabraSecreta.length; i += 2) {// Se recorre
			if (palabraSecreta[i] == '*') {// al encontrar el primer *
				letra = String.valueOf(palabra.charAt(i / 2));// guardar la letra que hay en esa posicion
				break;// paramos para que no llegue al final del bucle, ya que no es necesario
			}

		}
		cambiarAsterisco(letra, posicionesLetra(letra));
	}

	/***
	 * 
	 * @param longitud
	 */
	public void ponerPalabraSecreta() {
		String palabra = "";
		for (int i = 0; i < this.palabra.length(); i++) {
			palabra += "* ";
		}

		palabraActualSecreta = palabra;
	}

	public boolean cambiarAsterisco(String letra, ArrayList<Integer> posiciones) {
		char[] palabraSecreta = palabraActualSecreta.toCharArray();
		boolean existeLetra = false;
		for (int i = 0; i < palabraSecreta.length; i += 2) {
			for (int j = 0; j < posiciones.size(); j++) {
				if (i == (posiciones.get(j)) * 2) {
					palabraSecreta[i] = letra.charAt(0);
					existeLetra = true;
				}
			}
		}

		palabraActualSecreta = String.valueOf(palabraSecreta);

		return existeLetra;
	}

	public void mostrarPalabra(String palabra) {
		char[] palabraSecreta = palabraActualSecreta.toCharArray();

		for (int i = 0; i < palabraSecreta.length; i += 2) {
			palabraSecreta[i] = palabra.charAt(i / 2);
		}

		palabraActualSecreta = String.valueOf(palabraSecreta);
	}

}
