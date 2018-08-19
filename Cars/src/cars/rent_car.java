package cars;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import java.awt.Choice;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import java.util.Date;
import java.util.Locale;
import java.awt.Font;

public class rent_car extends JFrame {

	private JPanel submit;
	private JTextField pickup_place;
	private JTextField return_place;
	private JTextField car_id;
	private Choice type;
	private JSpinner r_minute;
	private JSpinner r_hour;
	private JSpinner p_minute;
	private JSpinner p_hour;
	private JTextField drive_id;
	ArrayList<String> ids = new ArrayList<String>(); //GETTING NON RENTED CAR ID

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					rent_car frame = new rent_car();
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
	public rent_car() {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 481, 389);
		submit = new JPanel();
		submit.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(submit);
		GridBagLayout gbl_submit = new GridBagLayout();
		gbl_submit.columnWidths = new int[]{198, 34, 34, 59, 39, 44, 0};
		gbl_submit.rowHeights = new int[]{20, 20, 21, 21, 20, 23, 23, 20, 21, 23, 20, 23, 0};
		gbl_submit.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_submit.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		submit.setLayout(gbl_submit);
		
		JLabel lblNewLabel = new JLabel("PICKUP PLACE");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		submit.add(lblNewLabel, gbc_lblNewLabel);
		
		pickup_place = new JTextField();
		GridBagConstraints gbc_pickup_place = new GridBagConstraints();
		gbc_pickup_place.anchor = GridBagConstraints.NORTH;
		gbc_pickup_place.fill = GridBagConstraints.HORIZONTAL;
		gbc_pickup_place.insets = new Insets(0, 0, 5, 0);
		gbc_pickup_place.gridwidth = 5;
		gbc_pickup_place.gridx = 1;
		gbc_pickup_place.gridy = 0;
		submit.add(pickup_place, gbc_pickup_place);
		pickup_place.setColumns(10);
		
		JLabel lblReturnPlace = new JLabel("RETURN PLACE");
		GridBagConstraints gbc_lblReturnPlace = new GridBagConstraints();
		gbc_lblReturnPlace.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblReturnPlace.insets = new Insets(0, 0, 5, 5);
		gbc_lblReturnPlace.gridx = 0;
		gbc_lblReturnPlace.gridy = 1;
		submit.add(lblReturnPlace, gbc_lblReturnPlace);
		
		return_place = new JTextField();
		GridBagConstraints gbc_return_place = new GridBagConstraints();
		gbc_return_place.anchor = GridBagConstraints.NORTH;
		gbc_return_place.fill = GridBagConstraints.HORIZONTAL;
		gbc_return_place.insets = new Insets(0, 0, 5, 0);
		gbc_return_place.gridwidth = 5;
		gbc_return_place.gridx = 1;
		gbc_return_place.gridy = 1;
		submit.add(return_place, gbc_return_place);
		return_place.setColumns(10);
		
		Choice r_date = new Choice();
		r_date.add("01"); 
		r_date.add("02"); 
		r_date.add("03"); 
		r_date.add("04"); 
		r_date.add("05"); 
		r_date.add("06"); 
		r_date.add("07"); 
		r_date.add("08");
		r_date.add("09"); 
		r_date.add("10"); 
		r_date.add("11"); 
		r_date.add("12"); 
		r_date.add("13"); 
		r_date.add("14"); 
		r_date.add("15"); 
		r_date.add("16");
		r_date.add("17"); 
		r_date.add("18"); 
		r_date.add("19"); 
		r_date.add("20"); 
		r_date.add("21"); 
		r_date.add("22"); 
		r_date.add("23"); 
		r_date.add("24");
		r_date.add("25"); 
		r_date.add("26"); 
		r_date.add("27"); 
		r_date.add("28"); 
		r_date.add("29"); 
		r_date.add("30"); 
		r_date.add("31");
		
