package Pantallas;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.border.BevelBorder;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;

import Clases.ActividadHorarioView;
import Controlador.ControladoraABM;
import Excepciones.ActividadException;
import Excepciones.ConnectionException;

import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class Cronogramas {
	List<ActividadHorarioView> v;
	public JFrame frmCronogramas;
	private ControladoraABM co;

	public Cronogramas(ControladoraABM c) {
		co = c;
		initialize();
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void initialize() {
		frmCronogramas = new JFrame();
		frmCronogramas.setBounds(100, 100, 339, 318);
		frmCronogramas.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmCronogramas.getContentPane().setLayout(null);
		
		JLabel lblConsultaDeCronogramas = new JLabel("CONSULTA DE CRONOGRAMAS");
		lblConsultaDeCronogramas.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblConsultaDeCronogramas.setBounds(41, 11, 282, 23);
		frmCronogramas.getContentPane().add(lblConsultaDeCronogramas);
		
		JLabel lblDia = new JLabel("Dia");
		lblDia.setBounds(24, 62, 46, 14);
		frmCronogramas.getContentPane().add(lblDia);
		
		JComboBox dia = new JComboBox();
		dia.setModel(new DefaultComboBoxModel(new String[] {"Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado"}));
		dia.setBounds(80, 59, 101, 20);
		frmCronogramas.getContentPane().add(dia);
		
		JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 90, 287, 142);
        frmCronogramas.getContentPane().add(scrollPane);
       
        JList listaAct = new JList();
        listaAct.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        scrollPane.setViewportView(listaAct);
        listaAct.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        
        JButton btnVolver = new JButton("VOLVER");
        btnVolver.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		frmCronogramas.dispose();
        	}
        });
        btnVolver.setBorder(new CompoundBorder(new EtchedBorder(EtchedBorder.RAISED, null, null), new BevelBorder(BevelBorder.RAISED, null, null, null, null)));
        btnVolver.setBounds(10, 245, 89, 23);
        frmCronogramas.getContentPane().add(btnVolver);
        
        JButton btnBuscar = new JButton("BUSCAR");
        btnBuscar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
                try {
                    v=co.devolverActividadesDia(dia.getSelectedItem().toString());
                    DefaultListModel<String> model = new DefaultListModel<String>();
                    
                    for( ActividadHorarioView h : v) {
                   	  
                    		 model.addElement(h.toString());                                   	
                        
	                    }
                    listaAct.setModel(model);
	                }
            catch (NumberFormatException | ConnectionException | ActividadException e1) {
                    JOptionPane.showMessageDialog(null, e1.getMessage());
                }
           
        	}
        });
        btnBuscar.setBorder(new CompoundBorder(new EtchedBorder(EtchedBorder.RAISED, null, null), new BevelBorder(BevelBorder.RAISED, null, null, null, null)));
        btnBuscar.setBounds(208, 245, 89, 23);
        frmCronogramas.getContentPane().add(btnBuscar);
	}
}