package projekt;

import java.util.Map;

public interface Tranzakcja {
	public void setProdukty( Map<String,Integer> produkty);
	public void dokonajTranzakcji(Magazyn m);
}
