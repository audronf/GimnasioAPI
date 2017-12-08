package Pantallas;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;

import Clases.EmpleadoView;
import Controlador.ControladoraABM;
import Excepciones.ConnectionException;
import Excepciones.EmpleadoException;
import javax.swing.border.BevelBorder;
import java.awt.Cursor;

public class AltaEmpleado {

	JFrame frmAltaEmpleado;
	ControladoraABM co;
	EmpleadoView v;
	private JTextField textNombre;
	private JTextField textDni;
	private JTextField textEmail;
	private JTextField textDomicilio;
	private JTextField textTelefono;
	private JTextField textSueldo;
	private JTextField textPuesto;
	private JTextField textRetenciones;
	private JTextField textDeducciones;
	
	public AltaEmpleado(ControladoraABM c) {
		co=c;
		initialize();
	}

	private void initialize() {
		frmAltaEmpleado = new JFrame();
		frmAltaEmpleado.setTitle("Empleado");
		frmAltaEmpleado.setBounds(100, 100, 275, 352);
		frmAltaEmpleado.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmAltaEmpleado.getContentPane().setLayout(null);
		
		JLabel lblAlta = new JLabel("Alta");
		lblAlta.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAlta.setBounds(109, 11, 56, 20);
		frmAltaEmpleado.getContentPane().add(lblAlta);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(10, 45, 46, 14);
		frmAltaEmpleado.getContentPane().add(lblNombre);
		
		JLabel lblDni = new JLabel("D.N.I");
		lblDni.setBounds(10, 70, 46, 14);
		frmAltaEmpleado.getContentPane().add(lblDni);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(10, 95, 46, 14);
		frmAltaEmpleado.getContentPane().add(lblEmail);
		
		JLabel lblNewLabel = new JLabel("Domicilio");
		lblNewLabel.setBounds(10, 120, 60, 14);
		frmAltaEmpleado.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Telefono");
		lblNewLabel_1.setBounds(10, 145, 60, 14);
		frmAltaEmpleado.getContentPane().add(lblNewLabel_1);
		
		textNombre = new JTextField();
		textNombre.setBounds(99, 42, 150, 20);
		frmAltaEmpleado.getContentPane().add(textNombre);
		textNombre.setColumns(10);
		
		textDni = new JTextField();
		textDni.setBounds(99, 67, 150, 20);
		frmAltaEmpleado.getContentPane().add(textDni);
		textDni.setColumns(10);
		
		textEmail = new JTextField();
		textEmail.setBounds(99, 92, 150, 20);
		frmAltaEmpleado.getContentPane().add(textEmail);
		textEmail.setColumns(10);
		
		textDomicilio = new JTextField();
		textDomicilio.setBounds(99, 117, 150, 20);
		frmAltaEmpleado.getContentPane().add(textDomicilio);
		textDomicilio.setColumns(10);
		
		textTelefono = new JTextField();
		textTelefono.setBounds(99, 142, 150, 20);
		frmAltaEmpleado.getContentPane().add(textTelefono);
		textTelefono.setColumns(10);
		
		JLabel lblSueldo = new JLabel("Sueldo");
		lblSueldo.setBounds(10, 170, 89, 14);
		frmAltaEmpleado.getContentPane().add(lblSueldo);
		
		textSueldo = new JTextField();
		textSueldo.setBounds(99, 167, 150, 20);
		frmAltaEmpleado.getContentPane().add(textSueldo);
		textSueldo.setColumns(10);
		JLabel lblPuesto = new JLabel("Puesto");
		lblPuesto.setBounds(10, 195, 46, 14);
		frmAltaEmpleado.getContentPane().add(lblPuesto);
		
		textPuesto = new JTextField();
		textPuesto.setBounds(99, 192, 150, 20);
		frmAltaEmpleado.getContentPane().add(textPuesto);
		textPuesto.setColumns(10);
		
		JLabel lblRetenciones = new JLabel("Retenciones");
		lblRetenciones.setBounds(10, 220, 179, 14);
		frmAltaEmpleado.getContentPane().add(lblRetenciones);
		
		JLabel lblDeducciones = new JLabel("Deducciones");
		lblDeducciones.setBounds(10, 245, 121, 14);
		frmAltaEmpleado.getContentPane().add(lblDeducciones);
		
		textRetenciones = new JTextField();
		textRetenciones.setBounds(99, 217, 150, 20);
		frmAltaEmpleado.getContentPane().add(textRetenciones);
		textRetenciones.setColumns(10);
		
		textDeducciones = new JTextField();
		textDeducciones.setBounds(99, 242, 150, 20);
		frmAltaEmpleado.getContentPane().add(textDeducciones);
		textDeducciones.setColumns(10);
		JButton button = new JButton("CANCELAR");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmAltaEmpleado.dispose();
			}
		});
		button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button.setBorder(new CompoundBorder(new EtchedBorder(EtchedBorder.RAISED, null, null), new BevelBorder(BevelBorder.RAISED, null, null, null, null)));
		button.setBounds(10, 279, 89, 23);
		frmAltaEmpleado.getContentPane().add(button);
		
		JButton btnAceptar = new JButton("ACEPTAR");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					try {
						co.altaEmpleado(textNombre.getText(), textDni.getText(), textDomicilio.getText(), textTelefono.getText(), textEmail.getText(), textPuesto.getText(), Double.parseDouble(textSueldo.getText()), Double.parseDouble(textRetenciones.getText()), Double.parseDouble(textDeducciones.getText()));
						textNombre.setText("");
						textEmail.setText("");
						textDni.setText("");
						textSueldo.setText("");
						textPuesto.setText("");
						textDomicilio.setText("");
						textTelefono.setText("");
						textRetenciones.setText("");
						textDeducciones.setText("");
					}catch(EmpleadoException | ConnectionException e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage());
					}
				
			}
		});
		btnAceptar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAceptar.setBorder(new CompoundBorder(new EtchedBorder(EtchedBorder.RAISED, null, null), new BevelBorder(BevelBorder.RAISED, null, null, null, null)));
		btnAceptar.setBounds(160, 279, 89, 23);
		frmAltaEmpleado.getContentPane().add(btnAceptar);
		

		
	}
}



