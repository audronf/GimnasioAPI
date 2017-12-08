package Pantallas;

import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;

import Controlador.ControladoraABM;
import Excepciones.ConnectionException;
import Excepciones.EmpleadoException;
import Excepciones.SocioException;

public class LiquidarSueldo {
	
	JFrame frmLiq;
	private JTextField textField;
	private JTextField textField_1;
	private ControladoraABM co;
	private double total;

	public LiquidarSueldo(ControladoraABM c) {
		co=c;
		initialize();
	}

	private void initialize() {
		frmLiq = new JFrame();
		frmLiq.setTitle("Gimnasio");
		frmLiq.setBounds(100, 100, 202, 185);
		frmLiq.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmLiq.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("CANCELAR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmLiq.dispose();
			}
		});
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.setBorder(new CompoundBorder(new EtchedBorder(EtchedBorder.RAISED, null, null), new BevelBorder(BevelBorder.RAISED, null, null, null, null)));
		btnNewButton.setBounds(10, 112, 75, 23);
		frmLiq.getContentPane().add(btnNewButton);
		
		JLabel lblSocios = new JLabel("Liquidacion");
		lblSocios.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSocios.setBounds(51, 11, 92, 23);
		frmLiq.getContentPane().add(lblSocios);
		
		JLabel lblNewLabel = new JLabel("Mes");
		lblNewLabel.setBounds(10, 52, 69, 14);
		frmLiq.getContentPane().add(lblNewLabel);
		
		JLabel lblAo = new JLabel("Anio");
		lblAo.setBounds(10, 77, 69, 14);
		frmLiq.getContentPane().add(lblAo);
		
		textField = new JTextField();
		textField.setBounds(66, 49, 86, 20);
		frmLiq.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(66, 74, 86, 20);
		frmLiq.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnAceptar = new JButton("ACEPTAR");
		btnAceptar.setBorder(new CompoundBorder(new EtchedBorder(EtchedBorder.RAISED, null, null), new BevelBorder(BevelBorder.RAISED, null, null, null, null)));
		btnAceptar.setBounds(101, 112, 75, 23);
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					total=co.liquidarSueldosEmpleados(Integer.parseInt(textField.getText()), Integer.parseInt(textField_1.getText()));
					JOptionPane.showMessageDialog(null, "El total a liquidar es"+total);
					textField.setText("");
                    textField_1.setText("");
				} catch (NumberFormatException | EmpleadoException | ConnectionException | SocioException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
			}
		});
		frmLiq.getContentPane().add(btnAceptar);
	}
	
}