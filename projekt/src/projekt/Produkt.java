package projekt;

public interface Produkt {
	String getCode();
	int getCena();
	String getString();
	boolean zmienAsortyment(String id,int zmiana);
	boolean checkID(String id);
	boolean usunProdukt(String kod);
	boolean dodajProdukt(String sektor,Produkt produkt);
}
