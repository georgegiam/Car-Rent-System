package cars;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class delete_car extends JFrame {

	private JPanel contentPane;
	private JTextField delete_id;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					delete_car frame = new delete_car();
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
	public delete_car() {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblG = new JLabel("CAR TO BE DELETED ID");
		lblG.setHorizontalAlignment(SwingConstants.CENTER);
		lblG.setBounds(118, 93, 187, 14);
		contentPane.add(lblG);
		
		delete_id = new JTextField();
		delete_id.setBounds(118, 118, 187, 20);
		contentPane.add(delete_id);
		delete_id.setColumns(10);
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { //DELETE CAR
				try {
					Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cars", "root", "");
					
					PreparedStatement st = myConn.prepareStatement("SELECT car_id FROM car");
					ResultSet resultSet = st.executeQuery();
					
					ArrayList<String> ids = new ArrayList<String>(); //CHECKS IF THE ID YOU TYPED EXISTS IN THE DATABASE				
					while(resultSet.next()){ 
						ids.add(resultSet.getString("car_id"));	
						
					}
					boolean exist = false;
					for(int i = 0; i<ids.size(); i++){
						if(ids.get(i).equals(delete_id.getText().toString())){
							exist = true;
							break;
						}							
						else
							exist = false;
					}
					if(exist == false)
						JOptionPane.showMessageDialog(null, "No car with ID " +delete_id.getText().toString() +" founded!");
					else{ //IF THE ID YOU TYPED EXISTS IN THE DATABASE THEN EDIT
						try {
							Connection myConn1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/cars", "root", "");				
							
							
							PreparedStatement st1 = myConn1.prepareStatement("DELETE FROM car WHERE car_id = ?");
														
							st1.setString(1, delete_id.getText());						
							
							st1.executeUpdate();	
							
							PreparedStatement st2 = myConn1.prepareStatement("DELETE FROM rent WHERE car_id = ?");
							
							st2.setString(1, delete_id.getText());						
							
							st2.executeUpdate();
							
							JOptionPane.showMessageDialog(null, "Car " +delete_id.getText() +" deleted successfully!");
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
		btnDelete.setBounds(118, 149, 187, 23);
		contentPane.add(btnDelete);
		
		JButton show = new JButton("SHOW ALL CARS");
		show.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { //SHOW ALL CARS
				try {
					Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cars", "root", "");
					
					PreparedStatement st = myConn.prepareStatement("SELECT car_id FROM car");
					ResultSet resultSet = st.executeQuery();
					
					while(resultSet.next()){
						System.out.println("Car ID: " +resultSet.getString("car_id"));						
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		show.setBounds(118, 183, 187, 23);
		contentPane.add(show);
	}
}
