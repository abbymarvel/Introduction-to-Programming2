package assignments.assignment4.frontend;

import assignments.assignment4.backend.SistakaNG;
import assignments.assignment4.backend.pengguna.Anggota;
import assignments.assignment4.backend.pengguna.Pengguna;
import assignments.assignment4.backend.pengguna.Staf;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// TODO: Implementasikan hal-hal yang diperlukan
public class LoginPanel extends SistakaPanel {
    public LoginPanel(HomeGUI main){
        super(main);
        // TODO: Implementasikan hal-hal yang diperlukan 
        JPanel loginPanel = new JPanel();
        loginPanel.setLayout(new GridLayout(3, 1));

        JLabel labelWelcome = new JLabel("Masukan ID Anda untuk login ke sistem");
        labelWelcome.setFont(new Font("Times New Roman", Font.PLAIN, 36));

        JTextField jtfID = new JTextField("");

        JButton buttonLogin = new JButton("Login");

        loginPanel.add(labelWelcome);
        loginPanel.add(jtfID);
        loginPanel.add(buttonLogin);
        
        add(loginPanel);

        buttonLogin.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent E){
                if (jtfID.getText().equals("")){
                    JOptionPane.showMessageDialog(main.getFrame(), "Harap masukan id anda pada kotak diatas!","Warning", JOptionPane.WARNING_MESSAGE);
                } else{
                    if (SistakaNG.handleLogin(jtfID.getText()) instanceof Staf){
                        main.setUser(SistakaNG.handleLogin(jtfID.getText()));
                        main.setPanel("staf");
                    } else if (SistakaNG.handleLogin(jtfID.getText()) instanceof Anggota){
                        main.setUser(SistakaNG.handleLogin(jtfID.getText()));
                        main.setPanel("anggota");
                    } else {
                        JOptionPane.showMessageDialog(main.getFrame(), "Pengguna dengan ID " + jtfID.getText() + " tidak ditemukan","Warning", JOptionPane.WARNING_MESSAGE);
                    }
                }
            }
        }
        );
    }

    @Override
    public void refresh() {
        // ignored
    }
}
