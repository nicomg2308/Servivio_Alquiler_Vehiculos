package ventana;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import logica.Controlador;
import logica.Servicios;
import logica.Vehiculo;

public class VDatos extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTable table;
	private JTable table_1;
	private JButton btnCancelar;
	private Controlador controlador;

	public VDatos(Controlador controlador) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 677, 359);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		this.controlador = controlador;

		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(10, 10, 491, 299);
		contentPane.add(panel);
		panel.setLayout(null);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 11, 471, 226);
		panel.add(tabbedPane);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2.setBackground(Color.WHITE);
		tabbedPane.addTab("Servicios", null, panel_2, null);
		panel_2.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 446, 176);
		panel_2.add(scrollPane);

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Identificacion", "Fecha Solicitud",
				"Tipo Servicio", "Direccion Origen", "Direccion Destino" }));
		table.getColumnModel().getColumn(0).setPreferredWidth(92);
		table.getColumnModel().getColumn(1).setPreferredWidth(112);
		table.getColumnModel().getColumn(3).setPreferredWidth(133);
		table.getColumnModel().getColumn(4).setPreferredWidth(137);
		crearTabla(table, controlador.registros);

		scrollPane.setViewportView(table);

		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_3.setBackground(Color.WHITE);
		tabbedPane.addTab("Vehiculos", null, panel_3, null);
		panel_3.setLayout(null);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 11, 446, 176);
		panel_3.add(scrollPane_1);

		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Fecha Ingreso", "Propietario", "Documento", "Marca", "Placa", "Tipo Vehiculo" }));
		table_1.getColumnModel().getColumn(1).setPreferredWidth(84);
		crearTabla(table_1, controlador.vehiculos);
		scrollPane_1.setViewportView(table_1);

		JLabel label_1 = new JLabel(Long.toString(controlador.getSaldoCompleto()));
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		label_1.setBounds(345, 248, 136, 40);
		panel.add(label_1);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.LIGHT_GRAY);
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(511, 10, 140, 299);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnCancelar.setBackground(Color.LIGHT_GRAY);
		btnCancelar.setBounds(10, 265, 94, 23);
		btnCancelar.addActionListener(this);
		panel_1.add(btnCancelar);

		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_4.setBackground(Color.WHITE);
		panel_4.setBounds(10, 11, 120, 105);
		panel_1.add(panel_4);
		panel_4.setLayout(null);

		JLabel lblClienteFrecuente = new JLabel("Cliente Frecuente");
		lblClienteFrecuente.setHorizontalAlignment(SwingConstants.CENTER);
		lblClienteFrecuente.setBounds(10, 11, 100, 14);
		panel_4.add(lblClienteFrecuente);

		JLabel label = new JLabel(Long.toString(controlador.getMasFrecuente()));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label.setBounds(10, 50, 100, 24);
		panel_4.add(label);

		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_5.setBackground(Color.WHITE);
		panel_5.setBounds(10, 127, 120, 105);
		panel_1.add(panel_5);
		panel_5.setLayout(null);

		JLabel lblServicioMenos = new JLabel("Servicio Menos");
		lblServicioMenos.setHorizontalAlignment(SwingConstants.CENTER);
		lblServicioMenos.setBounds(10, 11, 100, 14);
		panel_5.add(lblServicioMenos);

		JLabel lblFrecuente = new JLabel("Frecuente");
		lblFrecuente.setHorizontalAlignment(SwingConstants.CENTER);
		lblFrecuente.setBounds(10, 26, 100, 14);
		panel_5.add(lblFrecuente);

		JLabel lblNewLabel = new JLabel(controlador.getServicioMenos());
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 63, 100, 31);
		panel_5.add(lblNewLabel);
	}

	void crearTabla(JTable tabla, Servicios servicio) {
		for (int i = 0; i < servicio.tamano(); i++) {
			for (int j = 0; j < Servicios.getServicio(i).direccionOrigen.size(); j++) {
				Object fila[] = new Object[5];
				fila[0] = Servicios.getServicio(i).getDocumentoIdentidad();
				fila[1] = Servicios.getServicio(i).fecha.get(j);
				fila[2] = Servicios.getServicio(i).tipoServicio.get(j);
				fila[3] = Servicios.getServicio(i).direccionOrigen.get(j);
				fila[4] = Servicios.getServicio(i).direccionDestino.get(j);
				((DefaultTableModel) tabla.getModel()).addRow(fila);
			}

		}
	}

	void crearTabla(JTable tabla, ArrayList<Vehiculo> vehiculo) {
		for (int i = 0; i < vehiculo.size(); i++) {
			Object fila[] = new Object[6];
			fila[0] = vehiculo.get(i).getIngreso().getId();
			fila[1] = vehiculo.get(i).getDueno().getNombreCompleto();
			fila[2] = vehiculo.get(i).getDueno().getDocumentoIdentidad();
			fila[3] = vehiculo.get(i).getMarca();
			fila[4] = vehiculo.get(i).getPlaca();
			fila[5] = vehiculo.get(i).getTipoVehiculo();
			((DefaultTableModel) tabla.getModel()).addRow(fila);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(btnCancelar)) {
			dispose();
			Interfaz ventana = new Interfaz(controlador);
			ventana.setVisible(true);
		}
	}
}
