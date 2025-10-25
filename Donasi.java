public class Donasi {
    private String idDonasi;
    private String idDonatur;
    private String tanggal;
    private String jenis; // "Tunai", "Barang", "Kedua"
    private double jumlahTunai;
    private String jumlahBarang;

    public Donasi(String idDonasi, String idDonatur, String tanggal, String jenis,
                  double jumlahTunai, String jumlahBarang) {
        this.idDonasi = idDonasi;
        this.idDonatur = idDonatur;
        this.tanggal = tanggal;
        this.jenis = jenis;
        this.jumlahTunai = jumlahTunai;
        this.jumlahBarang = jumlahBarang;
    }

    public String getIdDonasi() { return idDonasi; }
    public String getIdDonatur() { return idDonatur; }
    public String getJenis() { return jenis; }
    public double getJumlahTunai() { return jumlahTunai; }
    public String getJumlahBarang() { return jumlahBarang; }

    @Override
    public String toString() {
        String s = "ID=" + idDonasi + ", Donatur=" + idDonatur + ", Jenis=" + jenis + ", Tanggal=" + tanggal;
        if (jumlahTunai > 0) s += ", Jumlah Tunai=Rp" + (long) jumlahTunai;
        if (jumlahBarang != null && !jumlahBarang.isBlank()) s += ", Jumlah Barang=" + jumlahBarang;
        return s;
    }
}
