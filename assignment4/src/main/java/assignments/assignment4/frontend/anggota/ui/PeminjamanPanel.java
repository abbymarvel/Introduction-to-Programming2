package assignments.assignment4.frontend.anggota.ui;

import assignments.assignment4.backend.SistakaNG;
import assignments.assignment4.backend.buku.Buku;
import assignments.assignment4.frontend.HomeGUI;
import assignments.assignment4.frontend.SistakaPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class PeminjamanPanel extends SistakaPanel {
    JComboBox<String> JCBBuku = new JComboBox<>();
    public PeminjamanPanel(HomeGUI main) {
        super(main);
        // TODO: Implementasikan hal-hal yang diperlukan
        JPanel panelPeminjaman = new JPanel();
        panelPeminjaman.setLayout(new GridLayout(6, 1));

        JPanel panelForButton = new JPanel();
        panelForButton.setLayout(new GridLayout(1, 2));

        JLabel labelPinjamBuku = new JLabel("Pinjam Buku");
        labelPinjamBuku.setFont(new Font("Times New Roman", Font.PLAIN, 36));
        labelPinjamBuku.setHorizontalAlignment(JLabel. CENTER);

        JLabel labelBuku = new JLabel("Buku");
        labelBuku.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        labelBuku.setHorizontalAlignment(JLabel. CENTER);

        JLabel labelTanggalPeminjaman = new JLabel("Tanggal Peminjaman (DD/MM/YYYY)");
        labelTanggalPeminjaman.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        labelTanggalPeminjaman.setHorizontalAlignment(JLabel. CENTER);

        JTextField jtfTanggalPeminjaman = new JTextField("");

        JButton buttonPinjam = new JButton("Pinjam");
        JButton buttonKembali = new JButton("Kembali");

        panelForButton.add(buttonPinjam);
        panelForButton.add(buttonKembali);

        panelPeminjaman.add(labelPinjamBuku);
        panelPeminjaman.add(labelBuku);
        panelPeminjaman.add(JCBBuku);
        panelPeminjaman.add(labelTanggalPeminjaman);
        panelPeminjaman.add(jtfTanggalPeminjaman);
        panelPeminjaman.add(panelForButton);

        add(panelPeminjaman);

        buttonPinjam.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent E){
                if(SistakaPanel.isDateValid(jtfTanggalPeminjaman.getText())==false){
                    JOptionPane.showMessageDialog(main.getFrame(), "Tanggal yang dimasukan harus dalam format DD/MM/YYYY!" ,"Warning", JOptionPane.WARNING_MESSAGE);
                } else{
                    String[] buku = JCBBuku.getSelectedItem().toString().split(" oleh ");
                    JOptionPane.showMessageDialog(main.getFrame(), SistakaNG.pinjamBuku(SistakaNG.findBuku(buku[0], buku[1]), jtfTanggalPeminjaman.getText()),"Info", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }
        );

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
        JCBBuku.removeAllItems();
        for (int i=0; i<SistakaNG.getDaftarBuku().size(); i++){
            JCBBuku.addItem(SistakaNG.getDaftarBuku().get(i).toString());
        }
    }
}
