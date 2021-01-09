package login;
/*
 *		��¼����
 */
import java.awt.Dimension;  //��װ��һ�������ĸ߶ȺͿ��
import java.awt.FlowLayout;
import java.awt.Font;
 
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
 
public class Logintxt {
 
	//�����ж���������
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//���������У�ʵ����Login��Ķ��󣬵��ó�ʼ������ķ���
		Logintxt login = new Logintxt();
		login.initUI();
 
	}
	
	//�����ж����ʼ������ķ���
	public void initUI() {
		//��initUI��ʵ����JFrame��Ķ���
		JFrame frame = new JFrame();
		//���ô�����������ֵ
		frame.setTitle("MySql��������¼");//���ô������
		frame.setSize(400, 250);//���ô����С��ֻ�Զ���������Ч
		frame.setDefaultCloseOperation(3);//���ô���رղ�����3��ʾ�رմ����˳�����
		frame.setLocationRelativeTo(null);//���ô����������һ���ľ���λ�ã�����null��ʾ�����������Ļ������λ��
		frame.setResizable(false);//��ֹ���������С
		frame.setFont(new Font("����",Font.PLAIN,14));//�������壬��ʾ��ʽ��������С
		
		//ʵ����FlowLayout��ʽ������Ķ���ָ�����뷽ʽΪ���ж������֮��ļ��Ϊ10������
		FlowLayout fl = new FlowLayout(FlowLayout.CENTER,10,10);
		//ʵ������ʽ������Ķ���
		frame.setLayout(fl);
		
		//ʵ����JLabel��ǩ���󣬸ö�����ʾ���˺š�
		JLabel labname = new JLabel("�˺ţ�");
		labname.setFont(new Font("����",Font.PLAIN,14));
		//��labname��ǩ��ӵ�������
		frame.add(labname);
		
		//ʵ����JTextField��ǩ����
		JTextField text_name = new JTextField();
		Dimension dim1 = new Dimension(300,30);
		text_name.setPreferredSize(dim1);//���ó������������������������Ĵ�С
		//��textName��ǩ��ӵ�������
		frame.add(text_name);
		
		//ʵ����JLabel��ǩ���󣬸ö�����ʾ�����롱
		JLabel labpass = new JLabel("���룺");
		labpass.setFont(new Font("����",Font.PLAIN,14));
		//��labpass��ӵ�������
		frame.add(labpass);
		
		//ʵ����JPasswordField
		JPasswordField text_password = new JPasswordField();
		//���ô�С
		text_password.setPreferredSize(dim1);
		//��ӵ�����
		frame.add(text_password);
		
		//ʵ����JButton���
		JButton button1 = new JButton();
		//���ð�������ʾ����
		Dimension dim2 = new Dimension(100,30);
		button1.setText("��¼");
		button1.setFont(new Font("����",Font.PLAIN,14));
		//���ð�����С
		button1.setSize(dim2);
		frame.add(button1);
		
		frame.setVisible(true);//����ɼ���һ��Ҫ��������������봰���
		
		LoginJM ll = new LoginJM(frame,text_name,text_password);
		button1.addActionListener(ll);
	}
}