package Pantallas;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Cursor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;

import Controlador.ControladoraABM;
import Excepciones.AbonoException;
import Excepciones.ActividadException;
import Excepciones.ConnectionException;
import Excepciones.HorarioException;

public class AgregarActividadAbono {
	ControladoraABM co;
	JFrame frmAgregarActividadAbono;
	private JTextField textCodigoAbono;
	private JTextField textCodigoA;
	private JTextField textHI;
	private JTextField textHF;

	public AgregarActividadAbono(ControladoraABM c) {
		co=c;
		initialize();
	}

	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void initialize() {
		frmAgregarActividadAbono = new JFrame();
		frmAgregarActividadAbono.setTitle("Abono");
		frmAgregarActividadAbono.setBounds(100, 100, 295, 266);
		frmAgregarActividadAbono.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmAgregarActividadAbono.getContentPane().setLayout(null);
		
		JLabel lblAgregarActividad = new JLabel("Agregar Actividad");
		lblAgregarActividad.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAgregarActividad.setBounds(69, 11, 141, 37);
		frmAgregarActividadAbono.getContentPane().add(lblAgregarActividad);
		
		JLabel lblCodigo = new JLabel("Codigo");
		lblCodigo.setBounds(10, 62, 46, 14);
		frmAgregarActividadAbono.getContentPane().add(lblCodigo);
		
		JLabel lblCodigoActividad = new JLabel("Codigo Actividad");
		lblCodigoActividad.setBounds(10, 87, 140, 14);
		frmAgregarActividadAbono.getContentPane().add(lblCodigoActividad);
		
		JLabel lblHoraInicio = new JLabel("Hora Inicio");
		lblHoraInicio.setBounds(10, 112, 80, 14);
		frmAgregarActividadAbono.getContentPane().add(lblHoraInicio);
		
		JLabel lblHoraFin = new JLabel("Hora Fin");
		lblHoraFin.setBounds(10, 137, 46, 14);
		frmAgregarActividadAbono.getContentPane().add(lblHoraFin);
		
		textCodigoAbono = new JTextField();
		textCodigoAbono.setBounds(116, 59, 141, 20);
		frmAgregarActividadAbono.getContentPane().add(textCodigoAbono);
		textCodigoAbono.setColumns(10);
		
		textCodigoA = new JTextField();
		textCodigoA.setBounds(116, 84, 141, 20);
		frmAgregarActividadAbono.getContentPane().add(textCodigoA);
		textCodigoA.setColumns(10);
		
		textHI = new JTextField();
		textHI.setBounds(116, 109, 141, 20);
		frmAgregarActividadAbono.getContentPane().add(textHI);
		textHI.setColumns(10);
		
		textHF = new JTextField();
		textHF.setBounds(116, 134, 141, 20);
		frmAgregarActividadAbono.getContentPane().add(textHF);
		textHF.setColumns(10);
		
		JButton btnCancelar = new JButton("CANCELAR");
		btnCancelar.setBorder(new CompoundBorder(new EtchedBorder(EtchedBorder.RAISED, null, null), new BevelBorder(BevelBorder.RAISED, null, null, null, null)));
		btnCancelar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmAgregarActividadAbono.dispose();
			}
		});
		btnCancelar.setBounds(10, 193, 89, 23);
		frmAgregarActividadAbono.getContentPane().add(btnCancelar);
		
		JLabel lblDia = new JLabel("Dia");
		lblDia.setBounds(10, 162, 46, 14);
		frmAgregarActividadAbono.getContentPane().add(lblDia);
		
		JComboBox dia = new JComboBox();
		dia.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		dia.setModel(new DefaultComboBoxModel(new String[] {"Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado"}));
		dia.setToolTipText("");
		dia.setBounds(116, 159, 141, 20);
		frmAgregarActividadAbono.getContentPane().add(dia);
		
		JButton btnAceptar = new JButton("ACEPTAR");
		btnAceptar.setBorder(new CompoundBorder(new EtchedBorder(EtchedBorder.RAISED, null, null), new BevelBorder(BevelBorder.RAISED, null, null, null, null)));
		btnAceptar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAceptar.setBounds(180, 193, 89, 23);
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					try {
						co.cargarActividadAbono(Integer.parseInt(textCodigoAbono.getText()), Integer.parseInt(textCodigoA.getText()), textHI.getText(), textHF.getText(), dia.getSelectedItem().toString());
						textCodigoAbono.setText("");
						textCodigoA.setText("");
						textHI.setText("");
						textHF.setText("");
						dia.setSelectedIndex(0);
					} catch (NumberFormatException | ActividadException | HorarioException | AbonoException
							| ConnectionException e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage());
					}
					
				
			
			}
		});
		frmAgregarActividadAbono.getContentPane().add(btnAceptar);
	}

}
