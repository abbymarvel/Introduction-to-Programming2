package assignments.assignment4.frontend;

import javax.swing.*;
import javax.swing.border.LineBorder;

import java.awt.*;
import java.awt.event.*;

public class WelcomePanel extends SistakaPanel {
    public WelcomePanel(HomeGUI homeGUI) {
        super(homeGUI);
        // Menginisiasi component-component yang dibutuhkan sesuai dengan dokumen soal
        setLayout(new BorderLayout(20, 15));

        JPanel welcomePanelLabel = new JPanel();                                                            //Membuat panel untuk memuat seluruh component
        welcomePanelLabel.setLayout(new GridLayout(1, 1));
        welcomePanelLabel.setBorder(new LineBorder(new Color(255,255,255, 0), 50));
        
        JPanel welcomePanelButton = new JPanel();                                                           // Membuat panel untuk memuat button yang nantinya akan dibutuhkan
        welcomePanelButton.setLayout(new GridLayout(2, 1, 10, 10));
        welcomePanelButton.setBorder(new LineBorder(new Color(255,255,255, 0), 50));
        
        JLabel labelWelcome = new JLabel("Welcome to SistakaNG");
        labelWelcome.setFont(new Font("Times New Roman", Font.PLAIN, 36));
        labelWelcome.setHorizontalAlignment(JLabel.CENTER);

        JButton buttonLogin = new JButton("Login");
        JButton buttonExit = new JButton("Exit");


        // Menambahkan component-component yang sudah diinisiasi di atas ke panel
        welcomePanelLabel.add(labelWelcome, BorderLayout.NORTH);
        welcomePanelButton.add(buttonLogin);
        welcomePanelButton.add(buttonExit);

        // Menambahkan panel ke dalam frame
        add(welcomePanelLabel, BorderLayout.CENTER);
        add(welcomePanelButton, BorderLayout.SOUTH);

        // Melakukan handle jika user berinteraksi dengan buttonLogin
        buttonLogin.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent E){
                main.setPanel("login");
            }
        }
        );

        // Melakukan handle jika user berinteraksi dengan buttonExit
        buttonExit.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent E){
                System.exit(0);
            }
        }
        );

    }

    @Override
    public void refresh() {
        // ignored
    }
}
