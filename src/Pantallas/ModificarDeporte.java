package Pantallas;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;

import Clases.DeporteView;
import Controlador.ControladoraABM;
import Excepciones.ConnectionException;
import Excepciones.DeporteException;
import javax.swing.border.BevelBorder;
import java.awt.Cursor;

public class ModificarDeporte {

	JFrame frmModificarDeporte;
	ControladoraABM co;
	DeporteView v;
	private JTextField txtInserteCodigoA;
	private JTextField textNombre;
	private JTextField textDescripcion;

	public ModificarDeporte(ControladoraABM c) {
		co=c;
		initialize();
	}

	private void initialize() {
		frmModificarDeporte = new JFrame();
		frmModificarDeporte.setTitle("Deporte");
		frmModificarDeporte.setBounds(100, 100, 388, 200);
		frmModificarDeporte.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmModificarDeporte.getContentPane().setLayout(null);
		
		JLabel lblBaja = new JLabel("Modificaci\u00F3n");
		lblBaja.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblBaja.setBounds(113, 11, 138, 27);
		frmModificarDeporte.getContentPane().add(lblBaja);
		
		txtInserteCodigoA = new JTextField();
		txtInserteCodigoA.setText("Inserte codigo a buscar");
		txtInserteCodigoA.setBounds(66, 51, 197, 20);
		frmModificarDeporte.getContentPane().add(txtInserteCodigoA);
		txtInserteCodigoA.setColumns(10);
		txtInserteCodigoA.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				if(txtInserteCodigoA.getText().equalsIgnoreCase("Inserte codigo a buscar"))
					txtInserteCodigoA.setText("");
			}
		});
		JButton btnBuscar = new JButton("BUSCAR");
		btnBuscar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnBuscar.setBorder(new CompoundBorder(new EtchedBorder(EtchedBorder.RAISED, null, null), new BevelBorder(BevelBorder.RAISED, null, null, null, null)));
		btnBuscar.setBounds(273, 50, 89, 23);
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					 v = co.devolverDeporte(Integer.parseInt(txtInserteCodigoA.getText()));
					 textNombre.setText(v.getNombre());
					 textDescripcion.setText(v.getDescripcion());
					 textNombre.setEnabled(true);
					 textNombre.setEditable(true);
					 textDescripcion.setEnabled(true);
					 textDescripcion.setEditable(true); 
					 
				} catch (DeporteException | NumberFormatException | ConnectionException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
			}
		});
		frmModificarDeporte.getContentPane().add(btnBuscar);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(10, 79, 46, 14);
		frmModificarDeporte.getContentPane().add(lblNombre);
		
		textNombre = new JTextField();
		textNombre.setEditable(false);
		textNombre.setEnabled(false);
		textNombre.setBounds(66, 76, 197, 20);
		frmModificarDeporte.getContentPane().add(textNombre);
		textNombre.setColumns(10);
		
		textDescripcion = new JTextField();
		textDescripcion.setEditable(false);
		textDescripcion.setEnabled(false);
		textDescripcion.setBounds(76, 101, 187, 20);
		frmModificarDeporte.getContentPane().add(textDescripcion);
		textDescripcion.setColumns(10);
		
		JButton btnAceptar = new JButton("ACEPTAR");
		btnAceptar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAceptar.setBorder(new CompoundBorder(new EtchedBorder(EtchedBorder.RAISED, null, null), new BevelBorder(BevelBorder.RAISED, null, null, null, null)));
		btnAceptar.setBounds(174, 132, 89, 23);
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					 try {
						co.modificarDeporte(Integer.parseInt(txtInserteCodigoA.getText()),textNombre.getText(),textDescripcion.getText());
						 txtInserteCodigoA.setText("");
						 textNombre.setText("");
						 textDescripcion.setText("");
						 textNombre.setEnabled(false);
						 textDescripcion.setEnabled(false);
					 } catch (NumberFormatException | DeporteException | ConnectionException e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage());
					}
					
					 
				
			}
		});
		frmModificarDeporte.getContentPane().add(btnAceptar);
		
		JButton btnCancelar = new JButton("CANCELAR");
		btnCancelar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCancelar.setBorder(new CompoundBorder(new EtchedBorder(EtchedBorder.RAISED, null, null), new BevelBorder(BevelBorder.RAISED, null, null, null, null)));
		btnCancelar.setBounds(10, 132, 89, 23);
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmModificarDeporte.dispose();
			}
		});
		frmModificarDeporte.getContentPane().add(btnCancelar);
		
		JLabel lblCodigo = new JLabel("Codigo");
		lblCodigo.setBounds(10, 54, 46, 14);
		frmModificarDeporte.getContentPane().add(lblCodigo);
		
		JLabel lblDescipcion = new JLabel("Descipcion");
		lblDescipcion.setBounds(10, 104, 70, 14);
		frmModificarDeporte.getContentPane().add(lblDescipcion);
	}
}
