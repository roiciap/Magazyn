 package projekt;

public class ProduktIlosc implements Produkt{
	String KrajID; 
	String ProducentID;
	String ProduktID;
	String KontrolnyID;
	int cena;
	int ilosc;
	String nazwa;
	
	
	public ProduktIlosc() {
		KrajID=new String();
		ProducentID=new String();
		ProduktID=new String();
		KontrolnyID=new String();
		cena=0;
		ilosc=0;
		nazwa=new String();
	}
	
	public String getCode() {
		return String.valueOf(KrajID)+String.valueOf(ProducentID)+String.valueOf(ProduktID)+String.valueOf(KontrolnyID);
	}
	
	public String getString() {
		return String.valueOf(KrajID)+String.valueOf(ProducentID)+String.valueOf(ProduktID)+String.valueOf(KontrolnyID) + ";" + nazwa + ";" + ilosc+";"+cena+";";
	}
	
	public int getCena() {
		return cena;
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
		if(id.equals(getCode()))
			return true;
		
		return false;
	}
	
	
	public boolean usunProdukt(String kod) {
		if(checkID(kod))
			return true;
		return false;
	}

	public boolean dodajProdukt(String sektor, Produkt produkt) {
		
		return false;
	}
	
}
