package projekt;

import java.util.ArrayList;
import java.util.List;



public class Sektor implements Produkt{
	String nazwa;
	List<Produkt> ListaProduktow;
	
	public Sektor(String n) {
		ListaProduktow=new ArrayList<>();
		nazwa=n;
	}
	
	public Sektor(String n,List <Produkt> l) {
		ListaProduktow=l;
		nazwa=n;
	}
	
	
	public boolean dodajProdukt(String sektor,Produkt produkt) {
		
		if(checkID(produkt.getCode())) return false;
		
		
		if(sektor.equals(nazwa)) {
			ListaProduktow.add(produkt);
			return true;
		}
		if(checkID(sektor)) {
			ProduktIterator it=new ProduktIterator(ListaProduktow);
			if(it.getProdukt().dodajProdukt(sektor,produkt)) return true;
			while(it.hasMore()) {
				if(it.getNext().dodajProdukt(sektor,produkt)) return true;
			}
		}
		return false;
	}
	
	public boolean usunProdukt(String kod) {
		if(!checkID(kod)) return false;
			
		ProduktIterator it=new ProduktIterator(ListaProduktow);
		
		if(it.getProdukt().getCode().equals(kod)) {
			ListaProduktow.remove(it.getProdukt());
			return true;
		}

		
		while(it.hasMore()) {
			if(it.getNext().checkID(kod)) 
				if(it.getProdukt().getCode().equals(kod)) {
					ListaProduktow.remove(it.getProdukt());
					return true;
				}
		}
		
		
		if(it.getProdukt().checkID(kod)) 
			return(it.getProdukt().usunProdukt(kod));
		
		while(it.hasMore()) {
			if(it.getNext().checkID(kod)) 
				return(it.getProdukt().usunProdukt(kod));
		}
		
		
		
		
		return true;
		
	}
	
	

	public int getCena() {
		if(ListaProduktow.isEmpty()) return 0;
		
		ProduktIterator it=new ProduktIterator(ListaProduktow);
		int cena=0;
		cena+=it.getProdukt().getCena();
		while(it.hasMore()) {
			cena+=it.getNext().getCena();
		}
		
		System.out.print("cena Sektoru" + nazwa);
		return cena;
	}
	
	public String getCode() {
		return nazwa;
	}
	
	public String getString() {
		ProduktIterator it=new ProduktIterator(ListaProduktow);
		String lista=new String();	
		if(!nazwa.equals("magazyn")) {
		
		lista+="Sektor:"+getCode()+"=[\n";
		}
		if(ListaProduktow.isEmpty()) return "Sektor:"+getCode()+"=[]";
		
		lista+=it.getProdukt().getString()+"\n";
		while(it.hasMore()) {
			lista+=it.getNext().getString()+"\n";
		}
		if(!nazwa.equals("magazyn"))
				lista+="]\n";

		return lista;
	}
	
	
	
	public boolean zmienAsortyment(Produkt produkt,int ilosc) {
		if(ListaProduktow.isEmpty()) return false;
		
		if(checkID(produkt.getCode())) {
			ProduktIterator it=new ProduktIterator(ListaProduktow);
			if(it.getProdukt().zmienAsortyment(produkt,ilosc)) return true;
			while(it.hasMore()) {
				if(it.getNext().zmienAsortyment(produkt,ilosc)) return true;
			}
			return false;
			
		}
		return false;
	}
	
	public boolean zmienAsortyment(String id,int ilosc) {
		if(ListaProduktow.isEmpty()) return false;
			

		ProduktIterator it=new ProduktIterator(ListaProduktow);
		if(it.getProdukt().zmienAsortyment(id,ilosc)) return true;
		while(it.hasMore()) {
			if(it.getNext().zmienAsortyment(id,ilosc)) return true;
		}
		return false;
	}
	
	public boolean checkID(String id) {
		if(id.equals(nazwa))return true;
		
		if(ListaProduktow.isEmpty()) return false;
		ProduktIterator it=new ProduktIterator(ListaProduktow);
		if(it.getProdukt().checkID(id)) return true;
		while(it.hasMore()) {
			if(it.getNext().checkID(id)) return true;
		}
		return false;
	}
}
