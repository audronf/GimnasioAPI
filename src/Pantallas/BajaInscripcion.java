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
 
public class BajaInscripcion {
	ControladoraABM co;
    JFrame frmBajaIns;
    private JTextField txtIngreseCodigoA;
 
    /**
     * Launch the application.
     */
    public BajaInscripcion(ControladoraABM c) {
    	co=c;
        initialize();
    }
 
    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frmBajaIns = new JFrame();
        frmBajaIns.setTitle("Inscripcion");
        frmBajaIns.setBounds(100, 100, 273, 161);
        frmBajaIns.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frmBajaIns.getContentPane().setLayout(null);
       
        JLabel lblAbrirInscripcion = new JLabel("Baja Inscripcion");
        lblAbrirInscripcion.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblAbrirInscripcion.setBounds(62, 13, 150, 28);
        frmBajaIns.getContentPane().add(lblAbrirInscripcion);
       
        JLabel lblDni = new JLabel("Codigo Inscripcion");
        lblDni.setBounds(10, 55, 46, 14);
        frmBajaIns.getContentPane().add(lblDni);
       
        txtIngreseCodigoA = new JTextField();
        txtIngreseCodigoA.setText("");
        txtIngreseCodigoA.setBounds(93, 52, 137, 20);
        frmBajaIns.getContentPane().add(txtIngreseCodigoA);
        txtIngreseCodigoA.setColumns(10);
       
        JButton btnCancelar = new JButton("CANCELAR");
        btnCancelar.setBorder(new CompoundBorder(new EtchedBorder(EtchedBorder.RAISED, null, null), new BevelBorder(BevelBorder.RAISED, null, null, null, null)));
        btnCancelar.setBounds(10, 88, 89, 23);
        btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmBajaIns.dispose();
			}
		});
        frmBajaIns.getContentPane().add(btnCancelar);
       
        JButton btnAceptar = new JButton("DAR DE BAJA");
        btnAceptar.setBorder(new CompoundBorder(new EtchedBorder(EtchedBorder.RAISED, null, null), new BevelBorder(BevelBorder.RAISED, null, null, null, null)));
        btnAceptar.setBounds(141, 88, 89, 23);
        btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					co.cerrarInscripcion(Integer.parseInt(txtIngreseCodigoA.getText()));
					txtIngreseCodigoA.setText("");					
				}catch(SocioException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				} catch (InscripcionException e2) {
					JOptionPane.showMessageDialog(null, e2.getMessage());
				} catch (ConnectionException e3) {
					JOptionPane.showMessageDialog(null, e3.getMessage());
				} catch (NumberFormatException e3) {
					JOptionPane.showMessageDialog(null, "Ingrese un codigo correcto");
				}
					
			}
		});
        frmBajaIns.getContentPane().add(btnAceptar);
    }
 
}