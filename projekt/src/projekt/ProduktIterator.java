package projekt;

import java.util.List;

public class ProduktIterator implements WarhouseIterator{
	
	private List<Produkt> lista;
	private Produkt aktualnyProdukt;
	private int pozycja;
	
	public ProduktIterator(List<Produkt> l) {
		this.lista=l;
		poczatekListy();
	}
	
	
	
	
	public void poczatekListy() {
		this.pozycja=0;	
	}
	
	
	public Produkt getProdukt() {
		aktualnyProdukt=lista.get(pozycja);
		return aktualnyProdukt;
	}
	
	public Produkt getNext() {
		if(hasMore()) {
			pozycja++;
			aktualnyProdukt=lista.get(pozycja);
			return aktualnyProdukt;
		}
		return null;
	}
	
	public Produkt getPrev() {
		if(pozycja>0) {
			pozycja--;
			aktualnyProdukt=lista.get(pozycja);
			return aktualnyProdukt;
		}
		return null;
	}
	
	public boolean hasMore() {
		if(pozycja+1<lista.size())
			return true;
		
		return false;
	}

}
