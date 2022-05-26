package assignments.assignment4.frontend.staf.ui;

import assignments.assignment4.backend.SistakaNG;
import assignments.assignment4.backend.buku.Buku;
import assignments.assignment4.backend.buku.Kategori;
import assignments.assignment4.frontend.HomeGUI;
import assignments.assignment4.frontend.SistakaPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// TODO: Implementasikan hal-hal yang diperlukan
public class TambahBukuPanel extends SistakaPanel {
    JComboBox<String> JCBKategori = new JComboBox<>();
    public TambahBukuPanel(HomeGUI main) {
        super(main);
        // Menginisiasi component-component yang dibutuhkan sesuai dengan dokumen soal
        JPanel paneltambahBuku = new JPanel();
        paneltambahBuku.setLayout(new GridLayout(12, 1));

        JPanel panelForButton = new JPanel();
        panelForButton.setLayout(new GridLayout(1, 2));

        JLabel labelTambahBuku = new JLabel("Tambah Buku");
        labelTambahBuku.setFont(new Font("Times New Roman", Font.PLAIN, 36));
        labelTambahBuku.setHorizontalAlignment(JLabel. CENTER);

        JLabel labelJudul = new JLabel("Judul");
        labelJudul.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        labelJudul.setHorizontalAlignment(JLabel. CENTER);

        JTextField jtfJudul = new JTextField("");

        JLabel labelPenulis = new JLabel("Penulis");
        labelPenulis.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        labelPenulis.setHorizontalAlignment(JLabel. CENTER);

        JTextField jtfPenulis = new JTextField("");

        JLabel labelPenerbit = new JLabel("Penerbit");
        labelPenerbit.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        labelPenerbit.setHorizontalAlignment(JLabel. CENTER);

        JTextField jtfPenerbit = new JTextField("");

        JLabel labelKategori = new JLabel("Kategori");
        labelKategori.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        labelKategori.setHorizontalAlignment(JLabel. CENTER);

        JLabel labelStok = new JLabel("Stok");
        labelStok.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        labelStok.setHorizontalAlignment(JLabel. CENTER);

        JTextField jtfStok = new JTextField("");
        
        JButton buttonTambah = new JButton("Tambah");
        JButton buttonKembali = new JButton("Kembali");

        // Menambahkan component-component yang sudah diinisiasi di atas ke panel
        panelForButton.add(buttonTambah);
        panelForButton.add(buttonKembali);

        paneltambahBuku.add(labelTambahBuku);
        paneltambahBuku.add(labelJudul);
        paneltambahBuku.add(jtfJudul);
        paneltambahBuku.add(labelPenulis);
        paneltambahBuku.add(jtfPenulis);
        paneltambahBuku.add(labelPenerbit);
        paneltambahBuku.add(jtfPenerbit);
        paneltambahBuku.add(labelKategori);
        paneltambahBuku.add(JCBKategori);
        paneltambahBuku.add(labelStok);
        paneltambahBuku.add(jtfStok);
        paneltambahBuku.add(panelForButton);

        // Menambahkan panel ke dalam frame
        add(paneltambahBuku);

        // Melakukan handle jika user berinteraksi dengan buttonTambah
        buttonTambah.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent E){
                if(Integer.parseInt(jtfStok.getText())<=0){
                    JOptionPane.showMessageDialog(main.getFrame(), "Stok harus lebih dari 0!" ,"Warning", JOptionPane.WARNING_MESSAGE);
                } else if (SistakaNG.findBuku(jtfJudul.getText(), jtfPenulis.getText())!=null){
                    JOptionPane.showMessageDialog(main.getFrame(), "Buku " + SistakaNG.findBuku(jtfJudul.getText(), jtfPenulis.getText()).getJudul() + " oleh " + SistakaNG.findBuku(jtfJudul.getText(), jtfPenulis.getText()).getPenulis() + " sudah pernah ditambahkan" ,"Warning", JOptionPane.WARNING_MESSAGE);
                } else{
                    SistakaNG.addBuku(jtfJudul.getText(), jtfPenulis.getText(), jtfPenerbit.getText(), JCBKategori.getSelectedItem().toString() ,Integer.parseInt(jtfStok.getText()));
                    JOptionPane.showMessageDialog(main.getFrame(), "Buku " + jtfJudul.getText() + " berhasil ditambahkan!","Success!", JOptionPane.INFORMATION_MESSAGE);
                    jtfJudul.setText("");
                    jtfPenulis.setText("");
                    jtfPenerbit.setText("");
                    jtfStok.setText("");
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
        JCBKategori.removeAllItems();
        for (int i=0; i<SistakaNG.getDaftarKategori().size(); i++){
            JCBKategori.addItem(SistakaNG.getDaftarKategori().get(i).getNama());
        }
    }
}
