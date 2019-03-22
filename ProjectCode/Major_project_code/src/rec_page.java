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
import java.util.*;
public class rec_page extends JFrame implements ActionListener{
    Container c;
    JLabel rdev,lImage,lImage1,lImage2;
    JList list;
    JButton b1,b2;
    rec_page(ArrayList<String> arr)
    {
        
        c=getContentPane();
		setTitle("Developer Module");
                //setSize();
               // System.out.println(Toolkit.getDefaultToolkit().getScreenSize());
		setSize(Toolkit.getDefaultToolkit().getScreenSize());
		setLayout(null);
		setBackground(Color.white);
                setVisible(true);
                
                JPanel pAdd=new JPanel();
		pAdd.setLayout(null);
		pAdd.setBackground(Color.ORANGE);
		pAdd.setBounds(10,10,1365,768);
		pAdd.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED),"Developer Recommendation"));
                 
                lImage1=new JLabel(new ImageIcon("C:\\Users\\HP\\Documents\\NetBeansProjects\\JavaApplication3\\build\\images\\developer3.png"));
		lImage1.setBounds(2,20,490,100);
		pAdd.add(lImage1);
                
                rdev=new JLabel("RECOMMENDED DEVELOPERS");
                rdev.setFont(new java.awt.Font("Bookman Old Style", 3, 24));
		rdev.setBounds(510,30,500,100);
		pAdd.add(rdev);
                
                lImage2=new JLabel(new ImageIcon("C:\\Users\\HP\\Documents\\NetBeansProjects\\JavaApplication3\\build\\images\\developer3.png"));
		lImage2.setBounds(912,20,474,100);
		pAdd.add(lImage2);
                
                lImage=new JLabel(new ImageIcon("C:\\Users\\HP\\Documents\\NetBeansProjects\\JavaApplication3\\build\\images\\developer.png"));
		lImage.setBounds(120,150,500,370);
		pAdd.add(lImage);
                
                 list = new JList(arr.toArray());
                 
                 JScrollPane jsplist=new JScrollPane(list);
                 jsplist.setBounds(750,150,500,370);
                 pAdd.add(jsplist);
                 
                b1=new JButton();
                b1.setIcon(new ImageIcon("C:\\Users\\HP\\Documents\\NetBeansProjects\\JavaApplication3\\build\\images\\Done.jpg"));
                b1.setText("LOGOUT");
                b1.setFont(new java.awt.Font("Bookman Old Style", 3, 24));
		b1.setBounds(695,580,185,50);
                b1.setToolTipText("LOGOUT");
		pAdd.add(b1);
                
                 b2=new JButton();
                b2.setIcon(new ImageIcon("C:\\Users\\HP\\Documents\\NetBeansProjects\\JavaApplication3\\build\\images\\Back.jpg"));
                b2.setText("BACK");
                b2.setFont(new java.awt.Font("Bookman Old Style", 3, 24));
		b2.setBounds(500,580,175,50);
                b2.setToolTipText("GO BACK");
		pAdd.add(b2);
                

        c.add(pAdd);
        b1.addActionListener(this);
        b2.addActionListener(this);
        setVisible(true);
    }
    	public void actionPerformed(ActionEvent ae)
	{
            Object o=ae.getSource();
		if(o.equals(b1))
		{
            //MainFrame m=new MainFrame();
            //m.setVisible(true);
           // this.dispose();
            System.exit(0);
        }
                if(o.equals(b2))
		{
            //MainFrame m=new MainFrame();
            //m.setVisible(true);
           this.dispose();
           // System.exit(0);
        }
        
        }
}
