package 窗口;

import java.io.File;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DatabaseDemo {
    private static String path="E:\\QQ\\测试";
    
    public static void main(String[] args) {
        test();
    }
    public static void test() {
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
            sb.append("package cn.test.entity;\r\n");
            sb.append("public class TBLACCOUNT {\r\n");
            File dirFile = new File(path);
            if (!dirFile.exists()) {
                dirFile.mkdirs();
            }
            // 获取列名及类型
            int colunmCount = rs.getMetaData().getColumnCount();
            String[] colNameArr = new String[colunmCount];
            String[] colTypeArr = new String[colunmCount];
            for (int i = 0; i < colunmCount; i++) {
                colNameArr[i] = rs.getMetaData().getColumnName(i + 1);
                colTypeArr[i] = rs.getMetaData().getColumnTypeName(i + 1);
                sb.append(colNameArr[i]+"("+colTypeArr[i]+")"+"\r\n");
                System.out.println(colNameArr[i] + "(" + colTypeArr[i] + ")"+ " | ");
                if (colTypeArr[i].equals("varchar")||colTypeArr[i].equals("nvarchar")) {
                    sb.append("\tprivate String "+colNameArr[i]+";\r\n");
                    
                }else if (colTypeArr[i].equals("datetime")) {

                } else if (colTypeArr[i].equals("int")) {

                }
            }
            sb.append("}");
            File file = new File(dirFile,"TBLACCOUNT.java");
            if(file.exists()){
                file.delete();
            }
            FileOutputStream outputStream = new FileOutputStream(file);
            outputStream.write(sb.toString().getBytes());
            outputStream.close();
            System.out.println(" success ... ");
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