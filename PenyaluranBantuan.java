public class PenyaluranBantuan {
    private String idPenyaluran;
    private String idPenerima;
    private String tanggal;
    private String jenis; // "Tunai","Barang","Kedua"
    private double jumlahTunai;
    private String jumlahBarang;

    public PenyaluranBantuan(String idPenyaluran, String idPenerima, String tanggal, String jenis,
                             double jumlahTunai, String jumlahBarang) {
        this.idPenyaluran = idPenyaluran;
        this.idPenerima = idPenerima;
        this.tanggal = tanggal;
        this.jenis = jenis;
        this.jumlahTunai = jumlahTunai;
        this.jumlahBarang = jumlahBarang;
    }

    public String getIdPenyaluran() { return idPenyaluran; }
    public String getIdPenerima() { return idPenerima; }
    public String getJenis() { return jenis; }
    public double getJumlahTunai() { return jumlahTunai; }
    public String getJumlahBarang() { return jumlahBarang; }

    @Override
    public String toString() {
        String s = "ID=" + idPenyaluran + ", Penerima=" + idPenerima + ", Jenis=" + jenis + ", Tanggal=" + tanggal;
        if (jumlahTunai > 0) s += ", Jumlah Tunai=Rp" + (long) jumlahTunai;
        if (jumlahBarang != null && !jumlahBarang.isBlank()) s += ", Jumlah Barang=" + jumlahBarang;
        return s;
    }
}
