package aplikasi_klinik_sederhana;

// Subclass: Dokter mewarisi atribut dari TenagaMedis (Inheritance)
public class Dokter extends TenagaMedis {
    private String spesialis;  // Atribut tambahan khusus dokter

    
    // Constructor: memanggil constructor superclass dengan 'super'
    public Dokter(String id, String nama, String status, String spesialis) {
        super(id, nama, status);
        this.spesialis = spesialis;
    }

    // Getter & Setter
    public String getSpesialis() { 
        return spesialis; 
    }
    public void setSpesialis(String spesialis) { 
        this.spesialis = spesialis; 
    }

    // Method overriding
    @Override
    public void tampilkanInfo() {
        System.out.println("========== DATA DOKTER ==========");
        super.tampilkanInfo(); // memanggil method superclass
        System.out.println("Spesialis: " + spesialis);
    }
}
