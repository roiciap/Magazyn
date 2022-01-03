package projekt;

import java.util.Map;
import java.util.*;

public class Sprzedaz implements Tranzakcja{
	private   Map<String,Integer> produkty;
	
	public Sprzedaz() {
		produkty=new HashMap<String,Integer>();
	}
	
	public void setProdukty( Map<String,Integer> p) {

		for(Map.Entry<String, Integer> rekord : p.entrySet()) {
			produkty.put(rekord.getKey(), rekord.getValue());
		}
	}
	public void dokonajTranzakcji(Magazyn m) {//dodac generowanie faktury
		
		for(Map.Entry<String, Integer> rekord : produkty.entrySet()) {
			if(!m.ObslugaTranzakcji(rekord.getKey(),-rekord.getValue()))//generuj error w razie niepowodzenia
				System.out.println("nie udalo sie dodac "+rekord.getKey()+" x"+rekord.getValue());
		}
	}
}
