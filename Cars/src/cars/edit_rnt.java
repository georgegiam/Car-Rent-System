package cars;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.PreparedStatement;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Choice;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.awt.event.ActionEvent;

public class edit_rnt extends JFrame {

	private JPanel contentPane;
	private JTextField car_id;
	private JTextField p_place;
	private JTextField r_place;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public edit_rnt(int crid) {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 380, 213);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{140, 71, 58, 53, 0};
		gbl_contentPane.rowHeights = new int[]{20, 20, 20, 21, 20, 23, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblNewLabel = new JLabel("CAR ID");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);
		
		car_id = new JTextField();
		car_id.setEditable(false);
		GridBagConstraints gbc_car_id = new GridBagConstraints();
		gbc_car_id.anchor = GridBagConstraints.NORTH;
		gbc_car_id.fill = GridBagConstraints.HORIZONTAL;
		gbc_car_id.insets = new Insets(0, 0, 5, 0);
		gbc_car_id.gridwidth = 3;
		gbc_car_id.gridx = 1;
		gbc_car_id.gridy = 0;
		contentPane.add(car_id, gbc_car_id);
		car_id.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("PICKUP PLACE");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		contentPane.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		p_place = new JTextField();
		GridBagConstraints gbc_p_place = new GridBagConstraints();
		gbc_p_place.anchor = GridBagConstraints.NORTH;
		gbc_p_place.fill = GridBagConstraints.HORIZONTAL;
		gbc_p_place.insets = new Insets(0, 0, 5, 0);
		gbc_p_place.gridwidth = 3;
		gbc_p_place.gridx = 1;
		gbc_p_place.gridy = 1;
		contentPane.add(p_place, gbc_p_place);
		p_place.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("RETURN PLACE");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 2;
		contentPane.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		r_place = new JTextField();
		GridBagConstraints gbc_r_place = new GridBagConstraints();
		gbc_r_place.anchor = GridBagConstraints.NORTH;
		gbc_r_place.fill = GridBagConstraints.HORIZONTAL;
		gbc_r_place.insets = new Insets(0, 0, 5, 0);
		gbc_r_place.gridwidth = 3;
		gbc_r_place.gridx = 1;
		gbc_r_place.gridy = 2;
		contentPane.add(r_place, gbc_r_place);
		r_place.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("PICKUP DATE");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.SOUTH;
		gbc_lblNewLabel_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 3;
		contentPane.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
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
		GridBagConstraints gbc_p_date = new GridBagConstraints();
		gbc_p_date.anchor = GridBagConstraints.SOUTH;
		gbc_p_date.fill = GridBagConstraints.HORIZONTAL;
		gbc_p_date.insets = new Insets(0, 0, 5, 5);
		gbc_p_date.gridx = 1;
		gbc_p_date.gridy = 3;
		contentPane.add(p_date, gbc_p_date);
		
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
		gbc_p_month.gridy = 3;
		contentPane.add(p_month, gbc_p_month);
		
		Choice p_year = new Choice();
		p_year.add("2018"); 
		p_year.add("2019"); 
		p_year.add("2020"); 
		p_year.add("2021"); 
		p_year.add("2022"); 
		p_year.add("2023"); 
		p_year.add("2024");
		GridBagConstraints gbc_p_year = new GridBagConstraints();
		gbc_p_year.anchor = GridBagConstraints.NORTH;
		gbc_p_year.fill = GridBagConstraints.HORIZONTAL;
		gbc_p_year.insets = new Insets(0, 0, 5, 0);
		gbc_p_year.gridx = 3;
		gbc_p_year.gridy = 3;
		contentPane.add(p_year, gbc_p_year);
		
