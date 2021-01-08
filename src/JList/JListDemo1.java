package JList;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Vector;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

public class JListDemo1 {

  public static void main(String[] args) throws Exception {
    File archivo = new File("E:\\QQ\\≤‚ ‘\\TableName.java");
    FileReader fr = new FileReader(archivo);
    BufferedReader br = new BufferedReader(fr);

    Vector<String> lines = new Vector<String>();

    String line;
    while ((line = br.readLine()) != null) {
      lines.add(line);
    }
    JOptionPane.showMessageDialog(null, new JScrollPane(new JList(lines)));
    System.out.println("—°‘Ò≥…π¶");
    fr.close();
  }
}