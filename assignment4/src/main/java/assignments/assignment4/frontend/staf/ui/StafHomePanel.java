package assignments.assignment4.frontend.staf.ui;

import assignments.assignment4.backend.SistakaNG;
import assignments.assignment4.frontend.HomeGUI;
import assignments.assignment4.frontend.SistakaPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// TODO: Implementasikan hal-hal yang diperlukan
public class StafHomePanel extends SistakaPanel {
    JLabel labelWelcome = new JLabel("");
    public StafHomePanel(HomeGUI main) {
        super(main);
        // Menginisiasi component-component yang dibutuhkan sesuai dengan dokumen soal
        JPanel panelStafHome = new JPanel();
        panelStafHome.setLayout(new GridLayout(10, 1, 5, 5));

        labelWelcome.setFont(new Font("Times New Roman", Font.PLAIN, 36));

        JButton buttonTambahMahasiswa = new JButton("Tambah Mahasiswa");
        JButton buttonTambahDosen = new JButton("Tambah Dosen");
        JButton buttonTambahKategori = new JButton("Tambah Kategori");
        JButton buttonTambahBuku = new JButton("Tambah Buku");
        JButton buttonHapusBuku = new JButton("Hapus Buku");
        JButton button3PeringkatPertama = new JButton("3 Peringkat Pertama");
        JButton buttonDetailAnggota= new JButton("Detail Anggota");
        JButton buttonDaftarPeminjamanBuku = new JButton("DaftarPeminjamanBuku");
        JButton buttonLogout = new JButton("Logout");

        // Menambahkan component-component yang sudah diinisiasi di atas ke panel
        panelStafHome.add(labelWelcome);
        panelStafHome.add(buttonTambahMahasiswa);
        panelStafHome.add(buttonTambahDosen);
        panelStafHome.add(buttonTambahKategori);
        panelStafHome.add(buttonTambahBuku);
        panelStafHome.add(buttonHapusBuku);
        panelStafHome.add(button3PeringkatPertama);
        panelStafHome.add(buttonDetailAnggota);
        panelStafHome.add(buttonDaftarPeminjamanBuku);
        panelStafHome.add(buttonLogout);

        // Menambahkan panel ke dalam frame
        add(panelStafHome);

        // Melakukan handle jika user berinteraksi dengan buttonTambahMahasiswa
        buttonTambahMahasiswa.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent E){
                main.setPanel("tambahMhs");
            }
        }
        );

        // Melakukan handle jika user berinteraksi dengan buttonTambahDosen
        buttonTambahDosen.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent E){
                main.setPanel("tambahDosen");
            }
        }
        );

        // Melakukan handle jika user berinteraksi dengan buttonTambahKategori
        buttonTambahKategori.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent E){
                main.setPanel("tambahKategori");
            }
        }
        );

        // Melakukan handle jika user berinteraksi dengan buttonTambahBuku
        buttonTambahBuku.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent E){
                main.setPanel("tambahBuku");
            }
        }
        );
        
        // Melakukan handle jika user berinteraksi dengan buttonHapusBuku
        buttonHapusBuku.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent E){
                main.setPanel("hapusBuku");
            }
        }
        );

        // Melakukan handle jika user berinteraksi dengan button3PeringkatPertama
        button3PeringkatPertama.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent E){
                main.setPanel("peringkat");
            }
        }
        );

        // Melakukan handle jika user berinteraksi dengan buttonDetailAnggota
        buttonDetailAnggota.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent E){
                main.setPanel("detailAnggota");
            }
        }
        );

        // Melakukan handle jika user berinteraksi dengan buttonDaftarPeminjamanBuku
        buttonDaftarPeminjamanBuku.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent E){
                main.setPanel("daftarPeminjam");
            }
        }
        );

        // Melakukan handle jika user berinteraksi dengan buttonLogout
        buttonLogout.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent E){
                main.setPanel("login");
            }
        }
        );
    }

    @Override
    public void refresh() {
        // TODO: Implementasikan hal-hal yang diperlukan
        // Jika tidak diperlukan, Anda dapat mengabaikannya (kosongkan method ini)
        labelWelcome.setText("Selamat datang kembali " + main.getUser().getNama() + "!");
    }

}
