import java.util.ArrayList;
import java.util.Scanner;

public class AplikasiYayasanAmal {
    public ArrayList<Donatur> daftarDonatur = new ArrayList<>();
    public ArrayList<PenerimaBantuan> daftarPenerima = new ArrayList<>();
    public ArrayList<Donasi> daftarDonasi = new ArrayList<>();
    public ArrayList<PenyaluranBantuan> daftarPenyaluran = new ArrayList<>();

    // ---- Donatur
    public void menuDonatur(Scanner scanner) {
        while (true) {
            System.out.println("Menu Donatur");
            System.out.println("Opsi: 1. Tambah Data 2. Lihat Data 0. Kembali");
            System.out.print("Pilih: ");
            String s = scanner.nextLine().trim();
            if (s.equals("0")) return;
            if (s.equals("1")) tambahDonatur(scanner);
            else if (s.equals("2")) tampilkanDonatur();
            else System.out.println("Pilihan tidak valid");
        }
    }

    public void tambahDonatur(Scanner scanner) {
        System.out.print("ID Donatur: ");
        String id = scanner.nextLine().trim();
        System.out.print("Nama: ");
        String nama = scanner.nextLine().trim();
        System.out.print("Alamat: ");
        String alamat = scanner.nextLine().trim();
        System.out.print("No HP: ");
        String no = scanner.nextLine().trim();

        Donatur d = new Donatur(id, nama, alamat, no);
        daftarDonatur.add(d);
        System.out.println("Tambah data Donatur: ID=" + id + ", Nama=" + nama + ", Alamat=" + alamat + ", NoHP=" + no);
    }

    public void tampilkanDonatur() {
        System.out.println("Menu Donatur");
        System.out.println("Opsi: 1. Tambah Data 2. Lihat Data");
        System.out.println("Data Donatur:");
        if (daftarDonatur.isEmpty()) {
            System.out.println("(Belum ada data donatur)");
            return;
        }
        for (Donatur d : daftarDonatur) {
            System.out.println(d.toString());
        }
    }

    // ---- Penerima
    public void menuPenerima(Scanner scanner) {
        while (true) {
            System.out.println("Menu Penerima Bantuan");
            System.out.println("Opsi: 1. Tambah Data 2. Lihat Data 0. Kembali");
            System.out.print("Pilih: ");
            String s = scanner.nextLine().trim();
            if (s.equals("0")) return;
            if (s.equals("1")) tambahPenerima(scanner);
            else if (s.equals("2")) tampilkanPenerima();
            else System.out.println("Pilihan tidak valid");
        }
    }

    public void tambahPenerima(Scanner scanner) {
        System.out.print("ID Penerima: ");
        String id = scanner.nextLine().trim();
        System.out.print("Nama: ");
        String nama = scanner.nextLine().trim();
        System.out.print("Alamat: ");
        String alamat = scanner.nextLine().trim();
        System.out.print("Status: ");
        String status = scanner.nextLine().trim();

        PenerimaBantuan p = new PenerimaBantuan(id, nama, alamat, status);
        daftarPenerima.add(p);
        System.out.println("Tambah data Penerima Bantuan: ID=" + id + ", Nama=" + nama + ", Alamat=" + alamat + ", Status=" + status);
    }

    public void tampilkanPenerima() {
        System.out.println("Menu Penerima Bantuan");
        System.out.println("Opsi: 1. Tambah Data 2. Lihat Data");
        System.out.println("Data Penerima Bantuan:");
        if (daftarPenerima.isEmpty()) {
            System.out.println("(Belum ada data penerima)");
            return;
        }
        for (PenerimaBantuan p : daftarPenerima) System.out.println(p.toString());
    }

    // ---- Donasi
    public void menuDonasi(Scanner scanner) {
        while (true) {
            System.out.println("Menu Donasi");
            System.out.println("Opsi: 1. Tambah Data 2. Lihat Data 0. Kembali");
            System.out.print("Pilih: ");
            String s = scanner.nextLine().trim();
            if (s.equals("0")) return;
            if (s.equals("1")) tambahDonasi(scanner);
            else if (s.equals("2")) tampilkanDonasi();
            else System.out.println("Pilihan tidak valid");
        }
    }

