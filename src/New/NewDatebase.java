package New;

/*
 * create DATABASE s
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import DatabaseCaozuo.MySQL;

public class NewDatebase implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
			String tdatabase = MySQL.name.getText();//��ȡ�ı�������
			System.out.println(tdatabase);
			MySQL.name.setText(null);//����ı���
			MySQL.A.setText("�½��ɹ�,��ر�");
			
	
		
		Connection conn = null;
		String url = "jdbc:mysql://localhost:3306?useSSL=false&serverTimezone=GMT%2B8";
		String user = "root";
		String password = "2418502228";
		PreparedStatement ps = null;
		// 1.��������
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			//long start = System.currentTimeMillis();
			// 2.�������ݿ�����
			conn = DriverManager.getConnection(url, user, password);
			
			// 3.����SQL�������PreparedStatement
			//String sql = "create database s"; //
			ps = conn.prepareStatement(tdatabase);

			ps.execute(tdatabase);
			
			System.out.println("�½��ɹ�");

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
