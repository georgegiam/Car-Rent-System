package cars;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.PreparedStatement;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Choice;
import java.awt.Label;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class edit_cr extends JFrame {

	private JPanel contentPane;
	private JTextField price;
	private JTextField seats;
	private JTextField doors;
	private JTextField id;
	private JTextField shop_id;

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
	public edit_cr(String crid) {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 365, 305);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{142, 173, 0};
		gbl_contentPane.rowHeights = new int[]{20, 20, 20, 20, 20, 20, 20, 20, 23, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		Choice gas = new Choice();
		gas.add("Gas");
		gas.add("Oil");
		
		JLabel lblId = new JLabel("ID");
		GridBagConstraints gbc_lblId = new GridBagConstraints();
		gbc_lblId.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblId.insets = new Insets(0, 0, 5, 5);
		gbc_lblId.gridx = 0;
		gbc_lblId.gridy = 0;
		contentPane.add(lblId, gbc_lblId);
		
		id = new JTextField(crid);
		id.setEditable(false);
		GridBagConstraints gbc_id = new GridBagConstraints();
		gbc_id.anchor = GridBagConstraints.NORTH;
		gbc_id.fill = GridBagConstraints.HORIZONTAL;
		gbc_id.insets = new Insets(0, 0, 5, 0);
		gbc_id.gridx = 1;
		gbc_id.gridy = 0;
		contentPane.add(id, gbc_id);
		id.setColumns(10);
		
		Choice conv = new Choice();
		conv.add("Yes");
		conv.add("No");
		
		JLabel lblNewLabel = new JLabel("CAR TYPE");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 1;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);
		
		Choice type = new Choice();
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
		
		JLabel lblNewLabel_4 = new JLabel("SEATS");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.anchor = GridBagConstraints.NORTH;
		gbc_lblNewLabel_4.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 0;
		gbc_lblNewLabel_4.gridy = 2;
		contentPane.add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		seats = new JTextField();
		GridBagConstraints gbc_seats = new GridBagConstraints();
		gbc_seats.anchor = GridBagConstraints.NORTH;
		gbc_seats.fill = GridBagConstraints.HORIZONTAL;
		gbc_seats.insets = new Insets(0, 0, 5, 0);
		gbc_seats.gridx = 1;
		gbc_seats.gridy = 2;
		contentPane.add(seats, gbc_seats);
		seats.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("DOORS");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 3;
		contentPane.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		doors = new JTextField();
		GridBagConstraints gbc_doors = new GridBagConstraints();
		gbc_doors.anchor = GridBagConstraints.NORTH;
		gbc_doors.fill = GridBagConstraints.HORIZONTAL;
		gbc_doors.insets = new Insets(0, 0, 5, 0);
		gbc_doors.gridx = 1;
		gbc_doors.gridy = 3;
		contentPane.add(doors, gbc_doors);
		doors.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("CONVENTIONAL");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.SOUTH;
		gbc_lblNewLabel_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 4;
		contentPane.add(lblNewLabel_1, gbc_lblNewLabel_1);
		GridBagConstraints gbc_conv = new GridBagConstraints();
		gbc_conv.anchor = GridBagConstraints.NORTH;
		gbc_conv.fill = GridBagConstraints.HORIZONTAL;
		gbc_conv.insets = new Insets(0, 0, 5, 0);
		gbc_conv.gridx = 1;
		gbc_conv.gridy = 4;
		contentPane.add(conv, gbc_conv);
		
		JLabel lblNewLabel_2 = new JLabel("GAS TYPE");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.SOUTH;
		gbc_lblNewLabel_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 5;
		contentPane.add(lblNewLabel_2, gbc_lblNewLabel_2);
		GridBagConstraints gbc_gas = new GridBagConstraints();
		gbc_gas.anchor = GridBagConstraints.NORTH;
		gbc_gas.fill = GridBagConstraints.HORIZONTAL;
		gbc_gas.insets = new Insets(0, 0, 5, 0);
		gbc_gas.gridx = 1;
		gbc_gas.gridy = 5;
		contentPane.add(gas, gbc_gas);
		
		JLabel lblNewLabel_5 = new JLabel("PRICE (PER DAY)");
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.gridx = 0;
		gbc_lblNewLabel_5.gridy = 6;
		contentPane.add(lblNewLabel_5, gbc_lblNewLabel_5);
		
		price = new JTextField();
		GridBagConstraints gbc_price = new GridBagConstraints();
		gbc_price.anchor = GridBagConstraints.NORTH;
		gbc_price.fill = GridBagConstraints.HORIZONTAL;
		gbc_price.insets = new Insets(0, 0, 5, 0);
		gbc_price.gridx = 1;
		gbc_price.gridy = 6;
		contentPane.add(price, gbc_price);
		price.setColumns(10);
		
		JButton save = new JButton("SAVE");
		save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { //SAVE
				if(doors.getText().equals("") || seats.getText().equals("") || price.getText().equals(""))
					JOptionPane.showMessageDialog(null, "You must complete all the fields!");
				else{
					try {
						Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cars", "root", "");							
						
						PreparedStatement st = (PreparedStatement) myConn.prepareStatement("UPDATE car SET car_type = ?, seats = ?, doors = ?, conv = ?, "
																			+ "fuel_type = ?, price = ?, shop_id = ? WHERE car_id = ?");																						
						
						st.setString(1, type.getSelectedItem().toString());
						st.setInt(2, Integer.parseInt(seats.getText()));
						st.setInt(3, Integer.parseInt(doors.getText()));
						st.setString(4, conv.getSelectedItem().toString());
						st.setString(5, gas.getSelectedItem().toString());							
						st.setDouble(6, Double.parseDouble(price.getText()));
						st.setString(7, shop_id.getText());
						st.setString(8, crid.toString());
						
						PreparedStatement st1 = (PreparedStatement) myConn.prepareStatement("SELECT shop_id FROM shop");
						ResultSet resultSet1 = st1.executeQuery();
						
						ArrayList<String> shops = new ArrayList<String>(); //CHECKS IF THE SHOP YOU TYPED EXISTS IN THE DATABASE				
						while(resultSet1.next()){ 
							shops.add(resultSet1.getString("shop_id"));	
							
						}
						boolean exist = false;
						for(int i = 0; i<shops.size(); i++){
							if(shops.get(i).equals(shop_id.getText().toString())){
								exist = true;
								break;
							}							
							else
								exist = false;
						}
						if(exist == false)
							JOptionPane.showMessageDialog(null, "No shop with ID " +shop_id.getText().toString() +" founded!");
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
		
		JLabel lblShopId = new JLabel("SHOP ID");
		GridBagConstraints gbc_lblShopId = new GridBagConstraints();
		gbc_lblShopId.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblShopId.insets = new Insets(0, 0, 5, 5);
		gbc_lblShopId.gridx = 0;
		gbc_lblShopId.gridy = 7;
		contentPane.add(lblShopId, gbc_lblShopId);
		
		shop_id = new JTextField();
		GridBagConstraints gbc_shop_id = new GridBagConstraints();
		gbc_shop_id.anchor = GridBagConstraints.NORTH;
		gbc_shop_id.fill = GridBagConstraints.HORIZONTAL;
		gbc_shop_id.insets = new Insets(0, 0, 5, 0);
		gbc_shop_id.gridx = 1;
		gbc_shop_id.gridy = 7;
		contentPane.add(shop_id, gbc_shop_id);
		shop_id.setColumns(10);
		GridBagConstraints gbc_save = new GridBagConstraints();
		gbc_save.anchor = GridBagConstraints.NORTH;
		gbc_save.fill = GridBagConstraints.HORIZONTAL;
		gbc_save.gridx = 1;
		gbc_save.gridy = 8;
		contentPane.add(save, gbc_save);
		
		
	}
}
