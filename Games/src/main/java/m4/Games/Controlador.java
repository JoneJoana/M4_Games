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

	public Controlador() {
		juego = new Juego();
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
				// poner letras teclado habilitadas
				ventana.habilitarBotones();
				quitarPistasUsadas();

				// quitar o poner invisible imagen
				ventana.cambiarImagen(0);

				// escoger nueva palabra
				juego.crearPartida();
				juego.getPartida().ponerPalabraSecreta();
				ventana.cambiarPalabra(juego.getPartida().getPalabraActualSecreta());
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
				// condicion vidas
				if (juego.getVidas() > 1) {
					boolean respuesta = ventana.estasSeguro("Perderas una vida a cambio de una pista, estas seguro?",
							"PISTA");
					if (respuesta == true) {
						ventana.quitarVida();
						juego.quitarVida();
						juego.getPartida().mostrarLetraPista();
						ventana.cambiarPalabra(juego.getPartida().getPalabraActualSecreta());
					}
				} else {
					JOptionPane.showMessageDialog(ventana,
							"No tienes suficientes vidas para canjearlas por pistas!!! :(");
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
				 * palabra secreta acertada si no existe la letra -> se carga la siguiente
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

				// partida.comprobarFinPartida();
				//juego.comprobarFinJuego();
			}

		};

		// esto no deberia ir en ventana? el action tiene la accion a hacer al clicar
		// ese boton, no tiene porque añadirlo tambien.
		// lo veo dos procesos distintos.
		for (int i = 0; i < ventana.getArrayBotonesLetras().length; i++) {
			ventana.getArrayBotonesLetras()[i].addActionListener(letrasListener);
		}

	}

}
