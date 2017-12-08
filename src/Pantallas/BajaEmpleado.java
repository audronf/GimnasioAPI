package Pantallas;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;

import Clases.EmpleadoView;
import Controlador.ControladoraABM;
import Excepciones.ConnectionException;
import Excepciones.EmpleadoException;
import javax.swing.border.BevelBorder;
import java.awt.Cursor;

public class BajaEmpleado {

	JFrame frmBajaEmpleado;
	EmpleadoView v;
	ControladoraABM co;
	private JTextField txtInserteDniA;
	private JTextField textNombre;
	private JTextField textEmail;
	private JTextField textDomicilio;
	private JTextField textTelefono;
	private JTextField textPuesto;
	private JTextField textSueldo;
	private JTextField textRetenciones;
	private JTextField textDeducciones;

	public BajaEmpleado(ControladoraABM c) {
		co=c;
		initialize();
	}

	private void initialize() {
		frmBajaEmpleado = new JFrame();
		frmBajaEmpleado.setTitle("Empleado");
		frmBajaEmpleado.setBounds(100, 100, 388, 366);
		frmBajaEmpleado.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmBajaEmpleado.getContentPane().setLayout(null);
		
		JLabel lblBaja = new JLabel("Baja");
		lblBaja.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblBaja.setBounds(130, 13, 46, 27);
		frmBajaEmpleado.getContentPane().add(lblBaja);
		
		JLabel lblDni = new JLabel("D.N.I");
		lblDni.setBounds(10, 54, 46, 14);
		frmBajaEmpleado.getContentPane().add(lblDni);
		
		txtInserteDniA = new JTextField();
		txtInserteDniA.setText("Inserte D.N.I a buscar");
		txtInserteDniA.setBounds(66, 51, 197, 20);
		frmBajaEmpleado.getContentPane().add(txtInserteDniA);
		txtInserteDniA.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				txtInserteDniA.setText("");
			}
		});
		txtInserteDniA.setColumns(10);
		
		JButton btnBuscar = new JButton("BUSCAR");
		btnBuscar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnBuscar.setBorder(new CompoundBorder(new EtchedBorder(EtchedBorder.RAISED, null, null), new BevelBorder(BevelBorder.RAISED, null, null, null, null)));
		btnBuscar.setBounds(273, 50, 89, 23);
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					 v = co.devolverEmpleado(txtInserteDniA.getText());
					 textNombre.setText(v.getNombre());
					 textEmail.setText(v.getMail());
					 textDomicilio.setText(v.getDomicilio());
					 textTelefono.setText(v.getTelefono());
					 textSueldo.setText(Double.toString(v.getSueldo()));
					 textPuesto.setText(v.getPuesto());
					 textDeducciones.setText(Double.toString(v.getDeducciones()));
					 textRetenciones.setText(Double.toString(v.getRetenciones()));
					 
				} catch (EmpleadoException | ConnectionException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
			}
		});
		frmBajaEmpleado.getContentPane().add(btnBuscar);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(10, 79, 46, 14);
		frmBajaEmpleado.getContentPane().add(lblNombre);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(10, 104, 46, 14);
		frmBajaEmpleado.getContentPane().add(lblEmail);
		
		JLabel lblDomicilio = new JLabel("Domicilio");
		lblDomicilio.setBounds(10, 129, 60, 14);
		frmBajaEmpleado.getContentPane().add(lblDomicilio);
		
		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setBounds(10, 154, 60, 14);
		frmBajaEmpleado.getContentPane().add(lblTelefono);
		
		textNombre = new JTextField();
		textNombre.setEditable(false);
		textNombre.setEnabled(false);
		textNombre.setBounds(66, 76, 197, 20);
		frmBajaEmpleado.getContentPane().add(textNombre);
		textNombre.setColumns(10);
		
		textEmail = new JTextField();
		textEmail.setEditable(false);
		textEmail.setEnabled(false);
		textEmail.setBounds(66, 101, 197, 20);
		frmBajaEmpleado.getContentPane().add(textEmail);
		textEmail.setColumns(10);
		
		textDomicilio = new JTextField();
		textDomicilio.setEditable(false);
		textDomicilio.setEnabled(false);
		textDomicilio.setBounds(66, 126, 197, 20);
		frmBajaEmpleado.getContentPane().add(textDomicilio);
		textDomicilio.setColumns(10);
		
		textTelefono = new JTextField();
		textTelefono.setEditable(false);
		textTelefono.setEnabled(false);
		textTelefono.setBounds(66, 151, 197, 20);
		frmBajaEmpleado.getContentPane().add(textTelefono);
		textTelefono.setColumns(10);
		
		JButton btnAceptar = new JButton("ACEPTAR");
		btnAceptar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAceptar.setBorder(new CompoundBorder(new EtchedBorder(EtchedBorder.RAISED, null, null), new BevelBorder(BevelBorder.RAISED, null, null, null, null)));
		btnAceptar.setBounds(174, 293, 89, 23);
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					 co.bajaLogicaEmpleado(txtInserteDniA.getText());
					 txtInserteDniA.setText("");
					 textNombre.setText("");
					 textEmail.setText("");
					 textDomicilio.setText("");
					 textTelefono.setText("");
					 textRetenciones.setText("");
					 textDeducciones.setText("");
					 textPuesto.setText("");
					 textSueldo.setText("");
					 
				} catch (EmpleadoException | ConnectionException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
			}
		});
		frmBajaEmpleado.getContentPane().add(btnAceptar);
		
		JButton btnCancelar = new JButton("CANCELAR");
		btnCancelar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCancelar.setBorder(new CompoundBorder(new EtchedBorder(EtchedBorder.RAISED, null, null), new BevelBorder(BevelBorder.RAISED, null, null, null, null)));
		btnCancelar.setBounds(10, 293, 89, 23);
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmBajaEmpleado.dispose();
			}
		});
		frmBajaEmpleado.getContentPane().add(btnCancelar);
		
		JLabel lblPuesto = new JLabel("Puesto");
		lblPuesto.setBounds(10, 179, 46, 14);
		frmBajaEmpleado.getContentPane().add(lblPuesto);
		
		JLabel lblSueldo = new JLabel("Sueldo");
		lblSueldo.setBounds(10, 204, 46, 14);
		frmBajaEmpleado.getContentPane().add(lblSueldo);
		
		textPuesto = new JTextField();
		textPuesto.setEnabled(false);
		textPuesto.setEditable(false);
		textPuesto.setBounds(66, 176, 197, 20);
		frmBajaEmpleado.getContentPane().add(textPuesto);
		textPuesto.setColumns(10);
		
		textSueldo = new JTextField();
		textSueldo.setEnabled(false);
		textSueldo.setEditable(false);
		textSueldo.setBounds(66, 201, 197, 20);
		frmBajaEmpleado.getContentPane().add(textSueldo);
		textSueldo.setColumns(10);
		
		JLabel lblRetenciones = new JLabel("Retenciones");
		lblRetenciones.setBounds(10, 229, 89, 14);
		frmBajaEmpleado.getContentPane().add(lblRetenciones);
		
		JLabel lblDeducciones = new JLabel("Deducciones");
		lblDeducciones.setBounds(10, 254, 89, 14);
		frmBajaEmpleado.getContentPane().add(lblDeducciones);
		
		textRetenciones = new JTextField();
		textRetenciones.setEnabled(false);
		textRetenciones.setEditable(false);
		textRetenciones.setColumns(10);
		textRetenciones.setBounds(109, 226, 154, 20);
		frmBajaEmpleado.getContentPane().add(textRetenciones);
		
		textDeducciones = new JTextField();
		textDeducciones.setEnabled(false);
		textDeducciones.setEditable(false);
		textDeducciones.setColumns(10);
		textDeducciones.setBounds(109, 251, 154, 20);
		frmBajaEmpleado.getContentPane().add(textDeducciones);
	}

}