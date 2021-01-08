package DatabaseCaozuo;

/*
select Sum(marks)  as He
from  t1
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SumList implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
			String sum = MySQL.name.getText();//获取文本域内容
			System.out.println(sum);
			MySQL.name.setText(null);//清空文本域
			MySQL.A.setText("查询成功,请关闭");
			
	
		
		Connection conn = null;
		String url = "jdbc:mysql://localhost:3306/mysqldemo?useSSL=false&serverTimezone=GMT%2B8";
		String user = "root";
		String password = "2418502228";
		ResultSet rs = null;
		Statement stmt = null;
		int S = 0;
		// 1.加载启动
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			//long start = System.currentTimeMillis();
			// 2.建立数据库连接
			conn = DriverManager.getConnection(url, user, password);
			
			// 3.创建SQL命令发送器PreparedStatement
			//String sql = "create database s"; //
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sum);
			while(rs.next()) {
				S=S+rs.getInt("He");//计算求和
			}
			System.out.println(S);
			System.out.println("计算成功");

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) 
					rs.close();
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
