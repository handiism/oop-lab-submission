package id.handiism.konverter;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double celcius;
        int opsi;

        System.out.println("+---------------------------+");
        System.out.println("| PROGRAM KONVERSI SUHU AIR |");
        System.out.println("+---------------------------+");
        System.out.println("Input Data");
        System.out.println("----------");
        System.out.print("Suhu Dalam Celcius    : ");

        celcius = scanner.nextDouble();

        Konversi konversi = new Konversi(celcius);

        while (true) {
            System.out.println();
            System.out.println("Opsi");
            System.out.println("----");
            System.out.println("1. Lihat Data Konversi");
            System.out.println("2. Edit Data Konversi");
            System.out.println("3. Exit");
            System.out.print("Pilih   : ");

            opsi = scanner.nextInt();
            System.out.println();

            if (opsi == 1) {
                System.out.format("Suhu Dalam Celcius       : %.1f°C\n", konversi.nilaiCelcius());
                System.out.format("Dalam Fahrenheit         : %.1f°F\n", konversi.keFahrenheit());
                System.out.format("Dalam Reamur             : %.1f°R\n", konversi.keReamur());
                System.out.format("Dalam Kelvin             : %.2fK\n", konversi.keKelvin());

                if (konversi.nilaiCelcius() <= 0) {
                    System.out.println("Kondisi Air Beku.");
                } else if (konversi.nilaiCelcius() >= 100) {
                    System.out.println("Kondisi Air Mendidih.");
                } else {
                    System.out.println("Kondisi Air Normal.");
                }
            } else if (opsi == 2) {
                System.out.println("Input Data");
                System.out.println("----------");
                System.out.print("Suhu Dalam Celcius      : ");
                celcius = scanner.nextDouble();
                konversi.aturCelcius(celcius);
            } else if (opsi == 3) {
                break;
            } else {
                System.out.println("Opsi tidak ada. Mohon masukkan opsi dengan benar!");
            }
        }

        scanner.close();
    }
}
