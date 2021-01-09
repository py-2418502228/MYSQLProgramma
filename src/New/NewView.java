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
		MySQL.name.setText(null);//清空文本域
		System.out.println(tview);
		MySQL.A.setText("新建成功,请关闭");
		
		
		Connection conn = null;
		String url = "jdbc:mysql://localhost:3306/mysqldemo?useSSL=false&serverTimezone=GMT%2B8";
		String user = "root";
		String password = "2418502228";
		PreparedStatement ps = null;
		// 1.加载启动
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			// 2.建立数据库连接
			conn = DriverManager.getConnection(url, user, password);
			
			// 3.创建SQL命令发送器PreparedStatement
			//String sql = "create view e(usename,password) as select usename,password from t1";
			ps = conn.prepareStatement(tview);
			
			ps.execute(tview);
			
			System.out.println("新建成功");

			
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
