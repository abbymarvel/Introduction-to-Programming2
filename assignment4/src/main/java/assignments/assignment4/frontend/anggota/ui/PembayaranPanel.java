package assignments.assignment4.frontend.anggota.ui;

import assignments.assignment4.backend.SistakaNG;
import assignments.assignment4.backend.pengguna.IdGenerator;
import assignments.assignment4.frontend.HomeGUI;
import assignments.assignment4.frontend.SistakaPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

// TODO: Implementasikan hal-hal yang diperlukan
public class PembayaranPanel extends SistakaPanel {
    public PembayaranPanel(HomeGUI main) {
        super(main);
        // TODO: Implementasikan hal-hal yang diperlukan
        JPanel panelPembayaran = new JPanel();
        panelPembayaran.setLayout(new GridLayout(4, 1));

        JPanel panelForButton = new JPanel();
        panelForButton.setLayout(new GridLayout(1, 2));

        JLabel labelPembayaranDenda = new JLabel("Bayar Denda");
        labelPembayaranDenda.setFont(new Font("Times New Roman", Font.PLAIN, 36));
        labelPembayaranDenda.setHorizontalAlignment(JLabel. CENTER);

        JLabel labelJumlahDenda = new JLabel("Jumlah Denda");
        labelJumlahDenda.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        labelJumlahDenda.setHorizontalAlignment(JLabel. CENTER);

        JTextField jtfJumlahDenda = new JTextField("");

        JButton buttonBayar = new JButton("Bayar");
        JButton buttonKembali = new JButton("Kembali");

        panelForButton.add(buttonBayar);
        panelForButton.add(buttonKembali);

        panelPembayaran.add(labelPembayaranDenda);
        panelPembayaran.add(labelJumlahDenda);
        panelPembayaran.add(jtfJumlahDenda);
        panelPembayaran.add(panelForButton);

        add(panelPembayaran);

        buttonBayar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent E){
                if(isNumeric(jtfJumlahDenda.getText())){
                    JOptionPane.showMessageDialog(main.getFrame(), SistakaNG.bayarDenda(Long.parseLong(jtfJumlahDenda.getText())) ,"Info", JOptionPane.INFORMATION_MESSAGE);
                    
                } else{
                    JOptionPane.showMessageDialog(main.getFrame(), "Jumlah bayar harus berupa angka!" ,"Warning", JOptionPane.WARNING_MESSAGE);
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
    }
}
