package projekt;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class menager extends Magazynier{

	

	protected void Dodawanie(Magazyn m) {

		Scanner scan = new Scanner(System.in);
		String odp;
		int cena;
		System.out.print("typ produktu(1.waga 2.ilosc): ");
			odp=scan.next();
			if(odp.equals("1")) {

			System.out.print("Podaj id (7 znakow): ");
			String line;			
			line=scan.next();
			if(!line.startsWith("2")) {
				System.out.println("produkt typu waga musi zaczynac sie od 2!");
				return;
			}
			
			String prefix=line.substring(0, 2);
			String SKU=line.substring(2, 7);

			
			
			System.out.println("Podaj cene: ");
			odp=scan.next();
			cena=Integer.parseInt(odp);
			
			System.out.println("Podaj nazwe: ");
			odp=scan.next();
			

			
			ProduktWagaBuilder br=new ProduktWagaBuilder();
			if(!br.setPrefix(prefix)) return;
			if(!br.setSKU(SKU))return ;
			br.setNazwa(odp);
			br.setCena(cena);
			ProduktWaga p=br.getProdukt();
			
			System.out.print("Podaj sektor: ");
			System.out.println(m.wypiszSektory());
			odp=scan.next();
			m.DodajProdukt(odp, p);
			}
			if(odp.equals("2")) {
				String Kraj,Produkt,Producent,kont;
				System.out.print("Podaj id (13 znakow): ");
				odp=scan.next();
				if(odp.length()!=13) {
					System.out.print("Nieprawidlowy kod\n");
					return;
				}
				if(odp.startsWith("2")) {
					System.out.print("Kod produktow po ilosci nie moze zaczynac sie od 2\n");
					return;
				}
				
				Kraj=odp.substring(0, 3);
				Producent=odp.substring(3,7);
				Produkt=odp.substring(7,12);
				kont=odp.substring(12);
				
				ProduktIloscBuilder bi=new ProduktIloscBuilder();
				
				if(!bi.setProduktID(Produkt)) return ;
				if(!bi.setProducentID(Producent))return ;
				if(!bi.setKrajID(Kraj))return ;
				if(!bi.setKontrolnyID(kont))return ;
				
				System.out.print("Podaj cene: ");
				odp=scan.next();
				cena=Integer.parseInt(odp);
				bi.setCena(cena);
				
				System.out.print("Podaj nazwe: ");
				odp=scan.next();
				bi.setNazwa(odp);
				ProduktIlosc p=bi.getProdukt();
				
				System.out.print("Podaj sektor: ");
				System.out.println(m.wypiszSektory());
				odp=scan.next();
				if(m.DodajProdukt(odp, p)) {
					System.out.println("Udalo sie dodac produkt\n");
				}
				else {
					System.out.println("Nie udalo sie dodac produktu ! \n");
				}	
				
			}
	}
	
	protected void Usuwanie(Magazyn m) {
		System.out.println(m.getString());
		System.out.println("podaj kod produktu ktory chcesz usunac/n");
		Scanner scan = new Scanner(System.in);
		String odp;
		odp=scan.next();
		
		m.usunProdukt(odp);
	}
	
	protected void sektor(Magazyn m) {
		System.out.println("Podaj nazwe setoru: ");
		Scanner scan = new Scanner(System.in);
		String odp;
		odp=scan.next();
		Sektor nowy =new Sektor(odp);
		m.DodajSektor(nowy);
	}
	
	
	
	@Override
	public String getMenu() {
		return"1.Dodaj produkt \n"
				+ "2.Usun produkt\n"
				+ "3.Lista wszystkich produktow\n"
				+ "4.Tranzakcja \n"
				+ "5.Dodaj sektor \n"
				+ "6.Inwentaryzacja\n"
				+ "7.Zapisz magazyn do pliku\n"
				+"8.Odczytaj magazyn z pliku\n";
	}
	
	@Override 
	public void perform(String choice, Magazyn m) {
		if(choice.equals("1")) {
			Dodawanie(m);
		}
		if(choice.equals("2")) {
			Usuwanie(m);
		}
		if(choice.equals("3")) {
			System.out.println(m.getString());
		}
		if(choice.equals("4")) {
			Tranzakcja(m);
		}
		if(choice.equals("5")) {
			sektor(m);
		}
		if(choice.equals("6")) {
			inwentaryzacja(m);
		}
		if(choice.equals("7")) {
			m.save();
		}
		if(choice.equals("8")) {
			m.load("magazyn.txt");
		}
	}
}
