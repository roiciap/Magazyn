package projekt;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.io.*;

public class Client {
	
	public static void menu() {
		System.out.println("____________________________________");
		System.out.println("Wybierz:");
		System.out.println("0.wyjdz\n1.Dodaj produkt \n2.Usun produkt\n3.Lista wszystkich produktow\n4.Tranzakcja \n5.Dodaj sektor \n");
	}
	
	public static void Dodawanie(Magazyn m) {

		Scanner scan = new Scanner(System.in);
		String odp;
		int cena;
		System.out.print("typ produktu(1.ilosc 2.waga): ");
			odp=scan.next();
			if(odp.equals("1")) {

			System.out.print("Podaj id (7 znakow): ");
			int SKU,prefix;
			prefix=scan.nextInt();
			

			SKU=prefix%100000;
			prefix=(prefix-SKU)/100000;
			
			
			System.out.println("Podaj cene: ");
			odp=scan.next();
			cena=Integer.parseInt(odp);
			
			System.out.println("Podaj nazwe: ");
			odp=scan.next();
			

			
			ProduktWagaBuilder br=new ProduktWagaBuilder();
			br.setPrefix(prefix);
			br.setSKU(SKU);
			br.setNazwa(odp);
			br.setCena(cena);
			ProduktWaga pw=br.getProdukt();
			

			}
			if(odp.equals("2")) {
				int Kraj,Produkt,Producent,kont;
				System.out.print("Podaj id (14 znakow): ");
				odp=scan.next();
				Kraj=Integer.parseInt(odp.substring(0, 3));
				Producent=Integer.parseInt(odp.substring(3,7));
				Produkt=Integer.parseInt(odp.substring(7,13));
				kont=Integer.parseInt(odp.substring(13));
				ProduktIloscBuilder bi=new ProduktIloscBuilder();
				bi.setProduktID(Produkt);
				bi.setProducentID(Producent);
				bi.setKrajID(Kraj);
				bi.setKontrolnyID(kont);
				
				System.out.print("Podaj cene: ");
				odp=scan.next();
				cena=Integer.parseInt(odp);
				bi.setCena(cena);
				
				System.out.print("Podaj nazwe: ");
				odp=scan.next();
				bi.setNazwa(odp);
				System.out.println(Kraj+" "+Producent+" "+Produkt+" "+kont);
				ProduktIlosc p=bi.getProdukt();
				
				System.out.println(p.getString());
			}
	}
	
	public static void Usuwanie(Magazyn m) {
		System.out.println(m.sektory.getString());
		System.out.println("podaj kod produktu ktory chcesz usunac");
		Scanner scan = new Scanner(System.in);
		String odp;
		odp=scan.next();
		
		m.sektory.usunProdukt(odp);
		System.out.println(m.sektory.getString());
		
		
	}
	
	/*public static void Tranzakcja(Magazyn m) {
		System.out.println()
		
	}*/
	
	public static void main(String[] args) {
		
		Sektor s=new Sektor("A");
		ProduktIloscBuilder bi=new ProduktIloscBuilder();
		bi.setProduktID(11111);
		bi.setProducentID(1111);
		bi.setKrajID(111);
		bi.setKontrolnyID(1);
		bi.setCena(123);
		bi.setNazwa("produkt1");
		ProduktIlosc p1,p2;
		p1=bi.getProdukt();
		bi.setProduktID(22222);
		bi.setProducentID(2222);
		bi.setKrajID(222);
		bi.setKontrolnyID(2);
		bi.setCena(123);
		bi.setNazwa("produkt2");
		p2=bi.getProdukt();
		
		s.dodajProdukt(p1);
		s.dodajProdukt(p2);
		
		
		Magazyn m=new Magazyn(s);
		int a;
		boolean dzialaj=true;
		Scanner scan = new Scanner(System.in);
		while(dzialaj) {
			menu();
			a=scan.nextInt();
			
			switch(a) {
			case 0:
				dzialaj=false;
				break;
			case 1:
				Dodawanie(m);
				break;
			case 2:
				Usuwanie(m);
				break;
			case 3:
				System.out.println(m.sektory.getString());
				break;
			/*case 4:
				Tranzakcja(m);
				break;
			case 5:
				Sektor();
				break;*/
			}

			
			
		}
	}
}
		
		
		
		
		
