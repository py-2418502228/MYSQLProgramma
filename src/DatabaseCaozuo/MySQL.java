package DatabaseCaozuo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
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

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import Drop.DropDatabase;
import Drop.DropTable;
import Drop.DropView;
import HanShu.Averag;
import HanShu.MinList;
import HanShu.SumList;
import Insert.InsertDemo;
import New.NewDatebase;
import New.NewTable;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import java.awt.FlowLayout;

public class MySQL extends JFrame {
	
	public static JTextArea name = new JTextArea(3,10);
	public static JLabel A = new JLabel("��ӭʹ��");
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MySQL frame = new MySQL();//ʵ��������
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param <JLable>
	 */
	public <JLable> MySQL() {
		setForeground(Color.CYAN);
		setIconImage(Toolkit.getDefaultToolkit().getImage("E:\\QQ\\\u6D4B\u8BD5\\my.jpg"));
		setTitle("MySql\u7BA1\u7406\u5668");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 281, 137);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu Mainmenu = new JMenu("\u83DC\u5355");
		menuBar.add(Mainmenu);
		
		JMenu New = new JMenu("\u65B0\u5EFA");
		Mainmenu.add(New);
		
		JMenuItem NewDatebase = new JMenuItem("\u65B0\u5EFA\u6570\u636E\u5E93");
		//����½����ݿ�
		NewDatebase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				name.setLineWrap(true);//����ı��������Զ�����
				JFrame h =new JFrame("�½����ݿ�");
				JLabel nameLab = new JLabel("�����½����ݿ���");
				JButton yes = new JButton("ȷ��");
				yes.setBounds(10, 50, 80, 20);//���ð�ť
				name.setBounds(110, 10, 300, 200);//���������ı���
				nameLab.setBounds(10, 10, 100, 20);//���ñ�ǩ
				A.setBounds(110, 150, 400, 200);//���ñ�ǩ
				Font fnt = new Font("Serief",Font.ITALIC+Font.BOLD,40);
				A.setFont(fnt);
				h.getContentPane().setLayout(null);
				//��������뵽������
				h.getContentPane().add(name);
				h.getContentPane().add(nameLab);
				h.getContentPane().add(yes);
				h.getContentPane().add(A);
				h.setSize(500, 320);
				h.setLocation(300, 200);
				h.setVisible(true);//��ʾ����
				//ִ��sql���
				yes.addActionListener(new NewDatebase());
			}
		});
		New.add(NewDatebase);
		
		JMenuItem NewTable = new JMenuItem("\u65B0\u5EFA\u8868");
		NewTable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				name.setLineWrap(true);//����ı��������Զ�����
				JFrame h =new JFrame("�½���");
				JLabel nameLab = new JLabel("�����½�����");
				JButton yes = new JButton("ȷ��");
				name.setBounds(110, 10, 300, 200);//���������ı���
				nameLab.setBounds(10, 10, 100, 20);
				A.setBounds(110, 150, 400, 200);
				yes.setBounds(10, 50, 80, 20);//���ð�ť
				Font fnt = new Font("Serief",Font.ITALIC+Font.BOLD,40);
				//��������뵽������
				h.getContentPane().setLayout(null);
				h.getContentPane().add(A);
				A.setFont(fnt);
				h.getContentPane().add(name);
				h.getContentPane().add(nameLab);
				h.getContentPane().add(yes);
				h.setSize(500, 320);
				h.setLocation(300, 200);
				h.setVisible(true);
				
				
				yes.addActionListener(new NewTable());//ִ��sql���
			}
		});
		New.add(NewTable);
		
		JMenuItem NewView = new JMenuItem("\u65B0\u5EFA\u89C6\u56FE");
		NewView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				name.setLineWrap(true);//����ı��������Զ�����
				JFrame h =new JFrame("�½���ͼ");
				JLabel nameLab = new JLabel("�����½���ͼ");
				JButton yes = new JButton("ȷ��");
				yes.setBounds(10, 50, 80, 20);//���ð�ť
				name.setBounds(110, 10, 300, 200);//���������ı���
				nameLab.setBounds(10, 10, 100, 20);
				A.setBounds(110, 150, 400, 200);
				Font fnt = new Font("Serief",Font.ITALIC+Font.BOLD,40);
				h.getContentPane().setLayout(null);
				//��������뵽������
				h.getContentPane().add(A);
				A.setFont(fnt);
				h.getContentPane().add(name);
				h.getContentPane().add(nameLab);
				h.getContentPane().add(yes);
				h.setSize(500, 320);
				h.setLocation(300, 200);
				h.setVisible(true);
				
				yes.addActionListener(new NewTable() );
			}
		});
		New.add(NewView);
		
		JSeparator separator = new JSeparator();
		Mainmenu.add(separator);
		
		JMenu Drop = new JMenu("\u5220\u9664");
		Mainmenu.add(Drop);
		
		JMenuItem DropDatebase = new JMenuItem("\u5220\u9664\u6570\u636E\u5E93");
		DropDatebase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				name.setLineWrap(true);//����ı��������Զ�����
				JFrame h =new JFrame("ɾ�����ݿ�");
				JLabel nameLab = new JLabel("��������Ҫɾ�����ݿ���");
				JButton yes = new JButton("ȷ��");
				yes.setBounds(10, 50, 80, 20);//���ð�ť
				name.setBounds(150, 10, 300, 200);//���������ı���
				nameLab.setBounds(10, 10, 200, 20);
				A.setBounds(110, 150, 400, 200);
				Font fnt = new Font("Serief",Font.ITALIC+Font.BOLD,40);
				h.getContentPane().setLayout(null);
				//��������뵽������
				h.getContentPane().add(A);
				A.setFont(fnt);
				h.getContentPane().add(name);
				h.getContentPane().add(nameLab);
				h.getContentPane().add(yes);
				h.setSize(500, 320);
				h.setLocation(300, 200);
				h.setVisible(true);
				//ִ��sql���
				yes.addActionListener(new DropDatabase());
			}
		});
		Drop.add(DropDatebase);
		
		JMenuItem DropTable = new JMenuItem("\u5220\u9664\u8868");
		DropTable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				name.setLineWrap(true);//����ı��������Զ�����
				JFrame h =new JFrame("ɾ����");
				JLabel nameLab = new JLabel("������ɾ������");
				JButton yes = new JButton("ȷ��");
				yes.setBounds(10, 50, 80, 20);//���ð�ť
				name.setBounds(110, 10, 300, 200);//���������ı���
				nameLab.setBounds(10, 10, 100, 20);
				A.setBounds(110, 150, 400, 200);
				Font fnt = new Font("Serief",Font.ITALIC+Font.BOLD,40);
				h.getContentPane().setLayout(null);
				//���������������
				h.getContentPane().add(A);
				A.setFont(fnt);
				h.getContentPane().add(name);
				h.getContentPane().add(nameLab);
				h.getContentPane().add(yes);
				h.setSize(500, 320);
				h.setLocation(300, 200);
				h.setVisible(true);
				//ִ��sql���
				yes.addActionListener(new DropTable());
			}
		});
		Drop.add(DropTable);
		
		JMenuItem DropView = new JMenuItem("\u5220\u9664\u89C6\u56FE");
		DropView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				name.setLineWrap(true);//����ı��������Զ�����
				JFrame h =new JFrame("ɾ����ͼ");
				JLabel nameLab = new JLabel("������ɾ����ͼ��");
				JButton yes = new JButton("ȷ��");
				yes.setBounds(10, 50, 80, 20);//���ð�ť
				name.setBounds(110, 10, 300, 200);//���������ı���
				nameLab.setBounds(10, 10, 100, 20);
				A.setBounds(110, 150, 400, 200);
				Font fnt = new Font("Serief",Font.ITALIC+Font.BOLD,40);
				h.getContentPane().setLayout(null);
				//���������������
				h.getContentPane().add(A);
				A.setFont(fnt);
				h.getContentPane().add(name);
				h.getContentPane().add(nameLab);
				h.getContentPane().add(yes);
				h.setSize(500, 320);
				h.setLocation(300, 200);
				h.setVisible(true);
				//ִ��sql���
				yes.addActionListener(new DropView());
			}
		});
		Drop.add(DropView);
		
		JMenu Look = new JMenu("\u67E5\u770B");
		menuBar.add(Look);
		
		JMenuItem Lookdatabase = new JMenuItem("\u67E5\u770B\u6570\u636E\u5E93\u540D");//�鿴���ݿ�
		Lookdatabase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				File archivo = new File("E:\\QQ\\����\\DatabaseName.java");//���ݿ��¼����λ��
		        FileReader fr = null;
				try {
					fr = new FileReader(archivo);
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		        BufferedReader br = new BufferedReader(fr);

		        Vector<String> lines = new Vector<String>();

		        String line;
		        try {
					while ((line = br.readLine()) != null) {
					  lines.add(line);
					}
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		        //����һ����Ϣ����������ݿ���Ϣ
		        JOptionPane.showMessageDialog(null, new JScrollPane(new JList(lines)));
		        try {
					fr.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		Look.add(Lookdatabase);
		
		JMenuItem Looktable = new JMenuItem("\u67E5\u770B\u6240\u4EE5\u8868\u540D");//�鿴�����Ϣ
		Looktable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				File archivo = new File("E:\\QQ\\����\\TableName.java");//��Ĵ洢·��
		        FileReader fr = null;
				try {
					fr = new FileReader(archivo);
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		        BufferedReader br = new BufferedReader(fr);

		        Vector<String> lines = new Vector<String>();

		        String line;
		        try {
					while ((line = br.readLine()) != null) {
					  lines.add(line);
					}
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		        JList jList = new JList(lines);
		        jList.addMouseListener(new doubleClick());//���˫���¼�����������Ϣ
		        JOptionPane.showMessageDialog(null, new JScrollPane(jList));
		        try {
					fr.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		Look.add(Looktable);
		
		JMenu Insertmenu = new JMenu("\u63D2\u5165");
		menuBar.add(Insertmenu);
		
		JMenuItem Insert = new JMenuItem("\u8868\u4E2D\u63D2\u5165\u6570\u636E");//�������ݵ�����
		Insert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				name.setLineWrap(true);//����ı��������Զ�����
				JFrame h =new JFrame("��������");
				JLabel nameLab = new JLabel("������SQL���");
				JButton yes = new JButton("ȷ��");
				yes.setBounds(10, 50, 80, 20);//���ð�ť
				name.setBounds(110, 10, 300, 200);//���������ı���
				nameLab.setBounds(10, 10, 100, 20);
				A.setBounds(110, 150, 400, 200);
				Font fnt = new Font("Serief",Font.ITALIC+Font.BOLD,40);
				h.getContentPane().setLayout(null);
				//���������������
				h.getContentPane().add(A);
				A.setFont(fnt);
				h.getContentPane().add(name);
				h.getContentPane().add(nameLab);
				h.getContentPane().add(yes);
				h.setSize(500, 320);
				h.setLocation(300, 200);
				h.setVisible(true);
				
				yes.addActionListener(new InsertDemo());
			}
		});
		Insertmenu.add(Insert);
		
		JMenuItem Out = new JMenuItem("\u5BFC\u51FA");//�����ݿ����ݵ������ĵ�
		Out.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String url = "jdbc:mysql://localhost:3306/mysqldemo?useSSL=false&serverTimezone=GMT%2B8";
				String user = "root";
				String password = "2418502228"; 
				
				
		        try {
					Class.forName("com.mysql.cj.jdbc.Driver");
				} catch (ClassNotFoundException e6) {
					// TODO Auto-generated catch block
					e6.printStackTrace();
				}  
		        Connection conn = null;
				try {
					conn = DriverManager.getConnection(url, user, password);
				} catch (SQLException e5) {
					// TODO Auto-generated catch block
					e5.printStackTrace();
				}  
		        
		        // ��ȡ���б���  
		        Statement statement = null;
				try {
					statement = conn.createStatement();
				} catch (SQLException e4) {
					// TODO Auto-generated catch block
					e4.printStackTrace();
				}  
		  
		        String dbUser =  null;
		    	String path="E:\\QQ\\����";
		        DatabaseMetaData dbMetData = null;
				try {
					dbMetData = conn.getMetaData();
				} catch (SQLException e3) {
					// TODO Auto-generated catch block
					e3.printStackTrace();
				}  
		        StringBuffer sb=new StringBuffer();
		        // mysql convertDatabaseCharsetType null  
		        ResultSet rs = null;
				try {
					rs = dbMetData.getTables(null,  
							dbUser, null,  
					        new String[] { "TABLE", "VIEW" });
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}  
		        
		        File dirFile = new File(path);
		        if (!dirFile.exists()) {
		            dirFile.mkdirs();
		        }

		        try {
					while (rs.next()) {  
					    if (rs.getString(4) != null  
					            && (rs.getString(4).equalsIgnoreCase("TABLE") || rs  
					                    .getString(4).equalsIgnoreCase("VIEW"))) {  
					        String tableName = rs.getString(3).toLowerCase();  
					        System.out.println(tableName + "\t"); 
					        sb.append(tableName+"\r\n"); //�������ļ�д���ĵ���
					        
					        
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
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
					        try {
								outputStream.close();
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}  
					     }  

					    
					}
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}   
			        
		        try {
					statement.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}  
		        try {
					conn.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}  
			}
		});
		menuBar.add(Out);
		
		JMenu HanShu = new JMenu("\u51FD\u6570");
		menuBar.add(HanShu);
		
		JMenuItem Sum = new JMenuItem("\u6C42\u548C");
		Sum.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				name.setLineWrap(true);//����ı��������Զ�����
				JFrame h =new JFrame("��������");
				JLabel nameLab = new JLabel("������SQL���");
				JButton yes = new JButton("ȷ��");
				yes.setBounds(10, 50, 80, 20);//���ð�ť
				name.setBounds(110, 10, 300, 200);//���������ı���
				nameLab.setBounds(10, 10, 100, 20);
				A.setBounds(110, 150, 400, 200);
				Font fnt = new Font("Serief",Font.ITALIC+Font.BOLD,40);
				h.getContentPane().setLayout(null);
				//���������������
				h.getContentPane().add(A);
				A.setFont(fnt);
				h.getContentPane().add(name);
				h.getContentPane().add(nameLab);
				h.getContentPane().add(yes);
				h.setSize(500, 320);
				h.setLocation(300, 200);
				h.setVisible(true);
				
				yes.addActionListener(new SumList());
			}
				
		});
		HanShu.add(Sum);
		
		JMenuItem Avg = new JMenuItem("\u5E73\u5747\u6570");
		Avg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				name.setLineWrap(true);//����ı��������Զ�����
				JFrame h =new JFrame("��������");
				JLabel nameLab = new JLabel("������SQL���");
				JButton yes = new JButton("ȷ��");
				yes.setBounds(10, 50, 80, 20);//���ð�ť
				name.setBounds(110, 10, 300, 200);//���������ı���
				nameLab.setBounds(10, 10, 100, 20);
				A.setBounds(110, 150, 400, 200);
				Font fnt = new Font("Serief",Font.ITALIC+Font.BOLD,40);
				h.getContentPane().setLayout(null);
				//���������������
				h.getContentPane().add(A);
				A.setFont(fnt);
				h.getContentPane().add(name);
				h.getContentPane().add(nameLab);
				h.getContentPane().add(yes);
				h.setSize(500, 320);
				h.setLocation(300, 200);
				h.setVisible(true);
				
				yes.addActionListener(new Averag());
			}
		});
		HanShu.add(Avg);
		
		JMenuItem MaxList = new JMenuItem("\u6700\u5927\u503C");
		MaxList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				name.setLineWrap(true);//����ı��������Զ�����
				JFrame h =new JFrame("��������");
				JLabel nameLab = new JLabel("������SQL���");
				JButton yes = new JButton("ȷ��");
				yes.setBounds(10, 50, 80, 20);//���ð�ť
				name.setBounds(110, 10, 300, 200);//���������ı���
				nameLab.setBounds(10, 10, 100, 20);
				A.setBounds(110, 150, 400, 200);
				Font fnt = new Font("Serief",Font.ITALIC+Font.BOLD,40);
				h.getContentPane().setLayout(null);
				//���������������
				h.getContentPane().add(A);
				A.setFont(fnt);
				h.getContentPane().add(name);
				h.getContentPane().add(nameLab);
				h.getContentPane().add(yes);
				h.setSize(500, 320);
				h.setLocation(300, 200);
				h.setVisible(true);
				
				yes.addActionListener(new SumList());
			}
		});
		HanShu.add(MaxList);
		
		JMenuItem MinJlist = new JMenuItem("\u6700\u5C0F\u503C");
		MinJlist.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				name.setLineWrap(true);//����ı��������Զ�����
				JFrame h =new JFrame("��������");
				JLabel nameLab = new JLabel("������SQL���");
				JButton yes = new JButton("ȷ��");
				yes.setBounds(10, 50, 80, 20);//���ð�ť
				name.setBounds(110, 10, 300, 200);//���������ı���
				nameLab.setBounds(10, 10, 100, 20);
				A.setBounds(110, 150, 400, 200);
				Font fnt = new Font("Serief",Font.ITALIC+Font.BOLD,40);
				h.getContentPane().setLayout(null);
				//���������������
				h.getContentPane().add(A);
				A.setFont(fnt);
				h.getContentPane().add(name);
				h.getContentPane().add(nameLab);
				h.getContentPane().add(yes);
				h.setSize(500, 320);
				h.setLocation(300, 200);
				h.setVisible(true);
				
				yes.addActionListener(new MinList());
			}
		});
		HanShu.add(MinJlist);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(102, 204, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
	}
}
//˫��JList�д����¼�
class doubleClick extends MouseAdapter {
    public void mouseClicked(MouseEvent e) {
        if(e.getClickCount() ==2) {
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
          			
          			
          			String sql = "select * from "+((JList)e.getSource()).getSelectedValue().toString();
          			
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
 
}