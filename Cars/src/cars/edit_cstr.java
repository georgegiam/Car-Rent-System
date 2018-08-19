package cars;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.PreparedStatement;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class edit_cstr extends JFrame {

	private JPanel contentPane;
	private JTextField first;
	private JTextField last;
	private JTextField email;
	private JTextField drive_id;
	private JTextField mobile;
	private JTextField home;

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
	public edit_cstr(String d_id) {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		first = new JTextField();
		first.setBounds(190, 8, 187, 20);
		contentPane.add(first);
		first.setColumns(10);
		
		last = new JTextField();
		last.setBounds(190, 39, 187, 20);
		contentPane.add(last);
		last.setColumns(10);
		
		email = new JTextField();
		email.setBounds(190, 70, 187, 20);
		contentPane.add(email);
		email.setColumns(10);
		
		drive_id = new JTextField(d_id);
		drive_id.setEditable(false);
		drive_id.setBounds(190, 101, 187, 20);
		contentPane.add(drive_id);
		drive_id.setColumns(10);
		
		mobile = new JTextField();
		mobile.setBounds(190, 132, 187, 20);
		contentPane.add(mobile);
		mobile.setColumns(10);
		
		home = new JTextField();
		home.setBounds(190, 163, 187, 20);
		contentPane.add(home);
		home.setColumns(10);
		
		JLabel first_l = new JLabel("FIRST NAME");
		first_l.setBounds(10, 11, 106, 14);
		contentPane.add(first_l);
		
		JLabel last_l = new JLabel("LAST NAME");
		last_l.setBounds(10, 42, 106, 14);
		contentPane.add(last_l);
		
		JLabel email_l = new JLabel("EMAIL");
		email_l.setBounds(10, 73, 106, 14);
		contentPane.add(email_l);
		
		JLabel drive_id_l = new JLabel("DRIVING ID");
		drive_id_l.setBounds(10, 104, 106, 14);
		contentPane.add(drive_id_l);
		
		JLabel mobile_l = new JLabel("MOBILE PHONE");
		mobile_l.setBounds(10, 135, 128, 14);
		contentPane.add(mobile_l);
		
		JLabel home_l = new JLabel("HOME PHONE");
		home_l.setBounds(10, 166, 128, 14);
		contentPane.add(home_l);
		
		JButton save = new JButton("SAVE");
		save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { //SAVE
				if(first.getText().equals("") || last.getText().equals("") || email.getText().equals("") ||
						mobile.getText().equals("") || home.getText().equals(""))
							JOptionPane.showMessageDialog(null, "You must complete all the fields!");
				else{
					try {
						
						Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cars", "root", "");					

						PreparedStatement st;					
						
						st = (PreparedStatement) myConn.prepareStatement("UPDATE customer SET first_name = ?, 	last_name = ?, "
																			+ "email = ?, home_phone = ?, "
																			+ "mobile_phone = ? WHERE lisence_id = ?");
																								
						
						st.setString(1, first.getText().toString());
						st.setString(2, last.getText().toString());
						st.setString(3, email.getText().toString());
						st.setString(4, home.getText().toString());	
						st.setString(5, mobile.getText().toString());					
						st.setString(6, d_id.toString());
						
						st.executeUpdate();
						
											
						JOptionPane.showMessageDialog(null, "Changes Saved Successfully");
					} catch (SQLException e1) {
						JOptionPane.showMessageDialog(null, "Can't Save Changes");
						
					}
				}			
			}
		});
		save.setBounds(190, 194, 187, 23);
		contentPane.add(save);
	}

}
