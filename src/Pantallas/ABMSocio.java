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

public class ABMSocio {

	JFrame frmABMSocio;
	private ControladoraABM co;
	/**
	 * Launch the application.
	 */


	/**
	 * Create the application.
	 */
	public ABMSocio(ControladoraABM c) {
		co=c;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmABMSocio = new JFrame();
		frmABMSocio.setTitle("Gimnasio");
		frmABMSocio.getContentPane().setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		frmABMSocio.setBounds(100, 100, 290, 216);
		frmABMSocio.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmABMSocio.getContentPane().setLayout(null);
		
		JButton btnAltas = new JButton("ALTAS");
		btnAltas.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAltas.setBorder(new CompoundBorder(new EtchedBorder(EtchedBorder.RAISED, null, null), new BevelBorder(BevelBorder.RAISED, null, null, null, null)));
		btnAltas.setForeground(Color.BLACK);
		btnAltas.setBounds(10, 44, 255, 23);
		frmABMSocio.getContentPane().add(btnAltas);
		btnAltas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AltaSocio as = new AltaSocio(co);
				as.frmAltaSocio.setVisible(true);
			}
		});
		
		JButton btnModificaciones = new JButton("MODIFICACIONES");
		btnModificaciones.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnModificaciones.setBorder(new CompoundBorder(new EtchedBorder(EtchedBorder.RAISED, null, null), new BevelBorder(BevelBorder.RAISED, null, null, null, null)));
		btnModificaciones.setBounds(10, 78, 255, 23);
		frmABMSocio.getContentPane().add(btnModificaciones);
		btnModificaciones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ModificarSocio ms = new ModificarSocio(co);
				ms.frmModificarSocio.setVisible(true);
			}
		});
		JButton btnBajas = new JButton("BAJAS");
		btnBajas.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnBajas.setBorder(new CompoundBorder(new EtchedBorder(EtchedBorder.RAISED, null, null), new BevelBorder(BevelBorder.RAISED, null, null, null, null)));
		btnBajas.setBounds(10, 112, 255, 23);
		frmABMSocio.getContentPane().add(btnBajas);
		btnBajas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				BajaSocio bs = new BajaSocio(co);
				bs.frmBajaSocio.setVisible(true);
			}
		});
		JLabel lblSocios = new JLabel("Socios");
		lblSocios.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSocios.setBounds(116, 10, 110, 23);
		frmABMSocio.getContentPane().add(lblSocios);
		
		JButton btnNewButton_1 = new JButton("ACTUALIZAR APTO MEDICO");
		btnNewButton_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_1.setBorder(new CompoundBorder(new EtchedBorder(EtchedBorder.RAISED, null, null), new BevelBorder(BevelBorder.RAISED, null, null, null, null)));
		btnNewButton_1.setBounds(10, 146, 255, 23);
		btnNewButton_1.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			ActualizarAptoMedico aam = new ActualizarAptoMedico(co);
			aam.frmActualizarAptoMedico.setVisible(true);
		}
	});
		frmABMSocio.getContentPane().add(btnNewButton_1);
	}
}
