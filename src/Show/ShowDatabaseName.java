package Show;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.Vector;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

public class ShowDatabaseName  {
	private static String path="E:\\QQ\\测试";
	
	public static void main(String[] args) throws Exception {  
		 
		String url = "jdbc:mysql://localhost:3306/mysqldemo?useSSL=false&serverTimezone=GMT%2B8";
		String user = "root";
		String password = "2418502228";
		Class.forName("com.mysql.cj.jdbc.Driver"); 
		StringBuffer sb=new StringBuffer();
        Connection conn = DriverManager.getConnection(url, user, password);  
        // 获取所有表名  
        Statement statement = conn.createStatement();  

        //获取该连接下所有的库名
        String sql1 = "SHOW DATABASES";
        ResultSet resultSouceSet = statement  
                .executeQuery(sql1);  
        File dirFile = new File(path);
        if (!dirFile.exists()) {
            dirFile.mkdirs();
        }
        while(resultSouceSet.next()){
            System.out.println(resultSouceSet.getString("database"));//输出名称
            
            sb.append(resultSouceSet.getString("database")+":\r\n"); //将数据文件写入文档中

        }  
        File file = new File(dirFile,"DatabaseName.java");
        if(file.exists()){
            file.delete();
        }
        FileOutputStream outputStream = new FileOutputStream(file);
        outputStream.write(sb.toString().getBytes());
        outputStream.close();
        
        
        
  
        //关闭连接
        statement.close();  
        conn.close();  

    }  

    
	 

}
