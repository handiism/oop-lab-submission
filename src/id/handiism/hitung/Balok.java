package id.handiism.hitung;

public class Balok extends PersegiPanjang implements MenghitungRuang {
    private float tinggi;

    public Balok(float panjang, float lebar, float tinggi) {
        super(panjang, lebar);
        this.tinggi = tinggi;
    }

    @Override
    public float hitungLuasPermukaan() {
        return 2 * (this.getPanjang() * this.getLebar() + this.getPanjang() * this.tinggi
                + this.getLebar() * this.tinggi);
    }

    @Override
    public float hitungVolume() {
        return this.hitungLuas() * this.tinggi;
    }
}
