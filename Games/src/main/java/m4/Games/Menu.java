package m4.Games;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;

public class Menu extends JFrame {

	private JPanel contentPane;
	private JButton btnAnadirPalabra;
	private JButton btnNuevoJuego;
	private JRadioButton rdbtnFacil;
	private JRadioButton rdbtnIntermedio;
	private JRadioButton rdbtnDificil;

	/**
	 * Create the frame.
	 */
	public Menu() {
		setTitle("Palabra Oculta");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		ButtonGroup buttonGroup = new ButtonGroup();
		
		rdbtnFacil = new JRadioButton("Fácil");
		rdbtnFacil.setSelected(true);
		rdbtnFacil.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtnFacil.setBounds(139, 58, 123, 34);
		buttonGroup.add(rdbtnFacil);
		contentPane.add(rdbtnFacil);
		
		rdbtnIntermedio = new JRadioButton("Intermedio");
		rdbtnIntermedio.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtnIntermedio.setBounds(139, 94, 123, 36);
		buttonGroup.add(rdbtnIntermedio);
		contentPane.add(rdbtnIntermedio);
		
		rdbtnDificil = new JRadioButton("Difícil");
		rdbtnDificil.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtnDificil.setBounds(139, 132, 123, 34);
		buttonGroup.add(rdbtnDificil);
		contentPane.add(rdbtnDificil);
		
		btnNuevoJuego = new JButton("Nuevo Juego");
		btnNuevoJuego.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNuevoJuego.setBounds(229, 193, 146, 48);
		contentPane.add(btnNuevoJuego);
		
		JLabel lblDificultad = new JLabel("Dificultad");
		lblDificultad.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDificultad.setBounds(30, 94, 103, 36);
		contentPane.add(lblDificultad);
		
		btnAnadirPalabra = new JButton("Añadir Palabra");
		btnAnadirPalabra.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnAnadirPalabra.setBounds(52, 193, 146, 48);
		contentPane.add(btnAnadirPalabra);
	}

	public JButton getBtnAnadirPalabra() {
		return btnAnadirPalabra;
	}

	public JButton getBtnNuevoJuego() {
		return btnNuevoJuego;
	}
	
	public int getDificultad() {
		
		if(rdbtnFacil.isSelected()) {
			return 1;
		}else if (rdbtnIntermedio.isSelected()) {
			return 2;
		}else{
			return 3;
		}
	}
}
