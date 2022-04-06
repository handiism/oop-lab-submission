public class Nilai {
    private double tulis;
    private double koding;
    private double wawancara;

    public double getTulis() {
        return tulis;
    }

    public void setTulis(double tulis) {
        this.tulis = tulis;
    }

    public Nilai(double tulis, double koding, double wawancara) {
        this.tulis = tulis;
        this.koding = koding;
        this.wawancara = wawancara;
    }

    public double getKoding() {
        return koding;
    }

    public void setKoding(double koding) {
        this.koding = koding;
    }

    public double getWawancara() {
        return wawancara;
    }

    public void setWawancara(double wawancara) {
        this.wawancara = wawancara;
    }

}
