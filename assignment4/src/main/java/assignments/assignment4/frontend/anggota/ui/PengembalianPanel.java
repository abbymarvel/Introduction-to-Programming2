package assignments.assignment4.frontend.anggota.ui;

import assignments.assignment4.backend.SistakaNG;
import assignments.assignment4.backend.buku.Buku;
import assignments.assignment4.frontend.HomeGUI;
import assignments.assignment4.frontend.SistakaPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

// TODO: Implementasikan hal-hal yang diperlukan
public class PengembalianPanel extends SistakaPanel {
    JComboBox<String> JCBBuku = new JComboBox<>();
    public PengembalianPanel(HomeGUI main) {
        super(main);
        // Menginisiasi component-component yang dibutuhkan sesuai dengan dokumen soal
        JPanel panelPengembalian = new JPanel();
        panelPengembalian.setLayout(new GridLayout(6, 1));

        JPanel panelForButton = new JPanel();
        panelForButton.setLayout(new GridLayout(1, 2));

        JLabel labelPengembalianBuku = new JLabel("Pengembalian Buku");
        labelPengembalianBuku.setFont(new Font("Times New Roman", Font.PLAIN, 36));
        labelPengembalianBuku.setHorizontalAlignment(JLabel. CENTER);

        JLabel labelBuku = new JLabel("Buku");
        labelBuku.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        labelBuku.setHorizontalAlignment(JLabel. CENTER);

        JLabel labelTanggalPengembalian = new JLabel("Tanggal Pengembalian (DD/MM/YYYY)");
        labelTanggalPengembalian.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        labelTanggalPengembalian.setHorizontalAlignment(JLabel. CENTER);

        JTextField jtfTanggalPengembalian = new JTextField("");

        JButton buttonKembalikan = new JButton("Kembalikan");
        JButton buttonKembali = new JButton("Kembali");

        // Menambahkan component-component yang sudah diinisiasi di atas ke panel
        panelForButton.add(buttonKembalikan);
        panelForButton.add(buttonKembali);

        panelPengembalian.add(labelPengembalianBuku);
        panelPengembalian.add(labelBuku);
        panelPengembalian.add(JCBBuku);
        panelPengembalian.add(labelTanggalPengembalian);
        panelPengembalian.add(jtfTanggalPengembalian);
        panelPengembalian.add(panelForButton);

        // Menambahkan panel ke dalam frame
        add(panelPengembalian);

        // Melakukan handle jika user berinteraksi dengan buttonKembalikan
        buttonKembalikan.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent E){
                if(SistakaPanel.isDateValid(jtfTanggalPengembalian.getText())==false){
                    JOptionPane.showMessageDialog(main.getFrame(), "Tanggal yang dimasukan harus dalam format DD/MM/YYYY!" ,"Warning", JOptionPane.WARNING_MESSAGE);
                } else{
                    String[] buku = JCBBuku.getSelectedItem().toString().split(" oleh ");
                    JOptionPane.showMessageDialog(main.getFrame(), SistakaNG.kembalikanBuku(SistakaNG.findBuku(buku[0], buku[1]), jtfTanggalPengembalian.getText()),"Info", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }
        );

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
        JCBBuku.removeAllItems();
        for (int i=0; i<SistakaNG.getDaftarBuku().size(); i++){
            JCBBuku.addItem(SistakaNG.getDaftarBuku().get(i).toString());
        }
    }
}
