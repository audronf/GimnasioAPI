package Pantallas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;

import java.awt.event.ActionEvent;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import Controlador.ControladoraABM;

import javax.swing.border.BevelBorder;
import java.awt.Cursor;
import java.awt.Color;

public class MenuPrincipal {

	private JFrame frmGimnasio;
	private ControladoraABM controladora;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {	
					MenuPrincipal window = new MenuPrincipal();
					window.frmGimnasio.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public MenuPrincipal() {
		controladora = ControladoraABM.getInstance();
		initialize();
	}

	private void initialize() {
		frmGimnasio = new JFrame();
		frmGimnasio.setBackground(Color.WHITE);
		frmGimnasio.setForeground(Color.LIGHT_GRAY);
		frmGimnasio.setTitle("Gimnasio");
		frmGimnasio.setBounds(100, 100, 450, 419);
		frmGimnasio.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGimnasio.getContentPane().setLayout(null);
		
		JLabel lblGimnasio = new JLabel("Gimnasio");
		lblGimnasio.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblGimnasio.setBounds(179, 11, 140, 41);
		frmGimnasio.getContentPane().add(lblGimnasio);
		
		JButton btnABMSocios = new JButton("SOCIOS");
		btnABMSocios.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnABMSocios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ABMSocio as = new ABMSocio(controladora);
				as.frmABMSocio.setVisible(true);
			}
		});
		btnABMSocios.setBorder(new CompoundBorder(new EtchedBorder(EtchedBorder.RAISED, null, null), new BevelBorder(BevelBorder.RAISED, null, null, null, null)));
		btnABMSocios.setBounds(10, 70, 414, 23);
		frmGimnasio.getContentPane().add(btnABMSocios);
		
		JButton btnABMProfesores = new JButton("PROFESORES");
		btnABMProfesores.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnABMProfesores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ABMProfesor ap = new ABMProfesor(controladora);
				ap.frmABMProfesor.setVisible(true);
			}
		});
		btnABMProfesores.setBorder(new CompoundBorder(new EtchedBorder(EtchedBorder.RAISED, null, null), new BevelBorder(BevelBorder.RAISED, null, null, null, null)));
		btnABMProfesores.setBounds(10, 104, 414, 23);
		frmGimnasio.getContentPane().add(btnABMProfesores);
		
		JButton btnABMEmpleados = new JButton("EMPLEADOS");
		btnABMEmpleados.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnABMEmpleados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ABMEmpleado ae = new ABMEmpleado(controladora);
				ae.frmABMEmpleado.setVisible(true);
			}
		});
		btnABMEmpleados.setBorder(new CompoundBorder(new EtchedBorder(EtchedBorder.RAISED, null, null), new BevelBorder(BevelBorder.RAISED, null, null, null, null)));
		btnABMEmpleados.setBounds(10, 138, 414, 23);
		frmGimnasio.getContentPane().add(btnABMEmpleados);
		
		JButton btnNewButton_3 = new JButton("DEPORTES");
		btnNewButton_3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_3.setBorder(new CompoundBorder(new EtchedBorder(EtchedBorder.RAISED, null, null), new BevelBorder(BevelBorder.RAISED, null, null, null, null)));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ABMDeporte ad = new ABMDeporte(controladora);
				ad.frmABMDeporte.setVisible(true);
			}
		});
		btnNewButton_3.setBounds(10, 172, 414, 23);
		frmGimnasio.getContentPane().add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("ABONOS");
		btnNewButton_4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ABMAbono aa = new ABMAbono(controladora);
				aa.frmABMAbono.setVisible(true);
			}
		});
		btnNewButton_4.setBorder(new CompoundBorder(new EtchedBorder(EtchedBorder.RAISED, null, null), new BevelBorder(BevelBorder.RAISED, null, null, null, null)));
		btnNewButton_4.setBounds(10, 206, 414, 23);
		frmGimnasio.getContentPane().add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("INSCRIPCIONES");
		btnNewButton_5.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_5.setBorder(new CompoundBorder(new EtchedBorder(EtchedBorder.RAISED, null, null), new BevelBorder(BevelBorder.RAISED, null, null, null, null)));
		btnNewButton_5.setBounds(10, 240, 414, 23);
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InscripcionP I = new InscripcionP(controladora);
				I.frmInscripcionP.setVisible(true);
			}
		});
		frmGimnasio.getContentPane().add(btnNewButton_5);
		
		JButton btnValidarIngreso = new JButton("VALIDAR INGRESO");
		btnValidarIngreso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ValidarIngreso vi = new ValidarIngreso(controladora);
				vi.frmValidarIngreso.setVisible(true);
			}
		});
		btnValidarIngreso.setBorder(new CompoundBorder(new EtchedBorder(EtchedBorder.RAISED, null, null), new BevelBorder(BevelBorder.RAISED, null, null, null, null)));
		btnValidarIngreso.setBounds(10, 274, 414, 23);
		frmGimnasio.getContentPane().add(btnValidarIngreso);
		
		JButton btnCronograma = new JButton("CRONOGRAMA");
		btnCronograma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Cronogramas cr = new Cronogramas(controladora);
                cr.frmCronogramas.setVisible(true);
			}
		});
		btnCronograma.setBorder(new CompoundBorder(new EtchedBorder(EtchedBorder.RAISED, null, null), new BevelBorder(BevelBorder.RAISED, null, null, null, null)));
		btnCronograma.setBounds(10, 308, 414, 23);
		frmGimnasio.getContentPane().add(btnCronograma);
		
		JButton btnNotificaciones = new JButton("ENVIO DE MAILS");
		btnNotificaciones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Mails ma = new Mails(controladora);
                ma.frmMails.setVisible(true);
			}
		});
		btnNotificaciones.setBorder(new CompoundBorder(new EtchedBorder(EtchedBorder.RAISED, null, null), new BevelBorder(BevelBorder.RAISED, null, null, null, null)));
		btnNotificaciones.setBounds(10, 342, 414, 23);
		frmGimnasio.getContentPane().add(btnNotificaciones);
	}
}
