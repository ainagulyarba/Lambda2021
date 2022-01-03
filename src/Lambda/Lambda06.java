package Lambda;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Locale;
import java.util.stream.Collectors;

public class Lambda06 {
    public static void main(String[] args) throws IOException {

        //TASK 01 --> haluk.txt dosyasini okuyunuz.(Console'a yazdiriniz)
        System.out.println("\n*** haluk.txt dosyasini okuyunuz -->  ");
        Files.lines(Paths.get("src/Lambda/src.tx")).//file erisip file satirlari akis alindi
                forEach(System.out::println);

        //TASK 02 --> haluk.txt dosyasini buyuk harflerle okuyunuz.(Console'a buyuk harflerle yazdiriniz)
        System.out.println("\n*** haluk.txt dosyasini buyuk harflerle okuyunuz -->  ");
        Files.lines(Paths.get("src/Lambda/src.tx")).//file erisip file satirlari akis alindi
                map(String::toUpperCase).//akistaki satirlarin buyuk harf ile update edildi
                forEach(System.out::println);

        //TASK 03 --> haluk.txt dosyasindaki ilk satiri kucuk harflerle yazdiriniz.
        System.out.println("\n*** haluk.txt dosyasindaki ilk satiri kucuk harflerle okuyunuz 01 -->  ");
        Files.lines(Paths.get("src/Lambda/src.tx")).//file erisip file satirlari akis alindi
                limit(1).//ilk satir alindi // fineFirst te yapabiliriz
                map(String::toLowerCase).
                forEach(System.out::println);

        //TASK 04 --> haluk.txt dosyasinda "basari" kelimesinin kac satirda gectiginiz yazdiriniz
        System.out.println("\n*** haluk.txt dosyasinda basari kelimesinin kac satirda gectiginiz yazdiriniz -->  ");
        System.out.println(Files.lines(Paths.get("src/Lambda/src.tx")).//file erisip file satirlari akis alindi
                filter(t -> t.contains("basari")).//basari icerme sarti
                count());//sarti saglayan akistaki elemanlar -> satirlar sayildi

        //TASK 05 --> haluk.txt dosyasindaki farkli kelimeleri  yazdiriniz.
        System.out.println("\n*** haluk.txt dosyasindaki farkli kelimeleri  yazdiriniz. -->  ");
        System.out.println(Files.lines(Paths.get("src/Lambda/src.tx")).//file erisip file satirlari akis alindi
                map(t -> t.split(" ")).//bosluga gore satirlardaki elemanlari parcalayip Array'e atadi
                flatMap(Arrays::stream).//Arrays Class'indan stream()'u ile Array elemanlarini yeni akis olusturdu
                distinct().//yeni akistaki Array elemanlari tekrarsiz hale getirildi
               // collect(Collectors.toList()));//yeni akistaki Array tekrarsiz elemanlari liste atandi
                toList());

     //TASK 06 --> haluk.txt dosyasindaki tum kelimeleri natural order  yazdiriniz.
     System.out.println("\n*** haluk.txt dosyasindaki tum kelimeleri natural order  yazdiriniz. -->  ");
     Files.lines(Paths.get("src//haluk.txt")).
             map(t -> t.
             toLowerCase().
             split(" ")).
             flatMap(Arrays::stream).
             sorted().
             forEach(System.out::println);



        //  TASK 07 --> haluk.txt dosyasinda "basari" kelimesinin kac kere gectigini buyuk harf kucuk harf bagımsız yaziniz.
          System.out.println("\n*** haluk.txt dosyasinda basari kelimesinin kac kere gectigini  yazdiriniz. -->  ");
             Files.lines(Paths.get("src//haluk.txt")).
              map(t -> t.
              toLowerCase().
              split(" ")).
              flatMap(Arrays::stream).
              sorted().
              forEach(System.out::println);

       //TASK 08 --> haluk.txt dosyasinda "a" harfi gecen kelimelerin sayisini ekrana yazdiran programi yaziniz
         System.out.println("\n*** haluk.txt dosyasinda a harfi gecen kelimelerin sayisini ekrana yazdiran programi yazdiriniz. -->  ");
         System.out.println(Files.lines(Paths.get("src//haluk.txt")).
            map(t -> t.
            split("")).
            flatMap(Arrays::stream).
            filter(t -> t.
            equals("a")).
            count());

         //TASK 09 --> haluk.txt dosyasinda icinde "a" harfi gecen kelimeleri yazdiriniz
          System.out.println("\n*** haluk.txt dosyasinda a harfi gecen kelimeler yazdiriniz. -->  ");
           Files.lines(Paths.get("src//haluk.txt")).
                   map(t -> t.
                   split(" ")).
                   flatMap(Arrays::stream).
                   filter(t -> t.
                   contains("a")).
                   forEach(System.out::println);


        //TASK 10 --> haluk.txt dosyasinda kac /farklı harf kullanildigini yazdiriniz
        System.out.println("\n*** haluk.txt dosyasinda kac /farklı harf kullanildigini  yazdiriniz. -->  ");

        System.out.println(Files.lines(Paths.get("src//haluk.txt")).
                map(t -> t.
                replaceAll("\\W", "").//array veririr
                replaceAll("\\d", "").//array veririr
                split("")).
                flatMap(Arrays::stream).
                //distinct().
                count());

        //TASK 11 --> haluk.txt dosyasinda kac farkli kelime kullanildigini yazdiriniz
        System.out.println("\n*** haluk.txt dosyasinda kac farkli kelime kullanildigini  yazdiriniz. -->  ");

        System.out.println(Files.lines(Paths.get("src//haluk.txt")).
                map(t -> t.
                replaceAll("[.!?,\\-]", "").
                split(" ")).
                flatMap(Arrays::stream).
                distinct().
                count());

    }
}
