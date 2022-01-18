package projekt;

import java.util.HashMap;
import java.util.Map;

public class Inwentaryzacja {
	private Map<String,Integer> items;
	
	public Inwentaryzacja() {
		items=new HashMap<String,Integer>();
	}
	
	public void zeskanuj(String kod,int ilosc) {
		if(items.containsKey(kod)) {
			edytuj(kod,ilosc);
		}
		else {
			items.put(kod, ilosc);
		}
	}
	
	public void edytuj(String kod,int ilosc) {
		for(Map.Entry<String, Integer> rekord : items.entrySet()) {
			if(rekord.getKey().equals(kod)) {
				rekord.setValue(rekord.getValue()+ilosc);
				if(rekord.getValue()<=0) {
					items.remove(rekord.getKey());
				}
				break;
			}
		}
	}
	
	public String wykonaj(Magazyn m) {
		return m.inwentaryzacja(items);
	}
	
	public String getString() {
		String odp=new String();
		for(Map.Entry<String, Integer> rekord : items.entrySet()) {
			odp+=rekord.getKey()+";"+rekord.getValue()+'\n';
		}
		return odp;
	}
	
}
