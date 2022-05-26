package assignments.assignment4.frontend;

import assignments.assignment4.backend.SistakaNG;
import assignments.assignment4.backend.pengguna.Anggota;
import assignments.assignment4.backend.pengguna.Pengguna;
import assignments.assignment4.backend.pengguna.Staf;

import javax.swing.*;
import javax.swing.plaf.DimensionUIResource;

import java.awt.*;
import java.awt.event.*;

// TODO: Implementasikan hal-hal yang diperlukan
public class LoginPanel extends SistakaPanel {
    public LoginPanel(HomeGUI main){
        super(main);
        // Menginisiasi component-component yang dibutuhkan sesuai dengan dokumen soal        
        JPanel loginPanel = new JPanel();
        loginPanel.setLayout(new GridLayout(3,1,5,5));

        JLabel labelWelcome = new JLabel("Masukan ID Anda untuk login ke sistem");
        labelWelcome.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        labelWelcome.setHorizontalAlignment(JLabel. CENTER);
        

        JTextField jtfID = new JTextField("");
        jtfID.setPreferredSize(new Dimension(400, 30));

        JButton buttonLogin = new JButton("Login");
        buttonLogin.setPreferredSize(new Dimension(100, 30));

        // Menambahkan component-component yang sudah diinisiasi di atas ke panel
        loginPanel.add(labelWelcome);
        loginPanel.add(jtfID);;
        loginPanel.add(buttonLogin);
        
        // Menambahkan panel ke dalam frame
        add(loginPanel, BorderLayout.CENTER);

        // Melakukan handle jika user berinteraksi dengan buttonLogin
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
