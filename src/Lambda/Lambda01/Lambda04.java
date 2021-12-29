package Lambda.Lambda01;

import java.util.*;
import java.util.stream.Collectors;

public class Lambda04 {
    public static void main(String[] args) {

        TechPro trGunduz = new TechPro("yaz", "TR gunduz", 97, 124);
        TechPro engGunduz = new TechPro("kis", "ENG gunduz", 95, 131);
        TechPro trGece = new TechPro("bahar", "TR gece", 98, 143);
        TechPro engGece = new TechPro("sonbahar", "ENG gece", 93, 151);

        List<TechPro> list = new ArrayList<>(Arrays.asList(trGunduz, engGunduz, trGece, engGece));

        //bu class'da agirlikli return type calisacagiz
        System.out.println(batchOrt92Byk(list));//true
        System.out.println("****");
        System.out.println(ogrcSayisi110Az(list));//true
        System.out.println("****");
        System.out.println(herhangiBirBaharKontrol(list));//true
        System.out.println("****");
        System.out.println(batchOgrSayiGoreBuykKckSirala(list));//[TechPro{batch='sonbahar', batchName='ENG gece', batchOrt=93, ogrcSayisi=151}, TechPro{batch='bahar', batchName='TR gece', batchOrt=98, ogrcSayisi=143}, TechPro{batch='kis', batchName='ENG gunduz', batchOrt=95, ogrcSayisi=131}, TechPro{batch='yaz', batchName='TR gunduz', batchOrt=97, ogrcSayisi=124}]
        System.out.println("****");
        System.out.println(batchOgrSayiGoreBuykKckSiralaIlk3Yaz(list));//[TechPro{batch='bahar', batchName='TR gece', batchOrt=98, ogrcSayisi=143}, TechPro{batch='yaz', batchName='TR gunduz', batchOrt=97, ogrcSayisi=124}, TechPro{batch='kis', batchName='ENG gunduz', batchOrt=95, ogrcSayisi=131}]
        System.out.println("****");
        System.out.println(batchOgrSayiGoreEnAzOlan2BatchYaz(list));//[TechPro{batch='kis', batchName='ENG gunduz', batchOrt=95, ogrcSayisi=131}]
        System.out.println("****");
        System.out.println(batchOrt95BykBatchOgrcSayiToplami(list));//267
        System.out.println("****");
        System.out.println(batchOrt95BykBatchOgrcSayiToplami1(list));//267
        System.out.println("****");
        System.out.println(ogrcSayi130BykBatchOgrcBatchOrtalamasi( list));//OptionalDouble[95.33333333333333]
    }

    //task01--> batch ort'larinin 92 den buyuk oldugunu kontrol eden prog creat ediniz
    public static boolean batchOrt92Byk(List<TechPro> list) {
        return list.
                stream().
                allMatch(t -> t.getBatchOrt() > 92);//akistaki her eleman batchOrt field'ine gore eslesmesi kontrol edildi
    }

    //task02-->ogrc sayilarinin hic birinin 110 den az olmadigini kontrol eden prog creat ediniz
    public static boolean ogrcSayisi110Az(List<TechPro> list) {
      return  list.stream().
             // noneMatch(t->t.getOgrcSayisi()<110);
            //hic biri
        allMatch(t->t.getOgrcSayisi()>=110);
        //hepsi
    }

    //task03-->batch'lerde herhangi birinde "bahar" olup olmadigini kontrol eden bir pr creat ediniz
    public static boolean herhangiBirBaharKontrol(List<TechPro> list) {
    return  list.stream().
            anyMatch(t->t.getBatch().equals("bahar"));
}

    //task04 --> batch'leri ogr sayilarina gore b->k siralayiniz
    public static List<TechPro> batchOgrSayiGoreBuykKckSirala(List<TechPro> list) {
    return  list.stream().
            sorted(Comparator.comparing(TechPro::getOgrcSayisi).reversed()).//ogrcSayisi parametresine gore ters siraladi
            collect(Collectors.toList());//collect()->akistaki elemanlari istenen sarta gore toplar
        //Collectors.toList()--> collect'e toplanan elemanlari list'e cevirir
    }

    //task05->batch'lerde bach ort gore b->k siralayip ilk 3'unu yazdiriniz
    public static List<TechPro> batchOgrSayiGoreBuykKckSiralaIlk3Yaz(List<TechPro> list) {
        return  list.stream().
                sorted(Comparator.comparing(TechPro::getBatchOrt).reversed()).
                limit(3).//ogrcSayisi parametresine gore ters siraladi
                 collect(Collectors.toList());//collect()->akistaki elemanlari istenen sarta gore toplar
        //Collectors.toList()--> collect'e toplanan elemanlari list'e cevirir
    }

    //task06-> batch'leri ogrc sayisi en az olan 2.batch'i yazdiriniz
    public static List<TechPro> batchOgrSayiGoreEnAzOlan2BatchYaz(List<TechPro> list) {
        return  list.stream().
                sorted(Comparator.comparing(TechPro::getOgrcSayisi)).//ogrc sayisi p'lerine gore siraladi
                limit(2).//ilk iki eleman alindi
                skip(1).//ilk elemani atlatildi
                collect(Collectors.toList());//collect()->akistaki elemanlari istenen sarta gore toplar
        //Collectors.toList()--> collect'e toplanan elemanlari list'e cevirir
    }

    //task 07--> batch ort 95 'den buyuk olan batch'lerin ogrc sayilarini toplamini yazdiriniz
    public static int batchOrt95BykBatchOgrcSayiToplami(List<TechPro> list) {
        return list.
                stream().
                filter(t -> t.getBatchOrt()>95).//95 ten buyuk sarti saglandi
               map(t->t.getOgrcSayisi()).
                //reduce(0,Integer::sum);
                reduce(0,(t,u)->t+u);//ogrenci sayisi toplandi

    }

    public static int batchOrt95BykBatchOgrcSayiToplami1(List<TechPro> list) {
        return list.
                stream().
                filter(t -> t.getBatchOrt()>95).//95 ten buyuk sarti saglandi
                mapToInt(t->t.getOgrcSayisi()).//mapToInt()-->type'ne gore int return eder ki
                sum();// sum() calisir reduce gerek kalmaz daha kisa ve hizli
    }
    //task08--> ogrc sayilari 130 buyuk olan batch'lerin batch ortalamalarinin ortamayi bulunuz
    public static OptionalDouble ogrcSayi130BykBatchOgrcBatchOrtalamasi(List<TechPro> list) {
        return list.
                stream().
                filter(t -> t.getOgrcSayisi()>130).// ogrc sayisi 130 dan buyuk sarti saglandi
                mapToDouble(t->t.getBatchOrt()).//map Data update eder trans degisiklik//ortaya baska bisey cikarsa
                average();//ortalamayi veriyor
    }
}
