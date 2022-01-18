package projekt;

public class ProduktIloscBuilder {
	private ProduktIlosc produkt;
	
	public  ProduktIloscBuilder(){
		this.reset();
	}
	
	private void reset() {
		this.produkt=new ProduktIlosc();
	}
	
	public boolean setProduktID(int id) {
		if(id>99999) return false;
		produkt.ProduktID=id;
		return true;
	}
	
	public boolean setKrajID(int id) {
		if(id>999) return false;
		produkt.KrajID=id;
		return true;
	}
	public boolean setKontrolnyID(int id) {
		if(id>9) return false;
		produkt.KontrolnyID=id;
		return true;
	}
	public boolean setProducentID(int id) {
		if(id>9999) return false;
		produkt.ProducentID=id;
		return true;
	}
	
	
	public void setCena(int cena) {
		produkt.cena=cena;
	}
	
	public void setIlosc(int ilosc) {
		produkt.ilosc=ilosc;
	}

	
	public void setNazwa(String nazwa) {
		produkt.nazwa=nazwa;
	}
	
	public ProduktIlosc getProdukt() {
		ProduktIlosc wynik=this.produkt;
		this.reset();
		return wynik;
	}
	
}
