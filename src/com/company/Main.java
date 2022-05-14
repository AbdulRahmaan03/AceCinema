package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main{

    public static void main(String[] args) {
        JFrame iF=new JFrame("Ace Cinema");
        JPanel iP=new JPanel();
        JButton iB=new JButton(new ImageIcon("src\\com\\resources\\intro.png"));

        iP.setBounds(0,0,800,450);
        iF.add(iP);
        iB.setBounds(0,0,800,450);
        iB.setBorderPainted(false);
        iP.add(iB);

        iB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                iF.dispose();
                new menu();
            }
        });

        iF.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        iF.setSize(800,450);
        iF.setLayout(null);
        iP.setLayout(null);
        iF.setVisible(true);
        iF.setLocationRelativeTo(null);
        iF.setResizable(false);
    }
}
