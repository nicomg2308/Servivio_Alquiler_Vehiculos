package ventana;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import com.toedter.calendar.JDateChooser;

import logica.Controlador;

import javax.swing.JButton;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.DefaultComboBoxModel;

public class VServicio extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField txtNodocumento;
	private JTextField txtOrigen;
	private JTextField txtDestino;
	private JButton btnCancelar;
	private JButton btnPedirServicio;
	private JComboBox comboBox;
	private JDateChooser dateChooser;

	private Controlador controlador;

	/**
	 * Create the frame.
	 */
	public VServicio(Controlador controlador) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 320, 300);
		this.controlador = controlador;
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 1, true), "Servicio", TitledBorder.CENTER,
				TitledBorder.TOP, null, new Color(64, 64, 64)));
		panel.setBounds(10, 11, 284, 239);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNoDocumento = new JLabel("No. Documento:");
		lblNoDocumento.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNoDocumento.setBounds(10, 21, 110, 24);
		panel.add(lblNoDocumento);

		JLabel lblFechaSolicitud = new JLabel("Fecha Solicitud:");
		lblFechaSolicitud.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFechaSolicitud.setBounds(10, 56, 110, 24);
		panel.add(lblFechaSolicitud);

		JLabel lblTipoServicio = new JLabel("Tipo Servicio:");
		lblTipoServicio.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTipoServicio.setBounds(10, 91, 110, 24);
		panel.add(lblTipoServicio);

		JLabel lblDireccionOrigen = new JLabel("Direccion Origen:");
		lblDireccionOrigen.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDireccionOrigen.setBounds(10, 126, 110, 24);
		panel.add(lblDireccionOrigen);

		JLabel lblDireccinDestino = new JLabel("Direcci\u00F3n Destino:");
		lblDireccinDestino.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDireccinDestino.setBounds(10, 161, 110, 24);
		panel.add(lblDireccinDestino);

		txtNodocumento = new JTextField();
		txtNodocumento.setBounds(130, 21, 124, 24);
		panel.add(txtNodocumento);
		txtNodocumento.setColumns(10);

		txtOrigen = new JTextField();
		txtOrigen.setColumns(10);
		txtOrigen.setBounds(130, 126, 124, 24);
		panel.add(txtOrigen);

		txtDestino = new JTextField();
		txtDestino.setColumns(10);
		txtDestino.setBounds(130, 161, 124, 24);
		panel.add(txtDestino);

		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "Personal", "Oficina", "Turismo" }));
		comboBox.setBorder(new LineBorder(new Color(171, 173, 179)));
		comboBox.setBackground(Color.WHITE);
		comboBox.setBounds(130, 91, 124, 24);
		panel.add(comboBox);

		dateChooser = new JDateChooser();
		dateChooser.setBounds(130, 56, 124, 24);
		panel.add(dateChooser);

		btnPedirServicio = new JButton("Pedir Servicio");
		btnPedirServicio.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnPedirServicio.setBackground(Color.LIGHT_GRAY);
		btnPedirServicio.setBounds(20, 205, 117, 23);
		btnPedirServicio.addActionListener(this);
		panel.add(btnPedirServicio);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnCancelar.setBackground(Color.LIGHT_GRAY);
		btnCancelar.setBounds(147, 205, 102, 23);
		btnCancelar.addActionListener(this);
		panel.add(btnCancelar);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(btnPedirServicio)) {
			controlador.registros.addServicio(Long.parseLong(txtNodocumento.getText()),
					controlador.getVehiculo(comboBox.getSelectedIndex()), dateChooser.getDate().toString(),
					txtOrigen.getText(), txtDestino.getText());
			JOptionPane.showMessageDialog(null, "El servicio se ha pedido de forma exitosa :D");
			dispose();
			Interfaz interfaz = new Interfaz(controlador);
			interfaz.setVisible(true);
		} else if (e.getSource().equals(btnCancelar)) {
			dispose();
			Interfaz interfaz = new Interfaz(controlador);
			interfaz.setVisible(true);
		}
	}
}
