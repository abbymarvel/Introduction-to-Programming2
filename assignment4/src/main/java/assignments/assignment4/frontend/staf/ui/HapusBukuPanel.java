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
public class HapusBukuPanel extends SistakaPanel {
    JComboBox<String> JCBBuku = new JComboBox<>();
    public HapusBukuPanel(HomeGUI main) {
        super(main);
        // Menginisiasi component-component yang dibutuhkan sesuai dengan dokumen soal
        JPanel panelhapusBuku = new JPanel();
        panelhapusBuku.setLayout(new GridLayout(4, 1));

        JPanel panelForButton = new JPanel();
        panelForButton.setLayout(new GridLayout(1, 2));

        JLabel labelHapusBuku = new JLabel("Hapus Buku");
        labelHapusBuku.setFont(new Font("Times New Roman", Font.PLAIN, 36));
        labelHapusBuku.setHorizontalAlignment(JLabel. CENTER);

        JLabel labelBuku = new JLabel("Buku");
        labelBuku.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        labelBuku.setHorizontalAlignment(JLabel. CENTER);

        JButton buttonHapus = new JButton("Hapus");
        JButton buttonKembali = new JButton("Kembali");

        // Menambahkan component-component yang sudah diinisiasi di atas ke panel
        panelForButton.add(buttonHapus);
        panelForButton.add(buttonKembali);

        panelhapusBuku.add(labelHapusBuku);
        panelhapusBuku.add(labelBuku);
        panelhapusBuku.add(JCBBuku);
        panelhapusBuku.add(panelForButton);

        // Menambahkan panel ke dalam frame
        add(panelhapusBuku);

        // Melakukan handle jika user berinteraksi dengan buttonHapus
        buttonHapus.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent E){
                if(JCBBuku.getSelectedItem()==null){
                    JOptionPane.showMessageDialog(main.getFrame(), "Silahkan memilih buku" ,"Warning", JOptionPane.WARNING_MESSAGE);
                } else{
                    String[] buku = JCBBuku.getSelectedItem().toString().split(" oleh ");
                    JOptionPane.showMessageDialog(main.getFrame(), SistakaNG.deleteBuku(SistakaNG.findBuku(buku[0], buku[1])),"Success!", JOptionPane.INFORMATION_MESSAGE);
                    refresh();
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
        JCBBuku.removeAllItems();
        for (int i=0; i<SistakaNG.getDaftarBuku().size(); i++){
            JCBBuku.addItem(SistakaNG.getDaftarBuku().get(i).toString());
        }
    }
}
