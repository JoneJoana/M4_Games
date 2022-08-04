package m4.Games;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.border.LineBorder;
import java.awt.Button;
import java.awt.Label;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;

import javax.swing.JLabel;

public class Ventana extends JFrame {

	private JPanel contentPane;
	private JButton btnIniciarJuego;
	private JButton[] arrayBotonesLetras;
	private Label labelPalabra;
	private JButton btnResolver;
	private Button buttonVida1;
	private Button buttonVida2;
	private Button buttonVida3;
	private Button buttonVida4;
	private Button buttonVida5;
	private JLabel lblDibujo;

	/**
	 * Create the frame.
	 */
	public Ventana() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 651, 510);
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

		buttonVida1 = new Button("Vida");
		panelVidas.add(buttonVida1);

		buttonVida2 = new Button("Vida");
		panelVidas.add(buttonVida2);

		buttonVida3 = new Button("Vida");
		panelVidas.add(buttonVida3);

		buttonVida4 = new Button("Vida");
		panelVidas.add(buttonVida4);

		buttonVida5 = new Button("Vida");
		panelVidas.add(buttonVida5);

		JPanel panelPalabraSecreta = new JPanel();
		panelPalabra.add(panelPalabraSecreta);
		panelPalabraSecreta.setLayout(new GridLayout(0, 1, 0, 0));

		JPanel panelPalabraSecretaInterior = new JPanel();
		panelPalabraSecretaInterior.setBorder(
				new TitledBorder(null, "Palabra secreta", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelPalabraSecreta.add(panelPalabraSecretaInterior);
		panelPalabraSecretaInterior.setLayout(new GridLayout(1, 0, 0, 0));

		labelPalabra = new Label("Palabra secreta");
		panelPalabraSecretaInterior.add(labelPalabra);

		JPanel panelTeclado = new JPanel();
		panelTeclado.setBorder(new TitledBorder(null, "Teclado", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.add(panelTeclado);
		panelTeclado.setLayout(new GridLayout(6, 5, 0, 0));

		rellenarBotonesLetras(panelTeclado);

		JPanel panelDibujo = new JPanel();
		panelDibujo.setBorder(new LineBorder(new Color(0, 0, 0)));
		contentPane.add(panelDibujo);
		
		lblDibujo = new JLabel("");
		panelDibujo.add(lblDibujo);

	}

	private void rellenarBotonesLetras(JPanel panelTeclado) {
		arrayBotonesLetras = new JButton[27];
		// rellenar el array
		String letras = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ";
		for (int i = 0; i < letras.length(); i++) {
			arrayBotonesLetras[i] = new JButton(String.valueOf(letras.charAt(i)));// nombramos boton
			arrayBotonesLetras[i].setEnabled(false);// dejamos dehabilitados
			panelTeclado.add(arrayBotonesLetras[i]);
		}
	}

	public void habilitarBotones() {
		for (int i = 0; i < arrayBotonesLetras.length; i++) {
			arrayBotonesLetras[i].setEnabled(true);
		}
	}

	public void deshabilitarBotones() {
		for (int i = 0; i < arrayBotonesLetras.length; i++) {
			arrayBotonesLetras[i].setEnabled(false);
		}
	}

	public void ponerPalabraSecreta(int longitud) {
		String palabra = "";
		for (int i = 0; i < longitud; i++) {
			palabra += "* ";
		}

		labelPalabra.setText(palabra);
	}
	
	public void cambiarImagen(int numImagen) {
		try {
			String direccion = "res/ahorcado1.png";
			switch(numImagen) {
			case 0:
				direccion = "res/ahorcado0.png";
				break;
			case 1:
				direccion = "res/ahorcado1.png";
				break;
			case 2:
				direccion = "res/ahorcado2.png";
				break;
			case 3:
				direccion = "res/ahorcado3.png";
				break;
			case 4:
				direccion = "res/ahorcado4.png";
				break;
			case 5:
				direccion = "res/ahorcado5.png";
				break;
			case 6:
				direccion = "res/ahorcado6.png";
				break;
			case 7:
				direccion = "res/ahorcado7.png";
				break;
			case 8:
				direccion = "res/ahorcado8.png";
				break;
			case 9:
				direccion = "res/ahorcado9.png";
				break;
			case 10:
				direccion = "res/ahorcado10.png";
				break;
			}
			
			BufferedImage imagen = ImageIO.read(new FileInputStream(direccion));
			lblDibujo.setIcon(new ImageIcon(imagen));
		} catch (IOException e) {
			e.printStackTrace();
		}
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
