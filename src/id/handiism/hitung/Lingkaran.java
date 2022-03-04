package id.handiism.hitung;

public class Lingkaran implements MenghitungBidang {
    private float jarijari;

    public Lingkaran(float jarijari) {
        this.jarijari = jarijari;
    }

    public float getJarijari() {
        return this.jarijari;
    }

    public void setJarijari(float jarijari) {
        this.jarijari = jarijari;
    }

    @Override
    public float hitungLuas() {
        return (float) (PHI * Math.pow(this.jarijari, 2));
    }

    @Override
    public float hitungKeliling() {
        return 2 * PHI * this.jarijari;
    }
}
