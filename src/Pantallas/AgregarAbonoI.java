package Pantallas;
 
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import Controlador.ControladoraABM;
import Excepciones.AbonoException;
import Excepciones.ConnectionException;
import Excepciones.DeporteException;
import Excepciones.InscripcionException;
import Excepciones.SocioException;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
 
public class AgregarAbonoI {
	ControladoraABM co;
    JFrame frmAgregarAbonoI;
    private JTextField textCodigoIns;
    private JTextField textCodigoAbono;
 

    public AgregarAbonoI(ControladoraABM c) {
    	co=c;
        initialize();
    }
 
    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frmAgregarAbonoI = new JFrame();
        frmAgregarAbonoI.setTitle("Inscripcion");
        frmAgregarAbonoI.setBounds(100, 100, 262, 185);
        frmAgregarAbonoI.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frmAgregarAbonoI.getContentPane().setLayout(null);
       
        JLabel lblAgregarAbono = new JLabel("Agregar Abono");
        lblAgregarAbono.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblAgregarAbono.setBounds(61, 11, 129, 25);
        frmAgregarAbonoI.getContentPane().add(lblAgregarAbono);
       
        JLabel lblNewLabel = new JLabel("Codigo Inscripcion");
        lblNewLabel.setBounds(10, 50, 115, 14);
        frmAgregarAbonoI.getContentPane().add(lblNewLabel);
       
        textCodigoIns = new JTextField();
        textCodigoIns.setBounds(123, 47, 103, 20);
        frmAgregarAbonoI.getContentPane().add(textCodigoIns);
        textCodigoIns.setColumns(10);
       
        JLabel lblCodigoAbono = new JLabel("Codigo Abono");
        lblCodigoAbono.setBounds(10, 75, 103, 14);
        frmAgregarAbonoI.getContentPane().add(lblCodigoAbono);
       
        textCodigoAbono = new JTextField();
        textCodigoAbono.setBounds(123, 72, 103, 20);
        frmAgregarAbonoI.getContentPane().add(textCodigoAbono);
        textCodigoAbono.setColumns(10);
       
        JButton btnCancelar = new JButton("CANCELAR");
        btnCancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	frmAgregarAbonoI.dispose();
            }
        });
        btnCancelar.setBounds(10, 112, 89, 23);
        frmAgregarAbonoI.getContentPane().add(btnCancelar);
       
        JButton btnAceptar = new JButton("ACEPTAR");
        btnAceptar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
				try {
					co.cargarAbonoInscripcion(Integer.parseInt(textCodigoIns.getText()), Integer.parseInt(textCodigoAbono.getText()));
					textCodigoIns.setText("");
					textCodigoAbono.setText("");
					textCodigoIns.setText("");
	            	textCodigoAbono.setText("");
				} catch (NumberFormatException | AbonoException | InscripcionException | ConnectionException | DeporteException | SocioException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
            	
				
            	
            }
        });
        btnAceptar.setBounds(137, 112, 89, 23);
        frmAgregarAbonoI.getContentPane().add(btnAceptar);
    }
 
}