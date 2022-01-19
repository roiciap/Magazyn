package projekt;

import java.util.*;
public abstract class TworzenieTranzakcji {
	private   Map<String,Integer> produkty;
	abstract  Tranzakcja DodajTranzakcje();
	
	public TworzenieTranzakcji() {
		produkty=new HashMap<String,Integer>();
	}
	
	
	void stworz(Magazyn m) {
		Tranzakcja t=DodajTranzakcje();
		t.setProdukty(produkty);
		t.dokonajTranzakcji(m);
		produkty.clear();
	}
	
	void DodajProdukt(String kod,int ilosc) {
		
		if(produkty.containsKey(kod)) {
			
			Iterator<Map.Entry<String,Integer>> iterator=produkty.entrySet().iterator();
			while(iterator.hasNext()) {
				Map.Entry<String, Integer> rekord=iterator.next();
				if(rekord.getKey().equals(kod)) {
					rekord.setValue(rekord.getValue()+ilosc);
					if(rekord.getValue()<0) {
						rekord.setValue(-ilosc);
					}
				}
			}
		}
		else {
			if(ilosc<0) return;
			produkty.put(kod, ilosc);
		}
	}
	
}
