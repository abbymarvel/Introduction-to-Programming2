package assignments.assignment4.frontend.anggota.ui;

import assignments.assignment4.frontend.HomeGUI;
import assignments.assignment4.frontend.SistakaPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

// TODO: Implementasikan hal-hal yang diperlukan
public class AnggotaHomePanel extends SistakaPanel {
    JLabel labelWelcome = new JLabel("");
    public AnggotaHomePanel(HomeGUI main) {
        super(main);
        // Menginisiasi component-component yang dibutuhkan sesuai dengan dokumen soal

        JPanel panelAnggotaHome = new JPanel();
        panelAnggotaHome.setLayout(new GridLayout(6, 1));

        labelWelcome.setFont(new Font("Times New Roman", Font.PLAIN, 36));

        JButton buttonPeminjaman = new JButton("Peminjaman");
        JButton buttonPengembalian = new JButton("Pengembalian");
        JButton buttonPembayaranDenda = new JButton("Pembayaran Denda");
        JButton buttonDetailAnggota = new JButton("Detail Anggota");
        JButton buttonLogout = new JButton("Logout");

        // Menambahkan component-component yang sudah diinisiasi di atas ke panel
        panelAnggotaHome.add(labelWelcome);
        panelAnggotaHome.add(buttonPeminjaman);
        panelAnggotaHome.add(buttonPengembalian);
        panelAnggotaHome.add(buttonPembayaranDenda);
        panelAnggotaHome.add(buttonDetailAnggota);
        panelAnggotaHome.add(buttonLogout);

        // Menambahkan panel ke dalam frame
        add(panelAnggotaHome);

        // Melakukan handle jika user berinteraksi dengan buttonPeminjaman
        buttonPeminjaman.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent E){
                main.setPanel("peminjaman");
            }
        }
        );

        // Melakukan handle jika user berinteraksi dengan buttonPengembalian
        buttonPengembalian.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent E){
                main.setPanel("pengembalian");
            }
        }
        );

        // Melakukan handle jika user berinteraksi dengan buttonPembayaranDenda
        buttonPembayaranDenda.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent E){
                main.setPanel("pembayaran");
            }
        }
        );

        // Melakukan handle jika user berinteraksi dengan buttonDetailAnggota
        buttonDetailAnggota.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent E){
                main.setPanel("detailUser");
            }
        }
        );

        // Melakukan handle jika user berinteraksi dengan buttonLogout
        buttonLogout.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent E){
                main.setPanel("login");
            }
        }
        );
    }

    @Override
    public void refresh() {
        // TODO: Implementasikan hal-hal yang diperlukan
        // Jika tidak diperlukan, Anda dapat mengabaikannya (kosongkan method ini)
        labelWelcome.setText("Selamat datang kembali " + main.getUser().getNama() + "!");

    }

}
