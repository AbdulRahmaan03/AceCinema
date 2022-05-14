package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class menu implements ActionListener {

    JFrame f = new JFrame("Main Menu");
    JPanel p = new JPanel();
    JButton admin = new JButton();
    JButton customer = new JButton();
    JLabel l=new JLabel();
    ImageIcon bg=new ImageIcon("src\\com\\resources\\bg.png");
    String idbt;


    menu()
    {



        p.setBounds(0,0,800,450);
        admin.setBounds(50,50,300,300);
        customer.setBounds(430,50,300,300);
        admin.setIcon(new ImageIcon("src\\com\\resources\\admin.png"));
        customer.setIcon(new ImageIcon("src\\com\\resources\\customer.png"));
        admin.addActionListener(this);
        customer.addActionListener(this);
        l.setIcon(bg);
        l.setBounds(0,0,800,450);

        admin.setBackground(new Color(0,0,0,0));
        admin.setOpaque(false);
        customer.setBackground(new Color(0,0,0,0));
        customer.setOpaque(false);
        admin.setBorderPainted(false);
        customer.setBorderPainted(false);
        f.add(p);
        p.add(admin);
        p.add(customer);
        p.add(l);


        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(800,450);
        f.setLayout(null);
        p.setLayout(null);
        f.setVisible(true);
        f.setLocationRelativeTo(null);
        f.setResizable(false);





    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== admin) {
            f.dispose();
            new adminLogin();
        }
        else
        if(e.getSource()==customer){
            f.dispose();
            new customerMenu(idbt);
        }
    }
}
