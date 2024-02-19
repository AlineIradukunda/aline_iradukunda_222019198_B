package cccccccccc;

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

public class menuform implements ActionListener{
	JFrame frame;
	JLabel item_id_lb=new JLabel("item_id");
	JLabel item_name_lb=new JLabel("item_name");
	JLabel price_lb=new JLabel("price");
	

	JTextField item_id_txf=new JTextField();
	JTextField item_name_txf=new JTextField();
	JTextField price_txf=new JTextField();
   
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
	public menuform() {
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
		frame.setTitle("menu form");
		frame.setBounds(0, 0, w/2, h/2);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().setBackground(Color.green);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(true);
		
	}


	private void setLocationandSize() {
		item_id_lb.setBounds(10, 10, 120, 30);
		item_name_lb.setBounds(10, 50, 140, 30);
		price_lb.setBounds(10, 90, 120, 30);
		
		item_id_txf.setBounds(160, 10, 130, 30);
		item_name_txf.setBounds(160, 50, 130, 30);
		price_txf.setBounds(160, 90, 130, 30);
		
        //Buttons CRUD
		insert_btn.setBounds(10,250, 85, 30);
		Read_btn.setBounds(100,250, 85, 30);
		update_tbtn.setBounds(190,250, 85, 30);
		delete_btn.setBounds(280,250, 85, 30);
		table.setBounds(500, 10, 600, 240);
		

	}
	private void setFontforall() {
		Font font = new Font("Times New Roman", Font.BOLD, 20);

		item_id_lb.setFont(font);
		item_name_lb.setFont(font);
		price_lb.setFont(font);
		
		item_id_txf.setFont(font);
		item_name_txf.setFont(font);
		price_txf.setFont(font);
		
		Font fonti = new Font("Courier New", Font.ITALIC, 12);

		insert_btn.setFont(fonti);
		Read_btn.setFont(fonti);
		update_tbtn.setFont(fonti);
		delete_btn.setFont(fonti);

	}
	private void addcomponentforFrame() {
		frame.add(item_id_lb);
		frame.add(item_name_lb);
		frame.add(price_lb);
		
		frame.add(item_id_txf);
		frame.add(item_name_txf);
		frame.add(price_txf);
		
		//Buttons CRUD
		frame.add(insert_btn);
		frame.add(Read_btn);
		frame.add(update_tbtn);
		frame.add(delete_btn);
		frame.add(table);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		menu mu=new menu();
		if(e.getSource()==insert_btn) {
			mu.setItem_name(item_name_txf.getText());
			mu.setPrice(price_txf.getText());
			
			mu.insertData();
			
		}
		
	 else if (e.getSource() == Read_btn) {
         model.setColumnCount(0);
         model.setRowCount(1);
         model.addColumn("item_id");
         model.addColumn("item_name");
         model.addColumn("price");

         ResultSet resultSet = menu.viewData();
         if (resultSet != null) {
             try {
                 while (resultSet.next()) {
                     model.addRow(new Object[] { resultSet.getInt(1), resultSet.getString(2),
                             resultSet.getString(3)});
                 }
             } catch (SQLException ex) {
                 ex.printStackTrace();
             }
         }
     }
	    else if (e.getSource()==update_tbtn) {
			int id=Integer.parseInt(item_id_txf.getText());
			mu.setItem_name(item_name_txf.getText());
			mu.setPrice(price_txf.getText());
			
			mu.update(id);
	    }
	  else {
			int id=Integer.parseInt(item_id_txf.getText());
			mu.delete(id);}

	  }

	public static void main(String[] args) {
		menuform stf=new menuform();

		
	}

}



