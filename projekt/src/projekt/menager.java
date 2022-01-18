package projekt;

import java.io.File;
import java.io.FileNotFoundException;
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
			int SKU,prefix;
			prefix=scan.nextInt();
			if(prefix<1000000) {
				System.out.println("kod jest za krotki");
				return;
			}
			if(prefix>=3000000 ||prefix<2000000) {
				System.out.println("kod produktu wagowego musi si� zaczyna� od 2");
				return;
			}

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
			ProduktWaga p=br.getProdukt();
			
			System.out.print("Podaj sektor: ");
			System.out.println(m.wypiszSektory());
			odp=scan.next();
			m.DodajProdukt(odp, p);
			}
			if(odp.equals("2")) {
				int Kraj,Produkt,Producent,kont;
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
				Kraj=Integer.parseInt(odp.substring(0, 3));
				Producent=Integer.parseInt(odp.substring(3,7));
				Produkt=Integer.parseInt(odp.substring(7,12));
				kont=Integer.parseInt(odp.substring(12));
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
				ProduktIlosc p=bi.getProdukt();
				
				System.out.print("Podaj sektor: ");
				System.out.println(m.wypiszSektory());
				odp=scan.next();
				m.DodajProdukt(odp, p);
			}
	}
	
	protected void Usuwanie(Magazyn m) {
		System.out.println(m.sektory.getString());
		System.out.println("podaj kod produktu ktory chcesz usunac/n");
		Scanner scan = new Scanner(System.in);
		String odp;
		odp=scan.next();
		
		m.sektory.usunProdukt(odp);
		//"DELETEITEM="+odp
		


	}
	
	protected void sektor(Magazyn m) {
		System.out.println("Podaj nazwe setoru: ");
		Scanner scan = new Scanner(System.in);
		String odp;
		odp=scan.next();
		Sektor nowy =new Sektor(odp);
		m.DodajSektor(nowy);
	}
	
	protected void addUser() throws FileNotFoundException {
		Scanner scan = new Scanner(System.in);
		System.out.println("podaj login nowego uzytkownika");
		String login=scan.next();
		System.out.println("podaj haslo nowego uzytkownika");
		String haslo=scan.next();
		System.out.println("wpisz menager jezeli chcesz dodac menagera w innym przypadku wpisz cokolwiek");
		String mode=scan.next();

		File plik=new File("users.txt");
		Scanner reader = new Scanner(plik);
		while(reader.hasNextLine()) {
			String data= reader.nextLine();
			String[] linia=data.split(";");
			if(linia.length==3) {
				if(linia[0].equals(login)) {
					System.out.println("podany login jest zajety");
				}
			}
		}
		String dopisz=login+";"+haslo+";"+mode;
		
		//sprawdz czy nie ma juz tego loginu jak nie to dodaj linie (login+";"+haslo+";"+rola)
		
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
				+"8.Odczytaj magazyn z pliku\n"
				+"9.Dodaj uzytkownika\n";
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
		if(choice.equals("9")) {
			try {
				addUser();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
		if(choice.equals("10")) {
			//m.getString() <--na podstawie-- new Magazyn() 
		}
		if(choice.equals("11")) {
			
		}
	}
}