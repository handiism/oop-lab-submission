package id.handiism.hitung;

public class Tabung extends Lingkaran implements MenghitungRuang {
    private float tinggi;

    public Tabung(float jarijari, float tinggi) {
        super(jarijari);
        this.tinggi = tinggi;
    }

    public Tabung(float jarijari) {
        super(jarijari);
    }

    public float getTinggi() {
        return tinggi;
    }

    public void setTinggi(float tinggi) {
        this.tinggi = tinggi;
    }

    @Override
    public float hitungLuasPermukaan() {
        return 2 * this.hitungLuas() + this.hitungKeliling() * this.tinggi;
    }

    @Override
    public float hitungVolume() {
        return this.hitungLuas() * this.tinggi;
    }
}
