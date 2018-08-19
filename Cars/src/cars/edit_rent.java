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

public class edit_rent extends JFrame {

	private JPanel contentPane;
	private JTextField edit_id;
	private int crid;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					edit_rent frame = new edit_rent();
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
	public edit_rent() {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{128, 167, 0};
		gbl_contentPane.rowHeights = new int[]{101, 14, 20, 23, 23, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblRentToBe = new JLabel("RENT ID TO BE EDITED");
		lblRentToBe.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblRentToBe = new GridBagConstraints();
		gbc_lblRentToBe.anchor = GridBagConstraints.NORTH;
		gbc_lblRentToBe.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblRentToBe.insets = new Insets(0, 0, 5, 0);
		gbc_lblRentToBe.gridx = 1;
		gbc_lblRentToBe.gridy = 1;
		contentPane.add(lblRentToBe, gbc_lblRentToBe);
		
		edit_id = new JTextField();
		GridBagConstraints gbc_edit_id = new GridBagConstraints();
		gbc_edit_id.anchor = GridBagConstraints.NORTH;
		gbc_edit_id.fill = GridBagConstraints.HORIZONTAL;
		gbc_edit_id.insets = new Insets(0, 0, 5, 0);
		gbc_edit_id.gridx = 1;
		gbc_edit_id.gridy = 2;
		contentPane.add(edit_id, gbc_edit_id);
		edit_id.setColumns(10);
		
		JButton btnNewButton = new JButton("SHOW ALL RENTS");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { // SHOW ALL RENTS
				try { 
					Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cars", "root", "");
					
					PreparedStatement st = myConn.prepareStatement("SELECT rent_id FROM rent");
					ResultSet resultSet = st.executeQuery();
					
					while(resultSet.next()){
						System.out.println("Rented ID: " +resultSet.getInt("rent_id"));					
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.anchor = GridBagConstraints.NORTH;
		gbc_btnNewButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton.gridx = 1;
		gbc_btnNewButton.gridy = 3;
		contentPane.add(btnNewButton, gbc_btnNewButton);
		
		JButton btnNewButton_1 = new JButton("EDIT");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { //EDIT RENT
				try {
					Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cars", "root", "");
					
					PreparedStatement st = myConn.prepareStatement("SELECT rent_id FROM rent");
					ResultSet resultSet = st.executeQuery();
					
					ArrayList<String> ids = new ArrayList<String>(); //CHECKS IF THE ID YOU TYPED EXISTS IN THE DATABASE				
					while(resultSet.next()){ 
						ids.add(resultSet.getString("rent_id"));	
						
					}
					boolean exist = false;
					for(int i = 0; i<ids.size(); i++){
						if(ids.get(i).equals(edit_id.getText().toString())){
							exist = true;
							break;
						}
						else
							exist = false;
					}
					if(exist == false)
						JOptionPane.showMessageDialog(null, "No rent with ID " +edit_id.getText().toString() +" founded!");
					else{ //IF THE ID YOU TYPED EXISTS IN THE DATABASE THEN EDIT
						crid = Integer.parseInt(edit_id.getText());
						edit_rnt edcr = new edit_rnt(crid);
						edcr.setVisible(true);	
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.anchor = GridBagConstraints.NORTH;
		gbc_btnNewButton_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNewButton_1.gridx = 1;
		gbc_btnNewButton_1.gridy = 4;
		contentPane.add(btnNewButton_1, gbc_btnNewButton_1);
	}

}
