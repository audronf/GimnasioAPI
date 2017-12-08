package Pantallas;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;

import Controlador.ControladoraABM;
import Excepciones.ConnectionException;
import Excepciones.ProfesorException;

import javax.swing.border.BevelBorder;
import java.awt.Cursor;

public class AltaProfesorC {
	ControladoraABM co;
	JFrame frmAltaProfesorCompleto;
	private JTextField txtNombre;
	private JTextField textDNI;
	private JTextField textEmail;
	private JTextField textDomicilio;
	private JTextField textTelefono;
	private JTextField textSueldo;
	private JTextField textRetenciones;
	private JTextField textDeducciones;


	public AltaProfesorC(ControladoraABM c) {
		co=c;
		initialize();
	}


	private void initialize() {
		frmAltaProfesorCompleto = new JFrame();
		frmAltaProfesorCompleto.setTitle("Profesor Completo");
		frmAltaProfesorCompleto.setBounds(100, 100, 275, 344);
		frmAltaProfesorCompleto.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmAltaProfesorCompleto.getContentPane().setLayout(null);
		
		JLabel lblAlta = new JLabel("Alta");
		lblAlta.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAlta.setBounds(109, 11, 56, 20);
		frmAltaProfesorCompleto.getContentPane().add(lblAlta);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(10, 45, 46, 14);
		frmAltaProfesorCompleto.getContentPane().add(lblNombre);
		
		JLabel lblDni = new JLabel("D.N.I");
		lblDni.setBounds(10, 70, 46, 14);
		frmAltaProfesorCompleto.getContentPane().add(lblDni);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(10, 95, 46, 14);
		frmAltaProfesorCompleto.getContentPane().add(lblEmail);
		
		JLabel lblNewLabel = new JLabel("Domicilio");
		lblNewLabel.setBounds(10, 120, 60, 14);
		frmAltaProfesorCompleto.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Telefono");
		lblNewLabel_1.setBounds(10, 145, 60, 14);
		frmAltaProfesorCompleto.getContentPane().add(lblNewLabel_1);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(99, 42, 150, 20);
		frmAltaProfesorCompleto.getContentPane().add(txtNombre);
		txtNombre.setColumns(10);
		
		textDNI = new JTextField();
		textDNI.setBounds(99, 67, 150, 20);
		frmAltaProfesorCompleto.getContentPane().add(textDNI);
		textDNI.setColumns(10);
		
		textEmail = new JTextField();
		textEmail.setBounds(99, 92, 150, 20);
		frmAltaProfesorCompleto.getContentPane().add(textEmail);
		textEmail.setColumns(10);
		
		textDomicilio = new JTextField();
		textDomicilio.setBounds(99, 117, 150, 20);
		frmAltaProfesorCompleto.getContentPane().add(textDomicilio);
		textDomicilio.setColumns(10);
		
		textTelefono = new JTextField();
		textTelefono.setBounds(99, 142, 150, 20);
		frmAltaProfesorCompleto.getContentPane().add(textTelefono);
		textTelefono.setColumns(10);
		
		JLabel lblSueldo = new JLabel("Sueldo");
		lblSueldo.setBounds(10, 170, 89, 14);
		frmAltaProfesorCompleto.getContentPane().add(lblSueldo);
		
		textSueldo = new JTextField();
		textSueldo.setBounds(99, 167, 150, 20);
		frmAltaProfesorCompleto.getContentPane().add(textSueldo);
		textSueldo.setColumns(10);
		
		JButton button = new JButton("CANCELAR");
		button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button.setBorder(new CompoundBorder(new EtchedBorder(EtchedBorder.RAISED, null, null), new BevelBorder(BevelBorder.RAISED, null, null, null, null)));
		button.setBounds(10, 271, 89, 23);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmAltaProfesorCompleto.dispose();
			}
		});
		frmAltaProfesorCompleto.getContentPane().add(button);

		
		JButton btnAceptar = new JButton("ACEPTAR");
		btnAceptar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAceptar.setBorder(new CompoundBorder(new EtchedBorder(EtchedBorder.RAISED, null, null), new BevelBorder(BevelBorder.RAISED, null, null, null, null)));
		btnAceptar.setBounds(160, 271, 89, 23);
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					try {
						co.altaProfesorC(txtNombre.getText(), textDNI.getText(), textDomicilio.getText(),  textTelefono.getText(), textEmail.getText(), Float.parseFloat(textSueldo.getText()), Float.parseFloat(textRetenciones.getText()), Float.parseFloat(textDeducciones.getText()));
						txtNombre.setText("");
						textDNI.setText("");
						textEmail.setText("");
						textDomicilio.setText("");
						textTelefono.setText("");
						textSueldo.setText("");
						textDeducciones.setText("");
						textRetenciones.setText("");
					} catch (NumberFormatException | ProfesorException | ConnectionException e1) {	
						JOptionPane.showMessageDialog(null, e1.getMessage());
					}
					
			}	
	});
		frmAltaProfesorCompleto.getContentPane().add(btnAceptar);
		
		JLabel lblRetenciones = new JLabel("Retenciones");
		lblRetenciones.setBounds(10, 195, 89, 14);
		frmAltaProfesorCompleto.getContentPane().add(lblRetenciones);
		
		JLabel lblDeducciones = new JLabel("Deducciones");
		lblDeducciones.setBounds(10, 220, 89, 14);
		frmAltaProfesorCompleto.getContentPane().add(lblDeducciones);
		
		textRetenciones = new JTextField();
		textRetenciones.setColumns(10);
		textRetenciones.setBounds(99, 192, 150, 20);
		frmAltaProfesorCompleto.getContentPane().add(textRetenciones);
		
		textDeducciones = new JTextField();
		textDeducciones.setColumns(10);
		textDeducciones.setBounds(99, 217, 150, 20);
		frmAltaProfesorCompleto.getContentPane().add(textDeducciones);
	}
}