package m4.Games;

import java.awt.EventQueue;

/**
 * Hello world!
 *
 */
public class App{   
    	
    	/*
    	 * un Jpanel(contentPane) que contenga 4 Jpanel 
    	 * 
    	 * 1n Jpanel -> menu con dos botones: iniciarJuego y resolver
    	 * 
    	 * 2r Jpanel -> contener las pistas/vidas (5) que te resaltaran una letra (si eliges pista)
    	 * 		 + label donde se muestren las letras (que sera la palabra secreta)
    	 * 		OTRA OPCION: introducir un Jpanel con varios labels por letra  	  
    	 * 
    	 * 3r Jpanel -> botones con letras (crear array con todos los botones
    	 *  que escriba en cada uno una letra. ActionListener en cada boton 
    	 *  que recoja el texto del boton.    	 *  
    	 *  
    	 * 4o panel -> con imagenes seteadas en invisible, segun num fallos se van
    	 *  visibilizando. (10 fallos max)
    	 *  
    	 * arrayList de 10 strings, extraer de forma aleatoria una palabra a adivinar. 
    	 * 
    	 * si existe la letra -> se desactivara el boton y mostrara las letras 
    	 *  	de la palabra secreta acertada
    	 * si no existe la letra -> se desactivara el boton y se carga la siguiente imagen
    	 *  
    	 * metodo comprobacion GanarPerder() -> se ejecutara al agotar los 10 intentos
    	 * 		o cuando la palabra secreta este visible del todo. 
    	 * 
    	 * al finalizar partida aparecera un pop-up informando si win o lose 
    	 * 		(tamb de intentos fallidos)y preguntando si quiere volver a jugar. 
    	 * 		si es que si hara lo mismo que boton IniciarPartida, sino exit. 
    	 *  
    	 * todos los botones deshabilitados de entrada, al clickar iniciar juego se 
    	 *  habilitan todos. 
    	 *  
    	 * en la barra MENU añadir: Como Jugar - AboutUs
    	 * 
    	 *
    	 *PISTAS/VIDAS
    	 *	en una partida, se puede pedir una pista (implica perder vida)
    	 *			--> comprobar que contador de vidas sea > 1. 
    	 *			--> ha de salir pop-up informando que pidiendo pista pierdes vida
    	 *			--> si acepta pista, eliminar un boton de pista y actualizar valor
    	 *					de vidas -1. 
    	 *  la pista mostrara la primera letra no mostrada (de la palabra secreta)			
    	 *  
    	 */
    	
	public static void main(String[] args) {
		Juego juego = new Juego();
	}        
    
}
