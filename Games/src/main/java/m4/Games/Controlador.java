package m4.Games;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;

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

				// quitar o poner invisible imagen
				ventana.cambiarImagen(0);

				// escoger nueva palabra
				juego.crearPartida();
				ventana.ponerPalabraSecreta(juego.getPartida().getPalabra().length());
			}
		});
	}

	public void actionResolver() {// david
		ventana.getBtnResolver().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// Confirmar siguiente partida ventana.confirmarPartida()
				// if(ventana.confirmarPartida()) {
				// juego.terminarPartida(); --pasa en juego
				juego.crearPartida();
				// -> desabilitar botones --pasa en ventana
				// ->muestra la palabra secreta--pasa en ventana

				// ->juego.quitarVida(); quitar una vida--pasa en juego
				// ->ventana.quitarVida(); (setVisible(false) un boton de pista --pasa en
				// ventana )

			}
		});
	}

	public void actionPista() {// ionela
		ActionListener pistaListener = new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// condicion vidas
				boolean respuesta = ventana.estasSeguro("Perderas una vida a cambio de una pista, estas seguro?",
						"PISTA");

				// -si es true la funcion que llamamos
				// ->juego.quitarUnaVida();
				// ->ventana.quitarVida();
				// ventana.mostrarLetraPista();
				// --a mejorar-->poner botones de pistas en arrayList
			}
		};
		for (int i = 0; i < ventana.getArrayPistas().length; i++) {
			ventana.getArrayPistas()[i].addActionListener(pistaListener);
		}

	}

	public void actionBotonesLetras() {// joana
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

				/*
				 * acceder a los asteriscos por posicion y ver cuales hay que cambiar, segun los
				 * datos guardados en lanterior arraylist. Podriamos hacer que
				 * ventana.ponerPalabraSecreta(xxx) devolviera la palabra hecha asteriscos, pero
				 * como ese metodo mete la palabra en JLabel, como se modificarian las letras
				 * por separado de un JLabel??
				 */

				// en cualquier caso se desactiva botonLetra
				tecla.setEnabled(false);

				// juego.comprobarFinPartida();
			}
		};

		// esto no deberia ir en ventana? el action tiene la accion a hacer al clicar
		// ese boton, no tiene porque añadirlo tambien.
		// lo veo dos procesos distintos.
		for (int i = 0; i < ventana.getArrayBotonesLetras().length; i++) {
			ventana.getArrayBotonesLetras()[i].addActionListener(letrasListener);
		}

	}
	/*
	 * public Juego getJuego() { return juego; }
	 * 
	 * public Ventana getVentana() { return ventana; }
	 */

	/*
	 * hacer barra de menu con boton de ayuda y boton about us
	 */

}
