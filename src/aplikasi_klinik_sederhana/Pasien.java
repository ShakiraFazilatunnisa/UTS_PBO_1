package aplikasi_klinik_sederhana;

// Class Pasien digunakan sebagai relasi (Association) dengan Dokter
public class Pasien {
    // Atribut private (Encapsulation)
    private String idPasien;
    private String nama;
    private String keluhan;

    // Constructor berparameter
    public Pasien(String idPasien, String nama, String keluhan) {
        this.idPasien = idPasien;
        this.nama = nama;
        this.keluhan = keluhan;
    }

    // Method tambahan untuk menampilkan data pasien
    public void tampilkanInfo() {
        System.out.println("ID Pasien: " + idPasien);
        System.out.println("Nama: " + nama);
        System.out.println("Keluhan: " + keluhan);
    }

    // Getter & Setter
    public String getIdPasien() { 
        return idPasien; 
    }
    public void setIdPasien(String idPasien) { 
        this.idPasien = idPasien; 
    }

    public String getNama() { 
        return nama; 
    }
    public void setNama(String nama) { 
        this.nama = nama; 
    }

    public String getKeluhan() { 
        return keluhan; 
    }
    public void setKeluhan(String keluhan) { 
        this.keluhan = keluhan; 
    }
}
