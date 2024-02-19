package bbbbbbb;

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


public class employeeform implements ActionListener {

	JFrame frame;
	JLabel employee_id_lb=new JLabel("employee_id");
	JLabel employee_name_lb=new JLabel("employee_name");
	JLabel address_lb=new JLabel("address");
	JLabel telephone_lb=new JLabel("telephone");
	JLabel email_lb=new JLabel("email");
	JLabel position_lb=new JLabel("position");

	JTextField employee_id_txf=new JTextField();
	JTextField employee_name_txf=new JTextField();
	JTextField address_txf=new JTextField();
	JTextField telephone_txf=new JTextField();
	JTextField email_txf=new JTextField();
	JTextField position_txf=new JTextField();
   
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
	public employeeform() {
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
		frame.setTitle("employee form");
		frame.setBounds(0, 0, w/2, h/2);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().setBackground(Color.blue);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(true);
		
	}


	private void setLocationandSize() {
		employee_id_lb.setBounds(10, 10, 120, 30);
		employee_name_lb.setBounds(10, 50, 140, 30);
		address_lb.setBounds(10, 90, 140, 30);
		telephone_lb.setBounds(10, 130, 100, 30);
		email_lb.setBounds(10, 170, 100, 30);
		position_lb.setBounds(10, 200, 100, 30);
		
		employee_id_txf.setBounds(160, 10, 130, 30);
		employee_name_txf.setBounds(160, 50, 130, 30);
		address_txf.setBounds(160, 90, 130, 30);
		telephone_txf.setBounds(160, 130, 130, 30);
		email_txf.setBounds(160, 170, 130, 30);
		position_txf.setBounds(160, 210, 130, 30);
		
        //Buttons CRUD
		insert_btn.setBounds(10,250, 85, 30);
		Read_btn.setBounds(100,250, 85, 30);
		update_tbtn.setBounds(190,250, 85, 30);
		delete_btn.setBounds(280,250, 85, 30);
		table.setBounds(500, 10, 600, 240);
		

	}
	private void setFontforall() {
		Font font = new Font("Times New Roman", Font.BOLD, 20);

		employee_id_lb.setFont(font);
		employee_name_lb.setFont(font);
		address_lb.setFont(font);
		telephone_lb.setFont(font);
		email_lb.setFont(font);
		position_lb.setFont(font);
		

		employee_id_txf.setFont(font);
		employee_name_txf.setFont(font);
		address_txf.setFont(font);
		telephone_txf.setFont(font);
		email_txf.setFont(font);
		position_txf.setFont(font);
		
		Font fonti = new Font("Courier New", Font.ITALIC, 12);

		insert_btn.setFont(fonti);
		Read_btn.setFont(fonti);
		update_tbtn.setFont(fonti);
		delete_btn.setFont(fonti);

	}
	private void addcomponentforFrame() {
		frame.add(employee_id_lb);
		frame.add(employee_name_lb);
		frame.add(address_lb);
		frame.add(telephone_lb);
		frame.add(email_lb);
		frame.add(position_lb);
		
		frame.add(employee_id_txf);
		frame.add(employee_name_txf);
		frame.add(address_txf);
		frame.add(telephone_txf);
		frame.add(email_txf);
		frame.add(position_txf);
		
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
		employee em=new employee();
		if(e.getSource()==insert_btn) {
			em.setEmployee_name(employee_name_txf.getText());
			em.setAddress(address_txf.getText());
			em.setTelephone(telephone_txf.getText());
			em.setEmail(email_txf.getText());
			em.setPosition(position_txf.getText());
			em.insertData();
			
		}
		
		else if (e.getSource() == Read_btn) {
            model.setColumnCount(0);
            model.setRowCount(1);
            model.addColumn("employee_id");
            model.addColumn("employee_name");
            model.addColumn("address");
            model.addColumn("telephone");
            model.addColumn("email");
            model.addColumn("position");
           
            ResultSet resultSet =employee.viewData();
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
			int id=Integer.parseInt(employee_id_txf.getText());
			em.setEmployee_name(employee_name_txf.getText());
			em.setAddress(address_txf.getText());
			em.setTelephone(telephone_txf.getText());
			em.setEmail(email_txf.getText());
			em.setPosition(position_txf.getText());
			em.update(id);
	    }
	  else {
			int id=Integer.parseInt(employee_id_txf.getText());
			em.delete(id);}

	  }
	 public static void main(String[] args) {
			
			employeeform empf= new employeeform();
			System.out.println(empf);
			
		}

		
	}






