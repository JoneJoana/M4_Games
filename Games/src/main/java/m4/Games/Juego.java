package m4.Games;

import java.awt.EventQueue;
import java.util.ArrayList;

public class Juego {

	int vidas;
	Partida partida;
	ArrayList<String> palabras = new ArrayList<String>();

	public Juego() {
		this.vidas = 5;
		rellenarPalabras();
		this.partida = new Partida(extraerPalabraRandom());

	
	}

	private void rellenarPalabras() {
		palabras.add("tabaco");
		palabras.add("estocolmo");
		palabras.add("azucena");
		palabras.add("candelabro");
		palabras.add("resurreccion");
		palabras.add("deshabilitar");
		palabras.add("github");
		palabras.add("antananaribo");
		palabras.add("madagascar");
		palabras.add("britney");
	}

	public String extraerPalabraRandom() {

		int palabra = (int) (Math.random() * (palabras.size()));
		String result = palabras.get(palabra);
		palabras.remove(palabra);
		return result;

	}

	public void crearPartida() {
		partida = new Partida(extraerPalabraRandom());
	}

}
