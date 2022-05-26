package assignments.assignment4.frontend.staf.ui;

import assignments.assignment4.backend.SistakaNG;
import assignments.assignment4.backend.pengguna.Mahasiswa;
import assignments.assignment4.frontend.HomeGUI;
import assignments.assignment4.frontend.SistakaPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

// TODO: Implementasikan hal-hal yang diperlukan
public class TambahMahasiswaPanel extends SistakaPanel {
    public TambahMahasiswaPanel(HomeGUI main) {
        super(main);
        // TODO: Implementasikan hal-hal yang diperlukan
        JPanel paneltambahMahasiswa = new JPanel();
        paneltambahMahasiswa.setLayout(new GridLayout(10, 1));

        JPanel panelForButton = new JPanel();
        panelForButton.setLayout(new GridLayout(1, 2));

        JLabel labelTambahMahasiswa = new JLabel("Tambah Mahasiswa");
        labelTambahMahasiswa.setFont(new Font("Times New Roman", Font.PLAIN, 36));
        labelTambahMahasiswa.setHorizontalAlignment(JLabel. CENTER);

        JLabel labelNama = new JLabel("Nama");
        labelNama.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        labelNama.setHorizontalAlignment(JLabel. CENTER);

        JTextField jtfNama = new JTextField("");

        JLabel labelTanggalLahir = new JLabel("Tanggal Lahir (DD/MM/YYY)");
        labelTanggalLahir.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        labelTanggalLahir.setHorizontalAlignment(JLabel. CENTER);

        JTextField jtfTanggalLahir = new JTextField("");

        JLabel labelProgramStudi = new JLabel("Program Studi");
        labelProgramStudi.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        labelProgramStudi.setHorizontalAlignment(JLabel. CENTER);
        
        String[] programStudi = {"SIK", "SSI", "MIK", "MTI", "DIK"};
        JComboBox<String> JCBProgramStudi = new JComboBox<>(programStudi);

        JLabel labelAngkatan = new JLabel("Angkatan");
        labelAngkatan.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        labelAngkatan.setHorizontalAlignment(JLabel. CENTER);

        JTextField jtfAngkatan = new JTextField("");

        JButton buttonTambah = new JButton("Tambah");
        JButton buttonKembali = new JButton("Kembali");

        panelForButton.add(buttonTambah);
        panelForButton.add(buttonKembali);

        paneltambahMahasiswa.add(labelTambahMahasiswa);
        paneltambahMahasiswa.add(labelNama);
        paneltambahMahasiswa.add(jtfNama);
        paneltambahMahasiswa.add(labelTanggalLahir);
        paneltambahMahasiswa.add(jtfTanggalLahir);
        paneltambahMahasiswa.add(labelProgramStudi);
        paneltambahMahasiswa.add(JCBProgramStudi);
        paneltambahMahasiswa.add(labelAngkatan);
        paneltambahMahasiswa.add(jtfAngkatan);
        paneltambahMahasiswa.add(panelForButton);

        add(paneltambahMahasiswa);

        buttonTambah.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent E){
                boolean tanggalLahirValid = SistakaPanel.isDateValid(jtfTanggalLahir.getText());
                if (jtfNama.getText().equals("") || tanggalLahirValid==false || jtfAngkatan.equals("")){
                    JOptionPane.showMessageDialog(main.getFrame(), "Tidak dapat menambahkan mahasiswa, silahkan periksa kembali input anda!","Warning", JOptionPane.WARNING_MESSAGE);
                } else{
                    Mahasiswa idMahasiswa = SistakaNG.addMahasiswa(jtfNama.getText(), jtfTanggalLahir.getText(), (String) JCBProgramStudi.getSelectedItem(), jtfAngkatan.getText());
                    if (idMahasiswa == null){
                        JOptionPane.showMessageDialog(main.getFrame(), "Tidak dapat menambahkan mahasiswa, silahkan periksa kembali input anda!","Warning", JOptionPane.WARNING_MESSAGE);
                    } else{
                        JOptionPane.showMessageDialog(main.getFrame(), "Berhasil menambahkan mahasiswa dengan id " + idMahasiswa.getId() + "!","Success!", JOptionPane.INFORMATION_MESSAGE);
                        jtfNama.setText("");
                        jtfTanggalLahir.setText("");
                        jtfAngkatan.setText("");
                    }
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
