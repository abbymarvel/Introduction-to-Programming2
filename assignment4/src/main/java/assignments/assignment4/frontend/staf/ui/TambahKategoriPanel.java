package assignments.assignment4.frontend.staf.ui;

import assignments.assignment4.backend.SistakaNG;
import assignments.assignment4.backend.buku.Kategori;
import assignments.assignment4.frontend.HomeGUI;
import assignments.assignment4.frontend.SistakaPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

// TODO: Implementasikan hal-hal yang diperlukan
public class TambahKategoriPanel extends SistakaPanel {
    public TambahKategoriPanel(HomeGUI main) {
        super(main);
        // Menginisiasi component-component yang dibutuhkan sesuai dengan dokumen soal
        JPanel paneltambahKategori = new JPanel();
        paneltambahKategori.setLayout(new GridLayout(6, 1));

        JPanel panelForButton = new JPanel();
        panelForButton.setLayout(new GridLayout(1, 2));

        JLabel labelTambahKategori = new JLabel("Tambah Kategori");
        labelTambahKategori.setFont(new Font("Times New Roman", Font.PLAIN, 36));
        labelTambahKategori.setHorizontalAlignment(JLabel. CENTER);

        JLabel labelNama = new JLabel("Nama");
        labelNama.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        labelNama.setHorizontalAlignment(JLabel. CENTER);

        JTextField jtfNama = new JTextField("");

        JLabel labelPoin = new JLabel("Poin");
        labelPoin.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        labelPoin.setHorizontalAlignment(JLabel. CENTER);

        JTextField jtfPoin = new JTextField("");

        JButton buttonTambah = new JButton("Tambah");
        JButton buttonKembali = new JButton("Kembali");

        // Menambahkan component-component yang sudah diinisiasi di atas ke panel
        panelForButton.add(buttonTambah);
        panelForButton.add(buttonKembali);

        paneltambahKategori.add(labelTambahKategori);
        paneltambahKategori.add(labelNama);
        paneltambahKategori.add(jtfNama);
        paneltambahKategori.add(labelPoin);
        paneltambahKategori.add(jtfPoin);
        paneltambahKategori.add(panelForButton);

        // Menambahkan panel ke dalam frame
        add(paneltambahKategori);

        // Melakukan handle jika user berinteraksi dengan buttonTambah
        buttonTambah.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent E){
                if (SistakaNG.findKategori(jtfNama.getText())!=null){
                    JOptionPane.showMessageDialog(main.getFrame(), "Kategori " + SistakaNG.findKategori(jtfNama.getText()).getNama() + " sudah pernah ditambahkan!" ,"Warning", JOptionPane.WARNING_MESSAGE);
                } 
                else{
                    SistakaNG.addKategori(jtfNama.getText(), Integer.parseInt(jtfPoin.getText()));
                    JOptionPane.showMessageDialog(main.getFrame(), "Kategori " + jtfNama.getText() + " dengan poin " + jtfPoin.getText() + " berhasil ditambahkan","Success!", JOptionPane.INFORMATION_MESSAGE);
                    jtfNama.setText("");
                    jtfPoin.setText("");                    
                }
            }
        }
        );

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
    }
}
