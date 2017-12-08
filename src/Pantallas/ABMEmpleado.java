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

public class ABMEmpleado {

	JFrame frmABMEmpleado;
	ControladoraABM co;


	public ABMEmpleado(ControladoraABM c) {
		co=c;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmABMEmpleado = new JFrame();
		frmABMEmpleado.setTitle("Gimnasio");
		frmABMEmpleado.setBounds(100, 100, 291, 220);
		frmABMEmpleado.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmABMEmpleado.getContentPane().setLayout(null);
		
		JButton btnAltas = new JButton("ALTAS");
		btnAltas.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAltas.setBorder(new CompoundBorder(new EtchedBorder(EtchedBorder.RAISED, null, null), new BevelBorder(BevelBorder.RAISED, null, null, null, null)));
		btnAltas.setForeground(Color.BLACK);
		btnAltas.setBounds(10, 44, 255, 23);
		btnAltas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AltaEmpleado ae = new AltaEmpleado(co);
				ae.frmAltaEmpleado.setVisible(true);
			}
		});
		frmABMEmpleado.getContentPane().add(btnAltas);
		
		JButton btnModificaciones = new JButton("MODIFICACIONES");
		btnModificaciones.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnModificaciones.setBorder(new CompoundBorder(new EtchedBorder(EtchedBorder.RAISED, null, null), new BevelBorder(BevelBorder.RAISED, null, null, null, null)));
		btnModificaciones.setBounds(10, 78, 255, 23);
		btnModificaciones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ModificarEmpleado me = new ModificarEmpleado(co);
				me.frmModificacionEmpleado.setVisible(true);
			}
		});
		frmABMEmpleado.getContentPane().add(btnModificaciones);
		
		JButton btnBajas = new JButton("BAJAS");
		btnBajas.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnBajas.setBorder(new CompoundBorder(new EtchedBorder(EtchedBorder.RAISED, null, null), new BevelBorder(BevelBorder.RAISED, null, null, null, null)));
		btnBajas.setBounds(10, 112, 255, 23);
		btnBajas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				BajaEmpleado be = new BajaEmpleado(co);
				be.frmBajaEmpleado.setVisible(true);
			}
		});
		frmABMEmpleado.getContentPane().add(btnBajas);
		  JButton btnLiq = new JButton("LIQUIDAR SUELDO");
		  btnLiq.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		  btnLiq.setBorder(new CompoundBorder(new EtchedBorder(EtchedBorder.RAISED, null, null), new BevelBorder(BevelBorder.RAISED, null, null, null, null)));
		  btnLiq.setBounds(10, 146, 255, 23);
		  btnLiq.addActionListener(new ActionListener() {
		   public void actionPerformed(ActionEvent arg0) {
			LiquidarSueldo ls = new LiquidarSueldo(co);
			ls.frmLiq.setVisible(true);
		   }
		  });
		  frmABMEmpleado.getContentPane().add(btnLiq);		
		JLabel lblSocios = new JLabel("Empleados");
		lblSocios.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSocios.setBounds(101, 10, 110, 23);
		frmABMEmpleado.getContentPane().add(lblSocios);
	}
}
