package New;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import DatabaseCaozuo.MySQL;

public class NewView implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e1) {
		
		String tview = MySQL.name.getText();
		MySQL.name.setText(null);//����ı���
		System.out.println(tview);
		MySQL.A.setText("�½��ɹ�,��ر�");
		
		
		Connection conn = null;
		String url = "jdbc:mysql://localhost:3306/mysqldemo?useSSL=false&serverTimezone=GMT%2B8";
		String user = "root";
		String password = "2418502228";
		PreparedStatement ps = null;
		// 1.��������
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			// 2.�������ݿ�����
			conn = DriverManager.getConnection(url, user, password);
			
			// 3.����SQL�������PreparedStatement
			//String sql = "create view e(usename,password) as select usename,password from t1";
			ps = conn.prepareStatement(tview);
			
			ps.execute(tview);
			
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
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
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
