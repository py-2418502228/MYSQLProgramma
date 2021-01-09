package login;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;
 
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
 
public class LoginJM implements ActionListener{
	private javax.swing.JTextField text_name;
	private javax.swing.JPasswordField text_password;
	private javax.swing.JFrame login;
	
	public LoginJM(javax.swing.JFrame login,javax.swing.JTextField text_name,javax.swing.JPasswordField text_password)
	{//获取登录界面、账号密码输入框对象
		this.login=login;
		this.text_name=text_name;
		this.text_password=text_password;
	}
	
	
	@SuppressWarnings("deprecation")
	public void actionPerformed(ActionEvent e)
	{
		Dimension dim2 = new Dimension(100,30);
		Dimension dim3 = new Dimension(300,30);
		
		//生成新界面
		javax.swing.JFrame login2 = new javax.swing.JFrame();
		login2.setSize(400,200);
		login2.setDefaultCloseOperation(3);
		login2.setLocationRelativeTo(null);
		login2.setFont(new Font("宋体",Font.PLAIN,14));  //宋体，正常风格，14号字体
		//创建组件
		javax.swing.JPanel jp1 = new JPanel();
		javax.swing.JPanel jp2 = new JPanel();
 
			if(text_name.getText().equals("baiduneko") && text_password.getText().equals("314159"))
			{	
				JLabel message = new JLabel("登陆成功！");
				message.setFont(new Font("宋体",Font.PLAIN,14));  //宋体，正常风格，14号字体
				message.setPreferredSize(dim3);
				jp1.add(message);
				login2.add(jp1,BorderLayout.CENTER);
				
				login2.setResizable(false);
				login2.setVisible(true);
				
				//通过我们获取的登录界面对象，用dispose方法关闭它
				login.dispose();
			}
			else
			{
				JLabel message = new JLabel("账号或密码错误!请重新输入！");
				message.setFont(new Font("宋体",Font.PLAIN,14));  //宋体，正常风格，14号字体
				message.setPreferredSize(dim3);
				//将textName标签添加到窗体上
				jp1.add(message);
				login2.add(jp1,BorderLayout.CENTER);
				
				JButton close = new JButton("确定");
				close.setFont(new Font("宋体",Font.PLAIN,14));
				//设置按键大小
				close.setSize(dim3);
				jp2.add(close);
				login2.add(jp2,BorderLayout.SOUTH);
				
				close.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						login2.dispose();
					}
				});
				
				login2.setResizable(false);
				login2.setVisible(true);
			}
			
	}
}