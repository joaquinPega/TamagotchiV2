package windowsView;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JLabel;

public class MainScreen extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainScreen frame = new MainScreen();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainScreen() {
		setTitle("Tamagotchi");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnCrearMascota = new JButton("Crear Mascota");
		btnCrearMascota.setBounds(23, 173, 103, 23);
		contentPane.add(btnCrearMascota);
		
		JButton btnCasamientos = new JButton("Casamientos");
		btnCasamientos.setBounds(156, 173, 103, 23);
		contentPane.add(btnCasamientos);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(67, 47, 180, 105);
		contentPane.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		scrollPane.setRowHeaderView(textArea);
		
		JLabel lblLblmascotas = new JLabel("Mascotas");
		lblLblmascotas.setBounds(67, 22, 168, 14);
		contentPane.add(lblLblmascotas);
		
		JButton btnSeleccionar = new JButton("Seleccionar");
		btnSeleccionar.setBounds(280, 47, 89, 23);
		contentPane.add(btnSeleccionar);
	}
}
