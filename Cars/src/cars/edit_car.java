package cars;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class edit_car extends JFrame {

	private JPanel contentPane;
	public JTextField edit_car_id;
	private String crid;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					edit_car frame = new edit_car();
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
	public edit_car() {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{121, 188, 0};
		gbl_contentPane.rowHeights = new int[]{88, 14, 20, 23, 23, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblCarToBe = new JLabel("CAR TO BE EDIT ID");
		lblCarToBe.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblCarToBe = new GridBagConstraints();
		gbc_lblCarToBe.anchor = GridBagConstraints.NORTH;
		gbc_lblCarToBe.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblCarToBe.insets = new Insets(0, 0, 5, 0);
		gbc_lblCarToBe.gridx = 1;
		gbc_lblCarToBe.gridy = 1;
		contentPane.add(lblCarToBe, gbc_lblCarToBe);
		
		edit_car_id = new JTextField();
		edit_car_id.setForeground(Color.BLACK);
		GridBagConstraints gbc_edit_car_id = new GridBagConstraints();
		gbc_edit_car_id.anchor = GridBagConstraints.NORTH;
		gbc_edit_car_id.fill = GridBagConstraints.HORIZONTAL;
		gbc_edit_car_id.insets = new Insets(0, 0, 5, 0);
		gbc_edit_car_id.gridx = 1;
		gbc_edit_car_id.gridy = 2;
		contentPane.add(edit_car_id, gbc_edit_car_id);
		edit_car_id.setColumns(10);
		
		JButton show_cars = new JButton("SHOW ALL CARS");
		show_cars.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { //SHOW ALL CARS
				try {
					Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cars", "root", "");
					
					PreparedStatement st = myConn.prepareStatement("SELECT * FROM car");
					ResultSet resultSet = st.executeQuery();
					
					while(resultSet.next()){
						System.out.println("Car ID: " +resultSet.getString("car_id"));						
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		GridBagConstraints gbc_show_cars = new GridBagConstraints();
		gbc_show_cars.insets = new Insets(0, 0, 5, 0);
		gbc_show_cars.anchor = GridBagConstraints.NORTH;
		gbc_show_cars.fill = GridBagConstraints.HORIZONTAL;
		gbc_show_cars.gridx = 1;
		gbc_show_cars.gridy = 3;
		contentPane.add(show_cars, gbc_show_cars);
		
		JButton edit = new JButton("EDIT");
		edit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {	
				try {
					Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cars", "root", "");
					
					PreparedStatement st = myConn.prepareStatement("SELECT car_id FROM car");
					ResultSet resultSet = st.executeQuery();
					
					ArrayList<String> ids = new ArrayList<String>(); //CHECKS IF THE ID YOU TYPED EXISTS IN THE DATABASE				
					while(resultSet.next()){ 
						ids.add(resultSet.getString("Car_id"));	
						
					}
					boolean exist = false;
					for(int i = 0; i<ids.size(); i++){
						if(ids.get(i).equals(edit_car_id.getText().toString())){
							exist = true;
							break;
						}
						else
							exist = false;
					}
					if(exist == false)
						JOptionPane.showMessageDialog(null, "No car with ID: " +edit_car_id.getText().toString() +" founded!");
					else{ //IF THE ID YOU TYPED EXISTS IN THE DATABASE THEN EDIT
						crid = edit_car_id.getText();
						edit_cr edcr = new edit_cr(crid);
						edcr.setVisible(true);	
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		GridBagConstraints gbc_edit = new GridBagConstraints();
		gbc_edit.insets = new Insets(0, 0, 5, 0);
		gbc_edit.anchor = GridBagConstraints.NORTH;
		gbc_edit.fill = GridBagConstraints.HORIZONTAL;
		gbc_edit.gridx = 1;
		gbc_edit.gridy = 4;
		contentPane.add(edit, gbc_edit);
	}
}
