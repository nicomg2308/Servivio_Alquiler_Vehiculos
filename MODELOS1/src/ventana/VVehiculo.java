package ventana;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import com.toedter.calendar.JDateChooser;

import logica.Controlador;

public class VVehiculo extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtNodocumento;
	private JTextField txtMarca;
	private JTextField txtPlaca;
	private JTextField txtApellidos;
	private JButton btnAgregar;
	private JButton btnCancelar;
	private JComboBox comboBox;
	private JDateChooser dateChooser;
	private Controlador controlador;

	public VVehiculo(Controlador controlador) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 330, 520);
		this.controlador = controlador;
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panel.setBounds(10, 10, 294, 460);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblAgregarVehculo = new JLabel("Agregar Veh\u00EDculo");
		lblAgregarVehculo.setBounds(10, 11, 266, 31);
		lblAgregarVehculo.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 15));
		lblAgregarVehculo.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblAgregarVehculo);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(20, 53, 256, 133);
		panel_1.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Datos Propietario", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(64, 64, 64)));
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNombres = new JLabel("Nombres:");
		lblNombres.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNombres.setBounds(10, 61, 95, 20);
		panel_1.add(lblNombres);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(115, 61, 131, 20);
		panel_1.add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblNoDocumento = new JLabel("No. Documento:");
		lblNoDocumento.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNoDocumento.setBounds(10, 30, 95, 20);
		panel_1.add(lblNoDocumento);
		
		txtNodocumento = new JTextField();
		txtNodocumento.setBounds(115, 30, 131, 20);
		panel_1.add(txtNodocumento);
		txtNodocumento.setColumns(10);
		
		JLabel lblApellidos = new JLabel("Apellidos:");
		lblApellidos.setHorizontalAlignment(SwingConstants.RIGHT);
		lblApellidos.setBounds(10, 92, 95, 20);
		panel_1.add(lblApellidos);
		
		txtApellidos = new JTextField();
		txtApellidos.setBounds(115, 92, 131, 20);
		panel_1.add(txtApellidos);
		txtApellidos.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(20, 197, 256, 133);
		panel_2.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Datos Veh\u00EDculo", TitledBorder.CENTER, TitledBorder.TOP, null, Color.DARK_GRAY));
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblMarca = new JLabel("Marca:");
		lblMarca.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMarca.setBounds(10, 30, 100, 20);
		panel_2.add(lblMarca);
		
		txtMarca = new JTextField();
		txtMarca.setBounds(120, 30, 126, 20);
		panel_2.add(txtMarca);
		txtMarca.setColumns(10);
		
		JLabel lblPlaca = new JLabel("Placa:");
		lblPlaca.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPlaca.setBounds(10, 61, 100, 20);
		panel_2.add(lblPlaca);
		
		txtPlaca = new JTextField();
		txtPlaca.setBounds(120, 61, 126, 20);
		panel_2.add(txtPlaca);
		txtPlaca.setColumns(10);
		
		comboBox = new JComboBox();
		comboBox.setBackground(Color.WHITE);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Personal", "Oficina", "Turismo"}));
		comboBox.setBounds(120, 92, 126, 20);
		panel_2.add(comboBox);
		
		JLabel lblTipoDeVehculo = new JLabel("Tipo de Veh\u00EDculo:");
		lblTipoDeVehculo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTipoDeVehculo.setBounds(10, 92, 100, 20);
		panel_2.add(lblTipoDeVehculo);
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnAgregar.setBackground(Color.LIGHT_GRAY);
		btnAgregar.setBounds(43, 426, 89, 23);
		btnAgregar.addActionListener(this);
		panel.add(btnAgregar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnCancelar.setBackground(Color.LIGHT_GRAY);
		btnCancelar.setBounds(159, 426, 89, 23);
		btnCancelar.addActionListener(this);
		panel.add(btnCancelar);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Datos Ingreso", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(64, 64, 64)));
		panel_3.setBounds(20, 341, 256, 73);
		panel.add(panel_3);
		
		JLabel lblFechaIngreso = new JLabel("Fecha Ingreso:");
		lblFechaIngreso.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFechaIngreso.setBounds(10, 30, 100, 20);
		panel_3.add(lblFechaIngreso);
		
		dateChooser = new JDateChooser();
		dateChooser.setBounds(120, 30, 126, 20);
		panel_3.add(dateChooser);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(btnAgregar)) {
			controlador.addVehiculo(comboBox.getSelectedIndex(), txtMarca.getText(), txtPlaca.getText(), Long.parseLong(txtNodocumento.getText()), txtNombre.getText(), txtApellidos.getText(), dateChooser.getDate().toString());
			JOptionPane.showMessageDialog(null, "El vehículo ha ingresado de forma exitosa :v");
			dispose();
			Interfaz interfaz = new Interfaz(controlador);
			interfaz.setVisible(true);
		} else if (e.getSource().equals(btnCancelar)){
			dispose();
			Interfaz interfaz = new Interfaz(controlador);
			interfaz.setVisible(true);
		}
	}
}
