package assignments.assignment4.frontend.staf.ui;

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
public class DaftarPeminjamPanel extends SistakaPanel {
    JComboBox<String> JCBBuku = new JComboBox<>();
    JLabel daftarPeminjam= new JLabel("");

    public DaftarPeminjamPanel(HomeGUI main) {
        super(main);
        // TODO: Implementasikan hal-hal yang diperlukan
        JPanel panelDaftarPeminjam = new JPanel();
        panelDaftarPeminjam.setLayout(new GridLayout(5, 1));

        JPanel panelForButton = new JPanel();
        panelForButton.setLayout(new GridLayout(1, 2));

        JLabel labelDaftarPeminjam = new JLabel("Lihat Daftar Peminjam");
        labelDaftarPeminjam.setFont(new Font("Times New Roman", Font.PLAIN, 36));
        labelDaftarPeminjam.setHorizontalAlignment(JLabel. CENTER);

        JLabel labelPilihBuku = new JLabel("Pilih Buku");
        labelPilihBuku.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        labelPilihBuku.setHorizontalAlignment(JLabel. CENTER);

        JButton buttonLihat = new JButton("Lihat");
        JButton buttonKembali = new JButton("Kembali");

        panelForButton.add(buttonLihat);
        panelForButton.add(buttonKembali);

        panelDaftarPeminjam.add(labelDaftarPeminjam);
        panelDaftarPeminjam.add(labelPilihBuku);
        panelDaftarPeminjam.add(JCBBuku);
        panelDaftarPeminjam.add(daftarPeminjam);
        panelDaftarPeminjam.add(panelForButton);
        
        add(panelDaftarPeminjam);

        buttonLihat.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent E){
                if(JCBBuku.getSelectedItem()==null){
                    JOptionPane.showMessageDialog(main.getFrame(), "Silahkan memilih buku!" ,"Warning", JOptionPane.WARNING_MESSAGE);
                } else{
                    String[] buku = JCBBuku.getSelectedItem().toString().split(" oleh ");
                    daftarPeminjam.setText(SistakaNG.daftarPeminjam(SistakaNG.findBuku(buku[0], buku[1])));
                }
            }
        }
        );

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
        JCBBuku.removeAllItems();
        for (int i=0; i<SistakaNG.getDaftarBuku().size(); i++){
            JCBBuku.addItem(SistakaNG.getDaftarBuku().get(i).toString());
        }
    }
}
