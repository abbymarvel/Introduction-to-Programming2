package assignments.assignment4.frontend.anggota.ui;

import assignments.assignment4.backend.SistakaNG;
import assignments.assignment4.backend.pengguna.Anggota;
import assignments.assignment4.frontend.HomeGUI;
import assignments.assignment4.frontend.SistakaPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

// TODO: Implementasikan hal-hal yang diperlukan
public class DetailUserPanel extends SistakaPanel {
    JLabel detailUser= new JLabel("");
    public DetailUserPanel(HomeGUI main) {
        super(main);
        // Menginisiasi component-component yang dibutuhkan sesuai dengan dokumen soal
        JPanel panelDetailUser = new JPanel();
        panelDetailUser.setLayout(new GridLayout(3, 1));

        JLabel labelDetailAnggota = new JLabel("Lihat Detail Anggota");
        labelDetailAnggota.setFont(new Font("Times New Roman", Font.PLAIN, 36));
        labelDetailAnggota.setHorizontalAlignment(JLabel. CENTER);

        JButton buttonKembali = new JButton("Kembali");

        // Menambahkan component-component yang sudah diinisiasi di atas ke panel
        panelDetailUser.add(labelDetailAnggota);
        panelDetailUser.add(detailUser);
        panelDetailUser.add(buttonKembali);

        // Menambahkan panel ke dalam frame
        add(panelDetailUser);

        // Melakukan handle jika user berinteraksi dengan buttonKembali
        buttonKembali.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent E){
                main.setPanel("anggota");
            }
        }
        );
    }

    @Override
    public void refresh() {
        // TODO: Implementasikan hal-hal yang diperlukan
        // Jika tidak diperlukan, Anda dapat mengabaikannya (kosongkan method ini)
        Anggota anggota = SistakaNG.findAnggota(main.getUser().getId());
        detailUser.setText(anggota.detail());
    }
}
