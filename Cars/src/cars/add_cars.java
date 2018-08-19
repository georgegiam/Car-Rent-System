package cars;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.Statement;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.text.ParseException;

import java.util.ArrayList;

import java.awt.event.ActionEvent;
import java.awt.Choice;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;


public class add_cars extends JFrame {

	private JPanel contentPane;
	private JTextField car_id;
	private JTextField doors;
	private JTextField seats;
	private JTextField price;
	private	Choice conv;
	private Choice type;
	private Choice gas;
	private JTextField shop_id;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					add_cars frame = new add_cars();
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
	@SuppressWarnings("deprecation")
	public add_cars() {
		
		setBounds(100, 100, 401, 356);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
			GridBagLayout gbl_contentPane = new GridBagLayout();
			gbl_contentPane.columnWidths = new int[]{130, 228, 0};
			gbl_contentPane.rowHeights = new int[]{20, 20, 20, 20, 20, 20, 20, 35, 20, 23, 23, 0};
			gbl_contentPane.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
			gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
			contentPane.setLayout(gbl_contentPane);
			
			JLabel lblNewLabel = new JLabel("ID");
			GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
			gbc_lblNewLabel.fill = GridBagConstraints.HORIZONTAL;
			gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel.gridx = 0;
			gbc_lblNewLabel.gridy = 0;
			contentPane.add(lblNewLabel, gbc_lblNewLabel);
			
			car_id = new JTextField();
			GridBagConstraints gbc_car_id = new GridBagConstraints();
			gbc_car_id.anchor = GridBagConstraints.NORTH;
			gbc_car_id.fill = GridBagConstraints.HORIZONTAL;
			gbc_car_id.insets = new Insets(0, 0, 5, 0);
			gbc_car_id.gridx = 1;
			gbc_car_id.gridy = 0;
			contentPane.add(car_id, gbc_car_id);
			car_id.setColumns(10);
			
			JLabel lblNewLabel_1 = new JLabel("CAR TYPE ");
			GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
			gbc_lblNewLabel_1.anchor = GridBagConstraints.SOUTH;
			gbc_lblNewLabel_1.fill = GridBagConstraints.HORIZONTAL;
			gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_1.gridx = 0;
			gbc_lblNewLabel_1.gridy = 1;
			contentPane.add(lblNewLabel_1, gbc_lblNewLabel_1);
			
			
				type = new Choice();
				type.add("Small");
				type.add("Medium");
				type.add("Big");
				GridBagConstraints gbc_type = new GridBagConstraints();
				gbc_type.anchor = GridBagConstraints.NORTH;
				gbc_type.fill = GridBagConstraints.HORIZONTAL;
				gbc_type.insets = new Insets(0, 0, 5, 0);
				gbc_type.gridx = 1;
				gbc_type.gridy = 1;
				contentPane.add(type, gbc_type);
			
			conv = new Choice();
			conv.add("No");
			conv.add("Yes");
			
			JLabel lblNewLabel_2 = new JLabel("CONVENTIONAL");
			GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
			gbc_lblNewLabel_2.anchor = GridBagConstraints.SOUTH;
			gbc_lblNewLabel_2.fill = GridBagConstraints.HORIZONTAL;
			gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_2.gridx = 0;
			gbc_lblNewLabel_2.gridy = 2;
			contentPane.add(lblNewLabel_2, gbc_lblNewLabel_2);
			GridBagConstraints gbc_conv = new GridBagConstraints();
			gbc_conv.anchor = GridBagConstraints.NORTH;
			gbc_conv.fill = GridBagConstraints.HORIZONTAL;
			gbc_conv.insets = new Insets(0, 0, 5, 0);
			gbc_conv.gridx = 1;
			gbc_conv.gridy = 2;
			contentPane.add(conv, gbc_conv);
			
			JLabel lblNewLabel_3 = new JLabel("GAS TYPE ");
			GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
			gbc_lblNewLabel_3.fill = GridBagConstraints.HORIZONTAL;
			gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_3.gridx = 0;
			gbc_lblNewLabel_3.gridy = 3;
			contentPane.add(lblNewLabel_3, gbc_lblNewLabel_3);
			

			
			gas = new Choice();
			gas.add("Oil");
			gas.add("Gas");
			GridBagConstraints gbc_gas = new GridBagConstraints();
			gbc_gas.anchor = GridBagConstraints.NORTH;
			gbc_gas.fill = GridBagConstraints.HORIZONTAL;
			gbc_gas.insets = new Insets(0, 0, 5, 0);
			gbc_gas.gridx = 1;
			gbc_gas.gridy = 3;
			contentPane.add(gas, gbc_gas);
			
			JLabel lblNewLabel_4 = new JLabel("DOORS");
			GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
			gbc_lblNewLabel_4.fill = GridBagConstraints.HORIZONTAL;
			gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_4.gridx = 0;
			gbc_lblNewLabel_4.gridy = 4;
			contentPane.add(lblNewLabel_4, gbc_lblNewLabel_4);
			
			doors = new JTextField();
			GridBagConstraints gbc_doors = new GridBagConstraints();
			gbc_doors.anchor = GridBagConstraints.NORTH;
			gbc_doors.fill = GridBagConstraints.HORIZONTAL;
			gbc_doors.insets = new Insets(0, 0, 5, 0);
			gbc_doors.gridx = 1;
			gbc_doors.gridy = 4;
			contentPane.add(doors, gbc_doors);
			doors.setColumns(10);
			
			JLabel lblNewLabel_5 = new JLabel("SEATS");
			GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
			gbc_lblNewLabel_5.fill = GridBagConstraints.HORIZONTAL;
			gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_5.gridx = 0;
			gbc_lblNewLabel_5.gridy = 5;
			contentPane.add(lblNewLabel_5, gbc_lblNewLabel_5);
			
			seats = new JTextField();
			GridBagConstraints gbc_seats = new GridBagConstraints();
			gbc_seats.anchor = GridBagConstraints.NORTH;
			gbc_seats.fill = GridBagConstraints.HORIZONTAL;
			gbc_seats.insets = new Insets(0, 0, 5, 0);
			gbc_seats.gridx = 1;
			gbc_seats.gridy = 5;
			contentPane.add(seats, gbc_seats);
			seats.setColumns(10);
			
			JLabel lblNewLabel_6 = new JLabel("PRICE (PER DAY)");
			GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
			gbc_lblNewLabel_6.fill = GridBagConstraints.HORIZONTAL;
			gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_6.gridx = 0;
			gbc_lblNewLabel_6.gridy = 6;
			contentPane.add(lblNewLabel_6, gbc_lblNewLabel_6);
			
			price = new JTextField();
			GridBagConstraints gbc_price = new GridBagConstraints();
			gbc_price.anchor = GridBagConstraints.NORTH;
			gbc_price.fill = GridBagConstraints.HORIZONTAL;
			gbc_price.insets = new Insets(0, 0, 5, 0);
			gbc_price.gridx = 1;
			gbc_price.gridy = 6;
			contentPane.add(price, gbc_price);
			price.setColumns(10);
			
			JLabel lblShop = new JLabel("SHOP ID TO ADD");
			GridBagConstraints gbc_lblShop = new GridBagConstraints();
			gbc_lblShop.anchor = GridBagConstraints.WEST;
			gbc_lblShop.insets = new Insets(0, 0, 5, 5);
			gbc_lblShop.gridx = 0;
			gbc_lblShop.gridy = 8;
			contentPane.add(lblShop, gbc_lblShop);
		
		shop_id = new JTextField();
		GridBagConstraints gbc_shop_id = new GridBagConstraints();
		gbc_shop_id.anchor = GridBagConstraints.NORTH;
		gbc_shop_id.fill = GridBagConstraints.HORIZONTAL;
		gbc_shop_id.insets = new Insets(0, 0, 5, 0);
		gbc_shop_id.gridx = 1;
		gbc_shop_id.gridy = 8;
		contentPane.add(shop_id, gbc_shop_id);
		shop_id.setColumns(10);
		
		JButton btnShowShops = new JButton("SHOW SHOPS");
		btnShowShops.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { //SHOW SHOPS
				try {
					Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cars", "root", "");
					
					PreparedStatement st = myConn.prepareStatement("SELECT * FROM shop");
					ResultSet resultSet = st.executeQuery();
					
					while(resultSet.next()){
						System.out.println("Shop ID: " +resultSet.getString("shop_id") +"\n"
								+"Town: " +resultSet.getString("Town") +"\n");					
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		GridBagConstraints gbc_btnShowShops = new GridBagConstraints();
		gbc_btnShowShops.anchor = GridBagConstraints.NORTH;
		gbc_btnShowShops.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnShowShops.insets = new Insets(0, 0, 5, 0);
		gbc_btnShowShops.gridx = 1;
		gbc_btnShowShops.gridy = 9;
		contentPane.add(btnShowShops, gbc_btnShowShops);
		
		JButton submit = new JButton("SUBMIT");
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { //SUBMIT	
				if(car_id.getText().equals("") || doors.getText().equals("") || seats.getText().equals("") || price.getText().equals(""))
					JOptionPane.showMessageDialog(null, "You must complete all the fields!");
				else{
					try {
						Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cars", "root", "");
						
						PreparedStatement st = myConn.prepareStatement("SELECT shop_id FROM shop");
						ResultSet resultSet = st.executeQuery();
						
						ArrayList<String> ids = new ArrayList<String>(); //CHECKS IF THE ID YOU TYPED EXISTS IN THE DATABASE				
						while(resultSet.next()){ 
							ids.add(resultSet.getString("shop_id"));								
						}
						
						boolean exist = false;
						for(int i = 0; i<ids.size(); i++){
							if(ids.get(i).equals(shop_id.getText().toString())){
								exist = true;
								break;
							}							
							else
								exist = false;
						}
						if(exist == false)
							JOptionPane.showMessageDialog(null, "No shop with ID " +shop_id.getText().toString() +" founded!");
						else{ //IF THE ID YOU TYPED EXISTS IN THE DATABASE THEN SUBMIT
							try {
								Connection myConn1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/cars", "root", "");						
								
								
								PreparedStatement st1 = myConn1.prepareStatement("INSERT INTO car(car_id, car_type, seats, doors, conv, "
										+ "fuel_type, price, shop_id, rnt) VALUES(?, ?, ?, ?, ?, ?, ?, ?, 0)");		
								
								
								
								st1.setString(1, car_id.getText());
								st1.setString(2, type.getSelectedItem().toString());
								st1.setInt(3, Integer.parseInt(seats.getText()));
								st1.setInt(4, Integer.parseInt(doors.getText()));
								st1.setString(5, conv.getSelectedItem().toString());
								st1.setString(6, gas.getSelectedItem().toString());													
								st1.setDouble(7, Double.parseDouble(price.getText()));
								st1.setString(8, shop_id.getText());

								st1.executeUpdate();								
								
								JOptionPane.showMessageDialog(null, "Car " +car_id.getText() +" added succesfully!");								
																	
							} catch (SQLException e1) {
								e1.printStackTrace();
								JOptionPane.showMessageDialog(null, "Car add failed!");								
							
						}
						}} catch (SQLException e1) {
							e1.printStackTrace();
					}					
				}			
			}			
		});
		GridBagConstraints gbc_submit = new GridBagConstraints();
		gbc_submit.anchor = GridBagConstraints.NORTH;
		gbc_submit.fill = GridBagConstraints.HORIZONTAL;
		gbc_submit.gridx = 1;
		gbc_submit.gridy = 10;
		contentPane.add(submit, gbc_submit);
	}
}
