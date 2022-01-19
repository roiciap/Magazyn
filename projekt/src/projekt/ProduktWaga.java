package projekt;

public class ProduktWaga implements Produkt {
	String prefix;
	String SKU;	
	int cena;
	int waga;
	String nazwa;

	
	public ProduktWaga() {
		prefix=new String();
		SKU=new String();
		cena=0;
		waga=0;
		nazwa=new String();
	}
	
	
	public String getCode() {
		return prefix+SKU;	}
	
	public String getString() {
		return getCode()+";"+nazwa+";"+waga+";"+cena+";";
	}
	
	public int getCena() {
		return cena; 
	}
	

	
	public boolean zmienAsortyment(String id,int zmiana) {
		if(!checkID(id)) return false;
		
		waga+=zmiana;
		if (waga<0) {
			waga-=zmiana;
			return false;
		}
		return true;
	}
	public boolean checkID(String id) {
		if(id.startsWith(getCode()))
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
