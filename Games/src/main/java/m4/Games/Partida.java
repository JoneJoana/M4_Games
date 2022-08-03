package m4.Games;

import java.util.ArrayList;

public class Partida{
	
	private int intentos;
	private String palabra;	
	
	public Partida(String palabra) {
		this.intentos = 10;
		this.palabra = palabra;		
	}
	
	public String getPalabra() {
		return palabra;
	}
	
	public int intentos() {
		return intentos;
	}
	
	public ArrayList<Integer> posicionesLetra(String letraTeclado) {
		
		//creamos un arrayList donde guardaremos las posibles multiples posiciones de dicha letra
		ArrayList<Integer> posicionesLetra = new ArrayList<Integer>();		
		//recorremos palabra de la partida char a char para comparar con la letra pulsada
		for(int i=0;i<palabra.length();i++) {
			if(letraTeclado.charAt(0)==palabra.charAt(i)) {
				//si encuentra la letra añade al arrayList dicha posicion
				posicionesLetra.add(i);				
			}
		}		
		return posicionesLetra;
	}

}
