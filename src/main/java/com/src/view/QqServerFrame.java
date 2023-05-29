package com.src.view;



import com.src.model.MyQqServer;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 功能
 *
 * @author caojianbang
 * @date 20/12/2021 12:22
 */
public class QqServerFrame extends JFrame implements ActionListener {
    JPanel jp;
    JButton jb1, jb2;

    public static void main(String[] args) {
        QqServerFrame qqServerFrame = new QqServerFrame();
    }

    public QqServerFrame() {
        jp = new JPanel();
        jb1 = new JButton("启动服务器");
        jb2 = new JButton("关闭服务器");
        jb1.addActionListener(this);
        jb2.addActionListener(this);
        jp.add(jb1);
        jp.add(jb2);
        this.add(jp);
        this.setSize(600, 500);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }


    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == jb1) {
            new MyQqServer();

        } else if (e.getSource() == jb2) {
            System.exit(0);
        }
    }
}

