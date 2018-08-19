package cars;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class edit_costumer extends JFrame {

	private JPanel contentPane;
	private JTextField drive_id;
	private String d_id;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					edit_costumer frame = new edit_costumer();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public edit_costumer() {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{114, 89, 89, 0};
		gbl_contentPane.rowHeights = new int[]{98, 14, 20, 23, 23, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblNewLabel = new JLabel("COSTUMER TO BE EDIT DRIVE ID");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.NORTH;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.gridwidth = 2;
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 1;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);
		
		drive_id = new JTextField();
		GridBagConstraints gbc_drive_id = new GridBagConstraints();
		gbc_drive_id.anchor = GridBagConstraints.NORTH;
		gbc_drive_id.fill = GridBagConstraints.HORIZONTAL;
		gbc_drive_id.insets = new Insets(0, 0, 5, 0);
		gbc_drive_id.gridwidth = 2;
		gbc_drive_id.gridx = 1;
		gbc_drive_id.gridy = 2;
		contentPane.add(drive_id, gbc_drive_id);
		drive_id.setColumns(10);
		
		JButton edit = new JButton("EDIT");
		edit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cars", "root", "");
					
					PreparedStatement st = myConn.prepareStatement("SELECT lisence_id FROM customer");
					ResultSet resultSet = st.executeQuery();
					
					ArrayList<String> ids = new ArrayList<String>(); //CHECKS IF THE ID YOU TYPED EXISTS IN THE DATABASE				
					while(resultSet.next()){ 
						ids.add(resultSet.getString("lisence_id"));							
					}
					boolean exist = false;
					for(int i = 0; i<ids.size(); i++){
						if(ids.get(i).equals(drive_id.getText().toString())){
							exist = true;
							break;
						}							
						else
							exist = false;
					}
					if(exist == false)
						JOptionPane.showMessageDialog(null, "No costumer with Drive ID " +drive_id.getText().toString() +" founded!");
					else{ //IF THE ID YOU TYPED EXISTS IN THE DATABASE THEN EDIT
						d_id = drive_id.getText();
						edit_cstr edcr = new edit_cstr(d_id);
						edcr.setVisible(true);	
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		GridBagConstraints gbc_edit = new GridBagConstraints();
		gbc_edit.gridwidth = 2;
		gbc_edit.anchor = GridBagConstraints.NORTH;
		gbc_edit.fill = GridBagConstraints.HORIZONTAL;
		gbc_edit.insets = new Insets(0, 0, 5, 5);
		gbc_edit.gridx = 1;
		gbc_edit.gridy = 3;
		contentPane.add(edit, gbc_edit);
		
		JButton show = new JButton("SHOW ALL CUSTOMERS");
		show.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { //SHOW ALL COSTUMERS
				try {
					Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cars", "root", "");
					
					PreparedStatement st = myConn.prepareStatement("SELECT lisence_id FROM customer");
					ResultSet resultSet = st.executeQuery();
					
					while(resultSet.next()){
						System.out.println("Drive ID: " +resultSet.getString("lisence_id"));						
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		GridBagConstraints gbc_show = new GridBagConstraints();
		gbc_show.anchor = GridBagConstraints.NORTH;
		gbc_show.fill = GridBagConstraints.HORIZONTAL;
		gbc_show.gridwidth = 2;
		gbc_show.gridx = 1;
		gbc_show.gridy = 4;
		contentPane.add(show, gbc_show);
	}

}
