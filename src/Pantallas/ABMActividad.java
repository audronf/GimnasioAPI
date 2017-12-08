package Pantallas;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Cursor;

public class ABMActividad {

	JFrame frmGimnasio;


	public ABMActividad() {
		initialize();
	}

	private void initialize() {
		frmGimnasio = new JFrame();
		frmGimnasio.setTitle("Gimnasio");
		frmGimnasio.setBounds(100, 100, 291, 185);
		frmGimnasio.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmGimnasio.getContentPane().setLayout(null);
		
		JButton btnAltas = new JButton("ALTAS");
		btnAltas.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAltas.setBorder(new CompoundBorder(new EtchedBorder(EtchedBorder.RAISED, null, null), new BevelBorder(BevelBorder.RAISED, null, null, null, null)));
		btnAltas.setForeground(Color.BLACK);
		btnAltas.setBounds(10, 44, 255, 23);
		frmGimnasio.getContentPane().add(btnAltas);
		
		JButton btnModificaciones = new JButton("MODIFICACIONES");
		btnModificaciones.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnModificaciones.setBorder(new CompoundBorder(new EtchedBorder(EtchedBorder.RAISED, null, null), new BevelBorder(BevelBorder.RAISED, null, null, null, null)));
		btnModificaciones.setBounds(10, 78, 255, 23);
		frmGimnasio.getContentPane().add(btnModificaciones);
		
		JButton btnNewButton = new JButton("BAJAS");
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.setBorder(new CompoundBorder(new EtchedBorder(EtchedBorder.RAISED, null, null), new BevelBorder(BevelBorder.RAISED, null, null, null, null)));
		btnNewButton.setBounds(10, 112, 255, 23);
		frmGimnasio.getContentPane().add(btnNewButton);
		
		JLabel lblSocios = new JLabel("Actividades");
		lblSocios.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSocios.setBounds(94, 10, 110, 23);
		frmGimnasio.getContentPane().add(lblSocios);
	}
}
