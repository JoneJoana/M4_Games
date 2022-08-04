package m4.Games;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.border.LineBorder;
import java.awt.Button;
import java.awt.Label;

public class Ventana extends JFrame {

	private JPanel contentPane;
	private JButton btnIniciarJuego;
	private JButton[] arrayBotonesLetras;
	private JButton[] arrayPistas;
	private Label labelPalabra;
	private JButton btnResolver;
	private Button buttonVida1;
	private Button buttonVida2;
	private Button buttonVida3;
	private Button buttonVida4;
	private Button buttonVida5;

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

		btnResolver = new JButton("Resolver");
		btnResolver.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panelMenu.add(btnResolver);

		JPanel panelPalabra = new JPanel();
		panelPalabra.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2.add(panelPalabra);
		panelPalabra.setLayout(new GridLayout(0, 1, 0, 0));

		JPanel panelVidas = new JPanel();
		panelPalabra.add(panelVidas);
		panelVidas.setLayout(new GridLayout(1, 5, 0, 0));

		ponerBotonesPistas(panelVidas, 5);

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

	private void ponerBotonesPistas(JPanel panelVidas, int longitud) {
		arrayPistas = new JButton[longitud];
		for (int i = 0; i < arrayPistas.length; i++) {
			arrayPistas[i] = new JButton("Vida");
			panelVidas.add(arrayPistas[i]);

		}

	}

	private void rellenarBotonesLetras(JPanel panelTeclado) {
		arrayBotonesLetras = new JButton[27];
		// rellenar el array
		String letras = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ";
		for (int i = 0; i < letras.length(); i++) {
			arrayBotonesLetras[i] = new JButton(String.valueOf(letras.charAt(i)));// nombramos boton
			panelTeclado.add(arrayBotonesLetras[i]);
		}
	}

	public void habilitarBotones() {
		btnResolver.setEnabled(true);

		for (int i = 0; i < arrayBotonesLetras.length; i++) {
			arrayBotonesLetras[i].setEnabled(true);
		}
		for (int i = 0; i < arrayPistas.length; i++) {
			arrayPistas[i].setEnabled(true);
		}

	}

	public void deshabilitarBotones() {
		btnResolver.setEnabled(false);

		for (int i = 0; i < arrayBotonesLetras.length; i++) {
			arrayBotonesLetras[i].setEnabled(false);
		}

		for (int i = 0; i < arrayPistas.length; i++) {
			arrayPistas[i].setEnabled(false);
		}
	}

	public void ponerPalabraSecreta(int longitud) {
		String palabra = "";
		for (int i = 0; i < longitud; i++) {
			palabra += "* ";
		}

		labelPalabra.setText(palabra);
	}

	public boolean estasSeguro(String mensaje1, String mensaje2) {
		int returnOpcion = 0;
		boolean respuesta = false;
		returnOpcion = JOptionPane.showConfirmDialog(this, mensaje1, mensaje2, JOptionPane.YES_NO_OPTION);
		if (returnOpcion == JOptionPane.YES_OPTION) {
			respuesta = true;
		} else if (returnOpcion == JOptionPane.NO_OPTION) {
			respuesta = false;
		}
		return respuesta;
	}

	public JButton getBtnIniciarJuego() {
		return btnIniciarJuego;
	}

	public JButton[] getArrayBotonesLetras() {
		return arrayBotonesLetras;
	}

	public JButton getBtnResolver() {
		return btnResolver;
	}

	public Button getButtonVida1() {
		return buttonVida1;
	}

	public Button getButtonVida2() {
		return buttonVida2;
	}

	public Button getButtonVida3() {
		return buttonVida3;
	}

	public Button getButtonVida4() {
		return buttonVida4;
	}

	public Button getButtonVida5() {
		return buttonVida5;
	}

}
