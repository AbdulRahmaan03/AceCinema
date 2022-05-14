package com.company;



import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class adminLogin implements ActionListener {
    JPanel adminpanel = new JPanel();
    JFrame adminframe = new JFrame("Admin Login");
    JLabel userlabel = new JLabel("Username");
    JLabel passwordlabel = new JLabel("Password");
    JTextField usertext = new JTextField(20);
    JPasswordField passwordtext = new JPasswordField(20);
    JButton login = new JButton();
    JButton back = new JButton();
    JLabel l4=new JLabel();
    ImageIcon bg4=new ImageIcon("src\\com\\resources\\bg.png");


    adminLogin() {
        adminframe.setSize(350, 200);
        adminframe.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        adminframe.add(adminpanel);
        adminpanel.setLayout(null);
        userlabel.setBounds(10, 20, 80, 25);
        adminpanel.add(userlabel);
        usertext.setBounds(100, 20, 165, 25);
        adminpanel.add(usertext);
        adminpanel.add(back);
        userlabel.setForeground(Color.white);
        passwordlabel.setForeground(Color.white);
        userlabel.setFont(new Font("SansSerif",Font.PLAIN,14));
        passwordlabel.setFont(new Font("SansSerif",Font.PLAIN,14));

        passwordlabel.setBounds(10, 50, 80, 25);
        adminpanel.add(passwordlabel);

        passwordtext.setBounds(100, 50, 165, 25);
        adminpanel.add(passwordtext);

        back.setIcon(new ImageIcon("src\\com\\resources\\Back.png"));
        back.setBounds(180, 100, 47, 32);
        back.addActionListener(this);
        adminpanel.add(back);
        login.setIcon(new ImageIcon("src\\com\\resources\\login.png"));
        login.setBounds(100, 100, 47, 32);
        login.addActionListener(this);
        adminpanel.add(login);
        adminpanel.add(l4);

        adminframe.setVisible(true);

        l4.setBounds(0,0,350,200);
        l4.setIcon(bg4);
        adminframe.setLocationRelativeTo(null);
        adminframe.setResizable(false);



    }

    @Override
    public void actionPerformed (ActionEvent e){

        String checkUser = usertext.getText();
        String checkPass = passwordtext.getText();
        if(e.getSource()== login) {
            if ((checkUser.equals("Jasim") && checkPass.equals("1234")))
            {
                JOptionPane.showMessageDialog(adminframe,"LOGIN SUCCESSFUL");
                new adminMenu();
                adminframe.dispose();
            }
        }
        else
        if(e.getSource()== back){
            adminframe.dispose();
            new menu();
        }




    }

}
