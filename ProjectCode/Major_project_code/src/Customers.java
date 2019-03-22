import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.*;
import java.sql.*;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
public class Customers extends JFrame
{
	Container c;
	JLabel lCID,lName,lGender,lAddress,lEmail,lContactNo,lImage;
	JTextField tCID,tName,tEmail,tContactNo,tFind;
	JTextArea tAddress;
	JRadioButton rMale,rFemale;
	ButtonGroup bg;
	JButton bAdd,bDelete,bFind,bExit,bUpdate,bNew,bClear,bPrint;
	DefaultTableModel mCustomers;
	JTable tCustomers;

	Customers()
	{
		c=getContentPane();
                
		setTitle("CUSTOMERS DETAILS");
		setSize(Toolkit.getDefaultToolkit().getScreenSize());
		setLayout(null);
		setBackground(Color.white);
		
		JPanel pAdd=new JPanel();
		pAdd.setLayout(null);
		pAdd.setBackground(Color.pink);
		pAdd.setBounds(10,10,1325,638);
		pAdd.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED),"CUSTOMER DETAILS"));
		
		
		lCID=new JLabel("Customer Id");
		lCID.setBounds(50,50,100,30);
		pAdd.add(lCID);
		
		tCID=new JTextField();
		tCID.setBounds(150,50,150,30);
		pAdd.add(tCID);
					
		lName=new JLabel("Name");
		lName.setBounds(50,100,100,30);
		pAdd.add(lName);
		
		tName=new JTextField();
		tName.setBounds(150,100,150,30);
		pAdd.add(tName);
		
		lGender=new JLabel("Gender");
		lGender.setBounds(50,150,100,30);
		pAdd.add(lGender);
		
		rMale=new JRadioButton("Male");
		rMale.setBounds(150,150,70,30);
		rMale.setBackground(Color.white);
		pAdd.add(rMale);
		
		rFemale=new JRadioButton("Female");
		rFemale.setBounds(220,150,80,30);
		rFemale.setBackground(Color.white);
		pAdd.add(rFemale);
		
		bg=new ButtonGroup();
		bg.add(rMale);
		bg.add(rFemale);
		
		lAddress=new JLabel("Address");
		lAddress.setBounds(50,200,100,30);
		pAdd.add(lAddress);
		
		tAddress=new JTextArea();
		JScrollPane jspAddress=new JScrollPane(tAddress);
		jspAddress.setBounds(150,200,150,100);
		pAdd.add(jspAddress);
		
		lEmail=new JLabel("Email-Id");
		lEmail.setBounds(50,320,100,30);
		pAdd.add(lEmail);
		
		tEmail=new JTextField();
		tEmail.setBounds(150,320,150,30);
		pAdd.add(tEmail);
		
		lContactNo=new JLabel("Contact No");
		lContactNo.setBounds(50,370,100,30);
		pAdd.add(lContactNo);
		
		tContactNo=new JTextField();
		tContactNo.setBounds(150,370,150,30);
		pAdd.add(tContactNo);
c.add(pAdd);
setVisible(true);
		//setClosable(true);
        }
        public static void main(String[] args)
        {
            Customers a= new Customers();
            
        }
}