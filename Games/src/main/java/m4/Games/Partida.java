package m4.Games;

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

}
