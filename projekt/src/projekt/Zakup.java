package projekt;

import java.util.HashMap;
import java.util.Map;

public class Zakup implements Tranzakcja{
	private   Map<String,Integer> produkty;
	
	public Zakup() {
		produkty=new HashMap<String,Integer>();
	}
	
	public void setProdukty( Map<String,Integer> p) {

		for(Map.Entry<String, Integer> rekord : p.entrySet()) {
			produkty.put(rekord.getKey(), rekord.getValue());
		}
	}
	public void dokonajTranzakcji(Magazyn m) {//dodac generowanie faktury
		
		for(Map.Entry<String, Integer> rekord : produkty.entrySet()) {
			m.ObslugaTranzakcji(rekord.getKey(),rekord.getValue());
		}

	}
}
