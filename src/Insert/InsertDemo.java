package Insert;



/*
 insert into t1
VALUES
("С��",2002,55)
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import DatabaseCaozuo.MySQL;

public class InsertDemo implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent arg) {
		
		String tInsert = MySQL.name.getText();
		MySQL.name.setText(null);//����ı���
		System.out.println(tInsert);
		MySQL.A.setText("����ɹ�,��ر�");
		
		
		Connection conn = null;
		String url = "jdbc:mysql://localhost:3306/mysqldemo?useSSL=false&serverTimezone=GMT%2B8";
		String user = "root";
		String password = "2418502228";
		PreparedStatement ps1 = null;
		// 1.��������
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			// 2.�������ݿ�����
			conn = DriverManager.getConnection(url, user, password);
			conn.setAutoCommit(false); //JDBC��Ĭ����true���Զ��ύ����
			
			ps1 = conn.prepareStatement(tInsert);

			ps1.execute();
			
			conn.commit();
			System.out.println("����ɹ�");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				conn.rollback();//�ع�
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
			try {
				if(ps1 != null) 
					ps1.close();
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
