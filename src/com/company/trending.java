package com.company;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileReader;
import java.util.Scanner;

public class trending implements ActionListener {
    private class Node{
        String data;
    }
    Node top;

    JFrame trendingframe = new JFrame("src\\com\\resources\\Trending Movie");
    JPanel trendingpanel = new JPanel();
    JLabel trendingbg = new JLabel();
    JButton trendingback = new JButton(new ImageIcon("src\\com\\resources\\Back.png"));
    String trendingid;

    trending(String id) {
        trendingid = id;
        trendingpanel.setBounds(0, 0, 800, 450);
        trendingbg.setIcon(new ImageIcon("src\\com\\resources\\bg.png"));
        trendingbg.setBounds(0, 0, 800, 450);

        trendingframe.add(trendingpanel);


        trendingback.setBounds(725, 365, 47, 32);
        trendingpanel.add(trendingback);

        trendingframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        trendingframe.setSize(800, 450);
        trendingframe.setLayout(null);
        trendingpanel.setLayout(null);
        trendingframe.setVisible(true);
        trendingframe.setLocationRelativeTo(null);
        trendingframe.setResizable(false);

        DefaultTableModel m = new DefaultTableModel();
        JTable t = new JTable(m);
        m.addColumn("ID");
        m.addColumn("Name");
        m.addColumn("Language");
        m.addColumn("Date");
        m.addColumn("Price");
        m.addColumn("SeatsAvailable");
        JTableHeader tableheader = t.getTableHeader();
        t.setRowHeight(35);
        t.setBackground(new Color(0, 0, 0, 0));
        t.setForeground(Color.white);
        tableheader.setForeground(Color.white);
        tableheader.setFont(new Font("Serif", Font.BOLD, 20));
        tableheader.setBackground(Color.black);
        t.setSelectionBackground(Color.gray);
        t.setShowGrid(false);
        t.setFont(new Font("Serif", Font.PLAIN, 15));
        JScrollPane sp = new JScrollPane(t);
        sp.getViewport().setBackground(Color.darkGray);

        sp.setBounds(35, 20, 700, 300);
        trendingpanel.add(sp);
        t.setOpaque(false);
        trendingpanel.add(trendingbg);

        String line;
        String[] arr = new String[0];
        trendingback.addActionListener(this);
        try{
            Node temp = new Node();
            FileReader fr=new FileReader("src\\com\\resources\\movie.txt");
            Scanner reader=new Scanner(fr);
            while(reader.hasNextLine()){
                line=reader.nextLine();
                temp.data = line;
                top = temp;
                arr = top.data.split(",");
            }
            m.addRow(arr);
            fr.close();
        }catch(Exception e1){JOptionPane.showMessageDialog(null, e1+"");}
    }
    @Override
    public void actionPerformed(ActionEvent ea) {
        if (ea.getSource() == trendingback) {
            trendingframe.dispose();
            new customerMenu(trendingid);
        }
    }
}
