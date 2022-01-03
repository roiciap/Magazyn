package projekt;

public interface Produkt {
	String getCode();
	int getCena();
	String getString();
	boolean zmienAsortyment(Produkt p,int zmiana);
	boolean zmienAsortyment(String id,int zmiana);
	boolean checkID(String id);
	boolean usunProdukt(String kod);
}