    public void tambahDonasi(Scanner scanner) {
        System.out.print("ID Donasi: ");
        String id = scanner.nextLine().trim();
        System.out.print("ID Donatur: ");
        String idDonatur = scanner.nextLine().trim();
        System.out.print("Tanggal: ");
        String tanggal = scanner.nextLine().trim();

        System.out.println("Pilih Jenis Donasi:");
        System.out.println("1. Tunai");
        System.out.println("2. Barang");
        System.out.println("3. Kedua");
        System.out.print("Pilihan Anda: ");
        String p = scanner.nextLine().trim();

        double jumlahTunai = 0;
        String jumlahBarang = "";

        if (p.equals("1")) {
            System.out.print("Jumlah Donasi Tunai: ");
            jumlahTunai = parseDouble(scanner.nextLine());
        } else if (p.equals("2")) {
            System.out.print("Jumlah Donasi Barang: ");
            jumlahBarang = scanner.nextLine();
        } else {
            System.out.print("Jumlah Donasi Tunai: ");
            jumlahTunai = parseDouble(scanner.nextLine());
            System.out.print("Jumlah Donasi Barang: ");
            jumlahBarang = scanner.nextLine();
        }

        String jenis = p.equals("1") ? "Tunai" : p.equals("2") ? "Barang" : "Kedua";
        Donasi d = new Donasi(id, idDonatur, tanggal, jenis, jumlahTunai, jumlahBarang);
        daftarDonasi.add(d);

        // find donatur name for display (if exists)
        String namaDonatur = idDonatur;
        for (Donatur dt : daftarDonatur) {
            if (dt.getId().equals(idDonatur)) { namaDonatur = dt.getNama(); break; }
        }

        System.out.println("Tambah data Donasi: ID=" + id + ", Donatur=" + namaDonatur +
                ", Jenis=" + jenis +
                (jumlahTunai>0 ? ", Jumlah Tunai=" + (long)jumlahTunai : "") +
                (!jumlahBarang.isBlank() ? ", Jumlah Barang=" + jumlahBarang : "") +
                ", Tanggal=" + tanggal);
    }

    public void tampilkanDonasi() {
        System.out.println("Menu Donasi");
        System.out.println("Opsi: 1. Tambah Data 2. Lihat Data");
        System.out.println("Data Donasi:");
        if (daftarDonasi.isEmpty()) {
            System.out.println("(Belum ada data donasi)");
            return;
        }
        for (Donasi d : daftarDonasi) System.out.println(d.toString());
    }

    // ---- Penyaluran
    public void menuPenyaluran(Scanner scanner) {
        while (true) {
            System.out.println("Menu Penyaluran Bantuan");
            System.out.println("Opsi: 1. Tambah Data 2. Lihat Data 0. Kembali");
            System.out.print("Pilih: ");
            String s = scanner.nextLine().trim();
            if (s.equals("0")) return;
            if (s.equals("1")) tambahPenyaluran(scanner);
            else if (s.equals("2")) tampilkanPenyaluran();
            else System.out.println("Pilihan tidak valid");
        }
    }

    public void tambahPenyaluran(Scanner scanner) {
        System.out.print("ID Penyaluran: ");
        String id = scanner.nextLine().trim();
        System.out.print("ID Penerima: ");
        String idPenerima = scanner.nextLine().trim();
        System.out.print("Tanggal: ");
        String tanggal = scanner.nextLine().trim();

        System.out.println("Pilih Jenis Bantuan:");
        System.out.println("1. Tunai");
        System.out.println("2. Barang");
        System.out.println("3. Kedua");
        System.out.print("Pilihan Anda: ");
        String p = scanner.nextLine().trim();

        double jumlahTunai = 0;
        String jumlahBarang = "";

        if (p.equals("1")) {
            System.out.print("Jumlah Bantuan Tunai: ");
            jumlahTunai = parseDouble(scanner.nextLine());
        } else if (p.equals("2")) {
            System.out.print("Jumlah Bantuan Barang: ");
            jumlahBarang = scanner.nextLine();
        } else {
            System.out.print("Jumlah Bantuan Tunai: ");
            jumlahTunai = parseDouble(scanner.nextLine());
            System.out.print("Jumlah Bantuan Barang: ");
            jumlahBarang = scanner.nextLine();
        }

        String jenis = p.equals("1") ? "Tunai" : p.equals("2") ? "Barang" : "Kedua";
        PenyaluranBantuan pb = new PenyaluranBantuan(id, idPenerima, tanggal, jenis, jumlahTunai, jumlahBarang);
        daftarPenyaluran.add(pb);

        // find penerima name for display (if exists)
        String namaPenerima = idPenerima;
        for (PenerimaBantuan pp : daftarPenerima) {
            if (pp.getId().equals(idPenerima)) { namaPenerima = pp.getNama(); break; }
        }

        System.out.println("Tambah data Penyaluran: ID=" + id + ", Penerima=" + namaPenerima +
                ", Jenis=" + jenis +
                (jumlahTunai>0 ? ", Jumlah Tunai=" + (long)jumlahTunai : "") +
                (!jumlahBarang.isBlank() ? ", Jumlah Barang=" + jumlahBarang : "") +
                ", Tanggal=" + tanggal);
    }

    public void tampilkanPenyaluran() {
        System.out.println("Menu Penyaluran Bantuan");
        System.out.println("Opsi: 1. Tambah Data 2. Lihat Data");
        System.out.println("Data Penyaluran:");
        if (daftarPenyaluran.isEmpty()) {
            System.out.println("(Belum ada data penyaluran)");
            return;
        }
        for (PenyaluranBantuan p : daftarPenyaluran) System.out.println(p.toString());
    }

    // ---- Laporan
    public void menuLaporan(Scanner scanner) {
        System.out.println("Menu Aplikasi");
        Laporan.tampilkanLaporan(daftarDonasi, daftarPenyaluran, daftarDonatur, daftarPenerima);
        System.out.println("Tekan Enter untuk kembali ke menu utama.");
        scanner.nextLine();
    }

    // util: parseDouble aman
    private double parseDouble(String s) {
        try { return Double.parseDouble(s.trim()); } catch (Exception e) { return 0; }
    }
}
