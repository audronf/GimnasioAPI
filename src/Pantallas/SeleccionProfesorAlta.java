package Pantallas;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import java.awt.Cursor;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;

import Controlador.ControladoraABM;

import javax.swing.border.BevelBorder;

public class SeleccionProfesorAlta {
	ControladoraABM co;
	JFrame frmSelProfesorA;


	public SeleccionProfesorAlta(ControladoraABM c) {
		co=c;
		initialize();
	}


	private void initialize() {
		frmSelProfesorA = new JFrame();
		frmSelProfesorA.setTitle("Profesor");
		frmSelProfesorA.setBounds(100, 100, 291, 166);
		frmSelProfesorA.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmSelProfesorA.getContentPane().setLayout(null);
		
		JLabel lblAltaProfesor = new JLabel("Seleccione tipo profesor");
		lblAltaProfesor.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAltaProfesor.setBounds(50, 0, 165, 45);
		frmSelProfesorA.getContentPane().add(lblAltaProfesor);
		
		JButton btnAltaCompleto = new JButton("COMPLETO");
		btnAltaCompleto.setBorder(new CompoundBorder(new EtchedBorder(EtchedBorder.RAISED, null, null), new BevelBorder(BevelBorder.RAISED, null, null, null, null)));
		btnAltaCompleto.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAltaCompleto.setBounds(10, 56, 255, 23);
		frmSelProfesorA.getContentPane().add(btnAltaCompleto);
		btnAltaCompleto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AltaProfesorC ac = new AltaProfesorC(co);
				ac.frmAltaProfesorCompleto.setVisible(true);
			}
		});
		JButton btnAltaParticular = new JButton("PARTICULAR");
		btnAltaParticular.setBorder(new CompoundBorder(new EtchedBorder(EtchedBorder.RAISED, null, null), new BevelBorder(BevelBorder.RAISED, null, null, null, null)));
		btnAltaParticular.setBounds(10, 90, 255, 23);
		frmSelProfesorA.getContentPane().add(btnAltaParticular);
		btnAltaParticular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AltaProfesorP ap = new AltaProfesorP(co);
				ap.frmAltaProfesorParticular.setVisible(true);
			}
		});	
	}

}
 