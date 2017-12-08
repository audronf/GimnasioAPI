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

public class SeleccionProfesorBaja {
	ControladoraABM co;
	JFrame frmSelProfesorB;


	public SeleccionProfesorBaja(ControladoraABM c) {
		co=c;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSelProfesorB = new JFrame();
		frmSelProfesorB.setTitle("Profesor");
		frmSelProfesorB.setBounds(100, 100, 291, 166);
		frmSelProfesorB.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmSelProfesorB.getContentPane().setLayout(null);
		
		JLabel lblAltaProfesor = new JLabel("Seleccione tipo profesor");
		lblAltaProfesor.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAltaProfesor.setBounds(50, 0, 165, 45);
		frmSelProfesorB.getContentPane().add(lblAltaProfesor);
		
		JButton btnBajaCompleto = new JButton("COMPLETO");
		btnBajaCompleto.setBorder(new CompoundBorder(new EtchedBorder(EtchedBorder.RAISED, null, null), new BevelBorder(BevelBorder.RAISED, null, null, null, null)));
		btnBajaCompleto.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnBajaCompleto.setBounds(10, 56, 255, 23);
		frmSelProfesorB.getContentPane().add(btnBajaCompleto);
		btnBajaCompleto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				BajaProfesorC bc = new BajaProfesorC(co);
				bc.frmBajaProfesorCompleto.setVisible(true);
			}
		});
		JButton btnBajaParticular = new JButton("PARTICULAR");
		btnBajaParticular.setBorder(new CompoundBorder(new EtchedBorder(EtchedBorder.RAISED, null, null), new BevelBorder(BevelBorder.RAISED, null, null, null, null)));
		btnBajaParticular.setBounds(10, 90, 255, 23);
		frmSelProfesorB.getContentPane().add(btnBajaParticular);
		btnBajaParticular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				BajaProfesorP bp = new BajaProfesorP(co);
				bp.frmBajaProfesorParticular.setVisible(true);
			}
		});	
	}

}