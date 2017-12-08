package Pantallas;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;

import Controlador.ControladoraABM;
import Excepciones.ActividadException;
import Excepciones.ConnectionException;
import Excepciones.HorarioException;

public class QuitarHorarioActividad {
	ControladoraABM co;
	JFrame frmQuitarHorarioActividad;
	private JTextField textCodigoActividad;


	public QuitarHorarioActividad(ControladoraABM c) {
		co=c;
		initialize();
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void initialize() {
		frmQuitarHorarioActividad = new JFrame();
		frmQuitarHorarioActividad.setTitle("Actividad");
		frmQuitarHorarioActividad.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmQuitarHorarioActividad.setBounds(100, 100, 254, 247);
		frmQuitarHorarioActividad.getContentPane().setLayout(null);
		
		JLabel lblCodigoActividad = new JLabel("Codigo Actividad");
		lblCodigoActividad.setBounds(10, 57, 101, 14);
		frmQuitarHorarioActividad.getContentPane().add(lblCodigoActividad);
		
		JLabel lblHoraInicio = new JLabel("Hora Inicio");
		lblHoraInicio.setBounds(10, 82, 90, 14);
		frmQuitarHorarioActividad.getContentPane().add(lblHoraInicio);
		
		JLabel lblHoraFin = new JLabel("Hora Fin");
		lblHoraFin.setBounds(10, 107, 72, 14);
		frmQuitarHorarioActividad.getContentPane().add(lblHoraFin);
		
		JLabel lblDia = new JLabel("Dia");
		lblDia.setBounds(10, 132, 46, 14);
		frmQuitarHorarioActividad.getContentPane().add(lblDia);
		
		JSpinner horaInicio = new JSpinner();
		horaInicio.setModel(new SpinnerNumberModel(0, 0, 23, 1));
		horaInicio.setBounds(113, 79, 43, 20);
		frmQuitarHorarioActividad.getContentPane().add(horaInicio);
		
		JSpinner horaFin = new JSpinner();
		horaFin.setModel(new SpinnerNumberModel(0, 0, 23, 1));
		horaFin.setBounds(113, 104, 43, 20);
		frmQuitarHorarioActividad.getContentPane().add(horaFin);
		
		JComboBox dia = new JComboBox();
		dia.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		dia.setModel(new DefaultComboBoxModel(new String[] {"Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado"}));
		dia.setBounds(113, 129, 86, 20);
		frmQuitarHorarioActividad.getContentPane().add(dia);
		
		textCodigoActividad = new JTextField();
		textCodigoActividad.setBounds(113, 54, 86, 20);
		frmQuitarHorarioActividad.getContentPane().add(textCodigoActividad);
		textCodigoActividad.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Quitar Horario");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(51, 11, 148, 20);
		frmQuitarHorarioActividad.getContentPane().add(lblNewLabel);
		
		JButton btnCancelar = new JButton("CANCELAR");
		btnCancelar.setBorder(new CompoundBorder(new EtchedBorder(EtchedBorder.RAISED, null, null), new BevelBorder(BevelBorder.RAISED, null, null, null, null)));
		btnCancelar.setBounds(11, 174, 89, 23);
		frmQuitarHorarioActividad.getContentPane().add(btnCancelar);
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmQuitarHorarioActividad.dispose();
			}
		});
		
		JButton btnAceptar = new JButton("ACEPTAR");
		btnAceptar.setBorder(new CompoundBorder(new EtchedBorder(EtchedBorder.RAISED, null, null), new BevelBorder(BevelBorder.RAISED, null, null, null, null)));
		btnAceptar.setBounds(139, 174, 89, 23);
		frmQuitarHorarioActividad.getContentPane().add(btnAceptar);
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					co.quitarHorario(Integer.parseInt(textCodigoActividad.getText()), (horaInicio.getValue()).toString(), horaFin.getValue().toString(), dia.getSelectedItem().toString());
					textCodigoActividad.setText("");
					horaInicio.setValue(0);
					horaFin.setValue(0);
					dia.setSelectedIndex(0);
				} catch (NumberFormatException | ActividadException | HorarioException | ConnectionException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
				
				
	}
		});
	}
}
