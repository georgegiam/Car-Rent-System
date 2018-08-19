package cars;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import java.awt.Button;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.SpinnerNumberModel;

public class add_shop extends JFrame {

	private JPanel contentPane;
	private JTextField shop_id;
	private JTextField town;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					add_shop frame = new add_shop();
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
	public add_shop() {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 395, 136);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{41, 181, 130, 0};
		gbl_contentPane.rowHeights = new int[]{20, 20, 23, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblShopId = new JLabel("SHOP ID");
		GridBagConstraints gbc_lblShopId = new GridBagConstraints();
		gbc_lblShopId.anchor = GridBagConstraints.WEST;
		gbc_lblShopId.insets = new Insets(0, 0, 5, 5);
		gbc_lblShopId.gridx = 0;
		gbc_lblShopId.gridy = 0;
		contentPane.add(lblShopId, gbc_lblShopId);
		
		shop_id = new JTextField();
		GridBagConstraints gbc_shop_id = new GridBagConstraints();
		gbc_shop_id.anchor = GridBagConstraints.NORTH;
		gbc_shop_id.fill = GridBagConstraints.HORIZONTAL;
		gbc_shop_id.insets = new Insets(0, 0, 5, 0);
		gbc_shop_id.gridx = 2;
		gbc_shop_id.gridy = 0;
		contentPane.add(shop_id, gbc_shop_id);
		shop_id.setColumns(10);
		
		JLabel lblTown = new JLabel("TOWN");
		GridBagConstraints gbc_lblTown = new GridBagConstraints();
		gbc_lblTown.anchor = GridBagConstraints.WEST;
		gbc_lblTown.insets = new Insets(0, 0, 5, 5);
		gbc_lblTown.gridx = 0;
		gbc_lblTown.gridy = 1;
		contentPane.add(lblTown, gbc_lblTown);
		
		town = new JTextField();
		GridBagConstraints gbc_town = new GridBagConstraints();
		gbc_town.anchor = GridBagConstraints.NORTH;
		gbc_town.fill = GridBagConstraints.HORIZONTAL;
		gbc_town.insets = new Insets(0, 0, 5, 0);
		gbc_town.gridx = 2;
		gbc_town.gridy = 1;
		contentPane.add(town, gbc_town);
		town.setColumns(10);
		
		JButton btnNewButton = new JButton("SUBMIT");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(shop_id.getText().equals("") || town.getText().equals(""))
					JOptionPane.showMessageDialog(null, "You must complete all the fields!");
				else{
					try {
						Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cars", "root", "");					

						PreparedStatement st;						
						
						st = myConn.prepareStatement("INSERT INTO shop(shop_id, town) VALUES(?, ?)");	
						
						st.setString(1, shop_id.getText());
						st.setString(2, town.getText());						
					
						st.executeUpdate();			
						
						JOptionPane.showMessageDialog(null, "Shop " +shop_id.getText() +" added succesfully!");										
						
					} catch (SQLException e1) {
						//e1.printStackTrace();
						JOptionPane.showMessageDialog(null, "Shop add failed!");						
					}
				}			
			}
		});
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.anchor = GridBagConstraints.NORTH;
		gbc_btnNewButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNewButton.gridx = 2;
		gbc_btnNewButton.gridy = 2;
		contentPane.add(btnNewButton, gbc_btnNewButton);
	}
}
