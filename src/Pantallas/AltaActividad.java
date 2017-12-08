package Pantallas;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Cursor;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;

import Controlador.ControladoraABM;
import Excepciones.ActividadException;
import Excepciones.ConnectionException;
import Excepciones.DeporteException;
import javax.swing.border.BevelBorder;

public class AltaActividad {
	ControladoraABM co;
	JFrame frmAltaActividad;
	private JTextField textCodigoDeporte;
	private JTextField textNombre;
	private JTextField textPrecioHora;

	public AltaActividad(ControladoraABM c) {
		co=c;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAltaActividad = new JFrame();
		frmAltaActividad.setTitle("Deportes");
		frmAltaActividad.setBounds(100, 100, 330, 238);
		frmAltaActividad.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmAltaActividad.getContentPane().setLayout(null);
		
		JLabel lblCodigoDeporte = new JLabel("Codigo Deporte");
		lblCodigoDeporte.setBounds(10, 51, 120, 26);
		frmAltaActividad.getContentPane().add(lblCodigoDeporte);
		
		JLabel lblNombre = new JLabel("Nombre ");
		lblNombre.setBounds(10, 88, 60, 23);
		frmAltaActividad.getContentPane().add(lblNombre);
		
		JLabel lblPreciohora = new JLabel("PrecioHora");
		lblPreciohora.setBounds(10, 122, 70, 26);
		frmAltaActividad.getContentPane().add(lblPreciohora);
		
		JLabel lblAltaActividad = new JLabel("Alta Actividad");
		lblAltaActividad.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAltaActividad.setBounds(95, 21, 115, 14);
		frmAltaActividad.getContentPane().add(lblAltaActividad);
		
		textCodigoDeporte = new JTextField();
		textCodigoDeporte.setBounds(143, 54, 137, 20);
		frmAltaActividad.getContentPane().add(textCodigoDeporte);
		textCodigoDeporte.setColumns(10);
		
		textNombre = new JTextField();
		textNombre.setBounds(143, 89, 137, 20);
		frmAltaActividad.getContentPane().add(textNombre);
		textNombre.setColumns(10);
		
		textPrecioHora = new JTextField();
		textPrecioHora.setBounds(143, 125, 137, 20);
		frmAltaActividad.getContentPane().add(textPrecioHora);
		textPrecioHora.setColumns(10);
		
		JButton btnCancelar = new JButton("CANCELAR");
		btnCancelar.setBorder(new CompoundBorder(new EtchedBorder(EtchedBorder.RAISED, null, null), new BevelBorder(BevelBorder.RAISED, null, null, null, null)));
		btnCancelar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmAltaActividad.dispose();
			}
		});
		btnCancelar.setBounds(10, 171, 89, 23);
		frmAltaActividad.getContentPane().add(btnCancelar);
		
		JButton btnAceptar = new JButton("ACEPTAR");
		btnAceptar.setBorder(new CompoundBorder(new EtchedBorder(EtchedBorder.RAISED, null, null), new BevelBorder(BevelBorder.RAISED, null, null, null, null)));
		btnAceptar.setBounds(191, 171, 89, 23);
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
				co.altaActividad(Integer.parseInt(textCodigoDeporte.getText()), textNombre.getText(), Float.parseFloat(textPrecioHora.getText()));
				textCodigoDeporte.setText("");
				textNombre.setText("");
				textPrecioHora.setText("");
				}catch(DeporteException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}catch(ActividadException e2){
					JOptionPane.showMessageDialog(null, e2.getMessage());
				} catch (NumberFormatException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				} catch (ConnectionException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				} 
				
				
			}
			
		});
		frmAltaActividad.getContentPane().add(btnAceptar);
	}
}