package Pantallas;
 
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
 
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.TitledBorder;
 
import Controlador.ControladoraABM;
import Excepciones.ConnectionException;
import Excepciones.SocioException;

import javax.swing.JButton;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.BevelBorder;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.awt.event.ActionEvent;
 
public class ActualizarAptoMedico {
 
    JFrame frmActualizarAptoMedico;
    ControladoraABM co;
    private JTextField textDni;
    private JTextField textFechaCarga;
    private JTextField textNombreProf;
    private JTextField textFechaVto;
 
    public ActualizarAptoMedico(ControladoraABM c) {
        co=c;
        initialize();
    }
 
    private void initialize() {
        frmActualizarAptoMedico = new JFrame();
        frmActualizarAptoMedico.setTitle("Socio");
        frmActualizarAptoMedico.setBounds(100, 100, 361, 300);
        frmActualizarAptoMedico.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frmActualizarAptoMedico.getContentPane().setLayout(null);
       
        JLabel lblAptoMedico = new JLabel("Apto Medico");
        lblAptoMedico.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblAptoMedico.setBounds(126, 11, 101, 25);
        frmActualizarAptoMedico.getContentPane().add(lblAptoMedico);
       
        JLabel lblFechaCarga = new JLabel("Fecha Carga");
        lblFechaCarga.setBounds(10, 77, 88, 14);
        frmActualizarAptoMedico.getContentPane().add(lblFechaCarga);
       
        JLabel lblDni = new JLabel("D.N.I");
        lblDni.setBounds(10, 52, 57, 14);
        frmActualizarAptoMedico.getContentPane().add(lblDni);
       
        JLabel lblNombreProfesional = new JLabel("Nombre Profesional");
        lblNombreProfesional.setBounds(10, 102, 117, 14);
        frmActualizarAptoMedico.getContentPane().add(lblNombreProfesional);
       
        JLabel lblVencimiento = new JLabel("Fecha Vencimiento");
        lblVencimiento.setBounds(10, 127, 117, 14);
        frmActualizarAptoMedico.getContentPane().add(lblVencimiento);
       
        JLabel lblObservaciones = new JLabel("Observaciones");
        lblObservaciones.setBounds(10, 152, 101, 14);
        frmActualizarAptoMedico.getContentPane().add(lblObservaciones);
       
        textDni = new JTextField();
        textDni.setBounds(126, 49, 101, 20);
        frmActualizarAptoMedico.getContentPane().add(textDni);
        textDni.setColumns(10);
       
        textFechaCarga = new JTextField();
        textFechaCarga.setBounds(126, 74, 101, 20);
        frmActualizarAptoMedico.getContentPane().add(textFechaCarga);
        textFechaCarga.setColumns(10);
       
        textNombreProf = new JTextField();
        textNombreProf.setBounds(126, 99, 101, 20);
        frmActualizarAptoMedico.getContentPane().add(textNombreProf);
        textNombreProf.setColumns(10);
       
        textFechaVto = new JTextField();
        textFechaVto.setBounds(126, 124, 101, 20);
        frmActualizarAptoMedico.getContentPane().add(textFechaVto);
        textFechaVto.setColumns(10);
       
        JTextPane txtObs = new JTextPane();
        txtObs.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        txtObs.setBounds(126, 152, 192, 62);
        frmActualizarAptoMedico.getContentPane().add(txtObs);
       
        JButton btnCancelar = new JButton("CANCELAR");
        btnCancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frmActualizarAptoMedico.dispose();
            }
        });
        btnCancelar.setBorder(new CompoundBorder(new EtchedBorder(EtchedBorder.RAISED, null, null), new BevelBorder(BevelBorder.RAISED, null, null, null, null)));
        btnCancelar.setBounds(10, 227, 89, 23);
        frmActualizarAptoMedico.getContentPane().add(btnCancelar);
       
        JButton btnAceptar = new JButton("ACEPTAR");
        btnAceptar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               
                    try {
                    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                        co.registrarAptoSocio(textDni.getText(),LocalDate.parse(textFechaCarga.getText(), formatter), textNombreProf.getText(), txtObs.getText(), LocalDate.parse(textFechaVto.getText()));
                        textDni.setText("");
                        txtObs.setText("");
                        textFechaCarga.setText("");
                        textNombreProf.setText("");
                        textFechaVto.setText("");
                    } catch (SocioException e1) {
                        JOptionPane.showMessageDialog(null, e1.getMessage());
                    } catch (ConnectionException e3) {
    					JOptionPane.showMessageDialog(null, e3.getMessage());
    				}
                    
               
            }
        });
        btnAceptar.setBorder(new CompoundBorder(new EtchedBorder(EtchedBorder.RAISED, null, null), new BevelBorder(BevelBorder.RAISED, null, null, null, null)));
        btnAceptar.setBounds(229, 225, 89, 23);
        frmActualizarAptoMedico.getContentPane().add(btnAceptar);
    }
}