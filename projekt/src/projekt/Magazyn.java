package projekt;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Magazyn {
	private Sektor sektory;//private
	private List<Snapshot> pamiatka;
	public Magazyn() {
		pamiatka=new ArrayList<Snapshot>();
		sektory=new Sektor("magazyn");
		File plik=new File("magazyn.txt");
		if(!plik.exists()) {
			try {
				plik.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		load("magazyn.txt");
	}
	public Magazyn(String file) {
		sektory=new Sektor("magazyn");
		load(file);
	}
	
	public void setMagazyn(Sektor s) {
		sektory=s;
	}
	
	public Sektor getSektor() {
		return sektory;
	}
	
	public boolean usunProdukt(String s) {
		return(sektory.usunProdukt(s));
	}
	
	public Magazyn (Sektor s) {
		if(s.getCode().equals("magazyn")) {
			sektory=s;
		}
		else {
			sektory=new Sektor("magazyn");
			sektory.dodajProdukt("magazyn", s);
		}
	}
	
	public boolean DodajSektor(Sektor p) {
		return sektory.dodajProdukt(sektory.nazwa,p);
	}
	
	public boolean DodajProdukt(String s,Produkt p) {
		return sektory.dodajProdukt(s, p);
	}
	
	public String getString() {
		return sektory.getString();
	}
	
	public void save() {
		String data=sektory.getString();
		System.out.println(data);
		 try {
			 FileWriter plik = new FileWriter("magazyn.txt");
			 plik.write(data);
			 plik.close();
			 
		 }
		 catch(IOException e) {
		
			 e.printStackTrace();
		 }
	}
	public void zapisz() {
		pamiatka.add(0, new Snapshot(getString()));
	}
	
	public void wczytaj() {
		if(pamiatka.size()>0) {
			pamiatka.get(0).wczytaj(this);
			pamiatka.remove(0);
		}
		else {
			System.out.println("brak zapisanych stanow");
		}
	}
	
	public void load(String sciezkaPliku) {
		Sektor koniec=new Sektor("magazyn");
		int nawiasy=0;
		List<Sektor> tworzenie=new ArrayList<Sektor>();
		try{
		File plik = new File(sciezkaPliku);
		Scanner reader = new Scanner(plik);
		while(reader.hasNextLine()) {
			String data= reader.nextLine();
			if(data.contains("=")) {
				String sektorInfo=data.split("=")[0];
				String sektorName=sektorInfo.split(":")[1];
				nawiasy++;
				tworzenie.add(0,new Sektor(sektorName));
			}
			if(data.contains("]")) {
				if(nawiasy==1) {
					koniec.dodajProdukt("magazyn",tworzenie.get(0));
					tworzenie.remove(0);
				}
				if(nawiasy>1) {
					tworzenie.get(1).dodajProdukt(tworzenie.get(1).getCode(),tworzenie.get(0) );
					tworzenie.remove(0);
				}
				nawiasy--;
			}
			if(data.contains(";")) {
				String[] productInfo=data.split(";");
				if(productInfo[0].charAt(0)=='2') {//waga
					
					ProduktWagaBuilder br=new ProduktWagaBuilder();
					br.setPrefix(productInfo[0].substring(0, 2));
					br.setSKU(productInfo[0].substring(2, 7));
					br.setNazwa(productInfo[1]);
					br.setWaga(Integer.parseInt(productInfo[2]));
					br.setCena(Integer.parseInt(productInfo[3]));
					ProduktWaga p=br.getProdukt();
					tworzenie.get(0).dodajProdukt(tworzenie.get(0).getCode(), p);
				}
				else {//ilosc
					String odp=productInfo[0];
					ProduktIloscBuilder b=new ProduktIloscBuilder();
					String Kraj=odp.substring(0, 3);
					String Producent=odp.substring(3,7);
					String Produkt=odp.substring(7,12);
					String kont=odp.substring(12);
					b.setKrajID(Kraj);
					b.setProducentID(Producent);
					b.setProduktID(Produkt);
					b.setKontrolnyID(kont);
					odp=productInfo[1];
					b.setNazwa(odp);
					b.setIlosc(Integer.parseInt(productInfo[2]));
					b.setCena(Integer.parseInt(productInfo[3]));
					Produkt Ilosc=b.getProdukt();
					tworzenie.get(0).dodajProdukt(tworzenie.get(0).getCode(), Ilosc);
				}
			}
		}
		sektory=koniec;
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	

	public String wypiszSektory() {
		String ret=sektory.getString();
		String[] a=ret.split("=");
		String wynik=new String();
		for(int i=0;i<a.length;i++) {
			if(a[i].split(":").length>1)
				wynik+=a[i].split(":")[1]+"\n";
		}
		return wynik;
	}
	
	public boolean ObslugaTranzakcji(String kod,int v) {
		return sektory.zmienAsortyment(kod, v);
	}
	
	public String inwentaryzacja(Map<String,Integer> zeskanowane) {
		String[] items=sektory.getString().split("\n");
		String odp=new String();
		
		
		
		for(int i=0;i<items.length;i++) {
			if(items[i].contains(";")) {
				String[] linia=items[i].split(";");
				if(zeskanowane.containsKey(linia[0])) {
					int a=zeskanowane.get(linia[0])-Integer.parseInt(linia[2]);
					if(a>0) {
						odp+="stan faktyczny magazynu dla "+linia[0]+" jest wiekszy o "+String.valueOf(a)+"\n";
					}
					if(a<0) {
						odp+="stan faktyczny magazynu dla "+linia[0]+" jest mniejszy o "+String.valueOf(a)+"\n";
					}
				}
			}
		}
		
		return odp;
	}

	
}
