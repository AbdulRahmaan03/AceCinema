package com.company;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class booktickets implements ActionListener {
    JFrame btframe = new JFrame("Book Tickets");
    JPanel btpanel = new JPanel();
    JLabel btlabel1 = new JLabel("Enter ID");
    JLabel btlabel2 = new JLabel("Enter Number of Tickets");
    JLabel btlabel3 = new JLabel("Movie name");
    JLabel btlabel4 = new JLabel("Price");
    JLabel btlabel5 = new JLabel("");
    JLabel btlabel6 = new JLabel("");
    JButton btproceed = new JButton(new ImageIcon("src\\com\\resources\\PROCEED.png"));
    JLabel btBg = new JLabel();
    JTextField btID = new JTextField();
    JTextField numberoftickets = new JTextField();
    JButton btback =new JButton(new ImageIcon("src\\com\\resources\\Back.png"));
    String idbt;
    JLabel info=new JLabel();

    booktickets(String id){
        idbt = id;
        btpanel.setBounds(0,0,800,600);
        btBg.setIcon(new ImageIcon("src\\com\\resources\\bg.png"));
        btBg.setBounds(0,0,800,600);
        btlabel1.setBounds(10,310,80,25);
        btpanel.add(btlabel1);
        btlabel2.setBounds(10,340,300,25);
        btpanel.add(btlabel2);
        btlabel3.setBounds(10,370,300,25);
        btpanel.add(btlabel3);
        btlabel4.setBounds(10,400,80,25);
        btpanel.add(btlabel4);
        btlabel5.setBounds(300,370,600,25);
        btpanel.add(btlabel5);
        btlabel6.setBounds(300,410,300,25);
        btpanel.add(btlabel6);
        btlabel1.setForeground(Color.white);
        btlabel1.setFont(new Font("SansSerif",Font.PLAIN,20));
        btlabel2.setForeground(Color.white);
        btlabel2.setFont(new Font("SansSerif",Font.PLAIN,20));
        btlabel3.setForeground(Color.white);
        btlabel3.setFont(new Font("SansSerif",Font.PLAIN,20));
        btlabel4.setForeground(Color.white);
        btlabel4.setFont(new Font("SansSerif",Font.PLAIN,20));
        btlabel5.setForeground(Color.white);
        btlabel5.setFont(new Font("SansSerif",Font.PLAIN,20));
        btlabel6.setForeground(Color.white);
        btlabel6.setFont(new Font("SansSerif",Font.PLAIN,20));
        btID.setBounds(300, 310, 250, 25);
        btpanel.add(btID);
        numberoftickets.setBounds(300, 340, 250, 25);
        btpanel.add(numberoftickets);


        btframe.add(btpanel);
        info.setBounds(10,380,500,25);
        btpanel.add(info);
        info.setForeground(Color.white);
        info.setFont(new Font("SansSerif",Font.PLAIN,20));


        btback.setBounds(725, 500, 47, 32);
        btback.addActionListener(this);
        btpanel.add(btback);
        btproceed.setBounds(350,500,100,40);
        btpanel.add(btproceed);
        btproceed.addActionListener(this);

        btframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        btframe.setSize(800,600);
        btframe.setLayout(null);
        btpanel.setLayout(null);
        btframe.setVisible(true);
        btframe.setLocationRelativeTo(null);
        btframe.setResizable(false);

        DefaultTableModel m = new DefaultTableModel();
        JTable t =new JTable(m);
        m.addColumn("ID");
        m.addColumn("Name");
        m.addColumn("Language");
        m.addColumn("Date");
        m.addColumn("Price");
        m.addColumn("SeatsAvailable");
        t.setRowHeight(35);
        t.setBackground(new Color(0,0,0,0));
        t.setForeground(Color.white);
        JTableHeader tableheader = t.getTableHeader();
        tableheader.setForeground(Color.white);
        tableheader.setFont(new Font("Serif", Font.BOLD, 20));
        tableheader.setBackground(Color.black);
        t.setSelectionBackground(Color.gray);
        t.setShowGrid(false);

        t.setFont(new Font("Serif", Font.PLAIN, 15));

        JScrollPane sp=new JScrollPane(t);
        sp.getViewport().setBackground(Color.darkGray);
        sp.setBounds(35,20,700,275);
        btpanel.add(sp);
        t.setOpaque(false);
        btpanel.add(btBg);

        String line;
        String[] arr;


        try{
            FileReader fr=new FileReader("src\\com\\resources\\movie.txt");
            Scanner reader=new Scanner(fr);
            while(reader.hasNextLine()){
                line=reader.nextLine();
                arr = line.split(",");
                int c = Integer.parseInt(arr[5]);
                if(!(line.equals(""))){
                    if (c>0) {
                        m.addRow(arr);
                    }

                }
            }
            fr.close();
        }catch(Exception e1){JOptionPane.showMessageDialog(null, e1+"");}
    }



    @Override
    public void actionPerformed(ActionEvent ea) {
        if (ea.getSource() == btproceed) {
            String bookID = this.btID.getText();
            String numofticket = this.numberoftickets.getText();
            ArrayList<String> tempArr = new ArrayList<String>();
            int flag = 0;
            String line;
            String[] arr;

            if (bookID.trim().isEmpty()) {
                info.setText("ENTER MOVIE ID");
            } else {
                info.setText("");
                try {
                    FileReader fr = new FileReader("src\\com\\resources\\movie.txt");
                    Scanner reader = new Scanner(fr);
                    while (reader.hasNextLine()) {
                        line = reader.nextLine();
                        arr = line.split(",");
                        if (arr[0].equals(bookID)) {
                            int a = Integer.parseInt(arr[5]);
                            int b = Integer.parseInt(numofticket);
                            if (a != 0 && a > b) {
                                int p = Integer.parseInt(arr[4]);
                                int total = p*b;
                                int c = a - b;
                                String tot = String.valueOf(total);
                                arr[5] = String.valueOf(c);
                                tempArr.add(arr[0] + "," + arr[1] + "," + arr[2] + "," + arr[3] + "," + arr[4] + "," + arr[5]);
                                btlabel5.setText(arr[1]);
                                btlabel6.setText("$"+tot);

                            }
                            else{JOptionPane.showMessageDialog(null, "SEATS FULL or WRONG MOVIE ID");
                                tempArr.add(line);
                                flag = 1;
                            }
                        }
                        else {
                            tempArr.add(line);
                        }
                    }
                    fr.close();
                }catch (Exception e1) {
                    JOptionPane.showMessageDialog(null, e1 + "");
                } finally {
                    try {
                        FileWriter file2 = new FileWriter("src\\com\\resources\\movie.txt");
                        PrintWriter pw2 = new PrintWriter(file2);

                        for (String str2 : tempArr) {
                            file2.write(str2);
                            pw2.println();
                        }

                        pw2.close();
                        file2.close();
                        if (flag == 0)
                        {
                            JOptionPane.showMessageDialog(null,"PAYMENT COMPLETED SUCCESSFULLY");
                        }
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, ex + "");
                    }

                }
            }
        }
        else
        if (ea.getSource() == btback) {
            btframe.dispose();
            new customerMenu(idbt);
        }
    }
}