package Pantallas;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JTextPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;

import Clases.ActividadView;
import Controlador.ControladoraABM;
import Excepciones.ActividadException;
import Excepciones.ConnectionException;
import Excepciones.InscripcionException;
import Excepciones.SocioException;

import javax.swing.border.BevelBorder;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class Mails {
	List<ActividadView> v;
	public JFrame frmMails;
	private ControladoraABM co;

	public Mails(ControladoraABM c) {
		co=c;
		initialize();
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void initialize() {
		frmMails = new JFrame();
		frmMails.setBounds(100, 100, 367, 326);
		frmMails.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmMails.getContentPane().setLayout(null);
		
		JLabel lblEnvioDeMails = new JLabel("ENVIO DE MAILS");
		lblEnvioDeMails.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEnvioDeMails.setBounds(76, 11, 282, 23);
		frmMails.getContentPane().add(lblEnvioDeMails);
		
		JRadioButton rdbtnEnvioMasivo = new JRadioButton("Envio Masivo");
		rdbtnEnvioMasivo.setBounds(6, 41, 133, 23);
		frmMails.getContentPane().add(rdbtnEnvioMasivo);
		
		JLabel lblFiltroPorActividad = new JLabel("Filtro por actividad");
		lblFiltroPorActividad.setBounds(16, 71, 123, 14);
		frmMails.getContentPane().add(lblFiltroPorActividad);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(121, 68, 192, 20);
		try {
		v = co.obtenerActividades();
		List<String> comboString = new ArrayList<String>();
		for(ActividadView av : v)
		{
			comboString.add(av.toString());
		}
		comboBox.setModel(new DefaultComboBoxModel(comboString.toArray()));
		frmMails.getContentPane().add(comboBox);
		} catch (ActividadException e1) {
			JOptionPane.showMessageDialog(null, "Nunca debería verse este cartel. Si aparece, entonces algo salió terriblemente mal con la combobox de Mail");
		} catch (ConnectionException e1) {
			JOptionPane.showMessageDialog(null, e1.getMessage());
		}
		JTextPane textMail = new JTextPane();
		textMail.setBounds(6, 101, 327, 130);
		frmMails.getContentPane().add(textMail);
		
		JButton btnCancelar = new JButton("CANCELAR");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmMails.dispose();
			}
		});
		btnCancelar.setBorder(new CompoundBorder(new EtchedBorder(EtchedBorder.RAISED, null, null), new BevelBorder(BevelBorder.RAISED, null, null, null, null)));
		btnCancelar.setBounds(6, 253, 89, 23);
		frmMails.getContentPane().add(btnCancelar);
		
		JButton btnEnviar = new JButton("ENVIAR");
		btnEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnEnvioMasivo.isSelected())
				{
					try {
						co.envioMasivo(textMail.getText());
						textMail.setText("");
					} catch (SocioException | ConnectionException e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage());
					}
				}
				else
				{
					try {
						co.envioMailActividad(comboBox.getSelectedItem().toString(), textMail.getText());
						textMail.setText("");
					} catch (ConnectionException | ActividadException | InscripcionException | SocioException e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage());
					}
				}
			}
		});
		btnEnviar.setBorder(new CompoundBorder(new EtchedBorder(EtchedBorder.RAISED, null, null), new BevelBorder(BevelBorder.RAISED, null, null, null, null)));
		btnEnviar.setBounds(244, 253, 89, 23);
		frmMails.getContentPane().add(btnEnviar);
	}
}