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

public class ModificarProfesorC {
	ControladoraABM co;
	PCompletoView po;
	JFrame frmModificarProfesorCompleto;
	private JTextField txtInserteDniA;
	private JTextField textNombre;
	private JTextField textEmail;
	private JTextField textDomicilio;
	private JTextField textTelefono;
	private JTextField textSueldo;
	private JTextField textRetenciones;
	private JTextField textDeducciones;

	public ModificarProfesorC(ControladoraABM c) {
		co=c;
		initialize();
	}

	private void initialize() {
		frmModificarProfesorCompleto = new JFrame();
		frmModificarProfesorCompleto.setTitle("Profesor Completo");
		frmModificarProfesorCompleto.setBounds(100, 100, 388, 332);
		frmModificarProfesorCompleto.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmModificarProfesorCompleto.getContentPane().setLayout(null);
		
		JLabel lblBaja = new JLabel("Modificaci\u00F3n");
		lblBaja.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblBaja.setBounds(110, 13, 125, 27);
		frmModificarProfesorCompleto.getContentPane().add(lblBaja);
		
		JLabel lblDni = new JLabel("D.N.I");
		lblDni.setBounds(10, 54, 46, 14);
		frmModificarProfesorCompleto.getContentPane().add(lblDni);
		
		txtInserteDniA = new JTextField();
		txtInserteDniA.setText("Inserte D.N.I a buscar");
		txtInserteDniA.setBounds(66, 51, 197, 20);
		frmModificarProfesorCompleto.getContentPane().add(txtInserteDniA);
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
					 textNombre.setEditable(true);
					 textDomicilio.setEditable(true);
					 textEmail.setEditable(true);
					 textTelefono.setEditable(true);
					 textSueldo.setEditable(true);
					 textDeducciones.setEditable(true);
					 textRetenciones.setEditable(true);
					 txtInserteDniA.setEnabled(false);
					 textSueldo.setEnabled(true);
                     textSueldo.setEditable(true);
                     textRetenciones.setEnabled(true);
                     textRetenciones.setEditable(true);
                     textDeducciones.setEnabled(true);
                     textDeducciones.setEditable(true);
				} catch (ProfesorException | ConnectionException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
			}
		});
		frmModificarProfesorCompleto.getContentPane().add(btnBuscar);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(10, 79, 46, 14);
		frmModificarProfesorCompleto.getContentPane().add(lblNombre);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(10, 104, 46, 14);
		frmModificarProfesorCompleto.getContentPane().add(lblEmail);
		
		JLabel lblDomicilio = new JLabel("Domicilio");
		lblDomicilio.setBounds(10, 129, 60, 14);
		frmModificarProfesorCompleto.getContentPane().add(lblDomicilio);
		
		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setBounds(10, 154, 60, 14);
		frmModificarProfesorCompleto.getContentPane().add(lblTelefono);
		
		textNombre = new JTextField();
		textNombre.setEditable(false);
		textNombre.setEnabled(false);
		textNombre.setBounds(66, 76, 197, 20);
		frmModificarProfesorCompleto.getContentPane().add(textNombre);
		textNombre.setColumns(10);
		
		textEmail = new JTextField();
		textEmail.setEditable(false);
		textEmail.setEnabled(false);
		textEmail.setBounds(66, 101, 197, 20);
		frmModificarProfesorCompleto.getContentPane().add(textEmail);
		textEmail.setColumns(10);
		
		textDomicilio = new JTextField();
		textDomicilio.setEditable(false);
		textDomicilio.setEnabled(false);
		textDomicilio.setBounds(66, 126, 197, 20);
		frmModificarProfesorCompleto.getContentPane().add(textDomicilio);
		textDomicilio.setColumns(10);
		
		textTelefono = new JTextField();
		textTelefono.setEditable(false);
		textTelefono.setEnabled(false);
		textTelefono.setBounds(66, 151, 197, 20);
		frmModificarProfesorCompleto.getContentPane().add(textTelefono);
		textTelefono.setColumns(10);
		
		JButton btnAceptar = new JButton("ACEPTAR");
		btnAceptar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAceptar.setBorder(new CompoundBorder(new EtchedBorder(EtchedBorder.RAISED, null, null), new BevelBorder(BevelBorder.RAISED, null, null, null, null)));
		btnAceptar.setBounds(174, 259, 89, 23);
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					co.modificarProfesorC(txtInserteDniA.getText(), textNombre.getText(), textDomicilio.getText(), textTelefono.getText(), textEmail.getText(), 0, 0, 0);
					txtInserteDniA.setText("Inserte D.N.I a buscar");
					txtInserteDniA.setEnabled(true);
					textNombre.setEnabled(false);
					textDomicilio.setEnabled(false);
					textEmail.setEnabled(false);
					textTelefono.setEnabled(false);
					textSueldo.setEnabled(false);
					textDeducciones.setEnabled(false);
					textRetenciones.setEnabled(false);
					textNombre.setText("");
					textDomicilio.setText("");
					textEmail.setText("");
					textTelefono.setText("");
					textSueldo.setText("");
					textDeducciones.setText("");
					textRetenciones.setText("");
				}catch(ProfesorException | ConnectionException e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
			}
		});
		frmModificarProfesorCompleto.getContentPane().add(btnAceptar);
		
		JButton btnCancelar = new JButton("CANCELAR");
		btnCancelar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCancelar.setBorder(new CompoundBorder(new EtchedBorder(EtchedBorder.RAISED, null, null), new BevelBorder(BevelBorder.RAISED, null, null, null, null)));
		btnCancelar.setBounds(10, 259, 89, 23);
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmModificarProfesorCompleto.dispose();
			}
		});
		frmModificarProfesorCompleto.getContentPane().add(btnCancelar);
		
		JLabel lblPuesto = new JLabel("Sueldo");
		lblPuesto.setBounds(10, 179, 89, 14);
		frmModificarProfesorCompleto.getContentPane().add(lblPuesto);
		
		textSueldo = new JTextField();
		textSueldo.setEnabled(false);
		textSueldo.setEditable(false);
		textSueldo.setBounds(66, 176, 197, 20);
		frmModificarProfesorCompleto.getContentPane().add(textSueldo);
		textSueldo.setColumns(10);
		
		JLabel lblRetenciones = new JLabel("Retenciones");
		lblRetenciones.setBounds(10, 204, 103, 14);
		frmModificarProfesorCompleto.getContentPane().add(lblRetenciones);
		
		textRetenciones = new JTextField();
		textRetenciones.setEnabled(false);
		textRetenciones.setEditable(false);
		textRetenciones.setColumns(10);
		textRetenciones.setBounds(99, 201, 164, 20);
		frmModificarProfesorCompleto.getContentPane().add(textRetenciones);
		
		JLabel lblDeducciones = new JLabel("Deducciones");
		lblDeducciones.setBounds(10, 229, 103, 14);
		frmModificarProfesorCompleto.getContentPane().add(lblDeducciones);
		
		textDeducciones = new JTextField();
		textDeducciones.setEnabled(false);
		textDeducciones.setEditable(false);
		textDeducciones.setColumns(10);
		textDeducciones.setBounds(99, 226, 164, 20);
		frmModificarProfesorCompleto.getContentPane().add(textDeducciones);
	}

}