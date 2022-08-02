package m4.Games;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.CardLayout;
import javax.swing.BoxLayout;
import javax.swing.SpringLayout;
import java.awt.GridLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import java.awt.Button;
import java.awt.Label;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ventana extends JFrame {

	private JPanel contentPane;
	JButton btnIniciarJuego;
	JButton[] arrayBotones;
	Label labelPalabra;

	/**
	 * Create the frame.
	 */
	public Ventana() {
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 649, 508);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 2, 10, 10));

		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2);
		panel_2.setLayout(new GridLayout(0, 1, 10, 10));

		JPanel panelMenu = new JPanel();
		panelMenu.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Menu",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2.add(panelMenu);
		panelMenu.setLayout(new GridLayout(0, 1, 10, 10));

		btnIniciarJuego = new JButton("Iniciar juego");

		btnIniciarJuego.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panelMenu.add(btnIniciarJuego);

		JButton btnResolver = new JButton("Resolver");
		btnResolver.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panelMenu.add(btnResolver);

		JPanel panelPalabra = new JPanel();
		panelPalabra.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2.add(panelPalabra);
		panelPalabra.setLayout(new GridLayout(0, 1, 0, 0));

		JPanel panelVidas = new JPanel();
		panelPalabra.add(panelVidas);
		panelVidas.setLayout(new GridLayout(1, 5, 0, 0));

		Button buttonVida1 = new Button("Vida");
		panelVidas.add(buttonVida1);

		Button buttonVida2 = new Button("Vida");
		panelVidas.add(buttonVida2);

		Button buttonVida3 = new Button("Vida");
		panelVidas.add(buttonVida3);

		Button buttonVida4 = new Button("Vida");
		panelVidas.add(buttonVida4);

		Button buttonVida5 = new Button("Vida");
		panelVidas.add(buttonVida5);

		JPanel panelPalabraSecreta = new JPanel();
		panelPalabra.add(panelPalabraSecreta);
		panelPalabraSecreta.setLayout(new GridLayout(0, 1, 0, 0));

		JPanel panel_3 = new JPanel();
		panel_3.setBorder(
				new TitledBorder(null, "Palabra secreta", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelPalabraSecreta.add(panel_3);
		panel_3.setLayout(new GridLayout(1, 0, 0, 0));

		labelPalabra = new Label("Palabra secreta");
		panel_3.add(labelPalabra);

		JPanel panelTeclado = new JPanel();
		panelTeclado.setBorder(new TitledBorder(null, "Teclado", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.add(panelTeclado);
		panelTeclado.setLayout(new GridLayout(6, 5, 0, 0));

		rellenarBotonesLetras(panelTeclado);

		JPanel panelDibujo = new JPanel();
		panelDibujo.setBorder(new LineBorder(new Color(0, 0, 0)));
		contentPane.add(panelDibujo);

	}

	private void rellenarBotonesLetras(JPanel panelTeclado) {
		arrayBotones = new JButton[27];
		// rellenar el array
		String letras = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ";
		for (int i = 0; i < letras.length(); i++) {
			arrayBotones[i] = new JButton(String.valueOf(letras.charAt(i)));// nombramos boton
			arrayBotones[i].setEnabled(false);// dejamos dehabilitados
			panelTeclado.add(arrayBotones[i]);
		}
	}

	public void habilitarBotones() {
		for (int i = 0; i < arrayBotones.length; i++) {
			arrayBotones[i].setEnabled(true);
		}
	}

	public void deshabilitarBotones() {
		for (int i = 0; i < arrayBotones.length; i++) {
			arrayBotones[i].setEnabled(false);
		}
	}

	public void ponerPalabraSecreta(int longitud) {
		String palabra = "";
		for (int i = 0; i < longitud; i++) {
			palabra += "* ";
		}

		labelPalabra.setText(palabra);
	}

}
