public class Pengguna {
    protected String id;
    protected String nama;
    protected String alamat;
    protected String noHP;

    public Pengguna(String id, String nama, String alamat, String noHP) {
        this.id = id;
        this.nama = nama;
        this.alamat = alamat;
        this.noHP = noHP;
    }

    public String getId() { return id; }
    public String getNama() { return nama; }
    public String getAlamat() { return alamat; }
    public String getNoHP() { return noHP; }

    @Override
    public String toString() {
        return "ID=" + id + ", Nama=" + nama + ", Alamat=" + alamat + ", NoHP=" + noHP;
    }
}