		Choice p_date = new Choice();
		p_date.add("01"); 
		p_date.add("02"); 
		p_date.add("03"); 
		p_date.add("04"); 
		p_date.add("05"); 
		p_date.add("06"); 
		p_date.add("07"); 
		p_date.add("08");
		p_date.add("09"); 
		p_date.add("10"); 
		p_date.add("11"); 
		p_date.add("12"); 
		p_date.add("13"); 
		p_date.add("14"); 
		p_date.add("15"); 
		p_date.add("16");
		p_date.add("17"); 
		p_date.add("18"); 
		p_date.add("19"); 
		p_date.add("20"); 
		p_date.add("21"); 
		p_date.add("22"); 
		p_date.add("23"); 
		p_date.add("24");
		p_date.add("25"); 
		p_date.add("26"); 
		p_date.add("27"); 
		p_date.add("28"); 
		p_date.add("29"); 
		p_date.add("30"); 
		p_date.add("31");
		
		JLabel lblPickupDate = new JLabel("PICKUP DATE (D/M/Y/T/M)");
		GridBagConstraints gbc_lblPickupDate = new GridBagConstraints();
		gbc_lblPickupDate.anchor = GridBagConstraints.NORTH;
		gbc_lblPickupDate.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblPickupDate.insets = new Insets(0, 0, 5, 5);
		gbc_lblPickupDate.gridx = 0;
		gbc_lblPickupDate.gridy = 2;
		submit.add(lblPickupDate, gbc_lblPickupDate);
		GridBagConstraints gbc_p_date = new GridBagConstraints();
		gbc_p_date.anchor = GridBagConstraints.SOUTH;
		gbc_p_date.fill = GridBagConstraints.HORIZONTAL;
		gbc_p_date.insets = new Insets(0, 0, 5, 5);
		gbc_p_date.gridx = 1;
		gbc_p_date.gridy = 2;
		submit.add(p_date, gbc_p_date);
		
		Choice p_month = new Choice();
		p_month.add("01"); 
		p_month.add("02"); 
		p_month.add("03"); 
		p_month.add("04"); 
		p_month.add("05"); 
		p_month.add("06"); 
		p_month.add("07"); 
		p_month.add("08");
		p_month.add("09"); 
		p_month.add("10"); 
		p_month.add("11"); 
		p_month.add("12");
		GridBagConstraints gbc_p_month = new GridBagConstraints();
		gbc_p_month.anchor = GridBagConstraints.SOUTH;
		gbc_p_month.fill = GridBagConstraints.HORIZONTAL;
		gbc_p_month.insets = new Insets(0, 0, 5, 5);
		gbc_p_month.gridx = 2;
		gbc_p_month.gridy = 2;
		submit.add(p_month, gbc_p_month);
		
		Choice p_year = new Choice();
		p_year.add("2018"); 
		p_year.add("2019"); 
		p_year.add("2020"); 
		p_year.add("2021"); 
		p_year.add("2022"); 
		p_year.add("2023"); 
		p_year.add("2024");
		GridBagConstraints gbc_p_year = new GridBagConstraints();
		gbc_p_year.anchor = GridBagConstraints.SOUTH;
		gbc_p_year.fill = GridBagConstraints.HORIZONTAL;
		gbc_p_year.insets = new Insets(0, 0, 5, 5);
		gbc_p_year.gridx = 3;
		gbc_p_year.gridy = 2;
		submit.add(p_year, gbc_p_year);
		
		p_hour = new JSpinner();
		p_hour.setModel(new SpinnerNumberModel(1, 1, 23, 1));
		GridBagConstraints gbc_p_hour = new GridBagConstraints();
		gbc_p_hour.anchor = GridBagConstraints.NORTHWEST;
		gbc_p_hour.insets = new Insets(0, 0, 5, 5);
		gbc_p_hour.gridx = 4;
		gbc_p_hour.gridy = 2;
		submit.add(p_hour, gbc_p_hour);
		
		p_minute = new JSpinner();
		p_minute.setModel(new SpinnerNumberModel(1, 1, 59, 1));
		GridBagConstraints gbc_p_minute = new GridBagConstraints();
		gbc_p_minute.anchor = GridBagConstraints.NORTH;
		gbc_p_minute.fill = GridBagConstraints.HORIZONTAL;
		gbc_p_minute.insets = new Insets(0, 0, 5, 0);
		gbc_p_minute.gridx = 5;
		gbc_p_minute.gridy = 2;
		submit.add(p_minute, gbc_p_minute);
		
