package Drop;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import DatabaseCaozuo.MySQL;

public class DropView implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		
		String tview = MySQL.name.getText();
		MySQL.name.setText(null);//����ı���
		System.out.println(tview);
		MySQL.A.setText("�½��ɹ�,��ر�");
		
		
		Connection conn = null;
		String url = "jdbc:mysql://localhost:3306/mysqldemo?useSSL=false&serverTimezone=GMT%2B8";
		String user = "root";
		String password = "2418502228";
		//Statement stmt = null;
		PreparedStatement ps = null;
		// 1.��������
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			// 2.�������ݿ�����
			conn = DriverManager.getConnection(url, user, password);
			
			// 3.����SQL�������PreparedStatement
			//String sql = "drop view e";
			ps = conn.prepareStatement(tview);
			
			ps.execute(tview);
			
			System.out.println("ɾ���ɹ�");

			
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} finally {
			try {
				if(ps != null) 
					ps.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			try {
				if(conn != null)
					conn.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	
}
