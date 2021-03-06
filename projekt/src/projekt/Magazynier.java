package projekt;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Magazynier implements uzytkownik {

	@Override
	public String getMenu() {
		return "1.Wyswietl magazyn\n2.Wykonaj Tranzakcje\n3.Wykonaj Inwentaryzacje\n";
	}
	
	protected void inwentaryzacja(Magazyn m) {
		String odp,kod;
		int ilosc;
		Scanner scan = new Scanner(System.in);
		Inwentaryzacja inw=new Inwentaryzacja();
		while(true) {
			System.out.println("1.Zeskanuj\n2.Sprawdz\n3.Wykonaj\n10.Porzuc ");
			odp=scan.next();
			if(odp.equals("1")) {
				System.out.println("podaj kod");
				kod=scan.next();
				System.out.println("podaj ilosc");
				ilosc=scan.nextInt();	
				inw.zeskanuj(kod, ilosc);
			}
			if(odp.equals("2")) {
				System.out.println(inw.getString());
			}
			if(odp.equals("3")) {
				System.out.println(inw.wykonaj(m));
				break;
			}
			if(odp.equals("10")) {
				break;
			}
		}
	}
	
	protected void Tranzakcja(Magazyn m) {
		System.out.println("1.Zakup/n2.Sprzedaz");
		Scanner scan = new Scanner(System.in);
		String odp;
		odp=scan.next();
		TworzenieTranzakcji t;
		if(odp.equals("1")) {
			t=new TworzenieTranzakcjiZakupu();
		}
		else if(odp.equals("2")) {
			t=new TworzenieTranzakcjiSprzedazy();
		}
		else {
			return;
		}
		
		while(true) {
			System.out.println("1.Dodaj Produkt");
			System.out.println("2.Dokonaj tranzakcji");
			
			odp=scan.next();
			if(odp.equals("1")) {
				
				System.out.println("podaj kod");
				odp=scan.next();
				System.out.println("podaj ilosc");
				int ilosc=scan.nextInt();
				t.DodajProdukt(odp, ilosc);
			}
			if(odp.equals("2")) {
				t.stworz(m);
				break;
			}
		}

	}

	@Override
	public void perform(String choice, Magazyn m) {
		if(choice.equals("1")) {
			System.out.println(m.getString());
		}
		if(choice.equals("2")) {
			Tranzakcja(m);
		}
		if(choice.equals("3")) {
			inwentaryzacja(m);
		}
		if(choice.equals("zapis")) {
			m.zapisz();
		}
		if(choice.equals("cofnij")) {
			m.wczytaj();
		}
	}

}
