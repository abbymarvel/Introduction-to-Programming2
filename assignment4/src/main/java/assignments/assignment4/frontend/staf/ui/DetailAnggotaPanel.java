package assignments.assignment4.frontend.staf.ui;

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
public class DetailAnggotaPanel extends SistakaPanel {
    JComboBox<String> JCBAnggota = new JComboBox<>();
    JLabel detailAnggota= new JLabel("");
    public DetailAnggotaPanel(HomeGUI main) {
        super(main);
        // TODO: Implementasikan hal-hal yang diperlukan
        JPanel panelDetailAnggota = new JPanel();
        panelDetailAnggota.setLayout(new GridLayout(5, 1));

        JPanel panelForButton = new JPanel();
        panelForButton.setLayout(new GridLayout(1, 2));

        JLabel labelDetailAnggota = new JLabel("Lihat Detail Anggota");
        labelDetailAnggota.setFont(new Font("Times New Roman", Font.PLAIN, 36));
        labelDetailAnggota.setHorizontalAlignment(JLabel. CENTER);

        JLabel labelPilihId = new JLabel("Pilih ID Anggota");
        labelPilihId.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        labelPilihId.setHorizontalAlignment(JLabel. CENTER);

        JButton buttonLihat = new JButton("Lihat");
        JButton buttonKembali = new JButton("Kembali");

        panelForButton.add(buttonLihat);
        panelForButton.add(buttonKembali);

        panelDetailAnggota.add(labelDetailAnggota);
        panelDetailAnggota.add(labelPilihId);
        panelDetailAnggota.add(JCBAnggota);
        panelDetailAnggota.add(detailAnggota);
        panelDetailAnggota.add(panelForButton);
        
        add(panelDetailAnggota);

        buttonLihat.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent E){
                if(JCBAnggota.getSelectedItem()==null){
                    JOptionPane.showMessageDialog(main.getFrame(), "Silahkan memilih ID Anggota!" ,"Warning", JOptionPane.WARNING_MESSAGE);
                } else{
                    detailAnggota.setText(SistakaNG.findAnggota(JCBAnggota.getSelectedItem().toString()).detail());
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
        JCBAnggota.removeAllItems();
        for (int i=0; i<SistakaNG.getDaftarAnggota().size(); i++){
            JCBAnggota.addItem(SistakaNG.getDaftarAnggota().get(i).getId());
        }
    }
}
