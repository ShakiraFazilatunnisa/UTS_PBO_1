package aplikasi_klinik_sederhana;

import java.util.ArrayList;
import java.util.Scanner;

// Class Main untuk menjalankan seluruh aplikasi
public class Aplikasi_Klinik {

    // Menyimpan data tenaga medis & pasien (Aggregation)
    static ArrayList<TenagaMedis> tenagaList = new ArrayList<>();
    static ArrayList<Pasien> pasienList = new ArrayList<>();
    
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        int pilih = 0;

    // data awal

    // Tambah dokter awal
    tenagaList.add(new Dokter("D-01", "dr. Andi", "Tetap", "Saraf"));
    tenagaList.add(new Dokter("D-02", "dr. Bima", "Sementara", "Anak"));

    // Tambah perawat awal
    tenagaList.add(new Perawat("P-01", "Sinta", "Tetap", "Malam"));
    tenagaList.add(new Perawat("P-02", "Rina", "Sementara", "Siang"));

    // Tambah pasien awal
    pasienList.add(new Pasien("PS-01", "Budi", "Demam"));
    pasienList.add(new Pasien("PS-02", "Syra", "Batuk"));
    pasienList.add(new Pasien("PS-03", "Miki", "Luka lecet"));


        // Pilihan & Perulangan program 
        do {
            System.out.println("\n========== SISTEM KLINIK ==========");
            System.out.println("1. Tambah Tenaga Medis");
            System.out.println("2. Tambah Pasien");
            System.out.println("3. Tampilkan Semua Tenaga Medis");
            System.out.println("4. Hapus Tenaga Medis");
            System.out.println("5. Tampilkan Semua Pasien");
            System.out.println("6. Hapus Pasien");
            System.out.println("7. Cari Tenaga Medis");
            System.out.println("8. Update Data Tenaga Medis");
            System.out.println("9. Dokter Periksa Pasien");
            System.out.println("10. Keluar");
            System.out.print("Pilih menu: ");

            try {
                pilih = Integer.parseInt(input.nextLine());
            } catch (Exception e) {
                System.out.println("Input harus angka!");
                continue;
            }

            switch (pilih) {
                case 1: 
                    tambahTenagaMedis(); 
                    break;
                case 2: 
                    tambahPasien(); 
                    break;
                case 3: 
                    tampilkanTenagaMedis(); 
                    break;
                case 4: 
                    hapusTenagaMedis(); 
                    break;
                case 5: 
                    tampilkanPasien(); 
                    break;
                case 6: 
                    hapusPasien(); 
                    break;
                case 7: 
                    cariTenagaMedis(); 
                    break;
                case 8: 
                    updateTenagaMedis(); 
                    break;
                case 9: 
                    dokterPeriksaPasien(); 
                    break;
                case 10: System.out.println("Terimakasih telah menggunakan aplikasi ini!!"); 
                break;
                
                default:
                    System.out.println("Pilihan tidak valid! silahkan masukkan menu 1-10");
            }

        } while (pilih != 10);
    }

    //Method tambahTenagaMedis
    public static void tambahTenagaMedis() {
        System.out.println("\n---------- Tambah Tenaga Medis ----------");
        System.out.println("1. Dokter");
        System.out.println("2. Perawat");
        System.out.print("Pilih: ");

        int medis;
        
        try {
            medis = Integer.parseInt(input.nextLine());
        } catch (Exception e) {
            System.out.println("Input harus angka!");
            return;
        }

        if (medis != 1 && medis != 2) {
            System.out.println("Pilihan tidak valid!");
            return;
        }

        // Input atribut tenaga medis
        System.out.print("ID: ");
        String id = input.nextLine();
        if (id.isEmpty()) {
            System.out.println("ID tidak boleh kosong!");
            return;
        }

        System.out.print("Nama: ");
        String nama = input.nextLine();
        if (nama.isEmpty()) {
            System.out.println("Nama tidak boleh kosong!");
            return;
        }

        System.out.print("Status (Tetap/Sementara): ");
        String status = input.nextLine();
        if (!status.equalsIgnoreCase("Tetap") &&
            !status.equalsIgnoreCase("Sementara")) {
            System.out.println("Status tidak valid!");
            return;
        }

        // Membuat objek Dokter atau Perawat
        if (medis == 1) {
            System.out.print("Spesialis: ");
            String spesialis = input.nextLine();
            tenagaList.add(new Dokter(id, nama, status, spesialis));

        } else {
            System.out.print("Shift (Pagi / Siang / Malam): ");
            String shift = input.nextLine();
            if (!shift.equalsIgnoreCase("Pagi") &&
                !shift.equalsIgnoreCase("Siang") &&
                !shift.equalsIgnoreCase("Malam")) {
                System.out.println("Shift tidak valid!");
                return;
            }
            tenagaList.add(new Perawat(id, nama, status, shift));
        }

        System.out.println("Tenaga medis berhasil ditambahkan!");
    }

    //Method tambahPasien
    public static void tambahPasien() {
        System.out.println("\n---------- Tambah Pasien ----------");

        System.out.print("ID Pasien: ");
        String id = input.nextLine();
        if (id.isEmpty()) {
            System.out.println("ID pasien tidak boleh kosong!");
            return;
        }

        System.out.print("Nama Pasien: ");
        String nama = input.nextLine();
        if (nama.isEmpty()) {
            System.out.println("Nama pasien tidak boleh kosong!");
            return;
        }

        System.out.print("Keluhan: ");
        String keluhan = input.nextLine();
        if (keluhan.isEmpty()) {
            System.out.println("Keluhan tidak boleh kosong!");
            return;
        }

        pasienList.add(new Pasien(id, nama, keluhan));
        System.out.println("Pasien berhasil ditambahkan!");
    }

    //Method tampilkanTenagaMedis
    public static void tampilkanTenagaMedis() {
        System.out.println("\n---------- DATA TENAGA MEDIS ----------");
        if (tenagaList.isEmpty()) {
            System.out.println("(Kosong)");
            return;
        }

        for (TenagaMedis t : tenagaList) {
            t.tampilkanInfo();
            System.out.println("-------------------------------------");
        }
    }
    
    //Method hapusTenagaMedis
    public static void hapusTenagaMedis() {
    System.out.print("Masukkan ID tenaga medis yang ingin dihapus: ");
    String id = input.nextLine();

    // mencari berdasarkan ID
    for (TenagaMedis t : tenagaList) {
        if (t.getId().equals(id)) {
            
            // konfirmasi hapus
            System.out.print("Yakin ingin menghapus data ini? (y/n): ");
            String yakin = input.nextLine();
            
            if (yakin.equalsIgnoreCase("y")) {
                tenagaList.remove(t);
                System.out.println("Data tenaga medis berhasil dihapus!");
            } else {
                System.out.println("Penghapusan dibatalkan.");
            }
            return;
        }
    }
    System.out.println("Data tenaga medis tidak ditemukan!");
}


    //Method tampilkanPasien
    public static void tampilkanPasien() {
        System.out.println("\n---------- DATA PASIEN ----------");
        if (pasienList.isEmpty()) {
            System.out.println("(Kosong)");
            return;
        }

        for (Pasien p : pasienList) {
            p.tampilkanInfo();
            System.out.println("-------------------------------");
        }
    }
    
    //Method hapusPasien
    public static void hapusPasien() {
    System.out.print("Masukkan ID pasien yang ingin dihapus: ");
    String id = input.nextLine();

    for (Pasien p : pasienList) {
        if (p.getIdPasien().equals(id)) {

            // konfirmasi hapus
            System.out.print("Yakin ingin menghapus data pasien ini? (y/n): ");
            String yakin = input.nextLine();

            if (yakin.equalsIgnoreCase("y")) {
                pasienList.remove(p);
                System.out.println("Data pasien berhasil dihapus!");
            } else {
                System.out.println("Penghapusan dibatalkan.");
            }
            return;
        }
    }

    System.out.println("Data pasien tidak ditemukan!");
}

    //Method cariTenagaMedis
    public static void cariTenagaMedis() {
        System.out.print("Masukkan ID tenaga medis: ");
        String id = input.nextLine();

        for (TenagaMedis t : tenagaList) {
            if (t.getId().equals(id)) {
                t.tampilkanInfo();
                return;
            }
        }
        System.out.println("Data tenaga medis tidak ditemukan!");
    }

    //Method updateTenagaMedis
    public static void updateTenagaMedis() {
        System.out.print("Masukkan ID tenaga medis: ");
        String id = input.nextLine();

        for (TenagaMedis t : tenagaList) {
            if (t.getId().equals(id)) {
                System.out.print("Nama baru: ");
                String nama = input.nextLine();
                if (nama.isEmpty()) {
                    System.out.println("Nama tidak boleh kosong!");
                    return;
                }

                System.out.print("Status baru (Tetap/Sementara): ");
                String status = input.nextLine();
                if (!status.equalsIgnoreCase("Tetap") &&
                    !status.equalsIgnoreCase("Sementara")) {
                    System.out.println("Status tidak valid!");
                    return;
                }

                t.setNama(nama);
                t.setStatus(status);

                System.out.println("Data berhasil diperbarui!");
                return;
            }
        }

        System.out.println("Data tidak ditemukan!");
    }

    //Relasi dokter memeriksa pasien (association)
    public static void dokterPeriksaPasien() {
        System.out.println("\n--- DOKTER PERIKSA PASIEN ---");

        // Menampilkan daftar dokter
        ArrayList<Dokter> listDokter = new ArrayList<>();
        int index = 1;

        for (TenagaMedis dokter : tenagaList) {
            if (dokter instanceof Dokter) {
                System.out.println(index + ". " + dokter.getNama());
                listDokter.add((Dokter) dokter);
                index++;
            }
        }

        if (listDokter.isEmpty()) {
            System.out.println("Tidak ada data dokter!");
            return;
        }

        // Memilih dokter
        System.out.print("Pilih dokter (dengan angka): ");
        int d;
        try {
            d = Integer.parseInt(input.nextLine());
            if (d < 1 || d > listDokter.size()) {
                System.out.println("Pilihan dokter tidak valid!");
                return;
            }
        } catch (Exception e) {
            System.out.println("Input harus angka!");
            return;
        }

        Dokter dokter = listDokter.get(d - 1);

        // Menampilkan daftar pasien
        if (pasienList.isEmpty()) {
            System.out.println("Tidak ada pasien!");
            return;
        }

        System.out.println("\nDaftar Pasien:");
        for (int i = 0; i < pasienList.size(); i++) {
            System.out.println((i + 1) + ". " + pasienList.get(i).getNama());
        }

        System.out.print("Pilih pasien: ");
        int p;
        try {
            p = Integer.parseInt(input.nextLine());
            if (p < 1 || p > pasienList.size()) {
                System.out.println("Pilihan pasien tidak valid!");
                return;
            }
        } catch (Exception e) {
            System.out.println("Input harus angka!");
            return;
        }

        Pasien pasien = pasienList.get(p - 1);

        // Association: dokter → pasien
        System.out.println("\n========== STATUS PEMERIKSAAN ==========");
        System.out.println("Dokter     : " + dokter.getNama());
        System.out.println("Spesialis  : " + dokter.getSpesialis());
        System.out.println("Pasien     : " + pasien.getNama());
        System.out.println("Keluhan    : " + pasien.getKeluhan());
        System.out.println("Status     : Pemeriksaan selesai");
    }
}
