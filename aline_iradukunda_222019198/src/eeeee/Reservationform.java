package eeeee;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import aaaaaaaaa.customer;
import aaaaaaaaa.customerform;
import cccccccccc.menuform;

public class Reservationform implements ActionListener{
	JFrame frame;
	JLabel reservation_id_lb=new JLabel("reservation_id");
	JLabel customer_id_lb=new JLabel("customer_id");
	JLabel reservation_time_lb=new JLabel("reservation_time");
	JLabel table_number_lb=new JLabel("table_number");
	

	JTextField reservation_id_txf=new JTextField();
	JTextField customer_id_txf=new JTextField();
	JTextField reservation_time_txf=new JTextField();
	JTextField table_number_txf=new JTextField();
   
	//Buttons CRUD
	JButton insert_btn=new JButton("Insert");
	JButton Read_btn=new JButton("View");
	JButton update_tbtn=new JButton("Update");
	JButton delete_btn=new JButton("Delete");
	
	DefaultTableModel model = new DefaultTableModel();
    JTable table = new JTable(model);
    
	Dimension screensize=Toolkit.getDefaultToolkit().getScreenSize();
	int w=(int) screensize.getWidth();
	int h=(int) screensize.getHeight();
	public Reservationform() {
		createForm();
		ActionEvent();
		setLocationandSize();
		setFontforall();
		addcomponentforFrame();

	}
	private void ActionEvent() {
		insert_btn.addActionListener(this);
		Read_btn.addActionListener(this);
		update_tbtn.addActionListener(this);
		delete_btn.addActionListener(this);
		//genderBox.addActionListener(this);
	}
	private void createForm() {
		frame=new JFrame();
		frame.setTitle("reservation form");
		frame.setBounds(0, 0, w/2, h/2);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().setBackground(Color.pink);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(true);
		
	}


	private void setLocationandSize() {
		reservation_id_lb.setBounds(10, 10, 120, 30);
		customer_id_lb.setBounds(10, 50, 140, 30);
		reservation_time_lb.setBounds(10, 90, 120, 30);
		table_number_lb.setBounds(10, 130, 120, 30);
		
		reservation_id_txf.setBounds(160, 10, 130, 30);
		customer_id_txf.setBounds(160, 50, 130, 30);
		reservation_time_txf.setBounds(160, 90, 130, 30);
		table_number_txf.setBounds(160, 130, 130, 30);
		
        //Buttons CRUD
		insert_btn.setBounds(10,250, 85, 30);
		Read_btn.setBounds(100,250, 85, 30);
		update_tbtn.setBounds(190,250, 85, 30);
		delete_btn.setBounds(280,250, 85, 30);
		table.setBounds(500, 10, 600, 240);
		

	}
	private void setFontforall() {
		Font font = new Font("Times New Roman", Font.BOLD, 20);

		reservation_id_lb.setFont(font);
		customer_id_lb.setFont(font);
		reservation_time_lb.setFont(font);
		table_number_lb.setFont(font);
		
		reservation_id_txf.setFont(font);
		customer_id_txf.setFont(font);
		reservation_time_txf.setFont(font);
		table_number_txf.setFont(font);
		
		Font fonti = new Font("Courier New", Font.ITALIC, 12);

		insert_btn.setFont(fonti);
		Read_btn.setFont(fonti);
		update_tbtn.setFont(fonti);
		delete_btn.setFont(fonti);

	}
	private void addcomponentforFrame() {
		frame.add(reservation_id_lb);
		frame.add(customer_id_lb);
		frame.add(reservation_time_lb);
		frame.add(table_number_lb);
		
		frame.add(reservation_id_txf);
		frame.add(customer_id_txf);
		frame.add(reservation_time_txf);
		frame.add(table_number_txf);
		
		//Buttons CRUD
		frame.add(insert_btn);
		frame.add(Read_btn);
		frame.add(update_tbtn);
		frame.add(delete_btn);
		frame.add(table);
		ActionEvent();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Reservation rsvtn=new Reservation();
		if(e.getSource()==insert_btn) {
		    rsvtn.setCustomer_id(customer_id_txf.getText());
			rsvtn.setReservation_time(reservation_time_txf.getText());
			rsvtn.setTable_number(table_number_txf.getText());
			rsvtn.insertData();
			
		}
		
	 else if (e.getSource() == Read_btn) {
         model.setColumnCount(0);
         model.setRowCount(1);
         model.addColumn("reservation_id");
         model.addColumn("customer_id");
         model.addColumn("reservation_time");
         model.addColumn("table_number");
         

         ResultSet resultSet = Reservation.viewData();
         if (resultSet != null) {
             try {
                 while (resultSet.next()) {
                     model.addRow(new Object[] { resultSet.getInt(1), resultSet.getString(2),
                             resultSet.getString(3), resultSet.getString(4)});
                 }
             } catch (SQLException ex) {
                 ex.printStackTrace();
             }
         }
     }
	    else if (e.getSource()==update_tbtn) {
			int id=Integer.parseInt(reservation_id_txf.getText());
			rsvtn.setCustomer_id(customer_id_txf.getText());
			rsvtn.setReservation_time(reservation_time_txf.getText());
			rsvtn.setTable_number(table_number_txf.getText());
			
			
			rsvtn.update(id);
	    }
	  else {
			int id=Integer.parseInt(reservation_id_txf.getText());
			rsvtn.delete(id);}

	  }
	public static void main(String[] args) {
		Reservationform rsvtn=new Reservationform();
		System.out.println(rsvtn);
	
}
}



		
	



