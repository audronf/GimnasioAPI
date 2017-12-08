package Pantallas;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;

import Controlador.ControladoraABM;
import Excepciones.ConnectionException;

import javax.swing.border.BevelBorder;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ValidarIngreso {
	private boolean validacion;
	JFrame frmValidarIngreso;
	private JTextField textdni;
	ControladoraABM co;
	
	public ValidarIngreso(ControladoraABM c) {
		co=c;
		initialize();
	}

	private void initialize() {
		frmValidarIngreso = new JFrame();
		frmValidarIngreso.setBounds(100, 100, 268, 231);
		frmValidarIngreso.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmValidarIngreso.getContentPane().setLayout(null);
		
		JLabel lblValidarIngreso = new JLabel("VALIDAR INGRESO");
		lblValidarIngreso.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblValidarIngreso.setBounds(55, 11, 150, 27);
		frmValidarIngreso.getContentPane().add(lblValidarIngreso);
		
		JLabel lblDni = new JLabel("D.N.I");
		lblDni.setBounds(10, 51, 88, 14);
		frmValidarIngreso.getContentPane().add(lblDni);
		
		textdni = new JTextField();
		textdni.setBounds(75, 48, 130, 20);
		frmValidarIngreso.getContentPane().add(textdni);
		textdni.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(22, 89, 171, 27);
		frmValidarIngreso.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblValidacion = new JLabel("");
		lblValidacion.setBounds(46, 5, 126, 14);
		panel.add(lblValidacion);
		
		JButton btnCancelar = new JButton("CANCELAR");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCancelar.setBorder(new CompoundBorder(new EtchedBorder(EtchedBorder.RAISED, null, null), new BevelBorder(BevelBorder.RAISED, null, null, null, null)));
		btnCancelar.setBounds(10, 158, 89, 23);
		frmValidarIngreso.getContentPane().add(btnCancelar);
		
		JButton btnAceptar = new JButton("ACEPTAR");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					validacion = co.validarIngreso(textdni.getText());
                if(validacion) {
                    panel.setBackground(Color.GREEN);
                    lblValidacion.setText("Ingreso Valido");
                }
                else {
                    panel.setBackground(Color.RED);
                    lblValidacion.setText("Ingreso Invalido");
                }
				} catch (ConnectionException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
			}
		});
		btnAceptar.setBorder(new CompoundBorder(new EtchedBorder(EtchedBorder.RAISED, null, null), new BevelBorder(BevelBorder.RAISED, null, null, null, null)));
		btnAceptar.setBounds(153, 158, 89, 23);
		frmValidarIngreso.getContentPane().add(btnAceptar);
		

	}
}