		JLabel lblReturnDate = new JLabel("RETURN DATE (D/M/Y/T/M)");
		GridBagConstraints gbc_lblReturnDate = new GridBagConstraints();
		gbc_lblReturnDate.anchor = GridBagConstraints.NORTH;
		gbc_lblReturnDate.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblReturnDate.insets = new Insets(0, 0, 5, 5);
		gbc_lblReturnDate.gridx = 0;
		gbc_lblReturnDate.gridy = 3;
		submit.add(lblReturnDate, gbc_lblReturnDate);
		GridBagConstraints gbc_r_date = new GridBagConstraints();
		gbc_r_date.anchor = GridBagConstraints.SOUTH;
		gbc_r_date.fill = GridBagConstraints.HORIZONTAL;
		gbc_r_date.insets = new Insets(0, 0, 5, 5);
		gbc_r_date.gridx = 1;
		gbc_r_date.gridy = 3;
		submit.add(r_date, gbc_r_date);
		
		Choice r_month = new Choice();
		r_month.add("01"); 
		r_month.add("02"); 
		r_month.add("03"); 
		r_month.add("04"); 
		r_month.add("05"); 
		r_month.add("06"); 
		r_month.add("07"); 
		r_month.add("08");
		r_month.add("09"); 
		r_month.add("10"); 
		r_month.add("11"); 
		r_month.add("12");
		GridBagConstraints gbc_r_month = new GridBagConstraints();
		gbc_r_month.anchor = GridBagConstraints.SOUTH;
		gbc_r_month.fill = GridBagConstraints.HORIZONTAL;
		gbc_r_month.insets = new Insets(0, 0, 5, 5);
		gbc_r_month.gridx = 2;
		gbc_r_month.gridy = 3;
		submit.add(r_month, gbc_r_month);
		
		Choice r_year = new Choice();
		r_year.add("2018"); 
		r_year.add("2019"); 
		r_year.add("2020"); 
		r_year.add("2021"); 
		r_year.add("2022"); 
		r_year.add("2023"); 
		r_year.add("2024");
		GridBagConstraints gbc_r_year = new GridBagConstraints();
		gbc_r_year.anchor = GridBagConstraints.SOUTH;
		gbc_r_year.fill = GridBagConstraints.HORIZONTAL;
		gbc_r_year.insets = new Insets(0, 0, 5, 5);
		gbc_r_year.gridx = 3;
		gbc_r_year.gridy = 3;
		submit.add(r_year, gbc_r_year);
		
		r_hour = new JSpinner();
		r_hour.setModel(new SpinnerNumberModel(1, 1, 23, 1));
		GridBagConstraints gbc_r_hour = new GridBagConstraints();
		gbc_r_hour.anchor = GridBagConstraints.NORTHWEST;
		gbc_r_hour.insets = new Insets(0, 0, 5, 5);
		gbc_r_hour.gridx = 4;
		gbc_r_hour.gridy = 3;
		submit.add(r_hour, gbc_r_hour);
		
		r_minute = new JSpinner();
		r_minute.setModel(new SpinnerNumberModel(1, 1, 59, 1));
		GridBagConstraints gbc_r_minute = new GridBagConstraints();
		gbc_r_minute.anchor = GridBagConstraints.NORTH;
		gbc_r_minute.fill = GridBagConstraints.HORIZONTAL;
		gbc_r_minute.insets = new Insets(0, 0, 5, 0);
		gbc_r_minute.gridx = 5;
		gbc_r_minute.gridy = 3;
		submit.add(r_minute, gbc_r_minute);
		
		JLabel lblCarTypeoptional = new JLabel("CAR TYPE (OPTIONAL)");
		GridBagConstraints gbc_lblCarTypeoptional = new GridBagConstraints();
		gbc_lblCarTypeoptional.anchor = GridBagConstraints.SOUTH;
		gbc_lblCarTypeoptional.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblCarTypeoptional.insets = new Insets(0, 0, 5, 5);
		gbc_lblCarTypeoptional.gridx = 0;
		gbc_lblCarTypeoptional.gridy = 4;
		submit.add(lblCarTypeoptional, gbc_lblCarTypeoptional);
		
