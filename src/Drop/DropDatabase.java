package Drop;

/*
 * drop  database s
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import DatabaseCaozuo.MySQL;

public class DropDatabase implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e1) {
		
		String tdatabase = MySQL.name.getText();
		MySQL.name.setText(null);//����ı���
		System.out.println(tdatabase);
		MySQL.A.setText("ɾ���ɹ�,��ر�");
		
		Connection conn = null;
		String url = "jdbc:mysql://localhost:3306?useSSL=false&serverTimezone=GMT%2B8";
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
			//String sql = "drop database s"; //? ռλ��
			ps = conn.prepareStatement(tdatabase);

			ps.execute(tdatabase);
			
			System.out.println("ɾ���ɹ�");

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
