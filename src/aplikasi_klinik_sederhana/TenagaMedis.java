package aplikasi_klinik_sederhana;

// Superclass untuk semua tenaga medis (Dokter & Perawat)
public class TenagaMedis {
    
    // Atribut private (Encapsulation)
    private String id;
    private String nama;
    private String status;

    // Constructor berparameter
    public TenagaMedis(String id, String nama, String status) {
        this.id = id;
        this.nama = nama;
        this.status = status;
    }

    // Getter & Setter (Encapsulation)
    public String getId() { 
        return id; 
    }
    public void setId(String id) { 
        this.id = id; 
    }

    public String getNama() { 
        return nama; 
    }
    public void setNama(String nama) { 
        this.nama = nama; 
    }

    public String getStatus() { 
        return status; 
    }
    public void setStatus(String status) { 
        this.status = status; 
    }

    // Method tambahan untuk menampilkan informasi dasar tenaga medis
    public void tampilkanInfo() {
        System.out.println("ID: " + id);
        System.out.println("Nama: " + nama);
        System.out.println("Status: " + status);
    }
}
