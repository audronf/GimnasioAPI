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

public class SeleccionProfesorModificar {
	ControladoraABM co;
	JFrame frmSelProfesorM;


	public SeleccionProfesorModificar(ControladoraABM c) {
		co=c;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSelProfesorM = new JFrame();
		frmSelProfesorM.setTitle("Profesor");
		frmSelProfesorM.setBounds(100, 100, 291, 166);
		frmSelProfesorM.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmSelProfesorM.getContentPane().setLayout(null);
		
		JLabel lblAltaProfesor = new JLabel("Seleccione tipo profesor");
		lblAltaProfesor.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAltaProfesor.setBounds(50, 0, 165, 45);
		frmSelProfesorM.getContentPane().add(lblAltaProfesor);
		
		JButton btnModificarCompleto = new JButton("COMPLETO");
		btnModificarCompleto.setBorder(new CompoundBorder(new EtchedBorder(EtchedBorder.RAISED, null, null), new BevelBorder(BevelBorder.RAISED, null, null, null, null)));
		btnModificarCompleto.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnModificarCompleto.setBounds(10, 56, 255, 23);
		frmSelProfesorM.getContentPane().add(btnModificarCompleto);
		btnModificarCompleto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ModificarProfesorC mc = new ModificarProfesorC(co);
				mc.frmModificarProfesorCompleto.setVisible(true);
			}
		});
		JButton btnModificarParticular = new JButton("PARTICULAR");
		btnModificarParticular.setBorder(new CompoundBorder(new EtchedBorder(EtchedBorder.RAISED, null, null), new BevelBorder(BevelBorder.RAISED, null, null, null, null)));
		btnModificarParticular.setBounds(10, 90, 255, 23);
		frmSelProfesorM.getContentPane().add(btnModificarParticular);
		btnModificarParticular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ModificarProfesorP mp = new ModificarProfesorP(co);
				mp.frmModificarProfesorParticular.setVisible(true);
			}
		});
//		
	}

}
