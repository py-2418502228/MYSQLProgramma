package Show;

import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;  
import java.sql.DatabaseMetaData;  
import java.sql.DriverManager;  
import java.sql.ResultSet;  
import java.sql.ResultSetMetaData;  
import java.sql.SQLException;  
import java.sql.Statement;  
import java.sql.Types;  
  
//jdbc链接数据库,获取表名，字段名和数据  
public class ShowTable {  
  
	private static String path="E:\\QQ\\测试";
	
    public static void main(String[] args) throws Exception {  
    
        String url = "jdbc:mysql://localhost:3306/mysqldemo?useSSL=false&serverTimezone=GMT%2B8";
		String user = "root";
		String password = "2418502228"; 
		
		
        Class.forName("com.mysql.cj.jdbc.Driver");  
        Connection conn = DriverManager.getConnection(url, user, password);  
        
        // 获取所有表名  
        Statement statement = conn.createStatement();  
  
        
        getTables(conn);  
  
        
        statement.close();  
        conn.close();  
  
    }  
  
    public static String convertDatabaseCharsetType(String in, String type) {  
        String dbUser;  
        if (in != null) {  
            if (type.equals("oracle")) {  
                dbUser = in.toUpperCase();  
            } else if (type.equals("postgresql")) {  
                dbUser = "public";  
            } else if (type.equals("mysql")) {  
                dbUser = null;  
            } else if (type.equals("mssqlserver")) {  
                dbUser = null;  
            } else if (type.equals("db2")) {  
                dbUser = in.toUpperCase();  
            } else {  
                dbUser = in;  
            }  
        } else {  
            dbUser = "public";  
        }  
        return dbUser;  
    }  
  
    private static void getTables(Connection conn) throws SQLException {  
        DatabaseMetaData dbMetData = conn.getMetaData();  
        StringBuffer sb=new StringBuffer();
        // mysql convertDatabaseCharsetType null  
        ResultSet rs = dbMetData.getTables(null,  
                convertDatabaseCharsetType("root", "mysql"), null,  
                new String[] { "TABLE", "VIEW" });  
        
        File dirFile = new File(path);
        if (!dirFile.exists()) {
            dirFile.mkdirs();
        }
  
        while (rs.next()) {  
            if (rs.getString(4) != null  
                    && (rs.getString(4).equalsIgnoreCase("TABLE") || rs  
                            .getString(4).equalsIgnoreCase("VIEW"))) {  
                String tableName = rs.getString(3).toLowerCase();  
                System.out.print(tableName + "\t"); 
                sb.append(tableName+"\r\n"); //将数据文件写入文档中
                
                
                File file = new File(dirFile,"TableName.java");
                if(file.exists()){
                    file.delete();
                }
                FileOutputStream outputStream = null;
				try {
					outputStream = new FileOutputStream(file);
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
                try {
					outputStream.write(sb.toString().getBytes());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
                try {
					outputStream.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}  
             }  
  
            
        }   
  
  
    }  
  
}  