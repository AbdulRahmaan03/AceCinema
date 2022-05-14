package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class adminMenu implements ActionListener {
    Movie m = new Movie();
    JFrame amframe = new JFrame("src\\com\\resources\\Admin Menu");
    JPanel ampanel = new JPanel();
    JButton create = new JButton(new ImageIcon("src\\com\\resources\\create.png"));

    JButton display = new JButton(new ImageIcon("src\\com\\resources\\display.png"));
    JButton modify = new JButton(new ImageIcon("src\\com\\resources\\modify.png"));

    JButton amback = new JButton(new ImageIcon("src\\com\\resources\\Back.png"));
    JLabel l = new JLabel();
    ImageIcon bg = new ImageIcon("src\\com\\resources\\bg.png");

    ImageIcon icon = new ImageIcon("src\\com\\resources\\label1.png");

    JLabel label = new JLabel(icon,JLabel.CENTER);



    adminMenu()
    {
        ampanel.setBounds(0,0,800,450);
        create.setBounds(325,90,150,75);
        modify.setBounds(325,165,150,75);
        display.setBounds(325,240,150,75);
        label.setBounds(250,0,300,100);
        l.setBounds(0,0,800,450);
        l.setIcon(bg);

        create.setBackground(new Color(0,0,0,0));
        create.setOpaque(false);
        create.setBorderPainted(false);
        modify.setBackground(new Color(0,0,0,0));
        modify.setOpaque(false);
        modify.setBorderPainted(false);
        display.setBackground(new Color(0,0,0,0));
        display.setOpaque(false);
        display.setBorderPainted(false);


        amback.setBounds(725, 365, 47, 32);
        amback.addActionListener(this);
        ampanel.add(amback);

        amframe.add(ampanel);
        ampanel.add(create);
        ampanel.add(modify);
        ampanel.add(display);
        ampanel.add(label);
        ampanel.add(l);



        amframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        amframe.setSize(800,450);
        amframe.setLayout(null);
        ampanel.setLayout(null);
        amframe.setVisible(true);
        amframe.setLocationRelativeTo(null);
        amframe.setResizable(false);

        create.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                amframe.dispose();
                m.addMovie();
            }
        });

        modify.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                amframe.dispose();
                m.modifyMovie();
            }
        });

        display.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                amframe.dispose();
                m.displayMovie();
            }
        });

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== amback){
            amframe.dispose();
            new menu();
        }
    }


}
