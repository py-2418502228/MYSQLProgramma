package DatabaseCaozuo;


/*
 * 
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class NewTable implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		String ttable = MySQL.name.getText();//��ȡ�ı�������
		MySQL.name.setText(null);//����ı���
		System.out.println(ttable);
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
			//String sql = "create table t1(usename nchar(10) primary key,password int)";
			ps = conn.prepareStatement(ttable);
		
			ps.execute();
		
			System.out.println("�½��ɹ�");

		
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
