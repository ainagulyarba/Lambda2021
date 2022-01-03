package Lambda;

import java.util.*;



public class Lambda02 {

	public static void main(String[] args) {

		List<Integer> list = new ArrayList<>(Arrays.asList(12, -3, 65, 3, 7, 34, 22, -60, 42, 15));

		ciftElKareMax(list);
		System.out.println();
		System.out.println(" *** ");
		tumElToplam(list);
		System.out.println();
		System.out.println(" *** ");
		tumElToplam1(list);
		System.out.println();
		System.out.println(" *** ");
		ciftElCarpimi(list);
		System.out.println();
		System.out.println(" *** ");
		ciftElCarpimi1(list);
		System.out.println();
		System.out.println(" *** ");
		enKucuk1(list);
		System.out.println();
		System.out.println(" *** ");
		enKucuk2(list);
		System.out.println();
		System.out.println(" *** ");
		enKucuk3(list);
		System.out.println();
		System.out.println(" *** ");
		enKucuk4(list);
		System.out.println();
		System.out.println(" *** ");
		enKucuk5(list);
		System.out.println();
		System.out.println(" *** ");
		onbestenBykKckTekSayi(list);
		System.out.println();
		System.out.println(" *** ");
		onbestenBykKckTekSayi(list);
		System.out.println();
		System.out.println(" *** ");
		ciftElKareKckBuyk(list);
		System.out.println();
		System.out.println(" *** ");
		tekKareBykKck(list);
	}

	// List'in cift olan elemanlarin karelerini aliniz ve en buyugunu yazdiriniz
	// filtrele islem update->2->4degisim
	public static void ciftElKareMax(List<Integer> list) {
		// Optional<Integer>maxEl=list.stream().filter(Lambda01::ciftBul).map(t->t*t).reduce(Integer::max);
		Optional<Integer> maxEl = list.stream().filter(Lambda01::ciftBul).map(t -> t * t).reduce(Math::max);// Optional
																											// kullandigimizda
																											// exception
																											// vermez
		// reduce(Math::max); da kullanilabilir ancak reduce(Integer::max); daha
		// specific oldugu icin daha hizli calisir

		// reduce() returne edilen eleman null ya da int'den buyuk olur ihtimali icin
		// JAva guvenlik olarak
		// handle ederek optional class sart koyar

		// int
		// maxEl=list.stream().filter(Lambda01::ciftBul).map(t->t*t).reduce(Integer::max);
		System.out.println(maxEl);// Optional[3600]

	}

	// List'teki tum elemanlarin toplamini yazdiriniz
	// lambda Expression...
	public static void tumElToplam(List<Integer> list) {
		int toplam = list.stream().reduce(0, (x, y) -> (x + y));
		// Optional<Integer>toplam=list.stream().reduce((x,y)->x+y);
		// x her zaman ilk degerini atanan degerden alir (0) alir
		// y her zaman degerini list.stream()'den akistan alir
		// x ilk degerden sonraki degerlerini islemden alir

		System.out.println(toplam);// 137
	}

	// List"teki tum elemanlarini yazdiriniz
	// () reference...
	public static void tumElToplam1(List<Integer> list) {

		Optional<Integer> toplam1 = list.stream().reduce(Integer::sum);// specific yapilar daha hizli calisir

		Optional<Integer> toplam2 = list.stream().reduce(Math::addExact);

		System.out.println(toplam1);// Optional[137]
		System.out.println(toplam2);// Optional[137]
	}

	// List'teki cift elemanlarin carpimini yazdiriniz
	// Method reference...
	public static void ciftElCarpimi(List<Integer> list) {

		Optional<Integer> carpim = list.stream().filter(Lambda01::ciftBul).reduce(Math::multiplyExact);

		System.out.println(carpim);//Optional[-22619520]

	}

	// List'teki cift elemanlarin carpimini yazdiriniz
	// Lambada expression....
	public static void ciftElCarpimi1(List<Integer> list) {

		Integer carpim = list.stream().filter(Lambda01::ciftBul).reduce(1, (x, y) -> (x * y));
		// pozitif deger uretiniz
		Integer carpimPozitif = list.stream().filter(Lambda01::ciftBul).reduce(-1, (x, y) -> (x * y));

		System.out.println(carpim);//-22619520

		System.out.println(carpimPozitif);//22619520

	}

	// list'teki elemanlardan en kucugunu 4farkli ()'ile yazdiriniz
	// 1-yontem: Method reference--> Integer Class
	public static void enKucuk1(List<Integer> list) {

		Optional<Integer> min = list.stream().reduce(Integer::min);

		System.out.println(min);//Optional[-60]

	}

	// 2-yontem: Method reference--> Math Class
	public static void enKucuk2(List<Integer> list) {

		Optional<Integer> min = list.stream().reduce(Math::min);

		System.out.println(min);//Optional[-60]

	}

	// 3-yontem: Method reference--> Haluk Class
	public static int minBul(int x, int y) {
		
		return x<y ?x:y;// ternary

	}
	public static void enKucuk3(List<Integer> list) {

		Optional<Integer> min = list.stream().reduce(Lambda02::minBul);

		System.out.println(min);//Optional[-60]

	}

	//4-yontem Lambda Expression
	public static void enKucuk4(List<Integer> list) {

		Integer min = list.stream().reduce(Integer.MAX_VALUE,(x,y)->x<y?x:y);

		System.out.println(min);//-60
		
	}

	public static void enKucuk5(List<Integer> list) {

		Optional<Integer> min = list.stream().sorted().findFirst();

		System.out.println(min);//Optional[-60]
		 

	}

	//List"teki 15'ten buyuk en kucuk tek sayiyi yazdiriniz
	public static void onbestenBykKckTekSayi(List <Integer> list) {
		//Optional<Integer> min = list.stream().filter(t->t%2==1).filter(t->t>15).reduce(Integer::min);

		System.out.println(list.stream().filter(t->t%2==1).filter(t->t>15).reduce(Integer::min));

	}

	//List'in cift elemanlariin karelerini buyukten kucuge yazdiriniz
	public static void ciftElKareKckBuyk(List <Integer> list) {

		list.
				stream().
				filter(Lambda01::ciftBul).
				map(t->t*t).
				sorted().//akisa giren elemanlar naturel orger'e gore siralanir
				forEach(Lambda01::printEl);//144 484 1156 1764 3600

	}

	//List'in tek elemanlarinin karelerini buyukten kucuge yazdir
	public static void tekKareBykKck(List <Integer> list) {
		list.
				stream().
				filter(t->t%2!=0).
				map(t->t*t).
				sorted(Comparator.reverseOrder()).
						forEach(Lambda01::printEl);//4225 225 49 9 9

	}
	
}
