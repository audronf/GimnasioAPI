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

public class InscripcionP {
	ControladoraABM co;
	JFrame frmInscripcionP;


	public InscripcionP(ControladoraABM c) {
		co=c;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmInscripcionP = new JFrame();
		frmInscripcionP.setTitle("Gimnasio");
		frmInscripcionP.setBounds(100, 100, 291, 254);
		frmInscripcionP.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmInscripcionP.getContentPane().setLayout(null);
		
		JButton btnAltas = new JButton("ABRIR");
		btnAltas.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAltas.setBorder(new CompoundBorder(new EtchedBorder(EtchedBorder.RAISED, null, null), new BevelBorder(BevelBorder.RAISED, null, null, null, null)));
		btnAltas.setForeground(Color.BLACK);
		btnAltas.setBounds(10, 44, 255, 23);
		btnAltas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AbrirInscripcion ai = new AbrirInscripcion(co);
				ai.frmInscripcion.setVisible(true);
			}
		});
		frmInscripcionP.getContentPane().add(btnAltas);
		
		JButton agregarAbono = new JButton("AGREGAR ABONO");
		agregarAbono.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		agregarAbono.setBorder(new CompoundBorder(new EtchedBorder(EtchedBorder.RAISED, null, null), new BevelBorder(BevelBorder.RAISED, null, null, null, null)));
		agregarAbono.setBounds(10, 78, 255, 23);
		agregarAbono.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AgregarAbonoI aai = new AgregarAbonoI(co);
				aai.frmAgregarAbonoI.setVisible(true);
			}
		});
		frmInscripcionP.getContentPane().add(agregarAbono);
		
		JButton agregarActividades = new JButton("AGREGAR ACTIVIDADES");
		agregarActividades.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		agregarActividades.setBorder(new CompoundBorder(new EtchedBorder(EtchedBorder.RAISED, null, null), new BevelBorder(BevelBorder.RAISED, null, null, null, null)));
		agregarActividades.setBounds(10, 112, 255, 23);
		agregarActividades.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AgregarActividadI aai = new AgregarActividadI(co);
				aai.frmAgregarActividad.setVisible(true);
			}
		});
		frmInscripcionP.getContentPane().add(agregarActividades);
		
		JButton precio = new JButton("CALCULAR PRECIO");
		precio.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		precio.setBorder(new CompoundBorder(new EtchedBorder(EtchedBorder.RAISED, null, null), new BevelBorder(BevelBorder.RAISED, null, null, null, null)));
		precio.setBounds(10, 146, 255, 23);
		precio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CalcularPrecio cp = new CalcularPrecio(co);
				cp.frmPrecio.setVisible(true);
			}
		});	
		
		
		JButton btnBajaIns = new JButton("BAJA");
		btnBajaIns.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnBajaIns.setBorder(new CompoundBorder(new EtchedBorder(EtchedBorder.RAISED, null, null), new BevelBorder(BevelBorder.RAISED, null, null, null, null)));
		btnBajaIns.setBounds(10, 180, 255, 23);
		frmInscripcionP.getContentPane().add(btnBajaIns);
		btnBajaIns.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				BajaInscripcion bi = new BajaInscripcion(co);
				bi.frmBajaIns.setVisible(true);
			}
		});	
		
		frmInscripcionP.getContentPane().add(precio);
		JLabel lblSocios = new JLabel("Inscripcion");
		lblSocios.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSocios.setBounds(101, 10, 110, 23);
		frmInscripcionP.getContentPane().add(lblSocios);
		

	}
}
