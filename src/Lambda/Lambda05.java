package Lambda;

import java.util.stream.IntStream;

public class Lambda05 {
    public static void main(String[] args) {

        System.out.println(topla(10));//55
        System.out.println("********");
        System.out.println(topla1(10));//55
        System.out.println("********");
        System.out.println(topla2(10));//55
        System.out.println("********");
        System.out.println(toplaCift(10));//30
        System.out.println("********");
        System.out.println(toplaCift1(10));//110
        System.out.println("********");
        System.out.println(toplaTek(10));//100
        System.out.println("********");
        ikiIlkXkuvvet(10);//2 4 8 16 32 64 128 256 512 1024
        istenenBirSayiIlkXkuvvet(2,3); //2nin ilk 3 kuvveti:2 4 8
        istenenBirSayiIlkXkuvvet(3,4);//3nin ilk 4 kuvveti:3 9 27 81
        istenenBirSayiIlkXkuvvet(5,3);//5nin ilk 3 kuvveti:5 25 125
        istenenBirSayiIlkXkuvvet(1,10);//  1 1 1 1 1 1 1 1 1 1
        System.out.println("********");
        System.out.println(istenenSayininFactoriyel(5));//120
        System.out.println("********");
        System.out.println(istenenSayininXnciKuvvet(2, 4));//16
    }
        //TASK 01 --> Structured Programming ve Functional Programming ile 1'den x'e kadar tamsayilari toplayan bir program yaziniz.
        //Structured Programing
        public static int topla(int x){
        int toplam =0;
        for (int i = 0; i <=x; i++) {
            toplam+=i;

        }
        return toplam;
    }
        //Functional Programing
        public static int topla1(int x){

        return IntStream.range(1,x+1).//1 2 3 ...x elemanlarinin akisi-->1 dahil x+1 haric (forLoop gibi calisir)
                sum();
    }
        public static int topla2(int x){

        return IntStream.rangeClosed(1,x).//1 2 3 ...x elemanlarinin akisi-->1 ve x dahil
                sum();
    }

        //TASK 02 --> 1'den x'e kadar cift tamsayilari toplayan bir program yaziniz
         public static int toplaCift(int x){

        return IntStream.rangeClosed(1,x).//1 2 3 ...x elemanlarinin akisi
                filter(Lambda01::ciftBul).//2 4 6 ...eleman akisi
                filter(t->t%2==0).
                sum();
    }
        //TASK 03 --> Ilk x pozitif cift sayiyi toplayan program yaziniz
         public static int toplaCift1(int x){

        return IntStream.iterate(2,t->t+2).//2 4 6 ...x elemanlarinin akisi
                limit(x).//akistaki ilk x elemani verir
                sum();
    }

        //TASK 04 --> Ilk X pozitif tek tamsayiyi toplayan programi yaziniz
        public static int toplaTek(int x){

            return IntStream.iterate(1,t->t+2).//1 2 3 5 ...x elemanlarinin akisi
                    limit(x).//akistaki ilk x elemani verir
                    sum();
        }
        //TASK 05 --> 2'nin ilk x kuvvetini ekrana yazdiran programi yaziniz
        public static void ikiIlkXkuvvet(int x){

             IntStream.iterate(2,t->t*2).//2 4 8 16 32 ...x elemanlarinin akisi
                    limit(x).//akistaki ilk x elemani verir
                    forEach(Lambda01::printEl);
        }
        //TASK 06 --> Istenilen bir sayinin ilk x kuvvetini ekrana yazdiran programi yaziniz
        public static void istenenBirSayiIlkXkuvvet(int a, int x){

            IntStream.iterate(a,t->t*a).//a a^2 a^3 a^4 a^5  ...x elemanlarinin akisi
                    limit(x).//akistaki ilk x elemani verir
                    forEach(Lambda01::printEl);
        }

        //TASK 07 --> Istenilen bir sayinin faktoriyelini hesaplayan programi yaziniz
        public static int istenenSayininFactoriyel(int x){

            return   IntStream.rangeClosed(1,x).////a a^2 a^3 a^4... x elemanarinin akısı
                    // reduce(Math::multiplyExact);
                     reduce(1,(t,u)->t*u);
        }

         //TASK 08 --> Istenilen bir sayinin ilk x kuvvetini ekrana yazdiran programi yaziniz
        public static int istenenSayininXnciKuvvet(int a, int x){

        return   IntStream.iterate(a,t->t*a).//a a^2 a^3 a^4 a^5 16 32 ...x elemanlarinin akisi
                    limit(x).
            reduce(0,(t,u)->u);//akistaki ilk x elemani verir
                    //skip(x-1);//skip den sonra cikan elemanlari toList ile yazdirilmali yoksa referans verir->java.util.stream.SliceOps$2@4e50df2e
        }
    }
