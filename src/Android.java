public class Android implements Divisi {
    private Bobot bobot = new Bobot(0.2, 0.5, 0.3);

    @Override
    public double hitungKelolosan(Nilai nilai) {
        double totalNilai = nilai.getTulis() * bobot.getTulis() + nilai.getKoding() * bobot.getKoding()
                + nilai.getWawancara() * bobot.getWawancara();
        double jumlahParameterDinilai = 3;
        return totalNilai / jumlahParameterDinilai;
    }

}
