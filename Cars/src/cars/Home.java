package cars;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JProgressBar;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class Home {

	private JFrame frame;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home window = new Home();
					window.frame.setVisible(true);
					Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cars", "root", "");				
					JOptionPane.showMessageDialog(null, "Connected to Database");			
				} catch (Exception e) {					
					JOptionPane.showMessageDialog(null, "Can't connect to Database");
					
				}				
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Home() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {		
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 17));
		frame.setBounds(100, 100, 549, 343);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{110, 151, 131, 136, 0};
		gridBagLayout.rowHeights = new int[]{25, 17, 23, 23, 23, 23, 44, 17, 23, 23, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		
		JButton btnNewButton_5 = new JButton("DELETE COSTUMER");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { //DELETE COSTUMER
				delete_costumer delete = new delete_costumer();
				delete.setVisible(true);
			}
		});
		
		JLabel lblNewLabel = new JLabel("Welcome to UniPi Rent A Car");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 17));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNewLabel.anchor = GridBagConstraints.NORTH;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.gridwidth = 4;
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		frame.getContentPane().add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("CARS");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Arial Black", Font.BOLD, 11));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.NORTH;
		gbc_lblNewLabel_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		frame.getContentPane().add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		JButton btnNewButton_3 = new JButton("EDIT CAR");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) { //EDIT CAR
				edit_car ed = new edit_car();
				ed.setVisible(true);
			}
		});
		
		JButton btnNewButton = new JButton("ADD COSTUMER");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) { //ADD COSTUMER
				add_costumer add = new add_costumer();
				add.setVisible(true);
			}
		});
		
		JLabel lblNewLabel_2 = new JLabel("COSTUMERS");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Arial Black", Font.BOLD, 11));
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.NORTH;
		gbc_lblNewLabel_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 1;
		gbc_lblNewLabel_2.gridy = 1;
		frame.getContentPane().add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		JLabel lblRents = new JLabel("RENTS");
		lblRents.setHorizontalAlignment(SwingConstants.CENTER);
		lblRents.setFont(new Font("Arial Black", Font.BOLD, 11));
		GridBagConstraints gbc_lblRents = new GridBagConstraints();
		gbc_lblRents.anchor = GridBagConstraints.NORTH;
		gbc_lblRents.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblRents.insets = new Insets(0, 0, 5, 5);
		gbc_lblRents.gridx = 2;
		gbc_lblRents.gridy = 1;
		frame.getContentPane().add(lblRents, gbc_lblRents);
		
		JButton show_cars = new JButton("SHOW CARS");
		show_cars.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { //SHOW CARS
				try {
					Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cars", "root", "");
					
					PreparedStatement st = myConn.prepareStatement("SELECT * FROM car");
					ResultSet resultSet = st.executeQuery();
					
					while(resultSet.next()){
						System.out.println("Car ID: " +resultSet.getString("car_id") +"\n"
								+"Car Type: " +resultSet.getString("car_type") +"\n"
								+"Conventional: " +resultSet.getString("conv") +"\n"
								+"Gas Type: " +resultSet.getString("fuel_type") +"\n"
								+"Number of seats: " +resultSet.getString("seats") +"\n"
								+"Number of doors: " +resultSet.getString("doors") +"\n"
								+"Price: " +resultSet.getString("price") +"\n"
								+"Shop ID: " +resultSet.getString("shop_id") +"\n\n");					
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		JLabel lblShops = new JLabel("SHOPS");
		lblShops.setFont(new Font("Arial Black", Font.BOLD, 11));
		lblShops.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblShops = new GridBagConstraints();
		gbc_lblShops.anchor = GridBagConstraints.NORTH;
		gbc_lblShops.insets = new Insets(0, 0, 5, 0);
		gbc_lblShops.gridx = 3;
		gbc_lblShops.gridy = 1;
		frame.getContentPane().add(lblShops, gbc_lblShops);
		GridBagConstraints gbc_show_cars = new GridBagConstraints();
		gbc_show_cars.anchor = GridBagConstraints.NORTH;
		gbc_show_cars.fill = GridBagConstraints.HORIZONTAL;
		gbc_show_cars.insets = new Insets(0, 0, 5, 5);
		gbc_show_cars.gridx = 0;
		gbc_show_cars.gridy = 2;
		frame.getContentPane().add(show_cars, gbc_show_cars);
		
		JButton btnNewButton_1 = new JButton("SHOW COSTUMERS");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) { //SHOW COSTUMERS
				try {
					Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cars", "root", "");
					
					PreparedStatement st = myConn.prepareStatement("SELECT * FROM customer");
					ResultSet resultSet = st.executeQuery();
					
					while(resultSet.next()){
						System.out.println("First Name: " +resultSet.getString("first_name") +"\n"
								+"Last Name: " +resultSet.getString("last_name") +"\n"
								+"Email: " +resultSet.getString("email") +"\n"
								+"Drive ID: " +resultSet.getString("lisence_id") +"\n"
								+"Home Phone: " +resultSet.getString("home_phone") +"\n"
								+"Mobile Phone: " +resultSet.getString("mobile_phone")+"\n");						
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.anchor = GridBagConstraints.NORTH;
		gbc_btnNewButton_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_1.gridx = 1;
		gbc_btnNewButton_1.gridy = 2;
		frame.getContentPane().add(btnNewButton_1, gbc_btnNewButton_1);
		
		JButton add_car = new JButton("ADD CAR");
		add_car.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) { //ADD CAR
				add_cars car = new add_cars();
				car.setVisible(true);
			}
		});
		
		JButton btnShowRents = new JButton("SHOW RENTS");
		btnShowRents.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { //SHOW RENTS
				try {
					Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cars", "root", "");
					
					PreparedStatement st = myConn.prepareStatement("SELECT * FROM rent");
					ResultSet resultSet = st.executeQuery();
					
					while(resultSet.next()){
						System.out.println("Rented ID: " +resultSet.getString("rent_id") +"\n"
								+"Pickup Date: " +resultSet.getString("pickup_date_time") +"\n"
								+"Return Date: " +resultSet.getString("return_date_time") +"\n"
								+"Pickup Place: " +resultSet.getString("pickup_place") +"\n"
								+"Return Place: " +resultSet.getString("return_place") +"\n");					
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		GridBagConstraints gbc_btnShowRents = new GridBagConstraints();
		gbc_btnShowRents.anchor = GridBagConstraints.NORTH;
		gbc_btnShowRents.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnShowRents.insets = new Insets(0, 0, 5, 5);
		gbc_btnShowRents.gridx = 2;
		gbc_btnShowRents.gridy = 2;
		frame.getContentPane().add(btnShowRents, gbc_btnShowRents);
		
		JButton btnAddShop = new JButton("ADD SHOP");
		btnAddShop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) { //ADD SHOP
				add_shop add = new add_shop();
				add.setVisible(true);
			}
		});
		GridBagConstraints gbc_btnAddShop = new GridBagConstraints();
		gbc_btnAddShop.anchor = GridBagConstraints.NORTH;
		gbc_btnAddShop.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnAddShop.insets = new Insets(0, 0, 5, 0);
		gbc_btnAddShop.gridx = 3;
		gbc_btnAddShop.gridy = 2;
		frame.getContentPane().add(btnAddShop, gbc_btnAddShop);
		GridBagConstraints gbc_add_car = new GridBagConstraints();
		gbc_add_car.anchor = GridBagConstraints.NORTH;
		gbc_add_car.fill = GridBagConstraints.HORIZONTAL;
		gbc_add_car.insets = new Insets(0, 0, 5, 5);
		gbc_add_car.gridx = 0;
		gbc_add_car.gridy = 3;
		frame.getContentPane().add(add_car, gbc_add_car);
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.anchor = GridBagConstraints.NORTH;
		gbc_btnNewButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 1;
		gbc_btnNewButton.gridy = 3;
		frame.getContentPane().add(btnNewButton, gbc_btnNewButton);
		
		JButton btnEditRent = new JButton("EDIT RENT");
		btnEditRent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				edit_rent edit = new edit_rent();
				edit.setVisible(true);
			}
		});
		GridBagConstraints gbc_btnEditRent = new GridBagConstraints();
		gbc_btnEditRent.anchor = GridBagConstraints.NORTH;
		gbc_btnEditRent.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnEditRent.insets = new Insets(0, 0, 5, 5);
		gbc_btnEditRent.gridx = 2;
		gbc_btnEditRent.gridy = 3;
		frame.getContentPane().add(btnEditRent, gbc_btnEditRent);
		GridBagConstraints gbc_btnNewButton_3 = new GridBagConstraints();
		gbc_btnNewButton_3.anchor = GridBagConstraints.NORTH;
		gbc_btnNewButton_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNewButton_3.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_3.gridx = 0;
		gbc_btnNewButton_3.gridy = 4;
		frame.getContentPane().add(btnNewButton_3, gbc_btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("EDIT COSTUMER");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) { //EDIT COSTUMER
				edit_costumer edit = new edit_costumer();
				edit.setVisible(true);
			}
		});
		GridBagConstraints gbc_btnNewButton_4 = new GridBagConstraints();
		gbc_btnNewButton_4.anchor = GridBagConstraints.NORTH;
		gbc_btnNewButton_4.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNewButton_4.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_4.gridx = 1;
		gbc_btnNewButton_4.gridy = 4;
		frame.getContentPane().add(btnNewButton_4, gbc_btnNewButton_4);
		
		JButton btnDeleteRent = new JButton("DELETE RENT");
		btnDeleteRent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				delete_rent delete = new delete_rent();
				delete.setVisible(true);
			}
		});
		GridBagConstraints gbc_btnDeleteRent = new GridBagConstraints();
		gbc_btnDeleteRent.anchor = GridBagConstraints.NORTH;
		gbc_btnDeleteRent.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnDeleteRent.insets = new Insets(0, 0, 5, 5);
		gbc_btnDeleteRent.gridx = 2;
		gbc_btnDeleteRent.gridy = 4;
		frame.getContentPane().add(btnDeleteRent, gbc_btnDeleteRent);
		
		JButton btnNewButton_2 = new JButton("DELETE CAR");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				delete_car delete = new delete_car();
				delete.setVisible(true);
			}
		});
		GridBagConstraints gbc_btnNewButton_2 = new GridBagConstraints();
		gbc_btnNewButton_2.anchor = GridBagConstraints.NORTH;
		gbc_btnNewButton_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNewButton_2.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_2.gridx = 0;
		gbc_btnNewButton_2.gridy = 5;
		frame.getContentPane().add(btnNewButton_2, gbc_btnNewButton_2);
		GridBagConstraints gbc_btnNewButton_5 = new GridBagConstraints();
		gbc_btnNewButton_5.anchor = GridBagConstraints.NORTH;
		gbc_btnNewButton_5.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNewButton_5.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_5.gridx = 1;
		gbc_btnNewButton_5.gridy = 5;
		frame.getContentPane().add(btnNewButton_5, gbc_btnNewButton_5);
		
		JLabel lblCarRentingMenu = new JLabel("CAR RENTING MENU");
		lblCarRentingMenu.setFont(new Font("Arial Black", Font.BOLD, 11));
		GridBagConstraints gbc_lblCarRentingMenu = new GridBagConstraints();
		gbc_lblCarRentingMenu.anchor = GridBagConstraints.NORTH;
		gbc_lblCarRentingMenu.insets = new Insets(0, 0, 5, 5);
		gbc_lblCarRentingMenu.gridwidth = 2;
		gbc_lblCarRentingMenu.gridx = 1;
		gbc_lblCarRentingMenu.gridy = 7;
		frame.getContentPane().add(lblCarRentingMenu, gbc_lblCarRentingMenu);
		
		JButton btnRentACar = new JButton("RENT A CAR");
		btnRentACar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) { // RENT A CAR 
				rent_car rent = new rent_car();
				rent.setVisible(true);
			}
		});
		GridBagConstraints gbc_btnRentACar = new GridBagConstraints();
		gbc_btnRentACar.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnRentACar.anchor = GridBagConstraints.NORTH;
		gbc_btnRentACar.insets = new Insets(0, 0, 5, 5);
		gbc_btnRentACar.gridwidth = 2;
		gbc_btnRentACar.gridx = 1;
		gbc_btnRentACar.gridy = 8;
		frame.getContentPane().add(btnRentACar, gbc_btnRentACar);
		
	
	}
}
