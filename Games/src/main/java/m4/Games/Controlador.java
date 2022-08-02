package m4.Games;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controlador {
	Juego juego;
	Ventana ventana;

	public Controlador() {
		juego = new Juego();
		// generar ventana
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ventana = new Ventana();

					ventana.setVisible(true);
					actionBtnIniciar();

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

	// Thread.sleep();
	public void actionBtnIniciar() {
		ventana.btnIniciarJuego.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// poner letras teclado habilitadas
				ventana.habilitarBotones();

				// quitar o poner invisible imagen
				// ventana.cambiarImagen(); david

				// escoger nueva palabra
				juego.crearPartida();
				ventana.ponerPalabraSecreta(juego.partida.palabra.length());
			}
		});
	}

	public void actionResolver() {//david
		ventana.btnResolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// juego.terminarPartida(); --pasa en juego
				// -> desabilitar botones --pasa en ventana
				// ->muestra la palabra secreta--pasa en ventana
				// ->juego.quitarUnaVida(); quitar una vida--pasa en juego
				// ->ventana.quitarVida(); (setVisible(false) un boton de pista --pasa en ventana )

			}
		});
	}

	public void actionPista() {//ionela
		ActionListener pistaListener = new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				//ventana.estasSeguroQueQuieresPista(); 
				//-si es true la funcion que llamamos 
				//->juego.quitarUnaVida();
				//->ventana.quitarVida();
				//ventana.mostrarLetraPista();
				// --a mejorar-->poner botones de pistas en arrayList
			}
		};
		ventana.buttonVida1.addActionListener(pistaListener);
		ventana.buttonVida2.addActionListener(pistaListener);
		ventana.buttonVida3.addActionListener(pistaListener);
		ventana.buttonVida4.addActionListener(pistaListener);
		ventana.buttonVida5.addActionListener(pistaListener);

	}

	public void actionBotonesLetras() {//joana
		ActionListener letrasListener = new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				//ventana.deshabilitarLetra();
				//juego.comprobarExisteLetraEnPalabra();
				//juego.comprobarFinPartida();
			}
		};
		for (int i = 0; i < ventana.arrayBotonesLetras.length; i++) {
			ventana.arrayBotonesLetras[i].addActionListener(letrasListener);
		}

	}
	
	/*
	 * cambiar atributos a private, hacer getters de todos y setters de los necesarios
	 * hacer barra de menu con boton de ayuda y boton about us
	 */

}
