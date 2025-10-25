public class PenerimaBantuan extends Pengguna {
    private String status;

    public PenerimaBantuan(String id, String nama, String alamat, String status) {
        super(id, nama, alamat, "-");
        this.status = status;
    }

    public String getStatus() { return status; }

    @Override
    public String toString() {
        return "ID=" + id + ", Nama=" + nama + ", Alamat=" + alamat + ", Status=" + status;
    }
}
