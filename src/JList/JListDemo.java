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
		//�����鹹�췽������
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
    		// 1.��������
    		try {
    			Class.forName("com.mysql.cj.jdbc.Driver");
    			// 2.�������ݿ�����
    			conn = DriverManager.getConnection(url, user, password);
    			
    			// 3.����SQL�������PreparedStatement
    			
    			
    			String sql = "select * from t1";
    			
    			Statement statement = conn.createStatement();
    			ResultSet resultSet = statement.executeQuery(sql);;
    			// ��ȡ����  
    	        ResultSetMetaData metaData = resultSet.getMetaData();  
    	        for (int i = 0; i < metaData.getColumnCount(); i++) {  
    	            // resultSet�����±��1��ʼ  
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
    	        // ��ȡ����  
    	        while (resultSet.next()) {  
    	            for (int i = 0; i < metaData.getColumnCount(); i++) {  
    	                // resultSet�����±��1��ʼ  
    	                System.out.print(resultSet.getString(i + 1) + "\t");  
    	            }  
    	            System.out.println();  
    	  
    	        }  
    			
    			//System.out.println("�½��ɹ�");

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