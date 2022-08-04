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
		palabras.add("TABACO");
		palabras.add("ESTOCOLMO");
		palabras.add("AZUCENA");
		palabras.add("CANDELABRO");
		palabras.add("RESURRECCION");
		palabras.add("DESHABILITAR");
		palabras.add("GITHUB");
		palabras.add("ANTANANARIVO");
		palabras.add("MADAGASCAR");
		palabras.add("BRITNEY");
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
	
	public boolean comprobarFinJuego() {
		if(vidas < 0 || palabras.size() == 0) {
			return true;
		}
		return false;
	}

}
