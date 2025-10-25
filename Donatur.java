public class Donatur extends Pengguna {
    public Donatur(String id, String nama, String alamat, String noHP) {
        super(id, nama, alamat, noHP);
    }

    @Override
    public String toString() {
        return "ID=" + id + ", Nama=" + nama + ", Alamat=" + alamat + ", NoHP=" + noHP;
    }
}
