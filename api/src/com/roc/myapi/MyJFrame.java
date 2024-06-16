package com.roc.myapi;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;

public class MyJFrame extends JFrame {

    public MyJFrame() throws HeadlessException {
        initJFrame();

        initView();

        setVisible(true);
    }

    private void initJFrame() {
        setSize(500, 600);
        setTitle("恶搞");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setAlwaysOnTop(true);
        setLocationRelativeTo(null);
        setLayout(null);
    }

    private void initView() {
        getContentPane().removeAll();

        JButton yesButton = new JButton("帅爆了");
        JButton midButton = new JButton("一般般");
        JButton noButton = new JButton("不帅");

        JLabel text = new JLabel("你觉得自己帅吗");

        text.setFont(new Font("微软雅黑", 0, 30));
        text.setBounds(120, 150, 300, 50);
        yesButton.setBounds(200, 250, 100, 30);
        midButton.setBounds(200, 325, 100, 30);
        noButton.setBounds(160, 400, 180, 30);

        yesButton.addActionListener(this::yesPerformed);
        midButton.addActionListener(this::midPerformed);
        noButton.addActionListener(this::noPerformed);

        getContentPane().add(text);
        getContentPane().add(yesButton);
        getContentPane().add(midButton);
        getContentPane().add(noButton);

        getContentPane().repaint();
    }

    private void showDad() {
        JButton dadButton = new JButton("饶了我吧!");
        dadButton.setBounds(50, 20, 100, 30);
        dadButton.addActionListener(this::dadPerformed);
        getContentPane().add(dadButton);
        getContentPane().repaint();
    }

    public void showDialogue(String content) {
        JDialog jDialog = new JDialog();
        jDialog.setSize(200, 150);
        jDialog.setAlwaysOnTop(true);
        jDialog.setLocationRelativeTo(null); //居中
        jDialog.setModal(true); //让弹窗不关闭无法操作下面的界面

        JLabel warning = new JLabel(content);
        warning.setBounds(0, 0, 200, 150);
        jDialog.getContentPane().removeAll();
        jDialog.getContentPane().add(warning);

        jDialog.setVisible(true);
    }

    private void dadPerformed(ActionEvent e) {
        showDialogue("这次就饶了你!");
        try {
            Runtime.getRuntime().exec("shutdown -a");
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    private void yesPerformed(ActionEvent e) {
        showDialogue("你太自信了");
        try {
            Runtime.getRuntime().exec("shutdown -s -t 3600");
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    private void midPerformed(ActionEvent e) {
        showDialogue("你还是太自信了");
        try {
            Runtime.getRuntime().exec("shutdown -s -t 5400");
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    private void noPerformed(ActionEvent e) {
        showDialogue("哈哈哈");
        try {
            Runtime.getRuntime().exec("shutdown -s -t 7200");
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        showDad();
    }
}
