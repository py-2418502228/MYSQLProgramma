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
		MySQL.name.setText(null);//清空文本域
		System.out.println(tdatabase);
		MySQL.A.setText("删除成功,请关闭");
		
		Connection conn = null;
		String url = "jdbc:mysql://localhost:3306?useSSL=false&serverTimezone=GMT%2B8";
		String user = "root";
		String password = "2418502228";
		//Statement stmt = null;
		PreparedStatement ps = null;
		// 1.加载启动
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			// 2.建立数据库连接
			conn = DriverManager.getConnection(url, user, password);
			
			// 3.创建SQL命令发送器PreparedStatement
			//String sql = "drop database s"; //? 占位符
			ps = conn.prepareStatement(tdatabase);

			ps.execute(tdatabase);
			
			System.out.println("删除成功");

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
