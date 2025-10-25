import java.util.ArrayList;

public class Laporan {
    public static void tampilkanLaporan(ArrayList<Donasi> daftarDonasi, ArrayList<PenyaluranBantuan> daftarPenyaluran,
                                        ArrayList<Donatur> daftarDonatur, ArrayList<PenerimaBantuan> daftarPenerima) {
        double totalDonasiTunai = 0;
        String totalDonasiBarang = "";
        double totalPenyaluranTunai = 0;
        String totalPenyaluranBarang = "";

        // total donasi
        for (Donasi d : daftarDonasi) {
            totalDonasiTunai += d.getJumlahTunai();
            if (d.getJumlahBarang() != null && !d.getJumlahBarang().isBlank()) {
                if (!totalDonasiBarang.isBlank()) totalDonasiBarang += " + ";
                totalDonasiBarang += d.getJumlahBarang();
            }
        }

        // total penyaluran
        for (PenyaluranBantuan p : daftarPenyaluran) {
            totalPenyaluranTunai += p.getJumlahTunai();
            if (p.getJumlahBarang() != null && !p.getJumlahBarang().isBlank()) {
                if (!totalPenyaluranBarang.isBlank()) totalPenyaluranBarang += " + ";
                totalPenyaluranBarang += p.getJumlahBarang();
            }
        }

        double saldoAkhirTunai = totalDonasiTunai - totalPenyaluranTunai;
        String saldoAkhirBarang = (totalDonasiBarang.isBlank() ? "-" : totalDonasiBarang);
        if (!totalPenyaluranBarang.isBlank()) {
            saldoAkhirBarang = (totalDonasiBarang.isBlank() ? "-" : totalDonasiBarang) + " (keluar: " + totalPenyaluranBarang + ")";
        }

        System.out.println("\nLaporan Data Bantuan");
        System.out.println("---------------------------------");
        System.out.println("Total Donasi Tunai Masuk: Rp" + (long) totalDonasiTunai);
        System.out.println("Total Donasi Barang Masuk: " + (totalDonasiBarang.isBlank() ? "-" : totalDonasiBarang));
        System.out.println("Total Penyaluran Tunai: Rp" + (long) totalPenyaluranTunai);
        System.out.println("Total Penyaluran Barang: " + (totalPenyaluranBarang.isBlank() ? "-" : totalPenyaluranBarang));
        System.out.println("Saldo Akhir Yayasan: Rp" + (long) saldoAkhirTunai + " + " + (saldoAkhirBarang.equals("-") ? "-" : saldoAkhirBarang));
        System.out.println("Jumlah Donatur: " + daftarDonatur.size());
        System.out.println("Jumlah Penerima Bantuan: " + daftarPenerima.size());
        System.out.println("---------------------------------");
    }
}
