package cars;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class add_costumer extends JFrame {

	private JPanel contentPane;
	private JTextField first;
	private JTextField last;
	private JTextField email;
	private JTextField drive_id;
	private JTextField mob;
	private JTextField home;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					add_costumer frame = new add_costumer();
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
	public add_costumer() {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 431, 238);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{190, 188, 0};
		gbl_contentPane.rowHeights = new int[]{20, 20, 20, 20, 20, 20, 23, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblNewLabel = new JLabel("FIRST NAME");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);
		
		first = new JTextField();
		GridBagConstraints gbc_first = new GridBagConstraints();
		gbc_first.anchor = GridBagConstraints.NORTH;
		gbc_first.fill = GridBagConstraints.HORIZONTAL;
		gbc_first.insets = new Insets(0, 0, 5, 0);
		gbc_first.gridx = 1;
		gbc_first.gridy = 0;
		contentPane.add(first, gbc_first);
		first.setColumns(10);
		
		JLabel lblLastName = new JLabel("LAST NAME");
		GridBagConstraints gbc_lblLastName = new GridBagConstraints();
		gbc_lblLastName.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblLastName.insets = new Insets(0, 0, 5, 5);
		gbc_lblLastName.gridx = 0;
		gbc_lblLastName.gridy = 1;
		contentPane.add(lblLastName, gbc_lblLastName);
		
		last = new JTextField();
		GridBagConstraints gbc_last = new GridBagConstraints();
		gbc_last.anchor = GridBagConstraints.NORTH;
		gbc_last.fill = GridBagConstraints.HORIZONTAL;
		gbc_last.insets = new Insets(0, 0, 5, 0);
		gbc_last.gridx = 1;
		gbc_last.gridy = 1;
		contentPane.add(last, gbc_last);
		last.setColumns(10);
		
		JLabel lblEmail = new JLabel("E-MAIL");
		GridBagConstraints gbc_lblEmail = new GridBagConstraints();
		gbc_lblEmail.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblEmail.insets = new Insets(0, 0, 5, 5);
		gbc_lblEmail.gridx = 0;
		gbc_lblEmail.gridy = 2;
		contentPane.add(lblEmail, gbc_lblEmail);
		
		email = new JTextField();
		GridBagConstraints gbc_email = new GridBagConstraints();
		gbc_email.anchor = GridBagConstraints.NORTH;
		gbc_email.fill = GridBagConstraints.HORIZONTAL;
		gbc_email.insets = new Insets(0, 0, 5, 0);
		gbc_email.gridx = 1;
		gbc_email.gridy = 2;
		contentPane.add(email, gbc_email);
		email.setColumns(10);
		
		JLabel lblDrivingId = new JLabel("DRIVING ID");
		GridBagConstraints gbc_lblDrivingId = new GridBagConstraints();
		gbc_lblDrivingId.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblDrivingId.insets = new Insets(0, 0, 5, 5);
		gbc_lblDrivingId.gridx = 0;
		gbc_lblDrivingId.gridy = 3;
		contentPane.add(lblDrivingId, gbc_lblDrivingId);
		
		drive_id = new JTextField();
		GridBagConstraints gbc_drive_id = new GridBagConstraints();
		gbc_drive_id.anchor = GridBagConstraints.NORTH;
		gbc_drive_id.fill = GridBagConstraints.HORIZONTAL;
		gbc_drive_id.insets = new Insets(0, 0, 5, 0);
		gbc_drive_id.gridx = 1;
		gbc_drive_id.gridy = 3;
		contentPane.add(drive_id, gbc_drive_id);
		drive_id.setColumns(10);
		
		JLabel lblMobilePhone = new JLabel("MOBILE PHONE");
		GridBagConstraints gbc_lblMobilePhone = new GridBagConstraints();
		gbc_lblMobilePhone.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblMobilePhone.insets = new Insets(0, 0, 5, 5);
		gbc_lblMobilePhone.gridx = 0;
		gbc_lblMobilePhone.gridy = 4;
		contentPane.add(lblMobilePhone, gbc_lblMobilePhone);
		
		mob = new JTextField();
		GridBagConstraints gbc_mob = new GridBagConstraints();
		gbc_mob.anchor = GridBagConstraints.NORTH;
		gbc_mob.fill = GridBagConstraints.HORIZONTAL;
		gbc_mob.insets = new Insets(0, 0, 5, 0);
		gbc_mob.gridx = 1;
		gbc_mob.gridy = 4;
		contentPane.add(mob, gbc_mob);
		mob.setColumns(10);
		
		JLabel lblHomePhone = new JLabel("HOME PHONE");
		GridBagConstraints gbc_lblHomePhone = new GridBagConstraints();
		gbc_lblHomePhone.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblHomePhone.insets = new Insets(0, 0, 5, 5);
		gbc_lblHomePhone.gridx = 0;
		gbc_lblHomePhone.gridy = 5;
		contentPane.add(lblHomePhone, gbc_lblHomePhone);
		
		home = new JTextField();
		GridBagConstraints gbc_home = new GridBagConstraints();
		gbc_home.anchor = GridBagConstraints.NORTH;
		gbc_home.fill = GridBagConstraints.HORIZONTAL;
		gbc_home.insets = new Insets(0, 0, 5, 0);
		gbc_home.gridx = 1;
		gbc_home.gridy = 5;
		contentPane.add(home, gbc_home);
		home.setColumns(10);
		
		JButton sumbit = new JButton("SUBMIT");
		sumbit.addActionListener(new ActionListener() { //SUBMIT
			public void actionPerformed(ActionEvent e) {
				if(first.getText().equals("") || last.getText().equals("") || email.getText().equals("") || drive_id.getText().equals("") ||
					mob.getText().equals("") || home.getText().equals(""))
						JOptionPane.showMessageDialog(null, "You must complete all the fields!");
				else{
					try {
						Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cars", "root", "");
						
						String sql = "INSERT INTO customer(lisence_id, first_name, last_name, email, "
								+ "	home_phone, mobile_phone)  VALUES (?, ?, ?, ?, ?, ?)";
						
						PreparedStatement st = myConn.prepareStatement(sql);
						
						st.setString(1, drive_id.getText());
						st.setString(2, first.getText());
						st.setString(3, last.getText());
						st.setString(4, email.getText());
						st.setString(5, home.getText());
						st.setString(6, mob.getText());
						
						st.executeUpdate();
						JOptionPane.showMessageDialog(null, "Done!");
					} catch (SQLException e1) {
						e1.printStackTrace();
						JOptionPane.showMessageDialog(null, ":(\nSomething went wrong...\nPlease try again!");
					}
				}				
			}
		});
		GridBagConstraints gbc_sumbit = new GridBagConstraints();
		gbc_sumbit.anchor = GridBagConstraints.NORTH;
		gbc_sumbit.fill = GridBagConstraints.HORIZONTAL;
		gbc_sumbit.gridx = 1;
		gbc_sumbit.gridy = 6;
		contentPane.add(sumbit, gbc_sumbit);
	}
}