		JButton btnShowMyPreferences = new JButton("SHOW AVAILABLE CARS");
		btnShowMyPreferences.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { //SHOW AVAILABLE CARS
				if(pickup_place.getText().equals("") || return_place.getText().equals(""))
					JOptionPane.showMessageDialog(null, "You must complete all the fields!");
				else{
					try {
						Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cars", "root", "");
						
						//1. NON RENTED CARS
						//2. RENTED CARS WITH AVAILABLE DATE	
						
						boolean date_correct = true;
						
						//CONVERT USERS DATE_TIME IN DATE FORMAT
						String p_none = p_year.getSelectedItem().toString() +"-" +p_month.getSelectedItem().toString() +"-"
								+p_date.getSelectedItem().toString(); 
								
						String r_none = r_year.getSelectedItem().toString() +"-" +r_month.getSelectedItem().toString() +"-"
								+r_date.getSelectedItem().toString(); 
						
						LocalDate pickup_d = LocalDate.parse(p_none.toString(), DateTimeFormatter.ISO_LOCAL_DATE);
						LocalDate return_d = LocalDate.parse(r_none.toString(), DateTimeFormatter.ISO_LOCAL_DATE);
						
						
						Duration diff = Duration.between(pickup_d.atStartOfDay(), return_d.atStartOfDay());
						long diffDays = diff.toDays();
						if(diffDays < 0){
							JOptionPane.showMessageDialog(null, "Pickup date must be before return date");
							date_correct = false;
						}	
						
						
						if(date_correct){
							//1
							PreparedStatement st = myConn.prepareStatement("SELECT C.car_id FROM car C, shop S WHERE C.rnt = 0 AND C.car_type = ?"
																			+"AND S.town = ?");
							
							
							st.setString(1, type.getSelectedItem().toString());
							st.setString(2, pickup_place.getText());
							
														
							ResultSet resultSet = st.executeQuery();							
											
							while(resultSet.next()){ 
								ids.add(resultSet.getString("car_id"));									
							}					
							
							
							//2								
							//GETTING RETURN AND PICKUP DATES AND CAR ID
							PreparedStatement st1 = myConn.prepareStatement("SELECT R.car_id, R.return_date_time, R.pickup_date_time, C.car_type "
																			+"FROM rent R, car C WHERE C.car_type = ? AND C.car_id = R.car_id");
							
							st1.setString(1, type.getSelectedItem().toString());
							
							ResultSet resultSet1 = st1.executeQuery();
								
							ArrayList<String> carid = new ArrayList<String>(); 
							ArrayList<String> r_dates = new ArrayList<String>(); 
							ArrayList<String> p_dates = new ArrayList<String>(); 
							while(resultSet1.next()){ 
								carid.add(resultSet1.getString("car_id"));
								r_dates.add(resultSet1.getString("return_date_time"));
								p_dates.add(resultSet1.getString("pickup_date_time"));	
							}							
							
							//CORRECT DATES	
							for(int i = 0; i<carid.size(); i++){
								LocalDate pickup_a = LocalDate.parse(p_dates.get(i), DateTimeFormatter.ISO_LOCAL_DATE);
								LocalDate return_a = LocalDate.parse(r_dates.get(i), DateTimeFormatter.ISO_LOCAL_DATE);
								if(pickup_d.isAfter(return_a))
									ids.add(carid.get(i));
								if(return_d.isBefore(pickup_a))
									ids.add(carid.get(i));
							}								
						}
									
						System.out.println("Available cars IDs\n");
						for(int i = 0; i<ids.size(); i++){ //SHOW ALL THE AVAILABLE CARS
							System.out.println(ids.get(i));
						}											
											
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}						
					} 	
				}			
		});
		
		JButton btnShowRentedCars = new JButton("SHOW RENTED CARS");
		btnShowRentedCars.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try { 
					Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cars", "root", "");
					
					PreparedStatement st = myConn.prepareStatement("SELECT car_id FROM car WHERE rnt = 1");
					ResultSet resultSet = st.executeQuery();
					
					while(resultSet.next()){
						System.out.println("Car ID: " +resultSet.getString("car_id"));					
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		type = new Choice();
		type.add("Small");
		type.add("Medium");
		type.add("Big");
		GridBagConstraints gbc_type = new GridBagConstraints();
		gbc_type.anchor = GridBagConstraints.NORTH;
		gbc_type.fill = GridBagConstraints.HORIZONTAL;
		gbc_type.insets = new Insets(0, 0, 5, 0);
		gbc_type.gridwidth = 5;
		gbc_type.gridx = 1;
		gbc_type.gridy = 4;
		submit.add(type, gbc_type);
		GridBagConstraints gbc_btnShowRentedCars = new GridBagConstraints();
		gbc_btnShowRentedCars.anchor = GridBagConstraints.NORTH;
		gbc_btnShowRentedCars.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnShowRentedCars.insets = new Insets(0, 0, 5, 0);
		gbc_btnShowRentedCars.gridwidth = 5;
		gbc_btnShowRentedCars.gridx = 1;
		gbc_btnShowRentedCars.gridy = 5;
		submit.add(btnShowRentedCars, gbc_btnShowRentedCars);
		GridBagConstraints gbc_btnShowMyPreferences = new GridBagConstraints();
		gbc_btnShowMyPreferences.anchor = GridBagConstraints.NORTH;
		gbc_btnShowMyPreferences.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnShowMyPreferences.insets = new Insets(0, 0, 5, 0);
		gbc_btnShowMyPreferences.gridwidth = 5;
		gbc_btnShowMyPreferences.gridx = 1;
		gbc_btnShowMyPreferences.gridy = 6;
		submit.add(btnShowMyPreferences, gbc_btnShowMyPreferences);
		
		JLabel lblSelectCarId = new JLabel("CAR ID TO RENT");
		GridBagConstraints gbc_lblSelectCarId = new GridBagConstraints();
		gbc_lblSelectCarId.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblSelectCarId.insets = new Insets(0, 0, 5, 5);
		gbc_lblSelectCarId.gridx = 0;
		gbc_lblSelectCarId.gridy = 7;
		submit.add(lblSelectCarId, gbc_lblSelectCarId);
		
		car_id = new JTextField();
		GridBagConstraints gbc_car_id = new GridBagConstraints();
		gbc_car_id.anchor = GridBagConstraints.NORTH;
		gbc_car_id.fill = GridBagConstraints.HORIZONTAL;
		gbc_car_id.insets = new Insets(0, 0, 5, 0);
		gbc_car_id.gridwidth = 5;
		gbc_car_id.gridx = 1;
		gbc_car_id.gridy = 7;
		submit.add(car_id, gbc_car_id);
		car_id.setColumns(10);
		
		JButton btnNewButton = new JButton("SHOW PREFERENCES");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) { //SHOW PREFERENCES
			
				boolean ex = true;
				for(int i = 0; i<ids.size(); i++){ //CHECKS IF THE CAR YOU TYPE IS AVAILABLE OR EXIST
					if(!(car_id.getText().equals(ids.get(i))))					
						ex = false;				
					else{
						ex = true;	
						break;
					}								
				}
				
				if(ex == false)
					JOptionPane.showMessageDialog(null, "This car is unavailable or doesn't exist");
				
				else{ //IF THE ID YOU TYPED EXISTS TEHN SHOW PREFERENCES
						boolean correct_date = true;
						double total = 0;						
					
						String p_none = p_year.getSelectedItem().toString() +"-" +p_month.getSelectedItem().toString() +"-"
								+p_date.getSelectedItem().toString(); 
									
						String r_none = r_year.getSelectedItem().toString() +"-" +r_month.getSelectedItem().toString() +"-"
								+r_date.getSelectedItem().toString(); 
							
						LocalDate pickup_d = LocalDate.parse(p_none.toString(), DateTimeFormatter.ISO_LOCAL_DATE);
						LocalDate return_d = LocalDate.parse(r_none.toString(), DateTimeFormatter.ISO_LOCAL_DATE);
	
						if(correct_date == true){
							try {
								Connection myConn1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/cars", "root", "");									
								
								PreparedStatement st2 = myConn1.prepareStatement("SELECT price FROM car WHERE car_id = ?");									
							
								st2.setString(1, car_id.getText());								
								
								ResultSet resultSet2 = st2.executeQuery();
									
								double[] pr = new double[1];
									
								while(resultSet2.next()){									
									pr[0] = resultSet2.getDouble("price");									
									Duration diff = Duration.between(pickup_d.atStartOfDay(), return_d.atStartOfDay());
									long diffDays = diff.toDays();
									if(diffDays == 0)
										total = pr[0];
									else
										total = diffDays * pr[0];	
									
									JOptionPane.showMessageDialog(null, "Pickup Place: " +pickup_place.getText() +"\n"
									+ "Return Place: " +return_place.getText() +"\n"
									+ "Pickup Date & Time: " +p_date.getSelectedItem() +"/" +p_month.getSelectedItem() +"/" 
									+p_year.getSelectedItem() +" " +p_hour.getValue() +":" +p_minute.getValue() +"\n"
									+ "Return Date: " +r_date.getSelectedItem() +"/" +r_month.getSelectedItem() +"/" 
									+r_year.getSelectedItem() +" " +r_hour.getValue() +":" +r_minute.getValue() +"\n"
									+ "Car Type: " +type.getSelectedItem() +"\n"
									+ "Car ID: " +car_id.getText() +"\n"
									+ "Total Ammount (" +diffDays +" days): " +total +" €"); // total works only for days (not months and years)		
								}
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();					
							}
					}						
						else
							JOptionPane.showMessageDialog(null, "Pickup Date must be before Return Date!");								
				}
			}
		});
		
		JLabel lblCustomerDetails = new JLabel("CUSTOMER DETAILS");
		lblCustomerDetails.setFont(new Font("Arial Black", Font.BOLD, 14));
		GridBagConstraints gbc_lblCustomerDetails = new GridBagConstraints();
		gbc_lblCustomerDetails.anchor = GridBagConstraints.NORTH;
		gbc_lblCustomerDetails.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblCustomerDetails.insets = new Insets(0, 0, 5, 5);
		gbc_lblCustomerDetails.gridx = 0;
		gbc_lblCustomerDetails.gridy = 8;
		submit.add(lblCustomerDetails, gbc_lblCustomerDetails);
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.anchor = GridBagConstraints.NORTH;
		gbc_btnNewButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton.gridwidth = 5;
		gbc_btnNewButton.gridx = 1;
		gbc_btnNewButton.gridy = 9;
		submit.add(btnNewButton, gbc_btnNewButton);
		
		JLabel lblDrivingId = new JLabel("DRIVING ID");
		GridBagConstraints gbc_lblDrivingId = new GridBagConstraints();
		gbc_lblDrivingId.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblDrivingId.insets = new Insets(0, 0, 5, 5);
		gbc_lblDrivingId.gridx = 0;
		gbc_lblDrivingId.gridy = 10;
		submit.add(lblDrivingId, gbc_lblDrivingId);
		
		drive_id = new JTextField();
		GridBagConstraints gbc_drive_id = new GridBagConstraints();
		gbc_drive_id.anchor = GridBagConstraints.NORTH;
		gbc_drive_id.fill = GridBagConstraints.HORIZONTAL;
		gbc_drive_id.insets = new Insets(0, 0, 5, 0);
		gbc_drive_id.gridwidth = 5;
		gbc_drive_id.gridx = 1;
		gbc_drive_id.gridy = 10;
		submit.add(drive_id, gbc_drive_id);
		drive_id.setColumns(10);
		
		JButton sumbit = new JButton("SUBMIT");
		sumbit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { //SUBMIT
				if(pickup_place.getText().equals("") || return_place.getText().equals("") || car_id.getText().equals(""))
					JOptionPane.showMessageDialog(null, "You must complete all the fields");
				else{
					try {
						Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cars", "root", "");					

						
						
						PreparedStatement st17 = myConn.prepareStatement("SELECT car_id FROM car");
						ResultSet resultSet17 = st17.executeQuery();
						
						ArrayList<String> caids = new ArrayList<String>(); //CHECKS IF THE ID YOU TYPED EXISTS IN THE DATABASE				
						while(resultSet17.next()){ 
							caids.add(resultSet17.getString("car_id"));											
						}	
						boolean car_exist = false;
						for(int i = 0; i<caids.size(); i++){
							if(car_id.getText().equals(caids.get(i)))
								car_exist = true;
						}
						
						
						if(car_exist){
							PreparedStatement st2 = myConn.prepareStatement("SELECT car_id FROM rent");
							ResultSet resultSet2 = st2.executeQuery();
							
							ArrayList<String> ids = new ArrayList<String>(); //CHECKS IF THE CAR YOU WANT IS RENTED				
							while(resultSet2.next()){ 
								ids.add(resultSet2.getString("car_id"));	
								
							}
							boolean exist = false;
							for(int i = 0; i<ids.size(); i++){
								if(ids.get(i).equals(car_id.getText())){
									exist = true;
									break;
								}
							}
							if(exist){ //THE CAR IS RENTED
								
								//CHECK THE DATE
								//GETTING CAR ID
								PreparedStatement st3 = myConn.prepareStatement("SELECT pickup_date_time FROM rent WHERE car_id = ?");
								PreparedStatement st4 = myConn.prepareStatement("SELECT return_date_time FROM rent WHERE car_id = ?");
								
								st3.setString(1, car_id.getText());
								st4.setString(1, car_id.getText());
								
								ResultSet resultSet3 = st3.executeQuery();
								ResultSet resultSet4 = st4.executeQuery();
								
								String[] pc_date = new String[1];				
								while(resultSet3.next()){ 
									pc_date[0] = resultSet3.getString("pickup_date_time");								
								}
								LocalDate p_d = LocalDate.parse(pc_date[0].toString(), DateTimeFormatter.ISO_LOCAL_DATE);
								
								String[] rt_date = new String[1];				
								while(resultSet4.next()){ 
									rt_date[0] = resultSet4.getString("return_date_time");								
								}
								LocalDate r_d = LocalDate.parse(rt_date[0].toString(), DateTimeFormatter.ISO_LOCAL_DATE);
								
								//CONVERT USERS DATE_TIME IN DATE FORMAT
								String p_none = p_year.getSelectedItem().toString() +"-" +p_month.getSelectedItem().toString() +"-"
										+p_date.getSelectedItem().toString(); 
										
								String r_none = r_year.getSelectedItem().toString() +"-" +r_month.getSelectedItem().toString() +"-"
										+r_date.getSelectedItem().toString(); 
								
								LocalDate pickup_d = LocalDate.parse(p_none.toString(), DateTimeFormatter.ISO_LOCAL_DATE);
								LocalDate return_d = LocalDate.parse(r_none.toString(), DateTimeFormatter.ISO_LOCAL_DATE);
								
								boolean date_correct = true;
								Duration diff = Duration.between(pickup_d.atStartOfDay(), return_d.atStartOfDay());
								long diffDays = diff.toDays();
								if(diffDays < 0)							
									date_correct = false;
								
								
								if(date_correct){ //USER ADDED A CORRECT DATE SO GO TO RENT
									boolean correct = false;
									//CORRECT DATES FOR RENT THE RENTED CAR
									if(pickup_d.isAfter(r_d))
										correct = true;
									if(return_d.isBefore(p_d))
										correct = true;
									if(correct){
										
										
										String pdate = p_year.getSelectedItem().toString() 
												+ "-" + p_month.getSelectedItem().toString() 
												+ "-" +p_date.getSelectedItem().toString();
										
										String rdate = r_year.getSelectedItem().toString() 
												+ "-" + r_month.getSelectedItem().toString() 
												+ "-" +r_date.getSelectedItem().toString();
										
										//GIVE ID TO THE RENT
										PreparedStatement st9 = myConn.prepareStatement("SELECT rent_id FROM rent");
										ResultSet resultSet9 = st9.executeQuery();
										
										ArrayList<Integer> rids = new ArrayList<Integer>(); //CHECKS IF THE ID YOU TYPED EXISTS IN THE DATABASE				
										while(resultSet9.next()){ 
											rids.add(resultSet9.getInt("rent_id"));											
										}
										
										
										int inid = 0;
										int max = 0;
										if(rids.isEmpty())
											inid = 1;									
										else{
											for(int i = 0; i<ids.size(); i++){												
												if(rids.get(i)>max)
													max = rids.get(i);										
											}
											inid = max + 1;
										}
										
										PreparedStatement st5 = myConn.prepareStatement("INSERT INTO rent(rent_id, pickup_place, pickup_date_time, return_place, "
												+ "return_date_time, car_id, customer_id) VALUES(?, ?, ?, ?, ?, ?, ?)");
										
										st5.setInt(1, inid);
										st5.setString(2, pickup_place.getText());
										st5.setString(3, pdate.toString());
										st5.setString(4, return_place.getText());
										st5.setString(5, rdate.toString());
										st5.setString(6, car_id.getText());
										st5.setString(7, drive_id.getText());
										
										st5.executeUpdate();
										
										PreparedStatement st7 = myConn.prepareStatement("UPDATE car SET rnt = 1 WHERE car_id = ?");
										
										st7.setString(1, car_id.getText());
										
										st7.executeUpdate();
										
										JOptionPane.showMessageDialog(null, "Rent added");	
										
									}
									else
										JOptionPane.showMessageDialog(null, "This car is not available for this date");	
								}
								else
									JOptionPane.showMessageDialog(null, "Pickup date must be before return date");	
							
								
							}
							else
							{ //THE CAR ISN'T RENTED
								//RENT IT	
								String pdate = p_year.getSelectedItem().toString() 
										+ "-" + p_month.getSelectedItem().toString() 
										+ "-" +p_date.getSelectedItem().toString();
								
								String rdate = r_year.getSelectedItem().toString() 
										+ "-" + r_month.getSelectedItem().toString() 
										+ "-" +r_date.getSelectedItem().toString();
								
								
								//INSTERT THE CUSTOMER
								PreparedStatement st13 = myConn.prepareStatement("SELECT lisence_id FROM customer");
								ResultSet resultSet13 = st13.executeQuery();
								
								ArrayList<String> coids = new ArrayList<String>(); //CHECKS IF THE ID YOU TYPED EXISTS IN THE DATABASE				
								while(resultSet13.next()){ 
									coids.add(resultSet13.getString("lisence_id"));											
								}							
								
								boolean a = true;
								for(int i = 0; i<coids.size(); i++){												
									if(drive_id.getText().equals(coids.get(i))){										
										
										//GIVE ID TO THE RENT
										PreparedStatement st10 = myConn.prepareStatement("SELECT rent_id FROM rent");
										ResultSet resultSet10 = st10.executeQuery();
										
										ArrayList<Integer> rids = new ArrayList<Integer>(); //CHECKS IF THE ID YOU TYPED EXISTS IN THE DATABASE				
										while(resultSet10.next()){ 
											rids.add(resultSet10.getInt("rent_id"));											
										}
										
										//INSERT THE RENT
										PreparedStatement st6 = myConn.prepareStatement("INSERT INTO rent(rent_id, pickup_place, pickup_date_time, return_place, "
												+ "return_date_time, car_id, customer_id) VALUES(?, ?, ?, ?, ?, ?, ?)");
										
										int inid1 = 0;
										int max1 = 0;
										if(rids.isEmpty())
											inid1 = 1;									
										else{
											for(int j = 0; j<ids.size(); j++){												
												if(rids.get(j)>max1)
													max1 = rids.get(j);										
											}
											inid1 = max1 + 1;
										}								

										st6.setInt(1, inid1);							
										st6.setString(2, pickup_place.getText());
										st6.setString(3, pdate.toString());
										st6.setString(4, return_place.getText());
										st6.setString(5, rdate.toString());
										st6.setString(6, car_id.getText());
										st6.setString(7, drive_id.getText());
										
										st6.executeUpdate();
										
										PreparedStatement st8 = myConn.prepareStatement("UPDATE car SET rnt = 1 WHERE car_id = ?");
										
										st8.setString(1, car_id.getText());
										
										st8.executeUpdate();
										
										JOptionPane.showMessageDialog(null, "Rent added");
										a = false;								
									}																
								}	
								if(a)
									JOptionPane.showMessageDialog(null, "Register first to rent a car");
							}
						}
						else{
							JOptionPane.showMessageDialog(null, "This car doesn't exist");
						}
							
												
					
						
					} catch (SQLException e1) {
						e1.printStackTrace();
						JOptionPane.showMessageDialog(null, ":( Oops! Try again!");					
					}
				}
				 			
			}			
		});
		GridBagConstraints gbc_sumbit = new GridBagConstraints();
		gbc_sumbit.anchor = GridBagConstraints.NORTH;
		gbc_sumbit.fill = GridBagConstraints.HORIZONTAL;
		gbc_sumbit.gridwidth = 5;
		gbc_sumbit.gridx = 1;
		gbc_sumbit.gridy = 11;
		submit.add(sumbit, gbc_sumbit);
	}
}
