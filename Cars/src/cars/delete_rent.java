package cars;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
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

public class delete_rent extends JFrame {

	private JPanel contentPane;
	private JTextField delete_id;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					delete_rent frame = new delete_rent();
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
	public delete_rent() {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{131, 161, 0};
		gbl_contentPane.rowHeights = new int[]{103, 14, 20, 23, 23, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblRentToBe = new JLabel("RENT TO BE DELETED");
		lblRentToBe.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblRentToBe = new GridBagConstraints();
		gbc_lblRentToBe.anchor = GridBagConstraints.NORTH;
		gbc_lblRentToBe.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblRentToBe.insets = new Insets(0, 0, 5, 0);
		gbc_lblRentToBe.gridx = 1;
		gbc_lblRentToBe.gridy = 1;
		contentPane.add(lblRentToBe, gbc_lblRentToBe);
		
		delete_id = new JTextField();
		GridBagConstraints gbc_delete_id = new GridBagConstraints();
		gbc_delete_id.anchor = GridBagConstraints.NORTH;
		gbc_delete_id.fill = GridBagConstraints.HORIZONTAL;
		gbc_delete_id.insets = new Insets(0, 0, 5, 0);
		gbc_delete_id.gridx = 1;
		gbc_delete_id.gridy = 2;
		contentPane.add(delete_id, gbc_delete_id);
		delete_id.setColumns(10);
		
		JButton show = new JButton("SHOW ALL RENTS");
		show.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { //SHOW ALL RENTS
				try {
					Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cars", "root", "");
					
					PreparedStatement st = myConn.prepareStatement("SELECT * FROM rent");
					ResultSet resultSet = st.executeQuery();
					
					while(resultSet.next()){
						System.out.println("Rent ID: " +resultSet.getInt("rent_id") +"\n"
								+"Pickup Date: " +resultSet.getString("pickup_date_time") +"\n"
								+"Return Date: " +resultSet.getString("return_date_time") +"\nt"
								+"Pickup Place: " +resultSet.getString("pickup_place") +"\n"
								+"Return Place: " +resultSet.getString("return_place") +"\n"
								+"Car ID: " +resultSet.getString("car_id") +"\n"
								+"Customer ID: " +resultSet.getString("customer_id") +"\n");					
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		GridBagConstraints gbc_show = new GridBagConstraints();
		gbc_show.anchor = GridBagConstraints.NORTH;
		gbc_show.fill = GridBagConstraints.HORIZONTAL;
		gbc_show.insets = new Insets(0, 0, 5, 0);
		gbc_show.gridx = 1;
		gbc_show.gridy = 3;
		contentPane.add(show, gbc_show);
		
		JButton delete = new JButton("DELETE");
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) { //DELETE
				try {
					Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cars", "root", "");
					
					PreparedStatement st = myConn.prepareStatement("SELECT rent_id FROM rent");
					ResultSet resultSet = st.executeQuery();
					
					ArrayList<Integer> ids = new ArrayList<Integer>(); //CHECKS IF THE ID YOU TYPED EXISTS IN THE DATABASE				
					while(resultSet.next()){ 
						ids.add(resultSet.getInt("rent_id"));	
						
					}
					boolean exist = false;
					for(int i = 0; i<ids.size(); i++){
						if(ids.get(i) == Integer.parseInt(delete_id.getText())){
							exist = true;
							break;
						}							
						else
							exist = false;
					}
					if(exist == false)
						JOptionPane.showMessageDialog(null, "No rent with ID " +delete_id.getText().toString() +" founded!");
					else{ //IF THE ID YOU TYPED EXISTS IN THE DATABASE THEN EDIT
						try {
							Connection myConn1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/cars", "root", "");				
							
							//GETTING THE DELETED CAR ID TO COMPARE IT
							PreparedStatement st2 = myConn.prepareStatement("SELECT car_id FROM rent WHERE rent_id = ?");
							
							st2.setInt(1, Integer.parseInt(delete_id.getText()));
							
							ResultSet resultSet2 = st2.executeQuery();
							
							String[] a = new String[1];		
							while(resultSet2.next()){ 
								a[0] = resultSet2.getString("car_id");									
							}
							
							//GETTING ALL THE CA IDS FROM RENT
							PreparedStatement st5 = myConn.prepareStatement("SELECT car_id FROM rent");							
							
							ResultSet resultSet5 = st5.executeQuery();
							
							ArrayList<String> acids = new ArrayList<String>();		
							while(resultSet5.next()){ 
								acids.add(resultSet5.getString("car_id"));										
							}
							
							PreparedStatement st1 = myConn1.prepareStatement("DELETE FROM rent WHERE rent_id = ?");
							
							st1.setInt(1, Integer.parseInt(delete_id.getText()));
							
							st1.executeUpdate();	
					
							PreparedStatement st3 = myConn1.prepareStatement("UPDATE car SET rnt = 0 WHERE car_id = ?");
								
							st3.setString(1, a[0]);
								
							st3.executeUpdate();
							
							
							JOptionPane.showMessageDialog(null, "Rent " +delete_id.getText() +" deleted successfully!");
						} catch (SQLException e1) {
							e1.printStackTrace();
							JOptionPane.showMessageDialog(null, "Dleition failed!");
						}
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		GridBagConstraints gbc_delete = new GridBagConstraints();
		gbc_delete.anchor = GridBagConstraints.NORTH;
		gbc_delete.fill = GridBagConstraints.HORIZONTAL;
		gbc_delete.gridx = 1;
		gbc_delete.gridy = 4;
		contentPane.add(delete, gbc_delete);
	}
}
