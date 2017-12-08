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

public class BajaProfesorP {
	ControladoraABM co;
	PParticularView po;
	JFrame frmBajaProfesorParticular;
	private JTextField txtInserteDniA;
	private JTextField textEmail;
	private JTextField textDomicilio;
	private JTextField textTelefono;
	private JTextField textNombre;
	private JTextField textValorHora;


	public BajaProfesorP(ControladoraABM c) {
		co=c;
		initialize();
	}

	
	private void initialize() {
		frmBajaProfesorParticular = new JFrame();
		frmBajaProfesorParticular.setTitle("Profesor Particular");
		frmBajaProfesorParticular.setBounds(100, 100, 388, 281);
		frmBajaProfesorParticular.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmBajaProfesorParticular.getContentPane().setLayout(null);
		
		JLabel lblBaja = new JLabel("Baja");
		lblBaja.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblBaja.setBounds(138, 13, 46, 27);
		frmBajaProfesorParticular.getContentPane().add(lblBaja);
		
		JLabel lblDni = new JLabel("D.N.I");
		lblDni.setBounds(10, 54, 46, 14);
		frmBajaProfesorParticular.getContentPane().add(lblDni);
		
		txtInserteDniA = new JTextField();
		txtInserteDniA.setText("Inserte D.N.I a buscar");
		txtInserteDniA.setBounds(66, 51, 197, 20);
		txtInserteDniA.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				txtInserteDniA.setText("");
			}
		});
		frmBajaProfesorParticular.getContentPane().add(txtInserteDniA);
		
		txtInserteDniA.setColumns(10);
		
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
					 txtInserteDniA.setEnabled(false);
					 txtInserteDniA.setEditable(true);
				} catch (ProfesorException | ConnectionException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
			}
		});
		frmBajaProfesorParticular.getContentPane().add(btnBuscar);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(10, 79, 46, 14);
		frmBajaProfesorParticular.getContentPane().add(lblNombre);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(10, 104, 46, 14);
		frmBajaProfesorParticular.getContentPane().add(lblEmail);
		
		JLabel lblDomicilio = new JLabel("Domicilio");
		lblDomicilio.setBounds(10, 129, 61, 14);
		frmBajaProfesorParticular.getContentPane().add(lblDomicilio);
		
		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setBounds(10, 154, 61, 14);
		frmBajaProfesorParticular.getContentPane().add(lblTelefono);
		
		textNombre = new JTextField();
		textNombre.setEditable(false);
		textNombre.setEnabled(false);
		textNombre.setBounds(66, 76, 197, 20);
		frmBajaProfesorParticular.getContentPane().add(textNombre);
		textNombre.setColumns(10);
		
		textEmail = new JTextField();
		textEmail.setEditable(false);
		textEmail.setEnabled(false);
		textEmail.setBounds(66, 101, 197, 20);
		frmBajaProfesorParticular.getContentPane().add(textEmail);
		textEmail.setColumns(10);
		
		textDomicilio = new JTextField();
		textDomicilio.setEditable(false);
		textDomicilio.setEnabled(false);
		textDomicilio.setBounds(66, 126, 197, 20);
		frmBajaProfesorParticular.getContentPane().add(textDomicilio);
		textDomicilio.setColumns(10);
		
		textTelefono = new JTextField();
		textTelefono.setEditable(false);
		textTelefono.setEnabled(false);
		textTelefono.setBounds(66, 151, 197, 20);
		frmBajaProfesorParticular.getContentPane().add(textTelefono);
		textTelefono.setColumns(10);
		
		JButton btnAceptar = new JButton("ACEPTAR");
		btnAceptar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAceptar.setBorder(new CompoundBorder(new EtchedBorder(EtchedBorder.RAISED, null, null), new BevelBorder(BevelBorder.RAISED, null, null, null, null)));
		btnAceptar.setBounds(175, 207, 89, 23);
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					 co.bajaLogicaProfesorP(txtInserteDniA.getText());
					 txtInserteDniA.setText("");
					 
				} catch (ProfesorException | ConnectionException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
			}
		});
		frmBajaProfesorParticular.getContentPane().add(btnAceptar);
		
		JButton btnCancelar = new JButton("CANCELAR");
		btnCancelar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCancelar.setBorder(new CompoundBorder(new EtchedBorder(EtchedBorder.RAISED, null, null), new BevelBorder(BevelBorder.RAISED, null, null, null, null)));
		btnCancelar.setBounds(10, 207, 89, 23);
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmBajaProfesorParticular.dispose();
			}
		});
		frmBajaProfesorParticular.getContentPane().add(btnCancelar);
		
		JLabel lblPuesto = new JLabel("Precio Hora");
		lblPuesto.setBounds(10, 179, 89, 14);
		frmBajaProfesorParticular.getContentPane().add(lblPuesto);
		
		textValorHora = new JTextField();
		textValorHora.setEnabled(false);
		textValorHora.setEditable(false);
		textValorHora.setBounds(85, 179, 179, 20);
		frmBajaProfesorParticular.getContentPane().add(textValorHora);
		textValorHora.setColumns(10);
	}

}