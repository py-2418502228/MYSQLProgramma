package ´°¿Ú;

import java.awt.Color;
import java.io.File;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Picture {
	public static void main(String arg[]) {
		JFrame frame = new JFrame("picture");
		String picpath = "E:\\QQ\\²âÊÔ\\src=http___img.php.cn_upload_article_000_000_008_65300b70f85174727a059d83b5d9fd44.png&refer=http___img.php.jpg";
		Icon icon = new ImageIcon(picpath);
		JLabel lab = null;
		lab = new JLabel(icon,JLabel.LEADING);
		lab.setBackground(Color.RED);
		lab.setForeground(Color.YELLOW);
		frame.add(lab);
		frame.setSize(300, 160);
		frame.setBackground(Color.WHITE);
		frame.setLocation(300, 200);
		frame.setVisible(true);
	}

}
