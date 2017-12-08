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

public class AltaProfesorP {
	ControladoraABM co;
	JFrame frmAltaProfesorParticular;
	private JTextField txtNombre;
	private JTextField textDNI;
	private JTextField textEmail;
	private JTextField textDomicilio;
	private JTextField textTelefono;
	private JTextField textPrecioHora;


	public AltaProfesorP(ControladoraABM c) {
		co=c;
		initialize();
	}


	private void initialize() {
		frmAltaProfesorParticular = new JFrame();
		frmAltaProfesorParticular.setTitle("Profesor Particular");
		frmAltaProfesorParticular.setBounds(100, 100, 275, 274);
		frmAltaProfesorParticular.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmAltaProfesorParticular.getContentPane().setLayout(null);
		
		JLabel lblAlta = new JLabel("Alta");
		lblAlta.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAlta.setBounds(109, 11, 56, 20);
		frmAltaProfesorParticular.getContentPane().add(lblAlta);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(10, 45, 46, 14);
		frmAltaProfesorParticular.getContentPane().add(lblNombre);
		
		JLabel lblDni = new JLabel("D.N.I");
		lblDni.setBounds(10, 70, 46, 14);
		frmAltaProfesorParticular.getContentPane().add(lblDni);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(10, 95, 46, 14);
		frmAltaProfesorParticular.getContentPane().add(lblEmail);
		
		JLabel lblNewLabel = new JLabel("Domicilio");
		lblNewLabel.setBounds(10, 120, 60, 14);
		frmAltaProfesorParticular.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Telefono");
		lblNewLabel_1.setBounds(10, 145, 60, 14);
		frmAltaProfesorParticular.getContentPane().add(lblNewLabel_1);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(99, 42, 150, 20);
		frmAltaProfesorParticular.getContentPane().add(txtNombre);
		txtNombre.setColumns(10);
		
		textDNI = new JTextField();
		textDNI.setBounds(99, 67, 150, 20);
		frmAltaProfesorParticular.getContentPane().add(textDNI);
		textDNI.setColumns(10);
		
		textEmail = new JTextField();
		textEmail.setBounds(99, 92, 150, 20);
		frmAltaProfesorParticular.getContentPane().add(textEmail);
		textEmail.setColumns(10);
		
		textDomicilio = new JTextField();
		textDomicilio.setBounds(99, 117, 150, 20);
		frmAltaProfesorParticular.getContentPane().add(textDomicilio);
		textDomicilio.setColumns(10);
		
		textTelefono = new JTextField();
		textTelefono.setBounds(99, 142, 150, 20);
		frmAltaProfesorParticular.getContentPane().add(textTelefono);
		textTelefono.setColumns(10);
		
		JLabel lblSueldo = new JLabel("Precio Hora");
		lblSueldo.setBounds(10, 170, 89, 14);
		frmAltaProfesorParticular.getContentPane().add(lblSueldo);
		
		textPrecioHora = new JTextField();
		textPrecioHora.setBounds(99, 167, 150, 20);
		frmAltaProfesorParticular.getContentPane().add(textPrecioHora);
		textPrecioHora.setColumns(10);
		
		JButton btnCancelar = new JButton("CANCELAR");
		btnCancelar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCancelar.setBorder(new CompoundBorder(new EtchedBorder(EtchedBorder.RAISED, null, null), new BevelBorder(BevelBorder.RAISED, null, null, null, null)));
		btnCancelar.setBounds(10, 201, 89, 23);
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmAltaProfesorParticular.dispose();
			}
		});
		frmAltaProfesorParticular.getContentPane().add(btnCancelar);
		
		JButton btnAceptar = new JButton("ACEPTAR");
		btnAceptar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAceptar.setBorder(new CompoundBorder(new EtchedBorder(EtchedBorder.RAISED, null, null), new BevelBorder(BevelBorder.RAISED, null, null, null, null)));
		btnAceptar.setBounds(160, 201, 89, 23);
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
					try {
						co.altaProfesorP(txtNombre.getText(), textDNI.getText(), textDomicilio.getText(),  textTelefono.getText(), textEmail.getText(), Float.parseFloat(textPrecioHora.getText()));
						txtNombre.setText("");
						textDNI.setText("");
						textEmail.setText("");
						textDomicilio.setText("");
						textTelefono.setText("");
						textPrecioHora.setText("");
					} catch (NumberFormatException | ProfesorException | ConnectionException e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage());
					}
					
				
		}
			
	});
		frmAltaProfesorParticular.getContentPane().add(btnAceptar);
	}
}