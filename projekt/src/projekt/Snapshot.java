package projekt;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Snapshot {
	final String stanMagazynu;
	
	public Snapshot(String s) {
		stanMagazynu=s;
	}
	
	public void wczytaj(Magazyn m) {
		File tmpFile;
		try {
		File snap=new File("snap.txt");
		if(!snap.exists()) {
			snap.createNewFile();
		}
		FileWriter w = new FileWriter("snap.txt");
		w.write(stanMagazynu);
		w.close();
		m.load("snap.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
