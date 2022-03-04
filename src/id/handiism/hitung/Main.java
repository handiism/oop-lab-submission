package id.handiism.hitung;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.println("==========");
            System.out.println("Menu Utama");
            System.out.println("==========");
            System.out.println("1. Hitung Balok");
            System.out.println("2. Hitung Tabung");
            System.out.println("0. Exit");

            System.out.print("Pilih: ");
            int menu = in.nextInt();

            if (menu == 1) {
                System.out.print("Input Panjang: ");
                float panjang = in.nextFloat();

                System.out.print("Input Lebar: ");
                float lebar = in.nextFloat();

                System.out.print("Input Tinggi: ");
                float tinggi = in.nextFloat();

                Balok balok = new Balok(panjang, lebar, tinggi);

                System.out.format("Luas  Persegi Panjang = %.2f\n", balok.hitungLuas());
                System.out.format("Keliling Persegi Panjang = %.2f\n", balok.hitungKeliling());
                System.out.format("Luas Permukaan Balok = %.2f\n", balok.hitungLuasPermukaan());
                System.out.format("Volume Balok = %.2f\n", balok.hitungVolume());

                System.out.print("Ulangi? (Ya: 1 || Tidak: 0): ");
                menu = in.nextInt();

                if (menu == 1) {
                    continue;
                }

                break;
            } else if (menu == 2) {
                System.out.print("Input Tinggi: ");
                float tinggi = in.nextInt();

                System.out.print("Input Jari-Jari: ");
                float jarijari = in.nextInt();

                Tabung tabung = new Tabung(jarijari, tinggi);

                System.out.format("Luas Lingkaran = %.2f\n", tabung.hitungLuas());
                System.out.format("Keliling Lingkaran = %.2f\n", tabung.hitungKeliling());
                System.out.format("Keliling Lingkaran = %.2f\n", tabung.hitungLuasPermukaan());
                System.out.format("Volume Tabung = %.2f\n", tabung.hitungVolume());
                System.out.print("Ulangi? (Ya: 1 || Tidak: 0): ");
                menu = in.nextInt();

                if (menu == 1) {
                    continue;
                }

                break;
            } else {
                break;
            }
        }
        in.close();
    }
}
