package aplikasi_klinik_sederhana;


// Subclass: Perawat mewarisi atribut dari TenagaMedis
public class Perawat extends TenagaMedis {
    private String shift; // Atribut tambahan khusus perawat

     // Constructor dengan pemanggilan constructor superclass
    public Perawat(String id, String nama, String status, String shift) {
        super(id, nama, status);
        this.shift = shift;
    }

    // Getter & Setter
    public String getShift() { 
        return shift; 
    }
    public void setShift(String shift) { 
        this.shift = shift; 
    }

     // Method overriding
    @Override
    public void tampilkanInfo() {
        System.out.println("========== DATA PERAWAT ==========");
        super.tampilkanInfo();
        System.out.println("Shift: " + shift);
    }
}
