package id.handiism.konverter;

/**
 * Kelas untuk mengkonversi suhu dari celcius ke
 * reamur, fahrenheit, maupun kelvin.
 */
public class Konversi {
    /**
     * Atribut celcius merupakan atribut untuk menyimpan
     * nilai celcius yang akan dikonversi.
     */

    private double celcius;

    /**
     * @param celcius Suhu celcius yang akan dikonversi.
     */

    public Konversi(double celcius) {
        this.celcius = celcius;
    }

    /**
     * @return Mengembalikan nilai celcius.
     */

    public double nilaiCelcius() {
        return this.celcius;
    }

    /**
     * @param celcius Mengatur ulang nilai celcius
     */

    public void aturCelcius(double celcius) {
        this.celcius = celcius;
    }

    /**
     * @return Mengembalikan hasil konversi dari celcius ke reamur
     */

    public double keReamur() {
        return (4 * this.celcius) / 5;
    }

    /**
     * @return Mengembalikan hasil konversi dari celcius ke fahrenheit
     */

    public double keFahrenheit() {
        return (9 * this.celcius) / 5 + 32;
    }

    /**
     * @return Mengembalikan hasil konversi dari celcius ke kelvin
     */

    public double keKelvin() {
        return this.celcius + 273.15;
    }
}
