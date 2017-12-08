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

import Clases.PCompletoView;
import Controlador.ControladoraABM;
import Excepciones.ConnectionException;
import Excepciones.ProfesorException;
import javax.swing.border.BevelBorder;
import java.awt.Cursor;

public class BajaProfesorC {
	ControladoraABM co;
	PCompletoView po;
	JFrame frmBajaProfesorCompleto;
	private JTextField txtInserteDniA;
	private JTextField textNombre;
	private JTextField textEmail;
	private JTextField textDomicilio;
	private JTextField textTelefono;
	private JTextField textSueldo;
	private JTextField textRetenciones;
	private JTextField textDeducciones;

	public BajaProfesorC(ControladoraABM c) {
		co=c;
		initialize();
	}

	private void initialize() {
		frmBajaProfesorCompleto = new JFrame();
		frmBajaProfesorCompleto.setTitle("Profesor Completo");
		frmBajaProfesorCompleto.setBounds(100, 100, 388, 342);
		frmBajaProfesorCompleto.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmBajaProfesorCompleto.getContentPane().setLayout(null);
		
		JLabel lblBaja = new JLabel("Baja");
		lblBaja.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblBaja.setBounds(138, 13, 46, 27);
		frmBajaProfesorCompleto.getContentPane().add(lblBaja);
		
		JLabel lblDni = new JLabel("D.N.I");
		lblDni.setBounds(10, 54, 46, 14);
		frmBajaProfesorCompleto.getContentPane().add(lblDni);
		
		txtInserteDniA = new JTextField();
		txtInserteDniA.setText("Inserte D.N.I a buscar");
		txtInserteDniA.setBounds(66, 51, 197, 20);
		frmBajaProfesorCompleto.getContentPane().add(txtInserteDniA);
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
					 po = co.devolverProfesorCompleto(txtInserteDniA.getText());
					 textNombre.setText(po.getNombre());
					 textEmail.setText(po.getMail());
					 textDomicilio.setText(po.getDomicilio());
					 textTelefono.setText(po.getTelefono());
					 textSueldo.setText(po.getSueldo());
                     textRetenciones.setText(po.getRetenciones());
                     textDeducciones.setText(po.getDeducciones());
					 textNombre.setEnabled(true);
					 textDomicilio.setEnabled(true);
					 textEmail.setEnabled(true);
					 textTelefono.setEnabled(true);
					 textNombre.setEditable(false);
					 textDomicilio.setEditable(false);
					 textEmail.setEditable(false);
					 textTelefono.setEditable(false);
					 txtInserteDniA.setEnabled(true);
					 textDeducciones.setEnabled(true);
					 textDeducciones.setEditable(false);
					 textRetenciones.setEnabled(true);
					 textRetenciones.setEditable(false);
					 textSueldo.setEnabled(true);
					 textSueldo.setEditable(false);
					 txtInserteDniA.setEditable(true);
				} catch (ProfesorException | ConnectionException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
			}
		});
		frmBajaProfesorCompleto.getContentPane().add(btnBuscar);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(10, 79, 46, 14);
		frmBajaProfesorCompleto.getContentPane().add(lblNombre);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(10, 104, 46, 14);
		frmBajaProfesorCompleto.getContentPane().add(lblEmail);
		
		JLabel lblDomicilio = new JLabel("Domicilio");
		lblDomicilio.setBounds(10, 129, 61, 14);
		frmBajaProfesorCompleto.getContentPane().add(lblDomicilio);
		
		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setBounds(10, 154, 61, 14);
		frmBajaProfesorCompleto.getContentPane().add(lblTelefono);
		
		textNombre = new JTextField();
		textNombre.setEditable(false);
		textNombre.setEnabled(false);
		textNombre.setBounds(66, 76, 197, 20);
		frmBajaProfesorCompleto.getContentPane().add(textNombre);
		textNombre.setColumns(10);
		
		textEmail = new JTextField();
		textEmail.setEditable(false);
		textEmail.setEnabled(false);
		textEmail.setBounds(66, 101, 197, 20);
		frmBajaProfesorCompleto.getContentPane().add(textEmail);
		textEmail.setColumns(10);
		
		textDomicilio = new JTextField();
		textDomicilio.setEditable(false);
		textDomicilio.setEnabled(false);
		textDomicilio.setBounds(66, 126, 197, 20);
		frmBajaProfesorCompleto.getContentPane().add(textDomicilio);
		textDomicilio.setColumns(10);
		
		textTelefono = new JTextField();
		textTelefono.setEditable(false);
		textTelefono.setEnabled(false);
		textTelefono.setBounds(66, 151, 197, 20);
		frmBajaProfesorCompleto.getContentPane().add(textTelefono);
		textTelefono.setColumns(10);
		
		JButton btnAceptar = new JButton("ACEPTAR");
		btnAceptar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAceptar.setBorder(new CompoundBorder(new EtchedBorder(EtchedBorder.RAISED, null, null), new BevelBorder(BevelBorder.RAISED, null, null, null, null)));
		btnAceptar.setBounds(174, 269, 89, 23);
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					 co.bajaLogicaProfesorC(txtInserteDniA.getText());
					 txtInserteDniA.setText("");
					 
				} catch (ProfesorException | ConnectionException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
			}
		});
		frmBajaProfesorCompleto.getContentPane().add(btnAceptar);
		
		JButton btnCancelar = new JButton("CANCELAR");
		btnCancelar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCancelar.setBorder(new CompoundBorder(new EtchedBorder(EtchedBorder.RAISED, null, null), new BevelBorder(BevelBorder.RAISED, null, null, null, null)));
		btnCancelar.setBounds(10, 269, 89, 23);
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmBajaProfesorCompleto.dispose();
			}
		});
		frmBajaProfesorCompleto.getContentPane().add(btnCancelar);
		
		JLabel lblPuesto = new JLabel("Sueldo");
		lblPuesto.setBounds(10, 179, 89, 14);
		frmBajaProfesorCompleto.getContentPane().add(lblPuesto);
		
		textSueldo = new JTextField();
		textSueldo.setEnabled(false);
		textSueldo.setEditable(false);
		textSueldo.setBounds(66, 176, 197, 20);
		frmBajaProfesorCompleto.getContentPane().add(textSueldo);
		textSueldo.setColumns(10);
		
		JLabel lblRetenciones = new JLabel("Retenciones");
		lblRetenciones.setBounds(10, 204, 89, 14);
		frmBajaProfesorCompleto.getContentPane().add(lblRetenciones);
		
		JLabel lblDeducciones = new JLabel("Deducciones");
		lblDeducciones.setBounds(10, 232, 89, 14);
		frmBajaProfesorCompleto.getContentPane().add(lblDeducciones);
		
		textRetenciones = new JTextField();
		textRetenciones.setEnabled(false);
		textRetenciones.setEditable(false);
		textRetenciones.setColumns(10);
		textRetenciones.setBounds(85, 201, 177, 20);
		frmBajaProfesorCompleto.getContentPane().add(textRetenciones);
		
		textDeducciones = new JTextField();
		textDeducciones.setEnabled(false);
		textDeducciones.setEditable(false);
		textDeducciones.setColumns(10);
		textDeducciones.setBounds(85, 229, 177, 20);
		frmBajaProfesorCompleto.getContentPane().add(textDeducciones);
	}

}