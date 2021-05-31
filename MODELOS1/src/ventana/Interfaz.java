package ventana;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.border.LineBorder;

import logica.Controlador;

public class Interfaz extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btnAddVehiculo;
	private JButton btnDatos;
	private JButton btnAddService;
	private Controlador controlador;

	public Interfaz(Controlador controlador) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 185, 216);
		this.controlador = controlador;
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new LineBorder(Color.DARK_GRAY, 1, true));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBorder(new LineBorder(Color.DARK_GRAY, 1, true));
		panel.setBounds(10, 10, 151, 156);
		contentPane.add(panel);
		panel.setLayout(null);

		btnAddService = new JButton("Solicitar Servicio");
		btnAddService.setBackground(Color.LIGHT_GRAY);
		btnAddService.setBorder(new LineBorder(Color.BLACK, 1, true));
		btnAddService.setForeground(Color.BLACK);
		btnAddService.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 10));
		btnAddService.setBounds(10, 54, 128, 23);
		btnAddService.addActionListener(this);
		panel.add(btnAddService);

		btnAddVehiculo = new JButton("Agregar Veh\u00EDculo");
		btnAddVehiculo.setBackground(Color.LIGHT_GRAY);
		btnAddVehiculo.setBorder(new LineBorder(Color.BLACK, 1, true));
		btnAddVehiculo.setForeground(Color.BLACK);
		btnAddVehiculo.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 10));
		btnAddVehiculo.setBounds(10, 88, 128, 23);
		btnAddVehiculo.addActionListener(this);
		panel.add(btnAddVehiculo);

		JLabel lblTitulo = new JLabel("Muerto\u00F1o S.A.S");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Lucida Calligraphy", Font.PLAIN, 14));
		lblTitulo.setBounds(10, 11, 128, 26);
		panel.add(lblTitulo);

		btnDatos = new JButton("Ver Datos");
		btnDatos.setForeground(Color.BLACK);
		btnDatos.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 10));
		btnDatos.setBorder(new LineBorder(Color.BLACK, 1, true));
		btnDatos.setBackground(Color.LIGHT_GRAY);
		btnDatos.setBounds(10, 122, 128, 23);
		btnDatos.addActionListener(this);
		panel.add(btnDatos);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JFrame ventana = null;
		;
		if (e.getSource().equals(btnDatos)) {
			ventana = new VDatos(controlador);
		} else if (e.getSource().equals(btnAddService)) {
			ventana = new VServicio(controlador);
		} else if (e.getSource().equals(btnAddVehiculo)) {
			ventana = new VVehiculo(controlador);
		}
		ventana.setVisible(true);
		dispose();
	}

}
