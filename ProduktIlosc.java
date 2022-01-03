package projekt;

public class ProduktIlosc implements Produkt{
	int KrajID; 
	int ProducentID;
	int ProduktID;
	int KontrolnyID;
	int cena;
	int ilosc;
	String nazwa;
	
	
	public ProduktIlosc() {
		KrajID=0;
		ProducentID=0;
		ProduktID=0;
		KontrolnyID=0;
		cena=0;
		ilosc=0;
		nazwa=null;
	}
	
	public String getCode() {
		return String.valueOf(KrajID)+String.valueOf(ProducentID)+String.valueOf(ProduktID)+String.valueOf(KontrolnyID);
	}
	
	public String getString() {
		return String.valueOf(KrajID)+String.valueOf(ProducentID)+String.valueOf(ProduktID)+String.valueOf(KontrolnyID) + ";" + nazwa + ";" + ilosc+";";
	}
	
	public int getCena() {
		return cena*ilosc;
	}
	
	public boolean zmienAsortyment(Produkt p,int zmiana) {
		if(!cmp(p)) return false; 
		ilosc+=zmiana;
		if (ilosc<0) {
			ilosc-=zmiana;
			return false;
		}
		return true;
	}
	
	public boolean zmienAsortyment(String id,int zmiana) {
		if(!checkID(id)) return false; 
		ilosc+=zmiana;
		if (ilosc<0) {
			ilosc-=zmiana;
			return false;
		}
		return true;
	}
	
	public boolean checkID(String id) {
		if(id.equals(String.valueOf(KrajID)+String.valueOf(ProducentID)+String.valueOf(ProduktID)+String.valueOf(KontrolnyID)))
			return true;
		
		return false;
	}
	
	public boolean cmp(Produkt a) {
		if(a==this) return true;
		
		return false;
	}
	
	public boolean usunProdukt(String kod) {
		if(checkID(kod))
			return true;
		return false;
	}
	
}