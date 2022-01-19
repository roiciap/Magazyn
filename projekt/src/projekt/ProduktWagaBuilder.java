package projekt;

public class ProduktWagaBuilder {
	private ProduktWaga produkt;
	
	public ProduktWagaBuilder() {
		this.reset();
	}
	
	private void reset() {
		this.produkt=new ProduktWaga();
	}
	
	public void setNazwa(String nazwa) {
		produkt.nazwa=nazwa;
	}
	
	public boolean setPrefix(String prefix) {
		if(prefix.length()!=2) return false;
		
		produkt.prefix=prefix;
		return true;
	}

	public void setWaga(int waga) {
		produkt.waga=waga;
	}
	public boolean setSKU(String SKU) {
		if(SKU.length()!=5) return false;
		
		produkt.SKU=SKU;
		return true;
	}
	

	public void setCena(int cena) {
		produkt.cena=cena;
	}
	
	public ProduktWaga getProdukt() {
		ProduktWaga wynik=produkt;
		this.reset();
		return wynik;
	}
	
}
