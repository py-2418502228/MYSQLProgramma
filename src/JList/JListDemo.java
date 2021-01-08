package JList;

import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class JListDemo {
	public static void main(String[] args) {		
		
		JFrame f = new JFrame();
		f.setSize(600, 500);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel = new JPanel();
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setPreferredSize(new Dimension(200,100));
		//以数组构造方法创建
		String[] str = {"aa","bb","cc","dd","ee","ff","gg"};
		 JList jList = new JList(str);
		jList.addMouseListener(new doubleClick());
		
		
		scrollPane.setViewportView(jList);
		panel.add(scrollPane);
		f.getContentPane().add(panel);
		f.setVisible(true);

		
	}
}

class doubleClick extends MouseAdapter {
    public void mouseClicked(MouseEvent e) {
        if(e.getClickCount() ==2) {
        	Connection conn = null;
    		String url = "jdbc:mysql://localhost:3306/mysqldemo?useSSL=false&serverTimezone=GMT%2B8";
    		String user = "root";
    		String password = "2418502228";
    		Statement stmt = null;
    		ResultSet rs = null;
    		//PreparedStatement ps = null;
    		// 1.加载启动
    		try {
    			Class.forName("com.mysql.cj.jdbc.Driver");
    			// 2.建立数据库连接
    			conn = DriverManager.getConnection(url, user, password);
    			
    			// 3.创建SQL命令发送器PreparedStatement
    			
    			
    			String sql = "select * from t1";
    			
    			Statement statement = conn.createStatement();
    			ResultSet resultSet = statement.executeQuery(sql);;
    			// 获取列名  
    	        ResultSetMetaData metaData = resultSet.getMetaData();  
    	        for (int i = 0; i < metaData.getColumnCount(); i++) {  
    	            // resultSet数据下标从1开始  
    	            String columnName = metaData.getColumnName(i + 1);  
    	            int type = metaData.getColumnType(i + 1);  
    	            if (Types.INTEGER == type) {  
    	                // int  
    	            } else if (Types.VARCHAR == type) {  
    	                // String  
    	            }  
    	            System.out.print(columnName + "\t");  
    	        }  
    	        System.out.println();  
    	        // 获取数据  
    	        while (resultSet.next()) {  
    	            for (int i = 0; i < metaData.getColumnCount(); i++) {  
    	                // resultSet数据下标从1开始  
    	                System.out.print(resultSet.getString(i + 1) + "\t");  
    	            }  
    	            System.out.println();  
    	  
    	        }  
    			
    			//System.out.println("新建成功");

    		} catch (ClassNotFoundException e1) {
    			// TODO Auto-generated catch block
    			e1.printStackTrace();
    		} catch (SQLException e1) {
    			// TODO Auto-generated catch block
    			e1.printStackTrace();
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
    			} catch (SQLException e1) {
    				// TODO Auto-generated catch block
    				e1.printStackTrace();
    			}
    		}

    	 }
      }
   
}