package Pantallas;
 
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SpinnerNumberModel;

import Controlador.ControladoraABM;
import Excepciones.ActividadException;
import Excepciones.ConnectionException;
import Excepciones.HorarioException;
import Excepciones.InscripcionException;
import Excepciones.SocioException;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
 
public class AgregarActividadI {
	ControladoraABM co;
    JFrame frmAgregarActividad;
    private JTextField textCodigoIns;
    private JTextField textCodigoAct;
 
    public AgregarActividadI(ControladoraABM c) {
    	co=c;
        initialize();
    }
 
    @SuppressWarnings({ "unchecked", "rawtypes" })
	private void initialize() {
        frmAgregarActividad = new JFrame();
        frmAgregarActividad.setTitle("Inscripcion");
        frmAgregarActividad.setBounds(100, 100, 290, 275);
        frmAgregarActividad.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frmAgregarActividad.getContentPane().setLayout(null);
       
        JLabel lblCodigoActividad = new JLabel("Codigo Actividad");
        lblCodigoActividad.setBounds(10, 85, 135, 14);
        frmAgregarActividad.getContentPane().add(lblCodigoActividad);
       
        JLabel lblCodigoInscripcion = new JLabel("Codigo Inscripcion");
        lblCodigoInscripcion.setBounds(10, 60, 135, 14);
        frmAgregarActividad.getContentPane().add(lblCodigoInscripcion);
       
        JLabel lblHoraInicio = new JLabel("Hora Inicio");
        lblHoraInicio.setBounds(10, 110, 74, 14);
        frmAgregarActividad.getContentPane().add(lblHoraInicio);
       
        JLabel lblHoraFin = new JLabel("Hora Fin");
        lblHoraFin.setBounds(10, 135, 46, 14);
        frmAgregarActividad.getContentPane().add(lblHoraFin);
       
        JLabel lblDia = new JLabel("Dia");
        lblDia.setBounds(10, 160, 46, 14);
        frmAgregarActividad.getContentPane().add(lblDia);
       
        JLabel lblAgregarActividad = new JLabel("Agregar Actividad");
        lblAgregarActividad.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblAgregarActividad.setBounds(71, 11, 143, 27);
        frmAgregarActividad.getContentPane().add(lblAgregarActividad);
       
        JSpinner HI = new JSpinner();
        HI.setModel(new SpinnerNumberModel(0, 0, 23, 1));
        HI.setBounds(130, 107, 46, 20);
        frmAgregarActividad.getContentPane().add(HI);
       
        textCodigoIns = new JTextField();
        textCodigoIns.setBounds(130, 57, 123, 20);
        frmAgregarActividad.getContentPane().add(textCodigoIns);
        textCodigoIns.setColumns(10);
       
        textCodigoAct = new JTextField();
        textCodigoAct.setBounds(130, 82, 123, 20);
        frmAgregarActividad.getContentPane().add(textCodigoAct);
        textCodigoAct.setColumns(10);
       
        JSpinner HF = new JSpinner();
        HF.setModel(new SpinnerNumberModel(0, 0, 23, 1));
        HF.setBounds(130, 132, 46, 20);
        frmAgregarActividad.getContentPane().add(HF);
       
        JComboBox dia = new JComboBox();
        dia.setModel(new DefaultComboBoxModel(new String[] {"Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado"}));
        dia.setBounds(130, 157, 84, 20);
        frmAgregarActividad.getContentPane().add(dia);
       
        JButton btnCancelar = new JButton("CANCELAR");
        btnCancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	frmAgregarActividad.dispose();
            }
        });
        btnCancelar.setBounds(10, 202, 89, 23);
        frmAgregarActividad.getContentPane().add(btnCancelar);
       
        JButton btnAceptar = new JButton("ACEPTAR");
        btnAceptar.setBounds(164, 202, 89, 23);
        btnAceptar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
					try {
						co.cargarActividadInscripcion(Integer.parseInt(textCodigoIns.getText()), Integer.parseInt(textCodigoAct.getText()), HI.getValue().toString(), HF.getValue().toString(), dia.getSelectedItem().toString());
						textCodigoIns.setText("");
						textCodigoAct.setText("");
						HI.setValue(0);
						HF.setValue(0);
						dia.setSelectedIndex(0);
					} catch (NumberFormatException | ActividadException | HorarioException | InscripcionException
							| ConnectionException | SocioException e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage());
					}
            
			
			}
            
        });
        frmAgregarActividad.getContentPane().add(btnAceptar);
    }
 
}