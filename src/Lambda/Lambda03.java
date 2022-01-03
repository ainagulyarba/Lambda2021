package Lambda;

import Lambda.Lambda01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;


public class Lambda03 {
    public static void main(String[] args) {

        List<String> list = new ArrayList(Arrays.asList("mehmet", "emre", "nilgun", "yildix", "kadex", "emine", "wislam", "islam", "kokorec"));

        bykHrfTekrarsizSira(list);
        System.out.println();
        System.out.println("*********");
        krktrSayisiTekrarsizTersSirali(list);
        System.out.println();
        System.out.println("*********");
        karakterSayisiSiraliEl(list);
        System.out.println();
        System.out.println("*********");
        elSonHarfineGoreTersSirali(list);
        System.out.println();
        System.out.println("*********");
        ciftKareTekrarsizTersSira(list);
        System.out.println();
        System.out.println("*********");
        KrktrSayisiYediVeYedidenAzDurumu(list);
        System.out.println();
        System.out.println("*********");
        elWileBaslama(list);
        System.out.println();
        System.out.println("*********");
        xbitmeKontrol(list);
        System.out.println();
        System.out.println("*********");
        krktrSayisiEnBuykEl(list);
        System.out.println();
        System.out.println("*********");
        krktrSayisiEnBuykEl2( list);
        System.out.println();
        System.out.println("*********");
        ilkElHaricSonHarfSirali(list);
    }

    public static void bykHrfTekrarsizSira(List<String> list) {
        list.
                stream().//akisa girdi
                // map(t->t.toUpperCase()).//elelmanlar byk harf update edildi
                        map(String::toUpperCase).//elelmanlar byk harf update edildi
                sorted().//alfabetik sira
                distinct().//tekrarsiz  yapildi
                forEach(t -> System.out.print(t + " "));//yazdirilidi  //EMRE EMİNE KADER MEHMET NİLGUN YILDIZ İSLAM

    }

    //list elelmanlarinin character sayisini ters sirali olarak tekrarsiz yazdiriniz
    public static void krktrSayisiTekrarsizTersSirali(List<String> list) {

        list.stream().
                map(t -> t.length()).//String Data character sayisina update edildi
                sorted(Comparator.reverseOrder()).//ters sira
                distinct().//tekrarsiz
                forEach(Lambda01::printEl);//yazdirildi//6 5 4

    }

    //List elemanlarini character sayisina gore kucukten buyuge gore yazdiriniz
    public static void karakterSayisiSiraliEl(List<String> list) {

        list.stream().
                sorted(Comparator.comparing(t -> t.length())).//eleman charakter sayisina gore ozel siralama yapildi
                // sorted=sirala; comparator.comparing=karsilastir
                //eleman length->boyut->charakter sayisi
                        forEach(t -> System.out.print(t + " "));//yazdirildi//emre emre kader emine islam islam mehmet nilgun yildiz

    }

    //list elemanlarinin son harfine gore ters sirali yazdiriniz
    public static void elSonHarfineGoreTersSirali(List<String> list) {

        list.stream().
                sorted(Comparator.
                        comparing(t -> t.toString().
                                charAt(t.toString().length() - 1)).//elamanin length()-1-->son index'inin karekterlerini alir
                                reversed()).//elemanin length()-1--> sin index'inin karakterini ters siralar z->a
                forEach(t -> System.out.print(t + " "));//yildiz mehmet kader nilgun islam islam emre emine emre

    }

    //listin elemanlarin karakterlerinin cift sayili  karelerini hesaplayan,
    // ve karelerini tekrarsiz buyukten kucuge sirali  yaziniz.
    public static void ciftKareTekrarsizTersSira(List<String> list) {

        list.stream().
                //filter(t->t.length()%2==0).
                        map(t -> t.length() * t.length()).//string elemanlar character sayisina cevirildi
                filter(Lambda01::ciftBul).//cift sarti calisti
                distinct().//tekrarsiz
                sorted(Comparator.reverseOrder()).//ters sira b->k
                forEach(Lambda01::printEl);//36 16

    }

