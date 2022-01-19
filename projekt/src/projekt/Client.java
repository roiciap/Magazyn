package projekt;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.io.*;

public class Client {
	private uzytkownik user;
	private Magazyn magazyn;
	
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
				if(!plik.exists()) {
					FileWriter tmp = new FileWriter("users.txt");
					plik.createNewFile();
					
					tmp.write("admin;admin;menager\nuser;user;user");
					
					tmp.close();
					
				}
				Scanner reader = new Scanner(plik);
				while(reader.hasNextLine()) {
					String linia=reader.nextLine();
					if(linia.contains(";")) {
						String[] data=linia.split(";");
						if(data[0].equals(login) && data[1].equals(haslo)){
							if(data[2].equals("menager")) {

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

			user.perform(odp,magazyn);
		}
	}
}

	
		
		
		
		
