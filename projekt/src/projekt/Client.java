package projekt;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.io.*;

public class Client {
	List<Magazyn> pamiatka=new ArrayList<Magazyn>();
	uzytkownik user;
	Magazyn magazyn;
	
	public Client(uzytkownik u,Magazyn m) {
		user=u;
		magazyn=m;
	}
	
	public static void main(String[] args) throws IOException {
		boolean loggedIn=false;
		Scanner scan = new Scanner(System.in);
		Client c;
		while(!loggedIn) {
				System.out.println("Podaj login");
				String login=scan.next();
				System.out.println("Podaj haslo");
				String haslo=scan.next();
				
				File plik = new File("users.txt");
				Scanner reader = new Scanner(plik);
				while(reader.hasNextLine()) {
					String linia=reader.nextLine();
					if(linia.contains(";")) {
						String[] data=linia.split(";");
						if(data[0].equals(login) && data[1].equals(haslo)){
							if(data[2].equals("meneger")) {

								c=new Client(new menager(),new Magazyn());
								c.obsluga();
								loggedIn=true;
								break;
							}
							else {
								c=new Client(new Magazynier(),new Magazyn());
								c.obsluga();
								loggedIn=true;
								break;
							}
						}
					}
				}
			}

	}
	
	public void obsluga() throws IOException {
		Scanner scan = new Scanner(System.in);
		String odp;
		while(true) {
			System.out.println(user.getMenu()+"zapis\ncofnij");
			odp=scan.next();
			if(odp.equals("zapis")) {
				File tmpFile = File.createTempFile("tmpFile3",".txt");
				
					FileWriter tmpWriter = new FileWriter("tmpFile3.txt");
					tmpWriter.write(magazyn.getString());
					tmpWriter.close();
					Magazyn m=new Magazyn("tmpFile3.txt");
					pamiatka.add(0, m);
					tmpFile.delete();
				
			}
			else if(odp.equals("cofnij")) {
				if(pamiatka.size()>0) {
					Magazyn tmp=pamiatka.get(0);
					magazyn.setMagazyn(tmp.getSektor());
					pamiatka.remove(0);
				}
				else {
					System.out.println("Brak zapisow\n");
				}
			}
			else {
			user.perform(odp,magazyn);
			}
		}
	}
}

	
		
		
		
		