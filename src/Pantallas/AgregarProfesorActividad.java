package Pantallas;
 
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;

import Controlador.ControladoraABM;
import Excepciones.ActividadException;
import Excepciones.ConnectionException;
import Excepciones.DeporteException;
import Excepciones.ProfesorException;

import javax.swing.border.BevelBorder;
 
public class AgregarProfesorActividad {
	 ControladoraABM co;
    JFrame frmAgregarProfesorActividad;
    private JTextField textDNI;
    private JTextField textCodigoActividad;
 
 
    public AgregarProfesorActividad(ControladoraABM c) {
    	co=c;
        initialize();
    }
 
    private void initialize() {
        frmAgregarProfesorActividad = new JFrame();
        frmAgregarProfesorActividad.setTitle("Actividad");
        frmAgregarProfesorActividad.setBounds(100, 100, 259, 193);
        frmAgregarProfesorActividad.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frmAgregarProfesorActividad.getContentPane().setLayout(null);
       
        JLabel lblAgregarProfesor = new JLabel("Agregar Profesor");
        lblAgregarProfesor.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblAgregarProfesor.setBounds(63, 11, 132, 32);
        frmAgregarProfesorActividad.getContentPane().add(lblAgregarProfesor);
       
        JLabel lblDni = new JLabel("D.N.I");
        lblDni.setBounds(10, 64, 46, 14);
        frmAgregarProfesorActividad.getContentPane().add(lblDni);
       
        JLabel lblCodigoActividad = new JLabel("Codigo Actividad");
        lblCodigoActividad.setBounds(10, 89, 110, 14);
        frmAgregarProfesorActividad.getContentPane().add(lblCodigoActividad);
       
        JButton btnCancelar = new JButton("CANCELAR");
        btnCancelar.setBorder(new CompoundBorder(new EtchedBorder(EtchedBorder.RAISED, null, null), new BevelBorder(BevelBorder.RAISED, null, null, null, null)));
        btnCancelar.setBounds(10, 124, 89, 23);
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmAgregarProfesorActividad.dispose();
			}
		});
        frmAgregarProfesorActividad.getContentPane().add(btnCancelar);
       
        JButton btnAceptar = new JButton("ACEPTAR");
        btnAceptar.setBorder(new CompoundBorder(new EtchedBorder(EtchedBorder.RAISED, null, null), new BevelBorder(BevelBorder.RAISED, null, null, null, null)));
        btnAceptar.setBounds(144, 124, 89, 23);
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				try {
					co.agregarProfesor(textDNI.getText(), Integer.parseInt(textCodigoActividad.getText()));
					textDNI.setText("");
					textCodigoActividad.setText("");
				} catch (NumberFormatException | ProfesorException | DeporteException | ActividadException
						| ConnectionException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
				
			
	}
		});
        frmAgregarProfesorActividad.getContentPane().add(btnAceptar);
       
        textDNI = new JTextField();
        textDNI.setBounds(111, 61, 122, 20);
        frmAgregarProfesorActividad.getContentPane().add(textDNI);
        textDNI.setColumns(10);
       
        textCodigoActividad = new JTextField();
        textCodigoActividad.setBounds(111, 86, 122, 20);
        frmAgregarProfesorActividad.getContentPane().add(textCodigoActividad);
        textCodigoActividad.setColumns(10);
    }
 
}