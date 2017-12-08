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
import Excepciones.DeporteException;
import javax.swing.border.BevelBorder;
import java.awt.Cursor;

public class AltaDeporte {

	JFrame frmAltaDeporte;
	ControladoraABM co;
	private JTextField txtNombre;
	private JTextField textDescripcion;


	public AltaDeporte(ControladoraABM c) {
		co = c;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAltaDeporte = new JFrame();
		frmAltaDeporte.setTitle("Deporte");
		frmAltaDeporte.setBounds(100, 100, 315, 167);
		frmAltaDeporte.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmAltaDeporte.getContentPane().setLayout(null);
		
		JLabel lblAlta = new JLabel("Alta");
		lblAlta.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAlta.setBounds(131, 11, 56, 20);
		frmAltaDeporte.getContentPane().add(lblAlta);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(10, 45, 46, 14);
		frmAltaDeporte.getContentPane().add(lblNombre);
		
		JLabel lblDescripcion = new JLabel("Descripcion");
		lblDescripcion.setBounds(10, 70, 79, 14);
		frmAltaDeporte.getContentPane().add(lblDescripcion);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(99, 42, 190, 20);
		frmAltaDeporte.getContentPane().add(txtNombre);
		txtNombre.setColumns(10);
		
		textDescripcion = new JTextField();
		textDescripcion.setBounds(99, 67, 190, 20);
		frmAltaDeporte.getContentPane().add(textDescripcion);
		textDescripcion.setColumns(10);
		
		JButton btnCancelar = new JButton("CANCELAR");
		btnCancelar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCancelar.setBorder(new CompoundBorder(new EtchedBorder(EtchedBorder.RAISED, null, null), new BevelBorder(BevelBorder.RAISED, null, null, null, null)));
		btnCancelar.setBounds(10, 98, 89, 23);
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmAltaDeporte.dispose();
			}
		});
		frmAltaDeporte.getContentPane().add(btnCancelar);
		
		JButton btnAceptar = new JButton("ACEPTAR");
		btnAceptar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAceptar.setBorder(new CompoundBorder(new EtchedBorder(EtchedBorder.RAISED, null, null), new BevelBorder(BevelBorder.RAISED, null, null, null, null)));
		btnAceptar.setBounds(200, 98, 89, 23);
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					co.altaDeporte(txtNombre.getText(),textDescripcion.getText());
					txtNombre.setText("");
					textDescripcion.setText("");
				} catch (ConnectionException | DeporteException e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
			}
		});
		frmAltaDeporte.getContentPane().add(btnAceptar);
	}
}