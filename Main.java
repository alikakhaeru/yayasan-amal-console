
import java.util.*;

public class Main {
    static Scanner input = new Scanner(System.in);

    // Data Sementara (ArrayList)
    static ArrayList<String> petugas = new ArrayList<>();
    static ArrayList<String> donatur = new ArrayList<>();
    static ArrayList<String> penerima = new ArrayList<>();
    static ArrayList<String> donasi = new ArrayList<>();
    static ArrayList<String> penyaluran = new ArrayList<>();

    public static void main(String[] args) {
        login();
    }

    // === LOGIN ===
    static void login() {
        System.out.println("=== LOGIN APLIKASI YAYASAN AMAL ===");
        System.out.print("Username: ");
        String username = input.nextLine();
        System.out.print("Password: ");
        String password = input.nextLine();

        if (username.equals("admin") && password.equals("pass")) {
            System.out.println("Login berhasil!\n");
            menuUtama();
        } else {
            System.out.println("Username atau password salah. Coba lagi.\n");
            login();
        }
    }

    // === MENU UTAMA ===
    static void menuUtama() {
        while (true) {
            System.out.println("=== MENU UTAMA ===");
            System.out.println("1. Menu Petugas");
            System.out.println("2. Menu Donatur");
            System.out.println("3. Menu Penerima");
            System.out.println("4. Menu Donasi");
            System.out.println("5. Menu Penyaluran");
            System.out.println("6. Keluar");
            System.out.print("Pilih menu: ");
            int pilih = input.nextInt();
            input.nextLine();

            switch (pilih) {
                case 1: menuPetugas(); break;
                case 2: menuDonatur(); break;
                case 3: menuPenerima(); break;
                case 4: menuDonasi(); break;
                case 5: menuPenyaluran(); break;
                case 6: 
                    System.out.println("Keluar dari aplikasi...");
                    System.exit(0);
                default:
                    System.out.println("Pilihan tidak valid!\n");
            }
        }
    }

    // === MENU PETUGAS ===
    static void menuPetugas() {
        while (true) {
            System.out.println("\n=== MENU PETUGAS ===");
            System.out.println("1. Tambah Data Petugas");
            System.out.println("2. Lihat Data Petugas");
            System.out.println("0. Kembali");
            System.out.print("Pilih: ");
            int pilih = input.nextInt();
            input.nextLine();

            if (pilih == 1) tambahData(petugas, "Petugas");
            else if (pilih == 2) lihatData(petugas, "Petugas");
            else if (pilih == 0) return;
            else System.out.println("Pilihan tidak valid!\n");
        }
    }

    // === MENU DONATUR ===
    static void menuDonatur() {
        while (true) {
            System.out.println("\n=== MENU DONATUR ===");
            System.out.println("1. Tambah Data Donatur");
            System.out.println("2. Lihat Data Donatur");
            System.out.println("0. Kembali");
            System.out.print("Pilih: ");
            int pilih = input.nextInt();
            input.nextLine();

            if (pilih == 1) tambahData(donatur, "Donatur");
            else if (pilih == 2) lihatData(donatur, "Donatur");
            else if (pilih == 0) return;
            else System.out.println("Pilihan tidak valid!\n");
        }
    }

    // === MENU PENERIMA ===
    static void menuPenerima() {
        while (true) {
            System.out.println("\n=== MENU PENERIMA ===");
            System.out.println("1. Tambah Data Penerima");
            System.out.println("2. Lihat Data Penerima");
            System.out.println("0. Kembali");
            System.out.print("Pilih: ");
            int pilih = input.nextInt();
            input.nextLine();

            if (pilih == 1) tambahData(penerima, "Penerima");
            else if (pilih == 2) lihatData(penerima, "Penerima");
            else if (pilih == 0) return;
            else System.out.println("Pilihan tidak valid!\n");
        }
    }

    // === MENU DONASI ===
    static void menuDonasi() {
        while (true) {
            System.out.println("\n=== MENU DONASI ===");
            System.out.println("1. Tambah Data Donasi");
            System.out.println("2. Lihat Data Donasi");
            System.out.println("0. Kembali");
            System.out.print("Pilih: ");
            int pilih = input.nextInt();
            input.nextLine();

            if (pilih == 1) tambahData(donasi, "Donasi");
            else if (pilih == 2) lihatData(donasi, "Donasi");
            else if (pilih == 0) return;
            else System.out.println("Pilihan tidak valid!\n");
        }
    }

    // === MENU PENYALURAN ===
    static void menuPenyaluran() {
        while (true) {
            System.out.println("\n=== MENU PENYALURAN ===");
            System.out.println("1. Tambah Data Penyaluran");
            System.out.println("2. Lihat Data Penyaluran");
            System.out.println("0. Kembali");
            System.out.print("Pilih: ");
            int pilih = input.nextInt();
            input.nextLine();

            if (pilih == 1) tambahData(penyaluran, "Penyaluran");
            else if (pilih == 2) lihatData(penyaluran, "Penyaluran");
            else if (pilih == 0) return;
            else System.out.println("Pilihan tidak valid!\n");
        }
    }

    // === FUNGSI TAMBAH & LIHAT DATA ===
    static void tambahData(ArrayList<String> data, String namaMenu) {
        System.out.print("Masukkan nama " + namaMenu + ": ");
        String nama = input.nextLine();
        data.add(nama);
        System.out.println(namaMenu + " berhasil ditambahkan!\n");
    }

    static void lihatData(ArrayList<String> data, String namaMenu) {
        System.out.println("\nDaftar " + namaMenu + ":");
        if (data.isEmpty()) {
            System.out.println("Belum ada data " + namaMenu + "!");
        } else {
            for (int i = 0; i < data.size(); i++) {
                System.out.println((i + 1) + ". " + data.get(i));
            }
        }
        System.out.println();
    }
}
