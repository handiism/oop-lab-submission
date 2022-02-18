package id.handiism.konverter;

public class Konversi {
    private double celcius;

    public Konversi(double celcius) {
        this.celcius = celcius;
    }

    public double nilaiCelcius() {
        return this.celcius;
    }

    public void aturCelcius(double celcius) {
        this.celcius = celcius;
    }

    public double keReamur() {
        return (4 * this.celcius) / 5;
    }

    public double keFahrenheit() {
        return (9 * this.celcius) / 5 + 32;
    }

    public double keKelvin() {
        return this.celcius + 273.15;
    }
}
