package out;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
* @author meemei
*
2010 2010-4-27 ����02:18:07
*/
@SuppressWarnings("serial")
public class Out extends JFrame {

//private JPasswordField passwordField;
private String frameName ;

   /**
* Launch the application
* @param args
*/
// �û���;
	String user = "root" ;
// ����;
	String password = "2418502228";
//�������ݿ��url;
	String url = "jdbc:mysql://localhost:3306?useSSL=false&serverTimezone=GMT%2B8";
//��ѯ�ı�sql���;
	String sql = "select * from t1";
// �����ļ���·��������;
	String file = "E:\\QQ\\����\\mysql.sql";

//

public static void main(String args[]) {
   try {
    Out frame = new Out("��������");
    frame.setVisible(true);
   } catch (Exception e) {
    e.printStackTrace();
   }
}

/**
* Create the frame
*/
public Out( String frameName ) {
   super();
   setTitle("��������");
   //setIconImage(SwingResourceManager.getImage(LogonFrame.class, "/image/title.jpg"));
   this.frameName = frameName ;
   String windows = "com.sun.java.swing.plaf.windows.WindowsLookAndFeel";
   try {
    UIManager.setLookAndFeel(windows);
   } catch (ClassNotFoundException e) {
    e.printStackTrace();
   } catch (InstantiationException e) {
    e.printStackTrace();
   } catch (IllegalAccessException e) {
    e.printStackTrace();
   } catch (UnsupportedLookAndFeelException e) {
    e.printStackTrace();
   }
   getContentPane().setLayout(null);

   setBounds(100, 100, 424, 272);
   Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
   Dimension framesize = this.getSize();
   int x = (int) screensize.getWidth() / 2 - (int) framesize.getWidth()
     / 2;
   int y = (int) screensize.getHeight() / 2 - (int) framesize.getHeight()
     / 2;
  
   this.setLocation(x, y);
   setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   final JPanel panel = new JPanel();
   panel.setLayout(null);
   panel.setBounds(0, 0, 416, 238);
   getContentPane().add(panel);

   final JButton button = new JButton();
   button.addActionListener(new ActionListener() {
    public void actionPerformed(final ActionEvent e) {
    
     try {    
      //���÷�װ�õ�˽�еķ���;
      boolean flag = export(url, user, password, sql, file);
      if ( flag ) {
       JOptionPane.showMessageDialog(null, "�����ļ��ɹ���");
      }
     } catch (Exception e1) {
      // TODO Auto-generated catch block
      e1.printStackTrace();
     }
    }
   });
   button.setText("��������");
   button.setBounds(83, 57, 106, 28);
   panel.add(button);

   final JLabel label = new JLabel();
   label.setForeground(new Color(255, 0, 0));
   label.setText("��������");
   label.setBounds(171, 10, 72, 28);
   panel.add(label);


}

/** ˽�еĵ������ݵķ���;
* @param url
* @param user
* @param password
* @param sql
* @param file
* @return
* @throws Exception
*/
@SuppressWarnings("unused")
private static boolean export(String url ,String user ,String password ,String sql ,String file ) throws Exception {
   boolean flag = false ;
   //ע��mysql��������;
   Class.forName("com.mysql.jdbc.Driver");
   FileWriter out = new FileWriter (file) ;
   Connection connection = DriverManager.getConnection(url, user, password);
   Statement st = connection.createStatement();
   //�鿴��ṹ

   
   
   
   //sql = "select * from t_position_type";
   ResultSet rs2 = st.executeQuery(sql);//sql��ѯ���
  
   while ( rs2.next() ) {
    out.write("|");
    out.write( rs2.getInt(1) + "                 |");
    out.write( rs2.getString(2)+"                 |");
    out.write( rs2.getDate(3) + "                 |\n");
   
   }
   out.flush();
   out.close();
   //�ж��ļ��Ƿ����!
   File file2 = new File ( file ) ;
   if ( file2.exists() && file2.length() > 0 ) {
    flag = true ;
   }
   return flag;
}

}