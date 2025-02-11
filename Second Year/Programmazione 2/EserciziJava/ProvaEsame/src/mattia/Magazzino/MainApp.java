package mattia.Magazzino;

import java.util.Scanner;
public class MainApp {
	public static void main (String[]Args){
		Scanner tastiera = new Scanner(System.in);
		
		MenuMagazzino menu = new MenuMagazzino ();
		
		int uscitamenu1 = menu.getUscitaMenu1();
		int uscitamenu2 = menu.getUscitaMenu2();
		int numerosceltomenu1, numerosceltomenu2;
		
		Magazzino magazzino = new Magazzino(5);

		String nome;
		int prezzoacquisto,prezzovendita,quantita;
	}
}



















































