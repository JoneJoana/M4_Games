package m4.Games;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JOptionPane;

public class Controlador {
	private Juego juego;
	private Ventana ventana;
	private Menu menu;
	private ArrayList<String> palabrasAdicionales;

	public Controlador() {
		palabrasAdicionales = new ArrayList<String>();
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					menu = new Menu();
					menu.setVisible(true);
					
					actionBtnAnadirPalabra();
					actionBtnNuevoJuego();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}
	
	public void actionBtnAnadirPalabra() {
		menu.getBtnAnadirPalabra().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String palabra = JOptionPane.showInputDialog("Introduce una palabra");
				if(!(palabra == null)) {
					palabra = palabra.toUpperCase();
					if(comprovarPalabra(palabra)) {
						palabrasAdicionales.add(palabra);
					} else {
						JOptionPane.showMessageDialog(menu, palabra+" no es una palabra valida","ERROR", JOptionPane.ERROR_MESSAGE);
					}
				} 
			}
		});
	}
	
	private boolean comprovarPalabra(String palabra) {
		String letras = Ventana.LETRAS;
		for(char letraPalabra : palabra.toCharArray()) {
			String stringLetraPalabra = Character.toString(letraPalabra);
			if(!letras.contains(stringLetraPalabra)) {
				return false;
			}
		}
		return true;
	}
	
	public void actionBtnNuevoJuego() {
		menu.getBtnNuevoJuego().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				crearJuego(menu.getDificultad());
				menu.dispose();
			}
		});
	}
	
	public void crearJuego(int dificultad) {
		juego = new Juego(palabrasAdicionales, dificultad);
		// generar ventana
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ventana = new Ventana();

					ventana.setVisible(true);
					ventana.deshabilitarBotones();
					actionBtnIniciar();
					actionPista();
					actionResolver();
					actionBotonesLetras();

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	// Thread.sleep();
	public void actionBtnIniciar() {
		ventana.getBtnIniciarJuego().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				// escoger nueva palabra
				juego.crearPartida();
				juego.getPartida().ponerPalabraSecreta();
				ventana.cambiarPalabra(juego.getPartida().getPalabraActualSecreta());
				
				// poner letras teclado habilitadas
				ventana.habilitarBotones();
				quitarPistasUsadas();

				// quitar o poner invisible imagen
				ventana.cambiarImagen(Partida.INTENTOS_MAX - juego.getPartida().getIntentos());

				// deshabilitar boton nueva partida
				ventana.deshabilitarBtnInicio();
			}
		});
	}

	public void quitarPistasUsadas() {
		for (int i = 0; i < ventana.getArrayPistas().length - juego.getVidas(); i++) {
			ventana.quitarVida();
		}
	}

	public void actionResolver() {
		ventana.getBtnResolver().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// Confirmar siguiente partida
				if (juego.getVidas() > 1) {
					if (ventana.estasSeguro("Deseas resolver la partida? Perderas una vida", "Resolver")) {
						// juego.terminarPartida(); --pasa en juego
						// juego.crearPartida();
						// -> desabilitar botones --pasa en ventana
						ventana.deshabilitarBotones();
						// ->muestra la palabra secreta--pasa en ventana
						juego.getPartida().mostrarPalabra(juego.getPartida().getPalabra());
						juego.quitarVida(); // quitar una vida--pasa en juego
						ventana.quitarVida(); // (setVisible(false) un boton de pista --pasa en ventana )
						ventana.cambiarPalabra(juego.getPartida().getPalabraActualSecreta());
						// Habilitar boton nueva partido
						ventana.habilitarBtnInicio();
						//Saber si hemos terminado partida
						estadoJuego();
					}
				} else {
					JOptionPane.showMessageDialog(ventana, "No tienes suficientes vidas");
				}
			}
		});
	}

	public void actionPista() {
		ActionListener pistaListener = new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if(!juego.getPartida().isPistaPedida()) {
					// condicion vidas
					if (juego.getVidas() > 1) {
						boolean respuesta = ventana.estasSeguro("Perderas una vida a cambio de una pista, estas seguro?",
								"PISTA");
						if (respuesta == true) {
							ventana.quitarVida();
							juego.quitarVida();
							String letra = juego.getPartida().mostrarLetraPista();
							ventana.cambiarPalabra(juego.getPartida().getPalabraActualSecreta());
							ventana.deshabilitarLetra(letra);
							//Saber si hemos terminado partida y/o juego
							estadoJuego();
						}
					} else {
						JOptionPane.showMessageDialog(ventana,
								"No tienes suficientes vidas para canjearlas por pistas!!! :(");
					}
				} else {
					JOptionPane.showMessageDialog(ventana,
							"Ya has pedido una pista en esta partida!");
				}
				
			}
		};
		for (int i = 0; i < ventana.getArrayPistas().length; i++) {
			ventana.getArrayPistas()[i].addActionListener(pistaListener);
		}

	}

	public void actionBotonesLetras() {
		ActionListener letrasListener = new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				/*
				 * si existe la letra -> se desactivara el boton y mostrara las letras de la
				 * palabra secreta acertada 
				 * si no existe la letra -> se carga la siguiente
				 * imagen del ahorcado
				 */				
				
				// extraemos info del evento que activa este actionListener;
				String letra = e.getActionCommand();
				JButton tecla = (JButton) e.getSource();

				// guardamos en un array list, las posibles multiples posiciones de la letra
				ArrayList<Integer> posiciones = juego.getPartida().posicionesLetra(letra);

				if (juego.getPartida().cambiarAsterisco(letra, posiciones)) {
					ventana.cambiarPalabra(juego.getPartida().getPalabraActualSecreta());
				} else {
					juego.getPartida().quitarIntento();
					ventana.cambiarImagen(Partida.INTENTOS_MAX - juego.getPartida().getIntentos());
				}
				// en cualquier caso se desactiva botonLetra
				tecla.setEnabled(false);	
				
				//Saber si hemos terminado partida y/o juego
				estadoJuego();
			}

		};

		// esto no deberia ir en ventana? el action tiene la accion a hacer al clicar
		// ese boton, no tiene porque añadirlo tambien.
		// lo veo dos procesos distintos.
		for (int i = 0; i < ventana.getArrayBotonesLetras().length; i++) {
			ventana.getArrayBotonesLetras()[i].addActionListener(letrasListener);
		}

	}

	//aclarar en que momentos llamarlo
	public void estadoJuego() {
		
		if (juego.getPartida().comprobarFinPartida()) {
			
			if(juego.getPartida().ganarPartida()) {
				
				if(juego.comprobarFinJuego()) {			// partida ganada juego terminado
					JOptionPane.showMessageDialog(ventana, "Enhorabuena has ganado el juego, no quedan mas palabras.");
					ventana.dispose();
				} else {								// partida ganada juego no terminado
					respuestaFinPartida();
				}
				

				boolean respuesta = ventana.estasSeguro("quieres iniciar otra partida?", "FIN PARTIDA");


				if (respuesta) {// yes
					ventana.quitarVida();
					juego.quitarVida();
					// estadoJuego();
					ventana.habilitarBtnInicio();					
					ventana.getBtnIniciarJuego().doClick(5);// reiniciamos partida nueva

				} else {
					JOptionPane.showMessageDialog(ventana, "HASTA LA PROXIMA!");
					ventana.setVisible(false);
				}
			} else {
				juego.quitarVida();
				ventana.quitarVida();
				if(juego.comprobarFinJuego()) {			// partida perdida juego terminado
					JOptionPane.showMessageDialog(ventana, "Fin de juego. No te quedan mas vidas :(");
					ventana.dispose();
				} else {								// partida perdida juego no terminado
					respuestaFinPartida();
				}
			}
			
		}

	}
	
	private void respuestaFinPartida () {
		boolean respuesta = ventana.estasSeguro("quieres iniciar otra partida?", "FIN PARTIDA");
		if (respuesta) {					// partida ganada juego no terminado
			ventana.habilitarBtnInicio();					
			ventana.getBtnIniciarJuego().doClick(5);// reiniciamos partida nueva

		} else {
			JOptionPane.showMessageDialog(ventana, "HASTA LA PROXIMA!");			
			ventana.dispose();
		}
	}

}
