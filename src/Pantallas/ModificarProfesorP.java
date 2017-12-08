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

import Clases.PParticularView;
import Controlador.ControladoraABM;
import Excepciones.ConnectionException;
import Excepciones.ProfesorException;

import javax.swing.border.BevelBorder;
import java.awt.Cursor;

public class ModificarProfesorP {
	ControladoraABM co;
	PParticularView po;
	JFrame frmModificarProfesorParticular;
	private JTextField txtInserteDniA;
	private JTextField textNombre;
	private JTextField textEmail;
	private JTextField textDomicilio;
	private JTextField textTelefono;
	private JTextField textValorHora;

	public ModificarProfesorP(ControladoraABM c) {
		co=c;
		initialize();
	}

	private void initialize() {
		frmModificarProfesorParticular = new JFrame();
		frmModificarProfesorParticular.setTitle("Profesor Particular");
		frmModificarProfesorParticular.setBounds(100, 100, 388, 281);
		frmModificarProfesorParticular.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmModificarProfesorParticular.getContentPane().setLayout(null);
		
		JLabel lblBaja = new JLabel("Modificaci\u00F3n");
		lblBaja.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblBaja.setBounds(110, 13, 125, 27);
		frmModificarProfesorParticular.getContentPane().add(lblBaja);
		
		JLabel lblDni = new JLabel("D.N.I");
		lblDni.setBounds(10, 54, 46, 14);
		frmModificarProfesorParticular.getContentPane().add(lblDni);
		
		txtInserteDniA = new JTextField();
		txtInserteDniA.setText("Inserte D.N.I a buscar");
		txtInserteDniA.setBounds(66, 51, 197, 20);
		frmModificarProfesorParticular.getContentPane().add(txtInserteDniA);
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
				 po = co.devolverProfesorParticular(txtInserteDniA.getText());
				 textNombre.setText(po.getNombre());
				 textEmail.setText(po.getMail());
				 textDomicilio.setText(po.getDomicilio());
				 textTelefono.setText(po.getTelefono());
				 textValorHora.setText(po.getSueldo());
				 textNombre.setEnabled(true);
				 textDomicilio.setEnabled(true);
				 textEmail.setEnabled(true);
				 textTelefono.setEnabled(true);
				 textNombre.setEditable(true);
				 textDomicilio.setEditable(true);
				 textEmail.setEditable(true);
				 textTelefono.setEditable(true);
				 textValorHora.setEnabled(true);
				 textValorHora.setEditable(true);
				 txtInserteDniA.setEnabled(false);
				 textValorHora.setEnabled(true);
                 textValorHora.setEditable(true);
			} catch (ProfesorException | ConnectionException e1) {
				JOptionPane.showMessageDialog(null, e1.getMessage());
			}
		}
	});
		frmModificarProfesorParticular.getContentPane().add(btnBuscar);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(10, 79, 46, 14);
		frmModificarProfesorParticular.getContentPane().add(lblNombre);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(10, 104, 46, 14);
		frmModificarProfesorParticular.getContentPane().add(lblEmail);
		
		JLabel lblDomicilio = new JLabel("Domicilio");
		lblDomicilio.setBounds(10, 129, 60, 14);
		frmModificarProfesorParticular.getContentPane().add(lblDomicilio);
		
		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setBounds(10, 154, 60, 14);
		frmModificarProfesorParticular.getContentPane().add(lblTelefono);
		
		textNombre = new JTextField();
		textNombre.setEditable(false);
		textNombre.setEnabled(false);
		textNombre.setBounds(66, 76, 197, 20);
		frmModificarProfesorParticular.getContentPane().add(textNombre);
		textNombre.setColumns(10);
		
		textEmail = new JTextField();
		textEmail.setEditable(false);
		textEmail.setEnabled(false);
		textEmail.setBounds(66, 101, 197, 20);
		frmModificarProfesorParticular.getContentPane().add(textEmail);
		textEmail.setColumns(10);
		
		textDomicilio = new JTextField();
		textDomicilio.setEditable(false);
		textDomicilio.setEnabled(false);
		textDomicilio.setBounds(66, 126, 197, 20);
		frmModificarProfesorParticular.getContentPane().add(textDomicilio);
		textDomicilio.setColumns(10);
		
		textTelefono = new JTextField();
		textTelefono.setEditable(false);
		textTelefono.setEnabled(false);
		textTelefono.setBounds(66, 151, 197, 20);
		frmModificarProfesorParticular.getContentPane().add(textTelefono);
		textTelefono.setColumns(10);
		
		JButton btnAceptar = new JButton("ACEPTAR");
		btnAceptar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAceptar.setBorder(new CompoundBorder(new EtchedBorder(EtchedBorder.RAISED, null, null), new BevelBorder(BevelBorder.RAISED, null, null, null, null)));
		btnAceptar.setBounds(175, 207, 89, 23);
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					co.modificarProfesorP(txtInserteDniA.getText(), textNombre.getText(), textDomicilio.getText(), textTelefono.getText(), textEmail.getText(), Float.parseFloat(textValorHora.getText()));
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
					textValorHora.setText("");
				}catch(ProfesorException | NumberFormatException | ConnectionException e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
			}
		});
		frmModificarProfesorParticular.getContentPane().add(btnAceptar);
		
		JButton btnCancelar = new JButton("CANCELAR");
		btnCancelar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCancelar.setBorder(new CompoundBorder(new EtchedBorder(EtchedBorder.RAISED, null, null), new BevelBorder(BevelBorder.RAISED, null, null, null, null)));
		btnCancelar.setBounds(10, 207, 89, 23);
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmModificarProfesorParticular.dispose();
			}
		});
		frmModificarProfesorParticular.getContentPane().add(btnCancelar);
		
		JLabel lblPuesto = new JLabel("Precio Hora");
		lblPuesto.setBounds(10, 179, 89, 14);
		frmModificarProfesorParticular.getContentPane().add(lblPuesto);
		
		textValorHora = new JTextField();
		textValorHora.setEnabled(false);
		textValorHora.setEditable(false);
		textValorHora.setBounds(80, 179, 184, 20);
		frmModificarProfesorParticular.getContentPane().add(textValorHora);
		textValorHora.setColumns(10);
	}

}