package JList;


import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.event.*;
import java.awt.*;
public class JListDemo2 extends JFrame implements ListSelectionListener {
    JList list;
    JTextArea text;
    static String[] lessons={"语文","数学","化学","地理"};
    static String[] times={"04-09-12","05-09-12","03-10-12","14-10-12"};
    public JListDemo2() {
        this.setTitle("Exec64 Test");
        this.setSize(400,400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        list = new JList(lessons);
        list.setVisibleRowCount(1);
        list.addListSelectionListener(this);
        list.addMouseListener(new doubleClick());
        text = new JTextArea(5,20);
        text.setBorder(BorderFactory.createEtchedBorder());
        
        add(list,BorderLayout.NORTH);
        add(text);
        
        
        this.setVisible(true);
        pack();
    }
    
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable(){
            public void run(){
                new JListDemo2();
            }
        });

    }
    @Override
    public void valueChanged(ListSelectionEvent e) {
        text.setText(((JList)e.getSource()).getSelectedValue().toString());
        
    }
    class doubleClick extends MouseAdapter {
        public void mouseClicked(MouseEvent e) {
            if(e.getClickCount() ==2) {
                text.append("\n"+times[((JList)e.getSource()).getSelectedIndex()]);
            }
        }
    }

}