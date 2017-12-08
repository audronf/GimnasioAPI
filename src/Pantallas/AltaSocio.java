package Pantallas;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Cursor;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;

import Controlador.ControladoraABM;
import Excepciones.ConnectionException;
import Excepciones.SocioException;

import javax.swing.border.BevelBorder;

public class AltaSocio {

	JFrame frmAltaSocio;
	ControladoraABM co;
	private JTextField txtNombre;
	private JTextField textDNI;
	private JTextField textEmail;
	private JTextField textDomicilio;
	private JTextField textTelefono;


	public AltaSocio(ControladoraABM c) {
		co=c;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAltaSocio = new JFrame();
		frmAltaSocio.setTitle("Socio");
		frmAltaSocio.setBounds(100, 100, 275, 252);
		frmAltaSocio.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmAltaSocio.getContentPane().setLayout(null);
		
		JLabel lblAlta = new JLabel("Alta");
		lblAlta.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAlta.setBounds(109, 11, 56, 20);
		frmAltaSocio.getContentPane().add(lblAlta);
		
		JLabel lblNombre = new JLabel("D.N.I");
		lblNombre.setBounds(10, 45, 46, 14);
		frmAltaSocio.getContentPane().add(lblNombre);
		
		JLabel lblDni = new JLabel("Nombre");
		lblDni.setBounds(10, 70, 46, 14);
		frmAltaSocio.getContentPane().add(lblDni);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(10, 95, 46, 14);
		frmAltaSocio.getContentPane().add(lblEmail);
		
		JLabel lblNewLabel = new JLabel("Domicilio");
		lblNewLabel.setBounds(10, 120, 60, 14);
		frmAltaSocio.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Telefono");
		lblNewLabel_1.setBounds(10, 145, 60, 14);
		frmAltaSocio.getContentPane().add(lblNewLabel_1);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(99, 42, 150, 20);
		frmAltaSocio.getContentPane().add(txtNombre);
		txtNombre.setColumns(10);
		
		textDNI = new JTextField();
		textDNI.setBounds(99, 67, 150, 20);
		frmAltaSocio.getContentPane().add(textDNI);
		textDNI.setColumns(10);
		
		textEmail = new JTextField();
		textEmail.setBounds(99, 92, 150, 20);
		frmAltaSocio.getContentPane().add(textEmail);
		textEmail.setColumns(10);
		
		textDomicilio = new JTextField();
		textDomicilio.setBounds(99, 117, 150, 20);
		frmAltaSocio.getContentPane().add(textDomicilio);
		textDomicilio.setColumns(10);
		
		textTelefono = new JTextField();
		textTelefono.setBounds(99, 142, 150, 20);
		frmAltaSocio.getContentPane().add(textTelefono);
		textTelefono.setColumns(10);
		
		JButton btnCancelar = new JButton("CANCELAR");
		btnCancelar.setBorder(new CompoundBorder(new EtchedBorder(EtchedBorder.RAISED, null, null), new BevelBorder(BevelBorder.RAISED, null, null, null, null)));
		btnCancelar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmAltaSocio.dispose();
			}
		});
		btnCancelar.setBounds(10, 179, 89, 23);
		frmAltaSocio.getContentPane().add(btnCancelar);
		
		JButton btnAceptar = new JButton("ACEPTAR");
		btnAceptar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAceptar.setBorder(new CompoundBorder(new EtchedBorder(EtchedBorder.RAISED, null, null), new BevelBorder(BevelBorder.RAISED, null, null, null, null)));
		btnAceptar.setBounds(160, 179, 89, 23);
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					co.altaSocio(txtNombre.getText(), textDNI.getText(), textEmail.getText(), textDomicilio.getText(), textTelefono.getText());
					txtNombre.setText("");
					textDNI.setText("");
					textEmail.setText("");
					textDomicilio.setText("");
					textTelefono.setText("");
				}catch(SocioException | ConnectionException e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
			}
		});
		frmAltaSocio.getContentPane().add(btnAceptar);
	}
}