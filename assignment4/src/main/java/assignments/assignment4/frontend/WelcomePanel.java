package assignments.assignment4.frontend;

import javax.swing.*;
import javax.swing.border.LineBorder;

import java.awt.*;
import java.awt.event.*;

public class WelcomePanel extends SistakaPanel {
    public WelcomePanel(HomeGUI homeGUI) {
        super(homeGUI);
        // TODO: Implementasikan hal-hal yang diperlukan
        JPanel welcomePanelLabel = new JPanel();
        welcomePanelLabel.setLayout(new GridLayout(1, 1));
        welcomePanelLabel.setBorder(new LineBorder(new Color(255,255,255, 0), 50));
        JPanel welcomePanelButton = new JPanel();
        welcomePanelButton.setLayout(new GridLayout(2, 1, 10, 10));
        welcomePanelButton.setBorder(new LineBorder(new Color(255,255,255, 0), 50));
        
        JLabel labelWelcome = new JLabel("Welcome to SistakaNG");
        labelWelcome.setFont(new Font("Times New Roman", Font.PLAIN, 36));
        JButton buttonLogin = new JButton("Login");
        JButton buttonExit = new JButton("Exit");

        labelWelcome.setHorizontalAlignment(JLabel.CENTER);
        setLayout(new BorderLayout(20, 15));
        welcomePanelLabel.add(labelWelcome, BorderLayout.NORTH);
        welcomePanelButton.add(buttonLogin);
        welcomePanelButton.add(buttonExit);
        add(welcomePanelLabel, BorderLayout.CENTER);
        add(welcomePanelButton, BorderLayout.SOUTH);

        buttonLogin.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent E){
                main.setPanel("login");
            }
        }
        );

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
