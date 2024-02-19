package ddddddd;

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
import bbbbbbb.employee;
import bbbbbbb.employeeform;

public class Orderform implements ActionListener{
		JFrame frame;
		JLabel order_id_lb=new JLabel("order_id");
		JLabel item_id_lb=new JLabel("item_id");
		JLabel customer_id_lb=new JLabel("customer_id");
		JLabel employee_id_lb=new JLabel("employee_id");
		JLabel quantity_lb=new JLabel("quantity");
		JLabel order_time_lb=new JLabel("order_time");

		JTextField order_id_txf=new JTextField();
		JTextField item_id_txf=new JTextField();
		JTextField customer_id_txf=new JTextField();
		JTextField employee_id_txf=new JTextField();
		JTextField quantity_txf=new JTextField();
		JTextField order_time_txf=new JTextField();

	   
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
		public Orderform() {
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
			frame.setTitle("order form");
			frame.setBounds(0, 0, w/2, h/2);
			frame.getContentPane().setLayout(null);
			frame.getContentPane().setBackground(Color.red);
			frame.setVisible(true);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setResizable(true);
			
		}


		private void setLocationandSize() {
			order_id_lb.setBounds(10, 10, 120, 30);
			item_id_lb.setBounds(10, 50, 140, 30);
			customer_id_lb.setBounds(10, 90, 120, 30);
			employee_id_lb.setBounds(10, 130, 120, 30);
			quantity_lb.setBounds(10, 170, 100, 30);
			order_time_lb.setBounds(10, 210, 100, 30);
			
			
			
			order_id_txf.setBounds(160, 10, 130, 30);
			item_id_txf.setBounds(160, 50, 130, 30);
			customer_id_txf.setBounds(160, 90, 130, 30);
			employee_id_txf.setBounds(160, 130, 130, 30);
			quantity_txf.setBounds(160, 170, 130, 30);
			order_time_txf.setBounds(160, 210, 130, 30);
			
	        //Buttons CRUD
			insert_btn.setBounds(10,250, 85, 30);
			Read_btn.setBounds(100,250, 85, 30);
			update_tbtn.setBounds(190,250, 85, 30);
			delete_btn.setBounds(280,250, 85, 30);
			table.setBounds(500, 10, 600, 240);
			

		}
		private void setFontforall() {
			Font font = new Font("Times New Roman", Font.BOLD, 20);

			order_id_lb.setFont(font);
			item_id_lb.setFont(font);
			customer_id_lb.setFont(font);
			employee_id_lb.setFont(font);
			quantity_lb.setFont(font);
			order_time_lb.setFont(font);
			

			order_id_txf.setFont(font);
			item_id_txf.setFont(font);
			customer_id_txf.setFont(font);
			employee_id_txf.setFont(font);
			quantity_txf.setFont(font);
			order_time_txf.setFont(font);
			
			Font fonti = new Font("Courier New", Font.ITALIC, 12);

			insert_btn.setFont(fonti);
			Read_btn.setFont(fonti);
			update_tbtn.setFont(fonti);
			delete_btn.setFont(fonti);

		}
		private void addcomponentforFrame() {
			frame.add(order_id_lb);
			frame.add(item_id_lb);
			frame.add(customer_id_lb);
			frame.add(employee_id_lb);
			frame.add(quantity_lb);
			frame.add(order_time_lb);
			
			frame.add(order_id_txf);
			frame.add(item_id_txf);
			frame.add(customer_id_txf);
			frame.add(employee_id_txf);
			frame.add(quantity_txf);
			frame.add(order_time_txf);
			
			//Buttons CRUD
			frame.add(insert_btn);
			frame.add(Read_btn);
			frame.add(update_tbtn);
			frame.add(delete_btn);
			frame.add(table);
		
			
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			Order odr=new Order();
			if(e.getSource()==insert_btn) {
				odr.setItem_id(item_id_txf.getText());
				odr.setCustomer_id(customer_id_txf.getText());
				odr.setEmployee_id(employee_id_txf.getText());
				odr.setQuantity(quantity_txf.getText());
				odr.setOrder_time(order_time_txf.getText());
				odr.insertData();
				
			}
			
		 
		else if (e.getSource() == Read_btn) {
	            model.setColumnCount(0);
	            model.setRowCount(1);
	            model.addColumn("order_id");
	            model.addColumn("item_id");
	            model.addColumn("customer_id");
	            model.addColumn("employee_id");
	            model.addColumn("quantity");
	            model.addColumn("order_time");

	            ResultSet resultSet = Order.viewData();
	            if (resultSet != null) {
	                try {
	                    while (resultSet.next()) {
	                        model.addRow(new Object[] { resultSet.getInt(1), resultSet.getString(2),
	                                resultSet.getString(3), resultSet.getString(4), resultSet.getString(5), resultSet.getString(6)});
	                    }
	                } catch (SQLException ex) {
	                    ex.printStackTrace();
	                }
	            }
	        }
		    else if (e.getSource()==update_tbtn) {
				int id=Integer.parseInt(order_id_txf.getText());
				odr.setItem_id(item_id_txf.getText());
				odr.setCustomer_id(customer_id_txf.getText());
				odr.setEmployee_id(employee_id_txf.getText());
				odr.setQuantity(quantity_txf.getText());
				odr.setOrder_time(order_time_txf.getText());
				odr.update(id);
		    }
		  else {
				int id=Integer.parseInt(order_id_txf.getText());
				odr.delete(id);}

		  }
		 public static void main(String[] args) {
				
				Orderform odr= new Orderform();
				System.out.println(odr);
				
		

		
		
			
		}
	



	}








