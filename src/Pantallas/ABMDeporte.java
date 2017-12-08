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

public class ABMDeporte {

	JFrame frmABMDeporte;
	ControladoraABM co;
	/**
	 * Launch the application.
	 */


	/**
	 * Create the application.
	 */
	public ABMDeporte(ControladoraABM c) {
		co=c;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmABMDeporte = new JFrame();
		frmABMDeporte.setTitle("Gimnasio");
		frmABMDeporte.setBounds(100, 100, 291, 296);
		frmABMDeporte.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmABMDeporte.getContentPane().setLayout(null);
		
		JButton btnAltas = new JButton("ALTAS");
		btnAltas.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAltas.setBorder(new CompoundBorder(new EtchedBorder(EtchedBorder.RAISED, null, null), new BevelBorder(BevelBorder.RAISED, null, null, null, null)));
		btnAltas.setForeground(Color.BLACK);
		btnAltas.setBounds(10, 44, 255, 23);
		frmABMDeporte.getContentPane().add(btnAltas);
		btnAltas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AltaDeporte ad = new AltaDeporte(co);
				ad.frmAltaDeporte.setVisible(true);
			}
		});
		JButton btnModificaciones = new JButton("MODIFICACIONES");
		btnModificaciones.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnModificaciones.setBorder(new CompoundBorder(new EtchedBorder(EtchedBorder.RAISED, null, null), new BevelBorder(BevelBorder.RAISED, null, null, null, null)));
		btnModificaciones.setBounds(10, 78, 255, 23);
		btnModificaciones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ModificarDeporte md = new ModificarDeporte(co);
				md.frmModificarDeporte.setVisible(true);
			}
		});
		frmABMDeporte.getContentPane().add(btnModificaciones);
		
		JButton btnBajas = new JButton("BAJAS");
		btnBajas.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnBajas.setBorder(new CompoundBorder(new EtchedBorder(EtchedBorder.RAISED, null, null), new BevelBorder(BevelBorder.RAISED, null, null, null, null)));
		btnBajas.setBounds(10, 112, 255, 23);
		frmABMDeporte.getContentPane().add(btnBajas);
		btnBajas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				BajaDeporte bd = new BajaDeporte(co);
				bd.frmBajaDeporte.setVisible(true);
			}
		});
		
		JButton btnAltaActividades = new JButton("ALTA ACTIVIDADES");
		btnAltaActividades.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AltaActividad aa = new AltaActividad(co);
				aa.frmAltaActividad.setVisible(true);
			}
		});
		btnAltaActividades.setBorder(new CompoundBorder(new EtchedBorder(EtchedBorder.RAISED, null, null), new BevelBorder(BevelBorder.RAISED, null, null, null, null)));
		btnAltaActividades.setBounds(10, 146, 255, 23);
		frmABMDeporte.getContentPane().add(btnAltaActividades);
		
		JButton btnAgregarHorarioActividad = new JButton("AGREGAR HORARIO ACTIVIDAD");
		btnAgregarHorarioActividad.setBorder(new CompoundBorder(new EtchedBorder(EtchedBorder.RAISED, null, null), new BevelBorder(BevelBorder.RAISED, null, null, null, null)));
		btnAgregarHorarioActividad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AgregarHorarioActividad aha = new AgregarHorarioActividad(co);
				aha.frmAgregarHorarioActividad.setVisible(true);
			}
		});
		btnAgregarHorarioActividad.setBounds(10, 182, 255, 23);
		frmABMDeporte.getContentPane().add(btnAgregarHorarioActividad);
		
		JButton btnQuitarHorario = new JButton("QUITAR HORARIO ACTIVIDAD");
		btnQuitarHorario.setBorder(new CompoundBorder(new EtchedBorder(EtchedBorder.RAISED, null, null), new BevelBorder(BevelBorder.RAISED, null, null, null, null)));
		btnQuitarHorario.setBounds(10, 216, 255, 23);
		btnQuitarHorario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				QuitarHorarioActividad qha = new QuitarHorarioActividad(co);
				qha.frmQuitarHorarioActividad.setVisible(true);
				
			}
		});
		frmABMDeporte.getContentPane().add(btnQuitarHorario);
		
		JLabel lblSocios = new JLabel("Deportes");
		lblSocios.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSocios.setBounds(101, 10, 110, 23);
		frmABMDeporte.getContentPane().add(lblSocios);
		JButton btnAgregarProfesor = new JButton("AGREGAR PROFESOR ACTIVIDAD");
		  btnAgregarProfesor.addActionListener(new ActionListener() {
		   public void actionPerformed(ActionEvent e) {
				AgregarProfesorActividad apa = new AgregarProfesorActividad(co);
				apa.frmAgregarProfesorActividad.setVisible(true);
		   }
		  });
		  btnAgregarProfesor.setBorder(new CompoundBorder(new EtchedBorder(EtchedBorder.RAISED, null, null), new BevelBorder(BevelBorder.RAISED, null, null, null, null)));
		  btnAgregarProfesor.setBounds(10, 250, 255, 23);
		  frmABMDeporte.getContentPane().add(btnAgregarProfesor);
		frmABMDeporte.setBounds(100, 100, 291, 329);
	}
}