    //list elemanlarinin karakter sayisini 7 ve 7'den az olma durumunu kontrol ediniz
    public static void KrktrSayisiYediVeYedidenAzDurumu(List<String> list) {
        //allMatch =her bir elemani eslestir
        //  boolean kontrol = list.stream().allMatch(t -> t.length() <= 7);//her bir elemani harf sayisini <=7 ye eslesmesine bakti
        //  if (kontrol) {
        //      System.out.println("List elemanlari 7 harften buyuk degildir");//true
        //  } else {
        //      System.out.println("List elemanlari 7 harften buyuktur");
        //  }
        //  System.out.println(kontrol);
        System.out.println(list.stream().allMatch(t -> t.length() <= 7) ? "List elemanlari 7 harften buyuk degildir" : "List elemanlari 7 harften buyuktur");//true

    }

    // List elemanlarinin "W" ile baslamasini kontrol ediniz
    public static void elWileBaslama(List<String> list) {

        System.out.println(list.stream().noneMatch(t -> t.startsWith("w")) ? "w ile baslayan isim kimse ayaga kalksin" : "w ile isim olmaz");
        //eslesmesi olmaz                                //true                         false

    }

    //list elemanlarinin "x" ile biten en az bir elemani kontrol ediniz
    public static void xbitmeKontrol(List<String> list) {

        System.out.println(list.stream().anyMatch(t -> t.endsWith("x")) ? "X ile baslayan isim kimse ayaga kalksin" : "X ile biten  isim olmaz");
        //eslesmesi olmaz                   en az sarti saglarsa true aksi takdirde false return eder                                         //true                         false

        //anyMatch() --> enaz bir eleman sarti saglarsa true aksi durumda false return eder
        //allMatch() --> tum  elemanlar sarti saglarsa true en az bir eleman sarti saglamazsa false return eder.
        //noneMatch() --> hic bir sarti SAGLAMAZSA true en az bir eleman sarti SAGLARSA false return eder.

    }

    //karakter sayisi en buyuk elemani yazdiriniz
    public static void krktrSayisiEnBuykEl(List<String> list) {

        System.out.println(list.stream().
                sorted(Comparator.comparing(t -> t.toString().length()).//length karakter uzunluguna gore siraladi kucukten->buyuge
                        reversed()).// terst siraladi buyukten->kucuge
                //    findFirst()); //Optional[kokorec] //ilk elemani aldi
                //System.out.println(list.stream().reduce((t, u) -> t.length()>u.length()?t:u));Optional[kokorec]
                        findFirst());

    }

    public static void krktrSayisiEnBuykEl2(List<String> list) {

        Stream<String> sonIsim = list.stream().
                sorted(Comparator.comparing(t -> t.toString().length()).//length karakter uzunluguna gore siraladi kucukten->buyuge
                        reversed()).// terst siraladi buyukten->kucuge
                //    findFirst()); //Optional[kokorec] //ilk elemani aldi
                //System.out.println(list.stream().reduce((t, u) -> t.length()>u.length()?t:u));Optional[kokorec]
                        limit(1);//akistan cikan elemanlari limitliyor,yapilan siralamadaki ilk elemani alir
        System.out.println(Arrays.toString(sonIsim.toArray()));//[kokorec]
                     //Array yazdirilir//akistan cikan Data//array'ye cevir

    }
    //list elemanlarini son harfine göre siralayıp ilk eleman hariç kalan elemanlari yazdiniz
    public static void ilkElHaricSonHarfSirali(List<String> list) {

       list.stream().
                sorted(Comparator.comparing(t -> t.toString().charAt(t.length()-1))).
                skip(1).//akistan cikan elemanlarin 1.parametreyi atlar
                forEach(System.out::println);

    }



}