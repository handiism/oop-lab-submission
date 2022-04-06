public class Pelamar {
    private String nik;
    private String nama;
    private Nilai nilai;
    private Divisi divisi;

    public Pelamar(String nik, String nama, Nilai nilai, Divisi divisi) {
        this.nik = nik;
        this.nama = nama;
        this.nilai = nilai;
        this.divisi = divisi;
    }

    public Divisi getDivisi() {
        return divisi;
    }

    public void setDivisi(Divisi divisi) {
        this.divisi = divisi;
    }

    public String getNik() {
        return nik;
    }

    public void setNik(String nik) {
        this.nik = nik;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public Nilai getNilai() {
        return nilai;
    }

    public void setNilai(Nilai nilai) {
        this.nilai = nilai;
    }

    public boolean kelolosan() {
        return divisi.hitungKelolosan(nilai) >= Divisi.minimal;
    }

    private String ucapan() {
        return this.kelolosan() ? "Selamat kepada " + this.nama + " telah diterima sebagai divisi "
                + divisi.getClass().getSimpleName()
                : "Mohon maaf kepada " + this.nama + " telah ditolak sebagai divisi " + divisi.getClass().getSimpleName();
    }

    private String keterangan() {
        return this.kelolosan() ? "KETERANGAN : LOLOS" : "KETERANGAN : GAGAL";
    }

    private String nilaiAkhir() {
        return "Nilai Akhir : " + divisi.hitungKelolosan(nilai);
    }

    public void tampil() {
        System.out.println(nilaiAkhir());
        System.out.println(keterangan());
        System.out.println(ucapan());
    }
}
