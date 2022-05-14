package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class language implements ActionListener{
    JFrame langframe = new JFrame("Language");
    JPanel langpanel = new JPanel();
    JLabel lang = new JLabel("Enter language");
    JButton langproceed = new JButton(new ImageIcon("src\\com\\resources\\PROCEED.png"));
    JLabel langBg = new JLabel();
    JTextField langtext = new JTextField();
    String test;
    JButton langback = new JButton(new ImageIcon("src\\com\\resources\\Back.png"));
    JLabel info = new JLabel("");
    String langID;
    language(String id){
        langID = id;
        langpanel.setBounds(0,0,800,450);
        langBg.setIcon(new ImageIcon("src\\com\\resources\\bg.png"));
        langBg.setBounds(0,0,800,450);
        lang.setBounds(10,50,350,25);
        langpanel.add(lang);
        lang.setForeground(Color.white);
        lang.setFont(new Font("SansSerif",Font.PLAIN,20));
        langtext.setBounds(400, 50, 75, 25);
        langpanel.add(langtext);


        langframe.add(langpanel);
        info.setBounds(10,380,500,25);
        langpanel.add(info);
        info.setForeground(Color.white);
        info.setFont(new Font("SansSerif",Font.PLAIN,20));


        langback.setBounds(725, 365, 47, 32);
        langback.addActionListener(this);
        langpanel.add(langback);
        langproceed.setBounds(350,325,100,40);
        langpanel.add(langproceed);
        langproceed.addActionListener(this);
        langpanel.add(langBg);

        langframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        langframe.setSize(800,450);
        langframe.setLayout(null);
        langpanel.setLayout(null);
        langframe.setVisible(true);
        langframe.setLocationRelativeTo(null);
        langframe.setResizable(false);
    }
    @Override
    public void actionPerformed(ActionEvent ea) {
        if(ea.getSource() == langback){
            langframe.dispose();
            new customerMenu(langID);
        }
        else if(ea.getSource()==langproceed){
            test = langtext.getText();
            if(test.equalsIgnoreCase("")){
                info.setText("Enter a language");
                return;
            }
            else {
                langframe.dispose();
                new orderByLanguage(test);
            }
        }
    }
}
