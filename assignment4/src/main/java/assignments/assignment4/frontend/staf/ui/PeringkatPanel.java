package assignments.assignment4.frontend.staf.ui;

import assignments.assignment4.backend.SistakaNG;
import assignments.assignment4.frontend.HomeGUI;
import assignments.assignment4.frontend.SistakaPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

// TODO: Implementasikan hal-hal yang diperlukan
public class PeringkatPanel extends SistakaPanel {
    JLabel PeringkatUtama= new JLabel("");
    public PeringkatPanel(HomeGUI main) {
        super(main);
        // Menginisiasi component-component yang dibutuhkan sesuai dengan dokumen soal
        JPanel panelPeringkat = new JPanel();
        panelPeringkat.setLayout(new GridLayout(3, 1));

        JPanel panelForButton = new JPanel();
        panelForButton.setLayout(new GridLayout(1, 1));

        JLabel labelPeringkat = new JLabel("Peringkat");
        labelPeringkat.setFont(new Font("Times New Roman", Font.PLAIN, 36));
        labelPeringkat.setHorizontalAlignment(JLabel. CENTER);

        JButton buttonKembali = new JButton("Kembali");

        // Menambahkan component-component yang sudah diinisiasi di atas ke panel
        panelForButton.add(buttonKembali);

        panelPeringkat.add(labelPeringkat);
        panelPeringkat.add(PeringkatUtama);
        panelPeringkat.add(panelForButton);

        // Menambahkan panel ke dalam frame
        add(panelPeringkat);

        // Melakukan handle jika user berinteraksi dengan buttonKembali
        buttonKembali.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent E){
                main.setPanel("staf");
            }
        }
        );
    }

    @Override
    public void refresh() {
        // TODO: Implementasikan hal-hal yang diperlukan
        // Jika tidak diperlukan, Anda dapat mengabaikannya (kosongkan method ini)
        PeringkatUtama.setText(SistakaNG.handleRankingAnggota());
    }
}
