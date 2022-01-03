package projekt;

import java.util.List;

public class Magazyn {//niedokonczony
	public Sektor sektory;//private
	
	public Magazyn (Sektor s) {
		sektory=s;
	}
	
	public boolean DodajSektor(Sektor p) {
		return sektory.dodajProdukt(p);
	}
	
	public boolean ObslugaTranzakcji(String kod,int v) {
		return sektory.zmienAsortyment(kod, v);
	}
	

	
}
