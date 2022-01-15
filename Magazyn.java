package magazyn;

import java.util.List;
import java.util.Map;

public class Magazyn {//niedokonczony
	public Sektor sektory;//private
	public Magazyn() {
		sektory=new Sektor("magazyn");
	}
	public Magazyn (Sektor s) {
		sektory=new Sektor("magazyn");
		sektory.dodajProdukt("magazyn", s);
	}
	
	public boolean DodajSektor(Sektor p) {
		return sektory.dodajProdukt(sektory.nazwa,p);
	}
	
	public boolean DodajProdukt(String s,Produkt p) {
		return sektory.dodajProdukt(s, p);
	}
	
	public String wypiszSektory() {
		String ret=sektory.getString();
		String[] a=ret.split("=");
		String wynik=new String();
		for(int i=0;i<a.length;i++) {
			if(a[i].split(":").length>1)
				wynik+=a[i].split(":")[1]+"\n";
		}
		return wynik;
	}
	
	public boolean ObslugaTranzakcji(String kod,int v) {
		return sektory.zmienAsortyment(kod, v);
	}
	
	public String inwentaryzacja(Map<String,Integer> zeskanowane) {
		String[] items=sektory.getString().split("\n");
		String odp=new String();
		for(int i=0;i<items.length;i++) {
			if(items[i].contains(";")) {
				String[] linia=items[i].split(";");
				if(zeskanowane.containsKey(linia[0])) {
					int a=zeskanowane.get(linia[0])-Integer.parseInt(linia[2]);
					if(a>0) {
						odp+="stan faktyczny magazynu dla "+linia[0]+" jest wiekszy o "+String.valueOf(a)+"\n";
					}
					if(a<0) {
						odp+="stan faktyczny magazynu dla "+linia[0]+" jest mniejszy o "+String.valueOf(a)+"\n";
					}
				}
			}
		}
		return odp;
	}

	
}
