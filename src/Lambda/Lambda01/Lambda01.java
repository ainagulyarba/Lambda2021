package Lambda.Lambda01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Lambda01 {
	/*
	 * 1) Lambda "Functional Programming" "Functional Programming" de
	 * "Nasil yaparim?" degil "Ne yaparim?" dusunulur. 2) "Structured Programming"
	 * de "Ne yaparim?" dan cok "Nasil Yaparim?" dusunulur 3)
	 * "Functional Programming" hiz, code kisaligi, code okunabilirligi ve hatasiz
	 * code yazma acilarindan cok faydalidir. 4) Lambda sadece
	 * collections'larda(List, Queue ve Set) ve array'lerde kullanilabilir ancak
	 * map'lerde kullanılmaz. Lambda kullanmak hatasız code kullanmaktır.
	 */

	public static void main(String[] args) {

		List<Integer> list = new ArrayList<>(Arrays.asList(12, 13, 65, 3, 7, 34, 22, 60, 42, 55));

		printElStructured(list);// method call
		System.out.println();
		System.out.println("   ***   ");
		printElFunctional(list);// lambda expression
		System.out.println();
		System.out.println("   ***   ");
		printElFunctional1(list);// method referance
		System.out.println();
		System.out.println("   ***   ");
		printCiftElStructured(list);
		System.out.println();
		System.out.println("   ***   ");
		printCiftElFunctional1(list);
		System.out.println();
		System.out.println("   ***   ");
		printCiftElFunctional2(list);
		System.out.println();
		System.out.println("   ***   ");
		printCiftAltmisKucuk(list);
		System.out.println();
		System.out.println("   ***   ");
		printTekBuyuk(list);
		System.out.println();
		System.out.println("   ***   ");
		printCiftKare(list);
		System.out.println();
		System.out.println("   ***   ");
		printTekKupBirFazla(list);
		System.out.println();
		System.out.println("   ***   ");
		printCiftKareKok(list);
		System.out.println();
		System.out.println("   ***   ");
		MaxElFunction(list);
		
	}

	// structured Programming ile list elemanlarinin tamamini aralarina bosluk
	// birakarak yazdiriniz
	public static void printElStructured(List<Integer> list) {

		for (Integer w : list) {

			System.out.print(w + " ");
		}
	}

	// Functional Programming ile list elemanlarinin tamamini aralarina bosluk
	// birakarak yazdiriniz
	public static void printElFunctional(List<Integer> list) {

		list.stream().forEach(t -> System.out.print(t + " "));// Lambda Expression : Lambda ifadesi //12 13 65 3 7 34 22
																// 60 42 55

		// stream() : datalari yukaridan asagiya akis sekline getirir
		// forEach() : datanin parametresine gore her bir elemani isler
		// t -> : Lambda operatoru diyoruz

		// Lambda Expression yapisi cok tavsiye edilmez, daha cok METHOD REFERENCE
		// kullanilir

	}

	// Method Reference --> kendi creat ettigimiz veya Java'dan aldigimiz () ile

	// Classname::MethodName =>(Lambda01::printEl) EZBERLE!!!

	public static void printEl(int t) {// refere edilecek () creat edildi

		System.out.print(t + " ");

	}

	public static void printElFunctional1(List<Integer> list) {

		list.stream().forEach(Lambda01::printEl);// =>Method referance diyoruz buna//12 13 65 3 7 34 22 60 42 55

	}

	// structured Programming ile list elemanlarinin cift olanlarini ayni satira
	// aralarina bosluk birakarak yazdiriniz
	public static void printCiftElStructured(List<Integer> list) {

		for (Integer w : list) {

			if (w % 2 == 0) {
				System.out.print(w + " ");// 12 34 22 60 42
			}
		}

	}

	// Functional Programming ile list elemanlarinin cift olanlarini ayni satira
	// aralarina bosluk birakarak yazdiriniz

	public static void printCiftElFunctional1(List<Integer> list) {

		list.stream().filter(t -> t % 2 == 0).forEach(Lambda01::printEl);// 12 34 22 60 42

		// filter() --> ais icerisindeki elemanlari istenen sarta gore filtreleme yapar
	}

	public static boolean ciftBul(int i) {// refere edilecek tohum () creat EDILDI
		return i % 2 == 0;

	}

	public static void printCiftElFunctional2(List<Integer> list) {

		list.stream().filter(Lambda01::ciftBul).forEach(Lambda01::printEl);// IKI TANE METHOD REFERE //12 34 22 60 42

		// filter() --> ais icerisindeki elemanlari istenen SARTA gore filtreleme yapar

	}
	// Functional Programming ile list elemanlarinin cift olanlarini 60 dan kucuk
	// olanlarini
	// ayni satira aralarina bosluk birakarak yazdir

	public static void printCiftAltmisKucuk(List<Integer> list) {

		list.stream().filter(t -> t % 2 == 0 & t < 60).forEach(Lambda01::printEl);// 12 34 22 42

	}

	// Functional Programming ile list elemanlarinin tek olanlarini veya 20 dan
	// buyuk olanlarini ayni satira aralarina bosluk birakarak yazdir

	public static void printTekBuyuk(List<Integer> list) {

		list.stream().filter(t -> t % 2 == 1 || t > 20).forEach(Lambda01::printEl);// 13 65 3 7 34 22 60 42 55

	}

	// Functional Programming ile list elemanlarinin cift olanlarinin
	// karelerini ayni satira aralarina bosluk birakarak yazdir

	public static void printCiftKare(List<Integer> list) {

		list.stream().filter(Lambda01::ciftBul).map(t->t*t).forEach(Lambda01::printEl);// 13 65 3 7 34 22 60 42 55
//       selale            cift                      kare       yazdiriyor
	}
	// Functional Programming ile list elemanlarinin tek olanlarinin
		// kuplerinin bir fazlasini ayni satira aralarina bosluk birakarak yazdir
	public static void printTekKupBirFazla(List<Integer> list) {

		list.stream().filter(t->t%2==1).map(t->(t*t*t)+1).forEach(Lambda01::printEl);// 13 65 3 7 34 22 60 42 55
//       selale            cift                    kup+1       yazdiriyor
	}
	
	// Functional Programming ile list elemanlarinin cift olanlarinin
			// karekoklerini ayni satira aralarina bosluk birakarak yazdir
	public static void printCiftKareKok(List<Integer> list) {

		list.stream().filter(Lambda01::ciftBul).map(Math::sqrt).forEach(t->System.out.println(t+" "));  // 3.4641016151377544 
			//selale				 cift			karekoku				yazdiriyor				    //5.830951894845301 
																										//4.69041575982343 
																										//7.745966692414834 
																										//6.48074069840786                                          
	}
	
	//list'in en buyuk elemanini yazdiriniz
	
	public static void MaxElFunction(List<Integer> list) {

		Optional<Integer> maxEl = list.stream().reduce(Math::max);
	//	Class	Data type   isim				azaltmak demek=>bir cok Data'yi tek bir Data'ya (max,min,carpma toplama(sum) vs islemlerde) cevirmek icin kullanilir
												//yani elemanları birbirine bağlı bir şekilde işleme sokacaksak


	System.out.println(maxEl);
	
	}
	
}
