import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double tulis, koding, wawancara;
        Divisi divisi;
        int menu;

        do {
            System.out.println("FORM PENDAFTARAN PT.UDIN");
            System.out.println("1. Android Development");
            System.out.println("2. Web Development");
            System.out.print("Pilih Jenis Form : ");

            try {
                menu = Integer.parseInt(in.nextLine());
            } catch (Exception e) {
                System.out.println();
                continue;
            }

            if (menu == 1) {
                divisi = new Android();

                System.out.println();
                System.out.println("FORM PENDAFTARAN");
                System.out.print("Input NIK : ");
                String nik = in.nextLine();
                System.out.print("Input Nama : ");
                String nama = in.next();

                System.out.print("Input Nilai Tes Tulis : ");
                try {
                    tulis = in.nextDouble();
                    if (tulis < 0 && tulis > 100) {
                        throw new Exception("Nilai Tidak Valid");
                    }
                } catch (NumberFormatException e) {
                    System.out.println();
                    continue;
                } catch (Exception e) {
                    continue;
                }

                System.out.print("Input Nilai Tes Coding : ");
                try {
                    koding = in.nextDouble();
                    if (koding < 0 && koding > 100) {
                        throw new Exception("Nilai Tidak Valid");
                    }
                } catch (NumberFormatException e) {
                    System.out.println();
                    continue;
                } catch (Exception e) {
                    continue;
                }

                System.out.print("Input Nilai Tes Wawancara : ");
                try {
                    wawancara = in.nextDouble();
                    if (wawancara < 0 && wawancara > 100) {
                        throw new Exception("Nilai Tidak Valid");
                    }
                } catch (NumberFormatException e) {
                    System.out.println();
                    continue;
                } catch (Exception e) {
                    continue;
                }

                do {
                    Nilai nilai = new Nilai(tulis, koding, wawancara);
                    Pelamar pelamar = new Pelamar(nik, nama, nilai, divisi);
                    System.out.println("Menu");
                    System.out.println("1. Edit");
                    System.out.println("2. Tampil");
                    System.out.println("3. Exit");
                    System.out.print("Pilih : ");

                    try {
                        menu = in.nextInt();
                    } catch (NumberFormatException e) {
                        System.out.println();
                        continue;
                    }

                    if (menu == 1) {
                        System.out.println();
                        System.out.println("FORM EDIT");
                        System.out.print("Input Nilai Tes Tulis : ");

                        try {
                            tulis = in.nextDouble();
                            if (tulis < 0 && tulis > 100) {
                                throw new Exception("Nilai Tidak Valid");
                            }
                        } catch (NumberFormatException e) {
                            System.out.println();
                            continue;
                        } catch (Exception e) {
                            continue;
                        }

                        System.out.print("Input Nilai Tes Coding : ");
                        try {
                            koding = in.nextDouble();
                            if (koding < 0 && koding > 100) {
                                throw new Exception("Nilai Tidak Valid");
                            }
                        } catch (NumberFormatException e) {
                            System.out.println();
                            continue;
                        } catch (Exception e) {
                            continue;
                        }

                        System.out.print("Input Nilai Tes Wawancara : ");
                        try {
                            wawancara = in.nextDouble();
                            if (wawancara < 0 && wawancara > 100) {
                                throw new Exception("Nilai Tidak Valid");
                            }
                        } catch (NumberFormatException e) {
                            System.out.println();
                            continue;
                        } catch (Exception e) {
                            continue;
                        }

                        nilai = new Nilai(tulis, koding, wawancara);
                        pelamar.setNilai(nilai);
                        System.out.println();
                    } else if (menu == 2) {
                        pelamar.tampil();
                        System.out.println();
                    } else if (menu == 3) {
                        break;
                    }
                } while (true);
                break;
            }
        } while (true);
        in.close();
    }
}
