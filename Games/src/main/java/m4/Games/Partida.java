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
		char[] palabraSecreta = palabraActualSecreta.toCharArray();
		for (int i = 0; i < palabraSecreta.length; i += 2) {
			if (palabraSecreta[i] == '*') {

			}
		}
	}

	public char obtenerLetraDeLaPosicion() {
		char letra = 0;

		return letra;
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

}
