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

public class ModificarEmpleado {

	JFrame frmModificacionEmpleado;
	ControladoraABM co;
	EmpleadoView v;
	private JTextField txtInserteDniA;
	private JTextField textNombre;
	private JTextField textEmail;
	private JTextField textDomicilio;
	private JTextField textTelefono;
	private JTextField textPuesto;
	private JTextField textSueldo;
	private JTextField textRetenciones;
	private JTextField textDeducciones;


	public ModificarEmpleado(ControladoraABM c) {
		co=c;
		initialize();
	}


	private void initialize() {
		frmModificacionEmpleado = new JFrame();
		frmModificacionEmpleado.setTitle("Empleado");
		frmModificacionEmpleado.setBounds(100, 100, 388, 371);
		frmModificacionEmpleado.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmModificacionEmpleado.getContentPane().setLayout(null);
		
		JLabel lblBaja = new JLabel("Modificaci\u00F3n");
		lblBaja.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblBaja.setBounds(110, 13, 150, 27);
		frmModificacionEmpleado.getContentPane().add(lblBaja);
		
		JLabel lblDni = new JLabel("D.N.I");
		lblDni.setBounds(10, 54, 46, 14);
		frmModificacionEmpleado.getContentPane().add(lblDni);
		
		txtInserteDniA = new JTextField();
		txtInserteDniA.setText("Inserte D.N.I a buscar");
		txtInserteDniA.setBounds(66, 51, 197, 20);
		frmModificacionEmpleado.getContentPane().add(txtInserteDniA);
		txtInserteDniA.setColumns(10);
		txtInserteDniA.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				txtInserteDniA.setText("");
			}
		});
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
					 textRetenciones.setText(Double.toString(v.getRetenciones()));
                     textDeducciones.setText(Double.toString(v.getDeducciones()));
					 textNombre.setEnabled(true);
					 textEmail.setEnabled(true);
					 textDomicilio.setEnabled(true);
					 textTelefono.setEnabled(true);
					 textSueldo.setEnabled(true);
					 textPuesto.setEnabled(true);
					 textNombre.setEditable(true);
					 textEmail.setEditable(true);
					 textDomicilio.setEditable(true);
					 textTelefono.setEditable(true);
					 textPuesto.setEditable(true);
					 textSueldo.setEditable(true);
					 txtInserteDniA.setEnabled(false);
					 textRetenciones.setEnabled(true);
					 textDeducciones.setEnabled(true);
					 textRetenciones.setEditable(true);
					 textDeducciones.setEditable(true);
				} catch (EmpleadoException | ConnectionException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
			}
		});
		frmModificacionEmpleado.getContentPane().add(btnBuscar);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(10, 79, 46, 14);
		frmModificacionEmpleado.getContentPane().add(lblNombre);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(10, 104, 46, 14);
		frmModificacionEmpleado.getContentPane().add(lblEmail);
		
		JLabel lblDomicilio = new JLabel("Domicilio");
		lblDomicilio.setBounds(10, 129, 60, 14);
		frmModificacionEmpleado.getContentPane().add(lblDomicilio);
		
		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setBounds(10, 154, 60, 14);
		frmModificacionEmpleado.getContentPane().add(lblTelefono);
		
		textNombre = new JTextField();
		textNombre.setEditable(false);
		textNombre.setEnabled(false);
		textNombre.setBounds(66, 76, 197, 20);
		frmModificacionEmpleado.getContentPane().add(textNombre);
		textNombre.setColumns(10);
		
		textEmail = new JTextField();
		textEmail.setEditable(false);
		textEmail.setEnabled(false);
		textEmail.setBounds(66, 101, 197, 20);
		frmModificacionEmpleado.getContentPane().add(textEmail);
		textEmail.setColumns(10);
		
		textDomicilio = new JTextField();
		textDomicilio.setEditable(false);
		textDomicilio.setEnabled(false);
		textDomicilio.setBounds(66, 126, 197, 20);
		frmModificacionEmpleado.getContentPane().add(textDomicilio);
		textDomicilio.setColumns(10);
		
		textTelefono = new JTextField();
		textTelefono.setEditable(false);
		textTelefono.setEnabled(false);
		textTelefono.setBounds(66, 151, 197, 20);
		frmModificacionEmpleado.getContentPane().add(textTelefono);
		textTelefono.setColumns(10);
		
		JButton btnAceptar = new JButton("ACEPTAR");
		btnAceptar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAceptar.setBorder(new CompoundBorder(new EtchedBorder(EtchedBorder.RAISED, null, null), new BevelBorder(BevelBorder.RAISED, null, null, null, null)));
		btnAceptar.setBounds(174, 298, 89, 23);
		btnAceptar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAceptar.setBorder(new CompoundBorder(new EtchedBorder(EtchedBorder.RAISED, null, null), new BevelBorder(BevelBorder.RAISED, null, null, null, null)));
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					co.modificarEmpleado(txtInserteDniA.getText(), textNombre.getText(), textEmail.getText(), textDomicilio.getText(), textEmail.getText(), textPuesto.getText(),Double.parseDouble(textSueldo.getText()),Double.parseDouble(textRetenciones.getText()),Double.parseDouble(textDeducciones.getText()));
					txtInserteDniA.setText("Inserte D.N.I a buscar");
					txtInserteDniA.setEnabled(true);
					textNombre.setEnabled(false);
					textDomicilio.setEnabled(false);
					textEmail.setEnabled(false);
					textTelefono.setEnabled(false);
					textNombre.setText("");
					textDomicilio.setText("");
					textEmail.setText("");
					textTelefono.setText("");
					textPuesto.setText("");
					textSueldo.setText("");
					textRetenciones.setText("");
					textDeducciones.setText("");
				}catch(EmpleadoException | NumberFormatException | ConnectionException e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
			}
		});
		frmModificacionEmpleado.getContentPane().add(btnAceptar);
		
		JButton btnCancelar = new JButton("CANCELAR");
		btnCancelar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCancelar.setBorder(new CompoundBorder(new EtchedBorder(EtchedBorder.RAISED, null, null), new BevelBorder(BevelBorder.RAISED, null, null, null, null)));
		btnCancelar.setBounds(10, 298, 89, 23);
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmModificacionEmpleado.dispose();
			}
		});
		frmModificacionEmpleado.getContentPane().add(btnCancelar);
		
		JLabel lblPuesto = new JLabel("Puesto");
		lblPuesto.setBounds(10, 179, 46, 14);
		frmModificacionEmpleado.getContentPane().add(lblPuesto);
		
		JLabel lblSueldo = new JLabel("Sueldo");
		lblSueldo.setBounds(10, 204, 46, 14);
		frmModificacionEmpleado.getContentPane().add(lblSueldo);
		
		textPuesto = new JTextField();
		textPuesto.setEnabled(false);
		textPuesto.setEditable(false);
		textPuesto.setBounds(66, 176, 197, 20);
		frmModificacionEmpleado.getContentPane().add(textPuesto);
		textPuesto.setColumns(10);
		
		textSueldo = new JTextField();
		textSueldo.setEnabled(false);
		textSueldo.setEditable(false);
		textSueldo.setBounds(66, 201, 197, 20);
		frmModificacionEmpleado.getContentPane().add(textSueldo);
		textSueldo.setColumns(10);
		
		JLabel lblRetenciones = new JLabel("Retenciones");
		lblRetenciones.setBounds(10, 229, 150, 14);
		frmModificacionEmpleado.getContentPane().add(lblRetenciones);
		
		JLabel lblDeducciones = new JLabel("Deducciones");
		lblDeducciones.setBounds(10, 254, 150, 14);
		frmModificacionEmpleado.getContentPane().add(lblDeducciones);
		
		textRetenciones = new JTextField();
		textRetenciones.setEnabled(false);
		textRetenciones.setEditable(false);
		textRetenciones.setColumns(10);
		textRetenciones.setBounds(98, 226, 165, 20);
		frmModificacionEmpleado.getContentPane().add(textRetenciones);
		
		textDeducciones = new JTextField();
		textDeducciones.setEnabled(false);
		textDeducciones.setEditable(false);
		textDeducciones.setColumns(10);
		textDeducciones.setBounds(98, 251, 165, 20);
		frmModificacionEmpleado.getContentPane().add(textDeducciones);
	}
}