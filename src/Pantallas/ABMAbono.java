package Pantallas;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;

import Controlador.ControladoraABM;

import java.awt.Cursor;

public class ABMAbono {
	ControladoraABM co;
	JFrame frmABMAbono;


	public ABMAbono(ControladoraABM c) {
		co=c;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmABMAbono = new JFrame();
		frmABMAbono.setTitle("Gimnasio");
		frmABMAbono.setBounds(100, 100, 291, 185);
		frmABMAbono.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmABMAbono.getContentPane().setLayout(null);
		
		JButton btnAltas = new JButton("ALTAS");
		btnAltas.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAltas.setBorder(new CompoundBorder(new EtchedBorder(EtchedBorder.RAISED, null, null), new BevelBorder(BevelBorder.RAISED, null, null, null, null)));
		btnAltas.setForeground(Color.BLACK);
		btnAltas.setBounds(10, 44, 255, 23);
		btnAltas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AltaAbono aa = new AltaAbono(co);
				aa.frmAltaAbono.setVisible(true);
			}
		});
		frmABMAbono.getContentPane().add(btnAltas);
		
		JButton btnBajas = new JButton("BAJAS");
		btnBajas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BajaAbono ba = new BajaAbono(co);
				ba.frmBajaAbono.setVisible(true);
			}
		});
		
		btnBajas.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnBajas.setBorder(new CompoundBorder(new EtchedBorder(EtchedBorder.RAISED, null, null), new BevelBorder(BevelBorder.RAISED, null, null, null, null)));
		btnBajas.setBounds(10, 78, 255, 23);
		frmABMAbono.getContentPane().add(btnBajas);
		
		JButton btnAgregar = new JButton("AGREGAR ACTIVIDAD");
		btnAgregar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAgregar.setBorder(new CompoundBorder(new EtchedBorder(EtchedBorder.RAISED, null, null), new BevelBorder(BevelBorder.RAISED, null, null, null, null)));
		btnAgregar.setBounds(10, 112, 255, 23);
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AgregarActividadAbono aaa = new AgregarActividadAbono(co);
				aaa.frmAgregarActividadAbono.setVisible(true);
			}
		});
		frmABMAbono.getContentPane().add(btnAgregar);
		
		JLabel lblSocios = new JLabel("Abonos");
		lblSocios.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSocios.setBounds(113, 11, 110, 23);
		frmABMAbono.getContentPane().add(lblSocios);
	}
}
