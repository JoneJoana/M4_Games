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
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

		actionBtnIniciar();

	}

	public void actionBtnIniciar() {
		ventana.btnIniciarJuego.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// poner letras teclado habilitadas
				ventana.habilitarBotones();

				// quitar o poner invisible imagen
				// ventana.cambiarImagen();

				// escoger nueva palabra
				juego.crearPartida();
				ventana.ponerPalabraSecreta(juego.partida.palabra.length());
			}
		});
	}

}
