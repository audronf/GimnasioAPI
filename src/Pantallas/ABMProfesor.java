package Pantallas;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;

import Controlador.ControladoraABM;

import java.awt.Cursor;

public class ABMProfesor {

	JFrame frmABMProfesor;
	ControladoraABM co;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 * @wbp.parser.entryPoint
	 */
	public ABMProfesor(ControladoraABM c) {
		co = c;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmABMProfesor = new JFrame();
		frmABMProfesor.setTitle("Gimnasio");
		frmABMProfesor.setBounds(100, 100, 291, 225);
		frmABMProfesor.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmABMProfesor.getContentPane().setLayout(null);
		
		JButton btnAltas = new JButton("ALTAS");
		btnAltas.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAltas.setBorder(new CompoundBorder(new EtchedBorder(EtchedBorder.RAISED, null, null), new BevelBorder(BevelBorder.RAISED, null, null, null, null)));
		btnAltas.setForeground(Color.BLACK);
		btnAltas.setBounds(10, 44, 255, 23);
		frmABMProfesor.getContentPane().add(btnAltas);
		btnAltas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SeleccionProfesorAlta sp = new SeleccionProfesorAlta(co);
				sp.frmSelProfesorA.setVisible(true);
			}
		});
		JButton btnModificaciones = new JButton("MODIFICACIONES");
		btnModificaciones.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnModificaciones.setBorder(new CompoundBorder(new EtchedBorder(EtchedBorder.RAISED, null, null), new BevelBorder(BevelBorder.RAISED, null, null, null, null)));
		btnModificaciones.setBounds(10, 78, 255, 23);
		frmABMProfesor.getContentPane().add(btnModificaciones);
		btnModificaciones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SeleccionProfesorModificar mp = new SeleccionProfesorModificar(co);
				mp.frmSelProfesorM.setVisible(true);
			}
		});
		JButton btnBajas = new JButton("BAJAS");
		btnBajas.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnBajas.setBorder(new CompoundBorder(new EtchedBorder(EtchedBorder.RAISED, null, null), new BevelBorder(BevelBorder.RAISED, null, null, null, null)));
		btnBajas.setBounds(10, 112, 255, 23);
		frmABMProfesor.getContentPane().add(btnBajas);
		frmABMProfesor.getContentPane().add(btnModificaciones);
		btnBajas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SeleccionProfesorBaja bp = new SeleccionProfesorBaja(co);
				bp.frmSelProfesorB.setVisible(true);
			}
		});
		
		JLabel lblSocios = new JLabel("Profesores");
		lblSocios.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSocios.setBounds(99, 10, 93, 23);
		frmABMProfesor.getContentPane().add(lblSocios);
		
		JButton btnLiquidar = new JButton("LIQUIDAR SUELDO PROF COMPLETOS");
		btnLiquidar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnLiquidar.setBorder(new CompoundBorder(new EtchedBorder(EtchedBorder.RAISED, null, null), new BevelBorder(BevelBorder.RAISED, null, null, null, null)));
		btnLiquidar.setBounds(10, 146, 255, 23);
		//frmABMProfesor.getContentPane().add(btnLiquidar);
	}
}