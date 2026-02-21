package com.mervan.miniatm;

import java.util.Scanner;

/**
 * Proje: Mini ATM Simülasyonu
 * Amaç: Java'da temel kontrol akışı (switch-case, while) ve durum yönetimi (state management) pratiği.
 * Özellikler: PIN doğrulama, bakiye sorgulama, para yatırma/çekme, yetersiz bakiye kontrolü.
 */
public class AtmApp {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int sifre = 1532;
        double bakiye = 2003.56;
        int girisHakki = 3;

        while (girisHakki > 0) {

            System.out.print("Lütfen 4 haneli şifrenizi giriniz: ");
            int girilenSifre = input.nextInt();

            if (girilenSifre == sifre) {
                System.out.println("Giriş Başarılı");
                break;
            } else {
                girisHakki--;
                System.out.println("Hatalı Şifre kalan hak: " + girisHakki);
            }
        }
        if (girisHakki == 0) {
            System.exit(0);
        }

        while (true) {
            System.out.println("\n1- Bakiye Görüntüle\n2- Para Yatır\n3- Para Çek\n4- Çıkış");
            System.out.print("Seçiminiz: ");
            int secim = input.nextInt();

            switch (secim) {
                case 1:
                    bakiyeGoruntule(bakiye);
                    break;

                case 2:
                    System.out.print("Yatırmak İstediğiniz tutar: ");
                    double tutar = input.nextDouble();
                    bakiye = paraYatir(tutar , bakiye);
                    break;

                case 3:
                    System.out.print("Çekmek istediğiniz tutar: ");
                    double cekim = input.nextDouble();

                    bakiye = paraCek(cekim , bakiye);

                    break;

                case 4:
                    System.out.println("İyi Günler :)");
                    System.exit(0);

                default:
                    System.out.println("Hatalı seçim, tekrar deneyiniz.");
                    break;
            }
        }

    }


    static void bakiyeGoruntule(double goster) {
        System.out.println("Bakiyeniz: " + goster);
    }
    static double paraYatir(double tutar , double bakiye) {

        if (tutar > 0) {
            bakiye += tutar;
            System.out.println("Yeni bakiyeniz: " + bakiye);
        }

        else {
            System.out.println("Gecersiz işlem");
        }
        return bakiye;

    }

    static double paraCek(double cekim , double bakiye) {

        if (cekim > 0) {
            if (cekim > bakiye) {
                System.out.println("Yetersiz Bakiye!!!");
            } else {
                bakiye -= cekim;
                System.out.println("Yeni bakiyeniz: " + bakiye);
            }
        } else {
            System.out.println("Gecersiz işlem");
        }
        return bakiye;
    }

}
