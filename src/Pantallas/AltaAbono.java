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
import Excepciones.AbonoException;
import Excepciones.ConnectionException;

import javax.swing.border.BevelBorder;
import java.awt.Cursor;

public class AltaAbono {
	ControladoraABM co;
	JFrame frmAltaAbono;
	private JTextField txtNombre;


	public AltaAbono(ControladoraABM c) {
		co=c;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAltaAbono = new JFrame();
		frmAltaAbono.setTitle("Abono");
		frmAltaAbono.setBounds(100, 100, 258, 165);
		frmAltaAbono.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmAltaAbono.getContentPane().setLayout(null);
		
		JLabel lblAlta = new JLabel("Alta");
		lblAlta.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAlta.setBounds(101, 11, 56, 20);
		frmAltaAbono.getContentPane().add(lblAlta);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(10, 45, 46, 14);
		frmAltaAbono.getContentPane().add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(101, 42, 129, 20);
		frmAltaAbono.getContentPane().add(txtNombre);
		txtNombre.setColumns(10);
		
		JButton button = new JButton("CANCELAR");
		button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button.setBorder(new CompoundBorder(new EtchedBorder(EtchedBorder.RAISED, null, null), new BevelBorder(BevelBorder.RAISED, null, null, null, null)));
		button.setBounds(10, 92, 89, 23);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmAltaAbono.dispose();
			}
		});
		frmAltaAbono.getContentPane().add(button);
		
		JButton button_1 = new JButton("ACEPTAR");
		button_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button_1.setBorder(new CompoundBorder(new EtchedBorder(EtchedBorder.RAISED, null, null), new BevelBorder(BevelBorder.RAISED, null, null, null, null)));
		button_1.setBounds(143, 92, 89, 23);
		button_1.addActionListener(new ActionListener() {
			   public void actionPerformed(ActionEvent e) {
			    try {
					co.altaAbono(txtNombre.getText());
					txtNombre.setText("");
				} catch (ConnectionException | AbonoException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
					
				}
			    
			   }
			  });
		frmAltaAbono.getContentPane().add(button_1);
	}
}