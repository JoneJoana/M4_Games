package m4.Games;

import java.util.ArrayList;

public class Juego {

	private int vidas;
	private Partida partida;
	private ArrayList<String> palabras;	
	private int dificultad;		//1 facil	2 intermedio	3 dificil

	public Juego(ArrayList<String> palabrasAdicionales, int dificultad) {
		this.vidas = 5;
		this.dificultad = dificultad;
		this.palabras = palabrasAdicionales;
		switch(dificultad) {
		case 1:
			rellenarPalabrasFacil();
			break;
		case 2:
			rellenarPalabrasIntermedio();
			break;
		case 3:
			rellenarPalabrasDificil();
			break;
		default:
			rellenarPalabrasFacil();
			break;
		}
	}

	private void rellenarPalabrasFacil() {
		palabras.add("TABACO");
		palabras.add("AZUCENA");
		palabras.add("GITHUB");
		palabras.add("BRITNEY");
	}

	private void rellenarPalabrasIntermedio() {
		rellenarPalabrasFacil();
		palabras.add("ESTOCOLMO");
		palabras.add("CANDELABRO");
		palabras.add("MADAGASCAR");
	}

	private void rellenarPalabrasDificil() {
		rellenarPalabrasIntermedio();
		palabras.add("RESURRECCION");
		palabras.add("DESHABILITAR");
		palabras.add("ANTANANARIVO");
	}

	
	public String extraerPalabraRandom() {

		int palabra = (int) (Math.random() * (palabras.size()));
		String result = palabras.get(palabra);
		palabras.remove(palabra);
		return result;

	}

	public void crearPartida() {
		switch(dificultad) {
		case 1:
			partida = new Partida(extraerPalabraRandom(), 10);	//facil 10 intentos
			break;
		case 2:
			partida = new Partida(extraerPalabraRandom(), 8);	//intermedio 8 intentos
			break;
		case 3:
			partida = new Partida(extraerPalabraRandom(), 6);	//dificil	6 intentos
			break;
		}
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
		if(vidas == 0 || palabras.size() == 0) {
			return true;
		}
		return false;
	}

}
