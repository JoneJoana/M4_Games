package m4.Games;

import java.util.ArrayList;

public class Juego {

	private int vidas;
	private Partida partida;
	private ArrayList<String> palabras = new ArrayList<String>();	

	public Juego() {
		this.vidas = 5;
		rellenarPalabras();
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
	
	public void quitarVida() {
		vidas--;
	}
	
	public int getVidas() {
		return vidas;
	}

	public Partida getPartida() {
		return partida;
	}

	public ArrayList<String> getPalabras() {
		return palabras;
	}

}
