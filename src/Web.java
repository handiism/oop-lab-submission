public class Web implements Divisi {
    private Bobot bobot = new Bobot(0.4, 0.35, 0.25);

    @Override
    public double hitungKelolosan(Nilai nilai) {
        return nilai.getTulis() * bobot.getTulis() + nilai.getKoding() * bobot.getKoding()
                + nilai.getWawancara() * bobot.getWawancara();
    }
}
