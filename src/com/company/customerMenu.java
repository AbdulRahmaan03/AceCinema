package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class customerMenu implements ActionListener {

    JFrame frame6= new JFrame("Customer Menu");
    JPanel panel6=new JPanel();
    JLabel l3=new JLabel();
    ImageIcon bg3=new ImageIcon("src\\com\\resources\\bg.png");
    ImageIcon r1=new ImageIcon("src\\com\\resources\\booktickets.png");
    ImageIcon r2=new ImageIcon("src\\com\\resources\\trending.png");
    ImageIcon r3=new ImageIcon("src\\com\\resources\\orderbyLang.png");
    JButton bookticket = new JButton();
    JButton trending = new JButton();
    JButton orderLang = new JButton();
    JButton backCusMenu = new JButton(new ImageIcon("src\\com\\resources\\Back.png"));
    String idCustomerMenu;


    customerMenu(String id)
    {
        idCustomerMenu = id;
        panel6.setBounds(0,0,800,450);
        bookticket.setBounds(150,70,500,100);
        trending.setBounds(150,140,500,100);
        orderLang.setBounds(150,210,500,100);
        bookticket.setIcon(r1);
        trending.setIcon(r2);
        orderLang.setIcon(r3);
        l3.setBounds(0,0,800,450);
        l3.setIcon(bg3);
        bookticket.addActionListener(this);
        trending.addActionListener(this);
        orderLang.addActionListener(this);

        bookticket.setBackground(new Color(0,0,0,0));
        bookticket.setOpaque(false);
        trending.setBackground(new Color(0,0,0,0));
        trending.setOpaque(false);
        orderLang.setBackground(new Color(0,0,0,0));
        orderLang.setOpaque(false);
        bookticket.setBorderPainted(false);
        trending.setBorderPainted(false);
        orderLang.setBorderPainted(false);

        backCusMenu.setBounds(725, 365, 47, 32);
        backCusMenu.addActionListener(this);
        panel6.add(backCusMenu);
        frame6.add(panel6);
        panel6.add(bookticket);
        panel6.add(trending);
        panel6.add(orderLang);
        panel6.add(l3);


        frame6.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame6.setSize(800,450);
        frame6.setLayout(null);
        panel6.setLayout(null);
        frame6.setVisible(true);
        frame6.setLocationRelativeTo(null);
        frame6.setResizable(false);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== bookticket) {
            frame6.dispose();
            new booktickets(idCustomerMenu);
        }
        else
        if(e.getSource()== trending){
            frame6.dispose();
            new trending(idCustomerMenu);
        }
        else
        if(e.getSource()== orderLang){
            frame6.dispose();
            new language(idCustomerMenu);
        }
        else
        if(e.getSource()==backCusMenu){
            frame6.dispose();
            new menu();
        }
    }
}