		JLabel lblNewLabel_4 = new JLabel("RETURN DATE");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.anchor = GridBagConstraints.SOUTH;
		gbc_lblNewLabel_4.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 0;
		gbc_lblNewLabel_4.gridy = 4;
		contentPane.add(lblNewLabel_4, gbc_lblNewLabel_4);
		
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
		GridBagConstraints gbc_r_date = new GridBagConstraints();
		gbc_r_date.anchor = GridBagConstraints.NORTH;
		gbc_r_date.fill = GridBagConstraints.HORIZONTAL;
		gbc_r_date.insets = new Insets(0, 0, 5, 5);
		gbc_r_date.gridx = 1;
		gbc_r_date.gridy = 4;
		contentPane.add(r_date, gbc_r_date);
		
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
		gbc_r_month.anchor = GridBagConstraints.NORTH;
		gbc_r_month.fill = GridBagConstraints.HORIZONTAL;
		gbc_r_month.insets = new Insets(0, 0, 5, 5);
		gbc_r_month.gridx = 2;
		gbc_r_month.gridy = 4;
		contentPane.add(r_month, gbc_r_month);
		
		Choice r_year = new Choice();
		r_year.add("2018"); 
		r_year.add("2019"); 
		r_year.add("2020"); 
		r_year.add("2021"); 
		r_year.add("2022"); 
		r_year.add("2023"); 
		r_year.add("2024");
		GridBagConstraints gbc_r_year = new GridBagConstraints();
		gbc_r_year.anchor = GridBagConstraints.NORTH;
		gbc_r_year.fill = GridBagConstraints.HORIZONTAL;
		gbc_r_year.insets = new Insets(0, 0, 5, 0);
		gbc_r_year.gridx = 3;
		gbc_r_year.gridy = 4;
		contentPane.add(r_year, gbc_r_year);
		
		JButton btnSave = new JButton("SAVE");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {  //SAVE
				if(p_place.getText().equals("") || r_place.getText().equals(""))
					JOptionPane.showMessageDialog(null, "You must complete all the fields!");
				else{
					try {
						Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cars", "root", "");					

						PreparedStatement st;					
						
						st = (PreparedStatement) myConn.prepareStatement("UPDATE rent SET pickup_place = ?, pickup_date_time = ?, return_place = ?, "
																			+ "return_date_time = ? WHERE rent_id = ?");						
						
						String p_none = p_year.getSelectedItem().toString() +"-" +p_month.getSelectedItem().toString() +"-"
								+p_date.getSelectedItem().toString(); 
								
						String r_none = r_year.getSelectedItem().toString() +"-" +r_month.getSelectedItem().toString() +"-"
								+r_date.getSelectedItem().toString(); 
						
						LocalDate pickup_d = LocalDate.parse(p_none.toString(), DateTimeFormatter.ISO_LOCAL_DATE);
						LocalDate return_d = LocalDate.parse(r_none.toString(), DateTimeFormatter.ISO_LOCAL_DATE);
						
						
						Duration diff = Duration.between(pickup_d.atStartOfDay(), return_d.atStartOfDay());
						long diffDays = diff.toDays();																								
						
						st.setString(1, p_place.getText().toString());
						st.setString(2, p_none);
						st.setString(3, r_place.getText().toString());
						st.setString(4, r_none);
						st.setInt(5, crid);
							
						if(diffDays < 0)
							JOptionPane.showMessageDialog(null, "Pickup date must be before return date");								
						else{
							st.executeUpdate();
							JOptionPane.showMessageDialog(null, "Changes Saved Successfully");
						}
							
						
											
						
					} catch (SQLException e1) {
						e1.printStackTrace();
						JOptionPane.showMessageDialog(null, "Can't Save Changes");
						
					}
				}
				
				
			}
		});
		GridBagConstraints gbc_btnSave = new GridBagConstraints();
		gbc_btnSave.anchor = GridBagConstraints.NORTH;
		gbc_btnSave.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnSave.gridwidth = 3;
		gbc_btnSave.gridx = 1;
		gbc_btnSave.gridy = 5;
		contentPane.add(btnSave, gbc_btnSave);
	}
}
