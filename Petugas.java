import java.util.ArrayList;
import java.util.Scanner;

public class Petugas {
    private String idPetugas;
    private String nama;
    private String username;
    private String password;

    private static ArrayList<Petugas> daftarPetugas = new ArrayList<>();

    public Petugas(String idPetugas, String nama, String username, String password) {
        this.idPetugas = idPetugas;
        this.nama = nama;
        this.username = username;
        this.password = password;
    }

    public String getIdPetugas() { return idPetugas; }
    public String getNama() { return nama; }
    public String getUsername() { return username; }

    // login sesuai UML: cari petugas berdasarkan username+password
    public static Petugas login(String username, String password) {
        for (Petugas p : daftarPetugas) {
            if (p.username.equals(username) && p.password.equals(password)) {
                return p;
            }
        }
        return null;
    }

    // tambah data (sesuai tampilan rancangan)
    public static void tambahData(Scanner scanner) {
        System.out.print("ID Petugas: ");
        String id = scanner.nextLine().trim();
        System.out.print("Nama: ");
        String nama = scanner.nextLine().trim();
        System.out.print("Username: ");
        String user = scanner.nextLine().trim();
        System.out.print("Password: ");
        String pass = scanner.nextLine().trim();

        Petugas baru = new Petugas(id, nama, user, pass);
        daftarPetugas.add(baru);
        System.out.println("Tambah data Petugas: ID=" + id + ", Nama=" + nama + ", Username=" + user);
    }

    // lihat data (sesuai tampilan rancangan)
    public static void lihatData() {
        System.out.println("Data Petugas:");
        if (daftarPetugas.isEmpty()) {
            System.out.println("(Belum ada data petugas)");
            return;
        }
        for (Petugas p : daftarPetugas) {
            System.out.println("ID=" + p.idPetugas + ", Nama=" + p.nama + ", Username=" + p.username);
        }
    }

    public static void tambahPetugasAwal(Petugas p) {
        daftarPetugas.add(p);
    }

    public static ArrayList<Petugas> getDaftarPetugas() {
        return daftarPetugas;
    }
}
