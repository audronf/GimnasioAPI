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

public class BajaDeporte {

	JFrame frmBajaDeporte;
	DeporteView v;
	ControladoraABM co;
	private JTextField txtInserteCodigoA;
	private JTextField textNombre;
	private JTextField textDescripcion;

	public BajaDeporte(ControladoraABM c) {
		co=c;
		initialize();
	}

	private void initialize() {
		frmBajaDeporte = new JFrame();
		frmBajaDeporte.setTitle("Deporte");
		frmBajaDeporte.setBounds(100, 100, 388, 200);
		frmBajaDeporte.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmBajaDeporte.getContentPane().setLayout(null);
		
		JLabel lblBaja = new JLabel("Baja");
		lblBaja.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblBaja.setBounds(144, 11, 46, 27);
		frmBajaDeporte.getContentPane().add(lblBaja);
		
		txtInserteCodigoA = new JTextField();
		txtInserteCodigoA.setText("Inserte codigo a buscar");
		txtInserteCodigoA.setBounds(66, 51, 197, 20);
		frmBajaDeporte.getContentPane().add(txtInserteCodigoA);
		txtInserteCodigoA.setColumns(10);
		txtInserteCodigoA.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
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
					 textNombre.setEditable(false);
					 textDescripcion.setEnabled(true);
					 textDescripcion.setEditable(false); 
					 
				} catch (DeporteException | NumberFormatException | ConnectionException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
			}
		});
		frmBajaDeporte.getContentPane().add(btnBuscar);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(10, 79, 46, 14);
		frmBajaDeporte.getContentPane().add(lblNombre);
		
		textNombre = new JTextField();
		textNombre.setEditable(false);
		textNombre.setEnabled(false);
		textNombre.setBounds(66, 76, 197, 20);
		frmBajaDeporte.getContentPane().add(textNombre);
		textNombre.setColumns(10);
		
		textDescripcion = new JTextField();
		textDescripcion.setEditable(false);
		textDescripcion.setEnabled(false);
		textDescripcion.setBounds(76, 101, 187, 20);
		frmBajaDeporte.getContentPane().add(textDescripcion);
		textDescripcion.setColumns(10);
		
		JButton btnAceptar = new JButton("ACEPTAR");
		btnAceptar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAceptar.setBorder(new CompoundBorder(new EtchedBorder(EtchedBorder.RAISED, null, null), new BevelBorder(BevelBorder.RAISED, null, null, null, null)));
		btnAceptar.setBounds(174, 132, 89, 23);
		frmBajaDeporte.getContentPane().add(btnAceptar);
        btnAceptar.addActionListener(new ActionListener() {
     	   public void actionPerformed(ActionEvent e) {
     	    try {
     	    co.bajaLogicaDeporte(Integer.parseInt(txtInserteCodigoA.getText()));
     	    textNombre.setText("");
			textDescripcion.setText("");
			textDescripcion.setText("");
			txtInserteCodigoA.setText("");
     	    } catch ( ConnectionException | NumberFormatException | DeporteException e1) {
     	     JOptionPane.showMessageDialog(null, e1.getMessage());
     	    }
     	   }
     	  });
		
		JButton btnCancelar = new JButton("CANCELAR");
		btnCancelar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCancelar.setBorder(new CompoundBorder(new EtchedBorder(EtchedBorder.RAISED, null, null), new BevelBorder(BevelBorder.RAISED, null, null, null, null)));
		btnCancelar.setBounds(10, 132, 89, 23);
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmBajaDeporte.dispose();
			}
		});
		frmBajaDeporte.getContentPane().add(btnCancelar);
		
		JLabel lblCodigo = new JLabel("Codigo");
		lblCodigo.setBounds(10, 54, 46, 14);
		frmBajaDeporte.getContentPane().add(lblCodigo);
		
		JLabel lblDescipcion = new JLabel("Descipcion");
		lblDescipcion.setBounds(10, 104, 75, 14);
		frmBajaDeporte.getContentPane().add(lblDescipcion);
	}
}
