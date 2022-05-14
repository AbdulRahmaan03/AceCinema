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

public class Movie {
    private class Node{
        String data;
    }
    Node top;
    public void addMovie()
    {

        JFrame addframe = new JFrame("Add Movie");
        JPanel addpanel = new JPanel();
        JLabel addbg=new JLabel(new ImageIcon("src\\com\\resources\\bg.png"));
        JLabel addname = new JLabel("Movie name");
        JLabel addlanguage = new JLabel("Movie Language");
        JLabel adddate = new JLabel("Date");
        JLabel addID = new JLabel("Movie ID");
        JLabel addprice = new JLabel("Price");
        JLabel info = new JLabel("");
        JTextField aname = new JTextField(20);
        JTextField aID = new JTextField(20);
        JTextField alanguage = new JTextField(20);
        JTextField adate = new JTextField(20);
        JTextField aprice = new JTextField(20);
        JButton aproceed = new JButton(new ImageIcon("src\\com\\resources\\PROCEED.png"));
        JButton aback = new JButton(new ImageIcon("src\\com\\resources\\Back.png"));

        addbg.setBounds(0,0,800,450);
        addpanel.setBounds(0,0,800,450);
        aback.setBounds(725,365,47,32);
        addpanel.add(aback);

        addframe.setSize(800,450);
        addframe.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        addframe.add(addpanel);
        addpanel.setLayout(null);
        addID.setBounds(10, 30, 150, 25);
        addpanel.add(addID);
        addID.setForeground(Color.white);
        addID.setFont(new Font("SansSerif",Font.PLAIN,20));
        addname.setBounds(10, 90, 150, 25);
        addpanel.add(addname);
        addname.setForeground(Color.white);
        addname.setFont(new Font("SansSerif",Font.PLAIN,20));
        addlanguage.setBounds(10, 150, 150, 25);
        addpanel.add(addlanguage);
        addlanguage.setForeground(Color.white);
        addlanguage.setFont(new Font("SansSerif",Font.PLAIN,20));
        adddate.setBounds(10, 210, 150, 25);
        addpanel.add(adddate);
        adddate.setForeground(Color.white);
        adddate.setFont(new Font("SansSerif",Font.PLAIN,20));
        addprice.setBounds(10, 270, 150, 25);
        addpanel.add(addprice);
        addprice.setForeground(Color.white);
        addprice.setFont(new Font("SansSerif",Font.PLAIN,20));

        aID.setBounds(200, 30, 250, 25);
        addpanel.add(aID);
        aname.setBounds(200, 90, 250, 25);
        addpanel.add(aname);
        alanguage.setBounds(200, 150, 250, 25);
        addpanel.add(alanguage);
        adate.setBounds(200, 210, 250, 25);
        addpanel.add(adate);
        aprice.setBounds(200, 270, 250, 25);
        addpanel.add(aprice);

        aproceed.setBounds(350,325,100,40);
        addpanel.add(aproceed);
        info.setBounds(10,380,500,25);
        addpanel.add(info);

        aproceed.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String moviename = aname.getText();
                String movieID = aID.getText();
                String movielanguage = alanguage.getText();
                String moviedate = adate.getText();
                String movieprice = aprice.getText();
                ArrayList<String> temparr = new ArrayList<String>();
                String line;
                String seatsavailable="300";
                int flag = 0;
                String[] arr;

                if (moviename.trim().isEmpty() || movieID.trim().isEmpty() || movielanguage.trim().isEmpty() || moviedate.trim().isEmpty() || movieprice.trim().isEmpty())
                {
                    info.setText("MORE INFORMATION TO BE ENTERED");
                }
                else {
                    info.setText("");

                    try{
                        FileReader fr=new FileReader("src\\com\\resources\\movie.txt");
                        Scanner reader=new Scanner(fr);
                        Node temp = new Node();
                        while(reader.hasNextLine()){
                            line=reader.nextLine();
                            arr = line.split(",");
                            if (arr[0].equals(movieID))
                            {
                                info.setText("RECORD ALREADY EXISTS");
                                flag = 1;
                            }
                            else
                            {
                                //if (temp == null){
                                //   info.setText("Heap Overflow");
                                //    return;
                                //}
                                temp.data = line;
                                top = temp;
                                temparr.add(top.data);
                            }
                        }
                        fr.close();
                    }catch(Exception e1){JOptionPane.showMessageDialog(null, e1+"");}
                    finally {
                        try {
                            if (flag == 0)
                            {
                            FileWriter file1 = new FileWriter("src\\com\\resources\\movie.txt");
                            PrintWriter pw = new PrintWriter(file1);

                            for(String str: temparr){
                                file1.write(str);
                                pw.println();

                            }
                            file1.write(movieID + "," + moviename + "," + movielanguage + "," + moviedate + "," + movieprice+ "," +seatsavailable);

                            file1.close();
                            pw.close();
                                JOptionPane.showMessageDialog(null,"FILE SAVED SUCCESSFULLY");
                            }


                        }catch (Exception ex) {JOptionPane.showMessageDialog(null, ex+"");
                        }

                    }



                }
            }
        });

        aback.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addframe.dispose();
                new adminMenu();

            }
        });

        addframe.setVisible(true);
        addpanel.add(addbg);
        addframe.setLocationRelativeTo(null);
        addframe.setResizable(false);
        info.setForeground(Color.white);
        info.setFont(new Font("SansSerif",Font.PLAIN,20));




    }
    public  void modifyMovie(){
        JFrame modifyframe = new JFrame("Modify movie");
        JPanel modifypanel = new JPanel();
        JLabel modifybg = new JLabel(new ImageIcon("src\\com\\resources\\bg.png"));
        JLabel modifyname = new JLabel("Movie name");
        JLabel modifylanguage = new JLabel("Movie Language");
        JLabel modifydate = new JLabel("Date");
        JLabel modifyid = new JLabel("Movie ID");
        JLabel modifyprice = new JLabel("Price");
        JLabel info = new JLabel("");
        JTextField mname = new JTextField(20);
        JTextField mid = new JTextField(20);
        JTextField mlanguage = new JTextField(20);
        JTextField mdate = new JTextField(20);
        JTextField mprice = new JTextField(20);
        JButton mproceed = new JButton(new ImageIcon("src\\com\\resources\\PROCEED.png"));
        JButton mback = new JButton(new ImageIcon("src\\com\\resources\\Back.png"));

        modifybg.setBounds(0,0,800,450);
        modifypanel.setBounds(0,0,800,450);
        mback.setBounds(725,365,47,32);
        modifypanel.add(mback);


        modifyframe.setSize(800,450);
        modifyframe.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        modifyframe.add(modifypanel);
        modifypanel.setLayout(null);


        modifyid.setBounds(10, 30, 150, 25);
        modifypanel.add(modifyid);
        modifyid.setForeground(Color.white);
        modifyid.setFont(new Font("SansSerif",Font.PLAIN,20));
        modifyname.setBounds(10, 90, 150, 25);
        modifypanel.add(modifyname);
        modifyname.setForeground(Color.white);
        modifyname.setFont(new Font("SansSerif",Font.PLAIN,20));
        modifylanguage.setBounds(10, 150, 150, 25);
        modifypanel.add(modifylanguage);
        modifylanguage.setForeground(Color.white);
        modifylanguage.setFont(new Font("SansSerif",Font.PLAIN,20));
        modifydate.setBounds(10, 210, 150, 25);
        modifypanel.add(modifydate);
        modifydate.setForeground(Color.white);
        modifydate.setFont(new Font("SansSerif",Font.PLAIN,20));
        modifyprice.setBounds(10, 270, 150, 25);
        modifypanel.add(modifyprice);
        modifyprice.setForeground(Color.white);
        modifyprice.setFont(new Font("SansSerif",Font.PLAIN,20));

        mid.setBounds(200, 30, 250, 25);
        modifypanel.add(mid);
        mname.setBounds(200, 90, 250, 25);
        modifypanel.add(mname);
        mlanguage.setBounds(200, 150, 250, 25);
        modifypanel.add(mlanguage);
        mdate.setBounds(200, 210, 250, 25);
        modifypanel.add(mdate);
        mprice.setBounds(200, 270, 250, 25);
        modifypanel.add(mprice);

        mproceed.setBounds(350,325,100,40);
        modifypanel.add(mproceed);
        info.setBounds(10,380,500,25);
        modifypanel.add(info);

        JFrame modifyframe2 = new JFrame("Modify Movie");
        JPanel modifypanel2 = new JPanel();
        JLabel modifyid2 = new JLabel("Enter ID");
        JButton mproceed2 = new JButton(new ImageIcon("src\\com\\resources\\PROCEED.png"));
        JLabel modifybg2 = new JLabel(new ImageIcon("src\\com\\resources\\bg.png"));
        JButton mback2 = new JButton(new ImageIcon("src\\com\\resources\\Back.png"));

        modifyframe2.setSize(800,450);
        modifyframe2.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        modifyframe2.setLocationRelativeTo(null);
        modifyframe2.add(modifypanel2);
        modifypanel2.setLayout(null);
        JTextField idtextModify = new JTextField();
        mback2.setBounds(725,365,47,32);
        modifypanel2.add(mback2);



        modifyid2.setBounds(10, 50, 80, 25);
        modifypanel2.add(modifyid2);
        modifyid2.setForeground(Color.white);
        modifyid2.setFont(new Font("SansSerif",Font.PLAIN,20));
        idtextModify.setBounds(150, 50, 250, 25);
        modifypanel2.add(idtextModify);

        mproceed2.setBounds(350,325,100,40);
        modifypanel2.add(mproceed2);
        modifypanel2.setBounds(0,0,800,450);
        modifybg2.setBounds(0,0,800,450);
        modifypanel2.add(modifybg2);
        modifyframe2.setVisible(true);

        mproceed2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String checkId = idtextModify.getText();
                String line;
                int flag = 0;
                String[] arr;

                try{
                    FileReader fr=new FileReader("src\\com\\resources\\movie.txt");
                    Scanner reader=new Scanner(fr);
                    while(reader.hasNextLine()){
                        line=reader.nextLine();
                        arr = line.split(",");
                        if (arr[0].equals(checkId))
                        {
                            modifyframe2.dispose();
                            modifyframe.setVisible(true);
                            mid.setText(checkId);
                            mid.setEditable(false);
                            flag=1;


                        }
                    }
                    fr.close();
                }catch(Exception e1){JOptionPane.showMessageDialog(null, e1+"");}
                finally {
                    if(flag==0){
                        JOptionPane.showMessageDialog(null,"RECORD NOT FOUND");
                    }
                }
            }
        });


        mproceed.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String checkId2  = mid.getText();
                String checkname = mname.getText();
                String checkLang = mlanguage.getText();
                String checkDate = mdate.getText();
                String checkPrice = mprice.getText();
                ArrayList<String> tempArray=new ArrayList<String>();
                String line;
                int flag = 0;
                String[] arr;

                if (checkname.trim().isEmpty() || checkLang.trim().isEmpty() || checkDate.trim().isEmpty() || checkPrice.trim().isEmpty())
                {
                    info.setText("MORE INFORMATION TO BE ENTERED");
                }
                else {
                    info.setText("");

                    try{
                        FileReader fr=new FileReader("src\\com\\resources\\movie.txt");
                        Scanner reader=new Scanner(fr);

                        while(reader.hasNextLine()){
                            line=reader.nextLine();
                            arr = line.split(",");
                            if (arr[0].equals(checkId2))
                            {
                                tempArray.add(arr[0] + "," + checkname + "," + checkLang + "," + checkDate + "," + checkPrice+ "," +arr[5]);
                                JOptionPane.showMessageDialog(null,"RECORD MODIFIED");
                            }
                            else{
                                tempArray.add(line);
                            }

                        }
                        fr.close();
                    }catch(Exception e1){JOptionPane.showMessageDialog(null, e1+"");}
                    finally {
                        try {
                            FileWriter file1 = new FileWriter("src\\com\\resources\\movie.txt");
                            PrintWriter pw = new PrintWriter(file1);

                            for(String str: tempArray){
                                file1.write(str);
                                pw.println();

                            }
                            pw.close();
                            file1.close();
                            if (flag == 0)
                            {
                                JOptionPane.showMessageDialog(null,"FILE SAVED SUCCESSFULLY");
                            }


                        }catch (Exception ex) {JOptionPane.showMessageDialog(null, ex+"");
                        }

                    }



                }
            }
        });

        mback.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modifyframe.dispose();
                new adminMenu();

            }
        });

        mback2 .addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modifyframe2.dispose();
                new adminMenu();

            }
        });

        modifypanel.add(modifybg);
        modifyframe.setLocationRelativeTo(null);
        modifyframe.setResizable(false);
        info.setForeground(Color.white);
        info.setFont(new Font("SansSerif",Font.PLAIN,20));




    }

    public void displayMovie(){
        JFrame displayFrame = new JFrame("Movie Details");
        JPanel displayPanel = new JPanel();
        JLabel displayBg = new JLabel();
        JButton displayback = new JButton(new ImageIcon("src\\com\\resources\\Back.png"));


        displayPanel.setBounds(0,0,800,450);
        displayBg.setIcon(new ImageIcon("src\\com\\resources\\bg.png"));
        displayBg.setBounds(0,0,800,450);

        displayFrame.add(displayPanel);


        displayback.setBounds(725, 365, 47, 32);
        displayPanel.add(displayback);

        displayFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        displayFrame.setSize(800,450);
        displayFrame.setLayout(null);
        displayPanel.setLayout(null);
        displayFrame.setVisible(true);
        displayFrame.setLocationRelativeTo(null);
        displayFrame.setResizable(false);

        DefaultTableModel m = new DefaultTableModel();
        JTable t =new JTable(m);
        m.addColumn("ID");
        m.addColumn("Name");
        m.addColumn("Language");
        m.addColumn("Date");
        m.addColumn("Price");
        m.addColumn("SeatsAvailable");
        JTableHeader tableheader = t.getTableHeader();
        t.setRowHeight(35);
        t.setBackground(new Color(0,0,0,0));
        t.setForeground(Color.white);
        tableheader.setForeground(Color.white);
        tableheader.setFont(new Font("Serif", Font.BOLD, 20));
        tableheader.setBackground(Color.black);
        t.setSelectionBackground(Color.gray);
        t.setShowGrid(false);
        t.setFont(new Font("Serif", Font.PLAIN, 15));
        JScrollPane sp=new JScrollPane(t);
        sp.getViewport().setBackground(Color.darkGray);

        sp.setBounds(35,20,700,300);
        displayPanel.add(sp);
        t.setOpaque(false);

        displayPanel.add(displayBg);

        String line;
        String[] arr;

        try{
            FileReader fr=new FileReader("src\\com\\resources\\movie.txt");
            Scanner reader=new Scanner(fr);
            while(reader.hasNextLine()){
                line=reader.nextLine();
                arr = line.split(",");
                m.addRow(arr);
            }
            fr.close();
        }catch(Exception e1){JOptionPane.showMessageDialog(null, e1+"");}

        displayback.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayFrame.dispose();
                new adminMenu();
            }
        });
    }
}