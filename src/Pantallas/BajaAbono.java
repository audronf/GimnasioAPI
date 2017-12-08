package Pantallas;
 
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
 

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
 

import Clases.AbonoView;
import Clases.ItemActividadHorario;
import Controlador.ControladoraABM;
import Excepciones.AbonoException;
import Excepciones.ActividadException;
import Excepciones.ConnectionException;
import javax.swing.border.BevelBorder;

import java.awt.Cursor;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.DefaultListModel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
 
public class BajaAbono {
 
    JFrame frmBajaAbono;
    ControladoraABM co;
    AbonoView v;
    private JTextField txtInserteCodigoA;
    private JTextField textField_1;
    public BajaAbono(ControladoraABM c) {
        co=c;
        initialize();
    }
 
    @SuppressWarnings({ "rawtypes", "unchecked" })
    private void initialize() {
        frmBajaAbono = new JFrame();
        frmBajaAbono.setTitle("Abono");
        frmBajaAbono.setBounds(100, 100, 388, 328);
        frmBajaAbono.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frmBajaAbono.getContentPane().setLayout(null);
       
        JLabel lblBaja = new JLabel("Baja");
        lblBaja.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblBaja.setBounds(144, 11, 46, 27);
        frmBajaAbono.getContentPane().add(lblBaja);
       
       
        txtInserteCodigoA = new JTextField();
        txtInserteCodigoA.setText("Inserte codigo a buscar");
        txtInserteCodigoA.setBounds(66, 51, 197, 20);
        frmBajaAbono.getContentPane().add(txtInserteCodigoA);
        txtInserteCodigoA.setColumns(10);
        txtInserteCodigoA.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent arg0) {
                txtInserteCodigoA.setText("");
            }
        });
       
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 129, 253, 117);
        frmBajaAbono.getContentPane().add(scrollPane);
       
        JList listaAct = new JList();
        listaAct.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        scrollPane.setViewportView(listaAct);
        listaAct.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
       
   
       
        JButton btnBuscar = new JButton("BUSCAR");
        btnBuscar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    v=co.devolverAbono(Integer.parseInt(txtInserteCodigoA.getText()));
                    textField_1.setText(v.getNombre());                
                    DefaultListModel<String> model = new DefaultListModel<String>();
                    
                    for(final ItemActividadHorario h : v.getActividades()) {
                   	  
                    		 model.addElement(h.getActividad().getNombre());                                   	
                        
	                    }
                    listaAct.setModel(model);
	                }
            catch (NumberFormatException | AbonoException | ConnectionException | ActividadException e1) {
                    JOptionPane.showMessageDialog(null, e1.getMessage());
                }
           
            }
        });

        btnBuscar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnBuscar.setBorder(new CompoundBorder(new EtchedBorder(EtchedBorder.RAISED, null, null), new BevelBorder(BevelBorder.RAISED, null, null, null, null)));
        btnBuscar.setBounds(273, 50, 89, 23);
        frmBajaAbono.getContentPane().add(btnBuscar);
       
        JLabel lblNombre = new JLabel("Nombre");
        lblNombre.setBounds(10, 79, 46, 14);
        frmBajaAbono.getContentPane().add(lblNombre);
       
        textField_1 = new JTextField();
        textField_1.setEditable(false);
        textField_1.setEnabled(false);
        textField_1.setBounds(66, 76, 197, 20);
        frmBajaAbono.getContentPane().add(textField_1);
        textField_1.setColumns(10);
       
        JButton btnAceptar = new JButton("ACEPTAR");
        btnAceptar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnAceptar.setBorder(new CompoundBorder(new EtchedBorder(EtchedBorder.RAISED, null, null), new BevelBorder(BevelBorder.RAISED, null, null, null, null)));
        btnAceptar.setBounds(174, 257, 89, 23);
        btnAceptar.addActionListener(new ActionListener() {
        	   public void actionPerformed(ActionEvent e) {
        	    try {
        	     co.bajaLogicaAbono(Integer.parseInt(txtInserteCodigoA.getText()));
        	     txtInserteCodigoA.setText("");
        	     textField_1.setText("");
        	     listaAct.setModel(new DefaultListModel());
        	    } catch (NumberFormatException | AbonoException | ConnectionException e1) {

        	     JOptionPane.showMessageDialog(null, e1.getMessage());
        	    }
        	   }
        	  });
        frmBajaAbono.getContentPane().add(btnAceptar);
       
        JButton btnCancelar = new JButton("CANCELAR");
        btnCancelar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnCancelar.setBorder(new CompoundBorder(new EtchedBorder(EtchedBorder.RAISED, null, null), new BevelBorder(BevelBorder.RAISED, null, null, null, null)));
        btnCancelar.setBounds(10, 257, 89, 23);
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmBajaAbono.dispose();
			}
		});
        frmBajaAbono.getContentPane().add(btnCancelar);
       
        JLabel lblCodigo = new JLabel("Codigo");
        lblCodigo.setBounds(10, 54, 46, 14);
        frmBajaAbono.getContentPane().add(lblCodigo);
       
        JLabel lblActividades = new JLabel("Actividades");
        lblActividades.setBounds(10, 104, 66, 14);
        frmBajaAbono.getContentPane().add(lblActividades);
       
    }
}