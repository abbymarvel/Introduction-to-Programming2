package assignments.assignment4.frontend.staf.ui;

import assignments.assignment4.backend.SistakaNG;
import assignments.assignment4.backend.pengguna.Anggota;
import assignments.assignment4.backend.pengguna.Dosen;
import assignments.assignment4.frontend.HomeGUI;
import assignments.assignment4.frontend.SistakaPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

// TODO: Implementasikan hal-hal yang diperlukan
public class TambahDosenPanel extends SistakaPanel {
    public TambahDosenPanel(HomeGUI main) {
        super(main);
        // TODO: Implementasikan hal-hal yang diperlukan
        JPanel paneltambahDosen = new JPanel();
        paneltambahDosen.setLayout(new GridLayout(4, 1));

        JPanel panelForButton = new JPanel();
        panelForButton.setLayout(new GridLayout(1, 2));

        JLabel labelTambahDosen = new JLabel("Tambah Dosen");
        labelTambahDosen.setFont(new Font("Times New Roman", Font.PLAIN, 36));
        labelTambahDosen.setHorizontalAlignment(JLabel. CENTER);

        
        JLabel labelNama = new JLabel("Nama");
        labelNama.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        labelNama.setHorizontalAlignment(JLabel. CENTER);

        JTextField jtfNama = new JTextField("");
        
        JButton buttonTambah = new JButton("Tambah");
        JButton buttonKembali = new JButton("Kembali");

        panelForButton.add(buttonTambah);
        panelForButton.add(buttonKembali);

        paneltambahDosen.add(labelTambahDosen);
        paneltambahDosen.add(labelNama);
        paneltambahDosen.add(jtfNama);
        paneltambahDosen.add(panelForButton);

        add(paneltambahDosen);

        buttonTambah.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent E){
                if (jtfNama.getText().equals("")){
                    JOptionPane.showMessageDialog(main.getFrame(), "Tidak dapat menambahkan dosen, silahkan periksa kembali input anda!","Warning", JOptionPane.WARNING_MESSAGE);
                } 
                else{
                    Dosen idDosen = SistakaNG.addDosen(jtfNama.getText());
                    JOptionPane.showMessageDialog(main.getFrame(), "Berhasil menambahkan dosen dengan id " + idDosen.getId() + "!","Success!", JOptionPane.INFORMATION_MESSAGE);
                    jtfNama.setText("");
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
    }
}
