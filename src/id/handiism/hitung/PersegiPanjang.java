package id.handiism.hitung;

public class PersegiPanjang implements MenghitungBidang {
    private float panjang;
    private float lebar;

    public PersegiPanjang(float panjang, float lebar) {
        this.panjang = panjang;
        this.lebar = lebar;
    }

    public float getPanjang() {
        return this.panjang;
    }

    public void setPanjang(float panjang) {
        this.panjang = panjang;
    }

    public float getLebar() {
        return this.lebar;
    }

    public void setLebar(float lebar) {
        this.lebar = lebar;
    }

    @Override
    public float hitungLuas() {
        return this.panjang * this.lebar;
    }

    @Override
    public float hitungKeliling() {
        return 2 * (this.panjang + this.lebar);
    }
}
