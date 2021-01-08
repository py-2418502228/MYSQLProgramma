package 窗口;

import java.io.File;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Tablesuo {
	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/mysqldemo?useSSL=false&serverTimezone=GMT%2B8";
		String user = "root";
		String password = "2418502228";
		 Connection conn = null;
	        PreparedStatement ps = null;
	        ResultSet rs = null;
	        StringBuffer sb=new StringBuffer();
	        try {
	        	Class.forName("com.mysql.cj.jdbc.Driver");
	            conn = DriverManager.getConnection(url, user, password);
	            String sql = "select * from t1";
	            ps = conn.prepareStatement(sql);
	            rs = ps.executeQuery();
	            // 获取列名及类型
	            int colunmCount = rs.getMetaData().getColumnCount();//列计数
	            String[] colNameArr = new String[colunmCount];//列名
	            String[] colTypeArr = new String[colunmCount];//列的数据类型
	            for (int i = 0; i < colunmCount; i++) {
	                colNameArr[i] = rs.getMetaData().getColumnName(i + 1);
	                colTypeArr[i] = rs.getMetaData().getColumnTypeName(i + 1);
	                System.out.print(colNameArr[i] + "(" + colTypeArr[i] + ")"+ " | "); 
	            }
	        } catch (Exception e) {
	            e.printStackTrace(System.out);
	        } finally {
	            try {
	                if (null != rs) {
	                    rs.close();
	                }
	                if (null != ps) {
	                    ps.close();
	                }
	                if (null != conn) {
	                    conn.close();
	                }
	            } catch (Exception e2) {
	            }
	        }
	    }
}



