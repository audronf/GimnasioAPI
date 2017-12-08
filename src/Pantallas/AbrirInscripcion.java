package Pantallas;
 
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;

import Controlador.ControladoraABM;
import Excepciones.ConnectionException;
import Excepciones.InscripcionException;
import Excepciones.SocioException;

import javax.swing.border.BevelBorder;
 
public class AbrirInscripcion {
	ControladoraABM co;
    JFrame frmInscripcion;
    private JTextField txtIngreseDniA;
 
    /**
     * Launch the application.
     */
    public AbrirInscripcion(ControladoraABM c) {
    	co=c;
        initialize();
    }
 
    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frmInscripcion = new JFrame();
        frmInscripcion.setTitle("Inscripcion");
        frmInscripcion.setBounds(100, 100, 273, 161);
        frmInscripcion.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frmInscripcion.getContentPane().setLayout(null);
       
        JLabel lblAbrirInscripcion = new JLabel("Abrir Inscripcion");
        lblAbrirInscripcion.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblAbrirInscripcion.setBounds(62, 13, 150, 28);
        frmInscripcion.getContentPane().add(lblAbrirInscripcion);
       
        JLabel lblDni = new JLabel("D.N.I");
        lblDni.setBounds(10, 55, 46, 14);
        frmInscripcion.getContentPane().add(lblDni);
       
        txtIngreseDniA = new JTextField();
        txtIngreseDniA.setText("");
        txtIngreseDniA.setBounds(93, 52, 137, 20);
        frmInscripcion.getContentPane().add(txtIngreseDniA);
        txtIngreseDniA.setColumns(10);
       
        JButton btnCancelar = new JButton("CANCELAR");
        btnCancelar.setBorder(new CompoundBorder(new EtchedBorder(EtchedBorder.RAISED, null, null), new BevelBorder(BevelBorder.RAISED, null, null, null, null)));
        btnCancelar.setBounds(10, 88, 89, 23);
        btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmInscripcion.dispose();
			}
		});
        frmInscripcion.getContentPane().add(btnCancelar);
       
        JButton btnAceptar = new JButton("ACEPTAR");
        btnAceptar.setBorder(new CompoundBorder(new EtchedBorder(EtchedBorder.RAISED, null, null), new BevelBorder(BevelBorder.RAISED, null, null, null, null)));
        btnAceptar.setBounds(141, 88, 89, 23);
        btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					co.abrirInscripcion(txtIngreseDniA.getText());
					txtIngreseDniA.setText("");					
				}catch(SocioException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				} catch (InscripcionException e2) {
					JOptionPane.showMessageDialog(null, e2.getMessage());
				} catch (ConnectionException e3) {
					JOptionPane.showMessageDialog(null, e3.getMessage());
				}
				
			}
		});
        frmInscripcion.getContentPane().add(btnAceptar);
    }
 
}