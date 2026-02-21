package com.mervan.logictoolkit;

import java.util.Scanner;

public class LogicToolkitApp {

    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("=== MERVAN LOGIC PROJESİNE HOŞ GELDİNİZ ===");

        while (true) {
            System.out.println("\n--- ANA MENÜ ---");
            System.out.println("1 - String (Metin) İşlemleri");
            System.out.println("2 - Number (Sayı) İşlemleri");
            System.out.println("3 - Array (Dizi) İşlemleri");
            System.out.println("0 - Çıkış");
            System.out.print("Seçiminiz: ");

            int anaSecim = input.nextInt();
            input.nextLine();

            if (anaSecim == 0) {
                System.out.println("Porgramdan çıkılıyor...");
                break;
            }

            switch (anaSecim) {
                case 1:
                    System.out.print("Bir kelime giriniz: ");
                    String gelenKelime = input.nextLine();

                    System.out.println("\n1: Son 3 harfi büyüt");
                    System.out.println("2: Tersten yazdır");
                    System.out.println("3: 'xyz' kontrolü");
                    System.out.print("İşlem seçiniz: ");
                    int strSecim = input.nextInt();

                    stringMenu(gelenKelime , strSecim);
                    break;

                case 2:
                    System.out.print("Lütfen bir sayı giriniz: ");
                    int gelenSayi = input.nextInt();

                    System.out.println("\n1: Tek/Çift kontrolü");
                    System.out.println("2: Pozitif/Negatif kontrolü");
                    System.out.println("3: Basamaklar toplamı");
                    System.out.print("İşlem seçiniz: ");
                    int numSecim = input.nextInt();

                    numberMenu(gelenSayi, numSecim);
                    break;

                case 3:
                    System.out.print("Dizi kaç elemanlı olsun?: ");
                    int boyut = input.nextInt();

                    if (boyut <= 0) {
                        System.out.println("Hata: Dizi boyutu 0'dan büyük olmalı!");
                    } else {
                        int[] yeniDizi = new int[boyut];

                        for (int i = 0; i < boyut; i++) {
                            System.out.print((i + 1) + ". elemanı giriniz: ");
                            yeniDizi[i] = input.nextInt();
                        }

                        System.out.println("\n1: En büyük sayıyı bul");
                        System.out.println("2: Ortalamayı bul");
                        System.out.println("3: 1-2-3 sıralı var mı?");
                        System.out.print("İşlem seçiniz: ");
                        int arrSecim = input.nextInt();

                        // Artık metoda diziyi parametre olarak atıyoruz
                        arrayMenu(yeniDizi, arrSecim);
                    }
                    break;

                default:
                    System.out.println("Hatalı seçim, tekrar deneyiniz.");
            }
        }

    }

    public static void stringMenu(String str, int sayi) {

        if (str.length() < 3 && sayi == 1) {
            System.out.println("Kelime en az 3 harf olmalı");
            return;
        }

        if (sayi == 1) {

            String sonUc = str.substring(str.length() - 3);
            System.out.println(str.substring(0, str.length() - 3) + sonUc.toUpperCase());

        } else if (sayi == 2) {

            char[] c = str.toCharArray();
            String ters = "";

            for (int i = c.length - 1; i >= 0; i--) {
                ters += c[i];
            }

            System.out.println(ters);
        } else if (sayi == 3) {

            boolean bulundu = false;

            for (int i = 0; i <= str.length() - 3; i++) {
                if (str.substring(i, i + 3).equals("xyz")) {
                    bulundu = true;
                    break;
                }
            }

            if (bulundu) {
                System.out.println("xyz var");
            } else {
                System.out.println("xyz yok");
            }
        } else {
            System.out.println("Geçersiz seçim");
        }
    }

    public static void numberMenu(int num, int sayi) {

        if (sayi == 1) {

            if (num % 2 == 0) {
                System.out.println(num + " Bir çift sayıdır");
            } else {
                System.out.println(num + " Bir tek sayıdır");
            }

        } else if (sayi == 2) {
            if (num < 0) {
                System.out.println(num + " Bir negatif sayıdır");
            } else if (num > 0) {
                System.out.println(num + " Bir pozitif sayıdır");
            } else {
                System.out.println(num + " Sıfırdır");
            }
        } else if (sayi == 3) {
            int toplam = 0;
            int islem = Math.abs(num);

            while (islem > 0) {
                toplam += islem % 10;
                islem = islem / 10;
            }
            System.out.println(num + " Basamaklar toplamı = " + toplam);

        } else {
            System.out.println("Geçersiz seçim");
        }
    }

    public static void arrayMenu(int[] dizi , int sayi) {
        if (sayi == 1) {

            int en_buyuk = dizi[0];

            for (int i = 1; i < dizi.length ; i++) {

                if (dizi[i] > en_buyuk) {
                    en_buyuk = dizi[i];
                }
            }
            System.out.println("En büyük sayı: " + en_buyuk);
        } else if (sayi == 2) {

            double toplam = 0;

            for (int i = 0; i < dizi.length ; i++) {
                toplam += dizi[i];
            }
            double ortalama = toplam / dizi.length;
            System.out.println("Dizideki elemanların ortalaması = " + ortalama);
        } else if (sayi == 3) {

            boolean var_mi = false;

            for (int i = 0; i <= dizi.length - 3; i++) {

                if (dizi[i] == 1 && dizi[i + 1] == 2 && dizi[i + 2] == 3) {
                    var_mi = true;
                    break;
                }
            }
            if (var_mi) {
                System.out.println("1 , 2 , 3  yan yana var");
            } else {
                System.out.println("1 , 2 , 3  yan yana yok");
            }

        } else {
            System.out.println("Geçersiz seçim");
        }

    }

}
