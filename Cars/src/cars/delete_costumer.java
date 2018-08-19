package cars;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.sun.xml.internal.bind.v2.model.core.ID;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class delete_costumer extends JFrame {

	private JPanel contentPane;
	private JTextField delete_id;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					delete_costumer frame = new delete_costumer();
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
	public delete_costumer() {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{85, 235, 0};
		gbl_contentPane.rowHeights = new int[]{93, 14, 20, 23, 23, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblCostumerToBe = new JLabel("COSTUMER TO BE DELETED DRIVE ID");
		lblCostumerToBe.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblCostumerToBe = new GridBagConstraints();
		gbc_lblCostumerToBe.anchor = GridBagConstraints.NORTH;
		gbc_lblCostumerToBe.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblCostumerToBe.insets = new Insets(0, 0, 5, 0);
		gbc_lblCostumerToBe.gridx = 1;
		gbc_lblCostumerToBe.gridy = 1;
		contentPane.add(lblCostumerToBe, gbc_lblCostumerToBe);
		
		delete_id = new JTextField();
		GridBagConstraints gbc_delete_id = new GridBagConstraints();
		gbc_delete_id.anchor = GridBagConstraints.NORTH;
		gbc_delete_id.fill = GridBagConstraints.HORIZONTAL;
		gbc_delete_id.insets = new Insets(0, 0, 5, 0);
		gbc_delete_id.gridx = 1;
		gbc_delete_id.gridy = 2;
		contentPane.add(delete_id, gbc_delete_id);
		delete_id.setColumns(10);
		
		JButton delete = new JButton("DELETE");
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {//DELETE
				try {
					Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cars", "root", "");
					
					PreparedStatement st = myConn.prepareStatement("SELECT lisence_id FROM customer");
					ResultSet resultSet = st.executeQuery();
					
					ArrayList<String> ids = new ArrayList<String>(); //CHECKS IF THE ID YOU TYPED EXISTS IN THE DATABASE				
					while(resultSet.next()){ 
						ids.add(resultSet.getString("lisence_id"));							
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
						JOptionPane.showMessageDialog(null, "No customer with Drive ID " +delete_id.getText().toString() +" founded!");
					else{ //IF THE ID YOU TYPED EXISTS IN THE DATABASE THEN EDIT
						try {
							Connection myConn1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/cars", "root", "");				
							
							
							PreparedStatement st1 = myConn1.prepareStatement("DELETE FROM customer WHERE lisence_id = ?");
							
							st1.setString(1, delete_id.getText());					
							
							st1.executeUpdate();
							
							PreparedStatement st2 = myConn1.prepareStatement("DELETE FROM rent WHERE customer_id = ?");	
							
							st2.setString(1, delete_id.getText());	
							
							st2.executeUpdate();
							JOptionPane.showMessageDialog(null, "Costumer " +delete_id.getText() +" deleted successfully!");
						} catch (SQLException e1) {
							e1.printStackTrace();
							JOptionPane.showMessageDialog(null, "Dleition failed!");
						}
					}
				} catch (SQLException e1) {					
					e1.printStackTrace();
				}
			}
		});
		GridBagConstraints gbc_delete = new GridBagConstraints();
		gbc_delete.anchor = GridBagConstraints.NORTH;
		gbc_delete.fill = GridBagConstraints.HORIZONTAL;
		gbc_delete.insets = new Insets(0, 0, 5, 0);
		gbc_delete.gridx = 1;
		gbc_delete.gridy = 3;
		contentPane.add(delete, gbc_delete);
		
		JButton btnShowAllCostumers = new JButton("SHOW ALL COSTUMERS");
		btnShowAllCostumers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { //SHOW ALL COSTUMERS
				try {
					Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cars", "root", "");
					
					PreparedStatement st = myConn.prepareStatement("SELECT lisence_id FROM customer");
					ResultSet resultSet = st.executeQuery();
					
					while(resultSet.next()){
						System.out.println("Drive ID: " +resultSet.getString("lisence_id"));					
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		GridBagConstraints gbc_btnShowAllCostumers = new GridBagConstraints();
		gbc_btnShowAllCostumers.anchor = GridBagConstraints.NORTH;
		gbc_btnShowAllCostumers.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnShowAllCostumers.gridx = 1;
		gbc_btnShowAllCostumers.gridy = 4;
		contentPane.add(btnShowAllCostumers, gbc_btnShowAllCostumers);
	}

}
